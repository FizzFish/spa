package com.feysh.corax.config.api.report;

import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;
import soot.tagkit.Tag;

public final class RegionKt {
    @Nullable
    public static Region getConvert(@NotNull de.fraunhofer.aisec.cpg.sarif.Region region) {
        if (region == null) {
            throw new NullPointerException("<this>");
        }
        return Region.Companion.invoke(region);
    }

    @Nullable
    public static SourceLnPosTag getPos(@NotNull Host host) {
        if (host == null) {
            throw new NullPointerException("<this>");
        }
        Tag tag = host.getTag("SourceLnPosTag");
        return tag instanceof SourceLnPosTag ? (SourceLnPosTag) tag : null;
    }
}