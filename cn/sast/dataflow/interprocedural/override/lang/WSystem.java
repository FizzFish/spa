package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.*;
import cn.sast.dataflow.interprocedural.check.*;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import org.jetbrains.annotations.NotNull;
import soot.*;

import java.util.Objects;

public final class WSystem implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();
    private final ArrayType arrayType = ArrayType.v(G.v().soot_ByteType(), 1);

    public ArrayType getArrayType() {
        return arrayType;
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        Objects.requireNonNull(analysis, "<this>");
        String identityHashCodeSignature = UtilsKt.getSootSignature(Companion.getIdentityHashCodeSignature());
        analysis.evalCall(identityHashCodeSignature, WSystem::handleIdentityHashCode);
        analysis.evalCall(UtilsKt.getSootSignature(Companion.getArrayCopySignature()), WSystem::handleArrayCopy);
    }

    private static boolean handleIdentityHashCodeLogic(CalleeCBImpl.EvalCall evalCall, IOpCalculator resolver, 
            IHeapValues.Builder result, CompanionV[] companions) {
        Objects.requireNonNull(resolver, "$this$resolve");
        Objects.requireNonNull(result, "res");
        Objects.requireNonNull(companions, "<destruct>");
        CompanionV instance = companions[0];
        result.add(evalCall.getHf().push(evalCall.getEnv(), 
                evalCall.getHf().toConstVal(instance.hashCode()))
                .markOfReturnValueOfMethod(evalCall).pop());
        return true;
    }

    private static Unit handleIdentityHashCode(CalleeCBImpl.EvalCall evalCall) {
        Objects.requireNonNull(evalCall, "$this$evalCall");
        IHeapValues obj = evalCall.arg(0);
        IHeapValues[] values = {obj};
        IOpCalculator unop = evalCall.getHf().resolveOp(evalCall.getEnv(), values);
        unop.resolve((arg0, arg1, arg2) -> handleIdentityHashCodeLogic(evalCall, arg0, arg1, arg2));
        unop.putSummaryIfNotConcrete(G.v().soot_IntType(), "return");
        evalCall.setReturn(unop.getRes().build());
        return Unit.INSTANCE;
    }

    private static boolean handleArrayCopyLogic(CalleeCBImpl.EvalCall evalCall, boolean append, 
            IOpCalculator resolver, IHeapValues.Builder result, CompanionV[] companions) {
        Objects.requireNonNull(resolver, "$this$resolve");
        Objects.requireNonNull(result, "res");
        Objects.requireNonNull(companions, "<destruct>");
        
        CompanionV src = companions[0];
        CompanionV srcPos = companions[1];
        CompanionV dest = companions[2];
        CompanionV destPos = companions[3];
        CompanionV length = companions[4];

        IArrayHeapKV srcArr = evalCall.getOut().getArray(src.getValue());
        if (srcArr == null) return false;
        
        IArrayHeapKV destArr = evalCall.getOut().getArray(dest.getValue());
        if (destArr == null) return false;

        Integer srcPosInt = FactValuesKt.getIntValue(srcPos.getValue(), true);
        Integer destPosInt = FactValuesKt.getIntValue(destPos.getValue(), true);
        Integer lengthInt = FactValuesKt.getIntValue(length.getValue(), true);
        if (srcPosInt == null || destPosInt == null || lengthInt == null || lengthInt >= 20) {
            return false;
        }

        IHeapKVData.Builder builder = destArr.builder();
        for (int i = 0; i < lengthInt; i++) {
            IHeapValues sourceElement = srcArr.get(evalCall.getHf(), i + srcPosInt);
            if (sourceElement == null) return false;
            
            IHeapValues copiedElement = evalCall.getHf().push(evalCall.getEnv(), sourceElement)
                    .dataElementCopyToSequenceElement(sourceElement).pop();
            builder.set(evalCall.getHf(), evalCall.getEnv(), i + destPosInt, copiedElement, append);
        }
        evalCall.getOut().setValueData(evalCall.getEnv(), dest.getValue(), BuiltInModelT.Array, builder.build());
        return true;
    }

    private static Unit handleArrayCopy(CalleeCBImpl.EvalCall evalCall) {
        Objects.requireNonNull(evalCall, "$this$evalCall");
        IHeapValues[] args = {
            evalCall.arg(0), evalCall.arg(1), evalCall.arg(2), 
            evalCall.arg(3), evalCall.arg(4)
        };
        
        IOpCalculator op = evalCall.getHf().resolveOp(evalCall.getEnv(), args);
        boolean append = !args[0].isSingle() || !args[1].isSingle() || 
                        !args[2].isSingle() || !args[3].isSingle() || !args[4].isSingle();
        
        IFact orig = evalCall.getOut().build();
        op.resolve((arg0, arg1, arg2) -> handleArrayCopyLogic(evalCall, append, arg0, arg1, arg2));
        
        if (!op.isFullySimplified()) {
            IFact.Builder builder = orig.builder();
            boolean multiDst = !args[2].isSingle();
            
            for (CompanionV dst : args[2]) {
                Type type = ((IValue)dst.getValue()).getType();
                if (!(type instanceof ArrayType)) continue;
                
                ArrayType dstType = (ArrayType)type;
                IArrayHeapKV dstArr = multiDst ? builder.getArray(dst.getValue()) : null;
                
                if (dstArr == null) {
                    IHeapValues length = evalCall.getHf().push(evalCall.getEnv(),
                            evalCall.getHf().newSummaryVal(evalCall.getEnv(), G.v().soot_IntType(), "arraySize"))
                            .popHV();
                    dstArr = ArraySpace.create(evalCall.getHf(), evalCall.getEnv(), 
                            ExtensionsKt.persistentHashMapOf(), evalCall.getHf().empty(), dstType, length);
                }
                
                IHeapKVData.Builder arrBuilder = dstArr.builder();
                if (!(arrBuilder instanceof ArrayHeapBuilder)) continue;
                
                ArrayHeapBuilder arrayBuilder = (ArrayHeapBuilder)arrBuilder;
                arrayBuilder.clearAllIndex();
                
                for (CompanionV src : args[0]) {
                    IArrayHeapKV srcArr = builder.getArray(src.getValue());
                    if (srcArr == null) {
                        Type baseType = ((IValue)src.getValue()).getType();
                        if (!(baseType instanceof PrimType) && !(baseType instanceof RefType) && !(baseType instanceof NullType)) {
                            continue;
                        }
                        
                        ArrayType srcArrayType = baseType.makeArrayType();
                        IHeapValues summary = evalCall.getHf().push(evalCall.getEnv(),
                                evalCall.getHf().newSummaryVal(evalCall.getEnv(), srcArrayType, "arraySize"))
                                .popHV();
                        IHeapValues len = evalCall.getHf().push(evalCall.getEnv(),
                                evalCall.getHf().newSummaryVal(evalCall.getEnv(), G.v().soot_IntType(), "summary"))
                                .popHV();
                        srcArr = ArraySpace.create(evalCall.getHf(), evalCall.getEnv(), 
                                ExtensionsKt.persistentHashMapOf(), summary, evalCall.getHf().getVg().getOBJ_ARRAY_TYPE(), len);
                        builder.setValueData(evalCall.getEnv(), src.getValue(), BuiltInModelT.Array, srcArr);
                    }
                    arrayBuilder.set(evalCall.getHf(), evalCall.getEnv(), null, srcArr.getElement(evalCall.getHf()), true);
                }
                builder.setValueData(evalCall.getEnv(), dst.getValue(), BuiltInModelT.Array, arrayBuilder.build());
            }
            evalCall.setOut(builder);
        }
        return Unit.INSTANCE;
    }

    public static final class Companion {
        private Companion() {}
        
        public KCallable<?> getIdentityHashCodeSignature() {
            // Implementation would return the appropriate KCallable
            return null;
        }
        
        public KCallable<?> getArrayCopySignature() {
            // Implementation would return the appropriate KCallable 
            return null;
        }
    }
}