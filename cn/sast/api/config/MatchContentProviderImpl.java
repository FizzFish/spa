/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfig$RelativePath
 *  cn.sast.api.config.MatchContentProvider
 *  cn.sast.api.config.MatchContentProviderImpl
 *  cn.sast.api.config.MatchContentProviderImpl$Companion
 *  cn.sast.common.Resource
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch$MatchTarget
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 */
package cn.sast.api.config;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MatchContentProvider;
import cn.sast.api.config.MatchContentProviderImpl;
import cn.sast.common.Resource;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001c"}, d2={"Lcn/sast/api/config/MatchContentProviderImpl;", "Lcn/sast/api/config/MatchContentProvider;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getRelativePath", "", "path", "Ljava/nio/file/Path;", "getSourceOfClassMember", "declaringClass", "Lsoot/SootClass;", "getClassPath", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$MatchTarget;", "classpath", "get", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$MatchTarget;", "file", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch$MatchTarget;", "sc", "sm", "Lsoot/SootMethod;", "sf", "Lsoot/SootField;", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nMatchContentProviderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchContentProviderImpl.kt\ncn/sast/api/config/MatchContentProviderImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
public final class MatchContentProviderImpl
implements MatchContentProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(MatchContentProviderImpl::logger$lambda$3);

    public MatchContentProviderImpl(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.mainConfig = mainConfig;
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @Nullable
    public final String getRelativePath(@NotNull Path path) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        try {
            Path path2 = path.toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toAbsolutePath(...)");
            Path path3 = path2.normalize();
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"normalize(...)");
            string2 = Resource.INSTANCE.of(path3).toString();
        }
        catch (Exception e) {
            logger.warn(() -> MatchContentProviderImpl.getRelativePath$lambda$0(path, e));
            return null;
        }
        String absPath = string2;
        MainConfig.RelativePath relativePath = this.mainConfig.tryGetRelativePathFromAbsolutePath(absPath);
        String it = string = relativePath.getRelativePath();
        boolean bl = false;
        return ((CharSequence)relativePath.getPrefix()).length() > 0 ? string : null;
    }

    private final String getSourceOfClassMember(SootClass declaringClass) {
        String string;
        Path path = AnalysisCache.G.INSTANCE.class2SourceFile(declaringClass);
        if (path != null) {
            Path it = path;
            boolean bl = false;
            string = this.getRelativePath(it);
        } else {
            string = null;
        }
        return string;
    }

    @NotNull
    public ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path classpath) {
        Intrinsics.checkNotNullParameter((Object)classpath, (String)"classpath");
        return new ProcessRule.ClassPathMatch.MatchTarget(this.getRelativePath(classpath));
    }

    @NotNull
    public ProcessRule.FileMatch.MatchTarget get(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return new ProcessRule.FileMatch.MatchTarget(this.getRelativePath(file));
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        return new ProcessRule.ClassMemberMatch.MatchTarget(sc.getName(), this.getSourceOfClassMember(sc), null, null, null, null);
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod sm) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        String string = sm.getDeclaringClass().getName();
        SootClass sootClass = sm.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return new ProcessRule.ClassMemberMatch.MatchTarget(string, this.getSourceOfClassMember(sootClass), sm.getSignature(), sm.getName(), null, null);
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField sf) {
        Intrinsics.checkNotNullParameter((Object)sf, (String)"sf");
        String string = sf.getDeclaringClass().getName();
        SootClass sootClass = sf.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return new ProcessRule.ClassMemberMatch.MatchTarget(string, this.getSourceOfClassMember(sootClass), null, null, sf.getSignature(), sf.getName());
    }

    private static final Object getRelativePath$lambda$0(Path $path, Exception $e) {
        return "Invalid path: [" + $path + "], e: " + $e.getMessage();
    }

    private static final Unit logger$lambda$3() {
        return Unit.INSTANCE;
    }
}

