/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/BuiltInField;", "Lcom/feysh/corax/config/api/IClassField;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "Lcom/feysh/corax/config/api/Elements;", "Lcom/feysh/corax/config/api/MapKeys;", "Lcom/feysh/corax/config/api/MapValues;", "Lcom/feysh/corax/config/api/TaintProperty;", "Lcom/feysh/corax/config/api/ViaProperty;", "corax-config-api"})
public abstract class BuiltInField
implements IClassField {
    @NotNull
    private final String name;

    private BuiltInField(String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public /* synthetic */ BuiltInField(String name, DefaultConstructorMarker $constructor_marker) {
        this(name);
    }
}

