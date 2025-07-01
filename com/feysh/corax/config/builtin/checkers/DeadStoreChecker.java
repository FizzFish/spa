package com.feysh.corax.config.builtin.checkers;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.builtin.standard.BuiltinCWERules;
import com.feysh.corax.config.builtin.standard.BuiltinFeyshRules;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class DeadStoreChecker implements IChecker {
    public static final DeadStoreChecker INSTANCE = new DeadStoreChecker();
    private static final IRule report = BuiltinFeyshRules.DeadStore;
    private static final Set<IRule> standards = Collections.singleton(BuiltinCWERules.CWE563_UnusedVariable);

    private DeadStoreChecker() {
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
        return "DeadStoreChecker";
    }

    @Override
    @NotNull
    public String getDesc() {
        return "Detects dead stores (assignments to variables that are never used)";
    }

    @Override
    public void validate() {
        // Default validation - no action needed
    }

    public static final class DeadLocalStore extends CheckType {
        public static final DeadLocalStore INSTANCE = new DeadLocalStore();
        private static final IChecker checker = INSTANCE;
        private static final Map<Language, BugMessage> bugMessage = Map.of(
            Language.ZH, BugMessage.of(env -> "赋值给变量，但后续并未使用该值"),
            Language.EN, BugMessage.of(env -> "Assign a value to a variable, but the value is not used subsequently")
        );

        private DeadLocalStore() {
        }

        @Override
        @NotNull
        public IChecker getChecker() {
            return checker;
        }

        @Override
        @NotNull
        public Map<Language, BugMessage> getBugMessage() {
            return bugMessage;
        }
    }
}