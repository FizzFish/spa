package cn.sast.api.config;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

public interface MatchContentProvider {
    @NotNull
    ProcessRule.FileMatch.MatchTarget get(@NotNull Path file);

    @NotNull
    ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField sf);

    @NotNull
    ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod sm);

    @NotNull
    ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass sc);

    @NotNull
    ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path classpath);
}