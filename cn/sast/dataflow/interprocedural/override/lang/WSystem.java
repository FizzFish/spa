/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.WSystem
 *  cn.sast.dataflow.interprocedural.override.lang.WSystem$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WSystem$register$2
 *  cn.sast.dataflow.interprocedural.override.lang.WSystem$register$identityHashCodeSignature$1
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlinx.collections.immutable.ExtensionsKt
 *  org.jetbrains.annotations.NotNull
 *  soot.ArrayType
 *  soot.G
 *  soot.IntType
 *  soot.NullType
 *  soot.PrimType
 *  soot.RefType
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WSystem;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlinx.collections.immutable.ExtensionsKt;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.G;
import soot.IntType;
import soot.NullType;
import soot.PrimType;
import soot.RefType;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r*\u00100\u000ej\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u000fH\u0016R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WSystem;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "arrayType", "Lsoot/ArrayType;", "kotlin.jvm.PlatformType", "getArrayType", "()Lsoot/ArrayType;", "Lsoot/ArrayType;", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WSystem
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final ArrayType arrayType = ArrayType.v((Type)((Type)G.v().soot_ByteType()), (int)1);

    public final ArrayType getArrayType() {
        return this.arrayType;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        String identityHashCodeSignature2 = UtilsKt.getSootSignature((KCallable)((KCallable)register.identityHashCodeSignature.1.INSTANCE));
        $this$register.evalCall(identityHashCodeSignature2, WSystem::register$lambda$1);
        $this$register.evalCall(UtilsKt.getSootSignature((KCallable)((KCallable)register.2.INSTANCE)), WSystem::register$lambda$4);
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_evalCall, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV instance = companionVArray[0];
        res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)instance.hashCode())).markOfReturnValueOfMethod($this_evalCall).pop());
        return true;
    }

    private static final Unit register$lambda$1(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues obj = $this$evalCall.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{obj};
        IOpCalculator unop = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        unop.resolve((arg_0, arg_1, arg_2) -> WSystem.register$lambda$1$lambda$0($this$evalCall, arg_0, arg_1, arg_2));
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        unop.putSummaryIfNotConcrete((Type)intType, (Object)"return");
        $this$evalCall.setReturn(unop.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$4$lambda$2(CalleeCBImpl.EvalCall $this_evalCall, boolean $append, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV src = companionVArray[0];
        CompanionV srcPos = companionVArray[1];
        CompanionV dest = companionVArray[2];
        CompanionV destPos = companionVArray[3];
        CompanionV length = companionVArray[4];
        IArrayHeapKV iArrayHeapKV = $this_evalCall.getOut().getArray(src.getValue());
        if (iArrayHeapKV == null) {
            return false;
        }
        IArrayHeapKV arrSrc = iArrayHeapKV;
        IArrayHeapKV iArrayHeapKV2 = $this_evalCall.getOut().getArray(dest.getValue());
        if (iArrayHeapKV2 == null) {
            return false;
        }
        IArrayHeapKV arrDest = iArrayHeapKV2;
        Integer n = FactValuesKt.getIntValue((IValue)((IValue)srcPos.getValue()), (boolean)true);
        if (n == null) {
            return false;
        }
        int intSrcPos = n;
        Integer n2 = FactValuesKt.getIntValue((IValue)((IValue)destPos.getValue()), (boolean)true);
        if (n2 == null) {
            return false;
        }
        int intDestPos = n2;
        Integer n3 = FactValuesKt.getIntValue((IValue)((IValue)length.getValue()), (boolean)true);
        if (n3 == null) {
            return false;
        }
        int intLength = n3;
        if (intLength >= 20) {
            return false;
        }
        IHeapKVData.Builder b = arrDest.builder();
        for (int i = 0; i < intLength; ++i) {
            IHeapValues s;
            if (arrSrc.get((IHeapValuesFactory)$this_evalCall.getHf(), (Object)(i + intSrcPos)) == null) {
                return false;
            }
            IHeapValues sf = $this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), s).dataElementCopyToSequenceElement(s).pop();
            b.set((IHeapValuesFactory)$this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), (Object)(i + intDestPos), sf, $append);
        }
        $this_evalCall.getOut().setValueData((HeapValuesEnv)$this_evalCall.getEnv(), dest.getValue(), (Object)BuiltInModelT.Array, b.build());
        return true;
    }

    private static final Unit register$lambda$4(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues srcP = $this$evalCall.arg(0);
        IHeapValues srcPosP = $this$evalCall.arg(1);
        IHeapValues destP = $this$evalCall.arg(2);
        IHeapValues destPosP = $this$evalCall.arg(3);
        IHeapValues lengthP = $this$evalCall.arg(4);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{srcP, srcPosP, destP, destPosP, lengthP};
        IOpCalculator op = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        boolean append = !srcP.isSingle() || !srcPosP.isSingle() || !destP.isSingle() || !destPosP.isSingle() || !lengthP.isSingle();
        IFact orig = $this$evalCall.getOut().build();
        op.resolve((arg_0, arg_1, arg_2) -> WSystem.register$lambda$4$lambda$2($this$evalCall, append, arg_0, arg_1, arg_2));
        if (!op.isFullySimplified()) {
            IFact.Builder builder2 = orig.builder();
            boolean multiDst = !destP.isSingle();
            for (CompanionV dst : destP) {
                ArrayHeapBuilder cb;
                IArrayHeapKV dstArr;
                IHeapKVData.Builder length;
                IArrayHeapKV iArrayHeapKV;
                ArrayType dstType;
                Type type = ((IValue)dst.getValue()).getType();
                if ((type instanceof ArrayType ? (ArrayType)type : null) == null) continue;
                dstType = dstType;
                if (multiDst) {
                    iArrayHeapKV = builder2.getArray(dst.getValue());
                    if (iArrayHeapKV == null) {
                        boolean bl = false;
                        AbstractHeapFactory abstractHeapFactory = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$evalCall.getEnv();
                        AbstractHeapFactory abstractHeapFactory2 = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)$this$evalCall.getEnv();
                        IntType intType = G.v().soot_IntType();
                        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
                        length = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newSummaryVal(heapValuesEnv2, (Type)intType, (Object)"arraySize")).popHV();
                        iArrayHeapKV = (IArrayHeapKV)ArraySpace.Companion.v($this$evalCall.getHf(), (HeapValuesEnv)$this$evalCall.getEnv(), ExtensionsKt.persistentHashMapOf(), $this$evalCall.getHf().empty(), dstType, (IHeapValues)length);
                    }
                } else {
                    AbstractHeapFactory abstractHeapFactory = $this$evalCall.getHf();
                    HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$evalCall.getEnv();
                    AbstractHeapFactory abstractHeapFactory3 = $this$evalCall.getHf();
                    HeapValuesEnv heapValuesEnv3 = (HeapValuesEnv)$this$evalCall.getEnv();
                    IntType intType = G.v().soot_IntType();
                    Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
                    IHeapValues length2 = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory3.newSummaryVal(heapValuesEnv3, (Type)intType, (Object)"arraySize")).popHV();
                    iArrayHeapKV = (IArrayHeapKV)ArraySpace.Companion.v($this$evalCall.getHf(), (HeapValuesEnv)$this$evalCall.getEnv(), ExtensionsKt.persistentHashMapOf(), $this$evalCall.getHf().empty(), dstType, length2);
                }
                if (((length = (dstArr = iArrayHeapKV).builder()) instanceof ArrayHeapBuilder ? (ArrayHeapBuilder)length : null) == null) continue;
                cb = cb;
                cb.clearAllIndex();
                for (CompanionV src : srcP) {
                    IArrayHeapKV arrSrc = builder2.getArray(src.getValue());
                    if (arrSrc == null) {
                        Type baseType = ((IValue)src.getValue()).getType();
                        if (!(baseType instanceof PrimType) && !(baseType instanceof RefType) && !(baseType instanceof NullType)) continue;
                        AbstractHeapFactory abstractHeapFactory = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$evalCall.getEnv();
                        AbstractHeapFactory abstractHeapFactory4 = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv4 = (HeapValuesEnv)$this$evalCall.getEnv();
                        ArrayType arrayType = ((IValue)src.getValue()).getType().makeArrayType();
                        Intrinsics.checkNotNullExpressionValue((Object)arrayType, (String)"makeArrayType(...)");
                        IHeapValues summary = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory4.newSummaryVal(heapValuesEnv4, (Type)arrayType, (Object)"arraySize")).popHV();
                        AbstractHeapFactory abstractHeapFactory5 = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv5 = (HeapValuesEnv)$this$evalCall.getEnv();
                        AbstractHeapFactory abstractHeapFactory6 = $this$evalCall.getHf();
                        HeapValuesEnv heapValuesEnv6 = (HeapValuesEnv)$this$evalCall.getEnv();
                        IntType intType = G.v().soot_IntType();
                        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
                        IHeapValues length3 = abstractHeapFactory5.push(heapValuesEnv5, abstractHeapFactory6.newSummaryVal(heapValuesEnv6, (Type)intType, (Object)"summary")).popHV();
                        arrSrc = (IArrayHeapKV)ArraySpace.Companion.v($this$evalCall.getHf(), (HeapValuesEnv)$this$evalCall.getEnv(), ExtensionsKt.persistentHashMapOf(), summary, $this$evalCall.getHf().getVg().getOBJ_ARRAY_TYPE(), length3);
                        builder2.setValueData((HeapValuesEnv)$this$evalCall.getEnv(), src.getValue(), (Object)BuiltInModelT.Array, (IData)arrSrc);
                    }
                    cb.set((IHeapValuesFactory)$this$evalCall.getHf(), (HeapValuesEnv)$this$evalCall.getEnv(), null, arrSrc.getElement($this$evalCall.getHf()), true);
                }
                builder2.setValueData((HeapValuesEnv)$this$evalCall.getEnv(), dst.getValue(), (Object)BuiltInModelT.Array, cb.build());
            }
            $this$evalCall.setOut(builder2);
        }
        return Unit.INSTANCE;
    }
}

