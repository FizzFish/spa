/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.coverage.ClassSourceInfo
 *  cn.sast.framework.report.coverage.ClassSourceInfo$Companion
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jacoco.core.internal.data.CRC64
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.coverage;

import cn.sast.common.IResFile;
import cn.sast.framework.report.coverage.ClassSourceInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.core.internal.data.CRC64;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2={"Lcn/sast/framework/report/coverage/ClassSourceInfo;", "", "className", "", "byteArray", "", "classSource", "Lcn/sast/common/IResFile;", "<init>", "(Ljava/lang/String;[BLcn/sast/common/IResFile;)V", "getClassName", "()Ljava/lang/String;", "getByteArray", "()[B", "getClassSource", "()Lcn/sast/common/IResFile;", "jacocoClassId", "", "getJacocoClassId", "()J", "jacocoClassId$delegate", "Lkotlin/Lazy;", "Companion", "corax-framework"})
public final class ClassSourceInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String className;
    @NotNull
    private final byte[] byteArray;
    @Nullable
    private final IResFile classSource;
    @NotNull
    private final Lazy jacocoClassId$delegate;

    public ClassSourceInfo(@NotNull String className, @NotNull byte[] byteArray, @Nullable IResFile classSource) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        Intrinsics.checkNotNullParameter((Object)byteArray, (String)"byteArray");
        this.className = className;
        this.byteArray = byteArray;
        this.classSource = classSource;
        this.jacocoClassId$delegate = LazyKt.lazy(() -> ClassSourceInfo.jacocoClassId_delegate$lambda$0(this));
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final byte[] getByteArray() {
        return this.byteArray;
    }

    @Nullable
    public final IResFile getClassSource() {
        return this.classSource;
    }

    public final long getJacocoClassId() {
        Lazy lazy = this.jacocoClassId$delegate;
        return ((Number)lazy.getValue()).longValue();
    }

    private static final long jacocoClassId_delegate$lambda$0(ClassSourceInfo this$0) {
        return CRC64.classId((byte[])this$0.byteArray);
    }
}

