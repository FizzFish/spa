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
import org.jetbrains.annotations.NotNull;

public final class DefineUnusedChecker implements IChecker {
    public static final DefineUnusedChecker INSTANCE = new DefineUnusedChecker();
    private static final IRule report = BuiltinFeyshRules.DefineUnused;
    private static final Set<IRule> standards = Set.of(BuiltinCWERules.CWE561_DeadCode);

    private DefineUnusedChecker() {
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
        return "DefineUnusedChecker";
    }

    @Override
    @NotNull
    public String getDesc() {
        return "Checks for unused methods and unread fields";
    }

    @Override
    public void validate() {
        // Default validation
    }

    public static final class UnusedMethod extends CheckType {
        public static final UnusedMethod INSTANCE = new UnusedMethod();
        private static final Map<Language, BugMessage> bugMessage;
        private static final IChecker checker = INSTANCE;

        private UnusedMethod() {
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

        private static String generateZhMessage(BugMessage.Env env) {
            return "方法 `" + env.getMethod() + "` 从未被使用过";
        }

        private static String generateEnMessage(BugMessage.Env env) {
            return "This method `" + env.getMethod() + "` is never used";
        }

        static {
            bugMessage = Map.of(
                Language.ZH, AIAnalysisApiKt.msgGenerator(UnusedMethod::generateZhMessage),
                Language.EN, AIAnalysisApiKt.msgGenerator(UnusedMethod::generateEnMessage)
            );
        }
    }

    public static final class UrfUnreadField extends CheckType {
        public static final UrfUnreadField INSTANCE = new UrfUnreadField();
        private static final Map<Language, BugMessage> bugMessage;
        private static final IChecker checker = INSTANCE;

        private UrfUnreadField() {
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

        private static String generateZhMessage(BugMessage.Env env) {
            return "字段 `" + env.getField() + "` 从未被读取";
        }

        private static String generateEnMessage(BugMessage.Env env) {
            return "Unread field: `" + env.getField() + "`";
        }

        static {
            bugMessage = Map.of(
                Language.ZH, AIAnalysisApiKt.msgGenerator(UrfUnreadField::generateZhMessage),
                Language.EN, AIAnalysisApiKt.msgGenerator(UrfUnreadField::generateEnMessage)
            );
        }
    }
}