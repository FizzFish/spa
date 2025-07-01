package cn.sast.api.config;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class CheckerPriorityConfig {
    @NotNull
    private final List<String> categoryList;
    @NotNull
    private final List<String> severityList;

    public CheckerPriorityConfig(@NotNull List<String> categoryList, @NotNull List<String> severityList) {
        if (categoryList == null) {
            throw new IllegalArgumentException("categoryList cannot be null");
        }
        if (severityList == null) {
            throw new IllegalArgumentException("severityList cannot be null");
        }
        this.categoryList = categoryList;
        this.severityList = severityList;
    }

    @NotNull
    public List<String> getCategoryList() {
        return categoryList;
    }

    @NotNull
    public List<String> getSeverityList() {
        return severityList;
    }

    private Comparator<ChapterFlat> getComparator() {
        Map<String, Integer> categoryMap = new LinkedHashMap<>();
        for (int i = 0; i < categoryList.size(); i++) {
            categoryMap.put(categoryList.get(i), i);
        }

        Map<String, Integer> severityMap = new LinkedHashMap<>();
        for (int i = 0; i < severityList.size(); i++) {
            severityMap.put(severityList.get(i), i);
        }

        return Comparator.<ChapterFlat>comparingInt(chapter -> 
            categoryMap.getOrDefault(chapter.getCategory(), Integer.MAX_VALUE)
        ).thenComparingInt(chapter -> 
            severityMap.getOrDefault(chapter.getSeverity(), Integer.MAX_VALUE)
        );
    }

    private List<ChapterFlat> sort(List<ChapterFlat> chapters) {
        return chapters.stream()
            .sorted(getComparator())
            .collect(Collectors.toList());
    }

    @NotNull
    public Map<String, Map<String, List<String>>> getSortTree(@NotNull List<ChapterFlat> chapters) {
        if (chapters == null) {
            throw new IllegalArgumentException("chapters cannot be null");
        }

        Map<String, List<ChapterFlat>> groupedByCategory = sort(chapters).stream()
            .collect(Collectors.groupingBy(
                ChapterFlat::getCategory,
                LinkedHashMap::new,
                Collectors.toList()
            ));

        Map<String, Map<String, List<String>>> result = new LinkedHashMap<>();
        groupedByCategory.forEach((category, categoryChapters) -> {
            Map<String, List<String>> severityMap = categoryChapters.stream()
                .collect(Collectors.groupingBy(
                    ChapterFlat::getSeverity,
                    LinkedHashMap::new,
                    Collectors.mapping(ChapterFlat::getRuleId, Collectors.toList())
                ));
            result.put(category, severityMap);
        });

        return result;
    }

    @NotNull
    public List<String> component1() {
        return categoryList;
    }

    @NotNull
    public List<String> component2() {
        return severityList;
    }

    @NotNull
    public CheckerPriorityConfig copy(@NotNull List<String> categoryList, @NotNull List<String> severityList) {
        if (categoryList == null) {
            throw new IllegalArgumentException("categoryList cannot be null");
        }
        if (severityList == null) {
            throw new IllegalArgumentException("severityList cannot be null");
        }
        return new CheckerPriorityConfig(categoryList, severityList);
    }

    @Override
    public String toString() {
        return "CheckerPriorityConfig(categoryList=" + categoryList + ", severityList=" + severityList + ")";
    }

    @Override
    public int hashCode() {
        int result = categoryList.hashCode();
        result = 31 * result + severityList.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CheckerPriorityConfig)) return false;
        CheckerPriorityConfig that = (CheckerPriorityConfig) other;
        return categoryList.equals(that.categoryList) && 
               severityList.equals(that.severityList);
    }
}
