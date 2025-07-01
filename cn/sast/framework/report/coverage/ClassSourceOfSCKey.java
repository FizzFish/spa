package cn.sast.framework.report.coverage;

import com.feysh.corax.cache.AnalysisKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassSourceOfSCKey extends AnalysisKey<ClassSourceInfo> {
    @NotNull
    private final String className;

    public ClassSourceOfSCKey(@NotNull String className) {
        super(ClassSourceOfSCFactory.INSTANCE.getKey());
        if (className == null) {
            throw new NullPointerException("className");
        }
        this.className = className;
    }

    @NotNull
    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "ClassSourceOfSCKey(className=" + className + ")";
    }

    @Override
    public int hashCode() {
        return className.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassSourceOfSCKey)) {
            return false;
        }
        ClassSourceOfSCKey that = (ClassSourceOfSCKey) other;
        return className.equals(that.className);
    }
}