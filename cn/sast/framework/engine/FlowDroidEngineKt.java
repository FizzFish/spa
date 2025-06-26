/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.FlowDroidEngineKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.AbstractInfoflow
 *  soot.jimple.infoflow.InfoflowConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration
 *  soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager
 */
package cn.sast.framework.engine;

import java.lang.reflect.Method;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.AbstractInfoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\"\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a8\u0006\n"}, d2={"fix", "", "Lsoot/jimple/infoflow/InfoflowConfiguration;", "runAnalysisReflect", "Lsoot/jimple/infoflow/AbstractInfoflow;", "sourcesSinks", "Lsoot/jimple/infoflow/sourcesSinks/manager/ISourceSinkManager;", "additionalSeeds", "", "", "corax-framework"})
public final class FlowDroidEngineKt {
    public static final void fix(@NotNull InfoflowConfiguration $this$fix) {
        Intrinsics.checkNotNullParameter((Object)$this$fix, (String)"<this>");
        String string = InfoflowConfiguration.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        KLogger logger = KotlinLogging.INSTANCE.logger(string);
        if ($this$fix instanceof InfoflowAndroidConfiguration && ((InfoflowAndroidConfiguration)$this$fix).getSourceSinkConfig().getEnableLifecycleSources() && ((InfoflowAndroidConfiguration)$this$fix).getIccConfig().isIccEnabled()) {
            logger.warn("ICC model specified, automatically disabling lifecycle sources");
            ((InfoflowAndroidConfiguration)$this$fix).getSourceSinkConfig().setEnableLifecycleSources(false);
        }
    }

    public static final void runAnalysisReflect(@NotNull AbstractInfoflow $this$runAnalysisReflect, @NotNull ISourceSinkManager sourcesSinks, @Nullable Set<String> additionalSeeds) {
        Intrinsics.checkNotNullParameter((Object)$this$runAnalysisReflect, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sourcesSinks, (String)"sourcesSinks");
        Class[] classArray = new Class[]{ISourceSinkManager.class, Set.class};
        Method it = AbstractInfoflow.class.getDeclaredMethod("runAnalysis", classArray);
        boolean bl = false;
        it.setAccessible(true);
        Object[] objectArray = new Object[]{sourcesSinks, additionalSeeds};
        it.invoke($this$runAnalysisReflect, objectArray);
    }
}

