/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.fraunhofer.aisec.cpg.sarif.Region
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.tagkit.Host
 *  soot.tagkit.SourceLnPosTag
 *  soot.tagkit.Tag
 */
package com.feysh.corax.config.api.report;

import com.feysh.corax.config.api.report.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;
import soot.tagkit.Tag;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"convert", "Lcom/feysh/corax/config/api/report/Region;", "Lde/fraunhofer/aisec/cpg/sarif/Region;", "getConvert", "(Lde/fraunhofer/aisec/cpg/sarif/Region;)Lcom/feysh/corax/config/api/report/Region;", "pos", "Lsoot/tagkit/SourceLnPosTag;", "Lsoot/tagkit/Host;", "getPos", "(Lsoot/tagkit/Host;)Lsoot/tagkit/SourceLnPosTag;", "corax-config-api"})
public final class RegionKt {
    @Nullable
    public static final Region getConvert(@NotNull de.fraunhofer.aisec.cpg.sarif.Region $this$convert) {
        Intrinsics.checkNotNullParameter((Object)$this$convert, (String)"<this>");
        return Region.Companion.invoke($this$convert);
    }

    @Nullable
    public static final SourceLnPosTag getPos(@NotNull Host $this$pos) {
        Intrinsics.checkNotNullParameter((Object)$this$pos, (String)"<this>");
        Tag tag = $this$pos.getTag("SourceLnPosTag");
        return tag instanceof SourceLnPosTag ? (SourceLnPosTag)tag : null;
    }
}

