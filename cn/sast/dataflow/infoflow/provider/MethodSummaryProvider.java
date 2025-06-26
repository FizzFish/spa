/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.config.PreAnalysisCoroutineScopeKt
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProvider
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProvider$Companion
 *  cn.sast.dataflow.infoflow.provider.ModelingConfigImpl
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.methodSummary.data.provider.AbstractMethodSummaryProvider
 *  soot.jimple.infoflow.methodSummary.data.summary.ClassMethodSummaries
 *  soot.jimple.infoflow.methodSummary.data.summary.ClassSummaries
 *  soot.jimple.infoflow.methodSummary.data.summary.MethodSummaries
 *  soot.util.MultiMap
 */
package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.config.PreAnalysisCoroutineScopeKt;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProvider;
import cn.sast.dataflow.infoflow.provider.ModelingConfigImpl;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.methodSummary.data.provider.AbstractMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.data.summary.ClassMethodSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.ClassSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.MethodSummaries;
import soot.util.MultiMap;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 62\u00020\u0001:\u00016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0016J \u0010\u001d\u001a\u0004\u0018\u00010\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\u001c\u0010&\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001eH\u0016J\u000e\u00104\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u00105R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101\u00a8\u00067"}, d2={"Lcn/sast/dataflow/infoflow/provider/MethodSummaryProvider;", "Lsoot/jimple/infoflow/methodSummary/data/provider/AbstractMethodSummaryProvider;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "preAnalysisImpl", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/api/config/PreAnalysisCoroutineScope;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getPreAnalysisImpl", "()Lcn/sast/api/config/PreAnalysisCoroutineScope;", "loadedClasses", "", "", "classSummaries", "Lsoot/jimple/infoflow/methodSummary/data/summary/ClassSummaries;", "getClassSummaries", "()Lsoot/jimple/infoflow/methodSummary/data/summary/ClassSummaries;", "subsigMethodsWithSummaries", "getSubsigMethodsWithSummaries", "()Ljava/util/Set;", "setSubsigMethodsWithSummaries", "(Ljava/util/Set;)V", "getSupportedClasses", "getAllClassesWithSummaries", "supportsClass", "", "clazz", "getMethodFlows", "Lsoot/jimple/infoflow/methodSummary/data/summary/ClassMethodSummaries;", "className", "methodSignature", "classes", "getClassFlows", "mayHaveSummaryForMethod", "subsig", "getSummaries", "isMethodExcluded", "subSignature", "addSubsigsForMethod", "", "read", "Lsoot/jimple/infoflow/methodSummary/data/summary/MethodSummaries;", "addMethodSummaries", "newSummaries", "aiCheckerImpl", "Lcn/sast/dataflow/infoflow/provider/ModelingConfigImpl;", "getAiCheckerImpl", "()Lcn/sast/dataflow/infoflow/provider/ModelingConfigImpl;", "aiCheckerImpl$delegate", "Lkotlin/Lazy;", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-data-flow"})
public class MethodSummaryProvider
extends AbstractMethodSummaryProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    @NotNull
    private final Set<String> loadedClasses;
    @NotNull
    private final ClassSummaries classSummaries;
    @NotNull
    private Set<String> subsigMethodsWithSummaries;
    @NotNull
    private final Lazy aiCheckerImpl$delegate;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(MethodSummaryProvider::logger$lambda$2);

    public MethodSummaryProvider(@NotNull MainConfig mainConfig, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisImpl, (String)"preAnalysisImpl");
        this.mainConfig = mainConfig;
        this.preAnalysisImpl = preAnalysisImpl;
        this.loadedClasses = new LinkedHashSet();
        this.classSummaries = new ClassSummaries();
        this.subsigMethodsWithSummaries = new LinkedHashSet();
        this.aiCheckerImpl$delegate = LazyKt.lazy(() -> MethodSummaryProvider.aiCheckerImpl_delegate$lambda$1(this));
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final PreAnalysisCoroutineScope getPreAnalysisImpl() {
        return this.preAnalysisImpl;
    }

    @NotNull
    public final ClassSummaries getClassSummaries() {
        return this.classSummaries;
    }

    @NotNull
    public final Set<String> getSubsigMethodsWithSummaries() {
        return this.subsigMethodsWithSummaries;
    }

    public final void setSubsigMethodsWithSummaries(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.subsigMethodsWithSummaries = set;
    }

    @NotNull
    public Set<String> getSupportedClasses() {
        return this.loadedClasses;
    }

    @NotNull
    public Set<String> getAllClassesWithSummaries() {
        return this.loadedClasses;
    }

    public boolean supportsClass(@NotNull String clazz) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        return this.loadedClasses.contains(clazz);
    }

    @Nullable
    public ClassMethodSummaries getMethodFlows(@NotNull String className, @NotNull String methodSignature) {
        ClassMethodSummaries classSummaries;
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
        ClassMethodSummaries classMethodSummaries = classSummaries = this.getClassSummaries(className);
        return classMethodSummaries != null ? classMethodSummaries.filterForMethod(methodSignature) : null;
    }

    @Nullable
    public ClassSummaries getMethodFlows(@NotNull Set<String> classes, @NotNull String methodSignature) {
        Intrinsics.checkNotNullParameter(classes, (String)"classes");
        Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
        return this.classSummaries.filterForMethod(classes, methodSignature);
    }

    @Nullable
    public ClassMethodSummaries getClassFlows(@Nullable String clazz) {
        return this.classSummaries.getClassSummaries(clazz);
    }

    public boolean mayHaveSummaryForMethod(@NotNull String subsig) {
        Intrinsics.checkNotNullParameter((Object)subsig, (String)"subsig");
        return this.subsigMethodsWithSummaries.contains(subsig);
    }

    @NotNull
    public ClassSummaries getSummaries() {
        return this.classSummaries;
    }

    public boolean isMethodExcluded(@Nullable String className, @Nullable String subSignature) {
        ClassMethodSummaries summaries = this.getClassSummaries(className);
        return summaries != null && summaries.getMethodSummaries().isExcluded(subSignature);
    }

    @Nullable
    public ClassMethodSummaries getClassSummaries(@Nullable String className) {
        return this.classSummaries.getClassSummaries(className);
    }

    protected void addSubsigsForMethod(@NotNull MethodSummaries read) {
        Intrinsics.checkNotNullParameter((Object)read, (String)"read");
        MultiMap flows = read.getFlows();
        MultiMap clears = read.getClears();
        if (flows != null) {
            Set set = flows.keySet();
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"keySet(...)");
            this.subsigMethodsWithSummaries.addAll(set);
        }
        if (clears != null) {
            Set set = clears.keySet();
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"keySet(...)");
            this.subsigMethodsWithSummaries.addAll(set);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addMethodSummaries(@NotNull ClassMethodSummaries newSummaries) {
        Intrinsics.checkNotNullParameter((Object)newSummaries, (String)"newSummaries");
        MethodSummaryProvider methodSummaryProvider = this;
        synchronized (methodSummaryProvider) {
            boolean bl = false;
            MethodSummaries methodSummaries = newSummaries.getMethodSummaries();
            Intrinsics.checkNotNullExpressionValue((Object)methodSummaries, (String)"getMethodSummaries(...)");
            this.addSubsigsForMethod(methodSummaries);
            this.classSummaries.merge(newSummaries);
            String string = newSummaries.getClassName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getClassName(...)");
            boolean bl2 = this.loadedClasses.add(string);
        }
    }

    private final ModelingConfigImpl getAiCheckerImpl() {
        Lazy lazy = this.aiCheckerImpl$delegate;
        return (ModelingConfigImpl)lazy.getValue();
    }

    @Nullable
    public final Object initialize(@NotNull Continuation<? super Unit> $completion) {
        Object object = PreAnalysisCoroutineScopeKt.processAIAnalysisUnits((AIAnalysisBaseImpl)((AIAnalysisBaseImpl)this.getAiCheckerImpl()), (PreAnalysisCoroutineScope)this.preAnalysisImpl, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final ModelingConfigImpl aiCheckerImpl_delegate$lambda$1(MethodSummaryProvider this$0) {
        return new ModelingConfigImpl(this$0, (PreAnalysisApi)this$0.preAnalysisImpl);
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }
}

