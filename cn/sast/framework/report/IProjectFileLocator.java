package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IProjectFileLocator {
    @Nullable
    IResFile get(@NotNull IBugResInfo resInfo, @NotNull IWrapperFileGenerator fileWrapperIfNotEExists);

    @NotNull
    Set<IResource> getSourceDir();

    void setSourceDir(@NotNull Set<? extends IResource> sourceDir);

    void update();

    @Nullable
    Object getByFileExtension(@NotNull String extension, @NotNull Continuation<? super Sequence<? extends IResFile>> continuation);

    @Nullable
    Object getByFileName(@NotNull String filename, @NotNull Continuation<? super Sequence<? extends IResFile>> continuation);

    @Nullable
    Object getAllFiles(@NotNull Continuation<? super Sequence<? extends IResFile>> continuation);

    @NotNull
    Sequence<IResFile> findFromFileIndexMap(@NotNull List<String> parentSubPath, @NotNull AbstractFileIndexer.CompareMode mode);
}