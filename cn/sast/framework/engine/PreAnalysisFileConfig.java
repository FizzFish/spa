/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.PreAnalysisAbsConfig
 *  cn.sast.framework.engine.PreAnalysisFileConfig
 *  com.feysh.corax.config.api.IPreAnalysisFileConfig
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package cn.sast.framework.engine;

import cn.sast.framework.engine.PreAnalysisAbsConfig;
import com.feysh.corax.config.api.IPreAnalysisFileConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lcn/sast/framework/engine/PreAnalysisFileConfig;", "Lcn/sast/framework/engine/PreAnalysisAbsConfig;", "Lcom/feysh/corax/config/api/IPreAnalysisFileConfig;", "skipFilesInArchive", "", "ignoreProjectConfigProcessFilter", "<init>", "(ZZ)V", "getSkipFilesInArchive", "()Z", "setSkipFilesInArchive", "(Z)V", "getIgnoreProjectConfigProcessFilter", "setIgnoreProjectConfigProcessFilter", "corax-framework"})
public final class PreAnalysisFileConfig
extends PreAnalysisAbsConfig
implements IPreAnalysisFileConfig {
    private boolean skipFilesInArchive;
    private boolean ignoreProjectConfigProcessFilter;

    public PreAnalysisFileConfig(boolean skipFilesInArchive, boolean ignoreProjectConfigProcessFilter) {
        super(null, false, 3, null);
        this.skipFilesInArchive = skipFilesInArchive;
        this.ignoreProjectConfigProcessFilter = ignoreProjectConfigProcessFilter;
    }

    public /* synthetic */ PreAnalysisFileConfig(boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        this(bl, bl2);
    }

    public boolean getSkipFilesInArchive() {
        return this.skipFilesInArchive;
    }

    public void setSkipFilesInArchive(boolean bl) {
        this.skipFilesInArchive = bl;
    }

    public boolean getIgnoreProjectConfigProcessFilter() {
        return this.ignoreProjectConfigProcessFilter;
    }

    public void setIgnoreProjectConfigProcessFilter(boolean bl) {
        this.ignoreProjectConfigProcessFilter = bl;
    }

    public PreAnalysisFileConfig() {
        this(false, false, 3, null);
    }
}

