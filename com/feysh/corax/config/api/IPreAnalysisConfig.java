/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/IPreAnalysisConfig;", "", "ignoreProjectConfigProcessFilter", "", "getIgnoreProjectConfigProcessFilter", "()Z", "setIgnoreProjectConfigProcessFilter", "(Z)V", "processRules", "", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRulesType;", "getProcessRules", "()Ljava/util/List;", "setProcessRules", "(Ljava/util/List;)V", "incrementalAnalyze", "getIncrementalAnalyze", "setIncrementalAnalyze", "corax-config-api"})
public interface IPreAnalysisConfig {
    public boolean getIgnoreProjectConfigProcessFilter();

    public void setIgnoreProjectConfigProcessFilter(boolean var1);

    @NotNull
    public List<ProcessRule.IMatchItem> getProcessRules();

    public void setProcessRules(@NotNull List<? extends ProcessRule.IMatchItem> var1);

    public boolean getIncrementalAnalyze();

    public void setIncrementalAnalyze(boolean var1);
}

