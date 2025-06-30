/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IRule;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/api/IChecker;", "", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "report", "Lcom/feysh/corax/config/api/IRule;", "getReport", "()Lcom/feysh/corax/config/api/IRule;", "standards", "", "getStandards", "()Ljava/util/Set;", "desc", "getDesc", "validate", "", "corax-config-api"})
public interface IChecker {
    @NotNull
    public String getSimpleName();

    @NotNull
    public IRule getReport();

    @NotNull
    public Set<IRule> getStandards();

    @NotNull
    public String getDesc();

    public void validate();

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static String getSimpleName(@NotNull IChecker $this) {
            String string = $this.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSimpleName(...)");
            return string;
        }

        @NotNull
        public static String getDesc(@NotNull IChecker $this) {
            return $this.getReport().getDesc();
        }

        public static void validate(@NotNull IChecker $this) {
        }
    }
}

