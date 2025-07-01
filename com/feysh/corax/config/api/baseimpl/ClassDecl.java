package com.feysh.corax.config.api.baseimpl;

import org.jetbrains.annotations.NotNull;

public class ClassDecl {
    @NotNull
    private final PackageDeclare pkg;
    @NotNull
    private final String className;
    @NotNull
    private final String clazz;

    public ClassDecl(@NotNull PackageDeclare pkg, @NotNull String className) {
        if (pkg == null) throw new IllegalArgumentException("package cannot be null");
        if (className == null) throw new IllegalArgumentException("className cannot be null");
        this.pkg = pkg;
        this.className = className;
        this.clazz = pkg.getPackage() + "." + className;
    }

    @NotNull
    public final PackageDeclare getPackage() {
        return pkg;
    }

    @NotNull
    public final String getClassName() {
        return className;
    }

    @NotNull
    public final String getClazz() {
        return clazz;
    }

    @NotNull
    public final RawSignatureMatch matchSimpleSubSig(@NotNull String subSignature) {
        if (subSignature == null) throw new IllegalArgumentException("subSignature cannot be null");
        return MatchUtilsKt.matchSimpleSig(clazz + ": " + subSignature);
    }

    @NotNull
    public final SootSignatureMatch matchSubSig(@NotNull String subSignature) {
        if (subSignature == null) throw new IllegalArgumentException("subSignature cannot be null");
        String sootSig = "<" + clazz + ": " + subSignature + ">";
        return SootSignatureMatch.of(sootSig);
    }

    @NotNull
    public final RawSignatureMatch matchName(@NotNull String name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        return RawSignatureMatch.of(clazz, name);
    }

    @Override
    @NotNull
    public String toString() {
        return "class match: " + className;
    }
}