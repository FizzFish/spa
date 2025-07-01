package cn.sast.framework.report;

import cn.sast.common.IResFile;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.jetbrains.annotations.NotNull;
import soot.util.ArraySet;

public class FileIndexerBuilder {
    private final ConcurrentNavigableMap<String, NavigableSet<IResFile>> fileNameToPathMap = new ConcurrentSkipListMap<>();
    private final ConcurrentNavigableMap<String, NavigableSet<IResFile>> extensionToPathMap = new ConcurrentSkipListMap<>();

    public void addIndexMap(@NotNull IResFile resFile) {
        if (resFile == null) {
            throw new NullPointerException("resFile is null");
        }
        if (!resFile.isFile()) {
            return;
        }

        fileNameToPathMap.computeIfAbsent(resFile.getName(), k -> new ConcurrentSkipListSet<>())
                        .add(resFile);
        extensionToPathMap.computeIfAbsent(resFile.getExtension(), k -> new ConcurrentSkipListSet<>())
                          .add(resFile);
    }

    public void union(@NotNull FileIndexer indexer) {
        if (indexer == null) {
            throw new NullPointerException("indexer is null");
        }

        indexer.getFileNameToPathMap().forEach((key, value) -> 
            fileNameToPathMap.computeIfAbsent(key, k -> new ConcurrentSkipListSet<>())
                            .addAll(value)
        );

        indexer.getExtensionToPathMap().forEach((key, value) -> 
            extensionToPathMap.computeIfAbsent(key, k -> new ConcurrentSkipListSet<>())
                             .addAll(value)
        );
    }

    @NotNull
    public FileIndexer build() {
        return new FileIndexer(fileNameToPathMap, extensionToPathMap);
    }

    @NotNull
    public FileIndexer sortAndOptimizeMem() {
        Map<String, Set<IResFile>> optimizedFileNameMap = optimizeMap(fileNameToPathMap);
        Map<String, Set<IResFile>> optimizedExtensionMap = optimizeMap(extensionToPathMap);
        return new FileIndexer(optimizedFileNameMap, optimizedExtensionMap);
    }

    private Map<String, Set<IResFile>> optimizeMap(ConcurrentNavigableMap<String, NavigableSet<IResFile>> sourceMap) {
        Map<String, Set<IResFile>> result = new LinkedHashMap<>(sourceMap.size());
        sourceMap.forEach((key, value) -> result.put(key, optimizeSet(value)));
        return result;
    }

    private Set<IResFile> optimizeSet(NavigableSet<IResFile> set) {
        int size = set.size();
        if (size == 0) {
            return Collections.emptySet();
        } else if (size == 1) {
            return Collections.singleton(set.first());
        } else if (size < 17) {
            return new ArraySet<>(set);
        }
        return set;
    }
}