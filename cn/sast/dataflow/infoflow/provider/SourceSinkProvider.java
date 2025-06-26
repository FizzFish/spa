/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.config.PreAnalysisCoroutineScopeKt
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider$Companion
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider$MethodModel
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider$MethodModel$AccPath
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider$ModelingConfigImpl
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider$initialize$1
 *  com.feysh.corax.config.api.ITaintType
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.jimple.infoflow.data.SootMethodAndClass
 *  soot.jimple.infoflow.sourcesSinks.definitions.AccessPathTuple
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider
 *  soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition
 */
package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.config.PreAnalysisCoroutineScopeKt;
import cn.sast.dataflow.infoflow.provider.SourceSinkProvider;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.jimple.infoflow.data.SootMethodAndClass;
import soot.jimple.infoflow.sourcesSinks.definitions.AccessPathTuple;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;
import soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010'\u001a\u00020(H\u0086@\u00a2\u0006\u0002\u0010)J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001eR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lcn/sast/dataflow/infoflow/provider/SourceSinkProvider;", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinitionProvider;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "preAnalysisImpl", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/api/config/PreAnalysisCoroutineScope;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "sourceDefinitions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lsoot/SootMethod;", "Lcn/sast/dataflow/infoflow/provider/SourceSinkProvider$MethodModel;", "getSourceDefinitions", "()Ljava/util/concurrent/ConcurrentHashMap;", "setSourceDefinitions", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "sinkDefinitions", "getSinkDefinitions", "setSinkDefinitions", "checkTypesInSink", "", "Lcom/feysh/corax/config/api/ITaintType;", "getCheckTypesInSink", "()Ljava/util/Set;", "sourceSet", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinition;", "getSourceSet", "setSourceSet", "(Ljava/util/Set;)V", "sinkSet", "getSinkSet", "setSinkSet", "allMethods", "getAllMethods", "setAllMethods", "missClass", "", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSources", "", "getSinks", "Companion", "ModelingConfigImpl", "MethodModel", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSourceSinkProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceSinkProvider.kt\ncn/sast/dataflow/infoflow/provider/SourceSinkProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,514:1\n1619#2:515\n1863#2:516\n1864#2:518\n1620#2:519\n1454#2,5:520\n1246#2,4:526\n1#3:517\n412#4:525\n216#5,2:530\n*S KotlinDebug\n*F\n+ 1 SourceSinkProvider.kt\ncn/sast/dataflow/infoflow/provider/SourceSinkProvider\n*L\n453#1:515\n453#1:516\n453#1:518\n453#1:519\n466#1:520,5\n471#1:526,4\n453#1:517\n471#1:525\n483#1:530,2\n*E\n"})
public final class SourceSinkProvider
implements ISourceSinkDefinitionProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    @NotNull
    private ConcurrentHashMap<SootMethod, MethodModel> sourceDefinitions;
    @NotNull
    private ConcurrentHashMap<SootMethod, MethodModel> sinkDefinitions;
    @NotNull
    private final Set<ITaintType> checkTypesInSink;
    @NotNull
    private Set<ISourceSinkDefinition> sourceSet;
    @NotNull
    private Set<ISourceSinkDefinition> sinkSet;
    @NotNull
    private Set<ISourceSinkDefinition> allMethods;
    @NotNull
    private Set<Object> missClass;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SourceSinkProvider::logger$lambda$6);

    public SourceSinkProvider(@NotNull MainConfig mainConfig, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisImpl, (String)"preAnalysisImpl");
        this.mainConfig = mainConfig;
        this.preAnalysisImpl = preAnalysisImpl;
        this.sourceDefinitions = new ConcurrentHashMap();
        this.sinkDefinitions = new ConcurrentHashMap();
        this.checkTypesInSink = new LinkedHashSet();
        this.sourceSet = new LinkedHashSet();
        this.sinkSet = new LinkedHashSet();
        this.allMethods = new LinkedHashSet();
        this.missClass = new LinkedHashSet();
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final ConcurrentHashMap<SootMethod, MethodModel> getSourceDefinitions() {
        return this.sourceDefinitions;
    }

    public final void setSourceDefinitions(@NotNull ConcurrentHashMap<SootMethod, MethodModel> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, (String)"<set-?>");
        this.sourceDefinitions = concurrentHashMap;
    }

    @NotNull
    public final ConcurrentHashMap<SootMethod, MethodModel> getSinkDefinitions() {
        return this.sinkDefinitions;
    }

    public final void setSinkDefinitions(@NotNull ConcurrentHashMap<SootMethod, MethodModel> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, (String)"<set-?>");
        this.sinkDefinitions = concurrentHashMap;
    }

    @NotNull
    public final Set<ITaintType> getCheckTypesInSink() {
        return this.checkTypesInSink;
    }

    @NotNull
    public final Set<ISourceSinkDefinition> getSourceSet() {
        return this.sourceSet;
    }

    public final void setSourceSet(@NotNull Set<ISourceSinkDefinition> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.sourceSet = set;
    }

    @NotNull
    public final Set<ISourceSinkDefinition> getSinkSet() {
        return this.sinkSet;
    }

    public final void setSinkSet(@NotNull Set<ISourceSinkDefinition> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.sinkSet = set;
    }

    @NotNull
    public final Set<ISourceSinkDefinition> getAllMethods() {
        return this.allMethods;
    }

    public final void setAllMethods(@NotNull Set<ISourceSinkDefinition> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.allMethods = set;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object initialize(@NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof initialize.1)) ** GOTO lbl-1000
        var8_2 = $completion;
        if ((var8_2.label & -2147483648) != 0) {
            var8_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                aiCheckerImpl = (AIAnalysisBaseImpl)new ModelingConfigImpl(this, (PreAnalysisApi)this.preAnalysisImpl);
                $continuation.L$0 = this;
                $continuation.label = 1;
                v0 = PreAnalysisCoroutineScopeKt.processAIAnalysisUnits((AIAnalysisBaseImpl)aiCheckerImpl, (PreAnalysisCoroutineScope)this.preAnalysisImpl, (Continuation)$continuation);
                if (v0 == var9_4) {
                    return var9_4;
                }
                ** GOTO lbl23
            }
            case 1: {
                this = (SourceSinkProvider)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                sinkTypes = new LinkedHashSet<E>();
                var4_7 = ((Map)this.sinkDefinitions).entrySet().iterator();
                while (var4_7.hasNext()) {
                    md = (MethodModel)var4_7.next().getValue();
                    definition = SourceSinkProvider.initialize$definition((MethodModel)md, null);
                    if (definition.isEmpty()) continue;
                    this.sinkSet.add(definition);
                    sinkTypes.addAll(SourceSinkProvider.initialize$types$5((MethodModel)md));
                }
                var4_7 = ((Map)this.sourceDefinitions).entrySet().iterator();
                while (var4_7.hasNext()) {
                    md = (MethodModel)var4_7.next().getValue();
                    definition = SourceSinkProvider.initialize$definition((MethodModel)md, (Set)sinkTypes);
                    if (definition.isEmpty()) continue;
                    this.sourceSet.add(definition);
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public Collection<ISourceSinkDefinition> getSources() {
        return this.sourceSet;
    }

    @NotNull
    public Collection<ISourceSinkDefinition> getSinks() {
        return this.sinkSet;
    }

    @NotNull
    public Collection<ISourceSinkDefinition> getAllMethods() {
        return SetsKt.plus((Set)this.sourceSet, (Iterable)this.sinkSet);
    }

    /*
     * WARNING - void declaration
     */
    private static final Set<AccessPathTuple> initialize$apt(Set<MethodModel.AccPath> $this$initialize_u24apt, Set<? extends ITaintType> filter2) {
        void var3_3;
        void $this$mapNotNullTo$iv;
        Iterable iterable = $this$initialize_u24apt;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            AccessPathTuple it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl = false;
            MethodModel.AccPath it = (MethodModel.AccPath)element$iv;
            boolean bl2 = false;
            Set types = it.getTypes();
            if ((types == null || filter2 == null ? it.getApt() : (CollectionsKt.intersect((Iterable)types, (Iterable)filter2).isEmpty() ? null : it.getApt())) == null) continue;
            it$iv = it$iv;
            boolean bl3 = false;
            destination$iv.add(it$iv);
        }
        return (Set)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    private static final Set<ITaintType> initialize$types(Set<MethodModel.AccPath> $this$initialize_u24types) {
        void var2_2;
        void $this$flatMapTo$iv;
        Iterable iterable = $this$initialize_u24types;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            MethodModel.AccPath it = (MethodModel.AccPath)element$iv;
            boolean bl = false;
            Set set = it.getTypes();
            if (set == null) {
                set = SetsKt.emptySet();
            }
            Iterable list$iv = set;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        return (Set)var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final MethodSourceSinkDefinition initialize$definition(MethodModel $this$initialize_u24definition, Set<? extends ITaintType> filter2) {
        void destination$iv;
        void $this$mapValuesTo$iv;
        Set baseObjects = SourceSinkProvider.initialize$apt((Set)$this$initialize_u24definition.getBaseObjectsAndTypes(), filter2);
        Map map = $this$initialize_u24definition.getParametersMapAndTypes();
        Map map2 = new LinkedHashMap();
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv = $this$mapValuesTo$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it;
            void it$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            void var12_14 = destination$iv;
            boolean bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv;
            Object k = it$iv.getKey();
            void var16_18 = var12_14;
            boolean bl2 = false;
            Set set = SourceSinkProvider.initialize$apt((Set)((Set)it.getValue()), filter2);
            var16_18.put(k, set);
        }
        void parametersMap = destination$iv;
        Set returnAPs = SourceSinkProvider.initialize$apt((Set)$this$initialize_u24definition.getReturnAPsAndTypes(), filter2);
        SootMethodAndClass am = new SootMethodAndClass($this$initialize_u24definition.getMethod());
        int n = parametersMap.isEmpty() ? 0 : ((Number)((Object)CollectionsKt.maxOrThrow((Iterable)parametersMap.keySet()))).intValue() + 1;
        Set[] setArray = new Set[n];
        for (int i = 0; i < n; ++i) {
            int n2 = i;
            Set set = (Set)parametersMap.get(n2);
            if (set == null) {
                set = new LinkedHashSet();
            }
            setArray[n2] = set;
        }
        Set[] parameters = setArray;
        return new MethodSourceSinkDefinition(am, baseObjects, parameters, returnAPs, $this$initialize_u24definition.getCallType(), null);
    }

    private static final Set<ITaintType> initialize$types$5(MethodModel $this$initialize_u24types_u245) {
        Set set;
        Set it = set = (Set)new LinkedHashSet();
        boolean bl = false;
        it.addAll(SourceSinkProvider.initialize$types((Set)$this$initialize_u24types_u245.getBaseObjectsAndTypes()));
        Map $this$forEach$iv = $this$initialize_u24types_u245.getParametersMapAndTypes();
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry p = element$iv = iterator2.next();
            boolean bl2 = false;
            it.addAll(SourceSinkProvider.initialize$types((Set)((Set)p.getValue())));
        }
        it.addAll(SourceSinkProvider.initialize$types((Set)$this$initialize_u24types_u245.getReturnAPsAndTypes()));
        return set;
    }

    private static final Unit logger$lambda$6() {
        return Unit.INSTANCE;
    }
}

