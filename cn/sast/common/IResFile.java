/*
 * Copyright (c) 2022, SAST. All rights reserved.
 */
package cn.sast.common;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public interface IResFile extends IResource {
    @NotNull
    Set<String> getEntries();

    @NotNull
    String getMd5();

    @NotNull
    IResFile getAbsolute();

    @NotNull
    IResFile getNormalize();

    @NotNull
    IResFile expandRes(@NotNull IResDirectory outPut);
}