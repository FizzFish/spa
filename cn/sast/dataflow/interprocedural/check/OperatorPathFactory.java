package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import com.feysh.corax.config.api.IIexConst;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootMethod;
import soot.jimple.*;

import java.util.*;

public final class OperatorPathFactory implements JOperatorV<IValue> {
    @NotNull
    private final AbstractHeapFactory<IValue> heapFactory;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final IValue alloc;
    @Nullable
    private final IPath path;

    public OperatorPathFactory(@NotNull AbstractHeapFactory<IValue> heapFactory, 
                             @NotNull HeapValuesEnv env, 
                             @NotNull IValue alloc, 
                             @Nullable IPath path) {
        this.heapFactory = heapFactory;
        this.env = env;
        this.alloc = alloc;
        this.path = path;
    }

    @NotNull
    public AbstractHeapFactory<IValue> getHeapFactory() {
        return heapFactory;
    }

    @NotNull
    public HeapValuesEnv getEnv() {
        return env;
    }

    @Nullable
    public IPath getPath() {
        return path;
    }

    @Override
    @NotNull
    public CompanionV<IValue> pop() {
        IPath path = this.path != null ? this.path : UnknownPath.Companion.v(env);
        return new CompanionValueImpl1(alloc, path);
    }

    @Override
    @NotNull
    public IHeapValues<IValue> popHV() {
        return heapFactory.empty().plus(pop());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfConstant(@NotNull Constant c, @Nullable Object info) {
        return copy(null, null, null, LiteralPath.Companion.v(env, c, info));
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfConstant(@NotNull IIexConst c) {
        return copy(null, null, null, LiteralPath.Companion.v(env, c));
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfNewExpr(@NotNull AnyNewExpr expr) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryValueFromArrayGet(@NotNull CompanionV<IValue> array, @Nullable Object info) {
        return copy(null, null, null, ((PathCompanionV) array).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryValueInCaughtExceptionRhs() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueFailedInHook() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueInCalleeSite() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfCantCalcAbstractResultValue() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfEntryMethodParam(@NotNull SootMethod entryPoint) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSootBinOp(@NotNull BinopExpr expr, 
                                          @NotNull CompanionV<IValue> clop, 
                                          @NotNull CompanionV<IValue> crop) {
        return copy(null, null, null, MergePath.Companion.v(env, 
                ((PathCompanionV) clop).getPath(), 
                ((PathCompanionV) crop).getPath()));
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfOp(@NotNull Object op, 
                                     @NotNull CompanionV<IValue> op1, 
                                     CompanionV<IValue>... ops) {
        Set<IPath> paths = new HashSet<>();
        paths.add(((PathCompanionV) op1).getPath());
        for (CompanionV<IValue> companion : ops) {
            paths.add(((PathCompanionV) companion).getPath());
        }
        return copy(null, null, null, MergePath.Companion.v(env, paths));
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfOp(@NotNull Object op, 
                                     @NotNull ImmutableElementSet<Object> op1, 
                                     ImmutableElementSet<Object>... ops) {
        Set<IPath> paths = new HashSet<>();
        collectPaths(op1, paths);
        for (ImmutableElementSet<Object> set : ops) {
            collectPaths(set, paths);
        }
        return copy(null, null, null, MergePath.Companion.v(env, paths));
    }

    private void collectPaths(ImmutableElementSet<Object> set, Set<IPath> paths) {
        for (IHeapValues values : set.getMap().values()) {
            for (CompanionV<IValue> companion : values.getValuesCompanion()) {
                paths.add(((PathCompanionV) companion).getPath());
            }
        }
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfNegExpr(@NotNull NegExpr expr, @NotNull CompanionV<IValue> cop) {
        return copy(null, null, null, ((PathCompanionV) cop).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfCastTo(@NotNull PrimType toPrimType) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfCastTo(@NotNull RefLikeType toRefType) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfInstanceOf() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfArrayContentEqualsBoolResult() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfParseString(@NotNull String hint, @NotNull CompanionV<IValue> str) {
        return copy(null, null, null, ((PathCompanionV) str).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueFailedGetKeyFromKey(
            @NotNull CompanionV<IValue> src, @NotNull Object mt, @Nullable Object key) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> dataGetElementFromSequence(@NotNull CompanionV<IValue> sourceSequence) {
        return copy(null, null, null, ((PathCompanionV) sourceSequence).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markSummaryArraySize(@NotNull IHeapValues<IValue> allocSite) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfGetClass(@NotNull CompanionV<IValue> cop) {
        return copy(null, null, null, ((PathCompanionV) cop).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfObjectEqualsResult(@NotNull CompanionV<IValue> th1s, 
                                                     @NotNull CompanionV<IValue> that) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfReturnValueOfMethod(@NotNull CalleeCBImpl.EvalCall ctx) {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> dataSequenceToSeq(@NotNull CompanionV<IValue> sourceSequence) {
        return copy(null, null, null, ((PathCompanionV) sourceSequence).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markArraySizeOf(@NotNull CompanionV<IValue> array) {
        return copy(null, null, null, ((PathCompanionV) array).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfTaint() {
        return this;
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfStringLatin1Hash(@NotNull CompanionV<IValue> byteArray) {
        return copy(null, null, null, ((PathCompanionV) byteArray).getPath());
    }

    @Override
    @NotNull
    public JOperatorV<IValue> markOfWideningSummary() {
        return this;
    }

    @NotNull
    public OperatorPathFactory copy(@NotNull AbstractHeapFactory<IValue> heapFactory,
                                  @NotNull HeapValuesEnv env,
                                  @NotNull IValue alloc,
                                  @Nullable IPath path) {
        return new OperatorPathFactory(heapFactory, env, alloc, path);
    }

    @Override
    public String toString() {
        return "OperatorPathFactory(heapFactory=" + heapFactory + 
               ", env=" + env + 
               ", alloc=" + alloc + 
               ", path=" + path + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperatorPathFactory)) return false;
        OperatorPathFactory that = (OperatorPathFactory) o;
        return heapFactory.equals(that.heapFactory) &&
               env.equals(that.env) &&
               alloc.equals(that.alloc) &&
               Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heapFactory, env, alloc, path);
    }
}
