/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2={"Lcn/sast/common/IResFile;", "Lcn/sast/common/IResource;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "md5", "getMd5", "()Ljava/lang/String;", "absolute", "getAbsolute", "()Lcn/sast/common/IResFile;", "normalize", "getNormalize", "expandRes", "outPut", "Lcn/sast/common/IResDirectory;", "corax-api"})
public interface IResFile
extends IResource {
    @NotNull
    public Set<String> getEntries();

    @NotNull
    public String getMd5();

    @NotNull
    public IResFile getAbsolute();

    @NotNull
    public IResFile getNormalize();

    @NotNull
    public IResFile expandRes(@NotNull IResDirectory var1);
}

