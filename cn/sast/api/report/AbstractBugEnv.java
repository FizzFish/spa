package cn.sast.api.report;

import cn.sast.common.Resource;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;

public abstract class AbstractBugEnv implements BugMessage.Env {
    @NotNull
    private final List<Function<BugPathEventEnvironment, BugPathEvent>> appendEvents = new ArrayList<>();

    @NotNull
    public final List<Function<BugPathEventEnvironment, BugPathEvent>> getAppendEvents() {
        return appendEvents;
    }

    public void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Path loc, @NotNull Region region) {
        if (message == null) throw new IllegalArgumentException("message cannot be null");
        if (loc == null) throw new IllegalArgumentException("loc cannot be null");
        if (region == null) throw new IllegalArgumentException("region cannot be null");
        
        appendEvents.add(env -> new BugPathEvent(
            message, 
            new FileResInfo(Resource.INSTANCE.fileOf(loc)), 
            region, 
            null, 
            8, 
            null
        ));
    }

    public void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Host loc, @Nullable Region region) {
        if (message == null) throw new IllegalArgumentException("message cannot be null");
        if (loc == null) throw new IllegalArgumentException("loc cannot be null");
        
        appendEvents.add(env -> {
            Region effectiveRegion = region;
            if (effectiveRegion == null) {
                SootInfoCache cache = env.getSootInfoCache();
                effectiveRegion = cache != null 
                    ? Region.Companion.invoke(cache, loc) 
                    : Region.Companion.getERROR();
            }
            return new BugPathEvent(
                message, 
                ClassResInfo.Companion.of(loc), 
                effectiveRegion, 
                null, 
                8, 
                null
            );
        });
    }
}