package cn.sast.api.config;

import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public final class CheckerInfoGenResult {
    @NotNull
    private final LinkedHashSet<CheckerInfo> checkerInfoList;
    @NotNull
    private final LinkedHashSet<CheckType> existsCheckTypes;
    @NotNull
    private final LinkedHashSet<String> existsCheckerIds;
    @NotNull
    private final LinkedHashSet<String> checkerIdInCsv;

    public CheckerInfoGenResult(@NotNull LinkedHashSet<CheckerInfo> checkerInfoList, 
                              @NotNull LinkedHashSet<CheckType> existsCheckTypes,
                              @NotNull LinkedHashSet<String> existsCheckerIds,
                              @NotNull LinkedHashSet<String> checkerIdInCsv) {
        Objects.requireNonNull(checkerInfoList, "checkerInfoList");
        Objects.requireNonNull(existsCheckTypes, "existsCheckTypes");
        Objects.requireNonNull(existsCheckerIds, "existsCheckerIds");
        Objects.requireNonNull(checkerIdInCsv, "checkerIdInCsv");
        this.checkerInfoList = checkerInfoList;
        this.existsCheckTypes = existsCheckTypes;
        this.existsCheckerIds = existsCheckerIds;
        this.checkerIdInCsv = checkerIdInCsv;
    }

    @NotNull
    public LinkedHashSet<CheckerInfo> getCheckerInfoList() {
        return checkerInfoList;
    }

    @NotNull
    public LinkedHashSet<CheckType> getExistsCheckTypes() {
        return existsCheckTypes;
    }

    @NotNull
    public LinkedHashSet<String> getExistsCheckerIds() {
        return existsCheckerIds;
    }

    @NotNull
    public LinkedHashSet<String> getCheckerIdInCsv() {
        return checkerIdInCsv;
    }

    @NotNull
    public List<ChapterFlat> getChapters() {
        List<ChapterFlat> result = new ArrayList<>();
        for (CheckerInfo info : checkerInfoList) {
            ChapterFlat chapter = info.getChapterFlat();
            if (chapter != null) {
                result.add(chapter);
            }
        }
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CheckerInfoGenResult)) return false;
        CheckerInfoGenResult that = (CheckerInfoGenResult) other;
        return checkerInfoList.equals(that.checkerInfoList) &&
               existsCheckTypes.equals(that.existsCheckTypes) &&
               existsCheckerIds.equals(that.existsCheckerIds) &&
               checkerIdInCsv.equals(that.checkerIdInCsv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkerInfoList, existsCheckTypes, existsCheckerIds, checkerIdInCsv);
    }

    @Override
    public String toString() {
        return "CheckerInfoGenResult(checkerInfoList=" + checkerInfoList + 
               ", existsCheckTypes=" + existsCheckTypes + 
               ", existsCheckerIds=" + existsCheckerIds + 
               ", checkerIdInCsv=" + checkerIdInCsv + ")";
    }
}