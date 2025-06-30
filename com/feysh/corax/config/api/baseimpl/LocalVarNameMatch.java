/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.Local
 *  soot.Scene
 *  soot.SootMethod
 *  soot.jimple.JimpleBody
 *  soot.util.Chain
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.ILocalVarMatch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.Local;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.JimpleBody;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/config/api/baseimpl/LocalVarNameMatch;", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "sm", "Lsoot/SootMethod;", "name", "", "<init>", "(Lsoot/SootMethod;Ljava/lang/String;)V", "getSm", "()Lsoot/SootMethod;", "getName", "()Ljava/lang/String;", "matched", "", "Lsoot/Local;", "scene", "Lsoot/Scene;", "match", "", "local", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAIAnalysisBaseImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/LocalVarNameMatch\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1477:1\n774#2:1478\n865#2,2:1479\n*S KotlinDebug\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/LocalVarNameMatch\n*L\n890#1:1478\n890#1:1479,2\n*E\n"})
public final class LocalVarNameMatch
implements ILocalVarMatch {
    @NotNull
    private final SootMethod sm;
    @NotNull
    private final String name;

    public LocalVarNameMatch(@NotNull SootMethod sm, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.sm = sm;
        this.name = name;
    }

    @NotNull
    public final SootMethod getSm() {
        return this.sm;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<Local> matched(@NotNull Scene scene) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        if (!this.sm.hasActiveBody()) {
            return CollectionsKt.emptyList();
        }
        Body body = this.sm.getActiveBody();
        JimpleBody jimpleBody = body instanceof JimpleBody ? (JimpleBody)body : null;
        if (jimpleBody == null) {
            return CollectionsKt.emptyList();
        }
        JimpleBody acBody = jimpleBody;
        Chain chain = acBody.getLocals();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getLocals(...)");
        Iterable $this$filter$iv = (Iterable)chain;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Local it = (Local)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            if (!this.match(it)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    public final boolean match(@NotNull Local local) {
        Intrinsics.checkNotNullParameter((Object)local, (String)"local");
        return Intrinsics.areEqual((Object)this.name, (Object)local.getName());
    }
}

