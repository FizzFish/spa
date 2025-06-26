/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysisKt
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f*\u0010\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"\u00020\u00022\u00020\u0002*,\u0010\u0003\"\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u00072\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007*,\u0010\b\"\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u00072\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007*\n\u0010\u0001\"\u00020\n2\u00020\n\u00a8\u0006\u0010"}, d2={"AnalysisInSummary", "V", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "EvalCallInCallee", "Lkotlin/Function1;", "Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl$EvalCall;", "", "Lkotlin/ExtensionFunctionType;", "PostCallInCallee", "Lcn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl$PostCall;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "excludeSubSignature", "", "", "getExcludeSubSignature", "()Ljava/util/Set;", "corax-data-flow"})
public final class ACheckCallAnalysisKt {
    @NotNull
    private static final Set<String> excludeSubSignature;

    @NotNull
    public static final Set<String> getExcludeSubSignature() {
        return excludeSubSignature;
    }

    public static /* synthetic */ void AnalysisInSummary$annotations() {
    }

    static {
        Object[] objectArray = new String[]{"java.lang.String toString()", "boolean equals(java.lang.Object)", "int hashCode()", "java.lang.Object clone()"};
        excludeSubSignature = SetsKt.setOf((Object[])objectArray);
    }
}

