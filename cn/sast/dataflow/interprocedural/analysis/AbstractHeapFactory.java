package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.IExpr;
import kotlin.Pair;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.Unit;
import soot.jimple.*;

import java.util.Set;

public abstract class AbstractHeapFactory<V> implements IHeapValuesFactory<V> {
    public IFact.Builder<V> constantPoolObjectData;
    private KLogger logger;

    public AbstractHeapFactory() {
        this.logger = KotlinLogging.INSTANCE.logger(getClass().getName());
    }

    @NotNull
    public final IFact.Builder<V> getConstantPoolObjectData() {
        if (constantPoolObjectData == null) {
            throw new IllegalStateException("constantPoolObjectData not initialized");
        }
        return constantPoolObjectData;
    }

    public final void setConstantPoolObjectData(@NotNull IFact.Builder<V> builder) {
        if (builder == null) {
            throw new IllegalArgumentException("builder cannot be null");
        }
        this.constantPoolObjectData = builder;
    }

    @NotNull
    public KLogger getLogger() {
        return logger;
    }

    public void setLogger(@NotNull KLogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("logger cannot be null");
        }
        this.logger = logger;
    }

    @NotNull
    public abstract IVGlobal getVg();

    public abstract V anyNewVal(@NotNull AnyNewExprEnv env, @NotNull AnyNewExpr newExpr);

    public abstract V newSummaryVal(@NotNull HeapValuesEnv env, @NotNull Type type, @NotNull Object special);

    @NotNull
    public abstract IHeapValues<V> canStore(@NotNull IHeapValues<V> receivers, @NotNull Type receiverType);

    public abstract V newConstVal(@NotNull Constant constant, @NotNull Type type);

    public abstract V getNullConst();

    @NotNull
    public abstract HeapValuesEnv env(@NotNull Unit node);

    @NotNull
    public abstract HookEnv env(@NotNull AIContext ctx, @NotNull Unit node);

    @Nullable
    public abstract Boolean getBooleanValue(V v, boolean checkType);

    @Nullable
    public abstract Integer getIntValue(V v, boolean checkType);

    @NotNull
    public abstract IReNew<V> newReNewInterface(@NotNull Set<V> orig);

    @NotNull
    public abstract JOperatorV<V> push(@NotNull HeapValuesEnv env, V alloc);

    @NotNull
    public abstract JOperatorC<V> push(@NotNull HeapValuesEnv env, @NotNull CompanionV<V> value);

    @NotNull
    public abstract JOperatorHV<V> push(@NotNull HeapValuesEnv env, @NotNull IHeapValues<V> value);

    @NotNull
    public abstract PathFactory<V> getPathFactory();

    public final V toConstVal(@NotNull Object v) {
        if (v == null) {
            throw new IllegalArgumentException("v cannot be null");
        }
        Pair<Constant, Type> pair = SootUtilsKt.constOf(v);
        return newConstVal(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public abstract IOpCalculator<V> resolveOp(@NotNull HeapValuesEnv env, IHeapValues<V>... ops);

    @Nullable
    public abstract IOpCalculator<V> resolveCast(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<V> fact, 
            @NotNull Type toType, @NotNull IHeapValues<V> fromValues);

    @NotNull
    public abstract IOpCalculator<V> resolveInstanceOf(@NotNull HeapValuesEnv env, 
            @NotNull IHeapValues<V> fromValues, @NotNull Type toType);

    @NotNull
    public abstract IOpCalculator<V> resolveUnop(@NotNull HeapValuesEnv env, @NotNull IIFact<V> opValues, 
            @NotNull IHeapValues<V> value, @NotNull UnopExpr expr, @NotNull Type resType);

    @NotNull
    public abstract IOpCalculator<V> resolveBinop(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<V> fact, 
            @NotNull IHeapValues<V> op1Values, @NotNull IHeapValues<V> op2Values, 
            @NotNull BinopExpr expr, @NotNull Type resType);

    @NotNull
    public abstract Sequence<Object> resolve(@NotNull HeapValuesEnv env, 
            @NotNull ICallCB<IHeapValues<V>, IFact.Builder<IValue>> atCall, @NotNull IExpr iExpr);

    @NotNull
    public IHeapValues.Builder<V> emptyBuilder() {
        return IHeapValuesFactory.super.emptyBuilder();
    }
}
