package cn.sast.api.report;

import com.feysh.corax.config.api.CheckType;
import java.util.Locale;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public enum CheckType2StringKind {
    RuleDotTYName(t -> t.getReport().getRealName() + "." + t.getClass().getSimpleName()),
    RuleDotTYName2(t -> {
        String className = t.getClass().getSimpleName();
        return t.getReport().getRealName() + "." + className.toLowerCase(Locale.getDefault());
    }),
    RuleName(t -> t.getReport().getRealName());

    private static final String RULE_NAME_KIND_ENV = "REPORT_RULE_KIND";
    private static final CheckType2StringKind checkType2StringKind;

    private final Function<CheckType, String> convert;

    CheckType2StringKind(Function<CheckType, String> convert) {
        this.convert = convert;
    }

    @NotNull
    public Function<CheckType, String> getConvert() {
        return convert;
    }

    @NotNull
    public static CheckType2StringKind getDefault() {
        return checkType2StringKind;
    }

    static {
        String envValue = System.getenv(RULE_NAME_KIND_ENV);
        if (envValue == null) {
            envValue = System.getProperty(RULE_NAME_KIND_ENV);
        }

        CheckType2StringKind kind = null;
        if (envValue != null) {
            try {
                kind = valueOf(envValue);
            } catch (IllegalArgumentException ignored) {
            }
        }
        checkType2StringKind = kind != null ? kind : RuleDotTYName;
    }
}