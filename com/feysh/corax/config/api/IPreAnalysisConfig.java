package com.feysh.corax.config.api;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface IPreAnalysisConfig {
    boolean getIgnoreProjectConfigProcessFilter();
    void setIgnoreProjectConfigProcessFilter(boolean value);

    @NotNull
    List<ProcessRule.IMatchItem> getProcessRules();
    void setProcessRules(@NotNull List<? extends ProcessRule.IMatchItem> rules);

    boolean getIncrementalAnalyze();
    void setIncrementalAnalyze(boolean value);
}