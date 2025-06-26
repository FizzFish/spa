/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.PreAnalysisAbsConfig
 *  cn.sast.framework.engine.PreAnalysisInvokeConfig
 *  com.feysh.corax.config.api.IPreAnalysisInvokeConfig
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package cn.sast.framework.engine;

import cn.sast.framework.engine.PreAnalysisAbsConfig;
import com.feysh.corax.config.api.IPreAnalysisInvokeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lcn/sast/framework/engine/PreAnalysisInvokeConfig;", "Lcn/sast/framework/engine/PreAnalysisAbsConfig;", "Lcom/feysh/corax/config/api/IPreAnalysisInvokeConfig;", "appOnly", "", "ignoreProjectConfigProcessFilter", "<init>", "(ZZ)V", "getAppOnly", "()Z", "setAppOnly", "(Z)V", "getIgnoreProjectConfigProcessFilter", "setIgnoreProjectConfigProcessFilter", "corax-framework"})
public final class PreAnalysisInvokeConfig
extends PreAnalysisAbsConfig
implements IPreAnalysisInvokeConfig {
    private boolean appOnly;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisInvokeConfig(boolean appOnly, boolean ignoreProjectConfigProcessFilter) {
        super(null, false, 3, null);
        this.appOnly = appOnly;
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }

    public /* synthetic */ PreAnalysisInvokeConfig(boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        this(bl, bl2);
    }

    public boolean getAppOnly() {
        return this.appOnly;
    }

    public void setAppOnly(boolean bl) {
        this.appOnly = bl;
    }

    public boolean getIgnoreProjectConfigProcessFilter() {
        return this.ignoreProjectConfigProcessFilter;
    }

    public void setIgnoreProjectConfigProcessFilter(boolean bl) {
        this.ignoreProjectConfigProcessFilter = bl;
    }

    public PreAnalysisInvokeConfig() {
        this(false, false, 3, null);
    }
}

