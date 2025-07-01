package cn.sast.api.report;

import cn.sast.api.util.SootUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SourceLocator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public final class ClassResInfo implements IBugResInfo, Comparable<IBugResInfo> {
    @NotNull
    private final SootClass sc;
    private final int maxLine;
    @Nullable
    private final String sourcePath;
    @NotNull
    private final LinkedHashSet<String> sourceFile;

    public ClassResInfo(@NotNull SootClass sc) {
        Objects.requireNonNull(sc, "sc");
        this.sc = sc;
        this.maxLine = SootUtilsKt.getNumCode(sc);
        this.sourcePath = SootUtilsKt.getSourcePath(sc);
        this.sourceFile = SootUtilsKt.getPossibleSourceFiles(sc);
    }

    @NotNull
    public SootClass getSc() {
        return sc;
    }

    @NotNull
    public String getPath() {
        return sourceFile.iterator().next();
    }

    public int getMaxLine() {
        return maxLine;
    }

    @Nullable
    public String getSourcePath() {
        return sourcePath;
    }

    @NotNull
    public LinkedHashSet<String> getSourceFile() {
        return sourceFile;
    }

    @NotNull
    public String getReportFileName() {
        if (sourcePath == null) {
            return SourceLocator.v().getSourceForClass(sc.getShortJavaStyleName()) + ".java";
        }
        String[] parts = sourcePath.split("/");
        return parts.length > 0 ? parts[parts.length - 1] : 
               SourceLocator.v().getSourceForClass(sc.getShortJavaStyleName()) + ".java";
    }

    @Override
    public int compareTo(@NotNull IBugResInfo other) {
        Objects.requireNonNull(other, "other");
        if (!(other instanceof ClassResInfo)) {
            return getClass().getSimpleName().compareTo(other.getClass().getSimpleName());
        }
        int nameComparison = sc.getName().compareTo(((ClassResInfo) other).sc.getName());
        return nameComparison != 0 ? nameComparison : 0;
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Objects.requireNonNull(c, "c");
        return c.from(sc);
    }

    @Override
    public String toString() {
        return "ClassResInfo(sc=" + sc + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ClassResInfo)) return false;
        ClassResInfo that = (ClassResInfo) other;
        return sc.equals(that.sc);
    }

    @Override
    public int hashCode() {
        return sc.hashCode();
    }
}