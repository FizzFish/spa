package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Tool {
    @NotNull
    private final ToolComponent driver;

    public Tool(@NotNull ToolComponent driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver cannot be null");
        }
        this.driver = driver;
    }

    @NotNull
    public ToolComponent getDriver() {
        return driver;
    }

    @NotNull
    public Tool copy(@NotNull ToolComponent driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver cannot be null");
        }
        return new Tool(driver);
    }

    @Override
    public String toString() {
        return "Tool(driver=" + driver + ")";
    }

    @Override
    public int hashCode() {
        return driver.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool) other;
        return driver.equals(tool.driver);
    }
}