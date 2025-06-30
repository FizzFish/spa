/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 */
package com.feysh.corax.config.api.baseimpl;

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
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
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
import com.feysh.corax.config.api.baseimpl.IBaseOperatorFactory;
import com.feysh.corax.config.api.baseimpl.Parameter;
import com.feysh.corax.config.api.baseimpl.Return;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003\u001e\u001f B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJN\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001f\u0010\u000e\u001a\u001b\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0014\u00a2\u0006\u0002\b\u00132\u001d\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0004\u0012\u00020\u00120\u000f\u00a2\u0006\u0002\b\u0013H\u0016Ji\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001f\u0010\u000e\u001a\u001b\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fj\u0002`\u0014\u00a2\u0006\u0002\b\u001328\u0010\u0015\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0018\u00a2\u0006\u0002\b\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006!"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseLocalVarDecl;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "analyzeConfig", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "match", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;Lcom/feysh/corax/config/api/ILocalVarMatch;)V", "getAnalyzeConfig", "()Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "getMatch", "()Lcom/feysh/corax/config/api/ILocalVarMatch;", "atGet", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "block", "Lcom/feysh/corax/config/api/ILocalVarDecl$IGet;", "atSet", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/ILocalVarDecl$ISet;", "Lcom/feysh/corax/config/api/IParameterT;", "Lkotlin/ParameterName;", "name", "value", "Builder", "LocalVarGet", "LocalVarSet", "corax-config-api"})
public final class BaseLocalVarDecl<T>
implements ILocalVarDecl<T> {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final ILocalVarMatch match;

    public BaseLocalVarDecl(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull ILocalVarMatch match) {
        Intrinsics.checkNotNullParameter((Object)analyzeConfig, (String)"analyzeConfig");
        Intrinsics.checkNotNullParameter((Object)match, (String)"match");
        this.analyzeConfig = analyzeConfig;
        this.match = match;
    }

    @NotNull
    public final AIAnalysisBaseImpl getAnalyzeConfig() {
        return this.analyzeConfig;
    }

    @NotNull
    public final ILocalVarMatch getMatch() {
        return this.match;
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atGet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super ILocalVarDecl.IGet<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        LocalVarGet getter = new LocalVarGet(new Builder(config));
        block.invoke(getter);
        return this;
    }

    @Override
    @NotNull
    public ILocalVarDecl<T> atSet(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super ILocalVarDecl.ISet<T>, ? super IParameterT<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        LocalVarSet setter = new LocalVarSet(new Builder(config));
        block.invoke(setter, setter.getValue());
        return this;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B(\u0012\u001f\u0010\u0003\u001a\u001b\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\t\u00a2\u0006\u0002\b\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J1\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\u0002\b\bH\u0016J3\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00070\u0004H\u0016R-\u0010\u0003\u001a\u001b\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\t\u00a2\u0006\u0002\b\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006'"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseLocalVarDecl$Builder;", "Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "Lcom/feysh/corax/config/api/baseimpl/IBaseOperatorFactory;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/BaseLocalVarDecl;Lkotlin/jvm/functions/Function1;)V", "getConfig", "()Lkotlin/jvm/functions/Function1;", "match", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "getMatch", "()Lcom/feysh/corax/config/api/ILocalVarMatch;", "decl", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "getDecl", "()Lcom/feysh/corax/config/api/ILocalVarDecl;", "addStmt", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "check", "expr", "Lcom/feysh/corax/config/api/IBoolExpr;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "eval", "Lcom/feysh/corax/config/api/IExpr;", "result", "", "Lkotlin/ParameterName;", "name", "value", "corax-config-api"})
    public final class Builder
    implements ILocalVarDecl.IBuilder<T>,
    IBaseOperatorFactory {
        @NotNull
        private final Function1<MethodConfig, Unit> config;
        @NotNull
        private final ILocalVarMatch match;
        @NotNull
        private final ILocalVarDecl<T> decl;

        public Builder(Function1<? super MethodConfig, Unit> config) {
            Intrinsics.checkNotNullParameter(config, (String)"config");
            this.config = config;
            this.match = BaseLocalVarDecl.this.getMatch();
            this.decl = BaseLocalVarDecl.this;
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.config;
        }

        @Override
        @NotNull
        public ILocalVarMatch getMatch() {
            return this.match;
        }

        @Override
        @NotNull
        public ILocalVarDecl<T> getDecl() {
            return this.decl;
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            BaseLocalVarDecl.this.getAnalyzeConfig().addStmt(BaseLocalVarDecl.this, this.getConfig(), stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            BaseLocalVarDecl.this.getAnalyzeConfig().check(BaseLocalVarDecl.this, this.getConfig(), expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function1<Object, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            BaseLocalVarDecl.this.getAnalyzeConfig().eval(BaseLocalVarDecl.this, this.getConfig(), expr, result);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.plus(this, $this$plus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$plus, @NotNull IViaType single) {
            return ILocalVarDecl.IBuilder.DefaultImpls.plus(this, $this$plus, single);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.minus(this, $this$minus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$minus, @NotNull IViaType single) {
            return ILocalVarDecl.IBuilder.DefaultImpls.minus(this, $this$minus, single);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.startsWith(this, $this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.endsWith((IBaseOperatorFactory)this, $this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull String str) {
            return ILocalVarDecl.IBuilder.DefaultImpls.endsWith(this, $this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull IStringExpr str) {
            return IBaseOperatorFactory.DefaultImpls.contains((IBaseOperatorFactory)this, $this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull String str) {
            return ILocalVarDecl.IBuilder.DefaultImpls.contains(this, $this$contains, str);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.stringEquals(this, $this$stringEquals, str);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
            return ILocalVarDecl.IBuilder.DefaultImpls.taintOf(this, type);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.getEmptyTaint(this);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return ILocalVarDecl.IBuilder.DefaultImpls.getEmptyVia(this);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.containsAll(this, $this$containsAll, taint);
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
            return ILocalVarDecl.IBuilder.DefaultImpls.anyOr(this, $this$anyOr, second);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull SootField field) {
            return ILocalVarDecl.IBuilder.DefaultImpls.field(this, $this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            return IBaseOperatorFactory.DefaultImpls.field((IBaseOperatorFactory)this, $this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            return ILocalVarDecl.IBuilder.DefaultImpls.field(this, $this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            return ILocalVarDecl.IBuilder.DefaultImpls.field(this, $this$field, declaringClass, fieldName, fieldType);
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
            ILocalVarDecl.IBuilder.DefaultImpls.check(this, expr, checkType, env);
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

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0005J\u0015\u0010\u0011\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JE\u0010\u0016\u001a\r\u0012\t\u0012\u0007H\u0001\u00a2\u0006\u0002\b\u00180\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u00192\u001e\u0010\u001a\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u001b\"\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001\u00a2\u0006\u0002\u0010\u001dJG\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0017\"\b\b\u0002\u0010 *\u0002H\u001f\"\b\b\u0003\u0010!*\u0002H\u001f\"\n\b\u0004\u0010\u001f*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H 0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u001cH\u0096\u0005JG\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0017\"\b\b\u0002\u0010 *\u0002H\u001f\"\b\b\u0003\u0010!*\u0002H\u001f\"\n\b\u0004\u0010\u001f*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H 0\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u0017H\u0096\u0005J8\u0010#\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010&\u001a\u00020'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\u0002\b+H\u0096\u0001J2\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\u0002\b+H\u0096\u0001J\u0015\u0010,\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010,\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J+\u0010,\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u00105\u001a\u000203H\u0096\u0001JA\u00106\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u001c\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4H\u0096\u0001J+\u00106\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u00105\u001a\u000203H\u0096\u0001J\u0015\u00107\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u00107\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J\u0015\u00108\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00122!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020>2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00142!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110?\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020-2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J-\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010@\u001a\u00020BH\u0096\u0001J-\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010@\u001a\u00020CH\u0096\u0001JC\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030E2\u0006\u0010F\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010/H\u0096\u0001JA\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\b\u0010D\u001a\u0004\u0018\u00010/2\u0006\u0010F\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010/H\u0096\u0001J?\u0010@\u001a\b\u0012\u0004\u0012\u0002HH0A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\n\b\u0003\u0010H*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002HH0IH\u0096\u0001JI\u0010@\u001a\b\u0012\u0004\u0012\u0002HJ0A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010J*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030I2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0EH\u0096\u0001JS\u0010@\u001a\b\u0012\u0004\u0012\u0002HJ0A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010J*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010E2\u0006\u0010F\u001a\u00020/2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0EH\u0096\u0001JO\u0010@\u001a\b\u0012\u0004\u0012\u0002HJ0A\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010J*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\b\u0010D\u001a\u0004\u0018\u00010/2\u0006\u0010F\u001a\u00020/2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0EH\u0096\u0001J\u0015\u0010L\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u001f\u0010M\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010N\u001a\u00020-\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010O\u001a\u00020\u0014\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010P\u001a\u00020Q\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010R\u001a\u00020-\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u0015\u0010S\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JA\u0010T\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u001c\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4H\u0096\u0001J'\u0010U\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010V\u001a\u00020/H\u0096\u0001J\u0015\u0010W\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0011\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020%H\u0096\u0001J\u0011\u0010X\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020?H\u0096\u0001J\u0011\u0010X\u001a\u00020Q2\u0006\u0010[\u001a\u00020\\H\u0096\u0001J\u0011\u0010X\u001a\u00020-2\u0006\u0010]\u001a\u00020/H\u0096\u0001J\u0015\u0010^\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010_\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JS\u0010`\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha00\"\b\b\u0002\u0010\u0001*\u00020B\"\u000e\b\u0003\u0010a*\b\u0012\u0004\u0012\u00020\u001902*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha002\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha00H\u0096\u0007JA\u0010`\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u0010c\u001a\u000203H\u0096\u0007JA\u0010`\u001a\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f*\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f2\u0006\u0010c\u001a\u00020eH\u0096\u0007J\u0015\u0010`\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0003J\u0015\u0010g\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\r\u0010h\u001a\u00020\u0012*\u00020\u0012H\u0096\u0003J\u001b\u0010i\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019H\u0096\u0001J\u0015\u0010j\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0005J\u0015\u0010j\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JS\u0010k\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha00\"\b\b\u0002\u0010\u0001*\u00020B\"\u000e\b\u0003\u0010a*\b\u0012\u0004\u0012\u00020\u001902*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha002\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002Ha00H\u0096\u0007JA\u0010k\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u0010c\u001a\u000203H\u0096\u0007JA\u0010k\u001a\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f*\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f2\u0006\u0010c\u001a\u00020eH\u0096\u0007J\u0015\u0010k\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0003J\u0015\u0010l\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010m\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010n\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010n\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J\u0015\u0010o\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010o\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J8\u0010p\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0012\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u0002030\u001b\"\u000203H\u0096\u0001\u00a2\u0006\u0002\u0010qJ-\u0010p\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\f\u0010r\u001a\b\u0012\u0004\u0012\u0002030sH\u0096\u0001J\r\u0010t\u001a\u00020-*\u00020-H\u0096\u0001J8\u0010u\u001a\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f2\u0012\u0010v\u001a\n\u0012\u0006\b\u0001\u0012\u00020e0\u001b\"\u00020eH\u0096\u0001\u00a2\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010y\u001a\u00020z\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b{\u0010|R.\u0010}\u001a\u001c\u0012\b\u0012\u00060~j\u0002`\u007f\u0012\u0004\u0012\u00020\u000e0)j\u0003`\u0080\u0001\u00a2\u0006\u0002\b+X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0084\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R-\u0010\u0087\u0001\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`48VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R-\u0010\u008a\u0001\u001a\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u0089\u0001R\u001a\u0010\u008c\u0001\u001a\u00020\u0012*\u00030\u008d\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008e\u0001R+\u0010\u008c\u0001\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008f\u0001R\u0016\u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0094\u0001\u001a\u00030\u0095\u0001*\u0006\u0012\u0002\b\u00030\u001cX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001RH\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R8\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001RH\u0010v\u001a\u0018\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0200j\u0002`f\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u00a0\u0001\u0010\u0099\u0001\"\u0006\b\u00a1\u0001\u0010\u009b\u0001\u00a8\u0006\u00a2\u0001"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseLocalVarDecl$LocalVarGet;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl$IGet;", "Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "delegate", "<init>", "(Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;)V", "getDelegate", "()Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "addStmt", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "and", "Lcom/feysh/corax/config/api/IBoolExpr;", "other", "Lcom/feysh/corax/config/api/IIntExpr;", "rhs", "anyOf", "Lcom/feysh/corax/config/api/ILocalValue;", "Lkotlin/UnsafeVariance;", "", "local", "", "Lcom/feysh/corax/config/api/ILocalT;", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "anyOr", "R", "T1", "T2", "second", "check", "expr", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "contains", "Lcom/feysh/corax/config/api/IStringExpr;", "str", "", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "taint", "containsAll", "endsWith", "eq", "eval", "result", "Lkotlin/ParameterName;", "name", "value", "Lcom/feysh/corax/config/api/IExpr;", "", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "Lcom/feysh/corax/config/api/IClassField;", "Lsoot/SootField;", "declaringClass", "Lkotlin/reflect/KClass;", "fieldName", "fieldType", "F", "Lkotlin/reflect/KProperty;", "FieldType", "type", "ge", "getBoolean", "getEnumName", "getInt", "getLong", "Lcom/feysh/corax/config/api/ILongExpr;", "getString", "gt", "hasIntersection", "isInstanceOf", "parentType", "le", "literal", "bool", "int", "long", "", "string", "lshr", "lt", "minus", "V", "set", "single", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "neq", "not", "null", "or", "plus", "shl", "shr", "startsWith", "stringEquals", "taintOf", "([Lcom/feysh/corax/config/api/ITaintType;)Lcom/feysh/corax/config/api/IAttribute;", "types", "", "toLowerCase", "viaOf", "via", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "xor", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "decl", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "getDecl", "()Lcom/feysh/corax/config/api/ILocalVarDecl;", "emptyTaint", "getEmptyTaint", "()Lcom/feysh/corax/config/api/IAttribute;", "emptyVia", "getEmptyVia", "isConstant", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "match", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "getMatch", "()Lcom/feysh/corax/config/api/ILocalVarMatch;", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "getValue", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "getVia", "setVia", "corax-config-api"})
    public static final class LocalVarGet<T>
    implements ILocalVarDecl.IGet<T>,
    ILocalVarDecl.IBuilder<T> {
        @NotNull
        private final ILocalVarDecl.IBuilder<T> delegate;
        @NotNull
        private final IReturnT<T> return;

        public LocalVarGet(@NotNull ILocalVarDecl.IBuilder<T> delegate) {
            Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
            this.delegate = delegate;
            this.return = new Return();
        }

        @NotNull
        public final ILocalVarDecl.IBuilder<T> getDelegate() {
            return this.delegate;
        }

        @Override
        @NotNull
        public IReturnT<T> getReturn() {
            return this.return;
        }

        @Override
        @NotNull
        public ILocalVarDecl<T> getDecl() {
            return this.delegate.getDecl();
        }

        @Override
        @NotNull
        public ILocalVarMatch getMatch() {
            return this.delegate.getMatch();
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.delegate.getConfig();
        }

        @Override
        @NotNull
        public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> $this$subFields) {
            Intrinsics.checkNotNullParameter($this$subFields, (String)"<this>");
            return this.delegate.getSubFields($this$subFields);
        }

        @Override
        @NotNull
        public <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> $this$attr) {
            Intrinsics.checkNotNullParameter($this$attr, (String)"<this>");
            return this.delegate.getAttr($this$attr);
        }

        @Override
        @NotNull
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> $this$taint) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            return this.delegate.getTaint($this$taint);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> $this$taint, @NotNull IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.delegate.setTaint($this$taint, iAttribute);
        }

        @Override
        @NotNull
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> $this$via) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            return this.delegate.getVia($this$via);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> $this$via, @NotNull IAttribute<ViaProperty, Set<IViaType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.delegate.setVia($this$via, iAttribute);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> $this$value) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            return this.delegate.getValue($this$value);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> $this$value, @NotNull ILocalValue<T> iLocalValue) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            Intrinsics.checkNotNullParameter(iLocalValue, (String)"<set-?>");
            this.delegate.setValue($this$value, iLocalValue);
        }

        @Override
        @NotNull
        public IStringExpr literal(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"string");
            return this.delegate.literal(string);
        }

        @Override
        @NotNull
        public IIntExpr literal(int n) {
            return this.delegate.literal(n);
        }

        @Override
        @NotNull
        public ILongExpr literal(long l) {
            return this.delegate.literal(l);
        }

        @Override
        @NotNull
        public IBoolExpr literal(boolean bool) {
            return this.delegate.literal(bool);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isConstant(@NotNull ILocalT<T> $this$isConstant) {
            Intrinsics.checkNotNullParameter($this$isConstant, (String)"<this>");
            return this.delegate.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr isConstant(@NotNull ITypedExpr $this$isConstant) {
            Intrinsics.checkNotNullParameter((Object)$this$isConstant, (String)"<this>");
            return this.delegate.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr not(@NotNull IBoolExpr $this$not) {
            Intrinsics.checkNotNullParameter((Object)$this$not, (String)"<this>");
            return this.delegate.not($this$not);
        }

        @Override
        @NotNull
        public IBoolExpr or(@NotNull IBoolExpr $this$or, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.delegate.or($this$or, other);
        }

        @Override
        @NotNull
        public IIntExpr or(@NotNull IIntExpr $this$or, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.or($this$or, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr and(@NotNull IBoolExpr $this$and, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.delegate.and($this$and, other);
        }

        @Override
        @NotNull
        public IIntExpr and(@NotNull IIntExpr $this$and, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.and($this$and, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr lt(@NotNull IIntExpr $this$lt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.lt($this$lt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr le(@NotNull IIntExpr $this$le, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$le, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.le($this$le, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr eq(@NotNull IIntExpr $this$eq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$eq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.eq($this$eq, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr ge(@NotNull IIntExpr $this$ge, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$ge, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.ge($this$ge, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr gt(@NotNull IIntExpr $this$gt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$gt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.gt($this$gt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr neq(@NotNull IIntExpr $this$neq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$neq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.neq($this$neq, rhs);
        }

        @Override
        @NotNull
        public IIntExpr xor(@NotNull IIntExpr $this$xor, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$xor, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.xor($this$xor, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shl(@NotNull IIntExpr $this$shl, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shl, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.shl($this$shl, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shr(@NotNull IIntExpr $this$shr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.shr($this$shr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr lshr(@NotNull IIntExpr $this$lshr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lshr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.lshr($this$lshr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr plus(@NotNull IIntExpr $this$plus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.plus($this$plus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> $this$plus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.delegate.plus($this$plus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$plus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$plus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IIntExpr minus(@NotNull IIntExpr $this$minus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.minus($this$minus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> $this$minus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.delegate.minus($this$minus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$minus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.minus($this$minus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$minus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.minus($this$minus, single);
        }

        @Override
        @NotNull
        public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> $this$getBoolean) {
            Intrinsics.checkNotNullParameter($this$getBoolean, (String)"<this>");
            return this.delegate.getBoolean($this$getBoolean);
        }

        @Override
        @NotNull
        public <T> IStringExpr getString(@NotNull ILocalT<T> $this$getString) {
            Intrinsics.checkNotNullParameter($this$getString, (String)"<this>");
            return this.delegate.getString($this$getString);
        }

        @Override
        @NotNull
        public <T> IIntExpr getInt(@NotNull ILocalT<T> $this$getInt) {
            Intrinsics.checkNotNullParameter($this$getInt, (String)"<this>");
            return this.delegate.getInt($this$getInt);
        }

        @Override
        @NotNull
        public <T> ILongExpr getLong(@NotNull ILocalT<T> $this$getLong) {
            Intrinsics.checkNotNullParameter($this$getLong, (String)"<this>");
            return this.delegate.getLong($this$getLong);
        }

        @Override
        @NotNull
        public <T> IStringExpr getEnumName(@NotNull ILocalT<T> $this$getEnumName) {
            Intrinsics.checkNotNullParameter($this$getEnumName, (String)"<this>");
            return this.delegate.getEnumName($this$getEnumName);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> $this$isInstanceOf, @NotNull String parentType) {
            Intrinsics.checkNotNullParameter($this$isInstanceOf, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)parentType, (String)"parentType");
            return this.delegate.isInstanceOf($this$isInstanceOf, parentType);
        }

        @Override
        @NotNull
        public IStringExpr toLowerCase(@NotNull IStringExpr $this$toLowerCase) {
            Intrinsics.checkNotNullParameter((Object)$this$toLowerCase, (String)"<this>");
            return this.delegate.toLowerCase($this$toLowerCase);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$contains, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.delegate.contains($this$contains, taint);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return this.delegate.taintOf(type);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            Intrinsics.checkNotNullParameter(types, (String)"types");
            return this.delegate.taintOf(types);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... via) {
            Intrinsics.checkNotNullParameter((Object)via, (String)"via");
            return this.delegate.viaOf(via);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return this.delegate.getEmptyTaint();
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return this.delegate.getEmptyVia();
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> anyOf(ILocalT<T> ... local) {
            Intrinsics.checkNotNullParameter(local, (String)"local");
            return this.delegate.anyOf(local);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> null() {
            return this.delegate.null();
        }

        @Override
        @NotNull
        public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$hasIntersection, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$hasIntersection, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.delegate.hasIntersection($this$hasIntersection, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.delegate.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.delegate.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> $this$anyOr, @NotNull ILocalValue<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.delegate.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> $this$anyOr, @NotNull ILocalT<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.delegate.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.delegate.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull SootField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.delegate.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull IClassField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<? extends F> field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, field, type);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            this.delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.delegate.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter(expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.delegate.check(expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function1<Object, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function1<? super Boolean, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function1<? super String, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function1<? super Integer, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0005J\u0015\u0010\u0011\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JE\u0010\u0016\u001a\r\u0012\t\u0012\u0007H\u0001\u00a2\u0006\u0002\b\u00180\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u00192\u001e\u0010\u001a\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u001b\"\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001\u00a2\u0006\u0002\u0010\u001dJG\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0017\"\b\b\u0002\u0010 *\u0002H\u001f\"\b\b\u0003\u0010!*\u0002H\u001f\"\n\b\u0004\u0010\u001f*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H 0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u001cH\u0096\u0005JG\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0017\"\b\b\u0002\u0010 *\u0002H\u001f\"\b\b\u0003\u0010!*\u0002H\u001f\"\n\b\u0004\u0010\u001f*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H 0\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u0017H\u0096\u0005J8\u0010#\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010&\u001a\u00020'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\u0002\b+H\u0096\u0001J2\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\u0002\b+H\u0096\u0001J\u0015\u0010,\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010,\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J+\u0010,\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u00105\u001a\u000203H\u0096\u0001JA\u00106\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u001c\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4H\u0096\u0001J+\u00106\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u00105\u001a\u000203H\u0096\u0001J\u0015\u00107\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u00107\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J\u0015\u00108\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00122!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020=2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00142!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110>\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J4\u00109\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020-2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000e0)H\u0096\u0001J-\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010?\u001a\u00020AH\u0096\u0001J-\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010?\u001a\u00020BH\u0096\u0001JC\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D2\u0006\u0010E\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010/H\u0096\u0001JA\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\b\u0010C\u001a\u0004\u0018\u00010/2\u0006\u0010E\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010/H\u0096\u0001J?\u0010?\u001a\b\u0012\u0004\u0012\u0002HG0@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\n\b\u0003\u0010G*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002HG0HH\u0096\u0001JI\u0010?\u001a\b\u0012\u0004\u0012\u0002HI0@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010I*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030H2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0DH\u0096\u0001JS\u0010?\u001a\b\u0012\u0004\u0012\u0002HI0@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010I*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010D2\u0006\u0010E\u001a\u00020/2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0DH\u0096\u0001JO\u0010?\u001a\b\u0012\u0004\u0012\u0002HI0@\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019\"\b\b\u0003\u0010I*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\b\u0010C\u001a\u0004\u0018\u00010/2\u0006\u0010E\u001a\u00020/2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0DH\u0096\u0001J\u0015\u0010K\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u001f\u0010L\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010M\u001a\u00020-\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010N\u001a\u00020\u0014\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010O\u001a\u00020P\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u001f\u0010Q\u001a\u00020-\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0096\u0001J\u0015\u0010R\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JA\u0010S\u001a\u00020\u0012*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u001c\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4H\u0096\u0001J'\u0010T\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010U\u001a\u00020/H\u0096\u0001J\u0015\u0010V\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0011\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020%H\u0096\u0001J\u0011\u0010W\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020>H\u0096\u0001J\u0011\u0010W\u001a\u00020P2\u0006\u0010Z\u001a\u00020[H\u0096\u0001J\u0011\u0010W\u001a\u00020-2\u0006\u0010\\\u001a\u00020/H\u0096\u0001J\u0015\u0010]\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010^\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JS\u0010_\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`00\"\b\b\u0002\u0010\u0001*\u00020A\"\u000e\b\u0003\u0010`*\b\u0012\u0004\u0012\u00020\u001902*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`002\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`00H\u0096\u0007JA\u0010_\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u0010b\u001a\u000203H\u0096\u0007JA\u0010_\u001a\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e*\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e2\u0006\u0010b\u001a\u00020dH\u0096\u0007J\u0015\u0010_\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0003J\u0015\u0010f\u001a\u00020\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\r\u0010g\u001a\u00020\u0012*\u00020\u0012H\u0096\u0003J\u001b\u0010h\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019H\u0096\u0001J\u0015\u0010i\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0005J\u0015\u0010i\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005JS\u0010j\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`00\"\b\b\u0002\u0010\u0001*\u00020A\"\u000e\b\u0003\u0010`*\b\u0012\u0004\u0012\u00020\u001902*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`002\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H`00H\u0096\u0007JA\u0010j\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4*\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0006\u0010b\u001a\u000203H\u0096\u0007JA\u0010j\u001a\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e*\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e2\u0006\u0010b\u001a\u00020dH\u0096\u0007J\u0015\u0010j\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0003J\u0015\u0010k\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010l\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005J\u0015\u0010m\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010m\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J\u0015\u0010n\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0015\u0010n\u001a\u00020\u0012*\u00020-2\u0006\u0010.\u001a\u00020/H\u0096\u0001J8\u0010o\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u0002030\u001b\"\u000203H\u0096\u0001\u00a2\u0006\u0002\u0010pJ-\u0010o\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`42\f\u0010q\u001a\b\u0012\u0004\u0012\u0002030rH\u0096\u0001J\r\u0010s\u001a\u00020-*\u00020-H\u0096\u0001J8\u0010t\u001a\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e2\u0012\u0010u\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0\u001b\"\u00020dH\u0096\u0001\u00a2\u0006\u0002\u0010vJ\u0015\u0010w\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0005R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010x\u001a\u00020y\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bz\u0010{R-\u0010|\u001a\u001b\u0012\b\u0012\u00060}j\u0002`~\u0012\u0004\u0012\u00020\u000e0)j\u0002`\u007f\u00a2\u0006\u0002\b+X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0083\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R-\u0010\u0086\u0001\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`48VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R-\u0010\u0089\u0001\u001a\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001a\u0010\u008b\u0001\u001a\u00020\u0012*\u00030\u008c\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008d\u0001R+\u0010\u008b\u0001\u001a\u00020\u0012\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008e\u0001R\u0016\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001e\u0010\u0093\u0001\u001a\u00030\u0094\u0001*\u0006\u0012\u0002\b\u00030\u001cX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001RH\u00105\u001a\u0018\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u0002030200j\u0002`4\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R7\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0017\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u000f\u001a\u0005\b\u000b\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001RH\u0010u\u001a\u0018\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0200j\u0002`e\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u0002H\u00010\u001cX\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u009e\u0001\u0010\u0098\u0001\"\u0006\b\u009f\u0001\u0010\u009a\u0001\u00a8\u0006\u00a0\u0001"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseLocalVarDecl$LocalVarSet;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl$ISet;", "Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "delegate", "<init>", "(Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;)V", "getDelegate", "()Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "value", "Lcom/feysh/corax/config/api/IParameterT;", "getValue", "()Lcom/feysh/corax/config/api/IParameterT;", "addStmt", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "and", "Lcom/feysh/corax/config/api/IBoolExpr;", "other", "Lcom/feysh/corax/config/api/IIntExpr;", "rhs", "anyOf", "Lcom/feysh/corax/config/api/ILocalValue;", "Lkotlin/UnsafeVariance;", "", "local", "", "Lcom/feysh/corax/config/api/ILocalT;", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "anyOr", "R", "T1", "T2", "second", "check", "expr", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "contains", "Lcom/feysh/corax/config/api/IStringExpr;", "str", "", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "taint", "containsAll", "endsWith", "eq", "eval", "result", "Lkotlin/ParameterName;", "name", "Lcom/feysh/corax/config/api/IExpr;", "", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "Lcom/feysh/corax/config/api/IClassField;", "Lsoot/SootField;", "declaringClass", "Lkotlin/reflect/KClass;", "fieldName", "fieldType", "F", "Lkotlin/reflect/KProperty;", "FieldType", "type", "ge", "getBoolean", "getEnumName", "getInt", "getLong", "Lcom/feysh/corax/config/api/ILongExpr;", "getString", "gt", "hasIntersection", "isInstanceOf", "parentType", "le", "literal", "bool", "int", "long", "", "string", "lshr", "lt", "minus", "V", "set", "single", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "neq", "not", "null", "or", "plus", "shl", "shr", "startsWith", "stringEquals", "taintOf", "([Lcom/feysh/corax/config/api/ITaintType;)Lcom/feysh/corax/config/api/IAttribute;", "types", "", "toLowerCase", "viaOf", "via", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "xor", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "decl", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "getDecl", "()Lcom/feysh/corax/config/api/ILocalVarDecl;", "emptyTaint", "getEmptyTaint", "()Lcom/feysh/corax/config/api/IAttribute;", "emptyVia", "getEmptyVia", "isConstant", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "match", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "getMatch", "()Lcom/feysh/corax/config/api/ILocalVarMatch;", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "getVia", "setVia", "corax-config-api"})
    public static final class LocalVarSet<T>
    implements ILocalVarDecl.ISet<T>,
    ILocalVarDecl.IBuilder<T> {
        @NotNull
        private final ILocalVarDecl.IBuilder<T> delegate;
        @NotNull
        private final IParameterT<T> value;

        public LocalVarSet(@NotNull ILocalVarDecl.IBuilder<T> delegate) {
            Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
            this.delegate = delegate;
            this.value = new Parameter(0);
        }

        @NotNull
        public final ILocalVarDecl.IBuilder<T> getDelegate() {
            return this.delegate;
        }

        @Override
        @NotNull
        public IParameterT<T> getValue() {
            return this.value;
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> $this$value) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            return this.delegate.getValue($this$value);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> $this$value, @NotNull ILocalValue<T> iLocalValue) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            Intrinsics.checkNotNullParameter(iLocalValue, (String)"<set-?>");
            this.delegate.setValue($this$value, iLocalValue);
        }

        @Override
        @NotNull
        public ILocalVarDecl<T> getDecl() {
            return this.delegate.getDecl();
        }

        @Override
        @NotNull
        public ILocalVarMatch getMatch() {
            return this.delegate.getMatch();
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.delegate.getConfig();
        }

        @Override
        @NotNull
        public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> $this$subFields) {
            Intrinsics.checkNotNullParameter($this$subFields, (String)"<this>");
            return this.delegate.getSubFields($this$subFields);
        }

        @Override
        @NotNull
        public <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> $this$attr) {
            Intrinsics.checkNotNullParameter($this$attr, (String)"<this>");
            return this.delegate.getAttr($this$attr);
        }

        @Override
        @NotNull
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> $this$taint) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            return this.delegate.getTaint($this$taint);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> $this$taint, @NotNull IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.delegate.setTaint($this$taint, iAttribute);
        }

        @Override
        @NotNull
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> $this$via) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            return this.delegate.getVia($this$via);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> $this$via, @NotNull IAttribute<ViaProperty, Set<IViaType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.delegate.setVia($this$via, iAttribute);
        }

        @Override
        @NotNull
        public IStringExpr literal(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"string");
            return this.delegate.literal(string);
        }

        @Override
        @NotNull
        public IIntExpr literal(int n) {
            return this.delegate.literal(n);
        }

        @Override
        @NotNull
        public ILongExpr literal(long l) {
            return this.delegate.literal(l);
        }

        @Override
        @NotNull
        public IBoolExpr literal(boolean bool) {
            return this.delegate.literal(bool);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isConstant(@NotNull ILocalT<T> $this$isConstant) {
            Intrinsics.checkNotNullParameter($this$isConstant, (String)"<this>");
            return this.delegate.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr isConstant(@NotNull ITypedExpr $this$isConstant) {
            Intrinsics.checkNotNullParameter((Object)$this$isConstant, (String)"<this>");
            return this.delegate.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr not(@NotNull IBoolExpr $this$not) {
            Intrinsics.checkNotNullParameter((Object)$this$not, (String)"<this>");
            return this.delegate.not($this$not);
        }

        @Override
        @NotNull
        public IBoolExpr or(@NotNull IBoolExpr $this$or, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.delegate.or($this$or, other);
        }

        @Override
        @NotNull
        public IIntExpr or(@NotNull IIntExpr $this$or, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.or($this$or, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr and(@NotNull IBoolExpr $this$and, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.delegate.and($this$and, other);
        }

        @Override
        @NotNull
        public IIntExpr and(@NotNull IIntExpr $this$and, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.and($this$and, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr lt(@NotNull IIntExpr $this$lt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.lt($this$lt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr le(@NotNull IIntExpr $this$le, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$le, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.le($this$le, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr eq(@NotNull IIntExpr $this$eq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$eq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.eq($this$eq, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr ge(@NotNull IIntExpr $this$ge, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$ge, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.ge($this$ge, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr gt(@NotNull IIntExpr $this$gt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$gt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.gt($this$gt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr neq(@NotNull IIntExpr $this$neq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$neq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.neq($this$neq, rhs);
        }

        @Override
        @NotNull
        public IIntExpr xor(@NotNull IIntExpr $this$xor, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$xor, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.xor($this$xor, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shl(@NotNull IIntExpr $this$shl, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shl, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.shl($this$shl, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shr(@NotNull IIntExpr $this$shr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.shr($this$shr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr lshr(@NotNull IIntExpr $this$lshr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lshr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.lshr($this$lshr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr plus(@NotNull IIntExpr $this$plus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.plus($this$plus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> $this$plus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.delegate.plus($this$plus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$plus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$plus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IIntExpr minus(@NotNull IIntExpr $this$minus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.delegate.minus($this$minus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> $this$minus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.delegate.minus($this$minus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$minus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.minus($this$minus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$minus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.delegate.minus($this$minus, single);
        }

        @Override
        @NotNull
        public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> $this$getBoolean) {
            Intrinsics.checkNotNullParameter($this$getBoolean, (String)"<this>");
            return this.delegate.getBoolean($this$getBoolean);
        }

        @Override
        @NotNull
        public <T> IStringExpr getString(@NotNull ILocalT<T> $this$getString) {
            Intrinsics.checkNotNullParameter($this$getString, (String)"<this>");
            return this.delegate.getString($this$getString);
        }

        @Override
        @NotNull
        public <T> IIntExpr getInt(@NotNull ILocalT<T> $this$getInt) {
            Intrinsics.checkNotNullParameter($this$getInt, (String)"<this>");
            return this.delegate.getInt($this$getInt);
        }

        @Override
        @NotNull
        public <T> ILongExpr getLong(@NotNull ILocalT<T> $this$getLong) {
            Intrinsics.checkNotNullParameter($this$getLong, (String)"<this>");
            return this.delegate.getLong($this$getLong);
        }

        @Override
        @NotNull
        public <T> IStringExpr getEnumName(@NotNull ILocalT<T> $this$getEnumName) {
            Intrinsics.checkNotNullParameter($this$getEnumName, (String)"<this>");
            return this.delegate.getEnumName($this$getEnumName);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> $this$isInstanceOf, @NotNull String parentType) {
            Intrinsics.checkNotNullParameter($this$isInstanceOf, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)parentType, (String)"parentType");
            return this.delegate.isInstanceOf($this$isInstanceOf, parentType);
        }

        @Override
        @NotNull
        public IStringExpr toLowerCase(@NotNull IStringExpr $this$toLowerCase) {
            Intrinsics.checkNotNullParameter((Object)$this$toLowerCase, (String)"<this>");
            return this.delegate.toLowerCase($this$toLowerCase);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$contains, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.delegate.contains($this$contains, taint);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.delegate.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return this.delegate.taintOf(type);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            Intrinsics.checkNotNullParameter(types, (String)"types");
            return this.delegate.taintOf(types);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... via) {
            Intrinsics.checkNotNullParameter((Object)via, (String)"via");
            return this.delegate.viaOf(via);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return this.delegate.getEmptyTaint();
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return this.delegate.getEmptyVia();
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> anyOf(ILocalT<T> ... local) {
            Intrinsics.checkNotNullParameter(local, (String)"local");
            return this.delegate.anyOf(local);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> null() {
            return this.delegate.null();
        }

        @Override
        @NotNull
        public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$hasIntersection, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$hasIntersection, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.delegate.hasIntersection($this$hasIntersection, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.delegate.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.delegate.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> $this$anyOr, @NotNull ILocalValue<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.delegate.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> $this$anyOr, @NotNull ILocalT<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.delegate.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.delegate.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull SootField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.delegate.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull IClassField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<? extends F> field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            return this.delegate.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.delegate.field($this$field, field, type);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            this.delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.delegate.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter(expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.delegate.check(expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function1<Object, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function1<? super Boolean, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function1<? super String, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function1<? super Integer, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.delegate.eval(expr, result);
        }
    }
}

