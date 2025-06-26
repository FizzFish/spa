/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.graph.HashMutableDirectedGraph
 *  cn.sast.graph.HashMutableDirectedGraph$Companion
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LinkedHashSetSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.toolkits.graph.MutableDirectedGraph
 */
package cn.sast.graph;

import cn.sast.graph.HashMutableDirectedGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.toolkits.graph.MutableDirectedGraph;

/*
 * Exception performing whole class analysis ignored.
 */
@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 @*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0002@AB\t\b\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0007Bs\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0018\u00010\u000b\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0004\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u001b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u001b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\tH\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u001d\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00020\u00162\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u0015\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010,J\u001d\u0010-\u001a\u00020.2\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010/J\u0015\u00100\u001a\u00020.2\u0006\u00101\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00102J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0015\u00104\u001a\u00020\u00162\u0006\u00101\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010,J\u0015\u00105\u001a\u00020\u00162\u0006\u00101\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010,J\u0006\u00106\u001a\u00020\u0016JE\u00107\u001a\u00020\u0016\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00142\f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00010>H\u0001\u00a2\u0006\u0002\b?R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2={"Lcn/sast/graph/HashMutableDirectedGraph;", "N", "Lsoot/toolkits/graph/MutableDirectedGraph;", "", "<init>", "()V", "orig", "(Lcn/sast/graph/HashMutableDirectedGraph;)V", "seen0", "", "nodeToPreds", "", "", "nodeToSuccs", "heads", "tails", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "clone", "", "clearAll", "", "getHeads", "", "getTails", "getPredsOf", "s", "(Ljava/lang/Object;)Ljava/util/List;", "getPredsOfAsSet", "", "(Ljava/lang/Object;)Ljava/util/Set;", "getSuccsOf", "getSuccsOfAsSet", "size", "iterator", "", "addEdge", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)V", "removeEdge", "removeSingle", "n", "(Ljava/lang/Object;)V", "containsEdge", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "containsNode", "node", "(Ljava/lang/Object;)Z", "getNodes", "addNode", "removeNode", "printGraph", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$corax_api", "Companion", "$serializer", "corax-api"})
@SourceDebugExtension(value={"SMAP\nHashMutableDirectedGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashMutableDirectedGraph.kt\ncn/sast/graph/HashMutableDirectedGraph\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,220:1\n381#2,7:221\n381#2,7:228\n381#2,7:235\n381#2,7:242\n*S KotlinDebug\n*F\n+ 1 HashMutableDirectedGraph.kt\ncn/sast/graph/HashMutableDirectedGraph\n*L\n106#1:221,7\n110#1:228,7\n171#1:235,7\n172#1:242,7\n*E\n"})
public final class HashMutableDirectedGraph<N>
implements MutableDirectedGraph<N>,
Cloneable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<N, Set<N>> nodeToPreds;
    @NotNull
    private final Map<N, Set<N>> nodeToSuccs;
    @NotNull
    private final Set<N> heads;
    @NotNull
    private final Set<N> tails;
    private static final Logger logger = LoggerFactory.getLogger(HashMutableDirectedGraph.class);
    @JvmField
    @NotNull
    private static final SerialDescriptor $cachedDescriptor;

    public HashMutableDirectedGraph() {
        this.nodeToPreds = new HashMap();
        this.nodeToSuccs = new HashMap();
        this.heads = new HashSet();
        this.tails = new HashSet();
    }

    public HashMutableDirectedGraph(@NotNull HashMutableDirectedGraph<N> orig) {
        Intrinsics.checkNotNullParameter(orig, (String)"orig");
        this.nodeToPreds = Companion.access$deepCopy((Companion)Companion, (Map)orig.nodeToPreds);
        this.nodeToSuccs = Companion.access$deepCopy((Companion)Companion, (Map)orig.nodeToSuccs);
        this.heads = new HashSet(orig.heads);
        this.tails = new HashSet(orig.tails);
    }

    @NotNull
    public Object clone() {
        return new HashMutableDirectedGraph(this);
    }

    public final void clearAll() {
        this.nodeToPreds.clear();
        this.nodeToSuccs.clear();
        this.heads.clear();
        this.tails.clear();
    }

    @NotNull
    public List<N> getHeads() {
        return Companion.access$getCopy((Companion)Companion, (Collection)this.heads);
    }

    @NotNull
    public List<N> getTails() {
        return Companion.access$getCopy((Companion)Companion, (Collection)this.tails);
    }

    @NotNull
    public List<N> getPredsOf(N s) {
        Set preds = (Set)this.nodeToPreds.get(s);
        if (preds != null) {
            return Companion.access$getCopy((Companion)Companion, (Collection)preds);
        }
        return CollectionsKt.emptyList();
    }

    @NotNull
    public final Set<N> getPredsOfAsSet(N s) {
        Set preds = (Set)this.nodeToPreds.get(s);
        if (preds != null) {
            Set set = Collections.unmodifiableSet(preds);
            Intrinsics.checkNotNullExpressionValue(set, (String)"unmodifiableSet(...)");
            return set;
        }
        return SetsKt.emptySet();
    }

    @NotNull
    public List<N> getSuccsOf(N s) {
        Set succs = (Set)this.nodeToSuccs.get(s);
        if (succs != null) {
            return Companion.access$getCopy((Companion)Companion, (Collection)succs);
        }
        return CollectionsKt.emptyList();
    }

    @NotNull
    public final Set<N> getSuccsOfAsSet(N s) {
        Set succs = (Set)this.nodeToSuccs.get(s);
        if (succs != null) {
            Set set = Collections.unmodifiableSet(succs);
            Intrinsics.checkNotNullExpressionValue(set, (String)"unmodifiableSet(...)");
            return set;
        }
        return SetsKt.emptySet();
    }

    public int size() {
        return this.nodeToPreds.keySet().size();
    }

    @NotNull
    public Iterator<N> iterator() {
        return this.nodeToPreds.keySet().iterator();
    }

    public void addEdge(N from, N to) {
        Object object;
        Object object2;
        if (this.containsEdge(from, to)) {
            return;
        }
        Map $this$getOrPut$iv = this.nodeToSuccs;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(from);
        if (value$iv == null) {
            boolean bl = false;
            this.heads.add(from);
            Set answer$iv = new LinkedHashSet();
            $this$getOrPut$iv.put(from, answer$iv);
            object2 = answer$iv;
        } else {
            object2 = value$iv;
        }
        Set succsList = (Set)object2;
        Map $this$getOrPut$iv2 = this.nodeToPreds;
        boolean $i$f$getOrPut2 = false;
        Object value$iv2 = $this$getOrPut$iv2.get(to);
        if (value$iv2 == null) {
            boolean bl = false;
            this.tails.add(to);
            Set answer$iv = new LinkedHashSet();
            $this$getOrPut$iv2.put(to, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv2;
        }
        Set predsList = (Set)object;
        this.heads.remove(to);
        this.tails.remove(from);
        succsList.add(to);
        predsList.add(from);
    }

    public void removeEdge(N from, N to) {
        Set succs = (Set)this.nodeToSuccs.get(from);
        if (succs == null || !succs.contains(to)) {
            return;
        }
        Set set = (Set)this.nodeToPreds.get(to);
        if (set == null) {
            throw new RuntimeException(to + " not in graph!");
        }
        Set preds = set;
        succs.remove(to);
        preds.remove(from);
        if (succs.isEmpty()) {
            this.tails.add(from);
            this.nodeToSuccs.remove(from);
        }
        if (preds.isEmpty()) {
            this.heads.add(to);
            this.nodeToPreds.remove(to);
        }
        this.removeSingle(from);
        this.removeSingle(to);
    }

    private final void removeSingle(N n) {
        Set succs = (Set)this.nodeToSuccs.get(n);
        Set preds = (Set)this.nodeToPreds.get(n);
        Set set = succs;
        if (!(set != null ? !((Collection)set).isEmpty() : false) && this.heads.contains(n)) {
            this.heads.remove(n);
        }
        Set set2 = preds;
        if (!(set2 != null ? !((Collection)set2).isEmpty() : false) && this.tails.contains(n)) {
            this.tails.remove(n);
        }
    }

    public boolean containsEdge(N from, N to) {
        Set succs = (Set)this.nodeToSuccs.get(from);
        return succs != null && succs.contains(to);
    }

    public boolean containsNode(N node) {
        return this.nodeToPreds.keySet().contains(node);
    }

    @NotNull
    public List<N> getNodes() {
        return Companion.access$getCopy((Companion)Companion, (Collection)this.nodeToPreds.keySet());
    }

    public void addNode(N node) {
        if (this.containsNode(node)) {
            return;
        }
        Map $this$getOrPut$iv = this.nodeToSuccs;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(node);
        if (value$iv == null) {
            boolean bl = false;
            Set answer$iv = new LinkedHashSet();
            $this$getOrPut$iv.put(node, answer$iv);
        }
        $this$getOrPut$iv = this.nodeToPreds;
        $i$f$getOrPut = false;
        value$iv = $this$getOrPut$iv.get(node);
        if (value$iv == null) {
            boolean bl = false;
            Set answer$iv = new LinkedHashSet();
            $this$getOrPut$iv.put(node, answer$iv);
        }
        this.heads.add(node);
        this.tails.add(node);
    }

    public void removeNode(N node) {
        Object n;
        Iterator iterator2 = new ArrayList((Collection)this.nodeToSuccs.get(node)).iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            n = iterator3.next();
            this.removeEdge(node, n);
        }
        this.nodeToSuccs.remove(node);
        Iterator iterator4 = new ArrayList((Collection)this.nodeToPreds.get(node)).iterator();
        Intrinsics.checkNotNullExpressionValue(iterator4, (String)"iterator(...)");
        iterator3 = iterator4;
        while (iterator3.hasNext()) {
            n = iterator3.next();
            this.removeEdge(n, node);
        }
        this.nodeToPreds.remove(node);
        this.heads.remove(node);
        this.tails.remove(node);
    }

    public final void printGraph() {
        for (Object node : this) {
            logger.debug("Node = " + node);
            logger.debug("Preds:");
            for (Object p : this.getPredsOf(node)) {
                logger.debug("     ");
                logger.debug("" + p);
            }
            logger.debug("Succs:");
            for (Object s : this.getSuccsOf(node)) {
                logger.debug("     ");
                logger.debug("" + s);
            }
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(HashMutableDirectedGraph self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)new LinkedHashMapSerializer(typeSerial0, (KSerializer)new LinkedHashSetSerializer(typeSerial0)), (Object)self.nodeToPreds);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)new LinkedHashMapSerializer(typeSerial0, (KSerializer)new LinkedHashSetSerializer(typeSerial0)), (Object)self.nodeToSuccs);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)new LinkedHashSetSerializer(typeSerial0), (Object)self.heads);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)new LinkedHashSetSerializer(typeSerial0), (Object)self.tails);
    }

    public /* synthetic */ HashMutableDirectedGraph(int seen0, Map nodeToPreds, Map nodeToSuccs, Set heads, Set tails, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (0xF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)15, (SerialDescriptor)$cachedDescriptor);
        }
        this.nodeToPreds = nodeToPreds;
        this.nodeToSuccs = nodeToSuccs;
        this.heads = heads;
        this.tails = tails;
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cn.sast.graph.HashMutableDirectedGraph", null, 4);
        pluginGeneratedSerialDescriptor.addElement("nodeToPreds", false);
        pluginGeneratedSerialDescriptor.addElement("nodeToSuccs", false);
        pluginGeneratedSerialDescriptor.addElement("heads", false);
        pluginGeneratedSerialDescriptor.addElement("tails", false);
        $cachedDescriptor = (SerialDescriptor)pluginGeneratedSerialDescriptor;
    }
}

