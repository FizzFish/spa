package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.feysh.corax.cache.analysis.SootRangeKey;
import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.Host;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;


public final class SootMethodExtend extends SootHostExtend {
    @NotNull
    private final SootMethod host;
    @NotNull
    private final CompilationUnit cu;
    private Node classDecl;
    private Pair<Integer, Integer> sootRange;
    private CallableDeclaration<?> decl;
    private LambdaExpr lambdaExpr;

    public SootMethodExtend(@NotNull SootMethod host, @NotNull CompilationUnit cu) {
        super(host, cu);
        this.host = host;
        this.cu = cu;
    }

    @NotNull
    public SootMethod getHost() {
        return host;
    }

    @Override
    @NotNull
    public CompilationUnit getCu() {
        return cu;
    }

    @Nullable
    public Node getClassDecl() {
        if (classDecl == null) {
            classDecl = SootHostExtendKt.getDecl(getCu(), host.getDeclaringClass());
        }
        return classDecl;
    }

    @Nullable
    public Pair<Integer, Integer> getSootRange() {
        if (sootRange == null) {
            sootRange = AnalysisCache.G.INSTANCE.get(new SootRangeKey(host));
        }
        return sootRange;
    }

    public <T extends NodeWithRange<N>, N> boolean nodeMatcher(@NotNull T node) {
        Pair<Integer, Integer> range = getSootRange();
        if (range == null) {
            return false;
        }

        Optional begin = node.getBegin();
        Integer startLine = SootHostExtendKt.getLine(begin);
        if (startLine == null) {
            return false;
        }

        Optional end = node.getEnd();
        Integer endLine = SootHostExtendKt.getLine(end);
        if (endLine == null) {
            return false;
        }

        Pair<Integer, Integer> declRange = new Pair<>(startLine, endLine);
        if (declRange.getFirst() > declRange.getSecond()) {
            return false;
        }

        return declRange.getSecond() >= range.getFirst() && range.getSecond() >= declRange.getFirst();
    }

    @Nullable
    public CallableDeclaration<?> getDecl() {
        if (decl == null) {
            Node classDecl = getClassDecl();
            if (classDecl == null) {
                return null;
            }

            if (classDecl instanceof TypeDeclaration) {
                decl = getNormalMethods((TypeDeclaration<?>) classDecl);
            } else if (classDecl instanceof ObjectCreationExpr) {
                decl = getMethodsOfAnonymousClass((ObjectCreationExpr) classDecl);
            }
        }
        return decl;
    }

    private CallableDeclaration<?> getMethods(List<? extends CallableDeclaration<?>> methods) {
        List<CallableDeclaration<?>> matchingMethods = new ArrayList<>();
        for (CallableDeclaration<?> m : methods) {
            if (m.getNameAsString().equals(SootHostExtendKt.getDeclaredName(host))) {
                matchingMethods.add(m);
            }
        }

        if (matchingMethods.isEmpty()) {
            return null;
        }

        matchingMethods.sort(Comparator.comparing(m -> SootHostExtendKt.getLine(m.getBegin())));

        if (matchingMethods.size() == 1 || getSootRange() == null) {
            return matchingMethods.get(0);
        }

        List<CallableDeclaration<?>> matchedByRange = new ArrayList<>();
        for (CallableDeclaration<?> m : matchingMethods) {
            if (nodeMatcher(m)) {
                matchedByRange.add(m);
            }
        }

        return matchedByRange.isEmpty() ? matchingMethods.get(0) : matchedByRange.get(0);
    }

    private CallableDeclaration<?> getNormalMethods(TypeDeclaration<?> classDecl) {
        List<CallableDeclaration<?>> methods = new ArrayList<>();
        methods.addAll(classDecl.getConstructors());
        methods.addAll(classDecl.getMethods());
        return getMethods(methods);
    }

    private CallableDeclaration<?> getMethodsOfAnonymousClass(ObjectCreationExpr classDecl) {
        List<CallableDeclaration<?>> methods = new ArrayList<>();
        for (Node n : classDecl.getChildNodes()) {
            if (n instanceof CallableDeclaration) {
                methods.add((CallableDeclaration<?>) n);
            }
        }
        return getMethods(methods);
    }

    @Nullable
    public LambdaExpr getLambdaExpr() {
        if (lambdaExpr == null) {
            String methodName = host.getName();
            if (!methodName.startsWith("lambda$")) {
                return null;
            }

            if (getSootRange() == null) {
                return null;
            }

            Node classDecl = getClassDecl();
            if (classDecl == null) {
                return null;
            }

            List<LambdaExpr> lambdas = classDecl.findAll(LambdaExpr.class);
            if (lambdas == null) {
                return null;
            }

            List<LambdaExpr> filteredLambdas = new ArrayList<>();
            for (LambdaExpr lambda : lambdas) {
                Optional<Node> ancestor = lambda.findAncestor(classDecl.getClass());
                if (ancestor.isPresent() && ancestor.get() == classDecl) {
                    filteredLambdas.add(lambda);
                }
            }

            filteredLambdas.sort(Comparator.comparing(l -> SootHostExtendKt.getLine(l.getBegin())));

            lambdaExpr = getLambdaExprs(filteredLambdas);
        }
        return lambdaExpr;
    }

    private LambdaExpr getLambdaExprs(List<? extends LambdaExpr> allLambdaExpr) {
        List<LambdaExpr> matchingLambdas = new ArrayList<>();
        for (LambdaExpr lambda : allLambdaExpr) {
            if (nodeMatcher(lambda)) {
                matchingLambdas.add(lambda);
            }
        }

        if (matchingLambdas.isEmpty()) {
            return null;
        }

        return matchingLambdas.stream()
                .max(Comparator.comparingInt(l -> {
                    Optional<Range> range = l.getRange();
                    return range.map(r -> r.begin.line).orElse(-1);
                }))
                .orElse(null);
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        CallableDeclaration<?> decl = getDecl();
        return decl != null ? decl.getName() : null;
    }

    @NotNull
    public SootMethodExtend copy(@NotNull SootMethod host, @NotNull CompilationUnit cu) {
        return new SootMethodExtend(host, cu);
    }

    @Override
    public String toString() {
        return "SootMethodExtend(host=" + host + ", cu=" + cu + ")";
    }

    @Override
    public int hashCode() {
        return 31 * host.hashCode() + cu.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof SootMethodExtend)) return false;
        SootMethodExtend that = (SootMethodExtend) other;
        return host.equals(that.host) && cu.equals(that.cu);
    }
}
