package cn.sast.api.config;

import cn.sast.common.Resource;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

public final class MatchContentProviderImpl implements MatchContentProvider {
    private static final Logger logger = LoggerFactory.getLogger(MatchContentProviderImpl.class);
    private final MainConfig mainConfig;

    public MatchContentProviderImpl(@NotNull MainConfig mainConfig) {
        if (mainConfig == null) {
            throw new IllegalArgumentException("mainConfig cannot be null");
        }
        this.mainConfig = mainConfig;
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @Nullable
    public String getRelativePath(@NotNull Path path) {
        if (path == null) {
            throw new IllegalArgumentException("path cannot be null");
        }

        try {
            Path absolutePath = path.toAbsolutePath().normalize();
            String absPath = Resource.of(absolutePath).toString();
            MainConfig.RelativePath relativePath = mainConfig.tryGetRelativePathFromAbsolutePath(absPath);
            String result = relativePath.getRelativePath();
            return relativePath.getPrefix().length() > 0 ? result : null;
        } catch (Exception e) {
            logger.warn("Invalid path: [{}], e: {}", path, e.getMessage());
            return null;
        }
    }

    private String getSourceOfClassMember(SootClass declaringClass) {
        Path path = AnalysisCache.G.INSTANCE.class2SourceFile(declaringClass);
        return path != null ? getRelativePath(path) : null;
    }

    @NotNull
    public ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path classpath) {
        if (classpath == null) {
            throw new IllegalArgumentException("classpath cannot be null");
        }
        return new ProcessRule.ClassPathMatch.MatchTarget(getRelativePath(classpath));
    }

    @NotNull
    public ProcessRule.FileMatch.MatchTarget get(@NotNull Path file) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        return new ProcessRule.FileMatch.MatchTarget(getRelativePath(file));
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass sc) {
        if (sc == null) {
            throw new IllegalArgumentException("sc cannot be null");
        }
        return new ProcessRule.ClassMemberMatch.MatchTarget(
            sc.getName(), 
            getSourceOfClassMember(sc), 
            null, 
            null, 
            null, 
            null
        );
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod sm) {
        if (sm == null) {
            throw new IllegalArgumentException("sm cannot be null");
        }
        SootClass declaringClass = sm.getDeclaringClass();
        return new ProcessRule.ClassMemberMatch.MatchTarget(
            declaringClass.getName(),
            getSourceOfClassMember(declaringClass),
            sm.getSignature(),
            sm.getName(),
            null,
            null
        );
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField sf) {
        if (sf == null) {
            throw new IllegalArgumentException("sf cannot be null");
        }
        SootClass declaringClass = sf.getDeclaringClass();
        return new ProcessRule.ClassMemberMatch.MatchTarget(
            declaringClass.getName(),
            getSourceOfClassMember(declaringClass),
            null,
            null,
            sf.getSignature(),
            sf.getName()
        );
    }
}