package cn.sast.framework;

import org.jetbrains.annotations.NotNull;

public enum CgAlgorithmProvider {
    Soot,
    QiLin;

    @NotNull
    public static CgAlgorithmProvider[] getEntries() {
        return values();
    }
}