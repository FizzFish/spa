package com.feysh.corax.config.api.report;

import com.github.javaparser.Position;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootMethodExtend;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.List;
import kotlin.Triple;
import java.util.Optional;
import java.util.regex.Matcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;

public final class Region implements Comparable<Region> {
    public static final Region ERROR = new Region(-1, -1, -1, -1);
    public static final Companion Companion = new Companion();
    
    public final int startLine;
    public final int startColumn;
    private final int endLine;
    private final int endColumn;

    public Region(int startLine, int startColumn, int endLine, int endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public final int getEndLine() {
        return endLine;
    }

    public final int getEndColumn() {
        return endColumn;
    }

    @NotNull
    public final Mutable getMutable() {
        return new Mutable(startLine, startColumn, endLine, endColumn);
    }

    @NotNull
    public String toString() {
        return startLine + ":" + startColumn + "-" + endLine + ":" + endColumn;
    }

    @Override
    public int compareTo(@NotNull Region other) {
        if (startLine != other.startLine) {
            return Integer.compare(startLine, other.startLine);
        }
        if (startColumn != other.startColumn) {
            return Integer.compare(startColumn, other.startColumn);
        }
        if (endLine != other.endLine) {
            return -Integer.compare(endLine, other.endLine);
        }
        return -Integer.compare(endColumn, other.endColumn);
    }

    public final boolean isValid() {
        return startLine >= 0;
    }

    public final boolean isColumnValid() {
        return startColumn >= 0 && endColumn >= 0;
    }

    @Nullable
    public final Region takeIfValid() {
        return isValid() ? this : null;
    }

    @Nullable
    public final Region takeIfColumnValid() {
        return isValid() && isColumnValid() ? this : null;
    }

    public final int component1() {
        return startLine;
    }

    public final int component2() {
        return startColumn;
    }

    public final int component3() {
        return endLine;
    }

    public final int component4() {
        return endColumn;
    }

    @NotNull
    public final Region copy(int startLine, int startColumn, int endLine, int endColumn) {
        return new Region(startLine, startColumn, endLine, endColumn);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(startLine);
        result = 31 * result + Integer.hashCode(startColumn);
        result = 31 * result + Integer.hashCode(endLine);
        result = 31 * result + Integer.hashCode(endColumn);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Region)) return false;
        Region region = (Region) other;
        return startLine == region.startLine &&
               startColumn == region.startColumn &&
               endLine == region.endLine &&
               endColumn == region.endColumn;
    }

    public static final class Companion {
        @NotNull
        public final Region getERROR() {
            return ERROR;
        }

        @Nullable
        private Region invoke(@NotNull Optional<Position> startLine) {
            return startLine.map(this::invoke).orElse(null);
        }

        @Nullable
        private Region invoke(@NotNull Optional<Position> start, @NotNull Optional<Position> end) {
            Position startPos = start.orElse(null);
            Position endPos = end.orElse(null);
            
            if (startPos == null && endPos == null) {
                return null;
            }
            
            return invoke(startPos != null ? startPos : endPos, endPos != null ? endPos : startPos);
        }

        @Nullable
        public final Region invoke(@NotNull NodeWithRange<?> regionNode) {
            return invoke(regionNode.getBegin(), regionNode.getEnd());
        }

        @Nullable
        public final Region invoke(@NotNull Optional<Range> regionNode) {
            return regionNode.map(this::invoke).orElse(null);
        }

        @Nullable
        public final Region invoke(@NotNull Range regionNode) {
            return invoke(regionNode.begin, regionNode.end);
        }

        @NotNull
        public final Region invoke(int atLine, @NotNull String stringToReport, @NotNull String lineText) {
            int start = lineText.indexOf(stringToReport);
            if (start < 0) {
                return new Region(atLine, -1, atLine, -1);
            }
            return invoke(atLine, lineText, start, start + stringToReport.length());
        }

        @NotNull
        public final Region invoke(int atLine, @NotNull String inputToMatch, int start, int end) {
            if (start < 0 || end < 0) {
                throw new IllegalStateException("Invalid positions: atLine=" + atLine + 
                    ", inputToMatch=" + inputToMatch + ", start=" + start + ", end=" + end);
            }

            String beforeStart = inputToMatch.substring(0, start);
            int startRow = countNewlines(beforeStart);
            int startCol = start - inputToMatch.lastIndexOf("\n", start);
            
            String beforeEnd = inputToMatch.substring(0, end);
            int endRow = countNewlines(beforeEnd);
            int endCol = end - 1 - inputToMatch.lastIndexOf("\n", end - 1);
            
            return new Region(
                atLine + startRow, startCol, 
                atLine + endRow, endCol + 1
            );
        }

        private int countNewlines(CharSequence text) {
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '\n') {
                    count++;
                }
            }
            return count;
        }

        @NotNull
        public final Region invoke(int atLine, @NotNull String inputToMatch, @NotNull Matcher matcher) {
            return invoke(atLine, inputToMatch, matcher.start(), matcher.end());
        }

        @NotNull
        public final Region invoke(@NotNull String inputToMatch, @NotNull Matcher matcher) {
            String matchedText = matcher.group();
            int startIndex = matcher.start();
            int line = getLineAndColumn(inputToMatch, startIndex).getSecond();
            return invoke(line, matchedText, matcher);
        }

        @NotNull
        public final Triple<Integer, Integer, Integer> getLineAndColumn(@NotNull String text, int index) {
            int line = 1;
            int col = 0;
            int start = 0;
            
            for (int i = 0; i < index; i++) {
                if (text.charAt(i) == '\n') {
                    line++;
                    start = i + 1;
                    col = 0;
                } else {
                    col++;
                }
            }
            return new Triple<>(start, line, col);
        }

        @Nullable
        public final Region invoke(@NotNull SootInfoCache c, @NotNull Host sootHost) {
            if (sootHost instanceof Unit) {
                return invoke((Unit) sootHost);
            } else if (sootHost instanceof AbstractHost) {
                return invoke(c, (AbstractHost) sootHost);
            }
            throw new IllegalStateException("Host: " + sootHost + " is not supported yet");
        }

        @Nullable
        public final Region invoke(@NotNull SootInfoCache c, @NotNull AbstractHost sootHost) {
            Region region = new Region(
                c.getJavaNameSourceStartLineNumber(sootHost),
                c.getJavaNameSourceStartColumnNumber(sootHost),
                c.getJavaNameSourceEndLineNumber(sootHost),
                c.getJavaNameSourceEndColumnNumber(sootHost)
            );
            return region.takeIfValid();
        }

        @Nullable
        public final Region invoke(@NotNull Unit unit) {
            SourceLnPosTag tag = RegionKt.getPos(unit);
            if (tag != null) {
                Region result = invoke(tag);
                if (result != null) {
                    return result;
                }
            }
            
            Region region = new Region(
                unit.getJavaSourceStartLineNumber(),
                unit.getJavaSourceStartColumnNumber(),
                -1, -1
            );
            return region.takeIfValid();
        }

        @Nullable
        public final Region invoke(@NotNull SourceLnPosTag sootSourceLnPos) {
            Region region = new Region(
                sootSourceLnPos.startLn(),
                sootSourceLnPos.startPos(),
                sootSourceLnPos.endLn(),
                sootSourceLnPos.endPos()
            );
            return region.takeIfValid();
        }

        @Nullable
        public final Region invoke(@NotNull de.fraunhofer.aisec.cpg.sarif.Region region) {
            Region result = new Region(
                region.startLine,
                region.startColumn,
                region.getEndLine(),
                region.getEndColumn()
            );
            return result.takeIfValid();
        }

        @Nullable
        private Region invoke(@NotNull Position start) {
            Region region = new Region(start.line, start.column, -1, -1);
            return region.takeIfValid();
        }

        @Nullable
        public final Region invoke(@NotNull Position start, @Nullable Position end) {
            Region region = new Region(
                start.line, 
                start.column,
                end != null ? end.line : -1,
                end != null ? end.column : -1
            );
            return region.takeIfValid();
        }

        @Nullable
        public final Region getParamRegion(@NotNull SootMethod sm, int index) {
            SootMethodExtend method = (SootMethodExtend) AnalysisCache.G.INSTANCE.sootHost2decl(sm);
            if (method == null) {
                return null;
            }

            if (index >= 0 && index < sm.getParameterCount()) {
                NodeList<Parameter> parameters = method.getDecl() != null ? 
                    method.getDecl().getParameters() : null;
                if (parameters != null && index < parameters.size()) {
                    Parameter param = parameters.get(index);
                    return invoke(param);
                }
            }

            NodeWithRange<Node> nameDecl = method.getNameDecl();
            return nameDecl != null ? invoke(nameDecl) : null;
        }
    }

    public static final class Mutable {
        public int startLine;
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
            return endLine;
        }

        public final void setEndLine(int endLine) {
            this.endLine = endLine;
        }

        public final int getEndColumn() {
            return endColumn;
        }

        public final void setEndColumn(int endColumn) {
            this.endColumn = endColumn;
        }

        @NotNull
        public String toString() {
            return startLine + ":" + startColumn + "-" + endLine + ":" + endColumn;
        }

        @NotNull
        public final Region getImmutable() {
            return new Region(startLine, startColumn, endLine, endColumn);
        }

        public final int component1() {
            return startLine;
        }

        public final int component2() {
            return startColumn;
        }

        public final int component3() {
            return endLine;
        }

        public final int component4() {
            return endColumn;
        }

        @NotNull
        public final Mutable copy(int startLine, int startColumn, int endLine, int endColumn) {
            return new Mutable(startLine, startColumn, endLine, endColumn);
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(startLine);
            result = 31 * result + Integer.hashCode(startColumn);
            result = 31 * result + Integer.hashCode(endLine);
            result = 31 * result + Integer.hashCode(endColumn);
            return result;
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (this == other) return true;
            if (!(other instanceof Mutable)) return false;
            Mutable mutable = (Mutable) other;
            return startLine == mutable.startLine &&
                   startColumn == mutable.startColumn &&
                   endLine == mutable.endLine &&
                   endColumn == mutable.endColumn;
        }
    }
}
