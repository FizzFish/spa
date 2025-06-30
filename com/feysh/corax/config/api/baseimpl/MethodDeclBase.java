/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Local
 *  soot.Scene
 *  soot.SootField
 *  soot.SootMethod
 *  soot.jimple.JimpleBody
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.BinOp;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILocalVarDecl;
import com.feysh.corax.config.api.ILocalVarMatch;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import com.feysh.corax.config.api.baseimpl.Attribute;
import com.feysh.corax.config.api.baseimpl.BaseLocalVarDecl;
import com.feysh.corax.config.api.baseimpl.BaseSootLocalVarDecl;
import com.feysh.corax.config.api.baseimpl.Global;
import com.feysh.corax.config.api.baseimpl.IBaseOperatorFactory;
import com.feysh.corax.config.api.baseimpl.Parameter;
import com.feysh.corax.config.api.baseimpl.Return;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.JimpleBody;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ1\u0010\u0011\u001a\u00020\u00122'\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J9\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001bR\b\u0012\u0004\u0012\u00028\u00000\u00002\u001f\u0010\u001c\u001a\u001b\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0012\u0004\u0012\u00020\u00120\u0014j\u0002` \u00a2\u0006\u0002\b\u001fH\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Lcom/feysh/corax/config/api/baseimpl/MethodDeclBase;", "R", "Lcom/feysh/corax/config/api/IMethodDecl;", "analyzeConfig", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "match", "Lcom/feysh/corax/config/api/IMethodMatch;", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;Lcom/feysh/corax/config/api/IMethodMatch;Lcom/feysh/corax/config/api/AIAnalysisApi$Error;)V", "getAnalyzeConfig", "()Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "getMatch", "()Lcom/feysh/corax/config/api/IMethodMatch;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "eachLocalVar", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "", "Lkotlin/ParameterName;", "name", "localVariable", "checkBuilder", "Lcom/feysh/corax/config/api/baseimpl/MethodDeclBase$CheckBuilder;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "toString", "", "CheckBuilder", "corax-config-api"})
public class MethodDeclBase<R>
implements IMethodDecl<R> {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final IMethodMatch match;
    @NotNull
    private final AIAnalysisApi.Error error;

    public MethodDeclBase(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IMethodMatch match, @NotNull AIAnalysisApi.Error error2) {
        Intrinsics.checkNotNullParameter((Object)analyzeConfig, (String)"analyzeConfig");
        Intrinsics.checkNotNullParameter((Object)match, (String)"match");
        Intrinsics.checkNotNullParameter((Object)error2, (String)"error");
        this.analyzeConfig = analyzeConfig;
        this.match = match;
        this.error = error2;
    }

    public /* synthetic */ MethodDeclBase(AIAnalysisBaseImpl aIAnalysisBaseImpl, IMethodMatch iMethodMatch, AIAnalysisApi.Error error2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            error2 = aIAnalysisBaseImpl.getError();
        }
        this(aIAnalysisBaseImpl, iMethodMatch, error2);
    }

    @NotNull
    public AIAnalysisBaseImpl getAnalyzeConfig() {
        return this.analyzeConfig;
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return this.match;
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return this.error;
    }

    @Override
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        IMethodMatch iMethodMatch = this.getMatch();
        Scene scene = Scene.v();
        Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
        for (SootMethod sm : iMethodMatch.matched(scene)) {
            Iterator iterator;
            JimpleBody acBody;
            Body body;
            if (!sm.hasActiveBody() || ((body = sm.getActiveBody()) instanceof JimpleBody ? (JimpleBody)body : null) == null) continue;
            acBody = acBody;
            Intrinsics.checkNotNullExpressionValue((Object)acBody.getLocals().iterator(), (String)"iterator(...)");
            while (iterator.hasNext()) {
                Local local = (Local)iterator.next();
                BaseLocalVarDecl baseLocal2 = new BaseLocalVarDecl(this.getAnalyzeConfig(), new ILocalVarMatch(local){
                    final /* synthetic */ Local $local;
                    {
                        this.$local = $local;
                    }

                    public List<Local> matched(Scene scene) {
                        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
                        return CollectionsKt.listOf((Object)this.$local);
                    }
                });
                ILocalVarDecl iLocalVarDecl = baseLocal2;
                Intrinsics.checkNotNull((Object)local);
                BaseSootLocalVarDecl sootLocal = new BaseSootLocalVarDecl(iLocalVarDecl, local);
                block.invoke(sootLocal);
            }
        }
    }

    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new CheckBuilder(config, this);
    }

    @NotNull
    public String toString() {
        return "method decl: " + this.getMatch();
    }

    @Override
    @Nullable
    public Integer getArgumentCnt() {
        return IMethodDecl.DefaultImpls.getArgumentCnt(this);
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return IMethodDecl.DefaultImpls.getActualType(this);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B6\u0012\u001f\u0010\u0004\u001a\u001b\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\n\u00a2\u0006\u0002\b\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J1\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH\u0016J3\u0010+\u001a\u00020\b2\u0006\u0010%\u001a\u00020,2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\b0\u0005H\u0016R-\u0010\u0004\u001a\u001b\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\n\u00a2\u0006\u0002\b\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00061"}, d2={"Lcom/feysh/corax/config/api/baseimpl/MethodDeclBase$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "Lcom/feysh/corax/config/api/baseimpl/IBaseOperatorFactory;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "method", "Lcom/feysh/corax/config/api/IMethodDecl;", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/MethodDeclBase;Lkotlin/jvm/functions/Function1;Lcom/feysh/corax/config/api/IMethodDecl;)V", "getConfig", "()Lkotlin/jvm/functions/Function1;", "getMethod", "()Lcom/feysh/corax/config/api/IMethodDecl;", "paramAt", "Lcom/feysh/corax/config/api/IParameterT;", "T", "index", "", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "global", "Lcom/feysh/corax/config/api/ILocalT;", "", "getGlobal", "()Lcom/feysh/corax/config/api/ILocalT;", "addStmt", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "check", "expr", "Lcom/feysh/corax/config/api/IBoolExpr;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "eval", "Lcom/feysh/corax/config/api/IExpr;", "result", "Lkotlin/ParameterName;", "name", "value", "corax-config-api"})
    public final class CheckBuilder<R>
    implements IMethodDecl.CheckBuilder<R>,
    IBaseOperatorFactory {
        @NotNull
        private final Function1<MethodConfig, Unit> config;
        @NotNull
        private final IMethodDecl<R> method;
        @NotNull
        private final IReturnT<R> return;
        @NotNull
        private final ILocalT<Object> global;

        public CheckBuilder(@NotNull Function1<? super MethodConfig, Unit> config, IMethodDecl<R> method) {
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(method, (String)"method");
            this.config = config;
            this.method = method;
            this.return = new Return();
            this.global = Global.INSTANCE;
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.config;
        }

        @Override
        @NotNull
        public IMethodDecl<R> getMethod() {
            return this.method;
        }

        @Override
        @NotNull
        public <T> IParameterT<T> paramAt(int index) {
            Integer argumentCnt = MethodDeclBase.this.getArgumentCnt();
            if (argumentCnt != null && index >= argumentCnt) {
                MethodDeclBase.this.getError().error("parameter index \"" + index + "\" out of range. argument count is " + argumentCnt + " of method: " + MethodDeclBase.this.getMatch() + ".");
            }
            return new Parameter(index);
        }

        @Override
        @NotNull
        public IReturnT<R> getReturn() {
            return this.return;
        }

        @Override
        @NotNull
        public ILocalT<Object> getGlobal() {
            return this.global;
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            MethodDeclBase.this.getAnalyzeConfig().addStmt(MethodDeclBase.this, this.getConfig(), stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            MethodDeclBase.this.getAnalyzeConfig().check(MethodDeclBase.this, this.getConfig(), expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function1<Object, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            MethodDeclBase.this.getAnalyzeConfig().eval(MethodDeclBase.this, this.getConfig(), expr, result);
        }

        @Override
        @NotNull
        public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> $this$subFields) {
            return IBaseOperatorFactory.DefaultImpls.getSubFields(this, $this$subFields);
        }

        @Override
        @NotNull
        public <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> $this$attr) {
            return IBaseOperatorFactory.DefaultImpls.getAttr(this, $this$attr);
        }

        @Override
        @NotNull
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> $this$taint) {
            return IBaseOperatorFactory.DefaultImpls.getTaint(this, $this$taint);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> $this$taint, @NotNull IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            IBaseOperatorFactory.DefaultImpls.setTaint(this, $this$taint, iAttribute);
        }

        @Override
        @NotNull
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> $this$via) {
            return IBaseOperatorFactory.DefaultImpls.getVia(this, $this$via);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> $this$via, @NotNull IAttribute<ViaProperty, Set<IViaType>> iAttribute) {
            IBaseOperatorFactory.DefaultImpls.setVia(this, $this$via, iAttribute);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> $this$value) {
            return IBaseOperatorFactory.DefaultImpls.getValue(this, $this$value);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> $this$value, @NotNull ILocalValue<T> iLocalValue) {
            IBaseOperatorFactory.DefaultImpls.setValue(this, $this$value, iLocalValue);
        }

        @Override
        @NotNull
        public IStringExpr literal(@NotNull String string) {
            return IBaseOperatorFactory.DefaultImpls.literal((IBaseOperatorFactory)this, string);
        }

        @Override
        @NotNull
        public IIntExpr literal(int n) {
            return IBaseOperatorFactory.DefaultImpls.literal((IBaseOperatorFactory)this, n);
        }

        @Override
        @NotNull
        public ILongExpr literal(long l) {
            return IBaseOperatorFactory.DefaultImpls.literal((IBaseOperatorFactory)this, l);
        }

        @Override
        @NotNull
        public IBoolExpr literal(boolean bool) {
            return IBaseOperatorFactory.DefaultImpls.literal((IBaseOperatorFactory)this, bool);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isConstant(@NotNull ILocalT<T> $this$isConstant) {
            return IBaseOperatorFactory.DefaultImpls.isConstant((IBaseOperatorFactory)this, $this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr isConstant(@NotNull ITypedExpr $this$isConstant) {
            return IBaseOperatorFactory.DefaultImpls.isConstant((IBaseOperatorFactory)this, $this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr not(@NotNull IBoolExpr $this$not) {
            return IBaseOperatorFactory.DefaultImpls.not(this, $this$not);
        }

        @Override
        @NotNull
        public IBoolExpr or(@NotNull IBoolExpr $this$or, @NotNull IBoolExpr other) {
            return IBaseOperatorFactory.DefaultImpls.or((IBaseOperatorFactory)this, $this$or, other);
        }

        @Override
        @NotNull
        public IIntExpr or(@NotNull IIntExpr $this$or, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.or((IBaseOperatorFactory)this, $this$or, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr and(@NotNull IBoolExpr $this$and, @NotNull IBoolExpr other) {
            return IBaseOperatorFactory.DefaultImpls.and((IBaseOperatorFactory)this, $this$and, other);
        }

        @Override
        @NotNull
        public IIntExpr and(@NotNull IIntExpr $this$and, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.and((IBaseOperatorFactory)this, $this$and, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr lt(@NotNull IIntExpr $this$lt, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.lt(this, $this$lt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr le(@NotNull IIntExpr $this$le, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.le(this, $this$le, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr eq(@NotNull IIntExpr $this$eq, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.eq(this, $this$eq, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr ge(@NotNull IIntExpr $this$ge, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.ge(this, $this$ge, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr gt(@NotNull IIntExpr $this$gt, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.gt(this, $this$gt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr neq(@NotNull IIntExpr $this$neq, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.neq(this, $this$neq, rhs);
        }

        @Override
        @NotNull
        public IIntExpr xor(@NotNull IIntExpr $this$xor, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.xor(this, $this$xor, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shl(@NotNull IIntExpr $this$shl, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.shl(this, $this$shl, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shr(@NotNull IIntExpr $this$shr, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.shr(this, $this$shr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr lshr(@NotNull IIntExpr $this$lshr, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.lshr(this, $this$lshr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr plus(@NotNull IIntExpr $this$plus, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.plus((IBaseOperatorFactory)this, $this$plus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> plus(@NotNull IAttribute<T, V> $this$plus, @NotNull IAttribute<T, V> set) {
            return IBaseOperatorFactory.DefaultImpls.plus((IBaseOperatorFactory)this, $this$plus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$plus, @NotNull ITaintType single) {
            return IMethodDecl.CheckBuilder.DefaultImpls.plus(this, $this$plus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$plus, @NotNull IViaType single) {
            return IMethodDecl.CheckBuilder.DefaultImpls.plus(this, $this$plus, single);
        }

        @Override
        @NotNull
        public IIntExpr minus(@NotNull IIntExpr $this$minus, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.minus((IBaseOperatorFactory)this, $this$minus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> Attribute<T, V> minus(@NotNull IAttribute<T, V> $this$minus, @NotNull IAttribute<T, V> set) {
            return IBaseOperatorFactory.DefaultImpls.minus((IBaseOperatorFactory)this, $this$minus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$minus, @NotNull ITaintType single) {
            return IMethodDecl.CheckBuilder.DefaultImpls.minus(this, $this$minus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$minus, @NotNull IViaType single) {
            return IMethodDecl.CheckBuilder.DefaultImpls.minus(this, $this$minus, single);
        }

        @Override
        @NotNull
        public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> $this$getBoolean) {
            return IBaseOperatorFactory.DefaultImpls.getBoolean(this, $this$getBoolean);
        }

        @Override
        @NotNull
        public <T> IStringExpr getString(@NotNull ILocalT<T> $this$getString) {
            return IBaseOperatorFactory.DefaultImpls.getString(this, $this$getString);
        }

        @Override
        @NotNull
        public <T> IIntExpr getInt(@NotNull ILocalT<T> $this$getInt) {
            return IBaseOperatorFactory.DefaultImpls.getInt(this, $this$getInt);
        }

        @Override
        @NotNull
        public <T> ILongExpr getLong(@NotNull ILocalT<T> $this$getLong) {
            return IBaseOperatorFactory.DefaultImpls.getLong(this, $this$getLong);
        }

        @Override
        @NotNull
        public <T> IStringExpr getEnumName(@NotNull ILocalT<T> $this$getEnumName) {
            return IBaseOperatorFactory.DefaultImpls.getEnumName(this, $this$getEnumName);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> $this$isInstanceOf, @NotNull String parentType) {
            return IBaseOperatorFactory.DefaultImpls.isInstanceOf(this, $this$isInstanceOf, parentType);
        }

        @Override
        @NotNull
        public IStringExpr toLowerCase(@NotNull IStringExpr $this$toLowerCase) {
            return IBaseOperatorFactory.DefaultImpls.toLowerCase(this, $this$toLowerCase);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.startsWith((IBaseOperatorFactory)this, $this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull String str) {
            return IMethodDecl.CheckBuilder.DefaultImpls.startsWith(this, $this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.endsWith((IBaseOperatorFactory)this, $this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull String str) {
            return IMethodDecl.CheckBuilder.DefaultImpls.endsWith(this, $this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.contains((IBaseOperatorFactory)this, $this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull String str) {
            return IMethodDecl.CheckBuilder.DefaultImpls.contains(this, $this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$contains, @NotNull ITaintType taint) {
            return IBaseOperatorFactory.DefaultImpls.contains((IBaseOperatorFactory)this, $this$contains, taint);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.stringEquals((IBaseOperatorFactory)this, $this$stringEquals, str);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull String str) {
            return IMethodDecl.CheckBuilder.DefaultImpls.stringEquals(this, $this$stringEquals, str);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
            return IMethodDecl.CheckBuilder.DefaultImpls.taintOf(this, type);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            return IBaseOperatorFactory.DefaultImpls.taintOf((IBaseOperatorFactory)this, types);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... via) {
            return IBaseOperatorFactory.DefaultImpls.viaOf(this, via);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint(this);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia(this);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> anyOf(ILocalT<T> ... local) {
            return IBaseOperatorFactory.DefaultImpls.anyOf(this, local);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> null() {
            return IBaseOperatorFactory.DefaultImpls.null(this);
        }

        @Override
        @NotNull
        public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$hasIntersection, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            return IBaseOperatorFactory.DefaultImpls.hasIntersection(this, $this$hasIntersection, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull ITaintType taint) {
            return IMethodDecl.CheckBuilder.DefaultImpls.containsAll(this, $this$containsAll, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            return IBaseOperatorFactory.DefaultImpls.containsAll((IBaseOperatorFactory)this, $this$containsAll, taint);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> $this$anyOr, @NotNull ILocalValue<T2> second) {
            return IBaseOperatorFactory.DefaultImpls.anyOr((IBaseOperatorFactory)this, $this$anyOr, second);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> $this$anyOr, @NotNull ILocalT<T2> second) {
            return IMethodDecl.CheckBuilder.DefaultImpls.anyOr(this, $this$anyOr, second);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull SootField field) {
            return IMethodDecl.CheckBuilder.DefaultImpls.field(this, $this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            return IMethodDecl.CheckBuilder.DefaultImpls.field(this, $this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            return IMethodDecl.CheckBuilder.DefaultImpls.field(this, $this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull IClassField field) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, field);
        }

        @Override
        @NotNull
        public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<? extends F> field) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type) {
            return IBaseOperatorFactory.DefaultImpls.field(this, $this$field, field, type);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            IMethodDecl.CheckBuilder.DefaultImpls.check(this, expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function1<? super Boolean, Unit> result) {
            IBaseOperatorFactory.DefaultImpls.eval((IBaseOperatorFactory)this, expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function1<? super String, Unit> result) {
            IBaseOperatorFactory.DefaultImpls.eval((IBaseOperatorFactory)this, expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function1<? super Integer, Unit> result) {
            IBaseOperatorFactory.DefaultImpls.eval((IBaseOperatorFactory)this, expr, result);
        }

        @Override
        @NotNull
        public IExpr const(@NotNull Object object, @NotNull IIexConst.Type type) {
            return IBaseOperatorFactory.DefaultImpls.const(this, object, type);
        }

        @Override
        @NotNull
        public IBoolExpr compareBinOp(@NotNull IIntExpr $this$compareBinOp, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.compareBinOp(this, $this$compareBinOp, op, rhs);
        }

        @Override
        @NotNull
        public IIntExpr arithmeticBinOp(@NotNull IIntExpr $this$arithmeticBinOp, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.arithmeticBinOp(this, $this$arithmeticBinOp, op, rhs);
        }

        @Override
        @NotNull
        public IIntExpr bitwiseBinOp(@NotNull IIntExpr $this$bitwiseBinOp, @NotNull BinOp op, @NotNull IIntExpr rhs) {
            return IBaseOperatorFactory.DefaultImpls.bitwiseBinOp(this, $this$bitwiseBinOp, op, rhs);
        }
    }
}

