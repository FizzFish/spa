package cn.sast.api.incremental;

import cn.sast.common.IResource;
import org.jetbrains.annotations.NotNull;

public interface IncrementalAnalyze {
    void parseIncrementBaseFile(@NotNull IResource base);
}