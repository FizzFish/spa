package cn.sast.api.util;

import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassPathUtil {
    public static final ClassPathUtil INSTANCE = new ClassPathUtil();

    private ClassPathUtil() {
    }

    @Nullable
    public String findCodeBaseInClassPath(@Nonnull @NotNull String codeBaseName, @Nullable String classPath) {
        if (codeBaseName == null) {
            throw new NullPointerException("codeBaseName");
        }
        if (classPath == null) {
            return null;
        }
        
        StringTokenizer tok = new StringTokenizer(classPath, File.pathSeparator);
        while (tok.hasMoreTokens()) {
            String t = tok.nextToken();
            File f = new File(t);
            if (f.getName().equals(codeBaseName)) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public String findCodeBaseInClassPath(@NotNull Pattern codeBaseNamePattern, @Nullable String classPath) {
        if (codeBaseNamePattern == null) {
            throw new NullPointerException("codeBaseNamePattern");
        }
        if (classPath == null) {
            return null;
        }
        
        StringTokenizer tok = new StringTokenizer(classPath, File.pathSeparator);
        while (tok.hasMoreTokens()) {
            String t = tok.nextToken();
            File f = new File(t);
            Matcher m = codeBaseNamePattern.matcher(f.getName());
            if (m.matches()) {
                return t;
            }
        }
        return null;
    }

    @NotNull
    public String[] getJavaClassPath() {
        String classPath = System.getProperty("java.class.path");
        if (classPath == null) {
            return new String[0];
        }
        return classPath.split(File.pathSeparator);
    }
}