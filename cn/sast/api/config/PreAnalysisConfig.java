package cn.sast.api.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PreAnalysisConfig {
    private static final Map<String, Integer> DEFAULT_EXTENSION_MAP = createDefaultExtensionMap();
    
    private final int cancelAnalysisInErrorCount;
    private final int largeFileSize;
    private final int largeFileSemaphorePermits;
    private final Map<String, Integer> fileExtensionToSizeThreshold;
    private final int maximumFileSizeThresholdWarnings;

    public PreAnalysisConfig() {
        this(10, 512000, 3, DEFAULT_EXTENSION_MAP, 20);
    }

    public PreAnalysisConfig(int cancelAnalysisInErrorCount, int largeFileSize, int largeFileSemaphorePermits, 
                           @NotNull Map<String, Integer> fileExtensionToSizeThreshold, int maximumFileSizeThresholdWarnings) {
        this.cancelAnalysisInErrorCount = cancelAnalysisInErrorCount;
        this.largeFileSize = largeFileSize;
        this.largeFileSemaphorePermits = largeFileSemaphorePermits;
        this.maximumFileSizeThresholdWarnings = maximumFileSizeThresholdWarnings;
        this.fileExtensionToSizeThreshold = expandExtensionMap(fileExtensionToSizeThreshold);
    }

    private static Map<String, Integer> createDefaultExtensionMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(String.join(",", ResourceKt.getJavaExtensions()), 0x100000);
        map.put(String.join(",", ResourceImplKt.getZipExtensions()), -1);
        map.put(String.join(",", List.of("html", "htm", "adoc", "gradle", "properties", "config", 
                "cnf", "txt", "json", "xml", "yml", "yaml", "toml", "ini")), 0x500000);
        map.put("*", 0x500000);
        return map;
    }

    private static Map<String, Integer> expandExtensionMap(Map<String, Integer> input) {
        Map<String, Integer> result = new HashMap<>();
        for (Entry<String, Integer> entry : input.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (key.contains(",")) {
                for (String ext : key.split(",")) {
                    result.put(ext.trim(), value);
                }
            } else {
                result.put(key, value);
            }
        }
        return result;
    }

    public int getCancelAnalysisInErrorCount() {
        return cancelAnalysisInErrorCount;
    }

    public int getLargeFileSize() {
        return largeFileSize;
    }

    public int getLargeFileSemaphorePermits() {
        return largeFileSemaphorePermits;
    }

    public int getMaximumFileSizeThresholdWarnings() {
        return maximumFileSizeThresholdWarnings;
    }

    @Nullable
    public Integer getSizeThreshold(@NotNull String extension) {
        Integer threshold = fileExtensionToSizeThreshold.get(extension);
        if (threshold == null) {
            threshold = fileExtensionToSizeThreshold.get("*");
        }
        return threshold != null && threshold > 0 ? threshold : null;
    }

    public boolean fileSizeThresholdExceeded(@NotNull String extension, long fileSize) {
        Integer threshold = getSizeThreshold(extension);
        return threshold != null && fileSize > threshold;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof PreAnalysisConfig)) return false;
        PreAnalysisConfig that = (PreAnalysisConfig) other;
        return cancelAnalysisInErrorCount == that.cancelAnalysisInErrorCount &&
               largeFileSize == that.largeFileSize &&
               largeFileSemaphorePermits == that.largeFileSemaphorePermits &&
               maximumFileSizeThresholdWarnings == that.maximumFileSizeThresholdWarnings &&
               fileExtensionToSizeThreshold.equals(that.fileExtensionToSizeThreshold);
    }

    @Override
    public int hashCode() {
        int result = cancelAnalysisInErrorCount;
        result = 31 * result + largeFileSize;
        result = 31 * result + largeFileSemaphorePermits;
        result = 31 * result + fileExtensionToSizeThreshold.hashCode();
        result = 31 * result + maximumFileSizeThresholdWarnings;
        return result;
    }

    @Override
    public String toString() {
        return "PreAnalysisConfig(cancelAnalysisInErrorCount=" + cancelAnalysisInErrorCount +
               ", largeFileSize=" + largeFileSize +
               ", largeFileSemaphorePermits=" + largeFileSemaphorePermits +
               ", fileExtensionToSizeThreshold=" + fileExtensionToSizeThreshold +
               ", maximumFileSizeThresholdWarnings=" + maximumFileSizeThresholdWarnings + ")";
    }
}
