/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BuiltInField;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/feysh/corax/config/api/MapValues;", "Lcom/feysh/corax/config/api/BuiltInField;", "<init>", "()V", "corax-config-api"})
public final class MapValues
extends BuiltInField {
    @NotNull
    public static final MapValues INSTANCE = new MapValues();

    private MapValues() {
        super("mapValues", null);
    }
}

