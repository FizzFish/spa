/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.ast.CompilationUnit
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.body.TypeDeclaration
 *  com.github.javaparser.ast.expr.ObjectCreationExpr
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2={"Lcom/feysh/corax/cache/analysis/SootClassExtend;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "host", "Lsoot/SootClass;", "cu", "Lcom/github/javaparser/ast/CompilationUnit;", "<init>", "(Lsoot/SootClass;Lcom/github/javaparser/ast/CompilationUnit;)V", "getHost", "()Lsoot/SootClass;", "getCu", "()Lcom/github/javaparser/ast/CompilationUnit;", "decl", "Lcom/github/javaparser/ast/Node;", "getDecl", "()Lcom/github/javaparser/ast/Node;", "decl$delegate", "Lkotlin/Lazy;", "nameDecl", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "getNameDecl", "()Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootClassExtend\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,391:1\n1#2:392\n*E\n"})
public final class SootClassExtend
extends SootHostExtend {
    @NotNull
    private final SootClass host;
    @NotNull
    private final CompilationUnit cu;
    @NotNull
    private final Lazy decl$delegate;

    public SootClassExtend(@NotNull SootClass host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        super((Host)host, cu, null);
        this.host = host;
        this.cu = cu;
        this.decl$delegate = LazyKt.lazy(() -> SootClassExtend.decl_delegate$lambda$1(this));
    }

    @NotNull
    public SootClass getHost() {
        return this.host;
    }

    @Override
    @NotNull
    public CompilationUnit getCu() {
        return this.cu;
    }

    @Nullable
    public Node getDecl() {
        Lazy lazy = this.decl$delegate;
        return (Node)lazy.getValue();
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        Node node = this.getDecl();
        if (node == null) {
            return null;
        }
        Node decl = node;
        Node node2 = decl;
        return node2 instanceof TypeDeclaration ? (NodeWithRange)((TypeDeclaration)decl).getName() : (node2 instanceof ObjectCreationExpr ? (NodeWithRange)((ObjectCreationExpr)decl).getType().getName() : null);
    }

    @NotNull
    public final SootClass component1() {
        return this.host;
    }

    @NotNull
    public final CompilationUnit component2() {
        return this.cu;
    }

    @NotNull
    public final SootClassExtend copy(@NotNull SootClass host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        return new SootClassExtend(host, cu);
    }

    public static /* synthetic */ SootClassExtend copy$default(SootClassExtend sootClassExtend, SootClass sootClass, CompilationUnit compilationUnit, int n, Object object) {
        if ((n & 1) != 0) {
            sootClass = sootClassExtend.host;
        }
        if ((n & 2) != 0) {
            compilationUnit = sootClassExtend.cu;
        }
        return sootClassExtend.copy(sootClass, compilationUnit);
    }

    @NotNull
    public String toString() {
        return "SootClassExtend(host=" + this.host + ", cu=" + this.cu + ")";
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
        if (!(other instanceof SootClassExtend)) {
            return false;
        }
        SootClassExtend sootClassExtend = (SootClassExtend)other;
        if (!Intrinsics.areEqual((Object)this.host, (Object)sootClassExtend.host)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cu, (Object)sootClassExtend.cu);
    }

    private static final Node decl_delegate$lambda$1(SootClassExtend this$0) {
        CompilationUnit $this$decl_delegate_u24lambda_u241_u24lambda_u240 = super.getCu();
        boolean bl = false;
        return SootHostExtendKt.getDecl($this$decl_delegate_u24lambda_u241_u24lambda_u240, this$0.getHost());
    }
}

