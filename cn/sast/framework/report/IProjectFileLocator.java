/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.sequences.Sequence
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.IWrapperFileGenerator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0017\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&R\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001f"}, d2={"Lcn/sast/framework/report/IProjectFileLocator;", "", "get", "Lcn/sast/common/IResFile;", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "fileWrapperIfNotEExists", "Lcn/sast/framework/report/IWrapperFileGenerator;", "sourceDir", "", "Lcn/sast/common/IResource;", "getSourceDir", "()Ljava/util/Set;", "setSourceDir", "(Ljava/util/Set;)V", "update", "", "getByFileExtension", "Lkotlin/sequences/Sequence;", "extension", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByFileName", "filename", "getAllFiles", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findFromFileIndexMap", "parentSubPath", "", "mode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "corax-framework"})
public interface IProjectFileLocator {
    @Nullable
    public IResFile get(@NotNull IBugResInfo var1, @NotNull IWrapperFileGenerator var2);

    @NotNull
    public Set<IResource> getSourceDir();

    public void setSourceDir(@NotNull Set<? extends IResource> var1);

    public void update();

    @Nullable
    public Object getByFileExtension(@NotNull String var1, @NotNull Continuation<? super Sequence<? extends IResFile>> var2);

    @Nullable
    public Object getByFileName(@NotNull String var1, @NotNull Continuation<? super Sequence<? extends IResFile>> var2);

    @Nullable
    public Object getAllFiles(@NotNull Continuation<? super Sequence<? extends IResFile>> var1);

    @NotNull
    public Sequence<IResFile> findFromFileIndexMap(@NotNull List<String> var1, @NotNull AbstractFileIndexer.CompareMode var2);
}

