/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResource
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.IResource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H&J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u00a8\u0006\r"}, d2={"Lcn/sast/common/IResDirectory;", "Lcn/sast/common/IResource;", "normalize", "getNormalize", "()Lcn/sast/common/IResDirectory;", "absolute", "getAbsolute", "expandRes", "outPut", "listPathEntries", "", "glob", "", "corax-api"})
public interface IResDirectory
extends IResource {
    @NotNull
    public IResDirectory getNormalize();

    @NotNull
    public IResDirectory getAbsolute();

    @NotNull
    public IResDirectory expandRes(@NotNull IResDirectory var1);

    @NotNull
    public List<IResource> listPathEntries(@NotNull String var1);
}

