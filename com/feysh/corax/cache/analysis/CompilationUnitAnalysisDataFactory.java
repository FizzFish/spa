package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.google.common.base.Charsets;
import kotlin.io.CloseableKt;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;

public final class CompilationUnitAnalysisDataFactory 
    implements AnalysisDataFactory<ParseResult<CompilationUnit>, CompilationUnitAnalysisKey> {

    public static final CompilationUnitAnalysisDataFactory INSTANCE = new CompilationUnitAnalysisDataFactory();

    @NotNull
    private static final LoadingCache<CompilationUnitAnalysisKey, XOptional<ParseResult<CompilationUnit>>> cache = 
        AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.CompilationUnitAnalysisDataFactory$cache$1
            public final ParseResult<CompilationUnit> load(CompilationUnitAnalysisKey key2) throws IOException {
                ParserConfiguration configuration = new ParserConfiguration();
                JavaParser parser = new JavaParser(configuration);
                OpenOption[] openOptionArr = new OpenOption[0];
                InputStream inputStreamNewInputStream = Files.newInputStream(key2.getSourceFile(), (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
                InputStream inputStream = inputStreamNewInputStream;
                Throwable th = null;
                try {
                    try {
                        InputStream inputStream2 = inputStream;
                        ParseResult<CompilationUnit> parseResult = parser.parse(inputStream2, Charsets.UTF_8);
//                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                        return parseResult;
                    } finally {
                    }
                } catch (Throwable th2) {
//                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        });


    @NotNull
    private static final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> key = 
        new AnalysisDataFactory.Key<ParseResult<CompilationUnit>>(){};

    private CompilationUnitAnalysisDataFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<CompilationUnitAnalysisKey, XOptional<ParseResult<CompilationUnit>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}
