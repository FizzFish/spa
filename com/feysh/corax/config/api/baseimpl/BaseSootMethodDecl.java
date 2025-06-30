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
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.tagkit.VisibilityParameterAnnotationTag
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
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.ISootMethodDecl;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.SootParameter;
import com.feysh.corax.config.api.baseimpl.SootReturn;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.List;
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
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.tagkit.VisibilityParameterAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00013B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J9\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00002\u001f\u0010\u001d\u001a\u001b\u0012\b\u0012\u00060\u001fj\u0002` \u0012\u0004\u0012\u00020!0\u001ej\u0002`#\u00a2\u0006\u0002\b\"H\u0016J2\u0010$\u001a\u00020!2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020!0\u001eH\u0096\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010+\u001a\u00020,X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00064"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseSootMethodDecl;", "R", "Lcom/feysh/corax/config/api/ISootMethodDecl;", "Lcom/feysh/corax/config/api/IMethodDecl;", "delegate", "clazz", "Lcom/feysh/corax/config/api/ISootClassDecl;", "sootMethod", "Lsoot/SootMethod;", "<init>", "(Lcom/feysh/corax/config/api/IMethodDecl;Lcom/feysh/corax/config/api/ISootClassDecl;Lsoot/SootMethod;)V", "getDelegate", "()Lcom/feysh/corax/config/api/IMethodDecl;", "getClazz", "()Lcom/feysh/corax/config/api/ISootClassDecl;", "getSootMethod", "()Lsoot/SootMethod;", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "argumentCnt", "", "getArgumentCnt", "()Ljava/lang/Integer;", "toString", "", "checkBuilder", "Lcom/feysh/corax/config/api/baseimpl/BaseSootMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "eachLocalVar", "block", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "", "Lkotlin/ParameterName;", "name", "localVariable", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "match", "Lcom/feysh/corax/config/api/IMethodMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IMethodMatch;", "CheckBuilder", "corax-config-api"})
public final class BaseSootMethodDecl<R>
implements ISootMethodDecl<R>,
IMethodDecl<R> {
    @NotNull
    private final IMethodDecl<R> delegate;
    @NotNull
    private final ISootClassDecl clazz;
    @NotNull
    private final SootMethod sootMethod;

    public BaseSootMethodDecl(@NotNull IMethodDecl<R> delegate, @NotNull ISootClassDecl clazz, @NotNull SootMethod sootMethod) {
        Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        this.delegate = delegate;
        this.clazz = clazz;
        this.sootMethod = sootMethod;
    }

    @NotNull
    public final IMethodDecl<R> getDelegate() {
        return this.delegate;
    }

    @Override
    @NotNull
    public ISootClassDecl getClazz() {
        return this.clazz;
    }

    @Override
    @NotNull
    public SootMethod getSootMethod() {
        return this.sootMethod;
    }

    @Override
    @NotNull
    public KFunctionType getActualType() {
        return UtilsKt.getFunctionType(this.getSootMethod());
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return this.getSootMethod().getParameterCount();
    }

    @NotNull
    public String toString() {
        return "soot decl: " + this.getSootMethod();
    }

    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new CheckBuilder<R>(this, this.delegate.checkBuilder(config));
    }

    @Override
    @NotNull
    public SootClass getSootClass() {
        return ISootMethodDecl.DefaultImpls.getSootClass(this);
    }

    @Override
    @Nullable
    public VisibilityParameterAnnotationTag getParameterAnnotationTag() {
        return ISootMethodDecl.DefaultImpls.getParameterAnnotationTag(this);
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull IParameterT<?> $this$visibilityAnnotationTag) {
        return ISootMethodDecl.DefaultImpls.getVisibilityAnnotationTag(this, $this$visibilityAnnotationTag);
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return ISootMethodDecl.DefaultImpls.getVisibilityAnnotationTag(this);
    }

    @Override
    @NotNull
    public List<AnnotationTag> getAnnotationTag(@NotNull IParameterT<?> $this$annotationTag) {
        return ISootMethodDecl.DefaultImpls.getAnnotationTag(this, $this$annotationTag);
    }

    @Override
    @Nullable
    public AnnotationTag getAnnotationTag() {
        return ISootMethodDecl.DefaultImpls.getAnnotationTag(this);
    }

    @Override
    @NotNull
    public List<Tag> getTags() {
        return ISootMethodDecl.DefaultImpls.getTags(this);
    }

    @Override
    @NotNull
    public ISootMethodDecl<R> model(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super ISootMethodDecl.CheckBuilder<R>, ? super IParameterT<Object>[], Unit> block) {
        return ISootMethodDecl.DefaultImpls.model(this, config, block);
    }

    @Override
    @NotNull
    public ISootMethodDecl<R> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super ISootMethodDecl.CheckBuilder<R>, Unit> block) {
        return ISootMethodDecl.DefaultImpls.modelNoArg(this, config, block);
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return this.delegate.getMatch();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return this.delegate.getError();
    }

    @Override
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        this.delegate.eachLocalVar(block);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0002\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0005J\u0015\u0010\u0018\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005JE\u0010\u001d\u001a\r\u0012\t\u0012\u0007H\r\u00a2\u0006\u0002\b\u001f0\u001e\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 2\u001e\u0010!\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\r0#0\"\"\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001\u00a2\u0006\u0002\u0010$JG\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001e\"\b\b\u0002\u0010&*\u0002H\u0001\"\b\b\u0003\u0010'*\u0002H\u0001\"\n\b\u0004\u0010\u0001*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H&0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0#H\u0096\u0005JG\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001e\"\b\b\u0002\u0010&*\u0002H\u0001\"\b\b\u0003\u0010'*\u0002H\u0001\"\n\b\u0004\u0010\u0001*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H&0\u001e2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u001eH\u0096\u0005J8\u0010)\u001a\u00020\u00152\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0#2\u0006\u0010,\u001a\u00020-2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00150/\u00a2\u0006\u0002\b1H\u0096\u0001J2\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00150/\u00a2\u0006\u0002\b1H\u0096\u0001J\u0015\u00102\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000203H\u0096\u0001J\u0015\u00102\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000205H\u0096\u0001J+\u00102\u001a\u00020\u0019*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u0006\u0010;\u001a\u000209H\u0096\u0001JA\u0010<\u001a\u00020\u0019*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:H\u0096\u0001J+\u0010<\u001a\u00020\u0019*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u0006\u0010;\u001a\u000209H\u0096\u0001J\u0015\u0010=\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000203H\u0096\u0001J\u0015\u0010=\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000205H\u0096\u0001J\u0015\u0010>\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J4\u0010?\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00192!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110+\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00150/H\u0096\u0001J4\u0010?\u001a\u00020\u00152\u0006\u0010*\u001a\u00020D2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110 \u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00150/H\u0096\u0001J4\u0010?\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001b2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00150/H\u0096\u0001J4\u0010?\u001a\u00020\u00152\u0006\u0010*\u001a\u0002032!\u0010@\u001a\u001d\u0012\u0013\u0012\u001105\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00150/H\u0096\u0001J-\u0010E\u001a\b\u0012\u0004\u0012\u00020 0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\u0006\u0010E\u001a\u00020GH\u0096\u0001J-\u0010E\u001a\b\u0012\u0004\u0012\u00020 0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\u0006\u0010E\u001a\u00020HH\u0096\u0001JC\u0010E\u001a\b\u0012\u0004\u0012\u00020 0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\u0006\u0010K\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u000105H\u0096\u0001JA\u0010E\u001a\b\u0012\u0004\u0012\u00020 0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\b\u0010I\u001a\u0004\u0018\u0001052\u0006\u0010K\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u000105H\u0096\u0001J?\u0010E\u001a\b\u0012\u0004\u0012\u0002HM0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 \"\n\b\u0003\u0010M*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HM0NH\u0096\u0001JI\u0010E\u001a\b\u0012\u0004\u0012\u0002HO0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 \"\b\b\u0003\u0010O*\u00020 *\b\u0012\u0004\u0012\u0002H\r0#2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030N2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0JH\u0096\u0001JS\u0010E\u001a\b\u0012\u0004\u0012\u0002HO0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 \"\b\b\u0003\u0010O*\u00020 *\b\u0012\u0004\u0012\u0002H\r0#2\f\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010J2\u0006\u0010K\u001a\u0002052\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0JH\u0096\u0001JO\u0010E\u001a\b\u0012\u0004\u0012\u0002HO0F\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 \"\b\b\u0003\u0010O*\u00020 *\b\u0012\u0004\u0012\u0002H\r0#2\b\u0010I\u001a\u0004\u0018\u0001052\u0006\u0010K\u001a\u0002052\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0JH\u0096\u0001J\u0015\u0010Q\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\u001f\u0010R\u001a\u00020\u0019\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001J\u001f\u0010S\u001a\u000203\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001J\u001f\u0010T\u001a\u00020\u001b\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001J\u001f\u0010U\u001a\u00020V\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001J\u001f\u0010W\u001a\u000203\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#H\u0096\u0001J\u0015\u0010X\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005JA\u0010Y\u001a\u00020\u0019*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:H\u0096\u0001J'\u0010Z\u001a\u00020\u0019\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#2\u0006\u0010[\u001a\u000205H\u0096\u0001J\u0015\u0010\\\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\u0011\u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020+H\u0096\u0001J\u0011\u0010]\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010]\u001a\u00020V2\u0006\u0010`\u001a\u00020aH\u0096\u0001J\u0011\u0010]\u001a\u0002032\u0006\u0010b\u001a\u000205H\u0096\u0001J\u0015\u0010c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\u0015\u0010d\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005JS\u0010e\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf06\"\b\b\u0002\u0010\r*\u00020G\"\u000e\b\u0003\u0010f*\b\u0012\u0004\u0012\u00020 08*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf062\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf06H\u0096\u0007JA\u0010e\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u0006\u0010h\u001a\u000209H\u0096\u0007JA\u0010e\u001a\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k*\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k2\u0006\u0010h\u001a\u00020jH\u0096\u0007J\u0015\u0010e\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0003J\u0015\u0010l\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\r\u0010m\u001a\u00020\u0019*\u00020\u0019H\u0096\u0003J\u001b\u0010n\u001a\b\u0012\u0004\u0012\u0002H\r0\u001e\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 H\u0096\u0001J\u0015\u0010o\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0005J\u0015\u0010o\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005JS\u0010p\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf06\"\b\b\u0002\u0010\r*\u00020G\"\u000e\b\u0003\u0010f*\b\u0012\u0004\u0012\u00020 08*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf062\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002Hf06H\u0096\u0007JA\u0010p\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:*\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u0006\u0010h\u001a\u000209H\u0096\u0007JA\u0010p\u001a\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k*\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k2\u0006\u0010h\u001a\u00020jH\u0096\u0007J\u0015\u0010p\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0003J\u0015\u0010q\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\u0015\u0010r\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005J\u0015\u0010s\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000203H\u0096\u0001J\u0015\u0010s\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000205H\u0096\u0001J\u0015\u0010t\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000203H\u0096\u0001J\u0015\u0010t\u001a\u00020\u0019*\u0002032\u0006\u00104\u001a\u000205H\u0096\u0001J8\u0010u\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\"\"\u000209H\u0096\u0001\u00a2\u0006\u0002\u0010vJ-\u0010u\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:2\f\u0010w\u001a\b\u0012\u0004\u0012\u0002090xH\u0096\u0001J\r\u0010y\u001a\u000203*\u000203H\u0096\u0001J8\u0010z\u001a\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k2\u0012\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020j0\"\"\u00020jH\u0096\u0001\u00a2\u0006\u0002\u0010|J\u0015\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0005R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010~\u001a\u00020\u007f\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R1\u0010\u0082\u0001\u001a\u001e\u0012\n\u0012\b0\u0083\u0001j\u0003`\u0084\u0001\u0012\u0004\u0012\u00020\u00150/j\u0003`\u0085\u0001\u00a2\u0006\u0002\b1X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R-\u0010\u0088\u0001\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R-\u0010\u008b\u0001\u001a\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008a\u0001R\u001b\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020 0#X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0090\u0001\u001a\u00020\u0019*\u00030\u0091\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0092\u0001R+\u0010\u0090\u0001\u001a\u00020\u0019\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0093\u0001R\u001e\u0010\u0094\u0001\u001a\u00030\u0095\u0001*\u0006\u0012\u0002\b\u00030#X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001RH\u0010;\u001a\u0018\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u0002090806j\u0002`:\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R8\u0010C\u001a\b\u0012\u0004\u0012\u0002H\r0\u001e\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001RH\u0010{\u001a\u0018\u0012\u0004\u0012\u00020i\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0806j\u0002`k\"\n\b\u0002\u0010\r*\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u0002H\r0#X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u00a0\u0001\u0010\u0099\u0001\"\u0006\b\u00a1\u0001\u0010\u009b\u0001\u00a8\u0006\u00a2\u0001"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BaseSootMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/ISootMethodDecl$CheckBuilder;", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/ISootMethodDecl;", "delegate", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/BaseSootMethodDecl;Lcom/feysh/corax/config/api/ISootMethodDecl;Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;)V", "getMethod", "()Lcom/feysh/corax/config/api/ISootMethodDecl;", "paramAt", "Lcom/feysh/corax/config/api/baseimpl/SootParameter;", "T", "index", "", "return", "Lcom/feysh/corax/config/api/baseimpl/SootReturn;", "getReturn", "()Lcom/feysh/corax/config/api/baseimpl/SootReturn;", "addStmt", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "and", "Lcom/feysh/corax/config/api/IBoolExpr;", "other", "Lcom/feysh/corax/config/api/IIntExpr;", "rhs", "anyOf", "Lcom/feysh/corax/config/api/ILocalValue;", "Lkotlin/UnsafeVariance;", "", "local", "", "Lcom/feysh/corax/config/api/ILocalT;", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "anyOr", "T1", "T2", "second", "check", "expr", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "contains", "Lcom/feysh/corax/config/api/IStringExpr;", "str", "", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "taint", "containsAll", "endsWith", "eq", "eval", "result", "Lkotlin/ParameterName;", "name", "value", "Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "Lcom/feysh/corax/config/api/IClassField;", "Lsoot/SootField;", "declaringClass", "Lkotlin/reflect/KClass;", "fieldName", "fieldType", "F", "Lkotlin/reflect/KProperty;", "FieldType", "type", "ge", "getBoolean", "getEnumName", "getInt", "getLong", "Lcom/feysh/corax/config/api/ILongExpr;", "getString", "gt", "hasIntersection", "isInstanceOf", "parentType", "le", "literal", "bool", "int", "long", "", "string", "lshr", "lt", "minus", "V", "set", "single", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "neq", "not", "null", "or", "plus", "shl", "shr", "startsWith", "stringEquals", "taintOf", "([Lcom/feysh/corax/config/api/ITaintType;)Lcom/feysh/corax/config/api/IAttribute;", "types", "", "toLowerCase", "viaOf", "via", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "xor", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "emptyTaint", "getEmptyTaint", "()Lcom/feysh/corax/config/api/IAttribute;", "emptyVia", "getEmptyVia", "global", "getGlobal", "()Lcom/feysh/corax/config/api/ILocalT;", "isConstant", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "getValue", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "getVia", "setVia", "corax-config-api"})
    public final class CheckBuilder<R>
    implements ISootMethodDecl.CheckBuilder<R>,
    IMethodDecl.CheckBuilder<R> {
        private final /* synthetic */ IMethodDecl.CheckBuilder<R> $$delegate_0;
        @NotNull
        private final ISootMethodDecl<R> method;
        @NotNull
        private final SootReturn<R> return;

        public CheckBuilder(@NotNull ISootMethodDecl<R> method, IMethodDecl.CheckBuilder<R> delegate) {
            Intrinsics.checkNotNullParameter(method, (String)"method");
            Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
            this.$$delegate_0 = delegate;
            this.method = method;
            this.return = new SootReturn(BaseSootMethodDecl.this.getSootMethod());
        }

        @Override
        @NotNull
        public ISootMethodDecl<R> getMethod() {
            return this.method;
        }

        @Override
        @NotNull
        public <T> SootParameter<T> paramAt(int index) {
            int argumentCnt = BaseSootMethodDecl.this.getArgumentCnt();
            if (index >= argumentCnt) {
                BaseSootMethodDecl.this.getError().error("parameter index \"" + index + "\" out of range. argument count is " + argumentCnt + " of method: " + BaseSootMethodDecl.this.getSootMethod() + ".");
            }
            return new SootParameter(index, BaseSootMethodDecl.this.getSootMethod());
        }

        @Override
        @NotNull
        public SootReturn<R> getReturn() {
            return this.return;
        }

        @Override
        @NotNull
        public SootParameter<Object> getThis() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getThis(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP0() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP1() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP1(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP2() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP2(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP3() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP3(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP4() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP4(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP5() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP5(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP6() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP6(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP7() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP7(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP8() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP8(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP9() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP9(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP10() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP10(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP11() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP11(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP12() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP12(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP13() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP13(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP14() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP14(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> getP15() {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.getP15(this);
        }

        @Override
        @NotNull
        public SootParameter<Object> parameter(int index) {
            return ISootMethodDecl.CheckBuilder.DefaultImpls.parameter(this, index);
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.$$delegate_0.getConfig();
        }

        @Override
        @NotNull
        public ILocalT<Object> getGlobal() {
            return this.$$delegate_0.getGlobal();
        }

        @Override
        @NotNull
        public IWithSubFieldsT getSubFields(@NotNull ILocalT<?> $this$subFields) {
            Intrinsics.checkNotNullParameter($this$subFields, (String)"<this>");
            return this.$$delegate_0.getSubFields($this$subFields);
        }

        @Override
        @NotNull
        public <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> $this$attr) {
            Intrinsics.checkNotNullParameter($this$attr, (String)"<this>");
            return this.$$delegate_0.getAttr($this$attr);
        }

        @Override
        @NotNull
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> $this$taint) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            return this.$$delegate_0.getTaint($this$taint);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> $this$taint, @NotNull IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$taint, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.$$delegate_0.setTaint($this$taint, iAttribute);
        }

        @Override
        @NotNull
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> $this$via) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            return this.$$delegate_0.getVia($this$via);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> $this$via, @NotNull IAttribute<ViaProperty, Set<IViaType>> iAttribute) {
            Intrinsics.checkNotNullParameter($this$via, (String)"<this>");
            Intrinsics.checkNotNullParameter(iAttribute, (String)"<set-?>");
            this.$$delegate_0.setVia($this$via, iAttribute);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> getValue(@NotNull ILocalT<T> $this$value) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            return this.$$delegate_0.getValue($this$value);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> $this$value, @NotNull ILocalValue<T> iLocalValue) {
            Intrinsics.checkNotNullParameter($this$value, (String)"<this>");
            Intrinsics.checkNotNullParameter(iLocalValue, (String)"<set-?>");
            this.$$delegate_0.setValue($this$value, iLocalValue);
        }

        @Override
        @NotNull
        public IStringExpr literal(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"string");
            return this.$$delegate_0.literal(string);
        }

        @Override
        @NotNull
        public IIntExpr literal(int n) {
            return this.$$delegate_0.literal(n);
        }

        @Override
        @NotNull
        public ILongExpr literal(long l) {
            return this.$$delegate_0.literal(l);
        }

        @Override
        @NotNull
        public IBoolExpr literal(boolean bool) {
            return this.$$delegate_0.literal(bool);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isConstant(@NotNull ILocalT<T> $this$isConstant) {
            Intrinsics.checkNotNullParameter($this$isConstant, (String)"<this>");
            return this.$$delegate_0.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr isConstant(@NotNull ITypedExpr $this$isConstant) {
            Intrinsics.checkNotNullParameter((Object)$this$isConstant, (String)"<this>");
            return this.$$delegate_0.isConstant($this$isConstant);
        }

        @Override
        @NotNull
        public IBoolExpr not(@NotNull IBoolExpr $this$not) {
            Intrinsics.checkNotNullParameter((Object)$this$not, (String)"<this>");
            return this.$$delegate_0.not($this$not);
        }

        @Override
        @NotNull
        public IBoolExpr or(@NotNull IBoolExpr $this$or, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.$$delegate_0.or($this$or, other);
        }

        @Override
        @NotNull
        public IIntExpr or(@NotNull IIntExpr $this$or, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$or, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.or($this$or, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr and(@NotNull IBoolExpr $this$and, @NotNull IBoolExpr other) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return this.$$delegate_0.and($this$and, other);
        }

        @Override
        @NotNull
        public IIntExpr and(@NotNull IIntExpr $this$and, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$and, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.and($this$and, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr lt(@NotNull IIntExpr $this$lt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.lt($this$lt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr le(@NotNull IIntExpr $this$le, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$le, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.le($this$le, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr eq(@NotNull IIntExpr $this$eq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$eq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.eq($this$eq, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr ge(@NotNull IIntExpr $this$ge, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$ge, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.ge($this$ge, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr gt(@NotNull IIntExpr $this$gt, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$gt, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.gt($this$gt, rhs);
        }

        @Override
        @NotNull
        public IBoolExpr neq(@NotNull IIntExpr $this$neq, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$neq, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.neq($this$neq, rhs);
        }

        @Override
        @NotNull
        public IIntExpr xor(@NotNull IIntExpr $this$xor, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$xor, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.xor($this$xor, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shl(@NotNull IIntExpr $this$shl, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shl, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.shl($this$shl, rhs);
        }

        @Override
        @NotNull
        public IIntExpr shr(@NotNull IIntExpr $this$shr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$shr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.shr($this$shr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr lshr(@NotNull IIntExpr $this$lshr, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$lshr, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.lshr($this$lshr, rhs);
        }

        @Override
        @NotNull
        public IIntExpr plus(@NotNull IIntExpr $this$plus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.plus($this$plus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> $this$plus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.$$delegate_0.plus($this$plus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$plus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.$$delegate_0.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$plus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.$$delegate_0.plus($this$plus, single);
        }

        @Override
        @NotNull
        public IIntExpr minus(@NotNull IIntExpr $this$minus, @NotNull IIntExpr rhs) {
            Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
            return this.$$delegate_0.minus($this$minus, rhs);
        }

        @Override
        @NotNull
        public <T extends IClassField, V extends Set<? extends Object>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> $this$minus, @NotNull IAttribute<T, V> set) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter(set, (String)"set");
            return this.$$delegate_0.minus($this$minus, set);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$minus, @NotNull ITaintType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.$$delegate_0.minus($this$minus, single);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> $this$minus, @NotNull IViaType single) {
            Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)single, (String)"single");
            return this.$$delegate_0.minus($this$minus, single);
        }

        @Override
        @NotNull
        public <T> IBoolExpr getBoolean(@NotNull ILocalT<T> $this$getBoolean) {
            Intrinsics.checkNotNullParameter($this$getBoolean, (String)"<this>");
            return this.$$delegate_0.getBoolean($this$getBoolean);
        }

        @Override
        @NotNull
        public <T> IStringExpr getString(@NotNull ILocalT<T> $this$getString) {
            Intrinsics.checkNotNullParameter($this$getString, (String)"<this>");
            return this.$$delegate_0.getString($this$getString);
        }

        @Override
        @NotNull
        public <T> IIntExpr getInt(@NotNull ILocalT<T> $this$getInt) {
            Intrinsics.checkNotNullParameter($this$getInt, (String)"<this>");
            return this.$$delegate_0.getInt($this$getInt);
        }

        @Override
        @NotNull
        public <T> ILongExpr getLong(@NotNull ILocalT<T> $this$getLong) {
            Intrinsics.checkNotNullParameter($this$getLong, (String)"<this>");
            return this.$$delegate_0.getLong($this$getLong);
        }

        @Override
        @NotNull
        public <T> IStringExpr getEnumName(@NotNull ILocalT<T> $this$getEnumName) {
            Intrinsics.checkNotNullParameter($this$getEnumName, (String)"<this>");
            return this.$$delegate_0.getEnumName($this$getEnumName);
        }

        @Override
        @NotNull
        public <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> $this$isInstanceOf, @NotNull String parentType) {
            Intrinsics.checkNotNullParameter($this$isInstanceOf, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)parentType, (String)"parentType");
            return this.$$delegate_0.isInstanceOf($this$isInstanceOf, parentType);
        }

        @Override
        @NotNull
        public IStringExpr toLowerCase(@NotNull IStringExpr $this$toLowerCase) {
            Intrinsics.checkNotNullParameter((Object)$this$toLowerCase, (String)"<this>");
            return this.$$delegate_0.toLowerCase($this$toLowerCase);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr startsWith(@NotNull IStringExpr $this$startsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$startsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.startsWith($this$startsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr endsWith(@NotNull IStringExpr $this$endsWith, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$endsWith, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.endsWith($this$endsWith, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IStringExpr $this$contains, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.contains($this$contains, str);
        }

        @Override
        @NotNull
        public IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$contains, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$contains, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.$$delegate_0.contains($this$contains, taint);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull IStringExpr str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IBoolExpr stringEquals(@NotNull IStringExpr $this$stringEquals, @NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)$this$stringEquals, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            return this.$$delegate_0.stringEquals($this$stringEquals, str);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType ... type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return this.$$delegate_0.taintOf(type);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            Intrinsics.checkNotNullParameter(types, (String)"types");
            return this.$$delegate_0.taintOf(types);
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType ... via) {
            Intrinsics.checkNotNullParameter((Object)via, (String)"via");
            return this.$$delegate_0.viaOf(via);
        }

        @Override
        @NotNull
        public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return this.$$delegate_0.getEmptyTaint();
        }

        @Override
        @NotNull
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return this.$$delegate_0.getEmptyVia();
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> anyOf(ILocalT<T> ... local) {
            Intrinsics.checkNotNullParameter(local, (String)"local");
            return this.$$delegate_0.anyOf(local);
        }

        @Override
        @NotNull
        public <T> ILocalValue<T> null() {
            return this.$$delegate_0.null();
        }

        @Override
        @NotNull
        public IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$hasIntersection, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$hasIntersection, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.$$delegate_0.hasIntersection($this$hasIntersection, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull ITaintType taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
            return this.$$delegate_0.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> $this$containsAll, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            Intrinsics.checkNotNullParameter($this$containsAll, (String)"<this>");
            Intrinsics.checkNotNullParameter(taint, (String)"taint");
            return this.$$delegate_0.containsAll($this$containsAll, taint);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> $this$anyOr, @NotNull ILocalValue<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.$$delegate_0.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> $this$anyOr, @NotNull ILocalT<T2> second) {
            Intrinsics.checkNotNullParameter($this$anyOr, (String)"<this>");
            Intrinsics.checkNotNullParameter(second, (String)"second");
            return this.$$delegate_0.anyOr($this$anyOr, second);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.$$delegate_0.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull SootField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.$$delegate_0.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.$$delegate_0.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.$$delegate_0.field($this$field, declaringClass, fieldName, type);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            return this.$$delegate_0.field($this$field, declaringClass, fieldName, fieldType);
        }

        @Override
        @NotNull
        public <T> IAccessPathT<Object> field(@NotNull ILocalT<T> $this$field, @NotNull IClassField field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            return this.$$delegate_0.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<? extends F> field) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            return this.$$delegate_0.field($this$field, field);
        }

        @Override
        @NotNull
        public <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> $this$field, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type) {
            Intrinsics.checkNotNullParameter($this$field, (String)"<this>");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            Intrinsics.checkNotNullParameter(type, (String)"type");
            return this.$$delegate_0.field($this$field, field, type);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
            this.$$delegate_0.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.$$delegate_0.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter(expr, (String)"expr");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            this.$$delegate_0.check(expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function1<Object, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.$$delegate_0.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function1<? super Boolean, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.$$delegate_0.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function1<? super String, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.$$delegate_0.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function1<? super Integer, Unit> result) {
            Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
            Intrinsics.checkNotNullParameter(result, (String)"result");
            this.$$delegate_0.eval(expr, result);
        }
    }
}

