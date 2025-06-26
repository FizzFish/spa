/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.idfa.check.CallBackManager
 *  cn.sast.idfa.check.IStmtCB
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 *  soot.toolkits.graph.UnitGraph
 */
package cn.sast.idfa.check;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.idfa.check.IStmtCB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.UnitGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0017\u001a\u00020\u0018\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\b2)\b\b\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001eH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJR\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00192\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\b2'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u00a2\u0006\u0002\u0010!JO\u0010\"\u001a+\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u0018\u00010#\"\u0004\b\u0000\u0010\u00192\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010$\u001a\u00020\bH\u0016JO\u0010%\u001a+\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u0018\u00010#\"\u0004\b\u0000\u0010\u00192\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0016J;\u0010\u0017\u001a\u00020\u0018\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r2\u0019\b\b\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00180&\u00a2\u0006\u0002\b\u001eH\u0086\b\u00f8\u0001\u0000J=\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00192\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\r2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00180&\u00a2\u0006\u0002\b\u001eJO\u0010\"\u001a+\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u0018\u00010#\"\u0004\b\u0000\u0010\u00192\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\rH\u0016JF\u0010\"\u001a+\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u0018\u00010#\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0001H\u0086\bJW\u0010\"\u001a+\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c\u00a2\u0006\u0002\b\u001e\u0018\u00010#\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00072\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010(\"\u00020\u0001H\u0086\b\u00a2\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0010J\u0010\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\bJ)\u0010-\u001a\u00020\u00182!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180&R7\u0010\u0004\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR7\u0010\f\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR7\u0010\u0014\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00150\u00120\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00061"}, d2={"Lcn/sast/idfa/check/CallBackManager;", "", "<init>", "()V", "callBacksOfMethod", "", "Ljava/lang/Class;", "Lcn/sast/idfa/check/IStmtCB;", "Lsoot/SootMethod;", "", "getCallBacksOfMethod", "()Ljava/util/Map;", "callBacksOfUnit", "Lsoot/Unit;", "getCallBacksOfUnit", "jimpleOverride", "Lsoot/toolkits/graph/UnitGraph;", "miss", "", "getMiss", "hit", "Lkotlin/Pair;", "getHit", "put", "", "typeCB", "key", "cb", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lsoot/SootMethod;Lkotlin/jvm/functions/Function2;)V", "x", "(Ljava/lang/Class;Lsoot/SootMethod;Lkotlin/jvm/functions/Function2;)V", "get", "", "method", "getRaw", "Lkotlin/Function1;", "keys", "", "([Ljava/lang/Object;)Ljava/util/List;", "putUnitGraphOverride", "override", "getUnitGraphOverride", "reportMissSummaryMethod", "reportMissingMethod", "Lkotlin/ParameterName;", "name", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nCheckerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerManager.kt\ncn/sast/idfa/check/CallBackManager\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n137#1,5:215\n381#2,7:171\n381#2,7:178\n381#2,7:187\n381#2,7:194\n381#2,7:201\n381#2,7:208\n183#3,2:185\n1628#4,3:220\n*S KotlinDebug\n*F\n+ 1 CheckerManager.kt\ncn/sast/idfa/check/CallBackManager\n*L\n147#1:215,5\n88#1:171,7\n89#1:178,7\n105#1:187,7\n111#1:194,7\n127#1:201,7\n128#1:208,7\n97#1:185,2\n163#1:220,3\n*E\n"})
public class CallBackManager {
    @NotNull
    private final Map<Class<? extends IStmtCB>, Map<SootMethod, List<Object>>> callBacksOfMethod = new LinkedHashMap();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Map<Unit, List<Object>>> callBacksOfUnit = new LinkedHashMap();
    @NotNull
    private final Map<SootMethod, UnitGraph> jimpleOverride = new LinkedHashMap();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Set<SootMethod>> miss = new LinkedHashMap();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Set<Pair<SootMethod, SootMethod>>> hit = new LinkedHashMap();

    @NotNull
    public final Map<Class<? extends IStmtCB>, Map<SootMethod, List<Object>>> getCallBacksOfMethod() {
        return this.callBacksOfMethod;
    }

    @NotNull
    public final Map<Class<? extends IStmtCB>, Map<Unit, List<Object>>> getCallBacksOfUnit() {
        return this.callBacksOfUnit;
    }

    @NotNull
    public final Map<Class<? extends IStmtCB>, Set<SootMethod>> getMiss() {
        return this.miss;
    }

    @NotNull
    public final Map<Class<? extends IStmtCB>, Set<Pair<SootMethod, SootMethod>>> getHit() {
        return this.hit;
    }

    public final /* synthetic */ <typeCB extends IStmtCB> void put(SootMethod key2, Function2<? super typeCB, ? super Continuation<? super kotlin.Unit>, ? extends Object> cb) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        boolean $i$f$put = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"typeCB");
        Class<IStmtCB> x = IStmtCB.class;
        this.put(x, key2, cb);
    }

    public final <typeCB> void put(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod key2, @NotNull Function2<? super typeCB, ? super Continuation<? super kotlin.Unit>, ? extends Object> cb) {
        Object object;
        Map map;
        Object object2;
        Intrinsics.checkNotNullParameter(x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        Map $this$getOrPut$iv = this.callBacksOfMethod;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(x);
        if (value$iv == null) {
            boolean bl = false;
            Map answer$iv = new LinkedHashMap();
            $this$getOrPut$iv.put(x, answer$iv);
            object2 = answer$iv;
        } else {
            object2 = value$iv;
        }
        $this$getOrPut$iv = map = (Map)object2;
        $i$f$getOrPut = false;
        value$iv = $this$getOrPut$iv.get(key2);
        if (value$iv == null) {
            boolean bl = false;
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(key2, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        ((List)object).add(cb);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public <typeCB> List<Function2<typeCB, Continuation<? super kotlin.Unit>, Object>> get(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod method) {
        List r;
        Object v1;
        block12: {
            Intrinsics.checkNotNullParameter(x, (String)"x");
            Intrinsics.checkNotNullParameter((Object)method, (String)"method");
            String subSignature = method.getSubSignature();
            SootClass sootClass = method.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            SootClass sootClass2 = sootClass;
            Intrinsics.checkNotNull((Object)subSignature);
            Sequence $this$firstOrNull$iv = SootUtilsKt.findMethodOrNull((SootClass)sootClass2, (String)subSignature);
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                SootMethod sm = (SootMethod)element$iv;
                boolean bl = false;
                List r2 = this.getRaw(x, sm);
                if (!(r2 != null)) continue;
                v1 = element$iv;
                break block12;
            }
            v1 = null;
        }
        SootMethod targetCB = v1;
        if (targetCB != null && (Intrinsics.areEqual((Object)targetCB, (Object)method) || !targetCB.isConcrete()) && (r = this.getRaw(x, targetCB)) != null) {
            Map map = this.hit;
            synchronized (map) {
                Object object;
                boolean bl = false;
                Map $this$getOrPut$iv = this.hit;
                boolean $i$f$getOrPut = false;
                Object value$iv = $this$getOrPut$iv.get(x);
                if (value$iv == null) {
                    boolean bl2 = false;
                    Set answer$iv = new LinkedHashSet();
                    $this$getOrPut$iv.put(x, answer$iv);
                    object = answer$iv;
                } else {
                    object = value$iv;
                }
                bl = ((Set)object).add(TuplesKt.to((Object)method, (Object)targetCB));
            }
            return r;
        }
        Map map = this.miss;
        synchronized (map) {
            Object object;
            boolean bl = false;
            Map $this$getOrPut$iv = this.miss;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(x);
            if (value$iv == null) {
                boolean bl3 = false;
                Set answer$iv = new LinkedHashSet();
                $this$getOrPut$iv.put(x, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            boolean bl4 = ((Set)object).add(method);
        }
        return null;
    }

    @Nullable
    public <typeCB> List<Function2<typeCB, Continuation<? super kotlin.Unit>, Object>> getRaw(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod key2) {
        Intrinsics.checkNotNullParameter(x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Map map = (Map)this.callBacksOfMethod.get(x);
        return map != null ? (List)map.get(key2) : null;
    }

    public final /* synthetic */ <typeCB extends IStmtCB> void put(Unit key2, Function1<? super typeCB, kotlin.Unit> cb) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        boolean $i$f$put = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"typeCB");
        Class<IStmtCB> x = IStmtCB.class;
        this.put(x, key2, cb);
    }

    public final <typeCB> void put(@NotNull Class<? extends IStmtCB> x, @NotNull Unit key2, @NotNull Function1<? super typeCB, kotlin.Unit> cb) {
        Object object;
        Map map;
        Object object2;
        Intrinsics.checkNotNullParameter(x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        Map $this$getOrPut$iv = this.callBacksOfUnit;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(x);
        if (value$iv == null) {
            boolean bl = false;
            Map answer$iv = new LinkedHashMap();
            $this$getOrPut$iv.put(x, answer$iv);
            object2 = answer$iv;
        } else {
            object2 = value$iv;
        }
        $this$getOrPut$iv = map = (Map)object2;
        $i$f$getOrPut = false;
        value$iv = $this$getOrPut$iv.get(key2);
        if (value$iv == null) {
            boolean bl = false;
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(key2, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        ((List)object).add(cb);
    }

    @Nullable
    public <typeCB> List<Function2<typeCB, Continuation<? super kotlin.Unit>, Object>> get(@NotNull Class<? extends IStmtCB> x, @NotNull Unit key2) {
        Intrinsics.checkNotNullParameter(x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Map map = (Map)this.callBacksOfUnit.get(x);
        return map != null ? (List)map.get(key2) : null;
    }

    public final /* synthetic */ <typeCB extends IStmtCB> List<Function2<typeCB, Continuation<? super kotlin.Unit>, Object>> get(Object key2) {
        List list;
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        boolean $i$f$get = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"typeCB");
        Class<IStmtCB> x = IStmtCB.class;
        Object object = key2;
        if (object instanceof Unit) {
            list = this.get(x, (Unit)key2);
        } else if (object instanceof SootMethod) {
            list = this.get(x, (SootMethod)key2);
        } else {
            String string = key2.getClass() + ": " + key2;
            throw new NotImplementedError("An operation is not implemented: " + string);
        }
        return list;
    }

    public final /* synthetic */ <typeCB extends IStmtCB> List<Function2<typeCB, Continuation<? super kotlin.Unit>, Object>> get(Object ... keys) {
        Intrinsics.checkNotNullParameter((Object)keys, (String)"keys");
        boolean $i$f$get = false;
        for (Object key2 : keys) {
            List r;
            List list;
            CallBackManager this_$iv = this;
            boolean $i$f$get2 = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"typeCB");
            Class<IStmtCB> x$iv = IStmtCB.class;
            Object object = key2;
            if (object instanceof Unit) {
                list = this_$iv.get(x$iv, (Unit)key2);
            } else if (object instanceof SootMethod) {
                list = this_$iv.get(x$iv, (SootMethod)key2);
            } else {
                String string = key2.getClass() + ": " + key2;
                throw new NotImplementedError("An operation is not implemented: " + string);
            }
            List list2 = r = list;
            if (list2 == null) continue;
            return list2;
        }
        return null;
    }

    @Nullable
    public final UnitGraph putUnitGraphOverride(@NotNull SootMethod key2, @NotNull UnitGraph override) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)override, (String)"override");
        return this.jimpleOverride.put(key2, override);
    }

    @Nullable
    public final UnitGraph getUnitGraphOverride(@NotNull SootMethod key2) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        return (UnitGraph)this.jimpleOverride.get(key2);
    }

    /*
     * WARNING - void declaration
     */
    public final void reportMissSummaryMethod(@NotNull Function1<? super SootMethod, kotlin.Unit> reportMissingMethod) {
        void destination$iv;
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(reportMissingMethod, (String)"reportMissingMethod");
        Iterable iterable = CollectionsKt.flatten((Iterable)this.hit.values());
        Collection collection = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            Pair pair = (Pair)item$iv;
            void var10_10 = destination$iv;
            boolean bl = false;
            var10_10.add((SootMethod)it.getFirst());
        }
        Set hit = (Set)destination$iv;
        Set miss = CollectionsKt.toSet((Iterable)CollectionsKt.flatten((Iterable)this.miss.values()));
        for (SootMethod m : SetsKt.minus((Set)miss, (Iterable)hit)) {
            reportMissingMethod.invoke((Object)m);
        }
    }
}

