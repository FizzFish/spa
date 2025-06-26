/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.FlowDroidFactory
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.jimple.infoflow.AbstractInfoflow
 *  soot.jimple.infoflow.InfoflowConfiguration$DataFlowDirection
 *  soot.jimple.infoflow.cfg.BiDirICFGFactory
 *  soot.jimple.infoflow.problems.TaintPropagationResults$OnTaintPropagationResultAdded
 */
package cn.sast.dataflow.infoflow;

import java.io.File;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.jimple.infoflow.AbstractInfoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.cfg.BiDirICFGFactory;
import soot.jimple.infoflow.problems.TaintPropagationResults;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JW\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/infoflow/FlowDroidFactory;", "", "<init>", "()V", "createInfoFlow", "Lsoot/jimple/infoflow/AbstractInfoflow;", "dataFlowDirection", "Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowDirection;", "androidPlatformDir", "", "forceAndroidJar", "", "lifecycleMethods", "", "Lsoot/SootMethod;", "cfgFactory", "Lsoot/jimple/infoflow/cfg/BiDirICFGFactory;", "useSparseOpt", "resultAddedHandlers", "", "Lsoot/jimple/infoflow/problems/TaintPropagationResults$OnTaintPropagationResultAdded;", "(Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowDirection;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Collection;Lsoot/jimple/infoflow/cfg/BiDirICFGFactory;ZLjava/util/Set;)Lsoot/jimple/infoflow/AbstractInfoflow;", "logger", "Lmu/KLogger;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nFlowDroidFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowDroidFactory.kt\ncn/sast/dataflow/infoflow/FlowDroidFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
public final class FlowDroidFactory {
    @NotNull
    public static final FlowDroidFactory INSTANCE = new FlowDroidFactory();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(FlowDroidFactory::logger$lambda$3);

    private FlowDroidFactory() {
    }

    @NotNull
    public final AbstractInfoflow createInfoFlow(@NotNull InfoflowConfiguration.DataFlowDirection dataFlowDirection, @Nullable String androidPlatformDir, @Nullable Boolean forceAndroidJar, @Nullable Collection<? extends SootMethod> lifecycleMethods, @Nullable BiDirICFGFactory cfgFactory, boolean useSparseOpt, @NotNull Set<? extends TaintPropagationResults.OnTaintPropagationResultAdded> resultAddedHandlers) {
        AbstractInfoflow abstractInfoflow;
        Intrinsics.checkNotNullParameter((Object)dataFlowDirection, (String)"dataFlowDirection");
        Intrinsics.checkNotNullParameter(resultAddedHandlers, (String)"resultAddedHandlers");
        if (!(androidPlatformDir != null || forceAndroidJar == null)) {
            boolean $i$a$-require-FlowDroidFactory$createInfoFlow$42 = false;
            String $i$a$-require-FlowDroidFactory$createInfoFlow$42 = "androidPlatformDir not special";
            throw new IllegalArgumentException($i$a$-require-FlowDroidFactory$createInfoFlow$42.toString());
        }
        if (!(androidPlatformDir == null || forceAndroidJar != null)) {
            boolean $i$a$-require-FlowDroidFactory$createInfoFlow$52 = false;
            String $i$a$-require-FlowDroidFactory$createInfoFlow$52 = "forceAndroidJar not special";
            throw new IllegalArgumentException($i$a$-require-FlowDroidFactory$createInfoFlow$52.toString());
        }
        if (androidPlatformDir != null && forceAndroidJar != null && !(StringsKt.endsWith$default((String)androidPlatformDir, (String)".jar", (boolean)false, (int)2, null) && forceAndroidJar != false || new File(androidPlatformDir).isDirectory() && forceAndroidJar == false)) {
            boolean bl = false;
            String string = "error androidPlatformDir: " + androidPlatformDir + " and forceAndroidJar: " + forceAndroidJar;
            throw new IllegalArgumentException(string.toString());
        }
        if (dataFlowDirection == InfoflowConfiguration.DataFlowDirection.Forwards) {
            Boolean bl = forceAndroidJar;
            var9_14 = bl != null ? bl : false;
            abstractInfoflow = (AbstractInfoflow)new /* Unavailable Anonymous Inner Class!! */;
        } else {
            Boolean bl = forceAndroidJar;
            var9_14 = bl != null ? bl : false;
            abstractInfoflow = (AbstractInfoflow)new /* Unavailable Anonymous Inner Class!! */;
        }
        AbstractInfoflow infoFlow2 = abstractInfoflow;
        return infoFlow2;
    }

    private static final Unit logger$lambda$3() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$p() {
        return logger;
    }
}

