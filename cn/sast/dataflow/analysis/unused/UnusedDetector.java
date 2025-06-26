/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.util.OthersKt
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.analysis.IBugReporter
 *  cn.sast.dataflow.analysis.IBugReporter$DefaultImpls
 *  cn.sast.dataflow.analysis.unused.UnusedDetector
 *  cn.sast.dataflow.analysis.unused.UnusedDetector$Companion
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.IMethodMatch
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  com.feysh.corax.config.builtin.checkers.DefineUnusedChecker$UnusedMethod
 *  com.feysh.corax.config.builtin.checkers.DefineUnusedChecker$UrfUnreadField
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.sync.Semaphore
 *  kotlinx.coroutines.sync.SemaphoreKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.MethodOrMethodContext
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.ValueBox
 *  soot.jimple.FieldRef
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.VisibilityAnnotationTag
 */
package cn.sast.dataflow.analysis.unused;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.MainConfig;
import cn.sast.api.util.OthersKt;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.analysis.unused.UnusedDetector;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.feysh.corax.config.builtin.checkers.DefineUnusedChecker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.FieldRef;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.tagkit.AbstractHost;
import soot.tagkit.VisibilityAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0019H\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u001c\u0010+\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160/H\u0086@\u00a2\u0006\u0002\u00100R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010$\u001a\u00020\u000f*\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010$\u001a\u00020\u000f*\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010&R\u000e\u0010)\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2={"Lcn/sast/dataflow/analysis/unused/UnusedDetector;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "builtinAnalysisConfig", "Lcn/sast/api/config/BuiltinAnalysisConfig;", "cg", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "reporter", "Lcn/sast/dataflow/analysis/IBugReporter;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/api/config/BuiltinAnalysisConfig;Lsoot/jimple/toolkits/callgraph/CallGraph;Lcn/sast/dataflow/analysis/IBugReporter;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "isAnnotated", "", "abstractHost", "Lsoot/tagkit/AbstractHost;", "findUnusedField", "", "Lsoot/SootField;", "appClass", "Lsoot/SootClass;", "calleeAndSuperMethods", "", "Lsoot/SootMethod;", "getCalleeAndSuperMethods", "()Ljava/util/Set;", "calleeAndSuperMethods$delegate", "Lkotlin/Lazy;", "allBlackMethods", "getAllBlackMethods", "allBlackMethods$delegate", "blackMethodPatterns", "", "Lkotlin/text/Regex;", "isSkipped", "(Lsoot/SootMethod;)Z", "(Lsoot/SootField;)Z", "isUnused", "sootMethod", "enableUnusedMethod", "enableUrfUnreadField", "analyze", "", "clazz", "classes", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nUnusedDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnusedDetector.kt\ncn/sast/dataflow/analysis/unused/UnusedDetector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1557#2:226\n1628#2,3:227\n865#2,2:230\n1863#2,2:232\n1755#2,3:234\n1755#2,3:237\n1053#2:241\n1053#2:242\n1619#2:243\n1863#2:244\n1864#2:246\n1620#2:247\n1469#2,5:248\n1#3:240\n1#3:245\n*S KotlinDebug\n*F\n+ 1 UnusedDetector.kt\ncn/sast/dataflow/analysis/unused/UnusedDetector\n*L\n92#1:226\n92#1:227,3\n47#1:230,2\n53#1:232,2\n97#1:234,3\n102#1:237,3\n183#1:241\n199#1:242\n65#1:243\n65#1:244\n65#1:246\n65#1:247\n66#1:248,5\n65#1:245\n*E\n"})
public final class UnusedDetector {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final BuiltinAnalysisConfig builtinAnalysisConfig;
    @NotNull
    private final CallGraph cg;
    @NotNull
    private final IBugReporter reporter;
    @NotNull
    private final Lazy calleeAndSuperMethods$delegate;
    @NotNull
    private final Lazy allBlackMethods$delegate;
    @NotNull
    private final List<Regex> blackMethodPatterns;
    private final boolean enableUnusedMethod;
    private final boolean enableUrfUnreadField;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(UnusedDetector::logger$lambda$17);

    /*
     * WARNING - void declaration
     */
    public UnusedDetector(@NotNull MainConfig mainConfig, @NotNull BuiltinAnalysisConfig builtinAnalysisConfig, @NotNull CallGraph cg, @NotNull IBugReporter reporter) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)builtinAnalysisConfig, (String)"builtinAnalysisConfig");
        Intrinsics.checkNotNullParameter((Object)cg, (String)"cg");
        Intrinsics.checkNotNullParameter((Object)reporter, (String)"reporter");
        this.mainConfig = mainConfig;
        this.builtinAnalysisConfig = builtinAnalysisConfig;
        this.cg = cg;
        this.reporter = reporter;
        this.calleeAndSuperMethods$delegate = LazyKt.lazy(() -> UnusedDetector.calleeAndSuperMethods_delegate$lambda$6(this));
        this.allBlackMethods$delegate = LazyKt.lazy(() -> UnusedDetector.allBlackMethods_delegate$lambda$8(this));
        Iterable iterable = this.builtinAnalysisConfig.getUnusedDetectorSootSigPatternBlackList();
        UnusedDetector unusedDetector = this;
        boolean $i$f$map = false;
        void var7_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(new Regex((String)it));
        }
        unusedDetector.blackMethodPatterns = (List)destination$iv$iv;
        this.enableUnusedMethod = this.mainConfig.isEnable((CheckType)DefineUnusedChecker.UnusedMethod.INSTANCE);
        this.enableUrfUnreadField = this.mainConfig.isEnable((CheckType)DefineUnusedChecker.UrfUnreadField.INSTANCE);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    private final boolean isAnnotated(AbstractHost abstractHost) {
        return (VisibilityAnnotationTag)abstractHost.getTag("VisibilityAnnotationTag") != null;
    }

    /*
     * Unable to fully structure code
     */
    private final Set<SootField> findUnusedField(SootClass appClass) {
        v0 = appClass.getFields();
        Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getFields(...)");
        var3_2 = (Iterable)v0;
        var4_3 = new LinkedHashSet<E>();
        $i$f$filterTo = false;
        for (T element$iv : $this$filterTo$iv) {
            it = (SootField)element$iv;
            $i$a$-filterTo-UnusedDetector$findUnusedField$unused$1 = false;
            if (!it.isPrivate() || it.isFinal()) ** GOTO lbl-1000
            Intrinsics.checkNotNull((Object)it);
            if (!this.isAnnotated((AbstractHost)it)) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = false;
            }
            if (!v1) continue;
            destination$iv.add(element$iv);
        }
        unused = (Set)destination$iv;
        v2 = appClass.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getMethods(...)");
        for (SootMethod sootMethod : CollectionsKt.toSet((Iterable)v2)) {
            if (!sootMethod.hasActiveBody()) {
                return SetsKt.emptySet();
            }
            Intrinsics.checkNotNullExpressionValue((Object)sootMethod.getActiveBody().getUnits().iterator(), (String)"iterator(...)");
            while (var5_5.hasNext()) {
                unit = (Unit)var5_5.next();
                v3 = unit.getUseBoxes();
                Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getUseBoxes(...)");
                $this$forEach$iv = v3;
                $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    it = (ValueBox)element$iv;
                    $i$a$-forEach-UnusedDetector$findUnusedField$1 = false;
                    v = it.getValue();
                    if (!(v instanceof FieldRef)) continue;
                    unused.remove(((FieldRef)v).getField());
                }
            }
        }
        return unused;
    }

    private final Set<SootMethod> getCalleeAndSuperMethods() {
        Lazy lazy = this.calleeAndSuperMethods$delegate;
        return (Set)lazy.getValue();
    }

    private final Set<SootMethod> getAllBlackMethods() {
        Lazy lazy = this.allBlackMethods$delegate;
        return (Set)lazy.getValue();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isSkipped(SootMethod $this$isSkipped) {
        Regex it;
        String sig = $this$isSkipped.getSignature();
        if (this.getAllBlackMethods().contains($this$isSkipped)) return true;
        Iterable $this$any$iv = this.blackMethodPatterns;
        boolean $i$f$any = false;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            return false;
        }
        Iterator iterator2 = $this$any$iv.iterator();
        do {
            if (!iterator2.hasNext()) return false;
            Object element$iv = iterator2.next();
            it = (Regex)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)sig);
        } while (!it.matches((CharSequence)sig));
        return true;
    }

    private final boolean isSkipped(SootField $this$isSkipped) {
        boolean bl;
        block3: {
            String sig = $this$isSkipped.getSignature();
            Iterable $this$any$iv = this.blackMethodPatterns;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Regex it = (Regex)element$iv;
                    boolean bl2 = false;
                    Intrinsics.checkNotNull((Object)sig);
                    if (!it.matches((CharSequence)sig)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final boolean isUnused(SootMethod sootMethod) {
        block17: {
            block16: {
                if (sootMethod.isStaticInitializer() || this.isAnnotated((AbstractHost)sootMethod)) {
                    return false;
                }
                if (sootMethod.isConstructor()) {
                    if (Intrinsics.areEqual((Object)sootMethod.getSubSignature(), (Object)"void <init>()")) {
                        return false;
                    }
                    if (sootMethod.getParameterCount() == 1) {
                        String string = sootMethod.getDeclaringClass().getName();
                        Type type = sootMethod.getParameterType(0);
                        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getParameterType(...)");
                        String string2 = UtilsKt.getTypename((Type)type);
                        String string3 = sootMethod.getDeclaringClass().getShortJavaStyleName();
                        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getShortJavaStyleName(...)");
                        if (Intrinsics.areEqual((Object)string, (Object)(string2 + "$" + StringsKt.substringAfterLast$default((String)string3, (String)"$", null, (int)2, null)))) {
                            return false;
                        }
                    }
                }
                String string = sootMethod.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
                if (StringsKt.contains$default((CharSequence)string, (CharSequence)"$", (boolean)false, (int)2, null)) break block16;
                String string4 = sootMethod.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getName(...)");
                if (!StringsKt.contains((CharSequence)string4, (CharSequence)"lambda", (boolean)true)) break block17;
            }
            return false;
        }
        String string = sootMethod.getSubSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSubSignature(...)");
        if (StringsKt.endsWith$default((String)string, (String)"valueOf(java.lang.String)", (boolean)false, (int)2, null)) {
            return false;
        }
        String string5 = sootMethod.getSubSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"getSubSignature(...)");
        if (StringsKt.endsWith$default((String)string5, (String)"[] values()", (boolean)false, (int)2, null)) {
            return false;
        }
        if (!sootMethod.isStatic()) {
            String string6;
            String string7;
            String it = string7 = sootMethod.getName();
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            String string8 = string6 = StringsKt.startsWith$default((String)it, (String)"get", (boolean)false, (int)2, null) || StringsKt.startsWith$default((String)it, (String)"set", (boolean)false, (int)2, null) || StringsKt.startsWith$default((String)it, (String)"is", (boolean)false, (int)2, null) ? string7 : null;
            if (string6 != null) {
                it = string6;
                boolean bl2 = false;
                return false;
            }
        }
        if (sootMethod.isMain()) {
            return false;
        }
        if (this.cg.edgesInto((MethodOrMethodContext)sootMethod).hasNext()) {
            return false;
        }
        SootClass sootClass = sootMethod.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        SootMethod superMethod = SootUtilsKt.findMethodOrNull((SootClass)sootClass, (String)sootMethod.getSubSignature().toString(), arg_0 -> UnusedDetector.isUnused$lambda$14(sootMethod, arg_0));
        if (superMethod != null) {
            return false;
        }
        if (this.getCalleeAndSuperMethods().contains(sootMethod)) {
            return false;
        }
        return sootMethod.hasActiveBody();
    }

    public final void analyze(@NotNull SootClass clazz) {
        boolean $i$f$sortedBy;
        Iterable $this$sortedBy$iv;
        int count;
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        if (this.enableUnusedMethod) {
            count = 1;
            int maximumUnusedMethodReportsEachClass = this.builtinAnalysisConfig.getMaximumUnusedMethodReportsEachClass();
            List list = clazz.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            $this$sortedBy$iv = CollectionsKt.toSet((Iterable)list);
            $i$f$sortedBy = false;
            for (SootMethod method : CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */))) {
                Intrinsics.checkNotNull((Object)method);
                if (!this.isUnused(method) || this.isSkipped(method)) continue;
                if (count++ > maximumUnusedMethodReportsEachClass) break;
                IBugReporter.DefaultImpls.report$default((IBugReporter)this.reporter, (CheckType)((CheckType)DefineUnusedChecker.UnusedMethod.INSTANCE), (SootMethod)method, null, (int)4, null);
            }
        }
        if (this.enableUrfUnreadField) {
            count = 1;
            int maximumUnusedFieldReportsEachClass = this.builtinAnalysisConfig.getMaximumUnusedFieldReportsEachClass();
            $this$sortedBy$iv = this.findUnusedField(clazz);
            $i$f$sortedBy = false;
            List unused = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
            for (SootField field : unused) {
                if (this.isSkipped(field)) continue;
                if (count++ > maximumUnusedFieldReportsEachClass) break;
                IBugReporter.DefaultImpls.report$default((IBugReporter)this.reporter, (CheckType)((CheckType)DefineUnusedChecker.UrfUnreadField.INSTANCE), (SootField)field, null, (int)4, null);
            }
        }
    }

    @Nullable
    public final Object analyze(@NotNull Collection<? extends SootClass> classes, @NotNull Continuation<? super kotlin.Unit> $completion) {
        Semaphore semaphore = SemaphoreKt.Semaphore$default((int)(this.mainConfig.getParallelsNum() * 2), (int)0, (int)2, null);
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return kotlin.Unit.INSTANCE;
    }

    private static final boolean calleeAndSuperMethods_delegate$lambda$6$lambda$4$lambda$3(SootMethod it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !it.isConstructor() && !it.isPrivate();
    }

    /*
     * WARNING - void declaration
     */
    private static final Set calleeAndSuperMethods_delegate$lambda$6(UnusedDetector this$0) {
        void $this$flatMapTo$iv;
        Iterable $this$mapNotNullTo$iv;
        Iterable iterable = CollectionsKt.toCollection((Iterable)((Iterable)this$0.cg), (Collection)new LinkedHashSet());
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            SootMethod it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl = false;
            Edge it = (Edge)element$iv;
            boolean bl2 = false;
            if (it.tgt() == null) continue;
            boolean bl3 = false;
            destination$iv.add(it$iv);
        }
        Set res = (Set)destination$iv;
        $this$mapNotNullTo$iv = res;
        destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapSequenceTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            SootMethod sootMethod = (SootMethod)element$iv;
            boolean bl = false;
            SootClass sootClass = sootMethod.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            Sequence list$iv = SequencesKt.filter((Sequence)SootUtilsKt.findMethodOrNull((SootClass)sootClass, (String)sootMethod.getSubSignature().toString()), UnusedDetector::calleeAndSuperMethods_delegate$lambda$6$lambda$4$lambda$3);
            CollectionsKt.addAll((Collection)destination$iv, (Sequence)list$iv);
        }
        iterable = destination$iv;
        Set it = (Set)iterable;
        boolean bl = false;
        res.addAll(it);
        return res;
    }

    private static final String allBlackMethods_delegate$lambda$8$lambda$7(String $blackMethodSig) {
        return "`" + $blackMethodSig + "` is not a valid method signature";
    }

    private static final Set allBlackMethods_delegate$lambda$8(UnusedDetector this$0) {
        Scene scene = Scene.v();
        Set allBlackMethods = new LinkedHashSet();
        for (String blackMethodSig : this$0.builtinAnalysisConfig.getUnusedDetectorMethodSigBlackList()) {
            IMethodMatch match;
            if (OthersKt.methodSignatureToMatcher((String)blackMethodSig) == null) {
                throw new IllegalStateException(((Function0)() -> UnusedDetector.allBlackMethods_delegate$lambda$8$lambda$7(blackMethodSig)).toString());
            }
            Intrinsics.checkNotNull((Object)scene);
            List methods = match.matched(scene);
            for (SootMethod mBlack : methods) {
                allBlackMethods.add(mBlack);
                allBlackMethods.addAll(MethodSummaryProviderKt.findAllOverrideMethodsOfMethod((SootMethod)mBlack));
            }
        }
        return allBlackMethods;
    }

    private static final boolean isUnused$lambda$14(SootMethod $sootMethod, SootMethod it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !Intrinsics.areEqual((Object)it, (Object)$sootMethod) && !it.isConstructor() && !it.isPrivate();
    }

    private static final kotlin.Unit logger$lambda$17() {
        return kotlin.Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

