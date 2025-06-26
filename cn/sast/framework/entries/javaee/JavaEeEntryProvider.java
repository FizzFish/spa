/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.Implement
 *  cn.sast.common.IResFile
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.javaee.JavaEeEntryProvider
 *  cn.sast.framework.entries.javaee.JavaEeEntryProvider$Companion
 *  cn.sast.framework.entries.utils.PhantomValueForType
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  mock.MockObject
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  utils.BaseBodyGeneratorFactory
 */
package cn.sast.framework.entries.javaee;

import analysis.Config;
import analysis.CreateEdge;
import analysis.Implement;
import cn.sast.common.IResFile;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.javaee.JavaEeEntryProvider;
import cn.sast.framework.entries.utils.PhantomValueForType;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mock.MockObject;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import utils.BaseBodyGeneratorFactory;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lcn/sast/framework/entries/javaee/JavaEeEntryProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "ctx", "Lcn/sast/framework/SootCtx;", "beanXmls", "", "Lcn/sast/common/IResFile;", "<init>", "(Lcn/sast/framework/SootCtx;Ljava/util/Set;)V", "getBeanXmls", "()Ljava/util/Set;", "createDummyMain", "Lsoot/SootMethod;", "beanXmlPaths", "", "", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "SummaryTypeValueBaseBodyGenerator", "corax-framework"})
public final class JavaEeEntryProvider
implements IEntryPointProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootCtx ctx;
    @NotNull
    private final Set<IResFile> beanXmls;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(JavaEeEntryProvider::logger$lambda$1);

    public JavaEeEntryProvider(@NotNull SootCtx ctx2, @NotNull Set<IResFile> beanXmls) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter(beanXmls, (String)"beanXmls");
        this.ctx = ctx2;
        this.beanXmls = beanXmls;
        this.iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public /* synthetic */ JavaEeEntryProvider(SootCtx sootCtx, Set set, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            set = new LinkedHashSet();
        }
        this(sootCtx, set);
    }

    @NotNull
    public final Set<IResFile> getBeanXmls() {
        return this.beanXmls;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final SootMethod createDummyMain(Set<String> beanXmlPaths) {
        SootMethod sootMethod;
        PhantomValueForType p = new PhantomValueForType(null, 1, null);
        BaseBodyGeneratorFactory.instance = (BaseBodyGeneratorFactory)new /* Unavailable Anonymous Inner Class!! */;
        Implement.mockObject = (MockObject)new /* Unavailable Anonymous Inner Class!! */;
        CreateEdge edge = new CreateEdge();
        try {
            Config config = new Config();
            Config.linkMainAndController = false;
            Config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods = false;
            config.bean_xml_paths = beanXmlPaths;
            edge.initCallGraph(config);
            SootMethod dummy = edge.projectMainMethod;
            logger.info(() -> JavaEeEntryProvider.createDummyMain$lambda$0(dummy));
            sootMethod = dummy;
        }
        catch (Exception e) {
            logger.error("create JavaEE dummy main failed!", (Throwable)e);
            sootMethod = null;
        }
        finally {
            edge.clear();
            BaseBodyGeneratorFactory.instance = null;
        }
        return sootMethod;
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return this.iterator;
    }

    public void startAnalyse() {
        IEntryPointProvider.DefaultImpls.startAnalyse((IEntryPointProvider)this);
    }

    public void endAnalyse() {
        IEntryPointProvider.DefaultImpls.endAnalyse((IEntryPointProvider)this);
    }

    private static final Object createDummyMain$lambda$0(SootMethod $dummy) {
        return "JavaEE dummy main is " + $dummy;
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ SootCtx access$getCtx$p(JavaEeEntryProvider $this) {
        return $this.ctx;
    }

    public static final /* synthetic */ SootMethod access$createDummyMain(JavaEeEntryProvider $this, Set beanXmlPaths) {
        return $this.createDummyMain(beanXmlPaths);
    }
}

