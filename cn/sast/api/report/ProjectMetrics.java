package cn.sast.api.report;

import cn.sast.common.OS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class ProjectMetrics {
    @Nullable
    private List<String> command;
    @NotNull
    private List<String> paths;
    private int applicationClasses;
    private int libraryClasses;
    private int phantomClasses;
    private int applicationMethods;
    private int libraryMethods;
    private int applicationMethodsHaveBody;
    private float applicationMethodsHaveBodyRatio;
    private int libraryMethodsHaveBody;
    private float libraryMethodsHaveBodyRatio;
    private int analyzedFiles;
    private int appJavaFileCount;
    private int appJavaLineCount;
    private long totalFileNum;
    private long totalAnySourceFileNum;
    private long totalSourceFileNum;
    private int _analyzedClasses;
    private int _analyzedMethodEntries;
    private int _analyzedApplicationMethods;
    private float analyzedApplicationMethodsRatio;
    private int _analyzedLibraryMethods;
    private float analyzedLibraryMethodsRatio;
    private int serializedReports;
    @NotNull
    private final Set<String> analyzedClasses;
    @NotNull
    private final Set<String> analyzedMethodEntries;
    @NotNull
    private final Set<String> analyzedApplicationMethods;
    @NotNull
    private final Set<String> analyzedLibraryMethods;

    public ProjectMetrics(@Nullable List<String> command, @NotNull List<String> paths, int applicationClasses, 
            int libraryClasses, int phantomClasses, int applicationMethods, int libraryMethods, 
            int applicationMethodsHaveBody, float applicationMethodsHaveBodyRatio, int libraryMethodsHaveBody,
            float libraryMethodsHaveBodyRatio, int analyzedFiles, int appJavaFileCount, int appJavaLineCount,
            long totalFileNum, long totalAnySourceFileNum, long totalSourceFileNum, int _analyzedClasses,
            int _analyzedMethodEntries, int _analyzedApplicationMethods, float analyzedApplicationMethodsRatio,
            int _analyzedLibraryMethods, float analyzedLibraryMethodsRatio, int serializedReports) {
        if (paths == null) {
            throw new IllegalArgumentException("paths cannot be null");
        }
        this.command = command;
        this.paths = paths;
        this.applicationClasses = applicationClasses;
        this.libraryClasses = libraryClasses;
        this.phantomClasses = phantomClasses;
        this.applicationMethods = applicationMethods;
        this.libraryMethods = libraryMethods;
        this.applicationMethodsHaveBody = applicationMethodsHaveBody;
        this.applicationMethodsHaveBodyRatio = applicationMethodsHaveBodyRatio;
        this.libraryMethodsHaveBody = libraryMethodsHaveBody;
        this.libraryMethodsHaveBodyRatio = libraryMethodsHaveBodyRatio;
        this.analyzedFiles = analyzedFiles;
        this.appJavaFileCount = appJavaFileCount;
        this.appJavaLineCount = appJavaLineCount;
        this.totalFileNum = totalFileNum;
        this.totalAnySourceFileNum = totalAnySourceFileNum;
        this.totalSourceFileNum = totalSourceFileNum;
        this._analyzedClasses = _analyzedClasses;
        this._analyzedMethodEntries = _analyzedMethodEntries;
        this._analyzedApplicationMethods = _analyzedApplicationMethods;
        this.analyzedApplicationMethodsRatio = analyzedApplicationMethodsRatio;
        this._analyzedLibraryMethods = _analyzedLibraryMethods;
        this.analyzedLibraryMethodsRatio = analyzedLibraryMethodsRatio;
        this.serializedReports = serializedReports;
        this.analyzedClasses = Collections.synchronizedSet(new LinkedHashSet<>());
        this.analyzedMethodEntries = Collections.synchronizedSet(new LinkedHashSet<>());
        this.analyzedApplicationMethods = Collections.synchronizedSet(new LinkedHashSet<>());
        this.analyzedLibraryMethods = Collections.synchronizedSet(new LinkedHashSet<>());
    }

    public ProjectMetrics() {
        this(null, new ArrayList<>(), -1, -1, -1, -1, -1, -1, -1.0f, -1, -1.0f, -1, -1, -1, -1L, -1L, -1L, -1, -1, -1, -1.0f, -1, -1.0f, -1);
    }

    @Nullable
    public List<String> getCommand() {
        return command;
    }

    public void setCommand(@Nullable List<String> command) {
        this.command = command;
    }

    @NotNull
    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(@NotNull List<String> paths) {
        if (paths == null) {
            throw new IllegalArgumentException("paths cannot be null");
        }
        this.paths = paths;
    }

    public int getApplicationClasses() {
        return applicationClasses;
    }

    public void setApplicationClasses(int applicationClasses) {
        this.applicationClasses = applicationClasses;
    }

    public int getLibraryClasses() {
        return libraryClasses;
    }

    public void setLibraryClasses(int libraryClasses) {
        this.libraryClasses = libraryClasses;
    }

    public int getPhantomClasses() {
        return phantomClasses;
    }

    public void setPhantomClasses(int phantomClasses) {
        this.phantomClasses = phantomClasses;
    }

    public int getApplicationMethods() {
        return applicationMethods;
    }

    public void setApplicationMethods(int applicationMethods) {
        this.applicationMethods = applicationMethods;
    }

    public int getLibraryMethods() {
        return libraryMethods;
    }

    public void setLibraryMethods(int libraryMethods) {
        this.libraryMethods = libraryMethods;
    }

    public int getApplicationMethodsHaveBody() {
        return applicationMethodsHaveBody;
    }

    public void setApplicationMethodsHaveBody(int applicationMethodsHaveBody) {
        this.applicationMethodsHaveBody = applicationMethodsHaveBody;
    }

    public int getLibraryMethodsHaveBody() {
        return libraryMethodsHaveBody;
    }

    public void setLibraryMethodsHaveBody(int libraryMethodsHaveBody) {
        this.libraryMethodsHaveBody = libraryMethodsHaveBody;
    }

    public int getAnalyzedFiles() {
        return analyzedFiles;
    }

    public void setAnalyzedFiles(int analyzedFiles) {
        this.analyzedFiles = analyzedFiles;
    }

    public int getAppJavaFileCount() {
        return appJavaFileCount;
    }

    public void setAppJavaFileCount(int appJavaFileCount) {
        this.appJavaFileCount = appJavaFileCount;
    }

    public int getAppJavaLineCount() {
        return appJavaLineCount;
    }

    public void setAppJavaLineCount(int appJavaLineCount) {
        this.appJavaLineCount = appJavaLineCount;
    }

    public long getTotalFileNum() {
        return totalFileNum;
    }

    public void setTotalFileNum(long totalFileNum) {
        this.totalFileNum = totalFileNum;
    }

    public long getTotalAnySourceFileNum() {
        return totalAnySourceFileNum;
    }

    public void setTotalAnySourceFileNum(long totalAnySourceFileNum) {
        this.totalAnySourceFileNum = totalAnySourceFileNum;
    }

    public long getTotalSourceFileNum() {
        return totalSourceFileNum;
    }

    public void setTotalSourceFileNum(long totalSourceFileNum) {
        this.totalSourceFileNum = totalSourceFileNum;
    }

    public int getSerializedReports() {
        return serializedReports;
    }

    public void setSerializedReports(int serializedReports) {
        this.serializedReports = serializedReports;
    }

    @NotNull
    public Set<String> getAnalyzedClasses() {
        return analyzedClasses;
    }

    @NotNull
    public Set<String> getAnalyzedMethodEntries() {
        return analyzedMethodEntries;
    }

    @NotNull
    public Set<String> getAnalyzedApplicationMethods() {
        return analyzedApplicationMethods;
    }

    @NotNull
    public Set<String> getAnalyzedLibraryMethods() {
        return analyzedLibraryMethods;
    }

    public void process() {
        _analyzedClasses = analyzedClasses.size();
        _analyzedApplicationMethods = analyzedApplicationMethods.size();
        _analyzedLibraryMethods = analyzedLibraryMethods.size();
        _analyzedMethodEntries = analyzedMethodEntries.size();
        
        if (applicationMethods != 0) {
            applicationMethodsHaveBodyRatio = (float) applicationMethodsHaveBody / applicationMethods;
            analyzedApplicationMethodsRatio = (float) _analyzedApplicationMethods / applicationMethods;
        }
        
        if (libraryMethods != 0) {
            libraryMethodsHaveBodyRatio = (float) libraryMethodsHaveBody / libraryMethods;
            analyzedLibraryMethodsRatio = (float) _analyzedLibraryMethods / libraryMethods;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectMetrics)) return false;
        
        ProjectMetrics that = (ProjectMetrics) o;
        
        if (applicationClasses != that.applicationClasses) return false;
        if (libraryClasses != that.libraryClasses) return false;
        if (phantomClasses != that.phantomClasses) return false;
        if (applicationMethods != that.applicationMethods) return false;
        if (libraryMethods != that.libraryMethods) return false;
        if (applicationMethodsHaveBody != that.applicationMethodsHaveBody) return false;
        if (Float.compare(that.applicationMethodsHaveBodyRatio, applicationMethodsHaveBodyRatio) != 0) return false;
        if (libraryMethodsHaveBody != that.libraryMethodsHaveBody) return false;
        if (Float.compare(that.libraryMethodsHaveBodyRatio, libraryMethodsHaveBodyRatio) != 0) return false;
        if (analyzedFiles != that.analyzedFiles) return false;
        if (appJavaFileCount != that.appJavaFileCount) return false;
        if (appJavaLineCount != that.appJavaLineCount) return false;
        if (totalFileNum != that.totalFileNum) return false;
        if (totalAnySourceFileNum != that.totalAnySourceFileNum) return false;
        if (totalSourceFileNum != that.totalSourceFileNum) return false;
        if (_analyzedClasses != that._analyzedClasses) return false;
        if (_analyzedMethodEntries != that._analyzedMethodEntries) return false;
        if (_analyzedApplicationMethods != that._analyzedApplicationMethods) return false;
        if (Float.compare(that.analyzedApplicationMethodsRatio, analyzedApplicationMethodsRatio) != 0) return false;
        if (_analyzedLibraryMethods != that._analyzedLibraryMethods) return false;
        if (Float.compare(that.analyzedLibraryMethodsRatio, analyzedLibraryMethodsRatio) != 0) return false;
        if (serializedReports != that.serializedReports) return false;
        if (command != null ? !command.equals(that.command) : that.command != null) return false;
        return paths.equals(that.paths);
    }

    @Override
    public int hashCode() {
        int result = command != null ? command.hashCode() : 0;
        result = 31 * result + paths.hashCode();
        result = 31 * result + applicationClasses;
        result = 31 * result + libraryClasses;
        result = 31 * result + phantomClasses;
        result = 31 * result + applicationMethods;
        result = 31 * result + libraryMethods;
        result = 31 * result + applicationMethodsHaveBody;
        result = 31 * result + (applicationMethodsHaveBodyRatio != 0.0f ? Float.floatToIntBits(applicationMethodsHaveBodyRatio) : 0);
        result = 31 * result + libraryMethodsHaveBody;
        result = 31 * result + (libraryMethodsHaveBodyRatio != 0.0f ? Float.floatToIntBits(libraryMethodsHaveBodyRatio) : 0);
        result = 31 * result + analyzedFiles;
        result = 31 * result + appJavaFileCount;
        result = 31 * result + appJavaLineCount;
        result = 31 * result + (int) (totalFileNum ^ (totalFileNum >>> 32));
        result = 31 * result + (int) (totalAnySourceFileNum ^ (totalAnySourceFileNum >>> 32));
        result = 31 * result + (int) (totalSourceFileNum ^ (totalSourceFileNum >>> 32));
        result = 31 * result + _analyzedClasses;
        result = 31 * result + _analyzedMethodEntries;
        result = 31 * result + _analyzedApplicationMethods;
        result = 31 * result + (analyzedApplicationMethodsRatio != 0.0f ? Float.floatToIntBits(analyzedApplicationMethodsRatio) : 0);
        result = 31 * result + _analyzedLibraryMethods;
        result = 31 * result + (analyzedLibraryMethodsRatio != 0.0f ? Float.floatToIntBits(analyzedLibraryMethodsRatio) : 0);
        result = 31 * result + serializedReports;
        return result;
    }

    @Override
    public String toString() {
        return "ProjectMetrics{" +
                "command=" + command +
                ", paths=" + paths +
                ", applicationClasses=" + applicationClasses +
                ", libraryClasses=" + libraryClasses +
                ", phantomClasses=" + phantomClasses +
                ", applicationMethods=" + applicationMethods +
                ", libraryMethods=" + libraryMethods +
                ", applicationMethodsHaveBody=" + applicationMethodsHaveBody +
                ", applicationMethodsHaveBodyRatio=" + applicationMethodsHaveBodyRatio +
                ", libraryMethodsHaveBody=" + libraryMethodsHaveBody +
                ", libraryMethodsHaveBodyRatio=" + libraryMethodsHaveBodyRatio +
                ", analyzedFiles=" + analyzedFiles +
                ", appJavaFileCount=" + appJavaFileCount +
                ", appJavaLineCount=" + appJavaLineCount +
                ", totalFileNum=" + totalFileNum +
                ", totalAnySourceFileNum=" + totalAnySourceFileNum +
                ", totalSourceFileNum=" + totalSourceFileNum +
                ", _analyzedClasses=" + _analyzedClasses +
                ", _analyzedMethodEntries=" + _analyzedMethodEntries +
                ", _analyzedApplicationMethods=" + _analyzedApplicationMethods +
                ", analyzedApplicationMethodsRatio=" + analyzedApplicationMethodsRatio +
                ", _analyzedLibraryMethods=" + _analyzedLibraryMethods +
                ", analyzedLibraryMethodsRatio=" + analyzedLibraryMethodsRatio +
                ", serializedReports=" + serializedReports +
                '}';
    }
}
