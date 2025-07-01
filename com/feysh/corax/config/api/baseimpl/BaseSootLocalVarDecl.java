package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.ILocalVarDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.MethodConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Type;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public final class BaseSootLocalVarDecl<T> implements ISootLocalVarDecl<T>, ILocalVarDecl<T> {
    @NotNull
    private final ILocalVarDecl<T> delegate;
    @NotNull
    private final Local local;

    public BaseSootLocalVarDecl(@NotNull ILocalVarDecl<T> delegate, @NotNull Local local) {
        if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
        if (local == null) throw new IllegalArgumentException("local cannot be null");
        this.delegate = delegate;
        this.local = local;
    }

    @NotNull
    public ILocalVarDecl<T> getDelegate() {
        return delegate;
    }

    @Override
    @NotNull
    public Local getLocal() {
        return local;
    }

    @Override
    @Nullable
    public String getName() {
        return local.getName();
    }

    @Override
    @NotNull
    public Type getType() {
        return local.getType();
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atGet(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<ILocalVarDecl.IGet<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        return delegate.atGet(config, block);
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atSet(@NotNull Consumer<MethodConfig> config, @NotNull BiConsumer<ILocalVarDecl.ISet<T>, IParameterT<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        return delegate.atSet(config, block);
    }
}