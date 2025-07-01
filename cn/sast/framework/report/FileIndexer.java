package cn.sast.framework.report;

import cn.sast.common.IResFile;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.jetbrains.annotations.NotNull;

public final class FileIndexer extends AbstractFileIndexer<IResFile> {
    @NotNull
    private final Map<String, Set<IResFile>> fileNameToPathMap;
    @NotNull
    private final Map<String, Set<IResFile>> extensionToPathMap;
    private final long count;

    public FileIndexer(@NotNull Map<String, ? extends Set<? extends IResFile>> fileNameToPathMap, 
                      @NotNull Map<String, ? extends Set<? extends IResFile>> extensionToPathMap) {
        if (fileNameToPathMap == null) throw new IllegalArgumentException("fileNameToPathMap cannot be null");
        if (extensionToPathMap == null) throw new IllegalArgumentException("extensionToPathMap cannot be null");
        
        this.fileNameToPathMap = Collections.unmodifiableMap(fileNameToPathMap);
        this.extensionToPathMap = Collections.unmodifiableMap(extensionToPathMap);
        this.count = fileNameToPathMap.values().stream().mapToLong(Set::size).sum();
    }

    @NotNull
    public Map<String, Set<IResFile>> getFileNameToPathMap$corax_framework() {
        return fileNameToPathMap;
    }

    @NotNull
    public Map<String, Set<IResFile>> getExtensionToPathMap$corax_framework() {
        return extensionToPathMap;
    }

    @NotNull
    @Override
    public List<String> getNames(@NotNull IResFile path, @NotNull AbstractFileIndexer.CompareMode mode) {
        if (path == null) throw new IllegalArgumentException("path cannot be null");
        if (mode == null) throw new IllegalArgumentException("mode cannot be null");
        
        Path p = path.getPath();
        return IntStream.range(0, p.getNameCount())
                .mapToObj(p::getName)
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public Collection<IResFile> getPathsByName(@NotNull String name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        return fileNameToPathMap.getOrDefault(name, Collections.emptySet());
    }

    @NotNull
    public Collection<IResFile> getPathsByExtension(@NotNull String extension) {
        if (extension == null) throw new IllegalArgumentException("extension cannot be null");
        return extensionToPathMap.getOrDefault(extension, Collections.emptySet());
    }

    public long getCount() {
        return count;
    }
}