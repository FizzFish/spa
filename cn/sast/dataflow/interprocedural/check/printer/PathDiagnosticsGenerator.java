import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.dataflow.interprocedural.check.ExitInvoke;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import cn.sast.dataflow.interprocedural.check.ModelBind;
import cn.sast.dataflow.interprocedural.check.printer.EventPrinter;
import cn.sast.idfa.analysis.InterproceduralCFG;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;

import java.util.*;
import java.util.stream.Collectors;

public final class PathDiagnosticsGenerator {
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final InterproceduralCFG icfg;
    private final int deep;
    @NotNull
    private final Deque<BugPathEvent> result;
    @NotNull
    private final String prefix;
    @NotNull
    private final String calleePrefix;

    public PathDiagnosticsGenerator(@Nullable SootInfoCache info, @NotNull InterproceduralCFG icfg, int deep) {
        Objects.requireNonNull(icfg, "icfg cannot be null");
        this.info = info;
        this.icfg = icfg;
        this.deep = deep;
        this.result = new ArrayDeque<>();
        this.prefix = "[" + this.deep + "]";
        this.calleePrefix = "[" + (this.deep + 1) + "]";
    }

    @Nullable
    public SootInfoCache getInfo() {
        return info;
    }

    @NotNull
    public InterproceduralCFG getIcfg() {
        return icfg;
    }

    public int getDeep() {
        return deep;
    }

    @NotNull
    public List<BugPathEvent> emit(@NotNull IPath node, @NotNull EventPrinter message) {
        Objects.requireNonNull(node, "node cannot be null");
        Objects.requireNonNull(message, "message cannot be null");
        return emit(node.getNode(), message.getMessage(), message.getRegion());
    }

    @NotNull
    public List<BugPathEvent> emit(@NotNull Unit node, @Nullable Map<Language, String> message, @Nullable Region region) {
        Objects.requireNonNull(node, "node cannot be null");
        if (message == null) {
            return Collections.emptyList();
        }

        SootMethod method = icfg.getMethodOf(node);
        SootClass clazz = method.getDeclaringClass();
        InvokeExpr invokeExpr = getInvokeExpr(node);
        SootMethodRef methodRef = invokeExpr != null ? invokeExpr.getMethodRef() : null;

        if (shouldSkipMethod(methodRef, clazz)) {
            return Collections.emptyList();
        }

        IBugResInfo bugResInfo = ClassResInfo.of(clazz);
        Region effectiveRegion = resolveRegion(node, region);
        return Collections.singletonList(new BugPathEvent(message, bugResInfo, effectiveRegion, deep));
    }

    @NotNull
    public List<BugPathEvent> emit(@NotNull SootMethod method, @Nullable EventPrinter message) {
        Objects.requireNonNull(method, "method cannot be null");
        if (message == null) {
            return Collections.emptyList();
        }
        return emit(method, message.getMessage(), message.getRegion());
    }

    @NotNull
    public List<BugPathEvent> emit(@NotNull SootMethod method, @Nullable Map<Language, String> message, @Nullable Region region) {
        Objects.requireNonNull(method, "method cannot be null");
        if (message == null) {
            return Collections.emptyList();
        }

        SootClass clazz = method.getDeclaringClass();
        if (shouldSkipMethod(method, clazz)) {
            return Collections.emptyList();
        }

        IBugResInfo bugResInfo = ClassResInfo.of(clazz);
        Region effectiveRegion = resolveRegion(method, region);
        return Collections.singletonList(new BugPathEvent(message, bugResInfo, effectiveRegion, deep));
    }

    @NotNull
    public Unit inlineAssignment(@NotNull List<? extends IndexedValue<? extends IPath>> pathEvents, int index, 
            @NotNull Set<Integer> inlined, @NotNull Class<? extends IPath> type) {
        Objects.requireNonNull(pathEvents, "pathEvents cannot be null");
        Objects.requireNonNull(inlined, "inlined cannot be null");
        Objects.requireNonNull(type, "type cannot be null");

        IPath pathEvent = pathEvents.get(index).getValue();
        return new InlineAssignmentHelper().inline(pathEvent.getNode());
    }

    public void inlineBugPathEvents(@NotNull List<BugPathEvent> pathEvents) {
        Objects.requireNonNull(pathEvents, "pathEvents cannot be null");
        result.addAll(pathEvents);
    }

    public void inlinePathEvents(@NotNull List<? extends IndexedValue<? extends IPath>> pathEvents) {
        Objects.requireNonNull(pathEvents, "pathEvents cannot be null");
        Set<Integer> inlined = new LinkedHashSet<>();
        int insertIndex = result.size();
        
        for (int i = pathEvents.size() - 1; i >= 0; i--) {
            if (!inlined.contains(i)) {
                result.addAll(insertIndex, inlinePathEvents(pathEvents, i, inlined));
            }
        }
    }

    @NotNull
    public List<BugPathEvent> inlineEvents(@NotNull List<?> pathEvents) {
        Objects.requireNonNull(pathEvents, "pathEvents cannot be null");
        List<BugPathEvent> curEvents = new ArrayList<>();
        List<IndexedValue<IPath>> curPathEvents = new ArrayList<>();

        for (Object event : pathEvents) {
            if (event instanceof BugPathEvent) {
                if (!curPathEvents.isEmpty()) {
                    inlinePathEvents(curPathEvents);
                    curPathEvents.clear();
                }
                curEvents.add((BugPathEvent) event);
            } else if (event instanceof IPath) {
                if (!curEvents.isEmpty()) {
                    inlineBugPathEvents(curEvents);
                    curEvents.clear();
                }
                curPathEvents.add(new IndexedValue<>(curPathEvents.size(), (IPath) event));
            } else if (event instanceof ExitInvoke) {
                if (!curPathEvents.isEmpty()) {
                    inlinePathEvents(curPathEvents);
                    curPathEvents.clear();
                }
                if (!curEvents.isEmpty()) {
                    inlineBugPathEvents(curEvents);
                    curEvents.clear();
                }
                EventPrinter printer = new EventPrinter(prefix);
                result.addAll(emit(((ExitInvoke) event).getInvoke(), printer.normalPrint((ExitInvoke) event)));
            } else {
                throw new IllegalStateException("Internal error");
            }
        }

        if (!curEvents.isEmpty()) {
            inlineBugPathEvents(curEvents);
        }
        if (!curPathEvents.isEmpty()) {
            inlinePathEvents(curPathEvents);
        }

        return new ArrayList<>(result);
    }

    private List<BugPathEvent> inlinePathEvents(List<? extends IndexedValue<? extends IPath>> pathEvents, 
            int index, Set<Integer> inlined) {
        IndexedValue<? extends IPath> pathEventI = pathEvents.get(index);
        IPath pathEvent = pathEventI.getValue();
        Unit lineUnit = inlineAssignment(pathEvents, index, inlined, pathEvent.getClass());
        SootMethod sootMethod = icfg.getMethodOf(pathEvent.getNode());

        List<BugPathEvent> events;
        if (pathEvent instanceof ModelBind) {
            events = emit(pathEvent, new EventPrinter(prefix).printModeling((ModelBind) pathEvent, lineUnit, sootMethod));
        } else {
            events = emit(pathEvent, new EventPrinter(prefix).normalPrint(pathEventI, lineUnit, sootMethod));
            if (pathEvent instanceof InvokeEdgePath) {
                events.addAll(emit(((InvokeEdgePath) pathEvent).getCallee(), 
                    new EventPrinter(calleePrefix).calleeBeginPrint((InvokeEdgePath) pathEvent)));
            }
        }
        return events;
    }

    private boolean shouldSkipMethod(SootMethodRef methodRef, SootClass clazz) {
        if (methodRef != null && (!(methodRef instanceof SootMethod) || ((SootMethod) methodRef).isDeclared())) {
            if ("java.lang.String".equals(methodRef.getDeclaringClass().getName())) {
                String methodName = methodRef.getName();
                if (methodName != null && methodName.toLowerCase().contains("equals")) {
                    return true;
                }
            }
        }
        return clazz.isJavaLibraryClass();
    }

    private Region resolveRegion(Unit node, Region region) {
        if (region != null) return region;
        
        if (info != null) {
            region = Region.of(info, node);
        }
        if (region == null) {
            region = Region.of(node);
        }
        return region != null ? region : Region.ERROR();
    }

    private Region resolveRegion(SootMethod method, Region region) {
        if (region != null) return region;
        
        if (info != null) {
            region = Region.of(info, method);
        }
        if (region == null) {
            region = new Region(method.getJavaSourceStartLineNumber(), 
                              method.getJavaSourceStartColumnNumber(), -1, -1);
            if (region.startLine < 0) {
                region = Region.ERROR();
            }
        }
        return region;
    }

    private InvokeExpr getInvokeExpr(Unit node) {
        if (node instanceof Stmt) {
            Stmt stmt = (Stmt) node;
            return stmt.containsInvokeExpr() ? stmt.getInvokeExpr() : null;
        }
        return null;
    }

    private static class IndexedValue<T> {
        private final int index;
        private final T value;

        public IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public T getValue() {
            return value;
        }
    }

    private class InlineAssignmentHelper {
        public Unit inline(Unit node) {
            // Implementation of inline logic
            return node;
        }
    }
}