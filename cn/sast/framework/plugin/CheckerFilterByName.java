package cn.sast.framework.plugin;

import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class CheckerFilterByName {
    @NotNull
    private final Set<String> enables;
    @NotNull
    private final Map<String, String> renameMap;

    public CheckerFilterByName(@NotNull Set<String> enables, @NotNull Map<String, String> renameMap) {
        if (enables == null) {
            throw new IllegalArgumentException("enables cannot be null");
        }
        if (renameMap == null) {
            throw new IllegalArgumentException("renameMap cannot be null");
        }
        this.enables = enables;
        this.renameMap = renameMap;
    }

    @NotNull
    public Set<String> getEnables() {
        return enables;
    }

    @NotNull
    public Map<String, String> getRenameMap() {
        return renameMap;
    }
}