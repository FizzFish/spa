/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$PostCall
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.override.lang.WString
 *  cn.sast.dataflow.interprocedural.override.lang.WString$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WString$register$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringKt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  soot.ArrayType
 *  soot.ByteType
 *  soot.G
 *  soot.IntType
 *  soot.Local
 *  soot.RefType
 *  soot.SootField
 *  soot.Type
 *  soot.Value
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 *  soot.jimple.Jimple
 *  soot.jimple.NewArrayExpr
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WString;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import cn.sast.dataflow.util.SootUtilsKt;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.ByteType;
import soot.G;
import soot.IntType;
import soot.Local;
import soot.RefType;
import soot.SootField;
import soot.Type;
import soot.Value;
import soot.jimple.AnyNewExpr;
import soot.jimple.Constant;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.NewArrayExpr;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010*\u001a\u00020+*\u00100,j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`-H\u0016R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\n \b*\u0004\u0018\u00010\r0\r\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u00120\u0012\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001b\u0010\u001e\u001a\n \b*\u0004\u0018\u00010\u001f0\u001f\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\n \b*\u0004\u0018\u00010$0$\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\n \b*\u0004\u0018\u00010$0$\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010&\u00a8\u0006/"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WString;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "classType", "Lsoot/RefType;", "kotlin.jvm.PlatformType", "getClassType", "()Lsoot/RefType;", "Lsoot/RefType;", "byteType", "Lsoot/ByteType;", "getByteType", "()Lsoot/ByteType;", "Lsoot/ByteType;", "arrayType", "Lsoot/ArrayType;", "getArrayType", "()Lsoot/ArrayType;", "Lsoot/ArrayType;", "valueField", "Lsoot/SootField;", "getValueField", "()Lsoot/SootField;", "coderField", "getCoderField", "hashField", "getHashField", "sizeLocal", "Lsoot/Local;", "getSizeLocal", "()Lsoot/Local;", "Lsoot/Local;", "newValueExpr", "Lsoot/jimple/NewArrayExpr;", "getNewValueExpr", "()Lsoot/jimple/NewArrayExpr;", "Lsoot/jimple/NewArrayExpr;", "newStringExpr", "getNewStringExpr", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WString
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final RefType classType = RefType.v((String)"java.lang.String");
    private final ByteType byteType = G.v().soot_ByteType();
    private final ArrayType arrayType;
    @NotNull
    private final SootField valueField;
    @NotNull
    private final SootField coderField;
    @NotNull
    private final SootField hashField;
    private final Local sizeLocal;
    private final NewArrayExpr newValueExpr;
    private final NewArrayExpr newStringExpr;
    private static final byte LATIN1_BYTE;
    private static final byte UTF16_BYTE;
    @NotNull
    private static final IntConstant LATIN1;
    @NotNull
    private static final IntConstant UTF16;

    public WString() {
        ArrayType arrayType = this.arrayType = ArrayType.v((Type)((Type)this.byteType), (int)1);
        Intrinsics.checkNotNullExpressionValue((Object)arrayType, (String)"arrayType");
        this.valueField = SootUtilsKt.getOrMakeField((String)"java.lang.String", (String)"value", (Type)((Type)arrayType));
        ByteType byteType = this.byteType;
        Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"byteType");
        this.coderField = SootUtilsKt.getOrMakeField((String)"java.lang.String", (String)"coder", (Type)((Type)byteType));
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        this.hashField = SootUtilsKt.getOrMakeField((String)"java.lang.String", (String)"hash", (Type)((Type)intType));
        this.sizeLocal = Jimple.v().newLocal("size", (Type)G.v().soot_IntType());
        this.newValueExpr = Jimple.v().newNewArrayExpr((Type)this.arrayType, (Value)this.sizeLocal);
        this.newStringExpr = Jimple.v().newNewArrayExpr((Type)this.arrayType, (Value)this.sizeLocal);
    }

    public final RefType getClassType() {
        return this.classType;
    }

    public final ByteType getByteType() {
        return this.byteType;
    }

    public final ArrayType getArrayType() {
        return this.arrayType;
    }

    @NotNull
    public final SootField getValueField() {
        return this.valueField;
    }

    @NotNull
    public final SootField getCoderField() {
        return this.coderField;
    }

    @NotNull
    public final SootField getHashField() {
        return this.hashField;
    }

    public final Local getSizeLocal() {
        return this.sizeLocal;
    }

    public final NewArrayExpr getNewValueExpr() {
        return this.newValueExpr;
    }

    public final NewArrayExpr getNewStringExpr() {
        return this.newStringExpr;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        $this$register.evalCall(UtilsKt.getSootSignature((KCallable)((KCallable)register.1.INSTANCE)), WString::register$lambda$1);
        ArrayType arrayType = this.arrayType;
        Intrinsics.checkNotNullExpressionValue((Object)arrayType, (String)"arrayType");
        $this$register.postCallAtCaller("<java.lang.String: byte[] getBytes()>", WString.register$getValueElement((WString)this, (ArrayType)arrayType));
        ArrayType arrayType2 = this.arrayType;
        Intrinsics.checkNotNullExpressionValue((Object)arrayType2, (String)"arrayType");
        $this$register.postCallAtCaller("<java.lang.String: byte[] getBytes(java.lang.String)>", WString.register$getValueElement((WString)this, (ArrayType)arrayType2));
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.lang.String: boolean equals(java.lang.Object)>", (boolean)false));
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.lang.String: char charAt(int)>", (boolean)false));
        $this$register.evalCall("<java.lang.String: boolean isLatin1()>", WString::register$lambda$4);
        $this$register.evalCall("<java.lang.String: byte coder()>", WString::register$lambda$5);
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_ret, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV str = companionVArray[0];
        Object object = str.getValue();
        Object object2 = object instanceof ConstVal ? (ConstVal)object : null;
        if (object2 == null || (object2 = FactValuesKt.getStringValue((IValue)((IValue)object2), (boolean)true)) == null) {
            return false;
        }
        Object string = object2;
        AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
        IntConstant intConstant = IntConstant.v((int)((String)string).hashCode());
        Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
        Constant constant = (Constant)intConstant;
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        IValue r = (IValue)abstractHeapFactory.newConstVal(constant, (Type)intType);
        res.add($this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), (Object)r).markOfReturnValueOfMethod($this_ret).pop());
        return true;
    }

    private static final Unit register$lambda$1(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IHeapValues th1sOp = $this$ret.arg(-1);
        IOpCalculator c = WStringKt.getStringFromObject((ICallCBImpl)((ICallCBImpl)$this$ret), (IHeapValues)th1sOp);
        c.putSummaryIfNotConcrete((Type)$this$ret.getHf().getVg().getSTRING_TYPE(), (Object)"return");
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{c.getRes().build()};
        IOpCalculator strOp = $this$ret.getHf().resolveOp((HeapValuesEnv)$this$ret.getEnv(), iHeapValuesArray);
        strOp.resolve((arg_0, arg_1, arg_2) -> WString.register$lambda$1$lambda$0($this$ret, arg_0, arg_1, arg_2));
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$ret.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$ret.getEnv()), (Object)$this$ret.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)strOp.getRes().build(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }

    private static final boolean register$getValueElement$lambda$3$lambda$2(CallerSiteCBImpl.PostCall $this_ret, WString this$0, ArrayType $returnType, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        IValue newValue;
        CompanionV th1s;
        block2: {
            Object object;
            block4: {
                block3: {
                    Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
                    Intrinsics.checkNotNullParameter((Object)res, (String)"res");
                    Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
                    th1s = companionVArray[0];
                    AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
                    AnyNewExprEnv anyNewExprEnv = $this_ret.getNewEnv();
                    NewArrayExpr newArrayExpr = this$0.newValueExpr;
                    Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr, (String)"newValueExpr");
                    newValue = (IValue)abstractHeapFactory.anyNewVal(anyNewExprEnv, (AnyNewExpr)newArrayExpr);
                    res.add($this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), (Object)newValue).dataSequenceToSeq(th1s).pop());
                    if (!(th1s.getValue() instanceof ConstVal)) break block2;
                    object = FactValuesKt.getStringValue$default((IValue)((IValue)th1s.getValue()), (boolean)false, (int)1, null);
                    if (object == null) break block3;
                    String string = object;
                    byte[] byArray = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
                    object = byArray;
                    if (byArray != null) break block4;
                }
                return false;
            }
            Object str = object;
            IHeapValues len = $this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), $this_ret.getHf().toConstVal((Object)((Object)str).length)).popHV();
            $this_ret.getOut().setValueData((HeapValuesEnv)$this_ret.getEnv(), (Object)newValue, (Object)BuiltInModelT.Array, (IData)ArraySpace.Companion.v($this_ret.getHf(), (HeapValuesEnv)$this_ret.getEnv(), th1s, (Number[])ArraysKt.toTypedArray((byte[])str), $returnType, len));
            return true;
        }
        IData strArray = $this_ret.getOut().getValueData(th1s.getValue(), (Object)BuiltInModelT.Array);
        $this_ret.getOut().setValueData((HeapValuesEnv)$this_ret.getEnv(), (Object)newValue, (Object)BuiltInModelT.Array, strArray);
        return true;
    }

    private static final Unit register$getValueElement$lambda$3(WString this$0, ArrayType $returnType, CallerSiteCBImpl.PostCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IHeapValues th1sOp = $this$ret.getThis();
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{th1sOp};
        IOpCalculator strObjectOp = $this$ret.getHf().resolveOp((HeapValuesEnv)$this$ret.getEnv(), iHeapValuesArray);
        strObjectOp.resolve((arg_0, arg_1, arg_2) -> WString.register$getValueElement$lambda$3$lambda$2($this$ret, this$0, $returnType, arg_0, arg_1, arg_2));
        $this$ret.setReturn($this$ret.getReturn().plus(strObjectOp.getRes().build()));
        return Unit.INSTANCE;
    }

    private static final Function1<CallerSiteCBImpl.PostCall, Unit> register$getValueElement(WString this$0, ArrayType returnType) {
        return arg_0 -> WString.register$getValueElement$lambda$3(this$0, returnType, arg_0);
    }

    private static final Unit register$lambda$4(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IValue r = (IValue)$this$ret.getHf().toConstVal((Object)true);
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$ret.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$ret.getEnv()), (Object)$this$ret.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)$this$ret.getHf().push((HeapValuesEnv)$this$ret.getEnv(), (Object)r).markOfReturnValueOfMethod($this$ret).popHV(), (boolean)false, (int)8, null);
        $this$ret.getOut().build();
        return Unit.INSTANCE;
    }

    private static final Unit register$lambda$5(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IFact.Builder builder2 = $this$ret.getOut();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$ret.getEnv();
        String string = $this$ret.getHf().getVg().getRETURN_LOCAL();
        AbstractHeapFactory abstractHeapFactory = $this$ret.getHf();
        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)$this$ret.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this$ret.getHf();
        Constant constant = (Constant)LATIN1;
        ByteType byteType = G.v().soot_ByteType();
        Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)builder2, (HeapValuesEnv)heapValuesEnv, (Object)string, (IHeapValues)abstractHeapFactory.push(heapValuesEnv2, abstractHeapFactory2.newConstVal(constant, (Type)byteType)).markOfReturnValueOfMethod($this$ret).popHV(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ byte access$getLATIN1_BYTE$cp() {
        return LATIN1_BYTE;
    }

    public static final /* synthetic */ byte access$getUTF16_BYTE$cp() {
        return UTF16_BYTE;
    }

    public static final /* synthetic */ IntConstant access$getLATIN1$cp() {
        return LATIN1;
    }

    public static final /* synthetic */ IntConstant access$getUTF16$cp() {
        return UTF16;
    }

    static {
        UTF16_BYTE = 1;
        IntConstant intConstant = IntConstant.v((int)0);
        Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
        LATIN1 = intConstant;
        IntConstant intConstant2 = IntConstant.v((int)1);
        Intrinsics.checkNotNullExpressionValue((Object)intConstant2, (String)"v(...)");
        UTF16 = intConstant2;
    }
}

