/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IIexConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/config/api/AttributeName;", "Lcom/feysh/corax/config/api/IClassField;", "name", "", "default", "Lcom/feysh/corax/config/api/IIexConst;", "<init>", "(Ljava/lang/String;Lcom/feysh/corax/config/api/IIexConst;)V", "getName", "()Ljava/lang/String;", "getDefault", "()Lcom/feysh/corax/config/api/IIexConst;", "toString", "corax-config-api"})
public final class AttributeName
implements IClassField {
    @NotNull
    private final String name;
    @Nullable
    private final IIexConst default;

    public AttributeName(@NotNull String name, @Nullable IIexConst iIexConst) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.name = name;
        this.default = iIexConst;
    }

    public /* synthetic */ AttributeName(String string, IIexConst iIexConst, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            iIexConst = null;
        }
        this(string, iIexConst);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final IIexConst getDefault() {
        return this.default;
    }

    @NotNull
    public String toString() {
        return this.name;
    }
}

