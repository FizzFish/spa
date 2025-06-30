/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.SootLineToMethodMap;
import com.feysh.corax.cache.analysis.SootLineToMethodMapFactory;
import com.feysh.corax.cache.analysis.SootLineToMethodMapKey;
import com.feysh.corax.cache.analysis.SootMethodAndRange;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017R:\u0010\u0006\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/cache/analysis/SootLineToMethodMapFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lcom/feysh/corax/cache/analysis/SootLineToMethodMap;", "Lcom/feysh/corax/cache/analysis/SootLineToMethodMapKey;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getSootMethodAtLine", "Lcom/feysh/corax/cache/analysis/SootMethodAndRange;", "sc", "Lsoot/SootClass;", "ln", "", "check", "", "corax-config-api"})
public final class SootLineToMethodMapFactory
implements AnalysisDataFactory<SootLineToMethodMap, SootLineToMethodMapKey> {
    @NotNull
    public static final SootLineToMethodMapFactory INSTANCE = new SootLineToMethodMapFactory();
    @NotNull
    private static final LoadingCache<SootLineToMethodMapKey, XOptional<SootLineToMethodMap>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<SootLineToMethodMap> key = new AnalysisDataFactory.Key<SootLineToMethodMap>(){};

    private SootLineToMethodMapFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<SootLineToMethodMapKey, XOptional<SootLineToMethodMap>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<SootLineToMethodMap> getKey() {
        return key;
    }

    @Nullable
    public final SootMethodAndRange getSootMethodAtLine(@NotNull SootClass sc, int ln, boolean check) {
        Object object;
        SootLineToMethodMap lineToMethodMap;
        block5: {
            block4: {
                Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
                lineToMethodMap = (SootLineToMethodMap)AnalysisCache.G.INSTANCE.get(new SootLineToMethodMapKey(sc));
                object = lineToMethodMap;
                if (object == null || (object = ((SootLineToMethodMap)object).getMap()) == null) break block4;
                Object it = object;
                boolean bl = false;
                Integer n = ((TreeMap)it).containsKey(ln) ? Integer.valueOf(ln) : ((TreeMap)it).lowerKey(ln);
                object = n;
                if (n != null) break block5;
            }
            return null;
        }
        int key2 = (Integer)object;
        SootMethodAndRange sootMethodAndRange = lineToMethodMap.getMap().get(key2);
        Intrinsics.checkNotNull((Object)sootMethodAndRange);
        SootMethodAndRange range = sootMethodAndRange;
        if (check && ln > ((Number)range.getRange().getSecond()).intValue()) {
            return null;
        }
        return range;
    }

    public static /* synthetic */ SootMethodAndRange getSootMethodAtLine$default(SootLineToMethodMapFactory sootLineToMethodMapFactory, SootClass sootClass, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl = true;
        }
        return sootLineToMethodMapFactory.getSootMethodAtLine(sootClass, n, bl);
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

