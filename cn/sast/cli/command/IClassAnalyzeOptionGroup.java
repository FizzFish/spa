package cn.sast.cli.command;

import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;

public interface IClassAnalyzeOptionGroup {
    @NotNull
    InfoflowConfiguration getInfoFlowConfig();
}