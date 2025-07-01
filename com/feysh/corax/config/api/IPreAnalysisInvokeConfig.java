package com.feysh.corax.config.api;

public interface IPreAnalysisInvokeConfig extends IPreAnalysisConfig {
    boolean getAppOnly();
    void setAppOnly(boolean value);
}