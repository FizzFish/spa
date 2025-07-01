/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.problems.TaintPropagationResults;

/**
 * Interface combining result collection capabilities for FlowDroid analysis.
 */
public interface IFlowDroidResultCollector extends IResultCollector,
        TaintPropagationResults.OnTaintPropagationResultAdded,
        ResultsAvailableHandler {
}