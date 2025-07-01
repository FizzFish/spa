package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.TreeMap;

import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;

public final class SootLineToMethodMapFactory implements AnalysisDataFactory<SootLineToMethodMap, SootLineToMethodMapKey> {
    public static final SootLineToMethodMapFactory INSTANCE = new SootLineToMethodMapFactory();
    private static final LoadingCache<SootLineToMethodMapKey, XOptional<SootLineToMethodMap>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.SootLineToMethodMapFactory$cache$1
        /* JADX WARN: Multi-variable type inference failed */
        public final SootLineToMethodMap load(SootLineToMethodMapKey key2) {
            SootClass sc = key2.getSc();
            if (sc.resolvingLevel() < 2) {
                return null;
            }
            TreeMap map = new TreeMap();
            for (SootMethod sm : key2.getSc().getMethods()) {
                if (sm.hasActiveBody()) {
                    AnalysisCache.G g = AnalysisCache.G.INSTANCE;
                    Pair range = (Pair) g.get(new SootRangeKey(sm));
                    if (range != null) {
                        SootMethodAndRange r = new SootMethodAndRange(sm, range);
                        map.put(range.getFirst(), r);
                    }
                }
            }
            return new SootLineToMethodMap(map);
        }
    });

    private static final AnalysisDataFactory.Key<SootLineToMethodMap> key = new AnalysisDataFactory.Key<SootLineToMethodMap>() {};

    private SootLineToMethodMapFactory() {
    }

    @Override
    public @NotNull LoadingCache<SootLineToMethodMapKey, XOptional<SootLineToMethodMap>> getCache() {
        return cache;
    }

    @Override
    public @NotNull AnalysisDataFactory.Key<SootLineToMethodMap> getKey() {
        return key;
    }

    @Nullable
    public SootMethodAndRange getSootMethodAtLine(@NotNull SootClass sc, int ln, boolean check) {
        if (sc == null) {
            throw new IllegalArgumentException("sc cannot be null");
        }

        SootLineToMethodMap lineToMethodMap = AnalysisCache.G.INSTANCE.get(new SootLineToMethodMapKey(sc));
        if (lineToMethodMap == null || lineToMethodMap.getMap() == null) {
            return null;
        }

        TreeMap<Integer, SootMethodAndRange> map = lineToMethodMap.getMap();
        Integer key = map.containsKey(ln) ? ln : map.lowerKey(ln);
        if (key == null) {
            return null;
        }

        SootMethodAndRange range = map.get(key);
        if (check && ln > range.getRange().getSecond().intValue()) {
            return null;
        }
        return range;
    }

    public SootMethodAndRange getSootMethodAtLine(SootClass sc, int ln) {
        return getSootMethodAtLine(sc, ln, true);
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}