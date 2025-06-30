/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.Position
 *  com.github.javaparser.Range
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.NodeList
 *  com.github.javaparser.ast.body.Parameter
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  de.fraunhofer.aisec.cpg.sarif.Region
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.Host
 *  soot.tagkit.SourceLnPosTag
 */
package com.feysh.corax.config.api.report;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootMethodExtend;
import com.feysh.corax.config.api.report.RegionKt;
import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002'(B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0011\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J1\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0014\u001a\u00020\u00158\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u00158\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006)"}, d2={"Lcom/feysh/corax/config/api/report/Region;", "", "startLine", "", "startColumn", "endLine", "endColumn", "<init>", "(IIII)V", "getEndLine", "()I", "getEndColumn", "mutable", "Lcom/feysh/corax/config/api/report/Region$Mutable;", "getMutable", "()Lcom/feysh/corax/config/api/report/Region$Mutable;", "toString", "", "compareTo", "other", "valid", "", "getValid", "()Z", "columnValid", "getColumnValid", "takeIfValid", "getTakeIfValid", "()Lcom/feysh/corax/config/api/report/Region;", "takeIfColumnValid", "getTakeIfColumnValid", "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "Mutable", "Companion", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\ncom/feysh/corax/config/api/report/Region\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n57#1:189\n59#1:190\n57#1,2:192\n1#2:188\n1#2:191\n*S KotlinDebug\n*F\n+ 1 Region.kt\ncom/feysh/corax/config/api/report/Region\n*L\n59#1:189\n60#1:190\n60#1:192,2\n60#1:191\n*E\n"})
public final class Region
implements Comparable<Region> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    public final int startLine;
    @JvmField
    public final int startColumn;
    private final int endLine;
    private final int endColumn;
    @NotNull
    private static final Region ERROR = new Region(-1, -1, -1, -1);

    public Region(int startLine, int startColumn, int endLine, int endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public final int getEndLine() {
        return this.endLine;
    }

    public final int getEndColumn() {
        return this.endColumn;
    }

    @NotNull
    public final Mutable getMutable() {
        return new Mutable(this.startLine, this.startColumn, this.endLine, this.endColumn);
    }

    @NotNull
    public String toString() {
        return this.startLine + ":" + this.startColumn + "-" + this.endLine + ":" + this.endColumn;
    }

    @Override
    public int compareTo(@NotNull Region other) {
        int n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        int comparisonValue = 0;
        int it = n = Intrinsics.compare((int)this.startLine, (int)other.startLine);
        boolean bl = false;
        comparisonValue = it;
        if (n != 0) {
            return comparisonValue;
        }
        it = n = Intrinsics.compare((int)this.startColumn, (int)other.startColumn);
        boolean bl2 = false;
        comparisonValue = it;
        if (n != 0) {
            return comparisonValue;
        }
        it = n = Intrinsics.compare((int)this.endLine, (int)other.endLine);
        boolean bl3 = false;
        comparisonValue = it;
        if (n != 0) {
            return -comparisonValue;
        }
        it = n = Intrinsics.compare((int)this.endColumn, (int)other.endColumn);
        boolean bl4 = false;
        comparisonValue = it;
        return n != 0 ? -comparisonValue : comparisonValue;
    }

    public final boolean getValid() {
        boolean $i$f$getValid = false;
        return this.startLine >= 0;
    }

    public final boolean getColumnValid() {
        boolean $i$f$getColumnValid = false;
        return this.startColumn >= 0 && this.getEndColumn() >= 0;
    }

    @Nullable
    public final Region getTakeIfValid() {
        Region region;
        boolean $i$f$getTakeIfValid = false;
        Region it = region = this;
        boolean bl = false;
        Region this_$iv = this;
        boolean $i$f$getValid = false;
        return this_$iv.startLine >= 0 ? region : null;
    }

    @Nullable
    public final Region getTakeIfColumnValid() {
        Region region;
        Region region2;
        boolean $i$f$getTakeIfColumnValid = false;
        Region this_$iv = this;
        boolean $i$f$getTakeIfValid = false;
        Region it$iv = region2 = this_$iv;
        boolean bl = false;
        Region this_$iv$iv = this_$iv;
        boolean $i$f$getValid = false;
        Region it = region = this_$iv$iv.startLine >= 0 ? region2 : null;
        boolean bl2 = false;
        Region this_$iv2 = this;
        boolean $i$f$getColumnValid = false;
        return this_$iv2.startColumn >= 0 && this_$iv2.getEndColumn() >= 0 ? region : null;
    }

    public final int component1() {
        return this.startLine;
    }

    public final int component2() {
        return this.startColumn;
    }

    public final int component3() {
        return this.endLine;
    }

    public final int component4() {
        return this.endColumn;
    }

    @NotNull
    public final Region copy(int startLine, int startColumn, int endLine, int endColumn) {
        return new Region(startLine, startColumn, endLine, endColumn);
    }

    public static /* synthetic */ Region copy$default(Region region, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = region.startLine;
        }
        if ((n5 & 2) != 0) {
            n2 = region.startColumn;
        }
        if ((n5 & 4) != 0) {
            n3 = region.endLine;
        }
        if ((n5 & 8) != 0) {
            n4 = region.endColumn;
        }
        return region.copy(n, n2, n3, n4);
    }

    public int hashCode() {
        int result = Integer.hashCode(this.startLine);
        result = result * 31 + Integer.hashCode(this.startColumn);
        result = result * 31 + Integer.hashCode(this.endLine);
        result = result * 31 + Integer.hashCode(this.endColumn);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Region)) {
            return false;
        }
        Region region = (Region)other;
        if (this.startLine != region.startLine) {
            return false;
        }
        if (this.startColumn != region.startColumn) {
            return false;
        }
        if (this.endLine != region.endLine) {
            return false;
        }
        return this.endColumn == region.endColumn;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0083\u0002\u00a2\u0006\u0002\b\fJ'\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\u0002J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0087\u0002\u00a2\u0006\u0002\b\u0012J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0011H\u0086\u0002J!\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\u0002J)\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014H\u0086\u0002J!\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0086\u0002J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0086\u0002J(\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0014J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0086\u0002J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020#H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020%H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020'H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020)H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0082\u0002J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0086\u0002J\u0018\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006-"}, d2={"Lcom/feysh/corax/config/api/report/Region$Companion;", "", "<init>", "()V", "ERROR", "Lcom/feysh/corax/config/api/report/Region;", "getERROR", "()Lcom/feysh/corax/config/api/report/Region;", "invoke", "startLine", "Ljava/util/Optional;", "Lcom/github/javaparser/Position;", "invoke_Optional_Position", "start", "end", "regionNode", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "Lcom/github/javaparser/Range;", "invoke_Optional_Range", "atLine", "", "stringToReport", "", "lineText", "inputToMatch", "matcher", "Ljava/util/regex/Matcher;", "getLineAndColumn", "Lkotlin/Triple;", "text", "index", "c", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "sootHost", "Lsoot/tagkit/Host;", "Lsoot/tagkit/AbstractHost;", "unit", "Lsoot/Unit;", "sootSourceLnPos", "Lsoot/tagkit/SourceLnPosTag;", "region", "Lde/fraunhofer/aisec/cpg/sarif/Region;", "getParamRegion", "sm", "Lsoot/SootMethod;", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\ncom/feysh/corax/config/api/report/Region$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 Region.kt\ncom/feysh/corax/config/api/report/Region\n*L\n1#1,187:1\n1#2:188\n1#2:196\n1#2:199\n1#2:202\n1#2:205\n1#2:208\n1#2:211\n1104#3,3:189\n1104#3,3:192\n59#4:195\n57#4:197\n59#4:198\n57#4:200\n59#4:201\n57#4:203\n59#4:204\n57#4:206\n59#4:207\n57#4:209\n59#4:210\n57#4:212\n*S KotlinDebug\n*F\n+ 1 Region.kt\ncom/feysh/corax/config/api/report/Region$Companion\n*L\n157#1:196\n162#1:199\n164#1:202\n166#1:205\n168#1:208\n171#1:211\n103#1:189,3\n107#1:192,3\n157#1:195\n157#1:197\n162#1:198\n162#1:200\n164#1:201\n164#1:203\n166#1:204\n166#1:206\n168#1:207\n168#1:209\n171#1:210\n171#1:212\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Region getERROR() {
            return ERROR;
        }

        @JvmName(name="invoke_Optional_Position")
        private final Region invoke_Optional_Position(Optional<Position> startLine) {
            if (!startLine.isPresent()) {
                return null;
            }
            Position position = startLine.get();
            Intrinsics.checkNotNullExpressionValue((Object)position, (String)"get(...)");
            return Companion.invoke(position);
        }

        private final Region invoke(Optional<Position> start, Optional<Position> end) {
            Optional<Position> optional;
            Optional<Position> optional2;
            Optional<Position> it = optional2 = start;
            boolean bl = false;
            Optional<Object> optional3 = it.isPresent() ? optional2 : null;
            Position start1 = optional3 != null ? optional3.get() : null;
            Optional<Position> it2 = optional = end;
            boolean bl2 = false;
            Optional<Object> optional4 = it2.isPresent() ? optional : null;
            Position end1 = optional4 != null ? optional4.get() : null;
            Position position = start1;
            if (position == null && (position = end1) == null) {
                return null;
            }
            start1 = position;
            Position position2 = end1;
            if (position2 == null) {
                position2 = start1;
            }
            end1 = position2;
            return Companion.invoke(start1, end1);
        }

        @Nullable
        public final Region invoke(@NotNull NodeWithRange<?> regionNode) {
            Intrinsics.checkNotNullParameter(regionNode, (String)"regionNode");
            Optional optional = regionNode.getBegin();
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getBegin(...)");
            Optional optional2 = regionNode.getEnd();
            Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getEnd(...)");
            return Companion.invoke(optional, optional2);
        }

        @JvmName(name="invoke_Optional_Range")
        @Nullable
        public final Region invoke_Optional_Range(@NotNull Optional<Range> regionNode) {
            Range range;
            Intrinsics.checkNotNullParameter(regionNode, (String)"regionNode");
            Range it = range = regionNode;
            boolean bl = false;
            Object object = it.isPresent() ? range : null;
            if (object == null || (object = object.get()) == null) {
                return null;
            }
            Range range2 = object;
            return Companion.invoke(range2);
        }

        @Nullable
        public final Region invoke(@NotNull Range regionNode) {
            Intrinsics.checkNotNullParameter((Object)regionNode, (String)"regionNode");
            Position position = regionNode.begin;
            Intrinsics.checkNotNullExpressionValue((Object)position, (String)"begin");
            return Companion.invoke(position, regionNode.end);
        }

        @NotNull
        public final Region invoke(int atLine, @NotNull String stringToReport, @NotNull String lineText) {
            Intrinsics.checkNotNullParameter((Object)stringToReport, (String)"stringToReport");
            Intrinsics.checkNotNullParameter((Object)lineText, (String)"lineText");
            Integer n = StringsKt.indexOf$default((CharSequence)lineText, (String)stringToReport, (int)0, (boolean)false, (int)6, null);
            int it = ((Number)n).intValue();
            boolean bl = false;
            Integer n2 = it >= 0 ? n : null;
            if (n2 == null) {
                return new Region(atLine, -1, atLine, -1);
            }
            int start = n2;
            int end = start + stringToReport.length();
            return Companion.invoke(atLine, lineText, start, end);
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Region invoke(int atLine, @NotNull String inputToMatch, int start, int end) {
            void $this$count$iv;
            void $this$count$iv2;
            Intrinsics.checkNotNullParameter((Object)inputToMatch, (String)"inputToMatch");
            if (!(start >= 0 && end >= 0)) {
                boolean $i$a$-check-Region$Companion$invoke$22 = false;
                String $i$a$-check-Region$Companion$invoke$22 = "atLine: " + atLine + ", inputToMatch: " + inputToMatch + ", start: " + start + ", end: " + end;
                throw new IllegalStateException($i$a$-check-Region$Companion$invoke$22.toString());
            }
            String string = inputToMatch.substring(0, start);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            CharSequence $i$a$-check-Region$Companion$invoke$22 = string;
            boolean $i$f$count = false;
            int count$iv22 = 0;
            for (int i = 0; i < $this$count$iv2.length(); ++i) {
                char element$iv;
                char it = element$iv = $this$count$iv2.charAt(i);
                boolean bl = false;
                if (!(it == '\n')) continue;
                ++count$iv22;
            }
            int startRow = count$iv22;
            int startCol = start - StringsKt.lastIndexOf$default((CharSequence)inputToMatch, (String)"\n", (int)start, (boolean)false, (int)4, null);
            String string2 = inputToMatch.substring(0, end);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
            CharSequence count$iv22 = string2;
            boolean $i$f$count2 = false;
            int count$iv = 0;
            for (int i = 0; i < $this$count$iv.length(); ++i) {
                char element$iv;
                char it = element$iv = $this$count$iv.charAt(i);
                boolean bl = false;
                if (!(it == '\n')) continue;
                ++count$iv;
            }
            int endRow = count$iv;
            int endCol = end - 1 - StringsKt.lastIndexOf$default((CharSequence)inputToMatch, (String)"\n", (int)(end - 1), (boolean)false, (int)4, null);
            return new Region(atLine + startRow, startCol, atLine + endRow, endCol + 1);
        }

        @NotNull
        public final Region invoke(int atLine, @NotNull String inputToMatch, @NotNull Matcher matcher) {
            Intrinsics.checkNotNullParameter((Object)inputToMatch, (String)"inputToMatch");
            Intrinsics.checkNotNullParameter((Object)matcher, (String)"matcher");
            return Companion.invoke(atLine, inputToMatch, matcher.start(), matcher.end());
        }

        @NotNull
        public final Region invoke(@NotNull String inputToMatch, @NotNull Matcher matcher) {
            Intrinsics.checkNotNullParameter((Object)inputToMatch, (String)"inputToMatch");
            Intrinsics.checkNotNullParameter((Object)matcher, (String)"matcher");
            String matchedText = matcher.group();
            int startIndex = matcher.start();
            int line = ((Number)this.getLineAndColumn(inputToMatch, startIndex).component2()).intValue();
            Intrinsics.checkNotNull((Object)matchedText);
            return Companion.invoke(line, matchedText, matcher);
        }

        @NotNull
        public final Triple<Integer, Integer, Integer> getLineAndColumn(@NotNull String text, int index) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            int line = 1;
            int col = 0;
            int start = 0;
            for (int i = 0; i < index; ++i) {
                if (text.charAt(i) == '\n') {
                    ++line;
                    start = i + 1;
                    col = 0;
                    continue;
                }
                ++col;
            }
            return new Triple((Object)start, (Object)line, (Object)col);
        }

        @Nullable
        public final Region invoke(@NotNull SootInfoCache c, @NotNull Host sootHost) {
            Region region;
            Intrinsics.checkNotNullParameter((Object)c, (String)"c");
            Intrinsics.checkNotNullParameter((Object)sootHost, (String)"sootHost");
            if (sootHost instanceof Unit) {
                region = Companion.invoke((Unit)sootHost);
            } else if (sootHost instanceof AbstractHost) {
                region = Companion.invoke(c, (AbstractHost)sootHost);
            } else {
                throw new IllegalStateException(("Host: " + sootHost + " is not unsupported yet").toString());
            }
            return region;
        }

        /*
         * WARNING - void declaration
         */
        @Nullable
        public final Region invoke(@NotNull SootInfoCache c, @NotNull AbstractHost sootHost) {
            void this_$iv;
            void var7_7;
            Intrinsics.checkNotNullParameter((Object)c, (String)"c");
            Intrinsics.checkNotNullParameter((Object)sootHost, (String)"sootHost");
            SootInfoCache $this$invoke_u24lambda_u247 = c;
            boolean bl = false;
            Region region = new Region($this$invoke_u24lambda_u247.getJavaNameSourceStartLineNumber(sootHost), $this$invoke_u24lambda_u247.getJavaNameSourceStartColumnNumber(sootHost), $this$invoke_u24lambda_u247.getJavaNameSourceEndLineNumber(sootHost), $this$invoke_u24lambda_u247.getJavaNameSourceEndColumnNumber(sootHost));
            boolean $i$f$getTakeIfValid = false;
            void it$iv = var7_7 = this_$iv;
            boolean bl2 = false;
            void this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            return this_$iv$iv.startLine >= 0 ? var7_7 : null;
        }

        @Nullable
        public final Region invoke(@NotNull Unit unit) {
            Object object;
            block4: {
                Region region;
                block3: {
                    Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
                    object = RegionKt.getPos((Host)unit);
                    if (object == null) break block3;
                    SourceLnPosTag it = object;
                    boolean bl = false;
                    Region region2 = Companion.invoke(it);
                    object = region2;
                    if (region2 != null) break block4;
                }
                Region this_$iv = new Region(unit.getJavaSourceStartLineNumber(), unit.getJavaSourceStartColumnNumber(), -1, -1);
                boolean $i$f$getTakeIfValid = false;
                Region it$iv = region = this_$iv;
                boolean bl = false;
                Region this_$iv$iv = this_$iv;
                boolean $i$f$getValid = false;
                object = this_$iv$iv.startLine >= 0 ? region : null;
            }
            return object;
        }

        @Nullable
        public final Region invoke(@NotNull SourceLnPosTag sootSourceLnPos) {
            Region region;
            Intrinsics.checkNotNullParameter((Object)sootSourceLnPos, (String)"sootSourceLnPos");
            Region this_$iv = new Region(sootSourceLnPos.startLn(), sootSourceLnPos.startPos(), sootSourceLnPos.endLn(), sootSourceLnPos.endPos());
            boolean $i$f$getTakeIfValid = false;
            Region it$iv = region = this_$iv;
            boolean bl = false;
            Region this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            return this_$iv$iv.startLine >= 0 ? region : null;
        }

        @Nullable
        public final Region invoke(@NotNull de.fraunhofer.aisec.cpg.sarif.Region region) {
            Region region2;
            Intrinsics.checkNotNullParameter((Object)region, (String)"region");
            Region this_$iv = new Region(region.startLine, region.startColumn, region.getEndLine(), region.getEndColumn());
            boolean $i$f$getTakeIfValid = false;
            Region it$iv = region2 = this_$iv;
            boolean bl = false;
            Region this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            return this_$iv$iv.startLine >= 0 ? region2 : null;
        }

        private final Region invoke(Position start) {
            Region region;
            Region this_$iv = new Region(start.line, start.column, -1, -1);
            boolean $i$f$getTakeIfValid = false;
            Region it$iv = region = this_$iv;
            boolean bl = false;
            Region this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            return this_$iv$iv.startLine >= 0 ? region : null;
        }

        @Nullable
        public final Region invoke(@NotNull Position start, @Nullable Position end) {
            Region region;
            Intrinsics.checkNotNullParameter((Object)start, (String)"start");
            Position position = end;
            Position position2 = end;
            Region this_$iv = new Region(start.line, start.column, position != null ? position.line : -1, position2 != null ? position2.column : -1);
            boolean $i$f$getTakeIfValid = false;
            Region it$iv = region = this_$iv;
            boolean bl = false;
            Region this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            return this_$iv$iv.startLine >= 0 ? region : null;
        }

        @Nullable
        public final Region getParamRegion(@NotNull SootMethod sm, int index) {
            Region region;
            Region region2;
            Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
            SootMethodExtend sootMethodExtend = (SootMethodExtend)AnalysisCache.G.INSTANCE.sootHost2decl((Host)sm);
            if (sootMethodExtend == null) {
                return null;
            }
            SootMethodExtend method = sootMethodExtend;
            if (index == -1) {
                region2 = null;
            } else if (index >= 0 && index < sm.getParameterCount()) {
                NodeList nodeList = method.getDecl();
                if (nodeList != null && (nodeList = nodeList.getParameters()) != null && (nodeList = (Parameter)CollectionsKt.getOrNull((List)((List)nodeList), (int)index)) != null) {
                    NodeList it = nodeList;
                    boolean bl = false;
                    region2 = Companion.invoke((NodeWithRange)it);
                } else {
                    region2 = null;
                }
            } else {
                region2 = region = null;
            }
            if (region2 == null) {
                NodeWithRange<Node> nodeWithRange = method.getNameDecl();
                if (nodeWithRange != null) {
                    NodeWithRange<Node> it = nodeWithRange;
                    boolean bl = false;
                    region = Companion.invoke(it);
                } else {
                    region = null;
                }
            }
            return region;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2={"Lcom/feysh/corax/config/api/report/Region$Mutable;", "", "startLine", "", "startColumn", "endLine", "endColumn", "<init>", "(IIII)V", "getEndLine", "()I", "setEndLine", "(I)V", "getEndColumn", "setEndColumn", "toString", "", "immutable", "Lcom/feysh/corax/config/api/report/Region;", "getImmutable", "()Lcom/feysh/corax/config/api/report/Region;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "corax-config-api"})
    public static final class Mutable {
        @JvmField
        public int startLine;
        @JvmField
        public int startColumn;
        private int endLine;
        private int endColumn;

        public Mutable(int startLine, int startColumn, int endLine, int endColumn) {
            this.startLine = startLine;
            this.startColumn = startColumn;
            this.endLine = endLine;
            this.endColumn = endColumn;
        }

        public final int getEndLine() {
            return this.endLine;
        }

        public final void setEndLine(int n) {
            this.endLine = n;
        }

        public final int getEndColumn() {
            return this.endColumn;
        }

        public final void setEndColumn(int n) {
            this.endColumn = n;
        }

        @NotNull
        public String toString() {
            return this.startLine + ":" + this.startColumn + "-" + this.endLine + ":" + this.endColumn;
        }

        @NotNull
        public final Region getImmutable() {
            return new Region(this.startLine, this.startColumn, this.endLine, this.endColumn);
        }

        public final int component1() {
            return this.startLine;
        }

        public final int component2() {
            return this.startColumn;
        }

        public final int component3() {
            return this.endLine;
        }

        public final int component4() {
            return this.endColumn;
        }

        @NotNull
        public final Mutable copy(int startLine, int startColumn, int endLine, int endColumn) {
            return new Mutable(startLine, startColumn, endLine, endColumn);
        }

        public static /* synthetic */ Mutable copy$default(Mutable mutable, int n, int n2, int n3, int n4, int n5, Object object) {
            if ((n5 & 1) != 0) {
                n = mutable.startLine;
            }
            if ((n5 & 2) != 0) {
                n2 = mutable.startColumn;
            }
            if ((n5 & 4) != 0) {
                n3 = mutable.endLine;
            }
            if ((n5 & 8) != 0) {
                n4 = mutable.endColumn;
            }
            return mutable.copy(n, n2, n3, n4);
        }

        public int hashCode() {
            int result = Integer.hashCode(this.startLine);
            result = result * 31 + Integer.hashCode(this.startColumn);
            result = result * 31 + Integer.hashCode(this.endLine);
            result = result * 31 + Integer.hashCode(this.endColumn);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mutable)) {
                return false;
            }
            Mutable mutable = (Mutable)other;
            if (this.startLine != mutable.startLine) {
                return false;
            }
            if (this.startColumn != mutable.startColumn) {
                return false;
            }
            if (this.endLine != mutable.endLine) {
                return false;
            }
            return this.endColumn == mutable.endColumn;
        }
    }
}

