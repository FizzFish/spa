package com.feysh.corax.config.api.utils;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class ClassCommons {
    public static final ClassCommons INSTANCE = new ClassCommons();

    private ClassCommons() {
    }

    @NotNull
    public String toClassFilePath(@NotNull Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class parameter cannot be null");
        }
        String name = clazz.getName();
        if (name == null) {
            throw new IllegalArgumentException("Class is local or anonymous");
        }
        return name.replace('.', '/') + ".class";
    }

    private URI extractJarName(URI uri) {
        String schemeSpecific = uri.getSchemeSpecificPart();
        String beforeExclamation = schemeSpecific.split("!")[0];
        return URI.create(beforeExclamation.replace(" ", "%20"));
    }

    @NotNull
    public Path locateAllClass(@NotNull Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class parameter cannot be null");
        }

        String classPath = toClassFilePath(clazz);
        URL resource = clazz.getClassLoader().getResource(classPath);
        if (resource == null) {
            throw new IllegalArgumentException("No such file: " + classPath);
        }

        if ("jar".equals(resource.toURI().getScheme())) {
            URI jarUri = extractJarName(resource.toURI());
            return Paths.get(jarUri);
        } else {
            URI uri = resource.toURI();
            Path path;
            if ("file".equals(uri.getScheme())) {
                path = Paths.get(uri);
            } else {
                try {
                    FileSystems.getFileSystem(uri);
                } catch (FileSystemNotFoundException e) {
                    Map<String, String> env = Collections.singletonMap("zipinfo-time", "false");
                    FileSystems.newFileSystem(uri, env);
                }
                path = Paths.get(uri);
            }

            Path normalizedPath = path.toAbsolutePath().normalize();
            String fullPath = normalizedPath.toString()
                .replace("\\", "/")
                .replace("//", "/")
                .replace(classPath, "");
            return new File(fullPath).toPath();
        }
    }
}