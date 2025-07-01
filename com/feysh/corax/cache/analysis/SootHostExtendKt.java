package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.Host;
import soot.util.Chain;

public final class SootHostExtendKt {
    public static final char OUTER_INNER_CLASSES_DELIMITER = '$';

    @Nullable
    public static Integer getLine(@NotNull Optional<Position> position) {
        if (position == null) throw new NullPointerException("position is null");
        return position.map(p -> p.line).orElse(null);
    }

    @Nullable
    public static Integer getColumn(@NotNull Optional<Position> position) {
        if (position == null) throw new NullPointerException("position is null");
        return position.map(p -> p.column).orElse(null);
    }

    @Nullable
    public static SootHostExtend ext(@NotNull Host host, @NotNull AnalysisCache cache, 
                                    @NotNull AnalysisDataFactory.Key<SootHostExtend> key) {
        if (host == null) throw new NullPointerException("host is null");
        if (cache == null) throw new NullPointerException("cache is null");
        if (key == null) throw new NullPointerException("key is null");
        
        if (host instanceof Unit) {
            return null;
        }
        return cache.get(new SootHostExtInfoKey(host, key));
    }

    @NotNull
    public static String getDeclaredClassName(@NotNull SootClass sootClass) {
        if (sootClass == null) throw new NullPointerException("sootClass is null");
        return sootClass.isInnerClass() 
            ? sootClass.getJavaStyleName().substring(sootClass.getJavaStyleName().lastIndexOf('$') + 1)
            : sootClass.getJavaStyleName();
    }

    @NotNull
    public static String getDeclaredName(@NotNull SootMethod sootMethod) {
        if (sootMethod == null) throw new NullPointerException("sootMethod is null");
        return (sootMethod.isStaticInitializer() || sootMethod.isConstructor()) 
            ? getDeclaredClassName(sootMethod.getDeclaringClass())
            : sootMethod.getName();
    }

    @Nullable
    public static Node getDecl(@NotNull CompilationUnit compilationUnit, @NotNull SootClass sootClass) {
        if (sootClass == null) throw new NullPointerException("sootClass is null");
        if (compilationUnit == null) throw new NullPointerException("compilationUnit is null");
        
        List<Node> allClassDecls = getAllClassDecls(compilationUnit);
        TypeDeclaration<?> typeDecl = matchClassByFullyQualifiedName(sootClass, allClassDecls);
        if (typeDecl != null) return typeDecl;
        
        return matchClassByRange(sootClass, allClassDecls);
    }

    private static List<Node> getAllClassDecls(CompilationUnit compilationUnit) {
        List<TypeDeclaration> types = compilationUnit.findAll(TypeDeclaration.class)
            .stream()
            .filter(t -> !(t instanceof AnnotationDeclaration))
            .collect(Collectors.toList());
            
        List<ObjectCreationExpr> anonymousClasses = compilationUnit.findAll(ObjectCreationExpr.class)
            .stream()
            .filter(expr -> expr.getAnonymousClassBody().isPresent())
            .collect(Collectors.toList());
            
        List<Node> result = new ArrayList<>(types);
        result.addAll(anonymousClasses);
        return result;
    }

    private static TypeDeclaration<?> matchClassByFullyQualifiedName(SootClass sootClass, List<? extends Node> classDecls) {
        return classDecls.stream()
            .filter(TypeDeclaration.class::isInstance)
            .map(TypeDeclaration.class::cast)
            .filter(clazz -> {
                String fqn = (String) clazz.getFullyQualifiedName().orElse(null);
                return fqn != null && fqn.equals(sootClass.getName().replace('$', '.'));
            })
            .findFirst()
            .orElse(null);
    }

    private static Node matchClassByRange(SootClass sootClass, List<? extends Node> classDecls) {
        Node res = null;
        for (Node node : classDecls) {
            if (!(node instanceof TypeDeclaration) && !(node instanceof ObjectCreationExpr)) continue;
            
            Range range = node.getRange().orElse(null);
            if (range == null || !rangeCoverClass(range, sootClass)) continue;
            
            if (res != null) {
                int preMatchLine = res.getRange()
                    .flatMap(Range::getBegin)
                    .map(Position::getLine)
                    .orElse(-1);
                if (preMatchLine > range.begin.line) continue;
            }
            res = node;
        }

        if (res == null) return null;

        List<String> methodNames = sootClass.getMethods().stream()
            .map(SootMethod::getName)
            .collect(Collectors.toList());

        if (res instanceof TypeDeclaration) {
            TypeDeclaration<?> typeDecl = (TypeDeclaration<?>) res;
            if (!sootClass.getShortName().endsWith("$" + typeDecl.getNameAsString())) {
                return null;
            }
            return typeDecl.getMethods().stream()
                .anyMatch(m -> !methodNames.contains(m.getNameAsString())) ? null : res;
        } 
        else if (res instanceof ObjectCreationExpr) {
            ObjectCreationExpr expr = (ObjectCreationExpr) res;
            String typeName = expr.getType().getNameAsString();
            
            SootClass superClass = UtilsKt.superClassOrNull(sootClass);
            if (superClass != null && !superClass.getShortName().equals(typeName) 
                && !"java.lang.Object".equals(superClass.getName())) {
                return null;
            }
            
            if (superClass == null || "java.lang.Object".equals(superClass.getName())) {
                Chain<SootClass> interfaces = sootClass.getInterfaces();
                if (interfaces.size() == 1) {
                    SootClass singleInterface = interfaces.getFirst();
                    if (!singleInterface.getShortName().equals(typeName)) {
                        return null;
                    }
                }
            }
            
            return expr.findAll(CallableDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN).stream()
                .anyMatch(m -> !methodNames.contains(m.getNameAsString())) ? null : res;
        }
        return null;
    }

    private static boolean rangeCoverClass(Range range, SootClass sootClass) {
        SootLineToMethodMap lineMap = AnalysisCache.G.INSTANCE.get(new SootLineToMethodMapKey(sootClass));
        if (lineMap == null || lineMap.getMap().isEmpty()) {
            return false;
        }
        
        TreeMap<Integer, ?> map = lineMap.getMap();
        return range.begin.line <= map.firstKey() && range.end.line >= map.lastKey();
    }
}
