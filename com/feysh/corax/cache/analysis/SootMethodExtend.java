/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.Range
 *  com.github.javaparser.ast.CompilationUnit
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.Node$TreeTraversal
 *  com.github.javaparser.ast.body.CallableDeclaration
 *  com.github.javaparser.ast.body.TypeDeclaration
 *  com.github.javaparser.ast.expr.LambdaExpr
 *  com.github.javaparser.ast.expr.ObjectCreationExpr
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.feysh.corax.cache.analysis.SootRangeKey;
import com.github.javaparser.Range;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0018\u001a\u00020\u0019\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001a\u00a2\u0006\u0002\u0010\u001eJ \u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010 2\u0010\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0&H\u0002J\u001a\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010 2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030(H\u0002J\u0016\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010 2\u0006\u0010\f\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0&H\u0002J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\u001d\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u0014H\u00d6\u0001J\t\u0010<\u001a\u00020=H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\"R\u001d\u0010.\u001a\u0004\u0018\u00010,8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b/\u00100R\u001c\u00102\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006>"}, d2={"Lcom/feysh/corax/cache/analysis/SootMethodExtend;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "host", "Lsoot/SootMethod;", "cu", "Lcom/github/javaparser/ast/CompilationUnit;", "<init>", "(Lsoot/SootMethod;Lcom/github/javaparser/ast/CompilationUnit;)V", "getHost", "()Lsoot/SootMethod;", "getCu", "()Lcom/github/javaparser/ast/CompilationUnit;", "classDecl", "Lcom/github/javaparser/ast/Node;", "getClassDecl", "()Lcom/github/javaparser/ast/Node;", "classDecl$delegate", "Lkotlin/Lazy;", "sootRange", "Lkotlin/Pair;", "", "getSootRange", "()Lkotlin/Pair;", "sootRange$delegate", "nodeMatcher", "", "T", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "N", "node", "(Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;)Z", "decl", "Lcom/github/javaparser/ast/body/CallableDeclaration;", "getDecl", "()Lcom/github/javaparser/ast/body/CallableDeclaration;", "decl$delegate", "getMethods", "methods", "", "getNormalMethods", "Lcom/github/javaparser/ast/body/TypeDeclaration;", "getMethodsOfAnonymousClass", "Lcom/github/javaparser/ast/expr/ObjectCreationExpr;", "getLambdaExprs", "Lcom/github/javaparser/ast/expr/LambdaExpr;", "allLambdaExpr", "lambdaExpr", "getLambdaExpr", "()Lcom/github/javaparser/ast/expr/LambdaExpr;", "lambdaExpr$delegate", "nameDecl", "getNameDecl", "()Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootMethodExtend\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,391:1\n774#2:392\n865#2,2:393\n1053#2:395\n774#2:396\n865#2,2:397\n774#2:399\n865#2,2:400\n1971#2,14:402\n774#2:417\n865#2,2:418\n1053#2:420\n1#3:416\n*S KotlinDebug\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootMethodExtend\n*L\n80#1:392\n80#1:393,2\n81#1:395\n90#1:396\n90#1:397,2\n111#1:399\n111#1:400,2\n112#1:402,14\n122#1:417\n122#1:418,2\n123#1:420\n*E\n"})
public final class SootMethodExtend
extends SootHostExtend {
    @NotNull
    private final SootMethod host;
    @NotNull
    private final CompilationUnit cu;
    @NotNull
    private final Lazy classDecl$delegate;
    @NotNull
    private final Lazy sootRange$delegate;
    @NotNull
    private final Lazy decl$delegate;
    @NotNull
    private final Lazy lambdaExpr$delegate;

    public SootMethodExtend(@NotNull SootMethod host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        super((Host)host, cu, null);
        this.host = host;
        this.cu = cu;
        this.classDecl$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> SootMethodExtend.classDecl_delegate$lambda$1(this));
        this.sootRange$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> SootMethodExtend.sootRange_delegate$lambda$2(this));
        this.decl$delegate = LazyKt.lazy(() -> SootMethodExtend.decl_delegate$lambda$3(this));
        this.lambdaExpr$delegate = LazyKt.lazy(() -> SootMethodExtend.lambdaExpr_delegate$lambda$12(this));
    }

    @NotNull
    public SootMethod getHost() {
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
    public final Pair<Integer, Integer> getSootRange() {
        Lazy lazy = this.sootRange$delegate;
        return (Pair)lazy.getValue();
    }

    public final <T extends NodeWithRange<N>, N> boolean nodeMatcher(@NotNull T node) {
        Intrinsics.checkNotNullParameter(node, (String)"node");
        Pair<Integer, Integer> pair = this.getSootRange();
        if (pair == null) {
            return false;
        }
        Pair<Integer, Integer> range = pair;
        Optional optional = node.getBegin();
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getBegin(...)");
        Integer n = SootHostExtendKt.getLine(optional);
        if (n == null) {
            return false;
        }
        Integer n2 = (int)n;
        Optional optional2 = node.getEnd();
        Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getEnd(...)");
        Integer n3 = SootHostExtendKt.getLine(optional2);
        if (n3 == null) {
            return false;
        }
        Pair declRange = TuplesKt.to((Object)n2, (Object)n3);
        if (((Number)declRange.getFirst()).intValue() > ((Number)declRange.getSecond()).intValue()) {
            return false;
        }
        return ((Number)declRange.getSecond()).intValue() >= ((Number)range.getFirst()).intValue() && ((Number)range.getSecond()).intValue() >= ((Number)declRange.getFirst()).intValue();
    }

    @Nullable
    public CallableDeclaration<?> getDecl() {
        Lazy lazy = this.decl$delegate;
        return (CallableDeclaration)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private final CallableDeclaration<?> getMethods(List<? extends CallableDeclaration<?>> methods) {
        CallableDeclaration callableDeclaration;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = methods;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            CallableDeclaration m = (CallableDeclaration)element$iv$iv;
            boolean bl = false;
            if (!m.getNameAsString().equals(SootHostExtendKt.getDeclaredName(this.getHost()))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        List nodes = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator(){

            public final int compare(T a, T b) {
                CallableDeclaration it = (CallableDeclaration)a;
                boolean bl = false;
                Optional optional = it.getBegin();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getBegin(...)");
                it = (CallableDeclaration)b;
                Comparable comparable = SootHostExtendKt.getLine(optional);
                bl = false;
                Optional optional2 = it.getBegin();
                Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getBegin(...)");
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)SootHostExtendKt.getLine(optional2));
            }
        });
        boolean bl = false;
        if (nodes.isEmpty()) {
            callableDeclaration = null;
        } else if (nodes.size() == 1) {
            callableDeclaration = (CallableDeclaration)CollectionsKt.first((List)nodes);
        } else if (this.getSootRange() == null) {
            callableDeclaration = (CallableDeclaration)CollectionsKt.first((List)nodes);
        } else {
            void $this$filterTo$iv$iv2;
            Iterable $this$filter$iv2 = nodes;
            boolean $i$f$filter2 = false;
            Iterable iterable2 = $this$filter$iv2;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo2 = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                CallableDeclaration it = (CallableDeclaration)element$iv$iv;
                boolean bl2 = false;
                if (!this.nodeMatcher((NodeWithRange)it)) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            List hold = (List)destination$iv$iv2;
            callableDeclaration = hold.isEmpty() ? (CallableDeclaration)CollectionsKt.first((List)nodes) : (CallableDeclaration)CollectionsKt.first((List)hold);
        }
        return callableDeclaration;
    }

    private final CallableDeclaration<?> getNormalMethods(TypeDeclaration<?> classDecl) {
        List list = classDecl.getConstructors();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getConstructors(...)");
        Collection collection = list;
        List list2 = classDecl.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getMethods(...)");
        List methods = CollectionsKt.plus((Collection)collection, (Iterable)list2);
        return this.getMethods(methods);
    }

    private final CallableDeclaration<?> getMethodsOfAnonymousClass(ObjectCreationExpr classDecl) {
        List list = classDecl.findAll(CallableDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"findAll(...)");
        List methods = CollectionsKt.filterNotNull((Iterable)list);
        return this.getMethods(methods);
    }

    /*
     * WARNING - void declaration
     */
    private final LambdaExpr getLambdaExprs(List<? extends LambdaExpr> allLambdaExpr) {
        Object v0;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = allLambdaExpr;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            LambdaExpr p0 = (LambdaExpr)element$iv$iv;
            boolean $i$f$getLambdaExprs$stub_for_inlining = false;
            boolean bl = false;
            if (!this.nodeMatcher((NodeWithRange)p0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$maxByOrNull$iv = (List)destination$iv$iv;
        boolean $i$f$maxByOrNull = false;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v0 = null;
        } else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v0 = maxElem$iv;
            } else {
                LambdaExpr it = (LambdaExpr)maxElem$iv;
                boolean bl = false;
                Optional optional = it.getRange();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getRange(...)");
                Range range = (Range)OptionalsKt.getOrNull((Optional)optional);
                int maxValue$iv = range != null && (range = range.begin) != null ? range.line : -1;
                do {
                    int v$iv;
                    Object e$iv = iterator$iv.next();
                    LambdaExpr it2 = (LambdaExpr)e$iv;
                    $i$a$-maxByOrNull-SootMethodExtend$getLambdaExprs$2 = false;
                    Optional optional2 = it2.getRange();
                    Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getRange(...)");
                    Range range2 = (Range)OptionalsKt.getOrNull((Optional)optional2);
                    int n = range2 != null && (range2 = range2.begin) != null ? range2.line : (v$iv = -1);
                    if (maxValue$iv >= v$iv) continue;
                    maxElem$iv = e$iv;
                    maxValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v0 = maxElem$iv;
            }
        }
        return v0;
    }

    @Nullable
    public final LambdaExpr getLambdaExpr() {
        Lazy lazy = this.lambdaExpr$delegate;
        return (LambdaExpr)lazy.getValue();
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        CallableDeclaration<?> callableDeclaration = this.getDecl();
        return (NodeWithRange)(callableDeclaration != null ? callableDeclaration.getName() : null);
    }

    @NotNull
    public final SootMethod component1() {
        return this.host;
    }

    @NotNull
    public final CompilationUnit component2() {
        return this.cu;
    }

    @NotNull
    public final SootMethodExtend copy(@NotNull SootMethod host, @NotNull CompilationUnit cu) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)cu, (String)"cu");
        return new SootMethodExtend(host, cu);
    }

    public static /* synthetic */ SootMethodExtend copy$default(SootMethodExtend sootMethodExtend, SootMethod sootMethod, CompilationUnit compilationUnit, int n, Object object) {
        if ((n & 1) != 0) {
            sootMethod = sootMethodExtend.host;
        }
        if ((n & 2) != 0) {
            compilationUnit = sootMethodExtend.cu;
        }
        return sootMethodExtend.copy(sootMethod, compilationUnit);
    }

    @NotNull
    public String toString() {
        return "SootMethodExtend(host=" + this.host + ", cu=" + this.cu + ")";
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
        if (!(other instanceof SootMethodExtend)) {
            return false;
        }
        SootMethodExtend sootMethodExtend = (SootMethodExtend)other;
        if (!Intrinsics.areEqual((Object)this.host, (Object)sootMethodExtend.host)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cu, (Object)sootMethodExtend.cu);
    }

    private static final Node classDecl_delegate$lambda$1(SootMethodExtend this$0) {
        CompilationUnit $this$classDecl_delegate_u24lambda_u241_u24lambda_u240 = super.getCu();
        boolean bl = false;
        SootClass sootClass = this$0.getHost().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return SootHostExtendKt.getDecl($this$classDecl_delegate_u24lambda_u241_u24lambda_u240, sootClass);
    }

    private static final Pair sootRange_delegate$lambda$2(SootMethodExtend this$0) {
        return (Pair)AnalysisCache.G.INSTANCE.get(new SootRangeKey(this$0.getHost()));
    }

    private static final CallableDeclaration decl_delegate$lambda$3(SootMethodExtend this$0) {
        Node node = this$0.getClassDecl();
        if (node == null) {
            return null;
        }
        Node classDecl = node;
        Node node2 = classDecl;
        return node2 instanceof TypeDeclaration ? this$0.getNormalMethods((TypeDeclaration)classDecl) : (node2 instanceof ObjectCreationExpr ? this$0.getMethodsOfAnonymousClass((ObjectCreationExpr)classDecl) : null);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final LambdaExpr lambdaExpr_delegate$lambda$12(SootMethodExtend this$0) {
        void $this$sortedBy$iv;
        void $this$filterTo$iv$iv;
        String string = this$0.getHost().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        if (!StringsKt.startsWith$default((String)string, (String)"lambda$", (boolean)false, (int)2, null)) {
            return null;
        }
        if (this$0.getSootRange() == null) return null;
        Node node = this$0.getClassDecl();
        if (node == null) {
            return null;
        }
        Node classDecl = node;
        List list = classDecl.findAll(LambdaExpr.class);
        if (list == null) return null;
        Iterable $this$filter$iv = list;
        boolean $i$f$filter22 = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            LambdaExpr it = (LambdaExpr)element$iv$iv;
            boolean bl = false;
            Class[] classArray = new Class[]{classDecl.getClass()};
            Optional optional = it.findAncestor(classArray);
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"findAncestor(...)");
            if (!Intrinsics.areEqual((Object)classDecl, (Object)OptionalsKt.getOrNull((Optional)optional))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $i$f$filter22 = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        List list2 = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator(){

            public final int compare(T a, T b) {
                LambdaExpr it = (LambdaExpr)a;
                boolean bl = false;
                Optional optional = it.getBegin();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getBegin(...)");
                it = (LambdaExpr)b;
                Comparable comparable = SootHostExtendKt.getLine(optional);
                bl = false;
                Optional optional2 = it.getBegin();
                Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getBegin(...)");
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)SootHostExtendKt.getLine(optional2));
            }
        });
        if (list2 == null) return null;
        List it = list2;
        boolean bl = false;
        LambdaExpr lambdaExpr = this$0.getLambdaExprs(it);
        return lambdaExpr;
    }
}

