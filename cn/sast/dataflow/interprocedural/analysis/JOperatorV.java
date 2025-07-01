package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperator;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import com.feysh.corax.config.api.IIexConst;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootMethod;
import soot.jimple.*;

public interface JOperatorV<V> extends JOperator<V> {
    @NotNull JOperatorV<V> markOfEntryMethodParam(@NotNull SootMethod entryPoint);
    @NotNull JOperatorV<V> markOfTaint();
    @NotNull JOperatorV<V> markOfConstant(@NotNull Constant c, @Nullable Object info);
    @NotNull JOperatorV<V> markOfConstant(@NotNull IIexConst c);
    @NotNull JOperatorV<V> markOfNewExpr(@NotNull AnyNewExpr expr);
    @NotNull JOperatorV<V> markSummaryValueFromArrayGet(@NotNull CompanionV<V> array, @Nullable Object info);
    @NotNull JOperatorV<V> markSummaryValueInCaughtExceptionRhs();
    @NotNull JOperatorV<V> markSummaryReturnValueFailedInHook();
    @NotNull JOperatorV<V> markSummaryReturnValueInCalleeSite();
    @NotNull JOperatorV<V> markSummaryReturnValueFailedGetKeyFromKey(@NotNull CompanionV<V> src, @NotNull Object mt, @Nullable Object key);
    @NotNull JOperatorV<V> dataGetElementFromSequence(@NotNull CompanionV<V> sourceSequence);
    @NotNull JOperatorV<V> dataSequenceToSeq(@NotNull CompanionV<V> sourceSequence);
    @NotNull JOperatorV<V> markSummaryArraySize(@NotNull IHeapValues<V> allocSite);
    @NotNull JOperatorV<V> markArraySizeOf(@NotNull CompanionV<V> array);
    @NotNull JOperatorV<V> markOfCantCalcAbstractResultValue();
    @NotNull JOperatorV<V> markSootBinOp(@NotNull BinopExpr expr, @NotNull CompanionV<IValue> clop, @NotNull CompanionV<IValue> crop);
    @NotNull JOperatorV<V> markOfOp(@NotNull Object op, @NotNull CompanionV<IValue> op1, CompanionV<IValue>... ops);
    @NotNull JOperatorV<V> markOfOp(@NotNull Object op, @NotNull ImmutableElementSet<Object> op1, ImmutableElementSet<Object>... ops);
    @NotNull JOperatorV<V> markOfNegExpr(@NotNull NegExpr expr, @NotNull CompanionV<IValue> cop);
    @NotNull JOperatorV<V> markOfCastTo(@NotNull PrimType toPrimType);
    @NotNull JOperatorV<V> markOfCastTo(@NotNull RefLikeType toRefType);
    @NotNull JOperatorV<V> markOfInstanceOf();
    @NotNull JOperatorV<V> markOfArrayContentEqualsBoolResult();
    @NotNull JOperatorV<V> markOfParseString(@NotNull String str, @NotNull CompanionV<IValue> cop);
    @NotNull JOperatorV<V> markOfGetClass(@NotNull CompanionV<IValue> cop);
    @NotNull JOperatorV<V> markOfObjectEqualsResult(@NotNull CompanionV<IValue> th1s, @NotNull CompanionV<IValue> that);
    @NotNull JOperatorV<V> markOfReturnValueOfMethod(@NotNull CalleeCBImpl.EvalCall ctx);
    @NotNull JOperatorV<V> markOfStringLatin1Hash(@NotNull CompanionV<IValue> byteArray);
    @NotNull JOperatorV<V> markOfWideningSummary();
    @NotNull CompanionV<V> pop();
    @NotNull IHeapValues<V> popHV();
}