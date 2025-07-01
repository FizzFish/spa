package cn.sast.framework.incremental;

import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.graph.HashMutableDirectedGraph;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.rules.ProcessRule;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.graph.MutableDirectedGraph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public final class DependsGraph implements IncrementalAnalyzeByChangeFiles.IDependsGraph {
    @NotNull
    private final ModifyInfoFactory factory;
    @NotNull
    private final MutableDirectedGraph<XDecl> dependenceGraph;
    @NotNull
    private final Map<String, Set<XDecl>> patchRelateAnalysisTargets;
    @NotNull
    private final Set<XDecl> patchRelateObjects;
    @NotNull
    private final Set<XDecl> patchRelateChangedWalk;
    private boolean isOld;

    public DependsGraph(@NotNull ModifyInfoFactory factory) {
        if (factory == null) throw new NullPointerException("factory");
        this.factory = factory;
        this.dependenceGraph = new HashMutableDirectedGraph<>();
        this.patchRelateAnalysisTargets = new LinkedHashMap<>();
        this.patchRelateObjects = new LinkedHashSet<>();
        this.patchRelateChangedWalk = new LinkedHashSet<>();
    }

    @NotNull
    public ModifyInfoFactory getFactory() {
        return factory;
    }

    @Override
    public void dependsOn(@NotNull Collection<? extends XDecl> nodes, @NotNull Collection<? extends XDecl> deps) {
        if (nodes == null) throw new NullPointerException("nodes");
        if (deps == null) throw new NullPointerException("deps");
        
        for (XDecl node : nodes) {
            for (XDecl dep : deps) {
                dependsOn(node, dep);
            }
        }
    }

    @Override
    public void visitChangedDecl(@NotNull String diffPath, @NotNull Collection<? extends XDecl> changed) {
        if (diffPath == null) throw new NullPointerException("diffPath");
        if (changed == null) throw new NullPointerException("changed");
        
        for (XDecl xDecl : changed) {
            patchRelateAnalysisTargets.computeIfAbsent(diffPath, k -> new LinkedHashSet<>()).add(xDecl);
            patchRelateObjects.add(xDecl);
        }
        patchRelateChangedWalk.clear();
        isOld = true;
    }

    private synchronized void walkAll() {
        if (!isOld) return;
        
        targetsRelate(patchRelateObjects).forEach(patchRelateChangedWalk::add);
        isOld = false;
    }

    @Override
    public void dependsOn(@NotNull XDecl node, @NotNull XDecl dep) {
        if (node == null) throw new NullPointerException("node");
        if (dep == null) throw new NullPointerException("dep");
        
        dependenceGraph.addEdge(node, dep);
        isOld = true;
    }

    private Stream<XDecl> walk(Collection<? extends XDecl> nodes, boolean forward) {
        Set<XDecl> visited = new LinkedHashSet<>();
        Deque<XDecl> queue = new ArrayDeque<>(nodes);
        
        return Stream.generate(() -> {
            if (queue.isEmpty()) return null;
            
            XDecl current = queue.removeFirst();
            if (!visited.add(current)) return null;
            
            Collection<XDecl> neighbors = forward ? 
                dependenceGraph.getSuccsOf(current) : 
                dependenceGraph.getPredsOf(current);
            queue.addAll(neighbors);
            
            return current;
        }).takeWhile(Objects::nonNull);
    }

    @NotNull
    @Override
    public Stream<XDecl> targetsRelate(@NotNull Collection<? extends XDecl> targets) {
        if (targets == null) throw new NullPointerException("targets");
        return Stream.concat(walk(targets, true), walk(targets, false));
    }

    @NotNull
    @Override
    public XDecl toDecl(@NotNull Object target) {
        if (target == null) throw new NullPointerException("target");
        return factory.toDecl(target);
    }

    @NotNull
    @Override
    public Stream<XDecl> targetRelate(@NotNull XDecl target) {
        if (target == null) throw new NullPointerException("target");
        return targetsRelate(Collections.singletonList(target));
    }

    @NotNull
    @Override
    public ProcessRule.ScanAction shouldReAnalyzeDecl(@NotNull XDecl target) {
        if (target == null) throw new NullPointerException("target");
        
        walkAll();
        ProcessRule.ScanAction actionByFactory = factory.getScanAction(target);
        if (actionByFactory != ProcessRule.ScanAction.Keep) {
            return actionByFactory;
        }
        return patchRelateChangedWalk.contains(target) ? 
            ProcessRule.ScanAction.Process : 
            ProcessRule.ScanAction.Skip;
    }

    @NotNull
    @Override
    public ProcessRule.ScanAction shouldReAnalyzeTarget(@NotNull Object target) {
        if (target == null) throw new NullPointerException("target");
        return shouldReAnalyzeDecl(factory.toDecl(target));
    }
}
