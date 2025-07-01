package cn.sast.idfa.check;

import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.UnitGraph;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class CallBackManager {
    @NotNull
    private final Map<Class<? extends IStmtCB>, Map<SootMethod, List<Object>>> callBacksOfMethod = new LinkedHashMap<>();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Map<Unit, List<Object>>> callBacksOfUnit = new LinkedHashMap<>();
    @NotNull
    private final Map<SootMethod, UnitGraph> jimpleOverride = new LinkedHashMap<>();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Set<SootMethod>> miss = new LinkedHashMap<>();
    @NotNull
    private final Map<Class<? extends IStmtCB>, Set<Pair<SootMethod, SootMethod>>> hit = new LinkedHashMap<>();

    @NotNull
    public Map<Class<? extends IStmtCB>, Map<SootMethod, List<Object>>> getCallBacksOfMethod() {
        return callBacksOfMethod;
    }

    @NotNull
    public Map<Class<? extends IStmtCB>, Map<Unit, List<Object>>> getCallBacksOfUnit() {
        return callBacksOfUnit;
    }

    @NotNull
    public Map<Class<? extends IStmtCB>, Set<SootMethod>> getMiss() {
        return miss;
    }

    @NotNull
    public Map<Class<? extends IStmtCB>, Set<Pair<SootMethod, SootMethod>>> getHit() {
        return hit;
    }

    public <T extends IStmtCB> void put(@NotNull SootMethod key, @NotNull Function<T, Void> cb) {
        put(IStmtCB.class, key, cb);
    }

    public <T> void put(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod key, @NotNull Function<T, Void> cb) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(cb, "cb");

        callBacksOfMethod.computeIfAbsent(x, k -> new LinkedHashMap<>())
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(cb);
    }

    @Nullable
    public <T> List<Function<T, Void>> get(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod method) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(method, "method");

        String subSignature = method.getSubSignature();
        SootClass declaringClass = method.getDeclaringClass();
        SootMethod targetCB = SootUtilsKt.findMethodOrNull(declaringClass, subSignature)
                .stream()
                .findFirst()
                .orElse(null);

        if (targetCB != null && (targetCB.equals(method) || !targetCB.isConcrete())) {
            List<Function<T, Void>> result = getRaw(x, targetCB);
            if (result != null) {
                synchronized (hit) {
                    hit.computeIfAbsent(x, k -> new LinkedHashSet<>())
                            .add(new Pair<>(method, targetCB));
                }
                return result;
            }
        }

        synchronized (miss) {
            miss.computeIfAbsent(x, k -> new LinkedHashSet<>())
                    .add(method);
        }
        return null;
    }

    @Nullable
    public <T> List<Function<T, Void>> getRaw(@NotNull Class<? extends IStmtCB> x, @NotNull SootMethod key) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(key, "key");
        Map<SootMethod, List<Object>> map = callBacksOfMethod.get(x);
        return map != null ? (List<Function<T, Void>>) map.get(key) : null;
    }

    public <T extends IStmtCB> void put(@NotNull Unit key, @NotNull Function<T, Void> cb) {
        put(IStmtCB.class, key, cb);
    }

    public <T> void put(@NotNull Class<? extends IStmtCB> x, @NotNull Unit key, @NotNull Function<T, Void> cb) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(cb, "cb");

        callBacksOfUnit.computeIfAbsent(x, k -> new LinkedHashMap<>())
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(cb);
    }

    @Nullable
    public <T> List<Function<T, Void>> get(@NotNull Class<? extends IStmtCB> x, @NotNull Unit key) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(key, "key");
        Map<Unit, List<Object>> map = callBacksOfUnit.get(x);
        return map != null ? (List<Function<T, Void>>) map.get(key) : null;
    }

    @Nullable
    public <T extends IStmtCB> List<Function<T, Void>> get(@NotNull Object key) {
        Objects.requireNonNull(key, "key");
        if (key instanceof Unit) {
            return get(IStmtCB.class, (Unit) key);
        } else if (key instanceof SootMethod) {
            return get(IStmtCB.class, (SootMethod) key);
        } else {
            throw new UnsupportedOperationException(key.getClass() + ": " + key);
        }
    }

    @Nullable
    public <T extends IStmtCB> List<Function<T, Void>> get(@NotNull Object... keys) {
        Objects.requireNonNull(keys, "keys");
        for (Object key : keys) {
            List<Function<T, Void>> result = get(key);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    @Nullable
    public UnitGraph putUnitGraphOverride(@NotNull SootMethod key, @NotNull UnitGraph override) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(override, "override");
        return jimpleOverride.put(key, override);
    }

    @Nullable
    public UnitGraph getUnitGraphOverride(@NotNull SootMethod key) {
        Objects.requireNonNull(key, "key");
        return jimpleOverride.get(key);
    }

    public void reportMissSummaryMethod(@NotNull Function<SootMethod, Void> reportMissingMethod) {
        Set<SootMethod> hitMethods = new LinkedHashSet<>();
        hit.values().stream()
                .flatMap(Collection::stream)
                .forEach(pair -> hitMethods.add(pair.getFirst()));

        Set<SootMethod> missMethods = new LinkedHashSet<>();
        miss.values().stream()
                .flatMap(Collection::stream)
                .forEach(missMethods::add);

        Sets.difference(missMethods, hitMethods).forEach(reportMissingMethod::apply);
    }

    private static class Pair<A, B> {
        final A first;
        final B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() { return first; }
        public B getSecond() { return second; }
    }
}
