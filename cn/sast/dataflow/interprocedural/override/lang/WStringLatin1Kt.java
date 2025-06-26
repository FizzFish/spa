/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.override.lang.WStringLatin1Kt
 *  kotlin.Metadata
 */
package cn.sast.dataflow.interprocedural.override.lang;

import kotlin.Metadata;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2={"canEncode", "", "cp", "", "corax-data-flow"})
public final class WStringLatin1Kt {
    public static final boolean canEncode(int cp) {
        return cp >>> 8 == 0;
    }
}

