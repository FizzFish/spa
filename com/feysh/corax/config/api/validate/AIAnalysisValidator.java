package com.feysh.corax.config.api.validate;

import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.AnalysisApiNotImplException;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AIAnalysisValidator extends AIAnalysisBaseImpl {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(AIAnalysisValidator.class);

    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final List<String> errors = new ArrayList<>();
    @NotNull
    private final List<String> warnings = new ArrayList<>();
    @NotNull
    private final Map<IJDecl, List<IStmt>> stmts = new LinkedHashMap<>();
    @NotNull
    private final Map<IJDecl, List<CheckInfo>> checkPoint = new LinkedHashMap<>();
    @NotNull
    private final Map<IJDecl, List<IExpr>> eval = new LinkedHashMap<>();
    @NotNull
    private final AIAnalysisApi.Error error;

    public AIAnalysisValidator(@NotNull CoroutineScope scope) {
        if (scope == null) {
            throw new IllegalArgumentException("scope cannot be null");
        }
        this.scope = scope;
        this.error = new ErrorImpl(this);
    }

    public AIAnalysisValidator() {
        this(GlobalScope.INSTANCE);
    }

    @Override
    @NotNull
    public CoroutineScope getScope() {
        return scope;
    }

    @NotNull
    public List<String> getErrors() {
        return errors;
    }

    @NotNull
    public List<String> getWarnings() {
        return warnings;
    }

    @NotNull
    public Map<IJDecl, List<IStmt>> getStmts() {
        return stmts;
    }

    @NotNull
    public Map<IJDecl, List<CheckInfo>> getCheckPoint() {
        return checkPoint;
    }

    @NotNull
    public Map<IJDecl, List<IExpr>> getEval() {
        return eval;
    }

    @Override
    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        throw new AnalysisApiNotImplException("just a test");
    }

    @Override
    @NotNull
    public FastCache getFastCache() {
        throw new AnalysisApiNotImplException("just a test");
    }

    @Override
    public void validate() {
        warnings.forEach(msg -> logger.warn(msg));
        
        if (!check()) {
            logger.error("");
            logger.error("");
            logger.error("");
            errors.forEach(msg -> logger.error(msg));
            logger.error("Please fix errors. num: " + errors.size());
        }
    }

    public boolean check() {
        return errors.isEmpty();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return error;
    }

    @Override
    public void addStmt(@NotNull IJDecl decl, @NotNull Consumer<MethodConfig> config, @NotNull IStmt stmt) {
        if (decl == null) throw new IllegalArgumentException("decl cannot be null");
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");

        List<IStmt> stmtList = stmts.computeIfAbsent(decl, k -> {
            logger.debug("");
            logger.debug(decl + " :");
            return new ArrayList<>();
        });
        stmtList.add(stmt);
        logger.debug("\t\tadd stmt: " + stmt);
    }

    @Override
    public void check(@NotNull IJDecl decl, @NotNull Consumer<MethodConfig> config, @NotNull IBoolExpr expr, 
                     @NotNull CheckType checkType, @NotNull Consumer<BugMessage.Env> env) {
        if (decl == null) throw new IllegalArgumentException("decl cannot be null");
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (expr == null) throw new IllegalArgumentException("expr cannot be null");
        if (checkType == null) throw new IllegalArgumentException("checkType cannot be null");
        if (env == null) throw new IllegalArgumentException("env cannot be null");

        CheckInfo check = new CheckInfo(expr, checkType);
        List<CheckInfo> checkList = checkPoint.computeIfAbsent(decl, k -> {
            logger.debug("");
            logger.debug(decl + " :");
            return new ArrayList<>();
        });
        checkList.add(check);
        logger.debug("\t\tadd check point: " + check);
    }

    @Override
    public void eval(@NotNull IJDecl decl, @NotNull Consumer<MethodConfig> config, @NotNull IExpr expr, 
                    @NotNull Consumer<Object> accept) {
        if (decl == null) throw new IllegalArgumentException("decl cannot be null");
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (expr == null) throw new IllegalArgumentException("expr cannot be null");
        if (accept == null) throw new IllegalArgumentException("accept cannot be null");

        List<IExpr> exprList = eval.computeIfAbsent(decl, k -> {
            logger.debug("");
            logger.debug(decl + " :");
            return new ArrayList<>();
        });
        exprList.add(expr);
        logger.debug("\t\tadd eval expr: " + expr);
    }

    private static class ErrorImpl extends AIAnalysisApi.Error {
        private final AIAnalysisValidator validator;

        ErrorImpl(AIAnalysisValidator validator) {
            this.validator = validator;
        }

        @Override
        public void error(String msg) {
            if (msg == null) throw new IllegalArgumentException("msg cannot be null");
            logger.error(msg);
            validator.getErrors().add(msg);
        }

        @Override
        public void warning(String msg) {
            if (msg == null) throw new IllegalArgumentException("msg cannot be null");
            logger.warn(msg);
            validator.getWarnings().add(msg);
        }

        @Override
        public KLogger getLogger() {
            return logger;
        }
    }
}
