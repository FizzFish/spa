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

import com.feysh.corax.config.api.AttributeName;
import com.feysh.corax.config.api.IIexConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/CustomAttributeID;", "T", "", "name", "", "default", "Lcom/feysh/corax/config/api/IIexConst;", "<init>", "(Ljava/lang/String;Lcom/feysh/corax/config/api/IIexConst;)V", "getName", "()Ljava/lang/String;", "getDefault", "()Lcom/feysh/corax/config/api/IIexConst;", "attributeName", "Lcom/feysh/corax/config/api/AttributeName;", "getAttributeName", "()Lcom/feysh/corax/config/api/AttributeName;", "corax-config-api"})
public final class CustomAttributeID<T> {
    @NotNull
    private final String name;
    @Nullable
    private final IIexConst default;
    @NotNull
    private final AttributeName attributeName;

    public CustomAttributeID(@NotNull String name, @Nullable IIexConst iIexConst) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.name = name;
        this.default = iIexConst;
        this.attributeName = new AttributeName(this.name, this.default);
    }

    public /* synthetic */ CustomAttributeID(String string, IIexConst iIexConst, int n, DefaultConstructorMarker defaultConstructorMarker) {
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
    public final AttributeName getAttributeName() {
        return this.attributeName;
    }
}

