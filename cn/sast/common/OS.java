package cn.sast.common;

import java.lang.management.ManagementFactory;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OS {
    public static final OS INSTANCE = new OS();
    private static int maxThreadNum = Runtime.getRuntime().availableProcessors();
    private static final boolean isWindows;
    private static final String[] args = new String[0];
    private static final Set<PosixFilePermission> posixFilePermissions;
    private static final URL binaryUrl;
    private static final Path jarBinPath;

    static {
        String osName = System.getProperty("os.name");
        isWindows = osName.toLowerCase(Locale.getDefault()).contains("windows");
        
        binaryUrl = initializeBinaryUrl();
        jarBinPath = initializeJarBinPath();
        posixFilePermissions = isWindows ? null : PosixFilePermissions.fromString("rwxr--r--");
    }

    private OS() {
    }

    public int getMaxThreadNum() {
        return maxThreadNum;
    }

    public void setMaxThreadNum(int maxThreadNum) {
        OS.maxThreadNum = maxThreadNum;
    }

    public boolean isWindows() {
        return isWindows;
    }

    @Nullable
    public URL getBinaryUrl() {
        return binaryUrl;
    }

    @Nullable
    public Path getJarBinPath() {
        return jarBinPath;
    }

    @NotNull
    public String[] getArgs() {
        return args.clone();
    }

    public void setArgs(@NotNull String[] args) {
        if (args == null) {
            throw new NullPointerException("<set-?>");
        }
        OS.args = args.clone();
    }

    @Nullable
    public String getJavaExecutableFilePath() {
        return ProcessHandle.current().info().command().orElse(null);
    }

    @Nullable
    public List<String> getCommandLine(@Nullable String[] args, boolean includeJvmOptions) {
        String javaExecutable = getJavaExecutableFilePath();
        if (javaExecutable == null) {
            return null;
        }

        try {
            List<String> command = new ArrayList<>();
            command.add(javaExecutable);

            if (includeJvmOptions) {
                command.addAll(ManagementFactory.getRuntimeMXBean().getInputArguments());
            }

            URL binaryUrl = getBinaryUrl();
            if (binaryUrl != null) {
                command.add("-cp");
                command.add(binaryUrl.getPath());
                Collections.addAll(command, args != null ? args : OS.args);
            }

            return command;
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public Set<PosixFilePermission> getPosixFilePermissions() {
        return posixFilePermissions;
    }

    private static URL initializeBinaryUrl() {
        ProtectionDomain protectionDomain = OS.class.getProtectionDomain();
        if (protectionDomain == null) {
            return null;
        }

        CodeSource codeSource = protectionDomain.getCodeSource();
        if (codeSource == null) {
            return null;
        }

        URL location = codeSource.getLocation();
        if (location == null) {
            return null;
        }

        String locationStr = location.toString();
        if (locationStr.endsWith("BOOT-INF/classes!/") || locationStr.endsWith("BOOT-INF/classes")) {
            locationStr = locationStr.replace("!/", "");
            IResource classLoc = Resource.INSTANCE.of(ResourceKt.uriOf(locationStr));
            return PathUtil.INSTANCE.toURL(classLoc.getSchemePath());
        }

        return location;
    }

    private static Path initializeJarBinPath() {
        URL url = INSTANCE.getBinaryUrl();
        if (url == null) {
            return null;
        }

        try {
            Path path = Path.of(url.toURI());
            return path.toFile().isFile() && path.getFileName().toString().endsWith(".jar") ? path : null;
        } catch (Exception e) {
            return null;
        }
    }
}
