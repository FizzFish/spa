package cn.sast.framework.report.coverage;

import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.FileIndexerBuilder;
import org.jacoco.core.internal.analysis.CounterImpl;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class SourceCoverage {
    private static final Logger logger = LoggerFactory.getLogger(SourceCoverage.class);
    private final Map<String, JavaSourceCoverage> sourceCoverage;

    public SourceCoverage(@NotNull Map<String, JavaSourceCoverage> sourceCoverage) {
        if (sourceCoverage == null) {
            throw new IllegalArgumentException("sourceCoverage cannot be null");
        }
        this.sourceCoverage = sourceCoverage;
    }

    @NotNull
    public Map<String, JavaSourceCoverage> getSourceCoverage() {
        return sourceCoverage;
    }

    @NotNull
    public CounterImpl calculateCoveredRatio(@NotNull Set<? extends IResFile> targetSources) {
        if (targetSources == null) {
            throw new IllegalArgumentException("targetSources cannot be null");
        }

        int allLineCount = 0;
        int missedCount = 0;
        
        FileIndexerBuilder fileIndexerBuilder = new FileIndexerBuilder();
        for (IResFile source : targetSources) {
            fileIndexerBuilder.addIndexMap(source);
        }
        
        FileIndexer fileIndexer = fileIndexerBuilder.build();
        Map<Pair<String, JavaSourceCoverage>, IResFile> sourceMap = new LinkedHashMap<>();
        
        for (Map.Entry<String, JavaSourceCoverage> entry : sourceCoverage.entrySet()) {
            String key = entry.getKey();
            IResFile file = fileIndexer.findFromFileIndexMap(key.split("[/\\\\]"), 
                AbstractFileIndexer.getDefaultClassCompareMode()).stream()
                .findFirst()
                .orElse(null);
            sourceMap.put(new Pair<>(key, entry.getValue()), file);
        }
        
        for (Map.Entry<Pair<String, JavaSourceCoverage>, IResFile> entry : sourceMap.entrySet()) {
            JavaSourceCoverage coverage = entry.getKey().getSecond();
            allLineCount += coverage.getLineCount();
            int missed = coverage.getSourceCoverage().getLineCounter().getMissedCount();
            missedCount += Math.min(missed, coverage.getLineCount());
        }
        
        Set<IResFile> missSource = targetSources;
        missSource.removeAll(sourceMap.values());
        
        for (IResFile source : missSource) {
            int lineCount;
            try {
                lineCount = ResourceKt.readText(source).lines().count();
            } catch (Exception e) {
                logger.error("File {} cannot be read!", source, e);
                lineCount = 0;
            }
            allLineCount += lineCount;
            missedCount += lineCount;
        }
        
        return CounterImpl.getInstance(missedCount, allLineCount - missedCount);
    }

    public static final class JavaSourceCoverage {
        // Implementation omitted for brevity
    }

    private static class Pair<K, V> {
        private final K first;
        private final V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}