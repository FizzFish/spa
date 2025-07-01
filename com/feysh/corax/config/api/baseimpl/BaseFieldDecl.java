package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.baseimpl.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public final class BaseFieldDecl<This, T> implements IFieldDecl<This, T> {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final IFieldMatch match;

    public BaseFieldDecl(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IFieldMatch match) {
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
    public IFieldMatch getMatch() {
        return match;
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atSet(@NotNull Consumer<MethodConfig> config, @NotNull BiConsumer<IFieldDecl.ISet<This, T>, IParameterT<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        FieldSet setter = new FieldSet(new Builder(config));
        block.accept(setter, setter.getValue());
        return this;
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atGet(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<IFieldDecl.IGet<This, T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        FieldGet getter = new FieldGet(new Builder(config));
        block.accept(getter);
        return this;
    }

    @NotNull
    public String toString() {
        return "field decl: " + match;
    }

    public final class Builder implements IFieldDecl.IBuilder<This, T>, IBaseOperatorFactory {
        @NotNull
        private final Consumer<MethodConfig> config;
        @NotNull
        private final IFieldMatch match;
        @NotNull
        private final IFieldDecl<This, T> decl;
        @NotNull
        private final IParameterT<This> thisParam;
        @NotNull
        private final IAccessPathT<T> field;

        public Builder(@NotNull Consumer<MethodConfig> config) {
            if (config == null) throw new IllegalArgumentException("config cannot be null");
            this.config = config;
            this.match = BaseFieldDecl.this.getMatch();
            this.decl = BaseFieldDecl.this;
            this.thisParam = new Parameter(-1);
            this.field = new AccessPath(this.getThis().getExpr(), 
                new ClassField(this.getMatch().getDeclaringClassType(), 
                this.getMatch().getFieldName(), 
                this.getMatch().getFieldType()));
        }

        @Override
        @NotNull
        public Consumer<MethodConfig> getConfig() {
            return config;
        }

        @Override
        @NotNull
        public IFieldMatch getMatch() {
            return match;
        }

        @Override
        @NotNull
        public IFieldDecl<This, T> getDecl() {
            return decl;
        }

        @Override
        @NotNull
        public IParameterT<This> getThis() {
            return thisParam;
        }

        @Override
        @NotNull
        public IAccessPathT<T> getField() {
            return field;
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
            BaseFieldDecl.this.getAnalyzeConfig().addStmt(BaseFieldDecl.this, config, stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Consumer<BugMessage.Env> env) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (checkType == null) throw new IllegalArgumentException("checkType cannot be null");
            if (env == null) throw new IllegalArgumentException("env cannot be null");
            BaseFieldDecl.this.getAnalyzeConfig().check(BaseFieldDecl.this, config, expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Consumer<Object> result) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (result == null) throw new IllegalArgumentException("result cannot be null");
            BaseFieldDecl.this.getAnalyzeConfig().eval(BaseFieldDecl.this, config, expr, result);
        }

        // Implementations of other IBaseOperatorFactory and IFieldDecl.IBuilder methods...
        // (Omitted for brevity - they would follow similar patterns of delegation)
    }

    public final class FieldGet implements IFieldDecl.IGet<This, T>, IFieldDecl.IBuilder<This, T> {
        private final IFieldDecl.IBuilder<This, T> delegate;
        @NotNull
        private final IReturnT<T> returnValue;

        public FieldGet(@NotNull IFieldDecl.IBuilder<This, T> delegate) {
            if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
            this.delegate = delegate;
            this.returnValue = new Return<>();
        }

        @Override
        @NotNull
        public IReturnT<T> getReturn() {
            return returnValue;
        }

        // Delegated methods...
        @Override
        public IFieldDecl<This, T> getDecl() {
            return delegate.getDecl();
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
        }

        @Override
        public IAccessPathT<T> getField() {
            return delegate.getField();
        }

        // Other delegated methods...
        // (Omitted for brevity - they would all delegate to the underlying builder)
    }

    public final class FieldSet implements IFieldDecl.ISet<This, T>, IFieldDecl.IBuilder<This, T> {
        @NotNull
        private final IFieldDecl.IBuilder<This, T> delegate;
        @NotNull
        private final IParameterT<T> value;

        public FieldSet(@NotNull IFieldDecl.IBuilder<This, T> delegate) {
            if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
            this.delegate = delegate;
            this.value = new Parameter<>(0);
        }

        @NotNull
        public IFieldDecl.IBuilder<This, T> getDelegate() {
            return delegate;
        }

        @Override
        @NotNull
        public IParameterT<T> getValue() {
            return value;
        }

        // Delegated methods...
        @Override
        public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> local) {
            return delegate.getValue(local);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> local, @NotNull ILocalValue<T> value) {
            delegate.setValue(local, value);
        }

        // Other delegated methods...
        // (Omitted for brevity - they would all delegate to the underlying builder)
    }
}
