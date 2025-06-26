/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.override.lang.WNumber
 *  cn.sast.dataflow.interprocedural.override.lang.WNumber$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WStringKt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  soot.ByteType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.G
 *  soot.IntType
 *  soot.IntegerType
 *  soot.LongType
 *  soot.PrimType
 *  soot.RefType
 *  soot.ShortType
 *  soot.SootField
 *  soot.Type
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.Constant
 *  soot.jimple.Jimple
 *  soot.jimple.NewExpr
 *  soot.jimple.NumericConstant
 *  soot.jimple.StringConstant
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WNumber;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import soot.ByteType;
import soot.DoubleType;
import soot.FloatType;
import soot.G;
import soot.IntType;
import soot.IntegerType;
import soot.LongType;
import soot.PrimType;
import soot.RefType;
import soot.ShortType;
import soot.SootField;
import soot.Type;
import soot.jimple.AnyNewExpr;
import soot.jimple.Constant;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.NumericConstant;
import soot.jimple.StringConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J4\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rJ,\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rJ(\u0010\u001a\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u001b\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u001c\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u001e"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WNumber;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "registerToValue", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "clzName", "", "valueFieldType", "Lsoot/PrimType;", "valueField", "Lsoot/SootField;", "toType", "parseString", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl$EvalCall;", "hint", "sIdx", "", "radixIdx", "resType", "parseStringFloating", "registerValueOf", "registerEquals", "register", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWNumber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WNumber.kt\ncn/sast/dataflow/interprocedural/override/lang/WNumber\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,263:1\n44#2:264\n44#2:265\n44#2:266\n*S KotlinDebug\n*F\n+ 1 WNumber.kt\ncn/sast/dataflow/interprocedural/override/lang/WNumber\n*L\n62#1:264\n146#1:265\n178#1:266\n*E\n"})
public final class WNumber
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    private final void registerToValue(ACheckCallAnalysis $this$registerToValue, String clzName, PrimType valueFieldType, SootField valueField, PrimType toType) {
        Function1 handle = arg_0 -> WNumber.registerToValue$lambda$1(valueField, toType, arg_0);
        $this$registerToValue.evalCall("<" + clzName + ": " + toType + " " + toType + "Value()>", handle);
        String string = toType.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        $this$registerToValue.evalCall("<" + clzName + ": " + toType + " to" + StringsKt.capitalize((String)string) + "()>", handle);
    }

    @NotNull
    public final IOpCalculator<IValue> parseString(@NotNull CalleeCBImpl.EvalCall $this$parseString, @NotNull String hint, int sIdx, int radixIdx, @NotNull PrimType resType) {
        Intrinsics.checkNotNullParameter((Object)$this$parseString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)hint, (String)"hint");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        IHeapValues value = $this$parseString.arg(sIdx);
        IHeapValues radixParam = $this$parseString.arg(radixIdx);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{value, radixParam};
        IOpCalculator valueOp = $this$parseString.getHf().resolveOp((HeapValuesEnv)$this$parseString.getEnv(), iHeapValuesArray);
        valueOp.resolve((arg_0, arg_1, arg_2) -> WNumber.parseString$lambda$2($this$parseString, resType, hint, arg_0, arg_1, arg_2));
        valueOp.putSummaryIfNotConcrete((Type)resType, (Object)"return");
        return valueOp;
    }

    @NotNull
    public final IOpCalculator<IValue> parseStringFloating(@NotNull CalleeCBImpl.EvalCall $this$parseStringFloating, @NotNull String hint, int sIdx, @NotNull PrimType resType) {
        Intrinsics.checkNotNullParameter((Object)$this$parseStringFloating, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)hint, (String)"hint");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        IHeapValues value = $this$parseStringFloating.arg(sIdx);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{value};
        IOpCalculator valueOp = $this$parseStringFloating.getHf().resolveOp((HeapValuesEnv)$this$parseStringFloating.getEnv(), iHeapValuesArray);
        valueOp.resolve((arg_0, arg_1, arg_2) -> WNumber.parseStringFloating$lambda$3($this$parseStringFloating, resType, hint, arg_0, arg_1, arg_2));
        valueOp.putSummaryIfNotConcrete((Type)resType, (Object)"return");
        return valueOp;
    }

    public final void registerValueOf(@NotNull ACheckCallAnalysis $this$registerValueOf, @NotNull String clzName, @NotNull PrimType valueFieldType) {
        Intrinsics.checkNotNullParameter((Object)$this$registerValueOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)clzName, (String)"clzName");
        Intrinsics.checkNotNullParameter((Object)valueFieldType, (String)"valueFieldType");
        SootField valueField = cn.sast.dataflow.util.SootUtilsKt.getOrMakeField((String)clzName, (String)"value", (Type)((Type)valueFieldType));
        NewExpr newExpr2 = Jimple.v().newNewExpr(RefType.v((String)clzName));
        PrimType primType = valueFieldType;
        if (!(primType instanceof IntegerType || primType instanceof LongType || primType instanceof FloatType || primType instanceof DoubleType)) {
            throw new IllegalStateException(("error type of " + valueFieldType).toString());
        }
        $this$registerValueOf.evalCall("<" + clzName + ": " + clzName + " valueOf(" + valueFieldType + ")>", arg_0 -> WNumber.registerValueOf$lambda$4(newExpr2, valueField, arg_0));
        $this$registerValueOf.registerWrapper("<" + clzName + ": " + clzName + " valueOf(java.lang.String)>", true);
        String string = valueFieldType.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        $this$registerValueOf.registerWrapper("<" + clzName + ": " + valueFieldType + " parse" + StringsKt.capitalize((String)string) + "(java.lang.String)>", true);
        if (valueFieldType instanceof FloatType || valueFieldType instanceof DoubleType) {
            String string2 = valueFieldType.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
            $this$registerValueOf.evalCall("<" + clzName + ": " + valueFieldType + " parse" + StringsKt.capitalize((String)string2) + "(java.lang.String)>", arg_0 -> WNumber.registerValueOf$lambda$5(this, clzName, valueFieldType, arg_0));
        } else {
            String string3 = valueFieldType.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toString(...)");
            $this$registerValueOf.evalCall("<" + clzName + ": " + valueFieldType + " parse" + StringsKt.capitalize((String)string3) + "(java.lang.String,int)>", arg_0 -> WNumber.registerValueOf$lambda$6(this, clzName, valueFieldType, arg_0));
            $this$registerValueOf.evalCall("<" + clzName + ": " + clzName + " valueOf(java.lang.String,int)>", arg_0 -> WNumber.registerValueOf$lambda$7(newExpr2, this, clzName, valueFieldType, valueField, arg_0));
        }
    }

    public final void registerEquals(@NotNull ACheckCallAnalysis $this$registerEquals, @NotNull String clzName, @NotNull SootField valueField) {
        Intrinsics.checkNotNullParameter((Object)$this$registerEquals, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)clzName, (String)"clzName");
        Intrinsics.checkNotNullParameter((Object)valueField, (String)"valueField");
        RefType classType = RefType.v((String)clzName);
        $this$registerEquals.registerWrapper("<" + clzName + ": boolean equals(java.lang.Object)>", false);
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)"java.lang.Integer", (Object)G.v().soot_IntType()), TuplesKt.to((Object)"java.lang.Long", (Object)G.v().soot_LongType()), TuplesKt.to((Object)"java.lang.Short", (Object)G.v().soot_ShortType()), TuplesKt.to((Object)"java.lang.Byte", (Object)G.v().soot_ByteType()), TuplesKt.to((Object)"java.lang.Float", (Object)G.v().soot_FloatType()), TuplesKt.to((Object)"java.lang.Double", (Object)G.v().soot_DoubleType())};
        List classes = CollectionsKt.listOf((Object[])pairArray);
        for (Pair pair : classes) {
            String c = (String)pair.component1();
            PrimType valueOfType = (PrimType)pair.component2();
            $this$register.registerClassAllWrapper(c);
            Intrinsics.checkNotNull((Object)valueOfType);
            SootField valueField = cn.sast.dataflow.util.SootUtilsKt.getOrMakeField((String)c, (String)"value", (Type)((Type)valueOfType));
            ByteType byteType = G.v().soot_ByteType();
            Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)byteType);
            ShortType shortType = G.v().soot_ShortType();
            Intrinsics.checkNotNullExpressionValue((Object)shortType, (String)"soot_ShortType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)shortType);
            IntType intType = G.v().soot_IntType();
            Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)intType);
            LongType longType = G.v().soot_LongType();
            Intrinsics.checkNotNullExpressionValue((Object)longType, (String)"soot_LongType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)longType);
            FloatType floatType = G.v().soot_FloatType();
            Intrinsics.checkNotNullExpressionValue((Object)floatType, (String)"soot_FloatType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)floatType);
            DoubleType doubleType = G.v().soot_DoubleType();
            Intrinsics.checkNotNullExpressionValue((Object)doubleType, (String)"soot_DoubleType(...)");
            this.registerToValue($this$register, c, valueOfType, valueField, (PrimType)doubleType);
            this.registerValueOf($this$register, c, valueOfType);
            this.registerEquals($this$register, c, valueField);
        }
    }

    private static final boolean registerToValue$lambda$1$lambda$0(PrimType $toType, CalleeCBImpl.EvalCall $this, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        ConstVal constVal = op instanceof ConstVal ? (ConstVal)op : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        NumericConstant numericConstant = constant instanceof NumericConstant ? (NumericConstant)constant : null;
        if (numericConstant == null) {
            return false;
        }
        NumericConstant nc = numericConstant;
        Constant constant2 = SootUtilsKt.castTo((NumericConstant)nc, (Type)((Type)$toType));
        if (constant2 == null) {
            return false;
        }
        Constant c = constant2;
        res.add($this.getHf().push((HeapValuesEnv)$this.getEnv(), $this.getHf().newConstVal(c, (Type)$toType)).markOfCastTo($toType).pop());
        return true;
    }

    private static final Unit registerToValue$lambda$1(SootField $valueField, PrimType $toType, CalleeCBImpl.EvalCall evalCall2) {
        Intrinsics.checkNotNullParameter((Object)evalCall2, (String)"<this>");
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$of = false;
        IFact.Builder.DefaultImpls.getField$default((IFact.Builder)evalCall2.getOut(), (HeapValuesEnv)((HeapValuesEnv)evalCall2.getEnv()), (Object)"value", (Object)-1, (JFieldType)((JFieldType)new JSootFieldType($valueField)), (boolean)false, (int)16, null);
        IHeapValues value = evalCall2.getOut().getTargets((Object)"value");
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{value};
        IOpCalculator valueOp = evalCall2.getHf().resolveOp((HeapValuesEnv)evalCall2.getEnv(), iHeapValuesArray);
        valueOp.resolve((arg_0, arg_1, arg_2) -> WNumber.registerToValue$lambda$1$lambda$0($toType, evalCall2, arg_0, arg_1, arg_2));
        valueOp.putSummaryIfNotConcrete((Type)$toType, (Object)evalCall2.getHf().getVg().getRETURN_LOCAL());
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)evalCall2.getOut(), (HeapValuesEnv)((HeapValuesEnv)evalCall2.getEnv()), (Object)evalCall2.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)valueOp.getRes().build(), (boolean)false, (int)8, null);
        evalCall2.getOut().kill((Object)"value");
        return Unit.INSTANCE;
    }

    private static final boolean parseString$lambda$2(CalleeCBImpl.EvalCall $this_parseString, PrimType $resType, String $hint, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        NumericConstant numericConstant;
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        CompanionV cradix = companionVArray[1];
        IValue str = (IValue)cop.getValue();
        IValue radix = (IValue)cradix.getValue();
        Integer n = FactValuesKt.getIntValue((IValue)radix, (boolean)true);
        if (n == null) {
            return false;
        }
        int radixNm = n;
        if (str instanceof ConstVal) {
            Constant constant = ((ConstVal)str).getV();
            object = constant instanceof StringConstant ? (StringConstant)constant : null;
            if (object == null || (object = object.value) == null) {
                return false;
            }
        } else {
            byte[] byArray = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_parseString), (IValue)str);
            if (byArray == null) {
                return false;
            }
            byte[] byteArray = byArray;
            object = StringsKt.decodeToString((byte[])byteArray);
        }
        Object sc = object;
        try {
            numericConstant = SootUtilsKt.cvtNumericConstant((String)sc, (int)radixNm, (Type)((Type)$resType));
        }
        catch (NumberFormatException e) {
            return false;
        }
        NumericConstant numericConstant2 = numericConstant;
        if (numericConstant2 == null) {
            return false;
        }
        NumericConstant num = numericConstant2;
        res.add($this_parseString.getHf().push((HeapValuesEnv)$this_parseString.getEnv(), $this_parseString.getHf().newConstVal((Constant)num, (Type)$resType)).markOfParseString($hint, cop).pop());
        return true;
    }

    private static final boolean parseStringFloating$lambda$3(CalleeCBImpl.EvalCall $this_parseStringFloating, PrimType $resType, String $hint, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        NumericConstant numericConstant;
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue str = (IValue)cop.getValue();
        if (str instanceof ConstVal) {
            Constant constant = ((ConstVal)str).getV();
            object = constant instanceof StringConstant ? (StringConstant)constant : null;
            if (object == null || (object = object.value) == null) {
                return false;
            }
        } else {
            byte[] byArray = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_parseStringFloating), (IValue)str);
            if (byArray == null) {
                return false;
            }
            byte[] byteArray = byArray;
            object = StringsKt.decodeToString((byte[])byteArray);
        }
        Object sc = object;
        try {
            numericConstant = SootUtilsKt.cvtNumericConstant((String)sc, (int)-1, (Type)((Type)$resType));
        }
        catch (NumberFormatException e) {
            return false;
        }
        NumericConstant numericConstant2 = numericConstant;
        if (numericConstant2 == null) {
            return false;
        }
        NumericConstant num = numericConstant2;
        res.add($this_parseStringFloating.getHf().push((HeapValuesEnv)$this_parseStringFloating.getEnv(), $this_parseStringFloating.getHf().newConstVal((Constant)num, (Type)$resType)).markOfParseString($hint, cop).pop());
        return true;
    }

    private static final Unit registerValueOf$lambda$4(NewExpr $newExpr, SootField $valueField, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        AbstractHeapFactory abstractHeapFactory = $this$evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this$evalCall.getHf();
        AnyNewExprEnv anyNewExprEnv = $this$evalCall.getNewEnv();
        Intrinsics.checkNotNull((Object)$newExpr);
        IHeapValues returnValue = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)$newExpr)).markOfNewExpr((AnyNewExpr)$newExpr).popHV();
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)returnValue, (boolean)false, (int)8, null);
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$of = false;
        IFact.Builder.DefaultImpls.setField$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (JFieldType)((JFieldType)new JSootFieldType($valueField)), (Object)0, (boolean)false, (int)16, null);
        return Unit.INSTANCE;
    }

    private static final Unit registerValueOf$lambda$5(WNumber this$0, String $clzName, PrimType $valueFieldType, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IOpCalculator eval = this$0.parseStringFloating($this$evalCall, $clzName, 0, $valueFieldType);
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)eval.getRes().build(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }

    private static final Unit registerValueOf$lambda$6(WNumber this$0, String $clzName, PrimType $valueFieldType, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IOpCalculator eval = this$0.parseString($this$evalCall, $clzName, 0, 1, $valueFieldType);
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)eval.getRes().build(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }

    private static final Unit registerValueOf$lambda$7(NewExpr $newExpr, WNumber this$0, String $clzName, PrimType $valueFieldType, SootField $valueField, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        AbstractHeapFactory abstractHeapFactory = $this$evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this$evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this$evalCall.getHf();
        AnyNewExprEnv anyNewExprEnv = $this$evalCall.getNewEnv();
        Intrinsics.checkNotNull((Object)$newExpr);
        IHeapValues returnValue = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)$newExpr)).markOfNewExpr((AnyNewExpr)$newExpr).popHV();
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)returnValue, (boolean)false, (int)8, null);
        IOpCalculator eval = this$0.parseString($this$evalCall, $clzName, 0, 1, $valueFieldType);
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$of = false;
        $this$evalCall.getOut().setFieldNew((HeapValuesEnv)$this$evalCall.getEnv(), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (JFieldType)new JSootFieldType($valueField), eval.getRes().build());
        return Unit.INSTANCE;
    }
}

