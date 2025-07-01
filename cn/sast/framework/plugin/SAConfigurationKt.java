package cn.sast.framework.plugin;

import cn.sast.api.report.CheckType2StringKind;
import cn.sast.framework.plugin.ConfigSerializable;
import com.feysh.corax.config.api.CheckType;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class SAConfigurationKt {
    @NotNull
    public static String get1to1SpecialIdentifier(@NotNull CheckType checkType) {
        if (checkType == null) {
            throw new NullPointerException("checkType");
        }
        return CheckType2StringKind.Companion.getCheckType2StringKind().getConvert().invoke(checkType);
    }

    private static LinkedHashSet<ConfigSerializable> getSort(LinkedHashSet<ConfigSerializable> set) {
        return set.stream()
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}