/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.report.Counter
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.graph.CGUtils
 *  com.github.ajalt.mordant.rendering.Theme
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.MethodOrMethodContext
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.VoidType
 *  soot.jimple.DynamicInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.Stmt
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.jimple.toolkits.callgraph.ReachableMethods
 *  soot.util.Chain
 *  soot.util.queue.QueueReader
 */
package cn.sast.framework.graph;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.Counter;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import com.github.ajalt.mordant.rendering.Theme;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.VoidType;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.Chain;
import soot.util.queue.QueueReader;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\f\u001a\u00020\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ>\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020 J\"\u0010,\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010-\u001a\u00020 2\b\b\u0002\u0010.\u001a\u00020 R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2={"Lcn/sast/framework/graph/CGUtils;", "", "<init>", "()V", "missClasses", "Lcn/sast/api/report/Counter;", "Lsoot/SootClass;", "getMissClasses", "()Lcn/sast/api/report/Counter;", "rewriteJimpleBodyAfterCG", "", "makeSpuriousMethodFromInvokeExpr", "forceAddCgEdge", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "src", "Lsoot/SootMethod;", "srcUnit", "Lsoot/jimple/Stmt;", "ie", "Lsoot/jimple/InvokeExpr;", "addCallEdgeForPhantomMethods", "flushMissedClasses", "outputDir", "Lcn/sast/common/IResDirectory;", "removeInvalidMethodBody", "scene", "Lsoot/Scene;", "fixInvalidInterface", "removeLargeClasses", "fixScene", "createSootMethod", "name", "", "argsTypes", "", "Lsoot/Type;", "returnType", "declaringClass", "graphBody", "Lsoot/jimple/JimpleBody;", "isStatic", "", "getOrCreateClass", "className", "createDummyMain", "dummyClassName", "methodName", "logger", "Lmu/KLogger;", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nCGUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CGUtils.kt\ncn/sast/framework/graph/CGUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n1#2:224\n*E\n"})
public final class CGUtils {
    @NotNull
    public static final CGUtils INSTANCE = new CGUtils();
    @NotNull
    private static final Counter<SootClass> missClasses = new Counter();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CGUtils::logger$lambda$8);

    private CGUtils() {
    }

    @NotNull
    public final Counter<SootClass> getMissClasses() {
        return missClasses;
    }

    public final void rewriteJimpleBodyAfterCG() {
        Iterator all = Scene.v().getClasses().snapshotIterator();
        BuildersKt.runBlocking((CoroutineContext)((CoroutineContext)Dispatchers.getDefault()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public final void makeSpuriousMethodFromInvokeExpr() {
        Chain chain = Scene.v().getApplicationClasses();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getApplicationClasses(...)");
        List app = CollectionsKt.toList((Iterable)((Iterable)chain));
        for (SootClass appSc : app) {
            if (appSc.isPhantom()) continue;
            List list = appSc.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            List methods = CollectionsKt.toList((Iterable)list);
            for (SootMethod sm : methods) {
                if (!sm.isConcrete() || sm.getSource() == null) continue;
                try {
                    Iterator iterator2;
                    UnitPatchingChain units;
                    Body body;
                    if (sm.retrieveActiveBody() == null) continue;
                    Intrinsics.checkNotNullExpressionValue((Object)body.getUnits(), (String)"getUnits(...)");
                    Intrinsics.checkNotNullExpressionValue((Object)units.iterator(), (String)"iterator(...)");
                    while (iterator2.hasNext()) {
                        Stmt srcUnit;
                        Unit u = (Unit)iterator2.next();
                        Stmt stmt = u instanceof Stmt ? (Stmt)u : null;
                        if (stmt == null) continue;
                        if (srcUnit.containsInvokeExpr()) {
                            stmt = srcUnit.getInvokeExpr().getMethod();
                        }
                        if (!srcUnit.containsFieldRef()) continue;
                        stmt = srcUnit.getFieldRef().getField();
                    }
                }
                catch (RuntimeException runtimeException) {
                }
            }
        }
    }

    private final void forceAddCgEdge(CallGraph $this$forceAddCgEdge, SootMethod src, Stmt srcUnit, InvokeExpr ie) {
        SootMethod tgt = ie.getMethod();
        if (srcUnit.getInvokeExpr() instanceof DynamicInvokeExpr) {
            return;
        }
        Edge edge = new Edge((MethodOrMethodContext)src, srcUnit, (MethodOrMethodContext)tgt);
        $this$forceAddCgEdge.addEdge(edge);
    }

    public final void addCallEdgeForPhantomMethods() {
        Scene scene = Scene.v();
        CallGraph cg = scene.getCallGraph();
        ReachableMethods reachableMethods = scene.getReachableMethods();
        reachableMethods.update();
        QueueReader queueReader = reachableMethods.listener();
        Intrinsics.checkNotNullExpressionValue((Object)queueReader, (String)"listener(...)");
        Iterator listener = (Iterator)queueReader;
        while (listener.hasNext()) {
            Iterator iterator2;
            UnitPatchingChain units;
            SootMethod src = ((MethodOrMethodContext)listener.next()).method();
            if (!src.hasActiveBody()) continue;
            Intrinsics.checkNotNullExpressionValue((Object)src.getActiveBody().getUnits(), (String)"getUnits(...)");
            Intrinsics.checkNotNullExpressionValue((Object)units.iterator(), (String)"iterator(...)");
            while (iterator2.hasNext()) {
                Unit u = (Unit)iterator2.next();
                Intrinsics.checkNotNull((Object)u, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                Stmt srcUnit = (Stmt)u;
                if (!srcUnit.containsInvokeExpr()) continue;
                InvokeExpr ie = srcUnit.getInvokeExpr();
                Iterator edges = cg.edgesOutOf(u);
                if (edges.hasNext()) continue;
                if (ie.getMethodRef().getDeclaringClass() != null) {
                    SootClass tgtClass;
                    boolean bl = false;
                    if (tgtClass.isPhantom() && !Scene.v().isExcluded(tgtClass)) {
                        String string = tgtClass.getName();
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
                        if (!StringsKt.startsWith$default((String)string, (String)"soot.dummy", (boolean)false, (int)2, null)) {
                            missClasses.count((Object)tgtClass);
                        }
                    }
                }
                Intrinsics.checkNotNull((Object)cg);
                Intrinsics.checkNotNull((Object)src);
                Intrinsics.checkNotNull((Object)ie);
                this.forceAddCgEdge(cg, src, srcUnit, ie);
            }
        }
    }

    public final void flushMissedClasses(@NotNull IResDirectory outputDir) {
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        IResFile out = outputDir.resolve("phantom_dependence_classes.txt").toFile();
        if (missClasses.isNotEmpty()) {
            logger.warn(() -> CGUtils.flushMissedClasses$lambda$1(out));
            missClasses.writeResults(out);
        } else {
            Files.deleteIfExists(out.getPath());
        }
    }

    public final void removeInvalidMethodBody(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Iterator iterator2 = scene.getClasses().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            SootClass sc = (SootClass)iterator3.next();
            for (SootMethod sm : sc.getMethods()) {
                Body body;
                if (!sm.hasActiveBody() || !(body = sm.getActiveBody()).getUnits().isEmpty()) continue;
                sm.setActiveBody(null);
                sm.setPhantom(true);
            }
        }
    }

    public final void fixInvalidInterface(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Iterator iterator2 = scene.getClasses().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Iterator iterator4;
            SootClass sc = (SootClass)iterator3.next();
            Intrinsics.checkNotNullExpressionValue((Object)sc.getInterfaces().snapshotIterator(), (String)"snapshotIterator(...)");
            while (iterator4.hasNext()) {
                SootClass i = (SootClass)iterator4.next();
                if (i.isInterface()) continue;
                logger.warn(() -> CGUtils.fixInvalidInterface$lambda$2(i, sc));
                try {
                    sc.removeInterface(i);
                }
                catch (Exception e) {
                    logger.warn((Throwable)e, () -> CGUtils.fixInvalidInterface$lambda$3(i, sc));
                }
            }
        }
    }

    public final void removeLargeClasses(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        int skipClassByMaximumMethods = ExtSettings.INSTANCE.getSkip_large_class_by_maximum_methods();
        int skipClassByMaximumFields = ExtSettings.INSTANCE.getSkip_large_class_by_maximum_fields();
        if (skipClassByMaximumMethods > 0 || skipClassByMaximumFields > 0) {
            Iterator iterator2 = scene.getClasses().snapshotIterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"snapshotIterator(...)");
            Iterator iterator3 = iterator2;
            while (iterator3.hasNext()) {
                SootClass sc = (SootClass)iterator3.next();
                boolean removeIt = false;
                if (skipClassByMaximumMethods > 0 && sc.getMethodCount() > skipClassByMaximumMethods) {
                    removeIt = true;
                    logger.warn(() -> CGUtils.removeLargeClasses$lambda$4(sc, skipClassByMaximumMethods));
                }
                if (skipClassByMaximumFields > 0 && sc.getFieldCount() > skipClassByMaximumFields) {
                    removeIt = true;
                    logger.warn(() -> CGUtils.removeLargeClasses$lambda$5(sc, skipClassByMaximumFields));
                }
                if (!removeIt) continue;
                scene.removeClass(sc);
            }
        }
    }

    public final void fixScene(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        this.removeInvalidMethodBody(scene);
        this.fixInvalidInterface(scene);
    }

    @NotNull
    public final SootMethod createSootMethod(@NotNull String name, @NotNull List<? extends Type> argsTypes, @NotNull Type returnType, @NotNull SootClass declaringClass, @NotNull JimpleBody graphBody, boolean isStatic) {
        SootMethod sootMethod;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(argsTypes, (String)"argsTypes");
        Intrinsics.checkNotNullParameter((Object)returnType, (String)"returnType");
        Intrinsics.checkNotNullParameter((Object)declaringClass, (String)"declaringClass");
        Intrinsics.checkNotNullParameter((Object)graphBody, (String)"graphBody");
        SootMethod it = sootMethod = new SootMethod(name, argsTypes, returnType, isStatic ? 8 : 0);
        boolean bl = false;
        declaringClass.addMethod(it);
        it.setActiveBody((Body)graphBody);
        return sootMethod;
    }

    public static /* synthetic */ SootMethod createSootMethod$default(CGUtils cGUtils, String string, List list, Type type, SootClass sootClass, JimpleBody jimpleBody, boolean bl, int n, Object object) {
        if ((n & 0x20) != 0) {
            bl = true;
        }
        return cGUtils.createSootMethod(string, list, type, sootClass, jimpleBody, bl);
    }

    @NotNull
    public final SootClass getOrCreateClass(@NotNull Scene scene, @NotNull String className) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        SootClass mainClass = scene.getSootClassUnsafe(className, false);
        if (mainClass == null) {
            SootClass sootClass = scene.makeSootClass(className);
            Intrinsics.checkNotNull((Object)sootClass);
            mainClass = sootClass;
            mainClass.setResolvingLevel(3);
            scene.addClass(mainClass);
        }
        return mainClass;
    }

    @NotNull
    public final SootClass createDummyMain(@NotNull Scene scene, @NotNull String dummyClassName, @NotNull String methodName) {
        JimpleBody jimpleBody;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Intrinsics.checkNotNullParameter((Object)dummyClassName, (String)"dummyClassName");
        Intrinsics.checkNotNullParameter((Object)methodName, (String)"methodName");
        Jimple jimple = Jimple.v();
        SootClass dummyClass = this.getOrCreateClass(scene, dummyClassName);
        dummyClass.setApplicationClass();
        JimpleBody $this$createDummyMain_u24lambda_u247 = jimpleBody = jimple.newBody();
        boolean bl = false;
        $this$createDummyMain_u24lambda_u247.getUnits().add((Unit)jimple.newNopStmt());
        JimpleBody body = jimpleBody;
        List list = CollectionsKt.emptyList();
        VoidType voidType = VoidType.v();
        Intrinsics.checkNotNullExpressionValue((Object)voidType, (String)"v(...)");
        Type type = (Type)voidType;
        Intrinsics.checkNotNull((Object)body);
        CGUtils.createSootMethod$default((CGUtils)this, (String)methodName, (List)list, (Type)type, (SootClass)dummyClass, (JimpleBody)body, (boolean)false, (int)32, null);
        return dummyClass;
    }

    public static /* synthetic */ SootClass createDummyMain$default(CGUtils cGUtils, Scene scene, String string, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string = "dummyMainClass";
        }
        if ((n & 4) != 0) {
            string2 = "fakeMethod";
        }
        return cGUtils.createDummyMain(scene, string, string2);
    }

    private static final Object flushMissedClasses$lambda$1(IResFile $out) {
        return Theme.Companion.getDefault().getWarning().invoke("Incomplete analysis! The num of " + missClasses.size() + " dependent classes cannot be found here. check: " + $out.getAbsolute().getNormalize());
    }

    private static final Object fixInvalidInterface$lambda$2(SootClass $i, SootClass $sc) {
        return $i + " is not a interface. but contains in interfaces of " + $sc;
    }

    private static final Object fixInvalidInterface$lambda$3(SootClass $i, SootClass $sc) {
        return "remove interface " + $i + " from " + $sc + " failed";
    }

    private static final Object removeLargeClasses$lambda$4(SootClass $sc, int $skipClassByMaximumMethods) {
        return "Remove large class: " + $sc + " which is too large. Limit the class methods count should less than " + $skipClassByMaximumMethods;
    }

    private static final Object removeLargeClasses$lambda$5(SootClass $sc, int $skipClassByMaximumFields) {
        return "Remove big class: " + $sc + " which is too large. Limit the class fields count should less than " + $skipClassByMaximumFields;
    }

    private static final kotlin.Unit logger$lambda$8() {
        return kotlin.Unit.INSTANCE;
    }
}

