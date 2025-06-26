/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.dataflow.interprocedural.check.PathGeneratorImpl
 *  cn.sast.dataflow.interprocedural.check.PathGeneratorImpl$Companion
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import cn.sast.dataflow.interprocedural.check.PathGeneratorImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lcn/sast/dataflow/interprocedural/check/PathGeneratorImpl;", "", "<init>", "()V", "Companion", "corax-data-flow"})
public final class PathGeneratorImpl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final boolean dataFlowResultPathOnlyStmt = ExtSettings.INSTANCE.getDataFlowResultPathOnlyStmt();

    public static final /* synthetic */ boolean access$getDataFlowResultPathOnlyStmt$cp() {
        return dataFlowResultPathOnlyStmt;
    }
}

