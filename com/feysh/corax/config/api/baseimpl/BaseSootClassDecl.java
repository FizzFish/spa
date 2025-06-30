/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.ISootMethodDecl;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import com.feysh.corax.config.api.baseimpl.BaseFieldDecl;
import com.feysh.corax.config.api.baseimpl.BaseSootFieldDecl;
import com.feysh.corax.config.api.baseimpl.BaseSootMethodDecl;
import com.feysh.corax.config.api.baseimpl.MethodDeclBase;
import com.feysh.corax.config.api.baseimpl.SootFieldSignatureMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ1\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0012\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J7\u0010\u001a\u001a\u00020\u000f2-\u0010\u0010\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u0011H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\"\u001a\u00020#X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006&"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseSootClassDecl;", "Lcom/feysh/corax/config/api/ISootClassDecl;", "Lcom/feysh/corax/config/api/IClassDecl;", "delegate", "analyzeConfig", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "sootClass", "Lsoot/SootClass;", "<init>", "(Lcom/feysh/corax/config/api/IClassDecl;Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;Lsoot/SootClass;)V", "getDelegate", "()Lcom/feysh/corax/config/api/IClassDecl;", "getSootClass", "()Lsoot/SootClass;", "eachDeclaringMethod", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/ISootMethodDecl;", "", "Lkotlin/ParameterName;", "name", "method", "sootDeclaringMethod", "R", "Lsoot/SootMethod;", "eachDeclaringField", "Lcom/feysh/corax/config/api/ISootFieldDecl;", "field", "anySuperClass", "", "predicate", "toString", "", "match", "Lcom/feysh/corax/config/api/IClassMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IClassMatch;", "corax-config-api"})
public final class BaseSootClassDecl
implements ISootClassDecl,
IClassDecl {
    @NotNull
    private final IClassDecl delegate;
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final SootClass sootClass;

    public BaseSootClassDecl(@NotNull IClassDecl delegate, @NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull SootClass sootClass) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)analyzeConfig, (String)"analyzeConfig");
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        this.delegate = delegate;
        this.analyzeConfig = analyzeConfig;
        this.sootClass = sootClass;
    }

    @NotNull
    public final IClassDecl getDelegate() {
        return this.delegate;
    }

    @Override
    @NotNull
    public SootClass getSootClass() {
        return this.sootClass;
    }

    @Override
    public void eachDeclaringMethod(@NotNull Function1<? super ISootMethodDecl<Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        if (this.getSootClass().resolvingLevel() < 2) {
            return;
        }
        for (SootMethod sm : this.getSootClass().getMethods()) {
            Intrinsics.checkNotNull((Object)sm);
            ISootMethodDecl smd = this.sootDeclaringMethod(sm);
            block.invoke(smd);
        }
    }

    @Override
    @NotNull
    public <R> ISootMethodDecl<R> sootDeclaringMethod(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        MethodDeclBase md = new MethodDeclBase(this.analyzeConfig, SootSignatureMatch.Companion.invoke(method), null, 4, null);
        return new BaseSootMethodDecl(md, this, method);
    }

    @Override
    public void eachDeclaringField(@NotNull Function1<? super ISootFieldDecl<Object, Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Iterator iterator = this.getSootClass().getFields().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            SootField sf = (SootField)iterator2.next();
            Intrinsics.checkNotNull((Object)sf);
            BaseFieldDecl sootFd = new BaseFieldDecl(this.analyzeConfig, new SootFieldSignatureMatch(sf));
            BaseSootFieldDecl sootMd = new BaseSootFieldDecl(sootFd, this, sf);
            block.invoke(sootMd);
        }
    }

    @Override
    public boolean anySuperClass(@NotNull Function1<? super SootClass, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        SootClass clazz = this.getSootClass();
        while (clazz.hasSuperclass()) {
            if (!((Boolean)predicate.invoke((Object)(clazz = clazz.getSuperclass()))).booleanValue()) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "soot class decl: " + this.getSootClass();
    }

    @Override
    @NotNull
    public String getClazzName() {
        return ISootClassDecl.DefaultImpls.getClazzName(this);
    }

    @Override
    @NotNull
    public List<Tag> getClassTags() {
        return ISootClassDecl.DefaultImpls.getClassTags(this);
    }

    @Override
    @NotNull
    public List<AnnotationTag> getClassAnnotationTags() {
        return ISootClassDecl.DefaultImpls.getClassAnnotationTags(this);
    }

    @Override
    @NotNull
    public List<SootMethod> getDeclaringSootMethods() {
        return ISootClassDecl.DefaultImpls.getDeclaringSootMethods(this);
    }

    @Override
    @NotNull
    public IClassMatch getMatch() {
        return this.delegate.getMatch();
    }
}

