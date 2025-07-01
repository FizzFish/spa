package cn.sast.framework.engine;

import com.feysh.corax.config.api.IPreAnalysisFileConfig;

public final class PreAnalysisFileConfig extends PreAnalysisAbsConfig implements IPreAnalysisFileConfig {
    private boolean skipFilesInArchive;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisFileConfig() {
        this(false, false);
    }

    public PreAnalysisFileConfig(boolean skipFilesInArchive, boolean ignoreProjectConfigProcessFilter) {
        super(null, false);
        this.skipFilesInArchive = skipFilesInArchive;
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }

    public boolean getSkipFilesInArchive() {
        return skipFilesInArchive;
    }

    public void setSkipFilesInArchive(boolean skipFilesInArchive) {
        this.skipFilesInArchive = skipFilesInArchive;
    }

    public boolean getIgnoreProjectConfigProcessFilter() {
        return ignoreProjectConfigProcessFilter;
    }

    public void setIgnoreProjectConfigProcessFilter(boolean ignoreProjectConfigProcessFilter) {
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }
}