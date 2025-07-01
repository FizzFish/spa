package cn.sast.idfa.progressbar;

import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.jetbrains.annotations.NotNull;

public final class ProgressBarExt {
    private int updateIntervalMillis;
    private int maxProgressLength;

    public ProgressBarExt() {
        this(500, 120);
    }

    public ProgressBarExt(int updateIntervalMillis, int maxProgressLength) {
        this.updateIntervalMillis = updateIntervalMillis;
        this.maxProgressLength = maxProgressLength;
    }

    public int getUpdateIntervalMillis() {
        return updateIntervalMillis;
    }

    public void setUpdateIntervalMillis(int updateIntervalMillis) {
        this.updateIntervalMillis = updateIntervalMillis;
    }

    public int getMaxProgressLength() {
        return maxProgressLength;
    }

    public void setMaxProgressLength(int maxProgressLength) {
        this.maxProgressLength = maxProgressLength;
    }

    @NotNull
    public ProgressBar getProgressBar(@NotNull String unitName, long initialMax) {
        return getProgressBar(unitName, initialMax, ProgressBarStyle.COLORFUL_UNICODE_BLOCK, builder -> {});
    }

    @NotNull
    public ProgressBar getProgressBar(@NotNull String unitName, long initialMax, @NotNull ProgressBarStyle style) {
        return getProgressBar(unitName, initialMax, style, builder -> {});
    }

    @NotNull
    public ProgressBar getProgressBar(
            @NotNull String unitName,
            long initialMax,
            @NotNull ProgressBarStyle style,
            @NotNull ProgressBarBuilderConsumer builderConsumer
    ) {
        ProgressBarBuilder progressBarBuilder = new ProgressBarBuilder()
                .setTaskName(">")
                .showSpeed(new DecimalFormat("#.##"))
                .setStyle(style)
                .showSpeed()
                .setInitialMax(initialMax)
                .setUnit(unitName, 1L)
                .setSpeedUnit(ChronoUnit.SECONDS)
                .setMaxRenderedLength(maxProgressLength)
                .continuousUpdate()
                .setUpdateIntervalMillis(updateIntervalMillis);

        builderConsumer.accept(progressBarBuilder);
        return progressBarBuilder.build();
    }

    @FunctionalInterface
    public interface ProgressBarBuilderConsumer {
        void accept(ProgressBarBuilder builder);
    }
}
