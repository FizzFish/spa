/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion
 *  cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion$Companion
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.cache.analysis.SootMethodExtend
 *  com.feysh.corax.config.api.report.Region
 *  com.github.javaparser.ast.NodeList
 *  com.github.javaparser.ast.body.CallableDeclaration
 *  com.github.javaparser.ast.body.Parameter
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.Body
 *  soot.BodyTransformer
 *  soot.PatchingChain
 *  soot.SootMethod
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.IdentityStmt
 *  soot.jimple.ParameterRef
 *  soot.jimple.ThisRef
 *  soot.options.Options
 *  soot.tagkit.Host
 *  soot.tagkit.SourceLnPosTag
 *  soot.tagkit.Tag
 */
package cn.sast.framework.rewrite;

import cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootMethodExtend;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Body;
import soot.BodyTransformer;
import soot.PatchingChain;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.options.Options;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;
import soot.tagkit.Tag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000fH\u0014J\u0016\u0010\u0010\u001a\u00020\t*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0015"}, d2={"Lcn/sast/framework/rewrite/IdentityStmt2MethodParamRegion;", "Lsoot/BodyTransformer;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "internalTransform", "", "b", "Lsoot/Body;", "phaseName", "", "options", "", "addTag", "Lsoot/tagkit/Host;", "region", "Lcom/feysh/corax/config/api/report/Region;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIdentityStmt2MethodParamRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityStmt2MethodParamRegion.kt\ncn/sast/framework/rewrite/IdentityStmt2MethodParamRegion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Region.kt\ncom/feysh/corax/config/api/report/Region\n*L\n1#1,61:1\n1#2:62\n1#2:64\n59#3:63\n57#3:65\n57#3:66\n*S KotlinDebug\n*F\n+ 1 IdentityStmt2MethodParamRegion.kt\ncn/sast/framework/rewrite/IdentityStmt2MethodParamRegion\n*L\n40#1:64\n40#1:63\n40#1:65\n47#1:66\n*E\n"})
public final class IdentityStmt2MethodParamRegion
extends BodyTransformer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootInfoCache info;
    @NotNull
    public static final String phase = "jb.identityStmt2MethodParamRegion";
    @NotNull
    private static final Logger logger;

    public IdentityStmt2MethodParamRegion(@NotNull SootInfoCache info2) {
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        this.info = info2;
    }

    @NotNull
    public final SootInfoCache getInfo() {
        return this.info;
    }

    /*
     * WARNING - void declaration
     */
    protected void internalTransform(@NotNull Body b, @NotNull String phaseName, @NotNull Map<String, String> options) {
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)phaseName, (String)"phaseName");
        Intrinsics.checkNotNullParameter(options, (String)"options");
        if (Options.v().verbose()) {
            logger.debug("[" + b.getMethod().getName() + "] Rewrite IdentityStmt region ...");
        }
        UnitPatchingChain unitPatchingChain = b.getUnits();
        Intrinsics.checkNotNullExpressionValue((Object)unitPatchingChain, (String)"getUnits(...)");
        PatchingChain units = (PatchingChain)unitPatchingChain;
        if (units.isEmpty()) {
            return;
        }
        if (b.getMethod().isStatic() && b.getMethod().getParameterCount() == 0) {
            return;
        }
        SootMethod sootMethod = b.getMethod();
        Intrinsics.checkNotNullExpressionValue((Object)sootMethod, (String)"getMethod(...)");
        SootMethodExtend sootMethodExtend = (SootMethodExtend)AnalysisCache.G.INSTANCE.sootHost2decl((Host)sootMethod);
        if (sootMethodExtend == null) {
            return;
        }
        SootMethodExtend method = sootMethodExtend;
        CallableDeclaration callableDeclaration = method.getDecl();
        if (callableDeclaration == null) {
            return;
        }
        CallableDeclaration decl = callableDeclaration;
        Iterator iterator2 = units.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Region region;
            Unit unit = (Unit)iterator3.next();
            if (!(unit instanceof IdentityStmt)) continue;
            Value rop = ((IdentityStmt)unit).getRightOp();
            if (rop instanceof ThisRef) {
                Region region2;
                IdentityStmt2MethodParamRegion identityStmt2MethodParamRegion = this;
                Host host = (Host)unit;
                if (method.getNameDecl() != null) {
                    void it;
                    Host host2 = host;
                    IdentityStmt2MethodParamRegion identityStmt2MethodParamRegion2 = identityStmt2MethodParamRegion;
                    boolean bl = false;
                    Region region3 = Region.Companion.invoke((NodeWithRange)it);
                    identityStmt2MethodParamRegion = identityStmt2MethodParamRegion2;
                    host = host2;
                    region2 = region3;
                } else {
                    region2 = null;
                }
                identityStmt2MethodParamRegion.addTag(host, region2);
                continue;
            }
            if (!(rop instanceof ParameterRef)) continue;
            NodeList nodeList = decl.getParameters();
            Intrinsics.checkNotNullExpressionValue((Object)nodeList, (String)"getParameters(...)");
            Parameter parameter = (Parameter)CollectionsKt.getOrNull((List)((List)nodeList), (int)((ParameterRef)rop).getIndex());
            if (parameter == null || (parameter = parameter.getName()) == null) continue;
            Parameter param = parameter;
            Region region4 = Region.Companion.invoke((NodeWithRange)param);
            if (region4 == null) continue;
            Region this_$iv = region4;
            boolean $i$f$getTakeIfValid = false;
            Region it$iv = region = this_$iv;
            boolean bl = false;
            Region this_$iv$iv = this_$iv;
            boolean $i$f$getValid = false;
            Object object = this_$iv$iv.startLine >= 0 ? region : null;
            region4 = object;
            if (object == null) {
                continue;
            }
            Region region5 = region4;
            this.addTag((Host)unit, region5);
        }
    }

    private final void addTag(Host $this$addTag, Region region) {
        block5: {
            block4: {
                if (region == null) break block4;
                Region this_$iv = region;
                boolean $i$f$getValid = false;
                if (this_$iv.startLine >= 0) break block5;
            }
            return;
        }
        if (Options.v().keep_line_number()) {
            $this$addTag.removeTag("SourceLnPosTag");
            $this$addTag.removeTag("SourceLnPosTag");
            $this$addTag.addTag((Tag)new SourceLnPosTag(region.startLine, region.getEndLine(), region.startColumn, region.getEndColumn()));
        }
    }

    static {
        Logger logger = LoggerFactory.getLogger(IdentityStmt2MethodParamRegion.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        IdentityStmt2MethodParamRegion.logger = logger;
    }
}

