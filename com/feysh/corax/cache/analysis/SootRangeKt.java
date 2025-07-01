package com.feysh.corax.cache.analysis;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.tagkit.Host;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceLnNamePosTag;
import soot.tagkit.Tag;

public final class SootRangeKt {
    @Nullable
    public static Integer findLineNumber(@NotNull Host host) {
        if (host == null) {
            throw new NullPointerException("host is null");
        }
        if (host.getJavaSourceStartLineNumber() != -1) {
            return host.getJavaSourceStartLineNumber();
        }
        for (Tag tag : host.getTags()) {
            if (tag instanceof LineNumberTag && ((LineNumberTag)tag).getLineNumber() >= 0) {
                return ((LineNumberTag)tag).getLineNumber();
            }
            if (tag instanceof SourceLnNamePosTag && ((SourceLnNamePosTag)tag).startLn() >= 0) {
                return ((SourceLnNamePosTag)tag).startLn();
            }
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> getRange(@NotNull SootMethod method) {
        if (method == null) {
            throw new NullPointerException("method is null");
        }
        if (!method.hasActiveBody()) {
            return null;
        }

        UnitPatchingChain units = method.getActiveBody().getUnits();
        int firstLineNumber = -1;
        int lastLineNumber = -1;

        for (Unit u : units) {
            Integer lineNumber = findLineNumber(u);
            if (lineNumber == null) {
                continue;
            }
            int line = lineNumber;
            if (firstLineNumber == -1) {
                firstLineNumber = line;
            }
            firstLineNumber = Math.min(firstLineNumber, line);
            lastLineNumber = Math.max(lastLineNumber, line);
        }

        if (firstLineNumber == -1 || lastLineNumber == -1) {
            if (firstLineNumber != -1) {
                return new Pair<>(firstLineNumber, firstLineNumber);
            }
            if (lastLineNumber != -1) {
                return new Pair<>(lastLineNumber, lastLineNumber);
            }
            return null;
        }

        if (firstLineNumber > lastLineNumber) {
            return new Pair<>(lastLineNumber, lastLineNumber);
        }
        return new Pair<>(firstLineNumber, lastLineNumber);
    }

    public static final class Pair<A, B> {
        public final A first;
        public final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}