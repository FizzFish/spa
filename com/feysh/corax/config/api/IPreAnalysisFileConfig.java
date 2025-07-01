package com.feysh.corax.config.api;

public interface IPreAnalysisFileConfig extends IPreAnalysisConfig {
    boolean getSkipFilesInArchive();
    void setSkipFilesInArchive(boolean value);
}