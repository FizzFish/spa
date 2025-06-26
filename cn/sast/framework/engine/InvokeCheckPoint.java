/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.framework.engine.CheckPoint
 *  cn.sast.framework.engine.InvokeCheckPoint
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.IInvokeCheckPoint
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.InvokeExpr
 *  soot.tagkit.AbstractHost
 */
package cn.sast.framework.engine;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.framework.engine.CheckPoint;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IInvokeCheckPoint;
import com.feysh.corax.config.api.report.Region;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.tagkit.AbstractHost;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8PX\u0090\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.\u00a8\u00060"}, d2={"Lcn/sast/framework/engine/InvokeCheckPoint;", "Lcom/feysh/corax/config/api/IInvokeCheckPoint;", "Lcn/sast/framework/engine/CheckPoint;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "container", "Lsoot/SootMethod;", "callSite", "Lsoot/Unit;", "declaredReceiverType", "Lsoot/Type;", "invokeMethodRef", "Lsoot/SootMethodRef;", "callee", "invokeExpr", "Lsoot/jimple/InvokeExpr;", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;Lsoot/SootMethod;Lsoot/Unit;Lsoot/Type;Lsoot/SootMethodRef;Lsoot/SootMethod;Lsoot/jimple/InvokeExpr;)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "getContainer", "()Lsoot/SootMethod;", "getCallSite", "()Lsoot/Unit;", "getDeclaredReceiverType", "()Lsoot/Type;", "getInvokeMethodRef", "()Lsoot/SootMethodRef;", "getCallee", "getInvokeExpr", "()Lsoot/jimple/InvokeExpr;", "toString", "", "region", "Lcom/feysh/corax/config/api/report/Region;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "file", "Lcn/sast/api/report/IBugResInfo;", "getFile", "()Lcn/sast/api/report/IBugResInfo;", "file$delegate", "Lkotlin/Lazy;", "env", "Lcn/sast/api/report/DefaultEnv;", "getEnv$corax_framework", "()Lcn/sast/api/report/DefaultEnv;", "env$delegate", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPreAnalysisImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisImpl.kt\ncn/sast/framework/engine/InvokeCheckPoint\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,760:1\n1#2:761\n*E\n"})
public final class InvokeCheckPoint
extends CheckPoint
implements IInvokeCheckPoint {
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final SootMethod container;
    @Nullable
    private final Unit callSite;
    @Nullable
    private final Type declaredReceiverType;
    @Nullable
    private final SootMethodRef invokeMethodRef;
    @NotNull
    private final SootMethod callee;
    @Nullable
    private final InvokeExpr invokeExpr;
    @NotNull
    private final Lazy file$delegate;
    @NotNull
    private final Lazy env$delegate;

    public InvokeCheckPoint(@NotNull SootInfoCache info2, @NotNull SootMethod container, @Nullable Unit callSite, @Nullable Type declaredReceiverType, @Nullable SootMethodRef invokeMethodRef, @NotNull SootMethod callee, @Nullable InvokeExpr invokeExpr) {
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        Intrinsics.checkNotNullParameter((Object)container, (String)"container");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        this.info = info2;
        this.container = container;
        this.callSite = callSite;
        this.declaredReceiverType = declaredReceiverType;
        this.invokeMethodRef = invokeMethodRef;
        this.callee = callee;
        this.invokeExpr = invokeExpr;
        this.file$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> InvokeCheckPoint.file_delegate$lambda$1(this));
        this.env$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> InvokeCheckPoint.env_delegate$lambda$2(this));
    }

    @NotNull
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @NotNull
    public SootMethod getContainer() {
        return this.container;
    }

    @Nullable
    public Unit getCallSite() {
        return this.callSite;
    }

    @Nullable
    public Type getDeclaredReceiverType() {
        return this.declaredReceiverType;
    }

    @Nullable
    public SootMethodRef getInvokeMethodRef() {
        return this.invokeMethodRef;
    }

    @NotNull
    public SootMethod getCallee() {
        return this.callee;
    }

    @Nullable
    public InvokeExpr getInvokeExpr() {
        return this.invokeExpr;
    }

    @NotNull
    public String toString() {
        Unit unit = this.getCallSite();
        return this.getContainer() + ": at " + (unit != null ? Integer.valueOf(unit.getJavaSourceStartLineNumber()) : null) + " : " + this.getCallSite() + " -> " + this.getInvokeMethodRef() + " -> " + this.getCallee();
    }

    @NotNull
    public Region getRegion() {
        Unit unit;
        block5: {
            block4: {
                unit = this.getCallSite();
                if (unit == null) break block4;
                Unit it = unit;
                boolean bl = false;
                Region region = Region.Companion.invoke(it);
                unit = region;
                if (region != null) break block5;
            }
            if ((unit = Region.Companion.invoke(this.info, (AbstractHost)this.getContainer())) == null) {
                unit = Region.Companion.getERROR();
            }
        }
        return unit;
    }

    @NotNull
    public IBugResInfo getFile() {
        Lazy lazy = this.file$delegate;
        return (IBugResInfo)lazy.getValue();
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        Lazy lazy = this.env$delegate;
        return (DefaultEnv)lazy.getValue();
    }

    private static final ClassResInfo file_delegate$lambda$1(InvokeCheckPoint this$0) {
        SootClass sootClass = this$0.getContainer().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        return new ClassResInfo(sootClass);
    }

    private static final DefaultEnv env_delegate$lambda$2(InvokeCheckPoint this$0) {
        return new DefaultEnv(this$0.getRegion().getMutable(), null, this$0.getCallSite(), this$0.getCallee(), this$0.getContainer(), this$0.getInvokeExpr(), null, null, null, 450, null);
    }
}

