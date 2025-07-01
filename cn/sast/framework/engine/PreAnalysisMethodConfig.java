package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisMethodConfig;

public final class PreAnalysisMethodConfig extends PreAnalysisAbsConfig implements IPreAnalysisMethodConfig {
    private boolean appOnly;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisMethodConfig() {
        this(true, false);
    }

    public PreAnalysisMethodConfig(boolean appOnly, boolean ignoreProjectConfigProcessFilter) {
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