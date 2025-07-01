package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import com.feysh.corax.config.api.baseimpl.Attribute;
import com.feysh.corax.config.api.baseimpl.IBaseOperatorFactory;
import com.feysh.corax.config.api.baseimpl.Parameter;
import com.feysh.corax.config.api.baseimpl.Return;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public final class BaseLocalVarDecl<T> implements ILocalVarDecl<T> {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final ILocalVarMatch match;

    public BaseLocalVarDecl(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull ILocalVarMatch match) {
        if (analyzeConfig == null) throw new IllegalArgumentException("analyzeConfig cannot be null");
        if (match == null) throw new IllegalArgumentException("match cannot be null");
        this.analyzeConfig = analyzeConfig;
        this.match = match;
    }

    @NotNull
    public AIAnalysisBaseImpl getAnalyzeConfig() {
        return analyzeConfig;
    }

    @NotNull
    public ILocalVarMatch getMatch() {
        return match;
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atGet(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<ILocalVarDecl.IGet<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        LocalVarGet<T> getter = new LocalVarGet<>(new Builder<>(config));
        block.accept(getter);
        return this;
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atSet(@NotNull Consumer<MethodConfig> config, @NotNull BiConsumer<ILocalVarDecl.ISet<T>, IParameterT<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        LocalVarSet<T> setter = new LocalVarSet<>(new Builder<>(config));
        block.accept(setter, setter.getValue());
        return this;
    }

    public static final class Builder<T> implements ILocalVarDecl.IBuilder<T>, IBaseOperatorFactory {
        @NotNull
        private final Consumer<MethodConfig> config;
        @NotNull
        private final ILocalVarMatch match;
        @NotNull
        private final ILocalVarDecl<T> decl;

        public Builder(@NotNull Consumer<MethodConfig> config) {
            if (config == null) throw new IllegalArgumentException("config cannot be null");
            this.config = config;
            this.match = BaseLocalVarDecl.this.getMatch();
            this.decl = BaseLocalVarDecl.this;
        }

        @Override
        @NotNull
        public Consumer<MethodConfig> getConfig() {
            return config;
        }

        @Override
        @NotNull
        public ILocalVarMatch getMatch() {
            return match;
        }

        @Override
        @NotNull
        public ILocalVarDecl<T> getDecl() {
            return decl;
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
            BaseLocalVarDecl.this.getAnalyzeConfig().addStmt(BaseLocalVarDecl.this, getConfig(), stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Consumer<BugMessage.Env> env) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (checkType == null) throw new IllegalArgumentException("checkType cannot be null");
            if (env == null) throw new IllegalArgumentException("env cannot be null");
            BaseLocalVarDecl.this.getAnalyzeConfig().check(BaseLocalVarDecl.this, getConfig(), expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Consumer<Object> result) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (result == null) throw new IllegalArgumentException("result cannot be null");
            BaseLocalVarDecl.this.getAnalyzeConfig().eval(BaseLocalVarDecl.this, getConfig(), expr, result);
        }

        // Remaining interface method implementations...
    }

    public static final class LocalVarGet<T> implements ILocalVarDecl.IGet<T>, ILocalVarDecl.IBuilder<T> {
        @NotNull
        private final ILocalVarDecl.IBuilder<T> delegate;
        @NotNull
        private final IReturnT<T> returnValue;

        public LocalVarGet(@NotNull ILocalVarDecl.IBuilder<T> delegate) {
            if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
            this.delegate = delegate;
            this.returnValue = new Return<>();
        }

        @NotNull
        public ILocalVarDecl.IBuilder<T> getDelegate() {
            return delegate;
        }

        @Override
        @NotNull
        public IReturnT<T> getReturn() {
            return returnValue;
        }

        // Delegate method implementations...
    }

    public static final class LocalVarSet<T> implements ILocalVarDecl.ISet<T>, ILocalVarDecl.IBuilder<T> {
        @NotNull
        private final ILocalVarDecl.IBuilder<T> delegate;
        @NotNull
        private final IParameterT<T> value;

        public LocalVarSet(@NotNull ILocalVarDecl.IBuilder<T> delegate) {
            if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
            this.delegate = delegate;
            this.value = new Parameter<>(0);
        }

        @NotNull
        public ILocalVarDecl.IBuilder<T> getDelegate() {
            return delegate;
        }

        @Override
        @NotNull
        public IParameterT<T> getValue() {
            return value;
        }

        // Delegate method implementations...
    }
}
