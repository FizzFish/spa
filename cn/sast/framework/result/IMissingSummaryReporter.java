/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.framework.result.IMissingSummaryReporter
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lcn/sast/framework/result/IMissingSummaryReporter;", "Lcn/sast/api/report/IResultCollector;", "reportMissingMethod", "", "method", "Lsoot/SootMethod;", "corax-framework"})
public interface IMissingSummaryReporter
extends IResultCollector {
    public void reportMissingMethod(@NotNull SootMethod var1);
}

