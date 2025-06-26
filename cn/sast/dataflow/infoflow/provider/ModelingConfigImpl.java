/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.caffine.impl.FastCacheImpl
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProvider
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt
 *  cn.sast.dataflow.infoflow.provider.ModelingConfigImpl
 *  cn.sast.dataflow.infoflow.provider.ModelingConfigImpl$Companion
 *  cn.sast.dataflow.infoflow.provider.ModelingConfigImpl$addSummaryFromStmt$stmtVisitor$1
 *  cn.sast.dataflow.util.ConfigInfoLogger
 *  com.feysh.corax.cache.coroutines.FastCache
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.IBoolExpr
 *  com.feysh.corax.config.api.IClassDecl
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.IFieldDecl
 *  com.feysh.corax.config.api.IIexConst
 *  com.feysh.corax.config.api.IJDecl
 *  com.feysh.corax.config.api.ILocalVarDecl
 *  com.feysh.corax.config.api.IMethodDecl
 *  com.feysh.corax.config.api.IMethodMatch
 *  com.feysh.corax.config.api.IModelStmtVisitor
 *  com.feysh.corax.config.api.IStmt
 *  com.feysh.corax.config.api.MLocal
 *  com.feysh.corax.config.api.MParameter
 *  com.feysh.corax.config.api.MReturn
 *  com.feysh.corax.config.api.MethodConfig
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.GlobalScope
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootMethod
 *  soot.jimple.infoflow.methodSummary.data.sourceSink.FlowClear
 *  soot.jimple.infoflow.methodSummary.data.sourceSink.FlowSink
 *  soot.jimple.infoflow.methodSummary.data.sourceSink.FlowSource
 *  soot.jimple.infoflow.methodSummary.data.summary.ClassMethodSummaries
 *  soot.jimple.infoflow.methodSummary.data.summary.GapDefinition
 *  soot.jimple.infoflow.methodSummary.data.summary.MethodSummaries
 *  soot.jimple.infoflow.methodSummary.data.summary.SourceSinkType
 *  soot.jimple.infoflow.methodSummary.taintWrappers.AccessPathFragment
 */
package cn.sast.dataflow.infoflow.provider;

import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProvider;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt;
import cn.sast.dataflow.infoflow.provider.ModelingConfigImpl;
import cn.sast.dataflow.util.ConfigInfoLogger;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.ILocalVarDecl;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.infoflow.methodSummary.data.sourceSink.FlowClear;
import soot.jimple.infoflow.methodSummary.data.sourceSink.FlowSink;
import soot.jimple.infoflow.methodSummary.data.sourceSink.FlowSource;
import soot.jimple.infoflow.methodSummary.data.summary.ClassMethodSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.GapDefinition;
import soot.jimple.infoflow.methodSummary.data.summary.MethodSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.SourceSinkType;
import soot.jimple.infoflow.methodSummary.taintWrappers.AccessPathFragment;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0001HB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J@\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0002JH\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0002J8\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0002J\u0011\u0010(\u001a\u0004\u0018\u00010\u001b*\u00020)\u00a2\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J9\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u001f\u00104\u001a\u001b\u0012\b\u0012\u000606j\u0002`7\u0012\u0004\u0012\u00020,05j\u0002`9\u00a2\u0006\u0002\b82\u0006\u0010/\u001a\u000200H\u0016JZ\u0010:\u001a\u00020,2\u0006\u00102\u001a\u0002032\u001f\u00104\u001a\u001b\u0012\b\u0012\u000606j\u0002`7\u0012\u0004\u0012\u00020,05j\u0002`9\u00a2\u0006\u0002\b82\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020,05\u00a2\u0006\u0002\b8H\u0016J\\\u0010A\u001a\u00020,2\u0006\u00102\u001a\u0002032\u001f\u00104\u001a\u001b\u0012\b\u0012\u000606j\u0002`7\u0012\u0004\u0012\u00020,05j\u0002`9\u00a2\u0006\u0002\b82\u0006\u0010;\u001a\u00020)2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110C\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020,05H\u0016J\b\u0010G\u001a\u00020,H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006I"}, d2={"Lcn/sast/dataflow/infoflow/provider/ModelingConfigImpl;", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "provider", "Lcn/sast/dataflow/infoflow/provider/MethodSummaryProvider;", "preAnalysis", "Lcom/feysh/corax/config/api/PreAnalysisApi;", "<init>", "(Lcn/sast/dataflow/infoflow/provider/MethodSummaryProvider;Lcom/feysh/corax/config/api/PreAnalysisApi;)V", "getProvider", "()Lcn/sast/dataflow/infoflow/provider/MethodSummaryProvider;", "getPreAnalysis", "()Lcom/feysh/corax/config/api/PreAnalysisApi;", "fastCache", "Lcom/feysh/corax/cache/coroutines/FastCache;", "getFastCache", "()Lcom/feysh/corax/cache/coroutines/FastCache;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "error", "Lcn/sast/dataflow/util/ConfigInfoLogger;", "getError", "()Lcn/sast/dataflow/util/ConfigInfoLogger;", "createSource", "Lsoot/jimple/infoflow/methodSummary/data/sourceSink/FlowSource;", "matchStrict", "", "loc", "Lcom/feysh/corax/config/api/MLocal;", "baseType", "", "fields", "", "fieldTypes", "createSink", "Lsoot/jimple/infoflow/methodSummary/data/sourceSink/FlowSink;", "taintSubFields", "createClear", "Lsoot/jimple/infoflow/methodSummary/data/sourceSink/FlowClear;", "isEmptySetValue", "Lcom/feysh/corax/config/api/IExpr;", "(Lcom/feysh/corax/config/api/IExpr;)Ljava/lang/Boolean;", "addSummaryFromStmt", "", "method", "Lsoot/SootMethod;", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "addStmt", "decl", "Lcom/feysh/corax/config/api/IJDecl;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "check", "expr", "Lcom/feysh/corax/config/api/IBoolExpr;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "eval", "accept", "", "Lkotlin/ParameterName;", "name", "value", "validate", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nMethodSummaryProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MethodSummaryProvider.kt\ncn/sast/dataflow/infoflow/provider/ModelingConfigImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,449:1\n1863#2,2:450\n*S KotlinDebug\n*F\n+ 1 MethodSummaryProvider.kt\ncn/sast/dataflow/infoflow/provider/ModelingConfigImpl\n*L\n420#1:450,2\n*E\n"})
public final class ModelingConfigImpl
extends AIAnalysisBaseImpl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MethodSummaryProvider provider;
    @NotNull
    private final PreAnalysisApi preAnalysis;
    @NotNull
    private final ConfigInfoLogger error;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ModelingConfigImpl::logger$lambda$1);

    public ModelingConfigImpl(@NotNull MethodSummaryProvider provider, @NotNull PreAnalysisApi preAnalysis) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)preAnalysis, (String)"preAnalysis");
        this.provider = provider;
        this.preAnalysis = preAnalysis;
        this.error = new ConfigInfoLogger();
    }

    @NotNull
    public final MethodSummaryProvider getProvider() {
        return this.provider;
    }

    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        return this.preAnalysis;
    }

    @NotNull
    public FastCache getFastCache() {
        return (FastCache)FastCacheImpl.INSTANCE;
    }

    @NotNull
    public CoroutineScope getScope() {
        return (CoroutineScope)GlobalScope.INSTANCE;
    }

    @NotNull
    public ConfigInfoLogger getError() {
        return this.error;
    }

    private final FlowSource createSource(boolean matchStrict, MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : new AccessPathFragment(CollectionsKt.toMutableList((Collection)fields), CollectionsKt.toMutableList((Collection)fieldTypes));
        if (loc instanceof MReturn) {
            return null;
        }
        if (loc instanceof MParameter && ((MParameter)loc).getIndex() >= 0) {
            return new FlowSource(SourceSinkType.Parameter, ((MParameter)loc).getIndex(), baseType, acp, gap, matchStrict);
        }
        if (loc instanceof MParameter && ((MParameter)loc).getIndex() == -1) {
            return new FlowSource(SourceSinkType.Field, baseType, acp, gap, matchStrict);
        }
        return null;
    }

    private final FlowSink createSink(boolean matchStrict, boolean taintSubFields, MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : new AccessPathFragment(CollectionsKt.toMutableList((Collection)fields), CollectionsKt.toMutableList((Collection)fieldTypes));
        if (loc instanceof MReturn) {
            return new FlowSink(SourceSinkType.Return, baseType, acp, taintSubFields, gap, matchStrict);
        }
        if (loc instanceof MParameter && ((MParameter)loc).getIndex() >= 0) {
            return new FlowSink(SourceSinkType.Parameter, ((MParameter)loc).getIndex(), baseType, acp, taintSubFields, gap, matchStrict);
        }
        if (loc instanceof MParameter && ((MParameter)loc).getIndex() == -1) {
            return new FlowSink(SourceSinkType.Field, baseType, acp, taintSubFields, gap, matchStrict);
        }
        return null;
    }

    private final FlowClear createClear(MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : new AccessPathFragment(CollectionsKt.toMutableList((Collection)fields), CollectionsKt.toMutableList((Collection)fieldTypes));
        if (!(loc instanceof MReturn)) {
            if (loc instanceof MParameter && ((MParameter)loc).getIndex() >= 0) {
                return new FlowClear(SourceSinkType.Parameter, ((MParameter)loc).getIndex(), baseType, acp, gap);
            }
            if (loc instanceof MParameter && ((MParameter)loc).getIndex() >= -1) {
                return new FlowClear(SourceSinkType.Field, baseType, acp, gap);
            }
        }
        return null;
    }

    @Nullable
    public final Boolean isEmptySetValue(@NotNull IExpr $this$isEmptySetValue) {
        Intrinsics.checkNotNullParameter((Object)$this$isEmptySetValue, (String)"<this>");
        if ($this$isEmptySetValue instanceof IIexConst) {
            Object object = ((IIexConst)$this$isEmptySetValue).getConst();
            Set set = object instanceof Set ? (Set)object : null;
            if (set == null) {
                return false;
            }
            Set set2 = set;
            return set2.isEmpty();
        }
        return null;
    }

    private final void addSummaryFromStmt(SootMethod method, IStmt stmt) {
        ClassMethodSummaries summaries = new ClassMethodSummaries(method.getDeclaringClass().getName());
        MethodSummaries methodSummaries = summaries.getMethodSummaries();
        Intrinsics.checkNotNullExpressionValue((Object)methodSummaries, (String)"getMethodSummaries(...)");
        MethodSummaries summary = methodSummaries;
        List from = new ArrayList();
        List to = new ArrayList();
        String subSignature = method.getSubSignature();
        Ref.ObjectRef typeChecking = new Ref.ObjectRef();
        typeChecking.element = false;
        Ref.ObjectRef ignoreTypes = new Ref.ObjectRef();
        Ref.ObjectRef cutSubfields = new Ref.ObjectRef();
        Ref.BooleanRef matchStrict = new Ref.BooleanRef();
        boolean isSummary = false;
        boolean taintSubFields = false;
        addSummaryFromStmt.stmtVisitor.1 stmtVisitor2 = new /* Unavailable Anonymous Inner Class!! */;
        stmt.accept((IModelStmtVisitor)stmtVisitor2);
        this.provider.addMethodSummaries(summaries);
    }

    public void addStmt(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IStmt stmt) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        IJDecl iJDecl = decl;
        if (iJDecl instanceof IMethodDecl) {
            IMethodMatch iMethodMatch = ((IMethodDecl)decl).getMatch();
            Scene scene = Scene.v();
            Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
            List sootMethods = iMethodMatch.matched(scene);
            Iterable $this$forEach$iv = sootMethods;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                SootMethod method = (SootMethod)element$iv;
                boolean bl = false;
                Set allImpls = SetsKt.plus((Set)MethodSummaryProviderKt.findAllOverrideMethodsOfMethod((SootMethod)method), (Object)method);
                for (SootMethod impl : allImpls) {
                    this.addSummaryFromStmt(impl, stmt);
                }
            }
        } else if (!(iJDecl instanceof IClassDecl || iJDecl instanceof IFieldDecl || iJDecl instanceof ILocalVarDecl)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public void check(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(env, (String)"env");
    }

    public void eval(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IExpr expr, @NotNull Function1<Object, Unit> accept) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(accept, (String)"accept");
    }

    public void validate() {
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ FlowSink access$createSink(ModelingConfigImpl $this, boolean matchStrict, boolean taintSubFields, MLocal loc, String baseType, List fields, List fieldTypes) {
        return $this.createSink(matchStrict, taintSubFields, loc, baseType, fields, fieldTypes);
    }

    public static final /* synthetic */ FlowSource access$createSource(ModelingConfigImpl $this, boolean matchStrict, MLocal loc, String baseType, List fields, List fieldTypes) {
        return $this.createSource(matchStrict, loc, baseType, fields, fieldTypes);
    }

    public static final /* synthetic */ FlowClear access$createClear(ModelingConfigImpl $this, MLocal loc, String baseType, List fields, List fieldTypes) {
        return $this.createClear(loc, baseType, fields, fieldTypes);
    }
}

