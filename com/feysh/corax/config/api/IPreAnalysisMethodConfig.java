/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IPreAnalysisConfig;
import kotlin.Metadata;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/IPreAnalysisMethodConfig;", "Lcom/feysh/corax/config/api/IPreAnalysisConfig;", "appOnly", "", "getAppOnly", "()Z", "setAppOnly", "(Z)V", "corax-config-api"})
public interface IPreAnalysisMethodConfig
extends IPreAnalysisConfig {
    public boolean getAppOnly();

    public void setAppOnly(boolean var1);
}

