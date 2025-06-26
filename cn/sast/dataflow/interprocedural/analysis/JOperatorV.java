/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperator
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  com.feysh.corax.config.api.IIexConst
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.PrimType
 *  soot.RefLikeType
 *  soot.SootMethod
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.BinopExpr
 *  soot.jimple.Constant
 *  soot.jimple.NegExpr
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperator;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import com.feysh.corax.config.api.IIexConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootMethod;
import soot.jimple.AnyNewExpr;
import soot.jimple.BinopExpr;
import soot.jimple.Constant;
import soot.jimple.NegExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\n\u0010\u0018\u001a\u00060\u000bj\u0002`\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H&J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J2\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&JI\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\u00122\u001e\u0010+\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020&0\u00120,\"\b\u0012\u0004\u0012\u00020&0\u0012H&\u00a2\u0006\u0002\u0010-JI\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0.2\u001e\u0010+\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0.0,\"\b\u0012\u0004\u0012\u00020\u000b0.H&\u00a2\u0006\u0002\u0010/J$\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u000205H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u000207H&J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J$\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u00102\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J*\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020&0\u00122\f\u0010A\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020DH&J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010F\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000 H&\u00a8\u0006J"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "V", "Lcn/sast/dataflow/interprocedural/analysis/JOperator;", "markOfEntryMethodParam", "entryPoint", "Lsoot/SootMethod;", "markOfTaint", "markOfConstant", "c", "Lsoot/jimple/Constant;", "info", "", "Lcom/feysh/corax/config/api/IIexConst;", "markOfNewExpr", "expr", "Lsoot/jimple/AnyNewExpr;", "markSummaryValueFromArrayGet", "array", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "markSummaryValueInCaughtExceptionRhs", "markSummaryReturnValueFailedInHook", "markSummaryReturnValueInCalleeSite", "markSummaryReturnValueFailedGetKeyFromKey", "src", "mt", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "key", "dataGetElementFromSequence", "sourceSequence", "dataSequenceToSeq", "markSummaryArraySize", "allocSite", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "markArraySizeOf", "markOfCantCalcAbstractResultValue", "markSootBinOp", "Lsoot/jimple/BinopExpr;", "clop", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "crop", "markOfOp", "op", "op1", "ops", "", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;[Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;[Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "markOfNegExpr", "Lsoot/jimple/NegExpr;", "cop", "markOfCastTo", "toPrimType", "Lsoot/PrimType;", "toRefType", "Lsoot/RefLikeType;", "markOfInstanceOf", "markOfArrayContentEqualsBoolResult", "markOfParseString", "hint", "", "str", "markOfGetClass", "markOfObjectEqualsResult", "th1s", "that", "markOfReturnValueOfMethod", "ctx", "Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl$EvalCall;", "markOfStringLatin1Hash", "byteArray", "markOfWideningSummary", "pop", "popHV", "corax-data-flow"})
public interface JOperatorV<V>
extends JOperator<V> {
    @NotNull
    public JOperatorV<V> markOfEntryMethodParam(@NotNull SootMethod var1);

    @NotNull
    public JOperatorV<V> markOfTaint();

    @NotNull
    public JOperatorV<V> markOfConstant(@NotNull Constant var1, @Nullable Object var2);

    @NotNull
    public JOperatorV<V> markOfConstant(@NotNull IIexConst var1);

    @NotNull
    public JOperatorV<V> markOfNewExpr(@NotNull AnyNewExpr var1);

    @NotNull
    public JOperatorV<V> markSummaryValueFromArrayGet(@NotNull CompanionV<V> var1, @Nullable Object var2);

    @NotNull
    public JOperatorV<V> markSummaryValueInCaughtExceptionRhs();

    @NotNull
    public JOperatorV<V> markSummaryReturnValueFailedInHook();

    @NotNull
    public JOperatorV<V> markSummaryReturnValueInCalleeSite();

    @NotNull
    public JOperatorV<V> markSummaryReturnValueFailedGetKeyFromKey(@NotNull CompanionV<V> var1, @NotNull Object var2, @Nullable Object var3);

    @NotNull
    public JOperatorV<V> dataGetElementFromSequence(@NotNull CompanionV<V> var1);

    @NotNull
    public JOperatorV<V> dataSequenceToSeq(@NotNull CompanionV<V> var1);

    @NotNull
    public JOperatorV<V> markSummaryArraySize(@NotNull IHeapValues<V> var1);

    @NotNull
    public JOperatorV<V> markArraySizeOf(@NotNull CompanionV<V> var1);

    @NotNull
    public JOperatorV<V> markOfCantCalcAbstractResultValue();

    @NotNull
    public JOperatorV<V> markSootBinOp(@NotNull BinopExpr var1, @NotNull CompanionV<IValue> var2, @NotNull CompanionV<IValue> var3);

    @NotNull
    public JOperatorV<V> markOfOp(@NotNull Object var1, @NotNull CompanionV<IValue> var2, CompanionV<IValue> ... var3);

    @NotNull
    public JOperatorV<V> markOfOp(@NotNull Object var1, @NotNull ImmutableElementSet<Object> var2, ImmutableElementSet<Object> ... var3);

    @NotNull
    public JOperatorV<V> markOfNegExpr(@NotNull NegExpr var1, @NotNull CompanionV<IValue> var2);

    @NotNull
    public JOperatorV<V> markOfCastTo(@NotNull PrimType var1);

    @NotNull
    public JOperatorV<V> markOfCastTo(@NotNull RefLikeType var1);

    @NotNull
    public JOperatorV<V> markOfInstanceOf();

    @NotNull
    public JOperatorV<V> markOfArrayContentEqualsBoolResult();

    @NotNull
    public JOperatorV<V> markOfParseString(@NotNull String var1, @NotNull CompanionV<IValue> var2);

    @NotNull
    public JOperatorV<V> markOfGetClass(@NotNull CompanionV<IValue> var1);

    @NotNull
    public JOperatorV<V> markOfObjectEqualsResult(@NotNull CompanionV<IValue> var1, @NotNull CompanionV<IValue> var2);

    @NotNull
    public JOperatorV<V> markOfReturnValueOfMethod(@NotNull CalleeCBImpl.EvalCall var1);

    @NotNull
    public JOperatorV<V> markOfStringLatin1Hash(@NotNull CompanionV<IValue> var1);

    @NotNull
    public JOperatorV<V> markOfWideningSummary();

    @NotNull
    public CompanionV<V> pop();

    @NotNull
    public IHeapValues<V> popHV();
}

