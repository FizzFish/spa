/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IIstSetField;
import com.feysh.corax.config.api.IIstStoreLocal;
import com.feysh.corax.config.api.IStmt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/IModelStmtVisitor;", "TResult", "", "default", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "(Lcom/feysh/corax/config/api/IStmt;)Ljava/lang/Object;", "visit", "Lcom/feysh/corax/config/api/IIstSetField;", "(Lcom/feysh/corax/config/api/IIstSetField;)Ljava/lang/Object;", "Lcom/feysh/corax/config/api/IIstStoreLocal;", "(Lcom/feysh/corax/config/api/IIstStoreLocal;)Ljava/lang/Object;", "corax-config-api"})
public interface IModelStmtVisitor<TResult> {
    public TResult default(@NotNull IStmt var1);

    public TResult visit(@NotNull IIstSetField var1);

    public TResult visit(@NotNull IIstStoreLocal var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static <TResult> TResult visit(@NotNull IModelStmtVisitor<TResult> $this, @NotNull IIstSetField stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            return $this.default(stmt);
        }

        public static <TResult> TResult visit(@NotNull IModelStmtVisitor<TResult> $this, @NotNull IIstStoreLocal stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            return $this.default(stmt);
        }
    }
}

