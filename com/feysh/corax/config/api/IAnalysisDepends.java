package com.feysh.corax.config.api;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public interface IAnalysisDepends {
    @NotNull
    XDecl toDecl(@NotNull Object target);

    void dependsOn(@NotNull XDecl source, @NotNull XDecl dependency);

    void dependsOn(@NotNull Collection<? extends XDecl> sources, 
                  @NotNull Collection<? extends XDecl> dependencies);
}