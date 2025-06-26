/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.coverage.ClassSourceInfo
 *  cn.sast.framework.report.coverage.ClassSourceOfSCFactory
 *  cn.sast.framework.report.coverage.ClassSourceOfSCKey
 *  com.feysh.corax.cache.AnalysisKey
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.coverage;

import cn.sast.framework.report.coverage.ClassSourceInfo;
import cn.sast.framework.report.coverage.ClassSourceOfSCFactory;
import com.feysh.corax.cache.AnalysisKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"Lcn/sast/framework/report/coverage/ClassSourceOfSCKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lcn/sast/framework/report/coverage/ClassSourceInfo;", "className", "", "<init>", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "corax-framework"})
public final class ClassSourceOfSCKey
extends AnalysisKey<ClassSourceInfo> {
    @NotNull
    private final String className;

    public ClassSourceOfSCKey(@NotNull String className) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        super(ClassSourceOfSCFactory.INSTANCE.getKey());
        this.className = className;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String component1() {
        return this.className;
    }

    @NotNull
    public final ClassSourceOfSCKey copy(@NotNull String className) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        return new ClassSourceOfSCKey(className);
    }

    public static /* synthetic */ ClassSourceOfSCKey copy$default(ClassSourceOfSCKey classSourceOfSCKey, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = classSourceOfSCKey.className;
        }
        return classSourceOfSCKey.copy(string);
    }

    @NotNull
    public String toString() {
        return "ClassSourceOfSCKey(className=" + this.className + ")";
    }

    public int hashCode() {
        return this.className.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassSourceOfSCKey)) {
            return false;
        }
        ClassSourceOfSCKey classSourceOfSCKey = (ClassSourceOfSCKey)other;
        return Intrinsics.areEqual((Object)this.className, (Object)classSourceOfSCKey.className);
    }
}

