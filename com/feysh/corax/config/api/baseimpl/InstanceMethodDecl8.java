/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function9
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIMethodDecl;
import com.feysh.corax.config.api.IIMethodDecl8;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
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
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t*\u0004\b\t\u0010\n2>\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000b2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\fB%\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011Je\u0010\u0014\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0\u00152\u001f\u0010\u0016\u001a\u001b\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a0\u0017j\u0002`\u001c\u00a2\u0006\u0002\b\u001bH\u0016J2\u0010\u001d\u001a\u00020\u001a2'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001a0\u0017H\u0096\u0001R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020)X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020-X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00060"}, d2={"Lcom/feysh/corax/config/api/baseimpl/InstanceMethodDecl8;", "R", "This", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "Lcom/feysh/corax/config/api/IIMethodDecl8;", "Lcom/feysh/corax/config/api/IIMethodDecl;", "base", "argumentCnt", "", "<init>", "(Lcom/feysh/corax/config/api/IIMethodDecl;I)V", "getArgumentCnt", "()Ljava/lang/Integer;", "checkBuilder", "Lcom/feysh/corax/config/api/IIMethodDecl8$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "eachLocalVar", "block", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "", "Lkotlin/ParameterName;", "name", "localVariable", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "match", "Lcom/feysh/corax/config/api/IMethodMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IMethodMatch;", "corax-config-api"})
public final class InstanceMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7>
implements IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7>,
IIMethodDecl<R, This> {
    @NotNull
    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl8(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        Intrinsics.checkNotNullParameter(base, (String)"base");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public /* synthetic */ InstanceMethodDecl8(IIMethodDecl iIMethodDecl, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            n = 8;
        }
        this(iIMethodDecl, n);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return this.argumentCnt;
    }

    @Override
    @NotNull
    public IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7>(this, config){
            private final /* synthetic */ IIMethodDecl.CheckBuilder<R, This> $$delegate_0;
            private final IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> method;
            {
                this.$$delegate_0 = InstanceMethodDecl8.access$getBase$p($receiver).checkBuilder($config);
                this.method = $receiver;
            }

            public IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> getMethod() {
                return this.method;
            }

            public IParameterT<P0> getP0() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP0(this);
            }

            public IParameterT<P1> getP1() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP1(this);
            }

            public IParameterT<P2> getP2() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP2(this);
            }

            public IParameterT<P3> getP3() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP3(this);
            }

            public IParameterT<P4> getP4() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP4(this);
            }

            public IParameterT<P5> getP5() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP5(this);
            }

            public IParameterT<P6> getP6() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP6(this);
            }

            public IParameterT<P7> getP7() {
                return IIMethodDecl8.CheckBuilder.DefaultImpls.getP7(this);
            }

            public IParameterT<This> getThis() {
                return this.$$delegate_0.getThis();
            }

            public Function1<MethodConfig, Unit> getConfig() {
                return this.$$delegate_0.getConfig();
            }

            public ILocalT<Object> getGlobal() {
                return this.$$delegate_0.getGlobal();
            }

            public <T> IParameterT<T> paramAt(int index) {
                return this.$$delegate_0.paramAt(index);
            }

            public IReturnT<R> getReturn() {
                return this.$$delegate_0.getReturn();
            }

            public IWithSubFieldsT getSubFields(ILocalT<?> $this$subFields) {
                Intrinsics.checkNotNullParameter($this$subFields, (String)"<this>");
                return this.$$delegate_0.getSubFields($this$subFields);
            }

            public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> $this$attr) {
                Intrinsics.checkNotNullParameter($this$attr, (String)"<this>");
                return this.$$delegate_0.getAttr($this$attr);
            }

            public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> $this$taint) {
                Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
                return this.$$delegate_0.getTaint($this$taint);
            }

            public <T> void setTaint(ILocalT<T> $this$taint, IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
                Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
                Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
                this.$$delegate_0.setTaint($this$taint, iAttribute);
            }

            public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(ILocalT<T> $this$via) {
                Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
                return this.$$delegate_0.getVia($this$via);
            }

            public <T> void setVia(ILocalT<T> $this$via, IAttribute<ViaProperty, Set<IViaType>> iAttribute) {
                Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
                Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
                this.$$delegate_0.setVia($this$via, iAttribute);
            }

            public <T> ILocalValue<T> getValue(ILocalT<T> $this$value) {
                Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
                return this.$$delegate_0.getValue($this$value);
            }

            public <T> void setValue(ILocalT<T> $this$value, ILocalValue<T> iLocalValue) {
                Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
                Intrinsics.checkNotNullParameter(iLocalValue, (String)"<set-?>");
                this.$$delegate_0.setValue($this$value, iLocalValue);
            }

            public IStringExpr literal(String string) {
                Intrinsics.checkNotNullParameter((Object)string, (String)"string");
                return this.$$delegate_0.literal(string);
            }

            public IIntExpr literal(int n) {
                return this.$$delegate_0.literal(n);
            }

            public ILongExpr literal(long l) {
                return this.$$delegate_0.literal(l);
            }

            public IBoolExpr literal(boolean bool) {
                return this.$$delegate_0.literal(bool);
            }

            public <T> IBoolExpr isConstant(ILocalT<T> $this$isConstant) {
                Intrinsics.checkNotNullParameter($this$isConstant, (String)"<this>");
                return this.$$delegate_0.isConstant($this$isConstant);
            }

            public IBoolExpr isConstant(ITypedExpr $this$isConstant) {
                Intrinsics.checkNotNullParameter((Object)$this$isConstant, (String)"<this>");
                return this.$$delegate_0.isConstant($this$isConstant);
            }

            public IBoolExpr not(IBoolExpr $this$not) {
                Intrinsics.checkNotNullParameter((Object)$this$not, (String)"<this>");
                return this.$$delegate_0.not($this$not);
            }

            public IBoolExpr or(IBoolExpr $this$or, IBoolExpr other) {
                Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)other, (String)"other");
                return this.$$delegate_0.or($this$or, other);
            }

            public IIntExpr or(IIntExpr $this$or, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.or($this$or, rhs);
            }

            public IBoolExpr and(IBoolExpr $this$and, IBoolExpr other) {
                Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)other, (String)"other");
                return this.$$delegate_0.and($this$and, other);
            }

            public IIntExpr and(IIntExpr $this$and, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.and($this$and, rhs);
            }

            public IBoolExpr lt(IIntExpr $this$lt, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$lt, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.lt($this$lt, rhs);
            }

            public IBoolExpr le(IIntExpr $this$le, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$le, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.le($this$le, rhs);
            }

            public IBoolExpr eq(IIntExpr $this$eq, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$eq, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.eq($this$eq, rhs);
            }

            public IBoolExpr ge(IIntExpr $this$ge, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$ge, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.ge($this$ge, rhs);
            }

            public IBoolExpr gt(IIntExpr $this$gt, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$gt, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.gt($this$gt, rhs);
            }

            public IBoolExpr neq(IIntExpr $this$neq, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$neq, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.neq($this$neq, rhs);
            }

            public IIntExpr xor(IIntExpr $this$xor, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$xor, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.xor($this$xor, rhs);
            }

            public IIntExpr shl(IIntExpr $this$shl, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$shl, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.shl($this$shl, rhs);
            }

            public IIntExpr shr(IIntExpr $this$shr, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$shr, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.shr($this$shr, rhs);
            }

            public IIntExpr lshr(IIntExpr $this$lshr, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$lshr, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.lshr($this$lshr, rhs);
            }

            public IIntExpr plus(IIntExpr $this$plus, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.plus($this$plus, rhs);
            }

            public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> plus(IAttribute<T, V> $this$plus, IAttribute<T, V> set) {
                Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
                Intrinsics.checkNotNullParameter(set, (String)"set");
                return this.$$delegate_0.plus($this$plus, set);
            }

            public IAttribute<TaintProperty, Set<ITaintType>> plus(IAttribute<TaintProperty, Set<ITaintType>> $this$plus, ITaintType single) {
                Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return this.$$delegate_0.plus($this$plus, single);
            }

            public IAttribute<ViaProperty, Set<IViaType>> plus(IAttribute<ViaProperty, Set<IViaType>> $this$plus, IViaType single) {
                Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return this.$$delegate_0.plus($this$plus, single);
            }

            public IIntExpr minus(IIntExpr $this$minus, IIntExpr rhs) {
                Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
                return this.$$delegate_0.minus($this$minus, rhs);
            }

            public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> minus(IAttribute<T, V> $this$minus, IAttribute<T, V> set) {
                Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
                Intrinsics.checkNotNullParameter(set, (String)"set");
                return this.$$delegate_0.minus($this$minus, set);
            }

            public IAttribute<TaintProperty, Set<ITaintType>> minus(IAttribute<TaintProperty, Set<ITaintType>> $this$minus, ITaintType single) {
                Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return this.$$delegate_0.minus($this$minus, single);
            }

            public IAttribute<ViaProperty, Set<IViaType>> minus(IAttribute<ViaProperty, Set<IViaType>> $this$minus, IViaType single) {
                Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return this.$$delegate_0.minus($this$minus, single);
            }

            public <T> IBoolExpr getBoolean(ILocalT<T> $this$getBoolean) {
                Intrinsics.checkNotNullParameter($this$getBoolean, (String)"<this>");
                return this.$$delegate_0.getBoolean($this$getBoolean);
            }

            public <T> IStringExpr getString(ILocalT<T> $this$getString) {
                Intrinsics.checkNotNullParameter($this$getString, (String)"<this>");
                return this.$$delegate_0.getString($this$getString);
            }

            public <T> IIntExpr getInt(ILocalT<T> $this$getInt) {
                Intrinsics.checkNotNullParameter($this$getInt, (String)"<this>");
                return this.$$delegate_0.getInt($this$getInt);
            }

            public <T> ILongExpr getLong(ILocalT<T> $this$getLong) {
                Intrinsics.checkNotNullParameter($this$getLong, (String)"<this>");
                return this.$$delegate_0.getLong($this$getLong);
            }

            public <T> IStringExpr getEnumName(ILocalT<T> $this$getEnumName) {
                Intrinsics.checkNotNullParameter($this$getEnumName, (String)"<this>");
                return this.$$delegate_0.getEnumName($this$getEnumName);
            }

            public <T> IBoolExpr isInstanceOf(ILocalT<T> $this$isInstanceOf, String parentType) {
                Intrinsics.checkNotNullParameter($this$isInstanceOf, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)parentType, (String)"parentType");
                return this.$$delegate_0.isInstanceOf($this$isInstanceOf, parentType);
            }

            public IStringExpr toLowerCase(IStringExpr $this$toLowerCase) {
                Intrinsics.checkNotNullParameter((Object)$this$toLowerCase, (String)"<this>");
                return this.$$delegate_0.toLowerCase($this$toLowerCase);
            }

            public IBoolExpr startsWith(IStringExpr $this$startsWith, IStringExpr str) {
                Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.startsWith($this$startsWith, str);
            }

            public IBoolExpr startsWith(IStringExpr $this$startsWith, String str) {
                Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.startsWith($this$startsWith, str);
            }

            public IBoolExpr endsWith(IStringExpr $this$endsWith, IStringExpr str) {
                Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.endsWith($this$endsWith, str);
            }

            public IBoolExpr endsWith(IStringExpr $this$endsWith, String str) {
                Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.endsWith($this$endsWith, str);
            }

            public IBoolExpr contains(IStringExpr $this$contains, IStringExpr str) {
                Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.contains($this$contains, str);
            }

            public IBoolExpr contains(IStringExpr $this$contains, String str) {
                Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.contains($this$contains, str);
            }

            public IBoolExpr contains(IAttribute<TaintProperty, Set<ITaintType>> $this$contains, ITaintType taint) {
                Intrinsics.checkNotNullParameter($this$contains, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return this.$$delegate_0.contains($this$contains, taint);
            }

            public IBoolExpr stringEquals(IStringExpr $this$stringEquals, IStringExpr str) {
                Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.stringEquals($this$stringEquals, str);
            }

            public IBoolExpr stringEquals(IStringExpr $this$stringEquals, String str) {
                Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return this.$$delegate_0.stringEquals($this$stringEquals, str);
            }

            public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return this.$$delegate_0.taintOf(type);
            }

            public IAttribute<TaintProperty, Set<ITaintType>> taintOf(Collection<? extends ITaintType> types) {
                Intrinsics.checkNotNullParameter(types, (String)"types");
                return this.$$delegate_0.taintOf(types);
            }

            public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... via) {
                Intrinsics.checkNotNullParameter((Object)via, (String)"via");
                return this.$$delegate_0.viaOf(via);
            }

            public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
                return this.$$delegate_0.getEmptyTaint();
            }

            public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
                return this.$$delegate_0.getEmptyVia();
            }

            public <T> ILocalValue<T> anyOf(ILocalT<T> ... local) {
                Intrinsics.checkNotNullParameter(local, (String)"local");
                return this.$$delegate_0.anyOf(local);
            }

            public <T> ILocalValue<T> null() {
                return this.$$delegate_0.null();
            }

            public IBoolExpr hasIntersection(IAttribute<TaintProperty, Set<ITaintType>> $this$hasIntersection, IAttribute<TaintProperty, Set<ITaintType>> taint) {
                Intrinsics.checkNotNullParameter($this$hasIntersection, (String)"<this>");
                Intrinsics.checkNotNullParameter(taint, (String)"taint");
                return this.$$delegate_0.hasIntersection($this$hasIntersection, taint);
            }

            public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, ITaintType taint) {
                Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return this.$$delegate_0.containsAll($this$containsAll, taint);
            }

            public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, IAttribute<TaintProperty, Set<ITaintType>> taint) {
                Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
                Intrinsics.checkNotNullParameter(taint, (String)"taint");
                return this.$$delegate_0.containsAll($this$containsAll, taint);
            }

            public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalValue<T1> $this$anyOr, ILocalValue<T2> second) {
                Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return this.$$delegate_0.anyOr($this$anyOr, second);
            }

            public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalT<T1> $this$anyOr, ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return this.$$delegate_0.anyOr($this$anyOr, second);
            }

            public <T> IAccessPathT<Object> field(ILocalT<T> $this$field, String declaringClass, String fieldName, String fieldType) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return this.$$delegate_0.field($this$field, declaringClass, fieldName, fieldType);
            }

            public <T> IAccessPathT<Object> field(ILocalT<T> $this$field, SootField field) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return this.$$delegate_0.field($this$field, field);
            }

            public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> $this$field, String declaringClass, String fieldName, KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return this.$$delegate_0.field($this$field, declaringClass, fieldName, type);
            }

            public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> $this$field, KClass<?> declaringClass, String fieldName, KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return this.$$delegate_0.field($this$field, declaringClass, fieldName, type);
            }

            public <T> IAccessPathT<Object> field(ILocalT<T> $this$field, KClass<?> declaringClass, String fieldName, String fieldType) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return this.$$delegate_0.field($this$field, declaringClass, fieldName, fieldType);
            }

            public <T> IAccessPathT<Object> field(ILocalT<T> $this$field, IClassField field) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return this.$$delegate_0.field($this$field, field);
            }

            public <T, F> IAccessPathT<F> field(ILocalT<T> $this$field, KProperty<? extends F> field) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter(field, (String)"field");
                return this.$$delegate_0.field($this$field, field);
            }

            public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> $this$field, KProperty<?> field, KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
                Intrinsics.checkNotNullParameter(field, (String)"field");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return this.$$delegate_0.field($this$field, field, type);
            }

            public void addStmt(IStmt stmt) {
                Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
                this.$$delegate_0.addStmt(stmt);
            }

            public void check(IBoolExpr expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                this.$$delegate_0.check(expr, checkType, env);
            }

            public void check(ILocalT<Boolean> expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                this.$$delegate_0.check(expr, checkType, env);
            }

            public void eval(IExpr expr, Function1<Object, Unit> result) {
                Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
                Intrinsics.checkNotNullParameter(result, (String)"result");
                this.$$delegate_0.eval(expr, result);
            }

            public void eval(IBoolExpr expr, Function1<? super Boolean, Unit> result) {
                Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
                Intrinsics.checkNotNullParameter(result, (String)"result");
                this.$$delegate_0.eval(expr, result);
            }

            public void eval(IStringExpr expr, Function1<? super String, Unit> result) {
                Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
                Intrinsics.checkNotNullParameter(result, (String)"result");
                this.$$delegate_0.eval(expr, result);
            }

            public void eval(IIntExpr expr, Function1<? super Integer, Unit> result) {
                Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
                Intrinsics.checkNotNullParameter(result, (String)"result");
                this.$$delegate_0.eval(expr, result);
            }
        };
    }

    @Override
    @NotNull
    public IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> model(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function9<? super IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>, Unit> block) {
        return IIMethodDecl8.DefaultImpls.model(this, config, block);
    }

    @Override
    @NotNull
    public IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7>, Unit> block) {
        return IIMethodDecl8.DefaultImpls.modelNoArg(this, config, block);
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return this.base.getMatch();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return this.base.getError();
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return this.base.getActualType();
    }

    @Override
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        this.base.eachLocalVar(block);
    }

    public static final /* synthetic */ IIMethodDecl access$getBase$p(InstanceMethodDecl8 $this) {
        return $this.base;
    }
}

