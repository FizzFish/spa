/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Type
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.ILocalVarDecl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "local", "Lsoot/Local;", "getLocal", "()Lsoot/Local;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "corax-config-api"})
public interface ISootLocalVarDecl<T>
extends ILocalVarDecl<T> {
    @NotNull
    public Local getLocal();

    @Nullable
    public String getName();

    @NotNull
    public Type getType();

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <T> String getName(@NotNull ISootLocalVarDecl<T> $this) {
            return $this.getLocal().getName();
        }

        @NotNull
        public static <T> Type getType(@NotNull ISootLocalVarDecl<T> $this) {
            Type type = $this.getLocal().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            return type;
        }
    }
}

