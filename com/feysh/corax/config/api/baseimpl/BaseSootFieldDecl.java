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
 *  soot.SootField
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 *  soot.tagkit.VisibilityAnnotationTag
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.MethodConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B+\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J[\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001f\u0010\u0015\u001a\u001b\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001b\u00a2\u0006\u0002\b\u001a2#\u0010\u001c\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0004\u0012\u00020\u00190\u0016\u00a2\u0006\u0002\b\u001aH\u0096\u0001Jv\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001f\u0010\u0015\u001a\u001b\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001b\u00a2\u0006\u0002\b\u001a2>\u0010\u001c\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00190\u001f\u00a2\u0006\u0002\b\u001aH\u0096\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseSootFieldDecl;", "This", "T", "Lcom/feysh/corax/config/api/ISootFieldDecl;", "Lcom/feysh/corax/config/api/IFieldDecl;", "delegate", "clazz", "Lcom/feysh/corax/config/api/ISootClassDecl;", "sootField", "Lsoot/SootField;", "<init>", "(Lcom/feysh/corax/config/api/IFieldDecl;Lcom/feysh/corax/config/api/ISootClassDecl;Lsoot/SootField;)V", "getDelegate", "()Lcom/feysh/corax/config/api/IFieldDecl;", "getClazz", "()Lcom/feysh/corax/config/api/ISootClassDecl;", "getSootField", "()Lsoot/SootField;", "toString", "", "atGet", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "block", "Lcom/feysh/corax/config/api/IFieldDecl$IGet;", "atSet", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/IFieldDecl$ISet;", "Lcom/feysh/corax/config/api/IParameterT;", "Lkotlin/ParameterName;", "name", "value", "corax-config-api"})
public final class BaseSootFieldDecl<This, T>
implements ISootFieldDecl<This, T>,
IFieldDecl<This, T> {
    @NotNull
    private final IFieldDecl<This, T> delegate;
    @NotNull
    private final ISootClassDecl clazz;
    @NotNull
    private final SootField sootField;

    public BaseSootFieldDecl(@NotNull IFieldDecl<This, T> delegate, @NotNull ISootClassDecl clazz, @NotNull SootField sootField) {
        Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)sootField, (String)"sootField");
        this.delegate = delegate;
        this.clazz = clazz;
        this.sootField = sootField;
    }

    @NotNull
    public final IFieldDecl<This, T> getDelegate() {
        return this.delegate;
    }

    @Override
    @NotNull
    public ISootClassDecl getClazz() {
        return this.clazz;
    }

    @Override
    @NotNull
    public SootField getSootField() {
        return this.sootField;
    }

    @NotNull
    public String toString() {
        return "soot decl: " + this.getSootField();
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return ISootFieldDecl.DefaultImpls.getVisibilityAnnotationTag(this);
    }

    @Override
    @NotNull
    public List<Tag> getTags() {
        return ISootFieldDecl.DefaultImpls.getTags(this);
    }

    @Override
    @Nullable
    public AnnotationTag getAnnotations() {
        return ISootFieldDecl.DefaultImpls.getAnnotations(this);
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atGet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super IFieldDecl.IGet<This, T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.delegate.atGet(config, block);
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atSet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super IFieldDecl.ISet<This, T>, ? super IParameterT<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.delegate.atSet(config, block);
    }
}

