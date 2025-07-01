package cn.sast.api.config;

import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public final class BuiltinAnalysisConfig {
    private static final List<String> DEFAULT_SOOT_PATTERNS = List.of(
        "<.*: void start\\(.*BundleContext\\)>",
        "<.*: void stop\\(.*BundleContext\\)>",
        "<.*\\.R(\\$.*)?: .*>"
    );
    private static final List<String> DEFAULT_METHOD_SIGS = List.of(
        "org.osgi.framework.BundleActivator: void start(BundleContext context)",
        "org.osgi.framework.BundleActivator: void stop(BundleContext context)"
    );
    private static final int DEFAULT_MAX_FIELD_REPORTS = 10;
    private static final int DEFAULT_MAX_METHOD_REPORTS = 40;

    @NotNull
    private final List<String> unusedDetectorSootSigPatternBlackList;
    @NotNull
    private final List<String> unusedDetectorMethodSigBlackList;
    private final int maximumUnusedFieldReportsEachClass;
    private final int maximumUnusedMethodReportsEachClass;

    public BuiltinAnalysisConfig(
        @NotNull List<String> unusedDetectorSootSigPatternBlackList,
        @NotNull List<String> unusedDetectorMethodSigBlackList,
        int maximumUnusedFieldReportsEachClass,
        int maximumUnusedMethodReportsEachClass
    ) {
        this.unusedDetectorSootSigPatternBlackList = Objects.requireNonNull(
            unusedDetectorSootSigPatternBlackList, 
            "unusedDetectorSootSigPatternBlackList"
        );
        this.unusedDetectorMethodSigBlackList = Objects.requireNonNull(
            unusedDetectorMethodSigBlackList,
            "unusedDetectorMethodSigBlackList"
        );
        this.maximumUnusedFieldReportsEachClass = maximumUnusedFieldReportsEachClass;
        this.maximumUnusedMethodReportsEachClass = maximumUnusedMethodReportsEachClass;
    }

    public BuiltinAnalysisConfig() {
        this(DEFAULT_SOOT_PATTERNS, DEFAULT_METHOD_SIGS, DEFAULT_MAX_FIELD_REPORTS, DEFAULT_MAX_METHOD_REPORTS);
    }

    @NotNull
    public List<String> getUnusedDetectorSootSigPatternBlackList() {
        return unusedDetectorSootSigPatternBlackList;
    }

    @NotNull
    public List<String> getUnusedDetectorMethodSigBlackList() {
        return unusedDetectorMethodSigBlackList;
    }

    public int getMaximumUnusedFieldReportsEachClass() {
        return maximumUnusedFieldReportsEachClass;
    }

    public int getMaximumUnusedMethodReportsEachClass() {
        return maximumUnusedMethodReportsEachClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuiltinAnalysisConfig)) return false;
        BuiltinAnalysisConfig that = (BuiltinAnalysisConfig) o;
        return maximumUnusedFieldReportsEachClass == that.maximumUnusedFieldReportsEachClass &&
            maximumUnusedMethodReportsEachClass == that.maximumUnusedMethodReportsEachClass &&
            unusedDetectorSootSigPatternBlackList.equals(that.unusedDetectorSootSigPatternBlackList) &&
            unusedDetectorMethodSigBlackList.equals(that.unusedDetectorMethodSigBlackList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            unusedDetectorSootSigPatternBlackList,
            unusedDetectorMethodSigBlackList,
            maximumUnusedFieldReportsEachClass,
            maximumUnusedMethodReportsEachClass
        );
    }

    @Override
    public String toString() {
        return "BuiltinAnalysisConfig(" +
            "unusedDetectorSootSigPatternBlackList=" + unusedDetectorSootSigPatternBlackList +
            ", unusedDetectorMethodSigBlackList=" + unusedDetectorMethodSigBlackList +
            ", maximumUnusedFieldReportsEachClass=" + maximumUnusedFieldReportsEachClass +
            ", maximumUnusedMethodReportsEachClass=" + maximumUnusedMethodReportsEachClass +
            ')';
    }

    public BuiltinAnalysisConfig copy(
        @NotNull List<String> unusedDetectorSootSigPatternBlackList,
        @NotNull List<String> unusedDetectorMethodSigBlackList,
        int maximumUnusedFieldReportsEachClass,
        int maximumUnusedMethodReportsEachClass
    ) {
        return new BuiltinAnalysisConfig(
            unusedDetectorSootSigPatternBlackList,
            unusedDetectorMethodSigBlackList,
            maximumUnusedFieldReportsEachClass,
            maximumUnusedMethodReportsEachClass
        );
    }
}