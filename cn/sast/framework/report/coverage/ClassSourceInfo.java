package cn.sast.framework.report.coverage;

import cn.sast.common.IResFile;
import org.jacoco.core.internal.data.CRC64;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class ClassSourceInfo {
    @NotNull
    private final String className;
    @NotNull
    private final byte[] byteArray;
    @Nullable
    private final IResFile classSource;
    private final long jacocoClassId;

    public ClassSourceInfo(@NotNull String className, @NotNull byte[] byteArray, @Nullable IResFile classSource) {
        Objects.requireNonNull(className, "className");
        Objects.requireNonNull(byteArray, "byteArray");
        this.className = className;
        this.byteArray = byteArray;
        this.classSource = classSource;
        this.jacocoClassId = CRC64.classId(byteArray);
    }

    @NotNull
    public String getClassName() {
        return className;
    }

    @NotNull
    public byte[] getByteArray() {
        return byteArray;
    }

    @Nullable
    public IResFile getClassSource() {
        return classSource;
    }

    public long getJacocoClassId() {
        return jacocoClassId;
    }
}