/*
 * Copyright (c) 2022, original authors.
 */
package cn.sast.dataflow.infoflow.svfa;

import org.jetbrains.annotations.NotNull;
import soot.Unit;
import java.util.List;

public interface ILocalDFA {
    @NotNull
    List<Unit> getUsesOfAt(@NotNull AP ap, @NotNull Unit stmt);

    @NotNull
    List<Unit> getDefUsesOfAt(@NotNull AP ap, @NotNull Unit stmt);
}