import cn.sast.common.OS;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.jimple.FieldRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;

public final class StaticFiledAccessCache {
    private final CallGraph cg;
    private final LoadingCache<MethodPair, Boolean> cache;
    private final Map<StaticFieldRef, Set<SootMethod>> staticFieldRefToSootMethod;

    public StaticFiledAccessCache(@NotNull CallGraph cg) {
        if (cg == null) {
            throw new IllegalArgumentException("cg cannot be null");
        }
        this.cg = cg;
        this.cache = CacheBuilder.newBuilder()
                .concurrencyLevel(OS.INSTANCE.getMaxThreadNum())
                .initialCapacity(getInitialCapacity())
                .maximumSize(getInitialCapacity() * 2L)
                .softValues()
                .build(new AccessCacheLoader());
        this.staticFieldRefToSootMethod = buildStaticFieldAccessMap();
    }

    @NotNull
    public CallGraph getCg() {
        return cg;
    }

    public boolean isAccessible(@NotNull SootMethod entry, @NotNull StaticFieldRef fieldRef) {
        if (entry == null) {
            throw new IllegalArgumentException("entry cannot be null");
        }
        if (fieldRef == null) {
            throw new IllegalArgumentException("fieldRef cannot be null");
        }

        Set<SootMethod> methods = staticFieldRefToSootMethod.get(fieldRef);
        if (methods == null) {
            return false;
        }

        for (SootMethod sm : methods) {
            if (cache.getUnchecked(new MethodPair(entry, sm))) {
                return true;
            }
        }
        return false;
    }

    private int getInitialCapacity() {
        int classCount = Scene.v().getClasses().size();
        return Math.max(classCount * 10, classCount + 1000);
    }

    private Map<StaticFieldRef, Set<SootMethod>> buildStaticFieldAccessMap() {
        Map<StaticFieldRef, Set<SootMethod>> result = new HashMap<>();
        
        for (SootClass sc : Scene.v().getClasses()) {
            for (SootMethod sm : sc.getMethods()) {
                if (!sm.hasActiveBody()) {
                    continue;
                }

                UnitPatchingChain units = sm.getActiveBody().getUnits();
                for (Unit u : units) {
                    Stmt stmt = (Stmt) u;
                    if (!stmt.containsFieldRef() || !(stmt.getFieldRef() instanceof StaticFieldRef)) {
                        continue;
                    }

                    StaticFieldRef sf = (StaticFieldRef) stmt.getFieldRef();
                    result.computeIfAbsent(sf, k -> new HashSet<>()).add(sm);
                }
            }
        }
        return Collections.unmodifiableMap(result);
    }

    private static final class MethodPair {
        private final SootMethod first;
        private final SootMethod second;

        MethodPair(SootMethod first, SootMethod second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MethodPair)) return false;
            MethodPair that = (MethodPair) o;
            return first.equals(that.first) && second.equals(that.second);
        }

        @Override
        public int hashCode() {
            return 31 * first.hashCode() + second.hashCode();
        }
    }

    private final class AccessCacheLoader extends CacheLoader<MethodPair, Boolean> {
        @Override
        public Boolean load(MethodPair key) {
            // Implementation of actual accessibility check would go here
            return false;
        }
    }
}