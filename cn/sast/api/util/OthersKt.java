package cn.sast.api.util;

import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.baseimpl.MatchUtilsKt;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;

public final class OthersKt {
    public static boolean isDummy(@NotNull SootMethod method) {
        if (method == null) throw new NullPointerException("method is null");
        if ("dummyMainMethod".equals(method.getName())) {
            return true;
        }
        SootClass sootClass = method.getDeclaringClass();
        return isDummy(sootClass);
    }

    public static boolean isDummy(@NotNull SootClass clazz) {
        if (clazz == null) throw new NullPointerException("clazz is null");
        String name = clazz.getName();
        return name != null && name.contains("dummy");
    }

    public static boolean isSyntheticComponent(@NotNull SootMethod method) {
        if (method == null) throw new NullPointerException("method is null");
        String name = method.getName();
        return (name != null && name.contains("synthetic")) || isDummy(method);
    }

    public static boolean isSyntheticComponent(@NotNull SootClass clazz) {
        if (clazz == null) throw new NullPointerException("clazz is null");
        String name = clazz.getName();
        return (name != null && name.contains("synthetic")) || isDummy(clazz);
    }

    public static boolean getSkipPathSensitive(@NotNull SootMethod method) {
        if (method == null) throw new NullPointerException("method is null");
        return isDummy(method) || isSyntheticComponent(method);
    }

    @NotNull
    public static InputStream asInputStream(@NotNull Class<?> clazz) {
        if (clazz == null) throw new NullPointerException("clazz is null");
        String className = clazz.getName().replace('.', '/');
        InputStream inputStream = clazz.getResourceAsStream("/" + className + ".class");
        if (inputStream == null) {
            throw new IllegalStateException("Resource not found for class: " + clazz.getName());
        }
        return inputStream;
    }

    public static void printMilliseconds(@NotNull String message, @NotNull Runnable body) {
        if (message == null) throw new NullPointerException("message is null");
        if (body == null) throw new NullPointerException("body is null");
        
        long start = System.currentTimeMillis();
        body.run();
        long time = System.currentTimeMillis() - start;
        System.out.println(message + ": " + time + " ms");
    }

    @Nullable
    public static IMethodMatch methodSignatureToMatcher(@NotNull String signature) {
        if (signature == null) throw new NullPointerException("signature is null");
        
        if (signature.startsWith("<") && signature.endsWith(">")) {
            return MatchUtilsKt.matchSoot(signature);
        } else if (signature.contains(":")) {
            return MatchUtilsKt.matchSimpleSig(signature);
        }
        return null;
    }
}