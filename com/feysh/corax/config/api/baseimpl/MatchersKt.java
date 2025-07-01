package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public final class MatchersKt {
    @NotNull
    public static RawSignatureMatch method(@NotNull IClassMatch classMatch, String... methodName) {
        if (classMatch == null) {
            throw new IllegalArgumentException("classMatch cannot be null");
        }
        if (methodName == null) {
            throw new IllegalArgumentException("methodName cannot be null");
        }
        List<String> methodNames = Arrays.asList(methodName);
        return new RawSignatureMatch(classMatch, methodNames, null, null, null, 16, null);
    }
}