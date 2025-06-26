/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.plugin.CheckerFilterByName
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.plugin;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lcn/sast/framework/plugin/CheckerFilterByName;", "", "enables", "", "", "renameMap", "", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getEnables", "()Ljava/util/Set;", "getRenameMap", "()Ljava/util/Map;", "corax-framework"})
public final class CheckerFilterByName {
    @NotNull
    private final Set<String> enables;
    @NotNull
    private final Map<String, String> renameMap;

    public CheckerFilterByName(@NotNull Set<String> enables, @NotNull Map<String, String> renameMap2) {
        Intrinsics.checkNotNullParameter(enables, (String)"enables");
        Intrinsics.checkNotNullParameter(renameMap2, (String)"renameMap");
        this.enables = enables;
        this.renameMap = renameMap2;
    }

    @NotNull
    public final Set<String> getEnables() {
        return this.enables;
    }

    @NotNull
    public final Map<String, String> getRenameMap() {
        return this.renameMap;
    }
}

