package cn.sast.common;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.SharedZipFileCacheWrapper;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.FileUtilKt;
import soot.util.SharedCloseable;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class Resource {
    public static final Resource INSTANCE = new Resource();
    public static final String EXTRACT_DIR_NAME = "archive-extract";
    
    private static Path zipExtractOutputDir = ResourceImplKt.getSAstTempDirectory();
    private static Map<String, Object> newFileSystemEnv = Map.of(
        "create", "true",
        "zipinfo-time", "false"
    );
    private static List<String> fileSystemEncodings = List.of("UTF-8", "GBK");
    private static final SharedZipFileCacheWrapper archivePathToZip = new SharedZipFileCacheWrapper(5, 50000);
    private static final LoadingCache<Path, Set<String>> archivePathToEntriesCache;
    private static final LoadingCache<Pair<URI, Boolean>, Path> uriToPathCached;
    private static FileSystemProvider zipFsProvider;
    private static final LoadingCache<Path, FileSystem> archiveSystemCache;
    private static final Caffeine<Object, Object> jarCacheBuilder = Caffeine.newBuilder().initialCapacity(4);

    static {
        archivePathToEntriesCache = Caffeine.newBuilder()
            .expireAfterAccess(Duration.ofSeconds(12))
            .build(new CacheLoader<Path, Set<String>>() {
                @Override
                public Set<String> load(Path key) throws Exception {
                    return loadArchiveEntries(key);
                }
            });

        uriToPathCached = Caffeine.newBuilder()
            .initialCapacity(5)
            .maximumSize(5000)
            .softValues()
            .build(new CacheLoader<Pair<URI, Boolean>, Path>() {
                @Override
                public Path load(Pair<URI, Boolean> key) throws Exception {
                    return ResourceKt.uriToPath(key.getFirst(), key.getSecond());
                }
            });

        archiveSystemCache = Caffeine.newBuilder()
            .weakValues()
            .build(new CacheLoader<Path, FileSystem>() {
                @Override
                public FileSystem load(Path key) throws Exception {
                    return createFileSystem(key);
                }
            });
    }

    private Resource() {}

    public Path getZipExtractOutputDir() {
        return zipExtractOutputDir;
    }

    public void setZipExtractOutputDir(Path path) {
        zipExtractOutputDir = path;
    }

    public Map<String, Object> getNewFileSystemEnv() {
        return newFileSystemEnv;
    }

    public void setNewFileSystemEnv(Map<String, ?> map) {
        newFileSystemEnv = new HashMap<>(map);
    }

    public List<String> getFileSystemEncodings() {
        return fileSystemEncodings;
    }

    public void setFileSystemEncodings(List<String> list) {
        fileSystemEncodings = new ArrayList<>(list);
    }

    public SharedZipFileCacheWrapper getArchivePathToZip() {
        return archivePathToZip;
    }

    public Set<String> getEntriesUnsafe(Path path) throws Exception {
        return archivePathToEntriesCache.get(path.toAbsolutePath().normalize());
    }

    public LoadingCache<Pair<URI, Boolean>, Path> getUriToPathCached() {
        return uriToPathCached;
    }

    public IResource of(URI uri) {
        if ("file".equals(uri.getScheme())) {
            return new ResourceBasic(Paths.get(uri));
        }

        if (isJarScheme(uri)) {
            String spec = uri.getSchemeSpecificPart();
            int sep = spec.lastIndexOf("!/");
            if (sep == -1) {
                throw new IllegalArgumentException("URI: " + uri + " does not contain path info ex. jar:file:/c:/foo.zip!/BAR");
            }
            Path path = Paths.get(ResourceKt.uriOf(spec.substring(0, sep)));
            FileSystem system = getZipFileSystem(path);
            Path entryPath = system.getPath(spec.substring(sep + 1));
            return new ResourceBasic(entryPath);
        }

        try {
            FileSystems.getFileSystem(uri);
        } catch (FileSystemNotFoundException e) {
            ResourceImplKt.createFileSystem(uri);
        }
        return new ResourceBasic(Paths.get(uri));
    }

    public IResource of(URL url) throws Exception {
        return of(url.toURI());
    }

    public IResource of(Path path) {
        return new ResourceBasic(path);
    }

    public IResource of(String path) {
        int index = path.indexOf('!');
        if (index == -1) {
            return new ResourceBasic(Paths.get(path));
        }

        Path archivePath = Paths.get(path.substring(0, index));
        String entry = path.substring(index + 1);
        return new ResourceBasic(archivePath(archivePath, entry));
    }

    public IResDirectory dirOf(String directory) {
        return of(directory).toDirectory();
    }

    public IResDirectory dirOf(Path directory) {
        return of(directory).toDirectory();
    }

    public IResFile fileOf(String file) {
        return of(file).toFile();
    }

    public IResFile fileOf(Path file) {
        return of(file).toFile();
    }

    public Set<IResource> multipleOf(List<String> paths) {
        return paths.stream()
            .flatMap(path -> Arrays.stream(path.split(File.pathSeparator)))
            .map(this::of)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public IResource getOriginFileFromExpandPath(IResource p) {
        return getOriginFileFromExpandAbsPath(p.getAbsolute().getNormalize());
    }

    public IResource getOriginFileFromExpandAbsPath(IResource absolute) {
        IResource result = getOriginFileFromExpandAbsolutePath(absolute);
        return result != null ? result : absolute;
    }

    public FileSystem getZipFileSystem(Path path) {
        return archiveSystemCache.get(path.toAbsolutePath().normalize());
    }

    public Path archivePath(Path archive, String entry) {
        int index = entry.indexOf('!');
        if (index != -1) {
            Path first = archivePath(archive, entry.substring(0, index));
            String end = entry.substring(index + 1);
            return archivePath(first, end);
        }

        FileSystem system = getZipFileSystem(archive);
        return system.getPath(entry.startsWith("/") ? entry : "/" + entry);
    }

    public URL locateClass(Class<?> clazz) {
        String path = FileUtilKt.toClassFilePath(clazz);
        URL url = clazz.getClassLoader().getResource(path);
        if (url == null) {
            throw new IllegalArgumentException("No such file: " + path);
        }
        return url;
    }

    public IResource locateAllClass(Class<?> clazz) throws Exception {
        String path = FileUtilKt.toClassFilePath(clazz);
        URL resource = locateClass(clazz);
        URI uri = resource.toURI();

        if (isJarScheme(uri)) {
            URI jarLocation = extractJarName(uri);
            if (jarLocation == null) {
                throw new IllegalStateException("internal error: resource=" + resource);
            }
            return of(jarLocation);
        }

        String fullPath = of(resource).getAbsolute().getNormalize().toString()
            .replace("\\", "/")
            .replace("//", "/");
        fullPath = fullPath.substring(0, fullPath.length() - path.length());
        return of(fullPath);
    }

    public void clean() {
        ResourceBasic.Companion.getJarInnerResourceCache$corax_api().cleanUp();
        ExpandResKey.Companion.getJarTempCache$corax_api().cleanUp();
        ExpandResKey.Companion.getMappingUnzipDirToZip$corax_api().clear();
        archiveSystemCache.cleanUp();
    }

    public Path extractZipToFolder(Path archiveFile, String entryPrefix, Path destFolder) throws IOException {
        String entryPrefixFixed = entryPrefix.startsWith("/") ? entryPrefix.substring(1) : entryPrefix;
        int errNo = 0;

        try (SharedCloseable archiveRef = archivePathToZip.getRef(archiveFile);
             ZipFile archive = (ZipFile) archiveRef.get()) {
            
            Enumeration<? extends ZipEntry> entries = archive.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName().startsWith("/") 
                    ? entry.getName().substring(1) 
                    : entry.getName();

                if (!entryName.startsWith(entryPrefixFixed)) {
                    continue;
                }

                if (entryName.contains("..")) {
                    continue;
                }

                try {
                    Path destFile = destFolder.resolve(entryName);
                    if (entry.isDirectory()) {
                        Files.createDirectories(destFile);
                        continue;
                    }

                    Path parent = destFile.getParent();
                    if (parent != null && !Files.exists(parent)) {
                        Files.createDirectories(parent);
                    }

                    try (InputStream in = archive.getInputStream(entry)) {
                        Files.write(destFile, in.readAllBytes());
                        if (OS.INSTANCE.getPosixFilePermissions() != null) {
                            Files.setPosixFilePermissions(destFile, OS.INSTANCE.getPosixFilePermissions());
                        }
                    }
                } catch (InvalidPathException e) {
                    if (errNo++ >= 3) continue;
                }
            }
        }

        return destFolder.resolve(entryPrefix);
    }

    private static Set<String> loadArchiveEntries(Path archivePath) throws Exception {
        try (SharedCloseable archiveRef = archivePathToZip.getRef(archivePath);
             ZipFile archive = (ZipFile) archiveRef.get()) {
            return archive.stream()
                .map(ZipEntry::getName)
                .collect(Collectors.toSet());
        }
    }

    private static FileSystem createFileSystem(Path archivePath) throws IOException {
        URI uri = URI.create("jar:" + archivePath.toUri());
        try {
            return FileSystems.getFileSystem(uri);
        } catch (FileSystemNotFoundException e) {
            return FileSystems.newFileSystem(uri, newFileSystemEnv);
        }
    }

    private boolean isJarScheme(URI uri) {
        String scheme = uri.getScheme();
        return "jar".equals(scheme) || "zip".equalsIgnoreCase(scheme);
    }

    private URI extractJarName(URI uri) {
        String spec = uri.getSchemeSpecificPart();
        int index = spec.lastIndexOf("!/");
        if (index == -1) {
            return null;
        }
        return ResourceKt.uriOf(spec.substring(0, index));
    }

    private boolean isUnderExtractDir(IResource p) {
        return p.isFileScheme() && p.toString().contains(EXTRACT_DIR_NAME);
    }

    private IResource getOriginFileFromExpandAbsolutePath(IResource abs) {
        if (isUnderExtractDir(abs)) {
            Path found = findFileMappingInZip(abs);
            if (found != null) {
                return of(found);
            }
            return null;
        }

        String entry = abs.getZipEntry();
        if (entry != null) {
            IResource schemePath = of(abs.getSchemePath());
            if (isUnderExtractDir(schemePath)) {
                IResource origin = getOriginFileFromExpandAbsolutePath(schemePath);
                return origin != null ? origin.resolve(entry) : null;
            }
        }
        return null;
    }

    private Path findFileMappingInZip(IResource nFile) {
        if (!nFile.isFileScheme()) {
            throw new IllegalStateException("Check failed.");
        }

        Path p = nFile.getPath();
        for (Map.Entry<IResDirectory, IResource> entry : ExpandResKey.Companion.getMappingUnzipDirToZip$corax_api().entrySet()) {
            IResDirectory uncompress = entry.getKey();
            IResource fromZip = entry.getValue();

            if (p.startsWith(uncompress.getPath())) {
                try {
                    Path after = p.subpath(uncompress.getPath().getNameCount(), p.getNameCount());
                    return fromZip.resolve(after.toString()).getPath();
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return null;
    }

    private FileSystemProvider getZipFsProvider() {
        if (zipFsProvider == null) {
            zipFsProvider = findZipFsProvider();
        }
        return zipFsProvider;
    }

    private FileSystemProvider findZipFsProvider() {
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if ("jar".equals(provider.getScheme())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("Provider not found");
    }

    private Path extract(Path path, String scheme) {
        String schemeFinal = "zip".equals(scheme) ? "jar" : scheme;
        if ("jar".equals(schemeFinal)) {
            URI uri = path.toUri();
            if (isJarScheme(uri)) {
                return extract(of(path).expandRes(dirOf(zipExtractOutputDir)).getPath(), scheme);
            }
        }
        return path;
    }
}
