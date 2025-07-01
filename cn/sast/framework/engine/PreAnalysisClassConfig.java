package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisClassConfig;

public final class PreAnalysisClassConfig extends PreAnalysisAbsConfig implements IPreAnalysisClassConfig {
    private boolean appOnly;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisClassConfig() {
        this(true, false);
    }

    public PreAnalysisClassConfig(boolean appOnly, boolean ignoreProjectConfigProcessFilter) {
        super(null, false);
        this.appOnly = appOnly;
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }

    public boolean getAppOnly() {
        return appOnly;
    }

    public void setAppOnly(boolean appOnly) {
        this.appOnly = appOnly;
    }

    public boolean getIgnoreProjectConfigProcessFilter() {
        return ignoreProjectConfigProcessFilter;
    }

    public void setIgnoreProjectConfigProcessFilter(boolean ignoreProjectConfigProcessFilter) {
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }
}