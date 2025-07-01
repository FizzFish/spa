/*
 * Copyright (c) 2022, Example Corp.
 */
package cn.sast.framework.entries;

import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

public interface IEntryPointProvider {

    @NotNull
    Flow<AnalyzeTask> getIterator();

    default void startAnalyse() {}

    default void endAnalyse() {}

    interface AnalyzeTask {}
}