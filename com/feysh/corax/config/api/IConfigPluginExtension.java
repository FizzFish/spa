/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.pf4j.ExtensionPoint
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.pf4j.ExtensionPoint;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\"\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/IConfigPluginExtension;", "Lorg/pf4j/ExtensionPoint;", "units", "Ljava/util/LinkedHashSet;", "Lcom/feysh/corax/config/api/CheckerUnit;", "Lkotlin/collections/LinkedHashSet;", "getUnits", "()Ljava/util/LinkedHashSet;", "sootConfig", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "getSootConfig", "()Lcom/feysh/corax/config/api/ISootInitializeHandler;", "name", "", "getName", "()Ljava/lang/String;", "corax-config-api"})
public interface IConfigPluginExtension
extends ExtensionPoint {
    @NotNull
    public LinkedHashSet<CheckerUnit> getUnits();

    @NotNull
    public ISootInitializeHandler getSootConfig();

    @NotNull
    public String getName();
}

