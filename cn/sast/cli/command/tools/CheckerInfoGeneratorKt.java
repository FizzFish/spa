package cn.sast.cli.command.tools;

import cn.sast.api.report.CheckType2StringKind;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;

public final class CheckerInfoGeneratorKt {
    @NotNull
    public static String getId(@NotNull CheckType checkType) {
        if (checkType == null) {
            throw new NullPointerException("checkType cannot be null");
        }
        return CheckType2StringKind.getCheckType2StringKind().getConvert().invoke(checkType);
    }
}