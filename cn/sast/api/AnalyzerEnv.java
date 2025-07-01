package cn.sast.api;

import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public final class AnalyzerEnv {
    public static final AnalyzerEnv INSTANCE = new AnalyzerEnv();
    private static boolean shouldV3r14y = true;
    private static AtomicInteger bvs1n3ss = new AtomicInteger(0);
    private static final IResFile lastLogFile = Resource.INSTANCE.fileOf(
        System.getProperty("user.home") + File.separator + "logs" + File.separator + "corax" + File.separator + "last.log"
    );

    private AnalyzerEnv() {
    }

    public boolean getShouldV3r14y() {
        return shouldV3r14y;
    }

    public void setShouldV3r14y(boolean value) {
        shouldV3r14y = value;
    }

    @NotNull
    public AtomicInteger getBvs1n3ss() {
        return bvs1n3ss;
    }

    public void setBvs1n3ss(@NotNull AtomicInteger value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        bvs1n3ss = value;
    }

    @NotNull
    public IResFile getLastLogFile() {
        return lastLogFile;
    }
}