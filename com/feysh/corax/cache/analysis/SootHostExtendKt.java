/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.Position
 *  com.github.javaparser.Range
 *  com.github.javaparser.ast.CompilationUnit
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.Node$TreeTraversal
 *  com.github.javaparser.ast.body.AnnotationDeclaration
 *  com.github.javaparser.ast.body.CallableDeclaration
 *  com.github.javaparser.ast.body.TypeDeclaration
 *  com.github.javaparser.ast.expr.ObjectCreationExpr
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 *  soot.tagkit.Host
 *  soot.util.Chain
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootHostExtInfoKey;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.feysh.corax.cache.analysis.SootLineToMethodMap;
import com.feysh.corax.cache.analysis.SootLineToMethodMapKey;
import com.feysh.corax.config.api.utils.UtilsKt;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.Host;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000p\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u0010\u001a\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H\u0002R\u00020\u001e\u00a2\u0006\u0002\u0010#\u001a$\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H\u0002\u001a \u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H\u0002\u001a\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010&\u001a\u00020\u0015H\u0002\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0014*\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u00158Fb\u00020\u001e\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 *\u001a\u0010\b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00a8\u0006-"}, d2={"line", "", "Ljava/util/Optional;", "Lcom/github/javaparser/Position;", "getLine", "(Ljava/util/Optional;)Ljava/lang/Integer;", "column", "getColumn", "SootHostExtInfoFKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "ext", "Lsoot/tagkit/Host;", "c", "Lcom/feysh/corax/cache/AnalysisCache;", "key", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoFKey;", "OUTER_INNER_CLASSES_DELIMITER", "", "declaredClassName", "", "Lsoot/SootClass;", "getDeclaredClassName", "(Lsoot/SootClass;)Ljava/lang/String;", "declaredName", "Lsoot/SootMethod;", "getDeclaredName", "(Lsoot/SootMethod;)Ljava/lang/String;", "decl", "Lcom/github/javaparser/ast/Node;", "Lcom/github/javaparser/ast/CompilationUnit;", "getDecl", "(Lcom/github/javaparser/ast/CompilationUnit;Lsoot/SootClass;)Lcom/github/javaparser/ast/Node;", "getAllClassDecls", "", "(Lcom/github/javaparser/ast/CompilationUnit;)Ljava/util/List;", "matchClassByFullyQualifiedName", "Lcom/github/javaparser/ast/body/TypeDeclaration;", "sootClass", "classDecls", "matchClassByRange", "rangeCoverClass", "", "range", "Lcom/github/javaparser/Range;", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootHostExtendKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,391:1\n774#2:392\n865#2,2:393\n808#2,11:395\n295#2,2:406\n1557#2:408\n1628#2,3:409\n1755#2,3:412\n1#3:415\n*S KotlinDebug\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootHostExtendKt\n*L\n317#1:392\n317#1:393,2\n328#1:395,11\n328#1:406,2\n351#1:408\n351#1:409,3\n378#1:412,3\n*E\n"})
public final class SootHostExtendKt {
    public static final char OUTER_INNER_CLASSES_DELIMITER = '$';

    @Nullable
    public static final Integer getLine(@NotNull Optional<Position> $this$line) {
        Intrinsics.checkNotNullParameter($this$line, (String)"<this>");
        Position position = (Position)OptionalsKt.getOrNull($this$line);
        return position != null ? Integer.valueOf(position.line) : null;
    }

    @Nullable
    public static final Integer getColumn(@NotNull Optional<Position> $this$column) {
        Intrinsics.checkNotNullParameter($this$column, (String)"<this>");
        Position position = (Position)OptionalsKt.getOrNull($this$column);
        return position != null ? Integer.valueOf(position.column) : null;
    }

    @Nullable
    public static final SootHostExtend ext(@NotNull Host $this$ext, @NotNull AnalysisCache c, @NotNull AnalysisDataFactory.Key<SootHostExtend> key2) {
        Intrinsics.checkNotNullParameter((Object)$this$ext, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        if ($this$ext instanceof Unit) {
            return null;
        }
        return (SootHostExtend)c.get(new SootHostExtInfoKey($this$ext, key2));
    }

    public static /* synthetic */ SootHostExtend ext$default(Host host, AnalysisCache analysisCache, AnalysisDataFactory.Key key2, int n, Object object) {
        if ((n & 1) != 0) {
            analysisCache = AnalysisCache.G.INSTANCE;
        }
        return SootHostExtendKt.ext(host, analysisCache, key2);
    }

    @NotNull
    public static final String getDeclaredClassName(@NotNull SootClass $this$declaredClassName) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$declaredClassName, (String)"<this>");
        if ($this$declaredClassName.isInnerClass()) {
            String string2 = $this$declaredClassName.getJavaStyleName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getJavaStyleName(...)");
            string = StringsKt.substringAfterLast$default((String)string2, (char)'$', null, (int)2, null);
        } else {
            String string3 = $this$declaredClassName.getJavaStyleName();
            Intrinsics.checkNotNull((Object)string3);
            string = string3;
        }
        return string;
    }

    @NotNull
    public static final String getDeclaredName(@NotNull SootMethod $this$declaredName) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$declaredName, (String)"<this>");
        if ($this$declaredName.isStaticInitializer() || $this$declaredName.isConstructor()) {
            SootClass sootClass = $this$declaredName.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            string = SootHostExtendKt.getDeclaredClassName(sootClass);
        } else {
            String string2 = $this$declaredName.getName();
            Intrinsics.checkNotNull((Object)string2);
            string = string2;
        }
        return string;
    }

    @Nullable
    public static final Node getDecl(@NotNull CompilationUnit $context_receiver_0, @NotNull SootClass $this$decl) {
        Intrinsics.checkNotNullParameter((Object)$this$decl, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        List<Node> allClassDecls = SootHostExtendKt.getAllClassDecls($context_receiver_0);
        TypeDeclaration<?> typeDeclaration = SootHostExtendKt.matchClassByFullyQualifiedName($this$decl, allClassDecls);
        if (typeDeclaration != null) {
            TypeDeclaration<?> it = typeDeclaration;
            boolean bl = false;
            return (Node)it;
        }
        Node node = SootHostExtendKt.matchClassByRange($this$decl, allClassDecls);
        if (node != null) {
            Node it = node;
            boolean bl = false;
            return it;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private static final List<Node> getAllClassDecls(CompilationUnit $context_receiver_0) {
        void $this$filterTo$iv$iv;
        List list = $context_receiver_0.findAll(TypeDeclaration.class);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"findAll(...)");
        Iterable $this$filter$iv = list;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            TypeDeclaration it = (TypeDeclaration)element$iv$iv;
            boolean bl = false;
            if (!(!(it instanceof AnnotationDeclaration))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List types = (List)destination$iv$iv;
        List list2 = $context_receiver_0.findAll(ObjectCreationExpr.class, (Predicate)getAllClassDecls.anonymousClasses.1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"findAll(...)");
        List anonymousClasses2 = CollectionsKt.filterNotNull((Iterable)list2);
        return CollectionsKt.plus((Collection)types, (Iterable)anonymousClasses2);
    }

    /*
     * WARNING - void declaration
     */
    private static final TypeDeclaration<?> matchClassByFullyQualifiedName(SootClass sootClass, List<? extends Node> classDecls) {
        Object v3;
        block4: {
            void $this$filterIsInstanceTo$iv$iv;
            Iterable $this$filterIsInstance$iv = classDecls;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof TypeDeclaration)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$firstOrNull$iv = (List)destination$iv$iv;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl;
                TypeDeclaration clazz = (TypeDeclaration)element$iv;
                boolean bl2 = false;
                Optional optional = clazz.getFullyQualifiedName();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getFullyQualifiedName(...)");
                if ((String)OptionalsKt.getOrNull((Optional)optional) == null) {
                    bl = false;
                } else {
                    String fullQualifiedName;
                    String string = sootClass.getName();
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
                    bl = Intrinsics.areEqual((Object)fullQualifiedName, (Object)StringsKt.replace$default((String)string, (char)'$', (char)'.', (boolean)false, (int)4, null));
                }
                if (!bl) continue;
                v3 = element$iv;
                break block4;
            }
            v3 = null;
        }
        return v3;
    }

    /*
     * WARNING - void declaration
     */
    private static final Node matchClassByRange(SootClass sootClass, List<? extends Node> classDecls) {
        boolean bl;
        List list;
        List list2;
        void $this$mapTo$iv$iv;
        Iterable range;
        Node res = null;
        for (Node node : classDecls) {
            Node node2;
            Node node3 = node;
            if (!(node3 instanceof TypeDeclaration) && !(node3 instanceof ObjectCreationExpr)) continue;
            Optional optional = node.getRange();
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getRange(...)");
            if ((Range)OptionalsKt.getOrNull((Optional)optional) == null || !SootHostExtendKt.rangeCoverClass((Range)range, sootClass)) continue;
            if (res != null) {
                Optional optional2 = res.getRange();
                int preMatchLine = optional2 != null && (optional2 = (Range)OptionalsKt.getOrNull((Optional)optional2)) != null && (optional2 = ((Range)optional2).begin) != null ? ((Position)optional2).line : -1;
                if (preMatchLine > ((Range)range).begin.line) continue;
                node2 = node;
            } else {
                node2 = node;
            }
            res = node2;
        }
        List list3 = sootClass.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)list3, (String)"getMethods(...)");
        Iterable iterable = list3;
        boolean $i$f$map = false;
        range = iterable;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            SootMethod sootMethod = (SootMethod)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getName());
        }
        List names = (List)destination$iv$iv;
        if (res instanceof TypeDeclaration) {
            String string = sootClass.getShortName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getShortName(...)");
            if (!StringsKt.endsWith$default((String)string, (String)("$" + ((TypeDeclaration)res).getName().getIdentifier()), (boolean)false, (int)2, null)) {
                return null;
            }
            list2 = ((TypeDeclaration)res).getMethods();
        } else if (res instanceof ObjectCreationExpr) {
            SootClass superClass = UtilsKt.superClassOrNull(sootClass);
            String identifier = ((ObjectCreationExpr)res).getType().getName().getIdentifier();
            if (superClass != null) {
                String string = superClass.getShortName();
                if (!(string != null ? string.equals(identifier) : false) && !Intrinsics.areEqual((Object)superClass.getName(), (Object)"java.lang.Object")) {
                    return null;
                }
            }
            if (superClass == null || Intrinsics.areEqual((Object)superClass.getName(), (Object)"java.lang.Object")) {
                Chain chain = sootClass.getInterfaces();
                Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
                SootClass singleInterface = (SootClass)CollectionsKt.singleOrNull((Iterable)((Iterable)chain));
                if (singleInterface != null) {
                    String string = singleInterface.getShortName();
                    if (!(string != null ? string.equals(identifier) : false)) {
                        return null;
                    }
                }
            }
            list2 = ((ObjectCreationExpr)res).findAll(CallableDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
        } else {
            return null;
        }
        List list4 = list = list2;
        if (list4 != null) {
            boolean bl2;
            block20: {
                Iterable $this$any$iv = list4;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        CallableDeclaration decl = (CallableDeclaration)element$iv;
                        boolean bl4 = false;
                        if (!(!names.contains(decl.getNameAsString()))) continue;
                        bl2 = true;
                        break block20;
                    }
                    bl2 = false;
                }
            }
            bl = bl2;
        } else {
            bl = false;
        }
        if (bl) {
            return null;
        }
        return res;
    }

    private static final boolean rangeCoverClass(Range range, SootClass sootClass) {
        Object object;
        block5: {
            block4: {
                Object object2;
                object = (SootLineToMethodMap)AnalysisCache.G.INSTANCE.get(new SootLineToMethodMapKey(sootClass));
                if (object == null || (object = ((SootLineToMethodMap)object).getMap()) == null) break block4;
                Object it = object2 = object;
                boolean bl = false;
                object = !((Map)it).isEmpty() ? object2 : null;
                if (object != null) break block5;
            }
            return false;
        }
        Object map = object;
        if (range.end.line < ((Number)((TreeMap)map).lastKey()).intValue()) {
            return false;
        }
        return range.begin.line <= ((Number)((TreeMap)map).firstKey()).intValue();
    }
}

