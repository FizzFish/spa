package com.feysh.corax.config.api.baseimpl;

import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;

public class PackageDeclare {
    @NotNull
    private final String packageName;

    public PackageDeclare(@NotNull String packageName) {
        if (packageName == null) {
            throw new IllegalArgumentException("package cannot be null");
        }
        this.packageName = packageName;
    }

    @NotNull
    public final String getPackage() {
        return this.packageName;
    }

    public final void declareClass(@NotNull String className, @NotNull Consumer<ClassDecl> block) {
        if (className == null) {
            throw new IllegalArgumentException("className cannot be null");
        }
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        block.accept(new ClassDecl(this, className));
    }

    @Override
    @NotNull
    public String toString() {
        return "package match: " + this.packageName;
    }
}