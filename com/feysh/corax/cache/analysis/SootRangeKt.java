/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.tagkit.Host
 *  soot.tagkit.LineNumberTag
 *  soot.tagkit.SourceLnNamePosTag
 *  soot.tagkit.Tag
 */
package com.feysh.corax.cache.analysis;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceLnNamePosTag;
import soot.tagkit.Tag;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u00a2\u0006\u0002\u0010\u0003\"#\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"findLineNumber", "", "Lsoot/tagkit/Host;", "(Lsoot/tagkit/Host;)Ljava/lang/Integer;", "range", "Lkotlin/Pair;", "Lsoot/SootMethod;", "getRange", "(Lsoot/SootMethod;)Lkotlin/Pair;", "corax-config-api"})
public final class SootRangeKt {
    @Nullable
    public static final Integer findLineNumber(@NotNull Host $this$findLineNumber) {
        Intrinsics.checkNotNullParameter((Object)$this$findLineNumber, (String)"<this>");
        if ($this$findLineNumber.getJavaSourceStartLineNumber() != -1) {
            return $this$findLineNumber.getJavaSourceStartLineNumber();
        }
        for (Tag tag : $this$findLineNumber.getTags()) {
            if (tag instanceof LineNumberTag && ((LineNumberTag)tag).getLineNumber() >= 0) {
                return ((LineNumberTag)tag).getLineNumber();
            }
            if (!(tag instanceof SourceLnNamePosTag) || ((SourceLnNamePosTag)tag).startLn() < 0) continue;
            return ((SourceLnNamePosTag)tag).startLn();
        }
        return null;
    }

    @Nullable
    public static final Pair<Integer, Integer> getRange(@NotNull SootMethod $this$range) {
        Intrinsics.checkNotNullParameter((Object)$this$range, (String)"<this>");
        if (!$this$range.hasActiveBody()) {
            return null;
        }
        UnitPatchingChain units = $this$range.getActiveBody().getUnits();
        int firstLineNumber = 0;
        firstLineNumber = -1;
        int lastLineNumber = 0;
        lastLineNumber = -1;
        Iterator iterator = units.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            Unit u = (Unit)iterator2.next();
            u.getJavaSourceStartLineNumber();
            Intrinsics.checkNotNull((Object)u);
            Integer n = SootRangeKt.findLineNumber((Host)u);
            if (n == null) continue;
            int it = ((Number)n).intValue();
            boolean bl = false;
            if (firstLineNumber == -1) {
                firstLineNumber = it;
            }
            firstLineNumber = Math.min(firstLineNumber, it);
            lastLineNumber = Math.max(lastLineNumber, it);
        }
        if (firstLineNumber == -1 || lastLineNumber == -1) {
            if (firstLineNumber != -1) {
                return TuplesKt.to((Object)firstLineNumber, (Object)firstLineNumber);
            }
            if (lastLineNumber != -1) {
                return TuplesKt.to((Object)lastLineNumber, (Object)lastLineNumber);
            }
            return null;
        }
        if (firstLineNumber > lastLineNumber) {
            return TuplesKt.to((Object)lastLineNumber, (Object)lastLineNumber);
        }
        return TuplesKt.to((Object)firstLineNumber, (Object)lastLineNumber);
    }
}

