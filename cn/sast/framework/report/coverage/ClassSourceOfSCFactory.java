/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.coverage.ClassSourceInfo
 *  cn.sast.framework.report.coverage.ClassSourceOfSCFactory
 *  cn.sast.framework.report.coverage.ClassSourceOfSCFactory$cache$1
 *  cn.sast.framework.report.coverage.ClassSourceOfSCKey
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.cache.AnalysisCacheKt
 *  com.feysh.corax.cache.AnalysisDataFactory
 *  com.feysh.corax.cache.AnalysisDataFactory$Key
 *  com.feysh.corax.cache.XOptional
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.coverage;

import cn.sast.framework.report.coverage.ClassSourceInfo;
import cn.sast.framework.report.coverage.ClassSourceOfSCFactory;
import cn.sast.framework.report.coverage.ClassSourceOfSCKey;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R:\u0010\u0006\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lcn/sast/framework/report/coverage/ClassSourceOfSCFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lcn/sast/framework/report/coverage/ClassSourceInfo;", "Lcn/sast/framework/report/coverage/ClassSourceOfSCKey;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-framework"})
public final class ClassSourceOfSCFactory
implements AnalysisDataFactory<ClassSourceInfo, ClassSourceOfSCKey> {
    @NotNull
    public static final ClassSourceOfSCFactory INSTANCE = new ClassSourceOfSCFactory();
    @NotNull
    private static final LoadingCache<ClassSourceOfSCKey, XOptional<ClassSourceInfo>> cache = AnalysisCacheKt.buildX((Caffeine)AnalysisDataFactory.Companion.getDefaultBuilder(), (CacheLoader)((CacheLoader)cache.1.INSTANCE));
    @NotNull
    private static final AnalysisDataFactory.Key<ClassSourceInfo> key = (AnalysisDataFactory.Key)new /* Unavailable Anonymous Inner Class!! */;

    private ClassSourceOfSCFactory() {
    }

    @NotNull
    public LoadingCache<ClassSourceOfSCKey, XOptional<ClassSourceInfo>> getCache() {
        return cache;
    }

    @NotNull
    public AnalysisDataFactory.Key<ClassSourceInfo> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory((AnalysisDataFactory)INSTANCE);
    }
}

