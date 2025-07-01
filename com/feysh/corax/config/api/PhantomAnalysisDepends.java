package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.XDecl;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public final class PhantomAnalysisDepends implements IAnalysisDepends {
    public static final PhantomAnalysisDepends INSTANCE = new PhantomAnalysisDepends();

    private PhantomAnalysisDepends() {
    }

    @Override
    public @NotNull XDecl toDecl(@NotNull Object target) {
        if (target == null) {
            throw new NullPointerException("target");
        }
        return new XDecl(){};
    }

    @Override
    public void dependsOn(@NotNull XDecl $this$dependsOn, @NotNull XDecl dep) {
        if ($this$dependsOn == null) {
            throw new NullPointerException("<this>");
        }
        if (dep == null) {
            throw new NullPointerException("dep");
        }
    }

    @Override
    public void dependsOn(@NotNull Collection<? extends XDecl> $this$dependsOn, @NotNull Collection<? extends XDecl> deps) {
        if ($this$dependsOn == null) {
            throw new NullPointerException("<this>");
        }
        if (deps == null) {
            throw new NullPointerException("deps");
        }
    }
}