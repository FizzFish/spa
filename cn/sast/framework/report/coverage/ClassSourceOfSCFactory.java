package cn.sast.framework.report.coverage;

import cn.sast.framework.report.coverage.ClassSourceInfo;
import cn.sast.framework.report.coverage.ClassSourceOfSCKey;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;

public final class ClassSourceOfSCFactory implements AnalysisDataFactory<ClassSourceInfo, ClassSourceOfSCKey> {
    public static final ClassSourceOfSCFactory INSTANCE = new ClassSourceOfSCFactory();
    
    private static final LoadingCache<ClassSourceOfSCKey, XOptional<ClassSourceInfo>> cache;
    private static final AnalysisDataFactory.Key<ClassSourceInfo> key = new ClassSourceOfSCKey();

    static {
        cache = AnalysisCacheKt.buildX(
            AnalysisDataFactory.Companion.getDefaultBuilder(),
            (CacheLoader<ClassSourceOfSCKey, XOptional<ClassSourceInfo>>) ClassSourceOfSCKey::load
        );
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }

    private ClassSourceOfSCFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<ClassSourceOfSCKey, XOptional<ClassSourceInfo>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ClassSourceInfo> getKey() {
        return key;
    }
}