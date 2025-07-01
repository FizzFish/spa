package cn.sast.common;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public interface IResDirectory extends IResource {
    @NotNull
    IResDirectory getNormalize();

    @NotNull
    IResDirectory getAbsolute();

    @NotNull
    IResDirectory expandRes(@NotNull IResDirectory outPut);

    @NotNull
    List<IResource> listPathEntries(@NotNull String glob);
}