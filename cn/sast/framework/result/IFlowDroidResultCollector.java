/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  kotlin.Metadata
 *  soot.jimple.infoflow.handlers.ResultsAvailableHandler
 *  soot.jimple.infoflow.problems.TaintPropagationResults$OnTaintPropagationResultAdded
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import kotlin.Metadata;
import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.problems.TaintPropagationResults;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003\u00a8\u0006\u0004"}, d2={"Lcn/sast/framework/result/IFlowDroidResultCollector;", "Lcn/sast/api/report/IResultCollector;", "Lsoot/jimple/infoflow/problems/TaintPropagationResults$OnTaintPropagationResultAdded;", "Lsoot/jimple/infoflow/handlers/ResultsAvailableHandler;", "corax-framework"})
public interface IFlowDroidResultCollector
extends IResultCollector,
TaintPropagationResults.OnTaintPropagationResultAdded,
ResultsAvailableHandler {
}

