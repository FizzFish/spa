package cn.sast.dataflow.infoflow.provider;

import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProvider;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class ModelingConfigImpl extends AIAnalysisBaseImpl {
    @NotNull
    private final MethodSummaryProvider provider;
    @NotNull
    private final PreAnalysisApi preAnalysis;
    @NotNull
    private final ConfigInfoLogger error;
    private static final KLogger logger = KotlinLogging.INSTANCE.logger("ModelingConfigImpl");

    public ModelingConfigImpl(@NotNull MethodSummaryProvider provider, @NotNull PreAnalysisApi preAnalysis) {
        if (provider == null) {
            throw new IllegalArgumentException("provider cannot be null");
        }
        if (preAnalysis == null) {
            throw new IllegalArgumentException("preAnalysis cannot be null");
        }
        this.provider = provider;
        this.preAnalysis = preAnalysis;
        this.error = new ConfigInfoLogger();
    }

    @NotNull
    public MethodSummaryProvider getProvider() {
        return provider;
    }

    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        return preAnalysis;
    }

    @NotNull
    public FastCache getFastCache() {
        return FastCacheImpl.INSTANCE;
    }

    @NotNull
    public CoroutineScope getScope() {
        return GlobalScope.INSTANCE;
    }

    @NotNull
    public ConfigInfoLogger getError() {
        return error;
    }

    private FlowSource createSource(boolean matchStrict, MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : 
            new AccessPathFragment(new ArrayList<>(fields), new ArrayList<>(fieldTypes));
        
        if (loc instanceof MReturn) {
            return null;
        }
        if (loc instanceof MParameter) {
            MParameter param = (MParameter) loc;
            if (param.getIndex() >= 0) {
                return new FlowSource(SourceSinkType.Parameter, param.getIndex(), baseType, acp, gap, matchStrict);
            }
            if (param.getIndex() == -1) {
                return new FlowSource(SourceSinkType.Field, baseType, acp, gap, matchStrict);
            }
        }
        return null;
    }

    private FlowSink createSink(boolean matchStrict, boolean taintSubFields, MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : 
            new AccessPathFragment(new ArrayList<>(fields), new ArrayList<>(fieldTypes));
        
        if (loc instanceof MReturn) {
            return new FlowSink(SourceSinkType.Return, baseType, acp, taintSubFields, gap, matchStrict);
        }
        if (loc instanceof MParameter) {
            MParameter param = (MParameter) loc;
            if (param.getIndex() >= 0) {
                return new FlowSink(SourceSinkType.Parameter, param.getIndex(), baseType, acp, taintSubFields, gap, matchStrict);
            }
            if (param.getIndex() == -1) {
                return new FlowSink(SourceSinkType.Field, baseType, acp, taintSubFields, gap, matchStrict);
            }
        }
        return null;
    }

    private FlowClear createClear(MLocal loc, String baseType, List<String> fields, List<String> fieldTypes) {
        GapDefinition gap = null;
        AccessPathFragment acp = fields.isEmpty() ? null : 
            new AccessPathFragment(new ArrayList<>(fields), new ArrayList<>(fieldTypes));
        
        if (loc instanceof MParameter) {
            MParameter param = (MParameter) loc;
            if (param.getIndex() >= 0) {
                return new FlowClear(SourceSinkType.Parameter, param.getIndex(), baseType, acp, gap);
            }
            if (param.getIndex() >= -1) {
                return new FlowClear(SourceSinkType.Field, baseType, acp, gap);
            }
        }
        return null;
    }

    @Nullable
    public Boolean isEmptySetValue(@NotNull IExpr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr cannot be null");
        }
        if (expr instanceof IIexConst) {
            Object constValue = ((IIexConst) expr).getConst();
            if (constValue instanceof Set) {
                return ((Set<?>) constValue).isEmpty();
            }
            return false;
        }
        return null;
    }

    private void addSummaryFromStmt(SootMethod method, IStmt stmt) {
        MethodSummaries methodSummaries = summaries.getMethodSummaries();
        List<FlowSource> from = new ArrayList<>();
        List<FlowSink> to = new ArrayList<>();
        String subSignature = method.getSubSignature();
        
        // Implementation of stmtVisitor would go here
        // Skipped for brevity as it was an anonymous inner class
        ClassMethodSummaries summaries = new ClassMethodSummaries(method.getDeclaringClass().getName());
        final MethodSummaries summary = summaries.getMethodSummaries();
        Intrinsics.checkNotNullExpressionValue(summary, "getMethodSummaries(...)");
        final List from = new ArrayList();
        final List to = new ArrayList();
        final String subSignature = method.getSubSignature();
        final Ref.ObjectRef typeChecking = new Ref.ObjectRef();
        typeChecking.element = false;
        final Ref.ObjectRef ignoreTypes = new Ref.ObjectRef();
        final Ref.ObjectRef cutSubfields = new Ref.ObjectRef();
        final Ref.BooleanRef matchStrict = new Ref.BooleanRef();
        final boolean taintSubFields = false;
        stmt.accept(new IModelStmtVisitor<Object>() { // from class: cn.sast.dataflow.infoflow.provider.ModelingConfigImpl$addSummaryFromStmt$stmtVisitor$1
            @Override // com.feysh.corax.config.api.IModelStmtVisitor
            /* renamed from: visit, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object mo121visit(IIstSetField stmt2) throws NoWhenBranchMatchedException {
                visit(stmt2);
                return Unit.INSTANCE;
            }

            @Override // com.feysh.corax.config.api.IModelStmtVisitor
            /* renamed from: default, reason: not valid java name */
            public Object mo120default(IStmt stmt2) {
                Intrinsics.checkNotNullParameter(stmt2, "stmt");
                return Unit.INSTANCE;
            }

            public final void initFlowSource(List<FlowSource> list, MethodSummaries summary2, SootMethod method2, IExpr expr, boolean matchStrict2) throws NoWhenBranchMatchedException {
                Intrinsics.checkNotNullParameter(list, "from");
                Intrinsics.checkNotNullParameter(summary2, "summary");
                Intrinsics.checkNotNullParameter(method2, "method");
                Intrinsics.checkNotNullParameter(expr, "expr");
                ModelingConfigImpl.Companion companion = ModelingConfigImpl.Companion;
                List<? extends IClassField> listEmptyList = CollectionsKt.emptyList();
                ModelingConfigImpl modelingConfigImpl = this.this$0;
                companion.getAccessPath(method2, listEmptyList, expr, (v6, v7, v8) -> {
                    return initFlowSource$lambda$2(r4, r5, r6, r7, r8, r9, v6, v7, v8);
                });
            }

            private static final Unit initFlowSource$lambda$2(ModelingConfigImpl this$0, boolean $matchStrict, IExpr $expr, SootMethod $method, MethodSummaries $summary, List $from, MLocal op, String baseType, List fields) throws NotImplementedError {
                Intrinsics.checkNotNullParameter(op, "op");
                Intrinsics.checkNotNullParameter(fields, "fields");
                ModelingConfigImpl.Companion.transFields(baseType, fields, (v8, v9, v10) -> {
                    return initFlowSource$lambda$2$lambda$1(r3, r4, r5, r6, r7, r8, r9, r10, v8, v9, v10);
                });
                return Unit.INSTANCE;
            }

            private static final Unit initFlowSource$lambda$2$lambda$1(ModelingConfigImpl this$0, boolean $matchStrict, MLocal $op, String $baseType, IExpr $expr, SootMethod $method, MethodSummaries $summary, List $from, List fieldSigs, List fieldTypes, boolean subFields) {
                Intrinsics.checkNotNullParameter(fieldSigs, "fieldSigs");
                Intrinsics.checkNotNullParameter(fieldTypes, "fieldTypes");
                FlowSource it = this$0.createSource($matchStrict, $op, $baseType, fieldSigs, fieldTypes);
                if (it != null) {
                    $from.add(it);
                }
                if (Intrinsics.areEqual(this$0.isEmptySetValue($expr), true)) {
                    MethodClear clear = new MethodClear($method.getSubSignature(), this$0.createClear($op, $baseType, fieldSigs, fieldTypes));
                    $summary.addClear(clear);
                }
                return Unit.INSTANCE;
            }

            public void visit(IIstSetField stmt2) throws NoWhenBranchMatchedException {
                Intrinsics.checkNotNullParameter(stmt2, "stmt");
                IClassField field = stmt2.getField();
                if ((field instanceof ClassField) || Intrinsics.areEqual(field, TaintProperty.INSTANCE) || Intrinsics.areEqual(field, MapKeys.INSTANCE) || Intrinsics.areEqual(field, MapValues.INSTANCE) || Intrinsics.areEqual(field, Elements.INSTANCE)) {
                    initFlowSource(from, summary, method, stmt2.getValue(), matchStrict.element);
                    ModelingConfigImpl.Companion companion = ModelingConfigImpl.Companion;
                    SootMethod sootMethod = method;
                    List<? extends IClassField> listListOf = CollectionsKt.listOf(stmt2.getField());
                    IExpr base = stmt2.getBase();
                    ModelingConfigImpl modelingConfigImpl = this.this$0;
                    Ref.BooleanRef booleanRef = matchStrict;
                    List<FlowSink> list = to;
                    companion.getAccessPath(sootMethod, listListOf, base, (v3, v4, v5) -> {
                        return visit$lambda$5(r4, r5, r6, v3, v4, v5);
                    });
                    boolean isAlias = !(field instanceof TaintProperty);
                    for (FlowSource fromE : from) {
                        for (FlowSink toE : to) {
                            MethodFlow flow = new MethodFlow(subSignature, fromE, toE, isAlias, (Boolean) typeChecking.element, (Boolean) ignoreTypes.element, (Boolean) cutSubfields.element);
                            summary.addFlow(flow);
                        }
                    }
                    return;
                }
                if (field instanceof BuiltInField) {
                }
            }

            private static final Unit visit$lambda$5(ModelingConfigImpl this$0, Ref.BooleanRef $matchStrict, List $to, MLocal op, String baseType, List fields) throws NotImplementedError {
                Intrinsics.checkNotNullParameter(op, "op");
                Intrinsics.checkNotNullParameter(fields, "fields");
                ModelingConfigImpl.Companion.transFields(baseType, fields, (v5, v6, v7) -> {
                    return visit$lambda$5$lambda$4(r3, r4, r5, r6, r7, v5, v6, v7);
                });
                return Unit.INSTANCE;
            }

            private static final Unit visit$lambda$5$lambda$4(ModelingConfigImpl this$0, Ref.BooleanRef $matchStrict, MLocal $op, String $baseType, List $to, List fieldSigs, List fieldTypes, boolean subFields) {
                Intrinsics.checkNotNullParameter(fieldSigs, "fieldSigs");
                Intrinsics.checkNotNullParameter(fieldTypes, "fieldTypes");
                FlowSink it = this$0.createSink($matchStrict.element, subFields, $op, $baseType, fieldSigs, fieldTypes);
                if (it != null) {
                    $to.add(it);
                }
                return Unit.INSTANCE;
            }

            @Override // com.feysh.corax.config.api.IModelStmtVisitor
            public Object visit(IIstStoreLocal stmt2) throws NoWhenBranchMatchedException {
                Intrinsics.checkNotNullParameter(stmt2, "stmt");
                initFlowSource(from, summary, method, stmt2.getValue(), matchStrict.element);
                MLocal toLocal = stmt2.getLocal();
                Type typeBaseType = SourceSinkProviderKt.baseType(method, toLocal);
                String baseType = typeBaseType != null ? typeBaseType.toString() : null;
                List fieldSigs = CollectionsKt.emptyList();
                List fieldTypes = CollectionsKt.emptyList();
                FlowSink it = this.this$0.createSink(matchStrict.element, taintSubFields, toLocal, baseType, fieldSigs, fieldTypes);
                if (it != null) {
                    to.add(it);
                }
                for (FlowSource fromE : from) {
                    for (FlowSink toE : to) {
                        MethodFlow flow = new MethodFlow(subSignature, fromE, toE, true, (Boolean) typeChecking.element, (Boolean) ignoreTypes.element, (Boolean) cutSubfields.element);
                        summary.addFlow(flow);
                    }
                }
                return Unit.INSTANCE;
            }
        });
        this.provider.addMethodSummaries(summaries);
    }

    public void addStmt(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IStmt stmt) {
        if (decl == null || config == null || stmt == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        
        if (decl instanceof IMethodDecl) {
            IMethodMatch match = ((IMethodDecl) decl).getMatch();
            Scene scene = Scene.v();
            List<SootMethod> sootMethods = match.matched(scene);
            
            for (SootMethod method : sootMethods) {
                Set<SootMethod> allImpls = MethodSummaryProviderKt.findAllOverrideMethodsOfMethod(method);
                allImpls.add(method);
                for (SootMethod impl : allImpls) {
                    addSummaryFromStmt(impl, stmt);
                }
            }
        } else if (!(decl instanceof IClassDecl || decl instanceof IFieldDecl || decl instanceof ILocalVarDecl)) {
            throw new IllegalArgumentException("Unsupported decl type");
        }
    }

    public void check(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, 
                     @NotNull IBoolExpr expr, @NotNull CheckType checkType, 
                     @NotNull Function1<? super BugMessage.Env, Unit> env) {
        // Implementation intentionally left empty
    }

    public void eval(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, 
                    @NotNull IExpr expr, @NotNull Function1<Object, Unit> accept) {
        // Implementation intentionally left empty
    }

    public void validate() {
        // Implementation intentionally left empty
    }
}
