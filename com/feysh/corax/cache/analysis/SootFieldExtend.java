/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.ast.CompilationUnit
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.Node$TreeTraversal
 *  com.github.javaparser.ast.body.FieldDeclaration
 *  com.github.javaparser.ast.body.TypeDeclaration
 *  com.github.javaparser.ast.body.VariableDeclarator
 *  com.github.javaparser.ast.expr.ObjectCreationExpr
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootField
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dH\u0002J\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00132\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020!H\u0002J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020,H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006-"}, d2={"Lcom/feysh/corax/cache/analysis/SootFieldExtend;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "host", "Lsoot/SootField;", "cu", "Lcom/github/javaparser/ast/CompilationUnit;", "<init>", "(Lsoot/SootField;Lcom/github/javaparser/ast/CompilationUnit;)V", "getHost", "()Lsoot/SootField;", "getCu", "()Lcom/github/javaparser/ast/CompilationUnit;", "classDecl", "Lcom/github/javaparser/ast/Node;", "getClassDecl", "()Lcom/github/javaparser/ast/Node;", "classDecl$delegate", "Lkotlin/Lazy;", "decl", "Lcom/github/javaparser/ast/body/FieldDeclaration;", "getDecl", "()Lcom/github/javaparser/ast/body/FieldDeclaration;", "decl$delegate", "nameDecl", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "getNameDecl", "()Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "getFields", "fields", "", "getNormalFields", "Lcom/github/javaparser/ast/body/TypeDeclaration;", "getFieldsOfAnonymousClass", "Lcom/github/javaparser/ast/expr/ObjectCreationExpr;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootFieldExtend\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,391:1\n1#2:392\n*E\n"})
public final class SootFieldExtend
extends SootHostExtend {
    @NotNull
    private final SootField host;
    @NotNull
    private final CompilationUnit cu;
    @NotNull
    private final Lazy classDecl$delegate;
    @NotNull
    private final Lazy decl$delegate;

    public SootFieldExtend(@NotNull SootField host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        super((Host)host, cu, null);
        this.host = host;
        this.cu = cu;
        this.classDecl$delegate = LazyKt.lazy(() -> SootFieldExtend.classDecl_delegate$lambda$1(this));
        this.decl$delegate = LazyKt.lazy(() -> SootFieldExtend.decl_delegate$lambda$2(this));
    }

    @NotNull
    public SootField getHost() {
        return this.host;
    }

    @Override
    @NotNull
    public CompilationUnit getCu() {
        return this.cu;
    }

    @Nullable
    public final Node getClassDecl() {
        Lazy lazy = this.classDecl$delegate;
        return (Node)lazy.getValue();
    }

    @Nullable
    public FieldDeclaration getDecl() {
        Lazy lazy = this.decl$delegate;
        return (FieldDeclaration)lazy.getValue();
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        FieldDeclaration fieldDeclaration = this.getDecl();
        return (NodeWithRange)(fieldDeclaration != null ? fieldDeclaration.getElementType() : null);
    }

    private final FieldDeclaration getFields(List<? extends FieldDeclaration> fields) {
        Function1 function1 = arg_0 -> SootFieldExtend.getFields$lambda$4(this, arg_0);
        Optional optional = fields.stream().filter(new Predicate(function1){
            private final /* synthetic */ Function1 function;
            {
                Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                this.function = function;
            }

            public final /* synthetic */ boolean test(Object p0) {
                return (Boolean)this.function.invoke(p0);
            }
        }).findFirst();
        Intrinsics.checkNotNullExpressionValue(optional, (String)"findFirst(...)");
        Optional fieldDeclaration = optional;
        return (FieldDeclaration)OptionalsKt.getOrNull(fieldDeclaration);
    }

    private final FieldDeclaration getNormalFields(TypeDeclaration<?> classDecl) {
        List list = classDecl.getFields();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getFields(...)");
        return this.getFields(list);
    }

    private final FieldDeclaration getFieldsOfAnonymousClass(ObjectCreationExpr classDecl) {
        List list = classDecl.findAll(FieldDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"findAll(...)");
        return this.getFields(CollectionsKt.filterNotNull((Iterable)list));
    }

    @NotNull
    public final SootField component1() {
        return this.host;
    }

    @NotNull
    public final CompilationUnit component2() {
        return this.cu;
    }

    @NotNull
    public final SootFieldExtend copy(@NotNull SootField host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        return new SootFieldExtend(host, cu);
    }

    public static /* synthetic */ SootFieldExtend copy$default(SootFieldExtend sootFieldExtend, SootField sootField, CompilationUnit compilationUnit, int n, Object object) {
        if ((n & 1) != 0) {
            sootField = sootFieldExtend.host;
        }
        if ((n & 2) != 0) {
            compilationUnit = sootFieldExtend.cu;
        }
        return sootFieldExtend.copy(sootField, compilationUnit);
    }

    @NotNull
    public String toString() {
        return "SootFieldExtend(host=" + this.host + ", cu=" + this.cu + ")";
    }

    public int hashCode() {
        int result = this.host.hashCode();
        result = result * 31 + this.cu.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootFieldExtend)) {
            return false;
        }
        SootFieldExtend sootFieldExtend = (SootFieldExtend)other;
        if (!Intrinsics.areEqual((Object)this.host, (Object)sootFieldExtend.host)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cu, (Object)sootFieldExtend.cu);
    }

    private static final Node classDecl_delegate$lambda$1(SootFieldExtend this$0) {
        CompilationUnit $this$classDecl_delegate_u24lambda_u241_u24lambda_u240 = this$0.getCu();
        boolean bl = false;
        SootClass sootClass = this$0.getHost().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return SootHostExtendKt.getDecl($this$classDecl_delegate_u24lambda_u241_u24lambda_u240, sootClass);
    }

    private static final FieldDeclaration decl_delegate$lambda$2(SootFieldExtend this$0) {
        Node node = this$0.getClassDecl();
        if (node == null) {
            return null;
        }
        Node classDecl = node;
        Node node2 = classDecl;
        return node2 instanceof TypeDeclaration ? this$0.getNormalFields((TypeDeclaration)classDecl) : (node2 instanceof ObjectCreationExpr ? this$0.getFieldsOfAnonymousClass((ObjectCreationExpr)classDecl) : null);
    }

    private static final boolean getFields$lambda$4$lambda$3(SootFieldExtend this$0, VariableDeclarator v) {
        return v.getNameAsString().equals(this$0.getHost().getName());
    }

    private static final boolean getFields$lambda$4(SootFieldExtend this$0, FieldDeclaration f) {
        Function1 function1 = arg_0 -> SootFieldExtend.getFields$lambda$4$lambda$3(this$0, arg_0);
        return f.getVariables().stream().anyMatch(new /* invalid duplicate definition of identical inner class */);
    }
}

