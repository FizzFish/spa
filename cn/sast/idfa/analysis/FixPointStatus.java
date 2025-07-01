package cn.sast.idfa.analysis;

import org.jetbrains.annotations.NotNull;
import java.util.EnumSet;

public enum FixPointStatus {
    HasChange,
    Fixpoint,
    NeedWideningOperators;

    @NotNull
    public static EnumSet<FixPointStatus> getEntries() {
        return EnumSet.allOf(FixPointStatus.class);
    }
}