package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisConfig;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class PreAnalysisAbsConfig implements IPreAnalysisConfig {
    @NotNull
    private List<? extends ProcessRule.IMatchItem> processRules;
    private boolean incrementalAnalyze;

    public PreAnalysisAbsConfig(@NotNull List<? extends ProcessRule.IMatchItem> processRules, boolean incrementalAnalyze) {
        if (processRules == null) {
            throw new IllegalArgumentException("processRules cannot be null");
        }
        this.processRules = processRules;
        this.incrementalAnalyze = incrementalAnalyze;
    }

    public PreAnalysisAbsConfig() {
        this(Collections.emptyList(), true);
    }

    @NotNull
    public List<ProcessRule.IMatchItem> getProcessRules() {
        return this.processRules;
    }

    public void setProcessRules(@NotNull List<? extends ProcessRule.IMatchItem> processRules) {
        if (processRules == null) {
            throw new IllegalArgumentException("processRules cannot be null");
        }
        this.processRules = processRules;
    }

    public boolean getIncrementalAnalyze() {
        return this.incrementalAnalyze;
    }

    public void setIncrementalAnalyze(boolean incrementalAnalyze) {
        this.incrementalAnalyze = incrementalAnalyze;
    }
}