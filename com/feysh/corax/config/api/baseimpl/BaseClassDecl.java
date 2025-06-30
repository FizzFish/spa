/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseClassDecl;", "Lcom/feysh/corax/config/api/IClassDecl;", "analyzeConfig", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "match", "Lcom/feysh/corax/config/api/IClassMatch;", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;Lcom/feysh/corax/config/api/IClassMatch;)V", "getAnalyzeConfig", "()Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "getMatch", "()Lcom/feysh/corax/config/api/IClassMatch;", "toString", "", "corax-config-api"})
public final class BaseClassDecl
implements IClassDecl {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final IClassMatch match;

    public BaseClassDecl(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IClassMatch match) {
        Intrinsics.checkNotNullParameter((Object)analyzeConfig, (String)"analyzeConfig");
        Intrinsics.checkNotNullParameter((Object)match, (String)"match");
        this.analyzeConfig = analyzeConfig;
        this.match = match;
    }

    @NotNull
    public final AIAnalysisBaseImpl getAnalyzeConfig() {
        return this.analyzeConfig;
    }

    @Override
    @NotNull
    public IClassMatch getMatch() {
        return this.match;
    }

    @NotNull
    public String toString() {
        return "class decl: " + this.getMatch();
    }
}

