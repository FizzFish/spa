/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.framework.engine.CheckPoint
 *  cn.sast.framework.engine.MethodCheckPoint
 *  cn.sast.framework.engine.UnitCheckPoint
 *  com.feysh.corax.cache.AnalysisCache
 *  com.feysh.corax.cache.AnalysisDataFactory$Key
 *  com.feysh.corax.cache.analysis.SootHostExtend
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.IMethodCheckPoint
 *  com.feysh.corax.config.api.IUnitCheckPoint
 *  com.feysh.corax.config.api.report.Region
 *  com.github.javaparser.ast.body.BodyDeclaration
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.Host
 *  soot.tagkit.VisibilityAnnotationTag
 */
package cn.sast.framework.engine;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.framework.engine.CheckPoint;
import cn.sast.framework.engine.UnitCheckPoint;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.IUnitCheckPoint;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.body.BodyDeclaration;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.VisibilityAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\u0002\b\u0016H\u0016J\u001b\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u00020'2\u0006\u0010(\u001a\u00020)H\u0096\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8PX\u0090\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0012\u0010*\u001a\u00020+X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u0004\u0018\u00010/*\u0002008VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010/04j\u0002`5X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0018\u00108\u001a\u00020)*\u0002098VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0018\u0010<\u001a\u00020)*\u0002098VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R\u0018\u0010>\u001a\u00020)*\u0002098VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b?\u0010;R\u0018\u0010@\u001a\u00020)*\u0002098VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bA\u0010;\u00a8\u0006B"}, d2={"Lcn/sast/framework/engine/MethodCheckPoint;", "Lcom/feysh/corax/config/api/IMethodCheckPoint;", "Lcn/sast/framework/engine/CheckPoint;", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "sootMethod", "Lsoot/SootMethod;", "info", "<init>", "(Lsoot/SootMethod;Lcom/feysh/corax/cache/analysis/SootInfoCache;)V", "getSootMethod", "()Lsoot/SootMethod;", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "visibilityAnnotationTag", "Lsoot/tagkit/VisibilityAnnotationTag;", "getVisibilityAnnotationTag", "()Lsoot/tagkit/VisibilityAnnotationTag;", "eachUnit", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/IUnitCheckPoint;", "Lkotlin/ExtensionFunctionType;", "region", "Lcom/feysh/corax/config/api/report/Region;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "file", "Lcn/sast/api/report/IBugResInfo;", "getFile", "()Lcn/sast/api/report/IBugResInfo;", "env", "Lcn/sast/api/report/DefaultEnv;", "getEnv$corax_framework", "()Lcn/sast/api/report/DefaultEnv;", "env$delegate", "Lkotlin/Lazy;", "getMemberAtLine", "Lcom/github/javaparser/ast/body/BodyDeclaration;", "Lsoot/SootClass;", "ln", "", "cache", "Lcom/feysh/corax/cache/AnalysisCache;", "getCache", "()Lcom/feysh/corax/cache/AnalysisCache;", "ext", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "Lsoot/tagkit/Host;", "getExt", "(Lsoot/tagkit/Host;)Lcom/feysh/corax/cache/analysis/SootHostExtend;", "hostKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoFKey;", "getHostKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "javaNameSourceEndColumnNumber", "Lsoot/tagkit/AbstractHost;", "getJavaNameSourceEndColumnNumber", "(Lsoot/tagkit/AbstractHost;)I", "javaNameSourceEndLineNumber", "getJavaNameSourceEndLineNumber", "javaNameSourceStartColumnNumber", "getJavaNameSourceStartColumnNumber", "javaNameSourceStartLineNumber", "getJavaNameSourceStartLineNumber", "corax-framework"})
public final class MethodCheckPoint
extends CheckPoint
implements IMethodCheckPoint,
SootInfoCache {
    @NotNull
    private final SootMethod sootMethod;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final IBugResInfo file;
    @NotNull
    private final Lazy env$delegate;

    public MethodCheckPoint(@NotNull SootMethod sootMethod, @NotNull SootInfoCache info2) {
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        this.sootMethod = sootMethod;
        this.info = info2;
        SootClass sootClass = this.getSootMethod().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        this.file = (IBugResInfo)new ClassResInfo(sootClass);
        this.env$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> MethodCheckPoint.env_delegate$lambda$0(this));
    }

    @NotNull
    public SootMethod getSootMethod() {
        return this.sootMethod;
    }

    @NotNull
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return (VisibilityAnnotationTag)this.getSootMethod().getTag("VisibilityAnnotationTag");
    }

    public void eachUnit(@NotNull Function1<? super IUnitCheckPoint, kotlin.Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        if (!this.getSootMethod().hasActiveBody()) {
            return;
        }
        Body b = this.getSootMethod().getActiveBody();
        Iterator iterator2 = b.getUnits().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Unit unit = (Unit)iterator3.next();
            Intrinsics.checkNotNull((Object)unit);
            block.invoke((Object)new UnitCheckPoint(this.info, unit, this.getSootMethod()));
        }
    }

    @NotNull
    public Region getRegion() {
        Region region = Region.Companion.invoke((SootInfoCache)this, (AbstractHost)this.getSootMethod());
        if (region == null) {
            region = Region.Companion.getERROR();
        }
        return region;
    }

    @NotNull
    public IBugResInfo getFile() {
        return this.file;
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        Lazy lazy = this.env$delegate;
        return (DefaultEnv)lazy.getValue();
    }

    @Nullable
    public BodyDeclaration<?> getMemberAtLine(@NotNull SootClass $this$getMemberAtLine, int ln) {
        Intrinsics.checkNotNullParameter((Object)$this$getMemberAtLine, (String)"<this>");
        return this.info.getMemberAtLine($this$getMemberAtLine, ln);
    }

    @NotNull
    public AnalysisCache getCache() {
        return this.info.getCache();
    }

    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getHostKey() {
        return this.info.getHostKey();
    }

    @Nullable
    public SootHostExtend getExt(@NotNull Host $this$ext) {
        Intrinsics.checkNotNullParameter((Object)$this$ext, (String)"<this>");
        return this.info.getExt($this$ext);
    }

    public int getJavaNameSourceStartLineNumber(@NotNull AbstractHost $this$javaNameSourceStartLineNumber) {
        Intrinsics.checkNotNullParameter((Object)$this$javaNameSourceStartLineNumber, (String)"<this>");
        return this.info.getJavaNameSourceStartLineNumber($this$javaNameSourceStartLineNumber);
    }

    public int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost $this$javaNameSourceStartColumnNumber) {
        Intrinsics.checkNotNullParameter((Object)$this$javaNameSourceStartColumnNumber, (String)"<this>");
        return this.info.getJavaNameSourceStartColumnNumber($this$javaNameSourceStartColumnNumber);
    }

    public int getJavaNameSourceEndLineNumber(@NotNull AbstractHost $this$javaNameSourceEndLineNumber) {
        Intrinsics.checkNotNullParameter((Object)$this$javaNameSourceEndLineNumber, (String)"<this>");
        return this.info.getJavaNameSourceEndLineNumber($this$javaNameSourceEndLineNumber);
    }

    public int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost $this$javaNameSourceEndColumnNumber) {
        Intrinsics.checkNotNullParameter((Object)$this$javaNameSourceEndColumnNumber, (String)"<this>");
        return this.info.getJavaNameSourceEndColumnNumber($this$javaNameSourceEndColumnNumber);
    }

    private static final DefaultEnv env_delegate$lambda$0(MethodCheckPoint this$0) {
        return new DefaultEnv(this$0.getRegion().getMutable(), null, null, null, this$0.getSootMethod(), null, this$0.getSootMethod().getDeclaringClass(), null, this$0.getSootMethod(), 174, null);
    }
}

