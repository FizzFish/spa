package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisFieldConfig;

public final class PreAnalysisFieldConfig extends PreAnalysisAbsConfig implements IPreAnalysisFieldConfig {
    private boolean appOnly;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisFieldConfig() {
        this(true, false);
    }

    public PreAnalysisFieldConfig(boolean appOnly, boolean ignoreProjectConfigProcessFilter) {
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