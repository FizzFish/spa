package cn.sast.common;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IResource extends Comparable<IResource> {
    @NotNull Path getPath();
    
    @NotNull String getName();
    
    @NotNull String getExtension();
    
    boolean exists();
    
    boolean isFile();
    
    boolean isDirectory();
    
    boolean isRegularFile();
    
    @NotNull String getAbsolutePath();
    
    @NotNull IResource getAbsolute();
    
    @NotNull IResource normalize();
    
    boolean isFileScheme();
    
    boolean isJrtScheme();
    
    boolean isJarScheme();
    
    @NotNull Path getSchemePath();
    
    @NotNull URI getUri();
    
    @NotNull URL getUrl();
    
    @Nullable String getZipEntry();
    
    @NotNull File getFile() throws UnsupportedOperationException;
    
    @Nullable IResource getParent();
    
    @NotNull IResource resolve(@NotNull String name);
    
    @NotNull IResFile toFile();
    
    @NotNull IResDirectory toDirectory();
    
    @NotNull IResource expandRes(@NotNull IResDirectory directory);
    
    void mkdirs();
    
    boolean isZipLike();
    
    void deleteDirectoryRecursively() throws IOException;
    
    void deleteDirectoryContents() throws IOException;
    
    @NotNull Iterable<Path> getChildren();
    
    @NotNull String getPathString();
}