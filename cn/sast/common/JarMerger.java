package cn.sast.common;

import com.google.common.collect.ImmutableSortedMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JarMerger implements Closeable {
    public interface Transformer {
        @Nullable
        InputStream filter(@NotNull String path, @NotNull InputStream input);
    }

    public interface Relocator {
        @NotNull
        String relocate(@NotNull String path);
    }

    private static final FileTime fileTime = FileTime.fromMillis(0L);
    private final Predicate<String> filter;
    private final byte[] buffer = new byte[8192];
    private final JarArchiveOutputStream jarOutputStream;

    public JarMerger(@NotNull Path jarFile, @Nullable Predicate<String> filter) throws IOException {
        if (jarFile == null) throw new NullPointerException("jarFile is null");
        this.filter = filter;
        Files.createDirectories(jarFile.getParent(), new FileAttribute[0]);
        this.jarOutputStream = new JarArchiveOutputStream(new BufferedOutputStream(Files.newOutputStream(jarFile)));
    }

    public JarMerger(@NotNull Path jarFile) throws IOException {
        this(jarFile, null);
    }

    @NotNull
    public String toSystemIndependentPath(@NotNull Path path) {
        if (path == null) throw new NullPointerException("path is null");
        String filePath = path.toString();
        if (!path.getFileSystem().getSeparator().equals("/")) {
            return filePath.replace(path.getFileSystem().getSeparator(), "/");
        }
        return filePath;
    }

    public void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride, 
            @Nullable Transformer transformer, @Nullable Relocator relocator) throws IOException {
        if (directory == null) throw new NullPointerException("directory is null");
        ImmutableSortedMap.Builder<String, Path> candidateFiles = ImmutableSortedMap.naturalOrder();
        Files.walkFileTree(directory, new FileVisitor<Path>() {
            // Implement FileVisitor methods here
        });
        ImmutableSortedMap<String, Path> sortedFiles = candidateFiles.build();
        for (Map.Entry<String, Path> entry : sortedFiles.entrySet()) {
            String entryPath = entry.getKey();
            Path value = entry.getValue();
            try (InputStream is = new BufferedInputStream(Files.newInputStream(value))) {
                if (transformer != null) {
                    InputStream transformed = transformer.filter(entryPath, is);
                    if (transformed != null) {
                        write(new JarArchiveEntry(entryPath), transformed);
                    }
                } else {
                    write(new JarArchiveEntry(entryPath), is);
                }
            }
        }
    }

    public void addJar(@NotNull Path file, @Nullable Predicate<String> filterOverride, 
            @Nullable Relocator relocator) throws IOException {
        if (file == null) throw new NullPointerException("file is null");
        try (JarArchiveInputStream zis = new JarArchiveInputStream(Files.newInputStream(file))) {
            ZipArchiveEntry entry;
            while ((entry = zis.getNextZipEntry()) != null) {
                if (entry.isDirectory()) continue;
                String name = entry.getName();
                if (filterOverride != null && !filterOverride.test(name)) continue;
                if (relocator != null) {
                    name = relocator.relocate(name);
                }
                JarArchiveEntry newEntry = new JarArchiveEntry(name);
                newEntry.setMethod(entry.getMethod());
                if (newEntry.getMethod() == ZipMethod.STORED.getCode()) {
                    newEntry.setSize(entry.getSize());
                    newEntry.setCompressedSize(entry.getCompressedSize());
                    newEntry.setCrc(entry.getCrc());
                }
                newEntry.setLastModifiedTime(FileTime.fromMillis(0L));
                write(newEntry, zis);
            }
        }
    }

    public void addFile(@NotNull String entryPath, @NotNull Path file) throws IOException {
        if (entryPath == null) throw new NullPointerException("entryPath is null");
        if (file == null) throw new NullPointerException("file is null");
        try (InputStream is = new BufferedInputStream(Files.newInputStream(file))) {
            write(new JarArchiveEntry(entryPath), is);
        }
    }

    public void addEntry(@NotNull String entryPath, @NotNull InputStream input) throws IOException {
        if (entryPath == null) throw new NullPointerException("entryPath is null");
        if (input == null) throw new NullPointerException("input is null");
        try (InputStream is = new BufferedInputStream(input)) {
            write(new JarArchiveEntry(entryPath), is);
        }
    }

    @Override
    public void close() throws IOException {
        jarOutputStream.close();
    }

    public void setManifestProperties(@NotNull Map<String, String> properties) throws IOException {
        if (properties == null) throw new NullPointerException("properties is null");
        Manifest manifest = new Manifest();
        Attributes global = manifest.getMainAttributes();
        global.put(Attributes.Name.MANIFEST_VERSION, "1.0.0");
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            global.put(new Attributes.Name(entry.getKey()), entry.getValue());
        }
        JarArchiveEntry manifestEntry = new JarArchiveEntry("META-INF/MANIFEST.MF");
        setEntryAttributes(manifestEntry);
        jarOutputStream.putArchiveEntry(manifestEntry);
        try {
            manifest.write(jarOutputStream);
        } finally {
            jarOutputStream.closeArchiveEntry();
        }
    }

    private void write(JarArchiveEntry entry, InputStream from) throws IOException {
        setEntryAttributes(entry);
        jarOutputStream.putArchiveEntry(entry);
        int count;
        while ((count = from.read(buffer)) != -1) {
            jarOutputStream.write(buffer, 0, count);
        }
        jarOutputStream.closeArchiveEntry();
    }

    private void setEntryAttributes(JarArchiveEntry entry) {
        entry.setLastModifiedTime(fileTime);
        entry.setLastAccessTime(fileTime);
        entry.setCreationTime(fileTime);
    }

    // Overloaded convenience methods
    public void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride, 
            @Nullable Transformer transformer) throws IOException {
        addDirectory(directory, filterOverride, transformer, null);
    }

    public void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride) throws IOException {
        addDirectory(directory, filterOverride, null, null);
    }

    public void addDirectory(@NotNull Path directory) throws IOException {
        addDirectory(directory, null, null, null);
    }

    public void addJar(@NotNull Path file, @Nullable Predicate<String> filterOverride) throws IOException {
        addJar(file, filterOverride, null);
    }

    public void addJar(@NotNull Path file) throws IOException {
        addJar(file, null, null);
    }
}
