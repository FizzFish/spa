package cn.sast.framework.report.sarif;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Result {
    @NotNull
    private final String ruleId;
    private final int ruleIndex;
    @NotNull
    private final IndexedMessage message;
    @NotNull
    private final List<Location> locations;
    @NotNull
    private final List<CodeFlow> codeFlows;

    public Result(@NotNull String ruleId, int ruleIndex, @NotNull IndexedMessage message, 
                 @NotNull List<Location> locations, @NotNull List<CodeFlow> codeFlows) {
        if (ruleId == null) throw new IllegalArgumentException("ruleId cannot be null");
        if (message == null) throw new IllegalArgumentException("message cannot be null");
        if (locations == null) throw new IllegalArgumentException("locations cannot be null");
        if (codeFlows == null) throw new IllegalArgumentException("codeFlows cannot be null");

        this.ruleId = ruleId;
        this.ruleIndex = ruleIndex;
        this.message = message;
        this.locations = locations;
        this.codeFlows = codeFlows;
    }

    @NotNull
    public String getRuleId() {
        return ruleId;
    }

    public int getRuleIndex() {
        return ruleIndex;
    }

    @NotNull
    public IndexedMessage getMessage() {
        return message;
    }

    @NotNull
    public List<Location> getLocations() {
        return locations;
    }

    @NotNull
    public List<CodeFlow> getCodeFlows() {
        return codeFlows;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Result)) return false;
        
        Result result = (Result) other;
        return ruleId.equals(result.ruleId) &&
               ruleIndex == result.ruleIndex &&
               message.equals(result.message) &&
               locations.equals(result.locations) &&
               codeFlows.equals(result.codeFlows);
    }

    @Override
    public int hashCode() {
        int result = ruleId.hashCode();
        result = 31 * result + Integer.hashCode(ruleIndex);
        result = 31 * result + message.hashCode();
        result = 31 * result + locations.hashCode();
        result = 31 * result + codeFlows.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Result(ruleId=" + ruleId + 
               ", ruleIndex=" + ruleIndex + 
               ", message=" + message + 
               ", locations=" + locations + 
               ", codeFlows=" + codeFlows + ")";
    }
}