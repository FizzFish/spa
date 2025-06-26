/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorC
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorHV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.check.PathFactory
 *  cn.sast.idfa.check.ICallCB
 *  com.feysh.corax.config.api.IExpr
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.sequences.Sequence
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.BinopExpr
 *  soot.jimple.Constant
 *  soot.jimple.UnopExpr
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorC;
import cn.sast.dataflow.interprocedural.analysis.JOperatorHV;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.check.PathFactory;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.IExpr;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.Unit;
import soot.jimple.AnyNewExpr;
import soot.jimple.BinopExpr;
import soot.jimple.Constant;
import soot.jimple.UnopExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&\u00a2\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H&\u00a2\u0006\u0002\u0010\"J$\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010&\u001a\u00020\u001fH&J\u001d\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH&\u00a2\u0006\u0002\u0010*J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H&J\u0018\u0010\u001c\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020/H&J!\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00028\u00002\b\b\u0002\u00106\u001a\u000204H&\u00a2\u0006\u0002\u00107J!\u00108\u001a\u0004\u0018\u0001092\u0006\u00105\u001a\u00028\u00002\b\b\u0002\u00106\u001a\u000204H&\u00a2\u0006\u0002\u0010:J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H&J#\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010A\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010BJ$\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000C2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000EH&J$\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000$H&J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000HH&J\u0013\u0010I\u001a\u00028\u00002\u0006\u00105\u001a\u00020!\u00a2\u0006\u0002\u0010JJ?\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000L2\u0006\u0010\u001c\u001a\u00020\u001d2\"\u0010M\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$0N\"\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H&\u00a2\u0006\u0002\u0010OJ<\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010L2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010R\u001a\u00020\u001f2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000$H&J,\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000L2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u00106\u001a\u00020\u001fH&JB\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000L2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u001fH&JP\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000L2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000$2\f\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010X\u001a\u00020^2\u0006\u0010Z\u001a\u00020\u001fH&J>\u0010_\u001a\b\u0012\u0004\u0012\u00020!0`2\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010a\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00060b2\u0006\u0010d\u001a\u00020eH&R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010+\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u0006f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "<init>", "()V", "constantPoolObjectData", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "getConstantPoolObjectData", "()Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "setConstantPoolObjectData", "(Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;)V", "logger", "Lmu/KLogger;", "getLogger", "()Lmu/KLogger;", "setLogger", "(Lmu/KLogger;)V", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "getVg", "()Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "anyNewVal", "newExprEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "newExr", "Lsoot/jimple/AnyNewExpr;", "(Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;Lsoot/jimple/AnyNewExpr;)Ljava/lang/Object;", "newSummaryVal", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "type", "Lsoot/Type;", "special", "", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lsoot/Type;Ljava/lang/Object;)Ljava/lang/Object;", "canStore", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "receivers", "receiverType", "newConstVal", "constant", "Lsoot/jimple/Constant;", "(Lsoot/jimple/Constant;Lsoot/Type;)Ljava/lang/Object;", "nullConst", "getNullConst", "()Ljava/lang/Object;", "node", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "ctx", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "getBooleanValue", "", "v", "checkType", "(Ljava/lang/Object;Z)Ljava/lang/Boolean;", "getIntValue", "", "(Ljava/lang/Object;Z)Ljava/lang/Integer;", "newReNewInterface", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "orig", "", "push", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "alloc", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorC;", "value", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "getPathFactory", "Lcn/sast/dataflow/interprocedural/check/PathFactory;", "toConstVal", "(Ljava/lang/Object;)Ljava/lang/Object;", "resolveOp", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "ops", "", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;[Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "resolveCast", "fact", "toType", "fromValues", "resolveInstanceOf", "resolveUnop", "Lcn/sast/dataflow/interprocedural/analysis/IIFact;", "opValues", "expr", "Lsoot/jimple/UnopExpr;", "resType", "resolveBinop", "op1Values", "op2Values", "Lsoot/jimple/BinopExpr;", "resolve", "Lkotlin/sequences/Sequence;", "atCall", "Lcn/sast/idfa/check/ICallCB;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "iExpr", "Lcom/feysh/corax/config/api/IExpr;", "corax-data-flow"})
public abstract class AbstractHeapFactory<V>
implements IHeapValuesFactory<V> {
    public IFact.Builder<V> constantPoolObjectData;
    @NotNull
    private KLogger logger;

    public AbstractHeapFactory() {
        String string = Reflection.getOrCreateKotlinClass(AbstractHeapFactory.class).getQualifiedName();
        Intrinsics.checkNotNull((Object)string);
        this.logger = KotlinLogging.INSTANCE.logger(string);
    }

    @NotNull
    public final IFact.Builder<V> getConstantPoolObjectData() {
        IFact.Builder builder2 = this.constantPoolObjectData;
        if (builder2 != null) {
            return builder2;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"constantPoolObjectData");
        return null;
    }

    public final void setConstantPoolObjectData(@NotNull IFact.Builder<V> builder2) {
        Intrinsics.checkNotNullParameter(builder2, (String)"<set-?>");
        this.constantPoolObjectData = builder2;
    }

    @NotNull
    public KLogger getLogger() {
        return this.logger;
    }

    public void setLogger(@NotNull KLogger kLogger) {
        Intrinsics.checkNotNullParameter((Object)kLogger, (String)"<set-?>");
        this.logger = kLogger;
    }

    @NotNull
    public abstract IVGlobal getVg();

    public abstract V anyNewVal(@NotNull AnyNewExprEnv var1, @NotNull AnyNewExpr var2);

    public abstract V newSummaryVal(@NotNull HeapValuesEnv var1, @NotNull Type var2, @NotNull Object var3);

    @NotNull
    public abstract IHeapValues<V> canStore(@NotNull IHeapValues<V> var1, @NotNull Type var2);

    public abstract V newConstVal(@NotNull Constant var1, @NotNull Type var2);

    public abstract V getNullConst();

    @NotNull
    public abstract HeapValuesEnv env(@NotNull Unit var1);

    @NotNull
    public abstract HookEnv env(@NotNull AIContext var1, @NotNull Unit var2);

    @Nullable
    public abstract Boolean getBooleanValue(V var1, boolean var2);

    public static /* synthetic */ Boolean getBooleanValue$default(AbstractHeapFactory abstractHeapFactory, Object object, boolean bl, int n, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanValue");
        }
        if ((n & 2) != 0) {
            bl = true;
        }
        return abstractHeapFactory.getBooleanValue(object, bl);
    }

    @Nullable
    public abstract Integer getIntValue(V var1, boolean var2);

    public static /* synthetic */ Integer getIntValue$default(AbstractHeapFactory abstractHeapFactory, Object object, boolean bl, int n, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntValue");
        }
        if ((n & 2) != 0) {
            bl = true;
        }
        return abstractHeapFactory.getIntValue(object, bl);
    }

    @NotNull
    public abstract IReNew<V> newReNewInterface(@NotNull Set<V> var1);

    @NotNull
    public abstract JOperatorV<V> push(@NotNull HeapValuesEnv var1, V var2);

    @NotNull
    public abstract JOperatorC<V> push(@NotNull HeapValuesEnv var1, @NotNull CompanionV<V> var2);

    @NotNull
    public abstract JOperatorHV<V> push(@NotNull HeapValuesEnv var1, @NotNull IHeapValues<V> var2);

    @NotNull
    public abstract PathFactory<V> getPathFactory();

    public final V toConstVal(@NotNull Object v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Pair pair = SootUtilsKt.constOf((Object)v);
        Constant constant = (Constant)pair.component1();
        Type type = (Type)pair.component2();
        return (V)this.newConstVal(constant, type);
    }

    @NotNull
    public abstract IOpCalculator<V> resolveOp(@NotNull HeapValuesEnv var1, IHeapValues<V> ... var2);

    @Nullable
    public abstract IOpCalculator<V> resolveCast(@NotNull HeapValuesEnv var1, @NotNull IFact.Builder<V> var2, @NotNull Type var3, @NotNull IHeapValues<V> var4);

    @NotNull
    public abstract IOpCalculator<V> resolveInstanceOf(@NotNull HeapValuesEnv var1, @NotNull IHeapValues<V> var2, @NotNull Type var3);

    @NotNull
    public abstract IOpCalculator<V> resolveUnop(@NotNull HeapValuesEnv var1, @NotNull IIFact<V> var2, @NotNull IHeapValues<V> var3, @NotNull UnopExpr var4, @NotNull Type var5);

    @NotNull
    public abstract IOpCalculator<V> resolveBinop(@NotNull HeapValuesEnv var1, @NotNull IFact.Builder<V> var2, @NotNull IHeapValues<V> var3, @NotNull IHeapValues<V> var4, @NotNull BinopExpr var5, @NotNull Type var6);

    @NotNull
    public abstract Sequence<Object> resolve(@NotNull HeapValuesEnv var1, @NotNull ICallCB<IHeapValues<V>, IFact.Builder<IValue>> var2, @NotNull IExpr var3);

    @NotNull
    public IHeapValues.Builder<V> emptyBuilder() {
        return IHeapValuesFactory.DefaultImpls.emptyBuilder((IHeapValuesFactory)this);
    }
}

