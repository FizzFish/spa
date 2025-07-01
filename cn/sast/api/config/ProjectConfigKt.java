package cn.sast.api.config;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class ProjectConfigKt {
    public static void validate(@NotNull List<? extends ProcessRule.IMatchItem> rules) {
        if (rules == null) {
            throw new IllegalArgumentException("Rules list cannot be null");
        }

        for (ProcessRule.IMatchItem item : rules) {
            if (item instanceof ProcessRule.ErrorCommit) {
                ProcessRule.ErrorCommit errorCommit = (ProcessRule.ErrorCommit) item;
                String error = errorCommit.getError();
                if (error != null) {
                    throw new IllegalStateException(
                        "Invalid process-regex: `" + item + "`, error: " + error
                    );
                }
            }
        }
    }
}
