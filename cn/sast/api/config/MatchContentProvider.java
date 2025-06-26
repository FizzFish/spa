/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MatchContentProvider
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch$MatchTarget
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 */
package cn.sast.api.config;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.nio.file.Path;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0002\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2={"Lcn/sast/api/config/MatchContentProvider;", "", "get", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$MatchTarget;", "file", "Ljava/nio/file/Path;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch$MatchTarget;", "sf", "Lsoot/SootField;", "sm", "Lsoot/SootMethod;", "sc", "Lsoot/SootClass;", "getClassPath", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$MatchTarget;", "classpath", "corax-api"})
public interface MatchContentProvider {
    @NotNull
    public ProcessRule.FileMatch.MatchTarget get(@NotNull Path var1);

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField var1);

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod var1);

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass var1);

    @NotNull
    public ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path var1);
}

