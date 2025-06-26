/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.override.lang.WString
 *  cn.sast.dataflow.interprocedural.override.lang.WStringCoding
 *  cn.sast.dataflow.interprocedural.override.lang.WStringCoding$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WStringKt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  soot.ByteType
 *  soot.G
 *  soot.Local
 *  soot.RefType
 *  soot.SootField
 *  soot.Type
 *  soot.Value
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.Constant
 *  soot.jimple.Jimple
 *  soot.jimple.NewArrayExpr
 *  soot.jimple.NewExpr
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WString;
import cn.sast.dataflow.interprocedural.override.lang.WStringCoding;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import cn.sast.dataflow.util.SootUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import soot.ByteType;
import soot.G;
import soot.Local;
import soot.RefType;
import soot.SootField;
import soot.Type;
import soot.Value;
import soot.jimple.AnyNewExpr;
import soot.jimple.Constant;
import soot.jimple.Jimple;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010'\u001a\u00020(*\u00100)j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`*H\u0016R\u001b\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\n \n*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00180\u0018\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\n \n*\u0004\u0018\u00010\u001d0\u001d\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$\u00a8\u0006,"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WStringCoding;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;)V", "sizeLocal", "Lsoot/Local;", "kotlin.jvm.PlatformType", "getSizeLocal", "()Lsoot/Local;", "Lsoot/Local;", "newValueExpr", "Lsoot/jimple/NewArrayExpr;", "getNewValueExpr", "()Lsoot/jimple/NewArrayExpr;", "Lsoot/jimple/NewArrayExpr;", "clzStringCodingResult", "", "getClzStringCodingResult", "()Ljava/lang/String;", "StringCodingResultType", "Lsoot/RefType;", "getStringCodingResultType", "()Lsoot/RefType;", "Lsoot/RefType;", "newExprStringCodingResult", "Lsoot/jimple/NewExpr;", "getNewExprStringCodingResult", "()Lsoot/jimple/NewExpr;", "Lsoot/jimple/NewExpr;", "stringCodingResultValueField", "Lsoot/SootField;", "getStringCodingResultValueField", "()Lsoot/SootField;", "stringCodingResultCoderField", "getStringCodingResultCoderField", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWStringCoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WStringCoding.kt\ncn/sast/dataflow/interprocedural/override/lang/WStringCoding\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,112:1\n44#2:113\n44#2:114\n*S KotlinDebug\n*F\n+ 1 WStringCoding.kt\ncn/sast/dataflow/interprocedural/override/lang/WStringCoding\n*L\n93#1:113\n100#1:114\n*E\n"})
public final class WStringCoding
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final Local sizeLocal;
    private final NewArrayExpr newValueExpr;
    @NotNull
    private final String clzStringCodingResult;
    private final RefType StringCodingResultType;
    private final NewExpr newExprStringCodingResult;
    @NotNull
    private final SootField stringCodingResultValueField;
    @NotNull
    private final SootField stringCodingResultCoderField;

    public WStringCoding(@NotNull IVGlobal vg) {
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        this.sizeLocal = Jimple.v().newLocal("size", (Type)G.v().soot_IntType());
        this.newValueExpr = Jimple.v().newNewArrayExpr((Type)vg.getBYTE_ARRAY_TYPE(), (Value)this.sizeLocal);
        this.clzStringCodingResult = "java.lang.StringCoding$Result";
        this.StringCodingResultType = RefType.v((String)this.clzStringCodingResult);
        this.newExprStringCodingResult = Jimple.v().newNewExpr(this.StringCodingResultType);
        this.stringCodingResultValueField = SootUtilsKt.getOrMakeField((String)this.clzStringCodingResult, (String)"value", (Type)((Type)vg.getBYTE_ARRAY_TYPE()));
        ByteType byteType = G.v().soot_ByteType();
        Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
        this.stringCodingResultCoderField = SootUtilsKt.getOrMakeField((String)this.clzStringCodingResult, (String)"coder", (Type)((Type)byteType));
    }

    public final Local getSizeLocal() {
        return this.sizeLocal;
    }

    public final NewArrayExpr getNewValueExpr() {
        return this.newValueExpr;
    }

    @NotNull
    public final String getClzStringCodingResult() {
        return this.clzStringCodingResult;
    }

    public final RefType getStringCodingResultType() {
        return this.StringCodingResultType;
    }

    public final NewExpr getNewExprStringCodingResult() {
        return this.newExprStringCodingResult;
    }

    @NotNull
    public final SootField getStringCodingResultValueField() {
        return this.stringCodingResultValueField;
    }

    @NotNull
    public final SootField getStringCodingResultCoderField() {
        return this.stringCodingResultCoderField;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        $this$register.evalCall("<java.lang.StringCoding: byte[] encode(byte,byte[])>", arg_0 -> WStringCoding.register$lambda$1(this, arg_0));
        $this$register.evalCall("<java.lang.StringCoding: java.lang.StringCoding$Result decode(byte[],int,int)>", arg_0 -> WStringCoding.register$lambda$3(this, arg_0));
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_evalCall, WStringCoding this$0, IOpCalculator $this$encode, IHeapValues.Builder ret, CompanionV[] companionVArray) {
        Object object;
        byte coderInt;
        CompanionV companionV;
        block6: {
            block5: {
                Intrinsics.checkNotNullParameter((Object)$this$encode, (String)"$this$encode");
                Intrinsics.checkNotNullParameter((Object)ret, (String)"ret");
                Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
                CompanionV coder = companionVArray[0];
                companionV = companionVArray[1];
                Byte by = FactValuesKt.getByteValue((IValue)((IValue)coder.getValue()), (boolean)true);
                if (by == null) {
                    return false;
                }
                coderInt = by;
                byte[] byArray = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_evalCall), (IValue)((IValue)companionV.getValue()));
                if (byArray == null) {
                    return false;
                }
                byte[] byteArray = byArray;
                IData iData = $this_evalCall.getOut().getValueData(companionV.getValue(), (Object)BuiltInModelT.Array);
                IArrayHeapKV arrayData = iData instanceof IArrayHeapKV ? (IArrayHeapKV)iData : null;
                object = arrayData;
                if (object == null) break block5;
                byte[] byArray2 = object.getByteArray((IHeapValuesFactory)$this_evalCall.getHf());
                object = byArray2;
                if (byArray2 != null) break block6;
            }
            return false;
        }
        Object array = object;
        String str = coderInt == WString.Companion.getLATIN1_BYTE() ? new String((byte[])array, Charsets.UTF_8) : new String((byte[])array, Charsets.UTF_16);
        byte[] byArray = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
        byte[] returnArr = byArray;
        AbstractHeapFactory abstractHeapFactory = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCall.getHf();
        AnyNewExprEnv anyNewExprEnv = $this_evalCall.getNewEnv();
        NewArrayExpr newArrayExpr = this$0.newValueExpr;
        Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr, (String)"newValueExpr");
        JOperatorV jOperatorV = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)newArrayExpr));
        NewArrayExpr newArrayExpr2 = this$0.newValueExpr;
        Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr2, (String)"newValueExpr");
        CompanionV newValue = jOperatorV.markOfNewExpr((AnyNewExpr)newArrayExpr2).pop();
        ret.add(newValue);
        IHeapValues arraySize = $this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)returnArr.length)).markArraySizeOf(companionV).popHV();
        ArraySpace newArray = ArraySpace.Companion.v($this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), companionV, (Number[])ArraysKt.toTypedArray((byte[])returnArr), $this_evalCall.getHf().getVg().getBYTE_ARRAY_TYPE(), arraySize);
        $this_evalCall.getOut().setValueData((HeapValuesEnv)$this_evalCall.getEnv(), newValue.getValue(), (Object)BuiltInModelT.Array, (IData)newArray);
        return true;
    }

    private static final Unit register$lambda$1(WStringCoding this$0, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues coderP = $this$evalCall.arg(0);
        IHeapValues valP = $this$evalCall.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{coderP, valP};
        IOpCalculator encodeOp = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        encodeOp.resolve((arg_0, arg_1, arg_2) -> WStringCoding.register$lambda$1$lambda$0($this$evalCall, this$0, arg_0, arg_1, arg_2));
        encodeOp.putSummaryIfNotConcrete((Type)$this$evalCall.getHf().getVg().getBYTE_ARRAY_TYPE(), (Object)"return");
        $this$evalCall.setReturn(encodeOp.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$3$lambda$2(CalleeCBImpl.EvalCall $this_evalCall, WStringCoding this$0, IOpCalculator $this$encode, IHeapValues.Builder res, CompanionV[] companionVArray) {
        byte[] byArray;
        Intrinsics.checkNotNullParameter((Object)$this$encode, (String)"$this$encode");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV companionV = companionVArray[0];
        CompanionV off = companionVArray[1];
        CompanionV len = companionVArray[2];
        Integer n = FactValuesKt.getIntValue((IValue)((IValue)off.getValue()), (boolean)true);
        if (n == null) {
            return false;
        }
        int offInt = n;
        Integer n2 = FactValuesKt.getIntValue((IValue)((IValue)len.getValue()), (boolean)true);
        if (n2 == null) {
            return false;
        }
        int lenInt = n2;
        byte[] byArray2 = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_evalCall), (IValue)((IValue)companionV.getValue()));
        if (byArray2 == null) {
            return false;
        }
        byte[] byteArray = byArray2;
        try {
            byte[] byArray3 = new String(byteArray, offInt, lenInt, Charsets.UTF_8).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)byArray3, (String)"getBytes(...)");
            byArray = byArray3;
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        byte[] newValueArray = byArray;
        AbstractHeapFactory abstractHeapFactory = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCall.getHf();
        AnyNewExprEnv anyNewExprEnv = $this_evalCall.getNewEnv();
        NewExpr newExpr2 = this$0.newExprStringCodingResult;
        Intrinsics.checkNotNullExpressionValue((Object)newExpr2, (String)"newExprStringCodingResult");
        JOperatorV jOperatorV = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)newExpr2));
        NewExpr newExpr3 = this$0.newExprStringCodingResult;
        Intrinsics.checkNotNullExpressionValue((Object)newExpr3, (String)"newExprStringCodingResult");
        CompanionV newResult = jOperatorV.markOfNewExpr((AnyNewExpr)newExpr3).pop();
        AbstractHeapFactory abstractHeapFactory3 = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory4 = $this_evalCall.getHf();
        AnyNewExprEnv anyNewExprEnv2 = $this_evalCall.getNewEnv();
        NewArrayExpr newArrayExpr = this$0.newValueExpr;
        Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr, (String)"newValueExpr");
        JOperatorV jOperatorV2 = abstractHeapFactory3.push(heapValuesEnv2, abstractHeapFactory4.anyNewVal(anyNewExprEnv2, (AnyNewExpr)newArrayExpr));
        NewArrayExpr newArrayExpr2 = this$0.newValueExpr;
        Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr2, (String)"newValueExpr");
        CompanionV newValue = jOperatorV2.markOfNewExpr((AnyNewExpr)newArrayExpr2).pop();
        AbstractHeapFactory abstractHeapFactory5 = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv3 = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory6 = $this_evalCall.getHf();
        Constant constant = (Constant)WString.Companion.getLATIN1();
        ByteType byteType = G.v().soot_ByteType();
        Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
        CompanionV newCoder = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)abstractHeapFactory5.push(heapValuesEnv3, abstractHeapFactory6.newConstVal(constant, (Type)byteType)), (Constant)((Constant)WString.Companion.getLATIN1()), null, (int)2, null).pop();
        IHeapValues arraySize = $this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)newValueArray.length)).markArraySizeOf(companionV).popHV();
        ArraySpace newArray = ArraySpace.Companion.v($this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), companionV, (Number[])ArraysKt.toTypedArray((byte[])newValueArray), $this_evalCall.getHf().getVg().getBYTE_ARRAY_TYPE(), arraySize);
        $this_evalCall.getOut().setValueData((HeapValuesEnv)$this_evalCall.getEnv(), newValue.getValue(), (Object)BuiltInModelT.Array, (IData)newArray);
        IFact.Builder builder2 = $this_evalCall.getOut();
        Intrinsics.checkNotNull((Object)builder2, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder");
        FieldUtil fieldUtil = FieldUtil.INSTANCE;
        SootField field$iv = this$0.stringCodingResultValueField;
        boolean $i$f$of = false;
        ((PointsToGraphBuilder)builder2).assignField((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().empty().plus(newResult), (JFieldType)new JSootFieldType(field$iv), $this_evalCall.getHf().empty().plus(newValue), false);
        IFact.Builder builder3 = $this_evalCall.getOut();
        Intrinsics.checkNotNull((Object)builder3, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder");
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        field$iv = this$0.stringCodingResultCoderField;
        $i$f$of = false;
        ((PointsToGraphBuilder)builder3).assignField((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().empty().plus(newResult), (JFieldType)new JSootFieldType(field$iv), $this_evalCall.getHf().empty().plus(newCoder), false);
        res.add(newResult);
        return true;
    }

    private static final Unit register$lambda$3(WStringCoding this$0, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues baP = $this$evalCall.arg(0);
        IHeapValues offP = $this$evalCall.arg(1);
        IHeapValues lenP = $this$evalCall.arg(2);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{baP, offP, lenP};
        IOpCalculator decodeOp = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        decodeOp.resolve((arg_0, arg_1, arg_2) -> WStringCoding.register$lambda$3$lambda$2($this$evalCall, this$0, arg_0, arg_1, arg_2));
        RefType refType = this$0.StringCodingResultType;
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"StringCodingResultType");
        decodeOp.putSummaryIfNotConcrete((Type)refType, (Object)"return");
        $this$evalCall.setReturn(decodeOp.getRes().build());
        return Unit.INSTANCE;
    }
}

