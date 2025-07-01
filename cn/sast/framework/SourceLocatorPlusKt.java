package cn.sast.framework;

import cn.sast.common.IResource;
import cn.sast.common.Resource;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import soot.Scene;

public final class SourceLocatorPlusKt {
    @NotNull
    public static Set<IResource> sootClassPathsCvt(@NotNull Set<? extends IResource> sourceDir) {
        Set<String> paths = sourceDir.stream()
            .map(IResource::getAbsolutePath)
            .collect(Collectors.toCollection(LinkedHashSet::new));

        String sootClassPath = Scene.v().getSootClassPath();
        Collections.addAll(paths, sootClassPath.split(File.pathSeparator));

        Set<IResource> result = new LinkedHashSet<>();
        for (String path : paths) {
            if ("VIRTUAL_FS_FOR_JDK".equals(path)) {
                result.add(Resource.INSTANCE.of(System.getProperty("java.home")));
            } else {
                result.add(Resource.INSTANCE.of(path));
            }
        }
        return result;
    }
}