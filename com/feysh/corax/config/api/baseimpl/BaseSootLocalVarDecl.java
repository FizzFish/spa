/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Type
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.ILocalVarDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.MethodConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJO\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001f\u0010\u000e\u001a\u001b\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0014\u00a2\u0006\u0002\b\u00132\u001d\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0004\u0012\u00020\u00120\u000f\u00a2\u0006\u0002\b\u0013H\u0096\u0001Jj\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001f\u0010\u000e\u001a\u001b\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0014\u00a2\u0006\u0002\b\u001328\u0010\u0015\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0018\u00a2\u0006\u0002\b\u0013H\u0096\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseSootLocalVarDecl;", "T", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "delegate", "local", "Lsoot/Local;", "<init>", "(Lcom/feysh/corax/config/api/ILocalVarDecl;Lsoot/Local;)V", "getDelegate", "()Lcom/feysh/corax/config/api/ILocalVarDecl;", "getLocal", "()Lsoot/Local;", "atGet", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "block", "Lcom/feysh/corax/config/api/ILocalVarDecl$IGet;", "atSet", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/ILocalVarDecl$ISet;", "Lcom/feysh/corax/config/api/IParameterT;", "Lkotlin/ParameterName;", "name", "value", "corax-config-api"})
public final class BaseSootLocalVarDecl<T>
implements ISootLocalVarDecl<T>,
ILocalVarDecl<T> {
    @NotNull
    private final ILocalVarDecl<T> delegate;
    @NotNull
    private final Local local;

    public BaseSootLocalVarDecl(@NotNull ILocalVarDecl<T> delegate, @NotNull Local local) {
        Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)local, (String)"local");
        this.delegate = delegate;
        this.local = local;
    }

    @NotNull
    public final ILocalVarDecl<T> getDelegate() {
        return this.delegate;
    }

    @Override
    @NotNull
    public Local getLocal() {
        return this.local;
    }

    @Override
    @Nullable
    public String getName() {
        return ISootLocalVarDecl.DefaultImpls.getName(this);
    }

    @Override
    @NotNull
    public Type getType() {
        return ISootLocalVarDecl.DefaultImpls.getType(this);
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atGet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super ILocalVarDecl.IGet<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.delegate.atGet(config, block);
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atSet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super ILocalVarDecl.ISet<T>, ? super IParameterT<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.delegate.atSet(config, block);
    }
}

