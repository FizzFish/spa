/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.AnalyzerEnv
 *  cn.sast.common.IResFile
 *  cn.sast.common.Resource
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api;

import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lcn/sast/api/AnalyzerEnv;", "", "<init>", "()V", "shouldV3r14y", "", "getShouldV3r14y", "()Z", "setShouldV3r14y", "(Z)V", "bvs1n3ss", "Ljava/util/concurrent/atomic/AtomicInteger;", "getBvs1n3ss", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setBvs1n3ss", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "lastLogFile", "Lcn/sast/common/IResFile;", "getLastLogFile", "()Lcn/sast/common/IResFile;", "corax-api"})
public final class AnalyzerEnv {
    @NotNull
    public static final AnalyzerEnv INSTANCE = new AnalyzerEnv();
    private static boolean shouldV3r14y = true;
    @NotNull
    private static AtomicInteger bvs1n3ss = new AtomicInteger(0);
    @NotNull
    private static final IResFile lastLogFile = Resource.INSTANCE.fileOf(System.getProperty("user.home") + File.separator + "logs" + File.separator + "corax" + File.separator + "last.log");

    private AnalyzerEnv() {
    }

    public final boolean getShouldV3r14y() {
        return shouldV3r14y;
    }

    public final void setShouldV3r14y(boolean bl) {
        shouldV3r14y = bl;
    }

    @NotNull
    public final AtomicInteger getBvs1n3ss() {
        return bvs1n3ss;
    }

    public final void setBvs1n3ss(@NotNull AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter((Object)atomicInteger, (String)"<set-?>");
        bvs1n3ss = atomicInteger;
    }

    @NotNull
    public final IResFile getLastLogFile() {
        return lastLogFile;
    }
}

