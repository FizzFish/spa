package com.feysh.corax.config.builtin.checkers;

import com.feysh.corax.config.api.AIAnalysisApiKt;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.builtin.standard.BuiltinCWERules;
import com.feysh.corax.config.builtin.standard.BuiltinFeyshRules;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import org.jetbrains.annotations.NotNull;

public final class DeadCodeChecker implements IChecker {
    public static final DeadCodeChecker INSTANCE = new DeadCodeChecker();
    private static final IRule report = BuiltinFeyshRules.DeadCode;
    private static final Set<IRule> standards = Collections.singleton(BuiltinCWERules.CWE561_DeadCode);

    private DeadCodeChecker() {
    }

    @Override
    @NotNull
    public IRule getReport() {
        return report;
    }

    @Override
    @NotNull
    public Set<IRule> getStandards() {
        return standards;
    }

    @Override
    @NotNull
    public String getSimpleName() {
        return "DeadCodeChecker";
    }

    @Override
    @NotNull
    public String getDesc() {
        return "Detects dead code and unreachable branches";
    }

    @Override
    public void validate() {
    }

    public static final class DeadCode extends CheckType {
        public static final DeadCode INSTANCE = new DeadCode();
        private static final Map<Language, BugMessage> bugMessage;
        private static final IChecker checker = DeadCodeChecker.INSTANCE;

        private DeadCode() {
        }

        @Override
        @NotNull
        public Map<Language, BugMessage> getBugMessage() {
            return bugMessage;
        }

        @Override
        @NotNull
        public IChecker getChecker() {
            return checker;
        }

        static {
            bugMessage = Map.of(
                Language.ZH, AIAnalysisApiKt.msgGenerator(env -> "该代码块下的代码永远无法访问"),
                Language.EN, AIAnalysisApiKt.msgGenerator(env -> "The code under that block can never be reached")
            );
        }
    }

    public static final class UnreachableBranch extends CheckType {
        public static final UnreachableBranch INSTANCE = new UnreachableBranch();
        private static final Map<Language, BugMessage> bugMessage;
        private static final IChecker checker = DeadCodeChecker.INSTANCE;

        private UnreachableBranch() {
        }

        @Override
        @NotNull
        public Map<Language, BugMessage> getBugMessage() {
            return bugMessage;
        }

        @Override
        @NotNull
        public IChecker getChecker() {
            return checker;
        }

        static {
            bugMessage = Map.of(
                Language.ZH, AIAnalysisApiKt.msgGenerator(env -> 
                    "该条件" + env.getArgs().get("guard") + "永远不成立, 目标分支" + env.getArgs().get("target") + "永远无法到达"),
                Language.EN, AIAnalysisApiKt.msgGenerator(env -> 
                    "The condition " + env.getArgs().get("guard") + " is always false, and the target branch " + 
                    env.getArgs().get("target") + " can never be reached.")
            );
        }
    }
}