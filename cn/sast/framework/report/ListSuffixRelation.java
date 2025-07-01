package cn.sast.framework.report;

import org.jetbrains.annotations.NotNull;

public enum ListSuffixRelation {
    Equals(false),
    AIsSuffixOfB(false),
    BIsSuffixOfA(false),
    NeitherSuffix(true);

    private final boolean neitherSuffix;

    ListSuffixRelation(boolean neitherSuffix) {
        this.neitherSuffix = neitherSuffix;
    }

    public boolean getNeitherSuffix() {
        return neitherSuffix;
    }

    @NotNull
    public static ListSuffixRelation[] getEntries() {
        return values();
    }
}