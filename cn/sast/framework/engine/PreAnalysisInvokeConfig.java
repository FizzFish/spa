package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisInvokeConfig;

public final class PreAnalysisInvokeConfig extends PreAnalysisAbsConfig implements IPreAnalysisInvokeConfig {
    private boolean appOnly = true;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisInvokeConfig() {
        this(true, false);
    }

    public PreAnalysisInvokeConfig(boolean appOnly, boolean ignoreProjectConfigProcessFilter) {
        super(null, false);
        this.appOnly = appOnly;
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }

    @Override
    public boolean getAppOnly() {
        return appOnly;
    }

    @Override
    public void setAppOnly(boolean appOnly) {
        this.appOnly = appOnly;
    }

    @Override
    public boolean getIgnoreProjectConfigProcessFilter() {
        return ignoreProjectConfigProcessFilter;
    }

    @Override
    public void setIgnoreProjectConfigProcessFilter(boolean ignoreProjectConfigProcessFilter) {
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }
}