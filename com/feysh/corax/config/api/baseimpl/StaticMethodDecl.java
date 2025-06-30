/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
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
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.ISMethodDecl;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u001f\u0010\t\u001a\u001b\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\nj\u0002`\u000f\u00a2\u0006\u0002\b\u000eH\u0016J2\u0010\u0010\u001a\u00020\r2'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\nH\u0096\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006("}, d2={"Lcom/feysh/corax/config/api/baseimpl/StaticMethodDecl;", "R", "Lcom/feysh/corax/config/api/IMethodDecl;", "Lcom/feysh/corax/config/api/ISMethodDecl;", "delegate", "<init>", "(Lcom/feysh/corax/config/api/IMethodDecl;)V", "checkBuilder", "Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "eachLocalVar", "block", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "", "Lkotlin/ParameterName;", "name", "localVariable", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "argumentCnt", "", "getArgumentCnt", "()Ljava/lang/Integer;", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "match", "Lcom/feysh/corax/config/api/IMethodMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IMethodMatch;", "CheckBuilder", "corax-config-api"})
public final class StaticMethodDecl<R>
implements IMethodDecl<R>,
ISMethodDecl<R> {
    @NotNull
    private final IMethodDecl<R> delegate;

    public StaticMethodDecl(@NotNull IMethodDecl<R> delegate) {
        Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
        this.delegate = delegate;
    }

    @Override
    @NotNull
    public ISMethodDecl.CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new CheckBuilder<R>(this.delegate.checkBuilder(config));
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
    @Nullable
    public Integer getArgumentCnt() {
        return this.delegate.getArgumentCnt();
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return this.delegate.getActualType();
    }

    @Override
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        this.delegate.eachLocalVar(block);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0005J\u0015\u0010\u000b\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005JE\u0010\u0010\u001a\r\u0012\t\u0012\u0007H\u0012\u00a2\u0006\u0002\b\u00130\u0011\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u00142\u001e\u0010\u0015\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00170\u0016\"\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001\u00a2\u0006\u0002\u0010\u0018JG\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\b\b\u0002\u0010\u001a*\u0002H\u0001\"\b\b\u0003\u0010\u001b*\u0002H\u0001\"\n\b\u0004\u0010\u0001*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u001a0\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0017H\u0096\u0005JG\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\b\b\u0002\u0010\u001a*\u0002H\u0001\"\b\b\u0003\u0010\u001b*\u0002H\u0001\"\n\b\u0004\u0010\u0001*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u001a0\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0011H\u0096\u0005J8\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\u0006\u0010 \u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0#\u00a2\u0006\u0002\b%H\u0096\u0001J2\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0#\u00a2\u0006\u0002\b%H\u0096\u0001J\u0015\u0010&\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020'H\u0096\u0001J\u0015\u0010&\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001J+\u0010&\u001a\u00020\f*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u0006\u0010/\u001a\u00020-H\u0096\u0001JA\u00100\u001a\u00020\f*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u001c\u0010/\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.H\u0096\u0001J+\u00100\u001a\u00020\f*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u0006\u0010/\u001a\u00020-H\u0096\u0001J\u0015\u00101\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020'H\u0096\u0001J\u0015\u00101\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001J\u0015\u00102\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J4\u00103\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\f2!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b0#H\u0096\u0001J4\u00103\u001a\u00020\b2\u0006\u0010\u001e\u001a\u0002082!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b0#H\u0096\u0001J4\u00103\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000e2!\u00104\u001a\u001d\u0012\u0013\u0012\u001109\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b0#H\u0096\u0001J4\u00103\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020'2!\u00104\u001a\u001d\u0012\u0013\u0012\u00110)\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b0#H\u0096\u0001J-\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\u0006\u0010:\u001a\u00020<H\u0096\u0001J-\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\u0006\u0010:\u001a\u00020=H\u0096\u0001JC\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010@\u001a\u00020)2\b\u0010A\u001a\u0004\u0018\u00010)H\u0096\u0001JA\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\b\u0010>\u001a\u0004\u0018\u00010)2\u0006\u0010@\u001a\u00020)2\b\u0010A\u001a\u0004\u0018\u00010)H\u0096\u0001J?\u0010:\u001a\b\u0012\u0004\u0012\u0002HB0;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014\"\n\b\u0003\u0010B*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\f\u0010:\u001a\b\u0012\u0004\u0012\u0002HB0CH\u0096\u0001JI\u0010:\u001a\b\u0012\u0004\u0012\u0002HD0;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014\"\b\b\u0003\u0010D*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\n\u0010:\u001a\u0006\u0012\u0002\b\u00030C2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HD0?H\u0096\u0001JS\u0010:\u001a\b\u0012\u0004\u0012\u0002HD0;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014\"\b\b\u0003\u0010D*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\f\u0010>\u001a\b\u0012\u0002\b\u0003\u0018\u00010?2\u0006\u0010@\u001a\u00020)2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HD0?H\u0096\u0001JO\u0010:\u001a\b\u0012\u0004\u0012\u0002HD0;\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014\"\b\b\u0003\u0010D*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\b\u0010>\u001a\u0004\u0018\u00010)2\u0006\u0010@\u001a\u00020)2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HD0?H\u0096\u0001J\u0015\u0010F\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\u001f\u0010G\u001a\u00020\f\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001J\u001f\u0010H\u001a\u00020'\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001J\u001f\u0010I\u001a\u00020\u000e\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001J\u001f\u0010J\u001a\u00020K\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001J\u001f\u0010L\u001a\u00020'\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0001J\u0015\u0010M\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005JA\u0010N\u001a\u00020\f*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u001c\u0010/\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.H\u0096\u0001J'\u0010O\u001a\u00020\f\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u00172\u0006\u0010P\u001a\u00020)H\u0096\u0001J\u0015\u0010Q\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\u0011\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010R\u001a\u00020\u000e2\u0006\u0010T\u001a\u000209H\u0096\u0001J\u0011\u0010R\u001a\u00020K2\u0006\u0010U\u001a\u00020VH\u0096\u0001J\u0011\u0010R\u001a\u00020'2\u0006\u0010W\u001a\u00020)H\u0096\u0001J\u0015\u0010X\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\u0015\u0010Y\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005JS\u0010Z\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*\"\b\b\u0002\u0010\u0012*\u00020<\"\u000e\b\u0003\u0010[*\b\u0012\u0004\u0012\u00020\u00140,*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*H\u0096\u0007JA\u0010Z\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u0006\u0010]\u001a\u00020-H\u0096\u0007JA\u0010Z\u001a\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``*\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``2\u0006\u0010]\u001a\u00020_H\u0096\u0007J\u0015\u0010Z\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0003J\u0015\u0010a\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\r\u0010b\u001a\u00020\f*\u00020\fH\u0096\u0003J\u001b\u0010c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014H\u0096\u0001J\u0015\u0010d\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0005J\u0015\u0010d\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J#\u0010e\u001a\b\u0012\u0004\u0012\u0002H\u00120f\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u00142\u0006\u0010g\u001a\u000209H\u0096\u0001JS\u0010h\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*\"\b\b\u0002\u0010\u0012*\u00020<\"\u000e\b\u0003\u0010[*\b\u0012\u0004\u0012\u00020\u00140,*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H[0*H\u0096\u0007JA\u0010h\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.*\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u0006\u0010]\u001a\u00020-H\u0096\u0007JA\u0010h\u001a\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``*\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``2\u0006\u0010]\u001a\u00020_H\u0096\u0007J\u0015\u0010h\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0003J\u0015\u0010i\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\u0015\u0010j\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005J\u0015\u0010k\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020'H\u0096\u0001J\u0015\u0010k\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001J\u0015\u0010l\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020'H\u0096\u0001J\u0015\u0010l\u001a\u00020\f*\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001J8\u0010m\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0\u0016\"\u00020-H\u0096\u0001\u00a2\u0006\u0002\u0010nJ-\u0010m\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020-0pH\u0096\u0001J\r\u0010q\u001a\u00020'*\u00020'H\u0096\u0001J8\u0010r\u001a\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``2\u0012\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020_0\u0016\"\u00020_H\u0096\u0001\u00a2\u0006\u0002\u0010tJ\u0015\u0010u\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010v\u001a\u00020w\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bx\u0010yR+\u0010z\u001a\u001b\u0012\b\u0012\u00060{j\u0002`|\u0012\u0004\u0012\u00020\b0#j\u0002`}\u00a2\u0006\u0002\b%X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b~\u0010\u007fR-\u0010\u0080\u0001\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R-\u0010\u0083\u0001\u001a\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``8VX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001b\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u0088\u0001\u001a\u00020\f*\u00030\u0089\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u008a\u0001R+\u0010\u0088\u0001\u001a\u00020\f\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u008b\u0001R\u001c\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u008d\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0091\u0001X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0094\u0001\u001a\u00030\u0095\u0001*\u0006\u0012\u0002\b\u00030\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001RH\u0010/\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0*j\u0002`.\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R8\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001RH\u0010s\u001a\u0018\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0,0*j\u0002``\"\n\b\u0002\u0010\u0012*\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u0002H\u00120\u0017X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u00a0\u0001\u0010\u0099\u0001\"\u0006\b\u00a1\u0001\u0010\u009b\u0001\u00a8\u0006\u00a2\u0001"}, d2={"Lcom/feysh/corax/config/api/baseimpl/StaticMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "delegate", "<init>", "(Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;)V", "addStmt", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "and", "Lcom/feysh/corax/config/api/IBoolExpr;", "other", "Lcom/feysh/corax/config/api/IIntExpr;", "rhs", "anyOf", "Lcom/feysh/corax/config/api/ILocalValue;", "T", "Lkotlin/UnsafeVariance;", "", "local", "", "Lcom/feysh/corax/config/api/ILocalT;", "([Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "anyOr", "T1", "T2", "second", "check", "expr", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "contains", "Lcom/feysh/corax/config/api/IStringExpr;", "str", "", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "", "Lcom/feysh/corax/config/api/ITaintType;", "Lcom/feysh/corax/config/api/ITaintSet;", "taint", "containsAll", "endsWith", "eq", "eval", "result", "Lkotlin/ParameterName;", "name", "value", "Lcom/feysh/corax/config/api/IExpr;", "", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "Lcom/feysh/corax/config/api/IClassField;", "Lsoot/SootField;", "declaringClass", "Lkotlin/reflect/KClass;", "fieldName", "fieldType", "F", "Lkotlin/reflect/KProperty;", "FieldType", "type", "ge", "getBoolean", "getEnumName", "getInt", "getLong", "Lcom/feysh/corax/config/api/ILongExpr;", "getString", "gt", "hasIntersection", "isInstanceOf", "parentType", "le", "literal", "bool", "int", "long", "", "string", "lshr", "lt", "minus", "V", "set", "single", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "neq", "not", "null", "or", "paramAt", "Lcom/feysh/corax/config/api/IParameterT;", "index", "plus", "shl", "shr", "startsWith", "stringEquals", "taintOf", "([Lcom/feysh/corax/config/api/ITaintType;)Lcom/feysh/corax/config/api/IAttribute;", "types", "", "toLowerCase", "viaOf", "via", "([Lcom/feysh/corax/config/api/IViaType;)Lcom/feysh/corax/config/api/IAttribute;", "xor", "attr", "Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "getAttr", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IOperatorFactory$IAttributeGetSet;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "emptyTaint", "getEmptyTaint", "()Lcom/feysh/corax/config/api/IAttribute;", "emptyVia", "getEmptyVia", "global", "getGlobal", "()Lcom/feysh/corax/config/api/ILocalT;", "isConstant", "Lcom/feysh/corax/config/api/ITypedExpr;", "(Lcom/feysh/corax/config/api/ITypedExpr;)Lcom/feysh/corax/config/api/IBoolExpr;", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IBoolExpr;", "method", "Lcom/feysh/corax/config/api/IMethodDecl;", "getMethod", "()Lcom/feysh/corax/config/api/IMethodDecl;", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "subFields", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getSubFields", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IWithSubFieldsT;", "getTaint", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/IAttribute;", "setTaint", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/IAttribute;)V", "getValue", "(Lcom/feysh/corax/config/api/ILocalT;)Lcom/feysh/corax/config/api/ILocalValue;", "setValue", "(Lcom/feysh/corax/config/api/ILocalT;Lcom/feysh/corax/config/api/ILocalValue;)V", "getVia", "setVia", "corax-config-api"})
    public static final class CheckBuilder<R>
    implements ISMethodDecl.CheckBuilder<R>,
    IMethodDecl.CheckBuilder<R> {
        @NotNull
        private final IMethodDecl.CheckBuilder<R> delegate;

        public CheckBuilder(@NotNull IMethodDecl.CheckBuilder<R> delegate) {
            Intrinsics.checkNotNullParameter(delegate, (String)"delegate");
            this.delegate = delegate;
        }

        @Override
        @NotNull
        public IMethodDecl<R> getMethod() {
            return this.delegate.getMethod();
        }

        @Override
        @NotNull
        public Function1<MethodConfig, Unit> getConfig() {
            return this.delegate.getConfig();
        }

        @Override
        @NotNull
        public ILocalT<Object> getGlobal() {
            return this.delegate.getGlobal();
        }

        @Override
        @NotNull
        public <T> IParameterT<T> paramAt(int index) {
            return this.delegate.paramAt(index);
        }

        @Override
        @NotNull
        public IReturnT<R> getReturn() {
            return this.delegate.getReturn();
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
}

