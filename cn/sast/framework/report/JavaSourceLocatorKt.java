package cn.sast.framework.report;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class JavaSourceLocatorKt {
    @NotNull
    public static ListSuffixRelation listEndsWith(@NotNull List<String> array1, @NotNull List<String> array2) {
        if (array1 == null) {
            throw new IllegalArgumentException("array1 cannot be null");
        }
        if (array2 == null) {
            throw new IllegalArgumentException("array2 cannot be null");
        }

        int minSize = Math.min(array1.size(), array2.size());
        if (minSize == 0) {
            return ListSuffixRelation.NeitherSuffix;
        }

        for (int i = 0; i < minSize; ++i) {
            String elem1 = array1.get(array1.size() - minSize + i);
            String elem2 = array2.get(array2.size() - minSize + i);
            if (!elem1.equals(elem2)) {
                return ListSuffixRelation.NeitherSuffix;
            }
        }

        if (array1.size() < array2.size()) {
            return ListSuffixRelation.AIsSuffixOfB;
        } else if (array1.size() > array2.size()) {
            return ListSuffixRelation.BIsSuffixOfA;
        } else {
            return ListSuffixRelation.Equals;
        }
    }
}