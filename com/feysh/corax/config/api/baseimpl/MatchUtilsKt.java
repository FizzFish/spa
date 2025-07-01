package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.baseimpl.PackageDeclare;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class MatchUtilsKt {
    private static final Pattern patternSimpleSig = Pattern.compile("^(?<class>.*?): (?<returnType>.*?) (?<methodName>.*?)\\((?<parameters>.*?)\\)$");

    @NotNull
    public static SootSignatureMatch matchSoot(@NotNull String sootSignature) {
        if (sootSignature == null) throw new IllegalArgumentException("sootSignature cannot be null");
        return SootSignatureMatch.Companion.invoke(sootSignature);
    }

    @NotNull
    public static SootSignatureMatch match(@NotNull Object function) {
        if (function == null) throw new IllegalArgumentException("function cannot be null");
        return SootSignatureMatch.Companion.invoke(function);
    }

    @NotNull
    public static RawSignatureMatch matchMethodName(@NotNull String clazz, @NotNull String methodName) {
        if (clazz == null) throw new IllegalArgumentException("class cannot be null");
        if (methodName == null) throw new IllegalArgumentException("methodName cannot be null");
        return RawSignatureMatch.Companion.invoke$default(RawSignatureMatch.Companion, clazz, methodName, null, null, null, 16, null);
    }

    @NotNull
    public static Pattern getPatternSimpleSig() {
        return patternSimpleSig;
    }

    @NotNull
    public static RawSignatureMatch matchSimpleSig(@NotNull String sig) {
        if (sig == null) throw new IllegalArgumentException("sig cannot be null");
        
        Matcher matcher = patternSimpleSig.matcher(sig);
        if (!matcher.matches() || sig.startsWith("<") || sig.endsWith(">")) {
            throw new IllegalArgumentException("invalid java style signature syntax: " + sig + 
                ". eg: \"java.util.Map: Object getOrDefault(Object key, Object defaultValue, *)\"");
        }

        String clazz = matcher.group("class");
        String returnType = "*".equals(matcher.group("returnType")) ? null : matcher.group("returnType");
        String methodName = matcher.group("methodName");
        String paramsStr = matcher.group("parameters");

        List<String> parameters = null;
        if (!"**".equals(paramsStr)) {
            if (paramsStr.isEmpty()) {
                parameters = List.of();
            } else {
                parameters = List.of(paramsStr.split(",")).stream()
                    .map(s -> extractParameter(sig, s.trim()))
                    .collect(Collectors.toList());
            }
        }

        if (clazz.split("\\.")[clazz.split("\\.").length - 1].equals(methodName)) {
            throw new IllegalStateException("This is a constructor: " + sig);
        }

        return RawSignatureMatch.Companion.invoke$default(RawSignatureMatch.Companion, 
            clazz, methodName, returnType, parameters, null, 16, null);
    }

    @NotNull
    public static RawSignatureMatch matchParameters(@NotNull RawSignatureMatch match, String... parameters) {
        if (match == null) throw new IllegalArgumentException("match cannot be null");
        if (parameters == null) throw new IllegalArgumentException("parameters cannot be null");
        return new RawSignatureMatch(match.getClazz(), match.getName(), 
            match.getReturnType(), List.of(parameters), match.getActualType());
    }

    @NotNull
    public static RawSignatureMatch matchFunctionType(@NotNull RawSignatureMatch match, @Nullable KFunctionType actualType) {
        if (match == null) throw new IllegalArgumentException("match cannot be null");
        return new RawSignatureMatch(match.getClazz(), match.getName(), 
            match.getReturnType(), match.getParameters(), actualType);
    }

    @NotNull
    public static RawSignatureMatch matchReturnType(@NotNull RawSignatureMatch match, @Nullable String returnType) {
        if (match == null) throw new IllegalArgumentException("match cannot be null");
        return new RawSignatureMatch(match.getClazz(), match.getName(), 
            returnType, match.getParameters(), match.getActualType());
    }

    public static void packageDeclare(@NotNull AIAnalysisApi api, @NotNull String pkg, @NotNull java.util.function.Consumer<PackageDeclare> block) {
        if (api == null) throw new IllegalArgumentException("api cannot be null");
        if (pkg == null) throw new IllegalArgumentException("package cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        block.accept(new PackageDeclare(pkg));
    }

    // Generic match methods for constructors, methods and static methods
    @NotNull
    public static <T> SootSignatureMatch matchConstructor(@NotNull java.util.function.Supplier<T> function) {
        return match(function);
    }

    @NotNull
    public static <R, T> SootSignatureMatch matchMethod(@NotNull java.util.function.Function<T, R> function) {
        return match(function);
    }

    @NotNull
    public static <R> SootSignatureMatch matchStaticMethod(@NotNull java.util.function.Supplier<R> function) {
        return match(function);
    }

    // Additional overloads for methods with parameters would go here...

    private static String extractParameter(String sig, String str) {
        String pass1Str = str.split("<")[0].trim();
        String[] parts = pass1Str.split(" ");
        if (parts.length > 2) {
            throw new IllegalArgumentException("error syntax signature: " + sig);
        }
        String type = parts[0];
        return "*".equals(type) ? null : type;
    }
}
