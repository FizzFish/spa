package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.analysis.SootHostExtend;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.tagkit.Host;
import java.util.Objects;
import java.util.function.Supplier;

public final class SootClassExtend extends SootHostExtend {
    @NotNull
    private final SootClass host;
    @NotNull
    private final CompilationUnit cu;
    private final Supplier<Node> declSupplier;

    public SootClassExtend(@NotNull SootClass host, @NotNull CompilationUnit cu) {
        super(host, cu);
        this.host = Objects.requireNonNull(host, "host");
        this.cu = Objects.requireNonNull(cu, "cu");
        this.declSupplier = () -> SootHostExtendKt.getDecl(super.getCu(), this.getHost());
    }

    @NotNull
    public SootClass getHost() {
        return host;
    }

    @Override
    @NotNull
    public CompilationUnit getCu() {
        return cu;
    }

    @Nullable
    public Node getDecl() {
        return declSupplier.get();
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        Node node = getDecl();
        if (node == null) {
            return null;
        }
        if (node instanceof TypeDeclaration) {
            return ((TypeDeclaration<?>) node).getName();
        } else if (node instanceof ObjectCreationExpr) {
            return ((ObjectCreationExpr) node).getType().getName();
        }
        return null;
    }

    @NotNull
    public SootClassExtend copy(@NotNull SootClass host, @NotNull CompilationUnit cu) {
        return new SootClassExtend(
            Objects.requireNonNull(host, "host"),
            Objects.requireNonNull(cu, "cu")
        );
    }

    @Override
    public String toString() {
        return "SootClassExtend(host=" + host + ", cu=" + cu + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SootClassExtend)) return false;
        SootClassExtend that = (SootClassExtend) o;
        return host.equals(that.host) && cu.equals(that.cu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, cu);
    }
}