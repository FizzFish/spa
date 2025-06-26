/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.dataflow.infoflow.provider.BugTypeProvider
 *  cn.sast.dataflow.infoflow.provider.BugTypeProvider$Companion
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.IChecker
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.dataflow.infoflow.provider.BugTypeProvider;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000eJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010\u0016\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/infoflow/provider/BugTypeProvider;", "", "config", "Lcn/sast/api/config/MainConfig;", "preAnalysisImpl", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/api/config/PreAnalysisCoroutineScope;)V", "getConfig", "()Lcn/sast/api/config/MainConfig;", "getPreAnalysisImpl", "()Lcn/sast/api/config/PreAnalysisCoroutineScope;", "methodToCheckType", "", "Lsoot/SootMethod;", "", "Lcom/feysh/corax/config/api/CheckType;", "init", "", "lookUpChecker", "", "Lcom/feysh/corax/config/api/IChecker;", "method", "lookUpCheckType", "aiCheckerImpl", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nBugTypeProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BugTypeProvider.kt\ncn/sast/dataflow/infoflow/provider/BugTypeProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1797#2,3:85\n1#3:88\n*S KotlinDebug\n*F\n+ 1 BugTypeProvider.kt\ncn/sast/dataflow/infoflow/provider/BugTypeProvider\n*L\n34#1:85,3\n*E\n"})
public final class BugTypeProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig config;
    @NotNull
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    @NotNull
    private Map<SootMethod, Set<CheckType>> methodToCheckType;
    @NotNull
    private final AIAnalysisBaseImpl aiCheckerImpl;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(BugTypeProvider::logger$lambda$2);

    public BugTypeProvider(@NotNull MainConfig config, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)preAnalysisImpl, (String)"preAnalysisImpl");
        this.config = config;
        this.preAnalysisImpl = preAnalysisImpl;
        this.methodToCheckType = new LinkedHashMap();
        this.aiCheckerImpl = (AIAnalysisBaseImpl)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public final MainConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final PreAnalysisCoroutineScope getPreAnalysisImpl() {
        return this.preAnalysisImpl;
    }

    public final void init() {
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<IChecker> lookUpChecker(@NotNull SootMethod method) {
        Iterable iterable;
        void $this$fold$iv;
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Iterable iterable2 = this.lookUpCheckType(method);
        Set initial$iv = SetsKt.emptySet();
        boolean $i$f$fold = false;
        Set accumulator$iv = initial$iv;
        for (Object element$iv : $this$fold$iv) {
            void type;
            CheckType checkType = (CheckType)element$iv;
            Set acc = accumulator$iv;
            boolean bl = false;
            accumulator$iv = SetsKt.plus((Set)acc, (Object)type.getChecker());
        }
        iterable2 = accumulator$iv;
        if (iterable2.isEmpty()) {
            boolean bl = false;
            iterable = SetsKt.emptySet();
        } else {
            iterable = iterable2;
        }
        return (Set)iterable;
    }

    @NotNull
    public final Set<CheckType> lookUpCheckType(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Set set = (Set)this.methodToCheckType.get(method);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ AIAnalysisBaseImpl access$getAiCheckerImpl$p(BugTypeProvider $this) {
        return $this.aiCheckerImpl;
    }

    public static final /* synthetic */ Map access$getMethodToCheckType$p(BugTypeProvider $this) {
        return $this.methodToCheckType;
    }
}

