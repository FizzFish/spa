package cn.sast.common;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class ResourceKt {
    private static final List<String> javaExtensions = List.of("java", "kt", "kts", "scala", "groovy", "jsp");
    private static final Map<String, String> escapes = Map.ofEntries(
        Map.entry("[", "%5B"),
        Map.entry("]", "%5D"),
        Map.entry("{", "%7B"),
        Map.entry("}", "%7D"),
        Map.entry("<", "%3C"),
        Map.entry(">", "%3E"),
        Map.entry("#", "%23"),
        Map.entry("?", "%3F"),
        Map.entry("@", "%40"),
        Map.entry(" ", "%20")
    );
    private static final Pattern urlEscapePattern = Pattern.compile("([\\[\\]{}<>#?@ ])");

    @NotNull
    public static String getText(@NotNull URL url) {
        if (url == null) throw new IllegalArgumentException("url cannot be null");
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read URL content", e);
        }
    }

    @NotNull
    public static List<String> getJavaExtensions() {
        return javaExtensions;
    }

    public static boolean getZipLike(@NotNull Path path) {
        if (path == null) throw new IllegalArgumentException("path cannot be null");
        String extension = getExtension(path.getFileName().toString());
        return ResourceImplKt.getZipExtensions().contains(extension);
    }

    private static String getExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex == -1) ? "" : filename.substring(dotIndex + 1);
    }

    public static boolean isJarScheme(@NotNull URI uri) {
        if (uri == null) throw new IllegalArgumentException("uri cannot be null");
        String scheme = uri.getScheme();
        return "jar".equalsIgnoreCase(scheme) || "zip".equalsIgnoreCase(scheme);
    }

    public static boolean isFileScheme(@NotNull URI uri) {
        if (uri == null) throw new IllegalArgumentException("uri cannot be null");
        return "file".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isJrtScheme(@NotNull URI uri) {
        if (uri == null) throw new IllegalArgumentException("uri cannot be null");
        return "jrt".equalsIgnoreCase(uri.getScheme());
    }

    @NotNull
    public static String readText(@NotNull IResFile resFile, @NotNull Charset charset) throws IOException {
        if (resFile == null) throw new IllegalArgumentException("resFile cannot be null");
        if (charset == null) throw new IllegalArgumentException("charset cannot be null");
        try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(resFile.getPath()), charset)) {
            return new BufferedReader(reader).lines().collect(Collectors.joining("\n"));
        }
    }

    public static <T> T lineSequence(@NotNull IResFile resFile, @NotNull java.util.function.Function<Iterable<String>, T> processor) throws IOException {
        if (resFile == null) throw new IllegalArgumentException("resFile cannot be null");
        if (processor == null) throw new IllegalArgumentException("processor cannot be null");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(resFile.getPath())))) {
            return processor.apply(reader.lines()::iterator);
        }
    }

    @NotNull
    public static byte[] readAllBytes(@NotNull IResFile resFile) throws IOException {
        if (resFile == null) throw new IllegalArgumentException("resFile cannot be null");
        return Files.readAllBytes(resFile.getPath());
    }

    public static void writeText(@NotNull IResFile resFile, @NotNull String text, @NotNull Charset charset) throws IOException {
        if (resFile == null) throw new IllegalArgumentException("resFile cannot be null");
        if (text == null) throw new IllegalArgumentException("text cannot be null");
        if (charset == null) throw new IllegalArgumentException("charset cannot be null");
        try (OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(resFile.getPath()), charset)) {
            writer.write(text);
        }
    }

    @NotNull
    public static URI uriOf(@NotNull String uri) {
        if (uri == null) throw new IllegalArgumentException("uri cannot be null");
        Matcher matcher = urlEscapePattern.matcher(uri);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, escapes.get(matcher.group(1)));
        }
        matcher.appendTail(sb);
        try {
            return new URI(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create URI", e);
        }
    }

    @NotNull
    public static Path uriToPath(@NotNull URI uri, boolean getRootFsPath) {
        if (uri == null) throw new IllegalArgumentException("uri cannot be null");
        if (isFileScheme(uri)) {
            if (getRootFsPath) throw new IllegalStateException("Cannot get root FS path for file URI");
            return Paths.get(uri);
        }
        if (isJrtScheme(uri)) {
            throw new IllegalStateException("Unsupported URI with JRT scheme: " + uri);
        }
        String spec = uri.getSchemeSpecificPart();
        int sep = spec.lastIndexOf("!/");
        if (sep != -1) {
            String zipPath = spec.substring(0, sep);
            String entry = spec.substring(sep + 1);
            Path archive = uriToPath(uriOf(zipPath), false);
            if (getRootFsPath) return archive;
            return Resource.INSTANCE.getZipFileSystem(archive).getPath(entry);
        } else {
            if (!getRootFsPath) throw new IllegalStateException("Invalid URI format");
            return Paths.get(uriOf(spec));
        }
    }

    @NotNull
    public static Path findCacheFromDeskOrCreate(@NotNull Path input, @NotNull Path output, @NotNull Runnable creator) {
        if (input == null) throw new IllegalArgumentException("input cannot be null");
        if (output == null) throw new IllegalArgumentException("output cannot be null");
        if (creator == null) throw new IllegalArgumentException("creator cannot be null");
        
        String md5 = Resource.INSTANCE.fileOf(input).getMd5();
        Path normal = output.toAbsolutePath();
        Path parent = normal.getParent();
        if (parent == null) throw new IllegalStateException("Bad output path: " + output);
        
        String baseName = getBaseName(output.getFileName().toString());
        File flagFile = parent.resolve("." + baseName + ".successful").toFile();
        
        if (flagFile.exists() && md5.equals(Files.readString(flagFile.toPath()))) {
            if (Files.exists(output)) return output;
        } else {
            try { Files.deleteIfExists(output); } catch (IOException ignored) {}
        }
        
        creator.run();
        try {
            Files.writeString(flagFile.toPath(), md5);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write flag file", e);
        }
        return output;
    }

    private static String getBaseName(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex == -1) ? filename : filename.substring(0, dotIndex);
    }
}
