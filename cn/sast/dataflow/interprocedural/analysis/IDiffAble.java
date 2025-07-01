/*
 * Copyright (c) 2022, SAS Institute Inc., Cary, NC, USA.
 * All Rights Reserved.
 */
package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface IDiffAble<V> {
    void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<?> that);
}