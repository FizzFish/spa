/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IBinOpExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IIexGetField;
import com.feysh.corax.config.api.IIexLoad;
import com.feysh.corax.config.api.IQOpExpr;
import com.feysh.corax.config.api.ITriOpExpr;
import com.feysh.corax.config.api.IUnOpExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "TResult", "", "default", "expr", "Lcom/feysh/corax/config/api/IExpr;", "(Lcom/feysh/corax/config/api/IExpr;)Ljava/lang/Object;", "visit", "Lcom/feysh/corax/config/api/IIexLoad;", "(Lcom/feysh/corax/config/api/IIexLoad;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IIexGetField;", "(Lcom/feysh/corax/config/api/IIexGetField;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IUnOpExpr;", "(Lcom/feysh/corax/config/api/IUnOpExpr;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IBinOpExpr;", "(Lcom/feysh/corax/config/api/IBinOpExpr;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/ITriOpExpr;", "(Lcom/feysh/corax/config/api/ITriOpExpr;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IQOpExpr;", "(Lcom/feysh/corax/config/api/IQOpExpr;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IIexConst;", "(Lcom/feysh/corax/config/api/IIexConst;)Ljava/lang/Object;", "corax-config-api"})
public interface IModelExpressionVisitor<TResult> {
    public TResult default(@NotNull IExpr var1);

    public TResult visit(@NotNull IIexLoad var1);

    public TResult visit(@NotNull IIexGetField var1);

    public TResult visit(@NotNull IUnOpExpr var1);

    public TResult visit(@NotNull IBinOpExpr var1);

    public TResult visit(@NotNull ITriOpExpr var1);

    public TResult visit(@NotNull IQOpExpr var1);

    public TResult visit(@NotNull IIexConst var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IIexLoad expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IIexGetField expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IUnOpExpr expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IBinOpExpr expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull ITriOpExpr expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IQOpExpr expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }

        public static <TResult> TResult visit(@NotNull IModelExpressionVisitor<TResult> $this, @NotNull IIexConst expr) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            return $this.default(expr);
        }
    }
}

