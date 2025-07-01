package cn.sast.dataflow.infoflow.manager;

import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkCategory;

public final class SourceSinkCategory implements ISourceSinkCategory {
    @NotNull
    private final String detector;
    @NotNull
    private final String pattern;

    public SourceSinkCategory(@NotNull String detector, @NotNull String pattern) {
        if (detector == null) {
            throw new IllegalArgumentException("detector must not be null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("pattern must not be null");
        }
        this.detector = detector;
        this.pattern = pattern;
    }

    @NotNull
    public String getDetector() {
        return detector;
    }

    @NotNull
    public String getPattern() {
        return pattern;
    }

    @Override
    @NotNull
    public String getHumanReadableDescription() {
        return "";
    }

    @Override
    @NotNull
    public String getID() {
        return pattern;
    }

    @Override
    @NotNull
    public String toString() {
        return detector + "::" + pattern;
    }
}