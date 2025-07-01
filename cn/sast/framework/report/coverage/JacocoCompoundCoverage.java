package cn.sast.framework.report.coverage;

import cn.sast.api.report.CoverData;
import cn.sast.api.report.CoverInst;
import cn.sast.api.report.CoverTaint;
import cn.sast.api.report.ICoverageCollector;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import org.jacoco.core.analysis.ICounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class JacocoCompoundCoverage implements ICoverageCollector {
    @NotNull
    private final IProjectFileLocator locator;
    @NotNull
    private final Coverage taintCoverage;
    @NotNull
    private final Coverage executionCoverage;
    private final boolean enableCoveredTaint;

    public JacocoCompoundCoverage(@NotNull IProjectFileLocator locator, 
                                 @NotNull Coverage taintCoverage,
                                 @NotNull Coverage executionCoverage,
                                 boolean enableCoveredTaint) {
        if (locator == null) throw new IllegalArgumentException("locator cannot be null");
        if (taintCoverage == null) throw new IllegalArgumentException("taintCoverage cannot be null");
        if (executionCoverage == null) throw new IllegalArgumentException("executionCoverage cannot be null");
        
        this.locator = locator;
        this.taintCoverage = taintCoverage;
        this.executionCoverage = executionCoverage;
        this.enableCoveredTaint = enableCoveredTaint;
    }

    public JacocoCompoundCoverage(@NotNull IProjectFileLocator locator) {
        this(locator, new TaintCoverage(), new Coverage(), false);
    }

    public boolean getEnableCoveredTaint() {
        return enableCoveredTaint;
    }

    @Override
    public void cover(@NotNull CoverData coverInfo) {
        if (coverInfo == null) throw new IllegalArgumentException("coverInfo cannot be null");
        
        if (coverInfo instanceof CoverTaint) {
            CoverTaint taint = (CoverTaint) coverInfo;
            taintCoverage.coverByQueue(taint.getClassName(), taint.getLineNumber());
        } else if (coverInfo instanceof CoverInst) {
            CoverInst inst = (CoverInst) coverInfo;
            executionCoverage.coverByQueue(inst.getClassName(), inst.getLineNumber());
        } else {
            throw new IllegalArgumentException("Unknown CoverData type");
        }
    }

    @Override
    public CompletableFuture<Void> flush(@NotNull IResDirectory output, @NotNull Charset sourceEncoding) {
        if (output == null) throw new IllegalArgumentException("output cannot be null");
        if (sourceEncoding == null) throw new IllegalArgumentException("sourceEncoding cannot be null");
        
        return CompletableFuture.allOf(
            taintCoverage.flushCoverage(locator, output, sourceEncoding).toCompletableFuture(),
            executionCoverage.flushCoverage(locator, output, sourceEncoding).toCompletableFuture()
        );
    }

    @Override
    public CompletableFuture<ICounter> getCoveredLineCounter(@NotNull Set<? extends IResFile> allSourceFiles, 
                                                           @NotNull Charset encoding) {
        if (allSourceFiles == null) throw new IllegalArgumentException("allSourceFiles cannot be null");
        if (encoding == null) throw new IllegalArgumentException("encoding cannot be null");
        
        return executionCoverage.calculateSourceCoverage(locator, encoding)
            .thenApply(sourceCoverage -> sourceCoverage.calculateCoveredRatio(allSourceFiles))
            .toCompletableFuture();
    }

    @NotNull
    public JacocoCompoundCoverage copy(@NotNull IProjectFileLocator locator,
                                      @NotNull Coverage taintCoverage,
                                      @NotNull Coverage executionCoverage,
                                      boolean enableCoveredTaint) {
        if (locator == null) throw new IllegalArgumentException("locator cannot be null");
        if (taintCoverage == null) throw new IllegalArgumentException("taintCoverage cannot be null");
        if (executionCoverage == null) throw new IllegalArgumentException("executionCoverage cannot be null");
        
        return new JacocoCompoundCoverage(locator, taintCoverage, executionCoverage, enableCoveredTaint);
    }
}
