package cn.sast.api.report;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import java.nio.charset.Charset;
import java.util.Set;
import org.jacoco.core.analysis.ICounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ICoverageCollector {
    boolean getEnableCoveredTaint();

    void cover(@NotNull CoverData coverInfo);

    @Nullable
    Object flush(@NotNull IResDirectory output, @NotNull Charset sourceEncoding, 
                 @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object getCoveredLineCounter(@NotNull Set<? extends IResFile> allSourceFiles, 
                                @NotNull Charset encoding, 
                                @NotNull Continuation<? super ICounter> continuation);
}