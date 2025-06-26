/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph
 *  cn.sast.api.incremental.ModifyInfoFactory
 *  cn.sast.api.util.OthersKt
 *  cn.sast.common.IResource
 *  cn.sast.framework.incremental.DependsGraph
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl$ClassDecl
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl$FieldDecl
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl$FileDecl
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl$MethodDecl
 *  com.feysh.corax.config.api.XDecl
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.eclipse.jgit.diff.DiffEntry
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.util.Chain
 */
package cn.sast.framework.incremental;

import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.api.util.OthersKt;
import cn.sast.common.IResource;
import cn.sast.framework.incremental.DependsGraph;
import cn.sast.framework.incremental.ModifyInfoFactoryImpl;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.eclipse.jgit.diff.DiffEntry;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/incremental/ModifyInfoFactoryImpl;", "Lcn/sast/api/incremental/ModifyInfoFactory;", "<init>", "()V", "toDecl", "Lcom/feysh/corax/config/api/XDecl;", "target", "", "getPatchedDeclsByDiff", "", "diff", "Lorg/eclipse/jgit/diff/DiffEntry;", "getSubDecls", "decl", "createInterProceduralAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;", "getScanAction", "Lcom/feysh/corax/config/api/rules/ProcessRule$ScanAction;", "createSimpleDeclAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "FileDecl", "ClassDecl", "MethodDecl", "FieldDecl", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIncrementalAnalyzeImplByChangeFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/ModifyInfoFactoryImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,395:1\n1628#2,3:396\n1628#2,3:399\n*S KotlinDebug\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/ModifyInfoFactoryImpl\n*L\n86#1:396,3\n87#1:399,3\n*E\n"})
public final class ModifyInfoFactoryImpl
implements ModifyInfoFactory {
    @NotNull
    public XDecl toDecl(@NotNull Object target) {
        XDecl xDecl;
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Object object = target;
        if (object instanceof SootClass) {
            xDecl = (XDecl)new ClassDecl((SootClass)target);
        } else if (object instanceof SootMethod) {
            xDecl = (XDecl)new MethodDecl((SootMethod)target);
        } else if (object instanceof SootField) {
            xDecl = (XDecl)new FieldDecl((SootField)target);
        } else if (object instanceof Path) {
            xDecl = (XDecl)new FileDecl((Path)target);
        } else if (object instanceof File) {
            Path path = ((File)target).toPath();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"toPath(...)");
            xDecl = (XDecl)new FileDecl(path);
        } else if (object instanceof IResource) {
            xDecl = (XDecl)new FileDecl((IResource)target);
        } else {
            throw new IllegalStateException("not support yet".toString());
        }
        return xDecl;
    }

    @NotNull
    public Collection<XDecl> getPatchedDeclsByDiff(@NotNull Object target, @NotNull DiffEntry diff2) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Intrinsics.checkNotNullParameter((Object)diff2, (String)"diff");
        return this.getSubDecls(this.toDecl(target));
    }

    @NotNull
    public Collection<XDecl> getSubDecls(@NotNull XDecl decl) {
        Collection collection;
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        XDecl xDecl = decl;
        if (xDecl instanceof FileDecl) {
            collection = CollectionsKt.listOf((Object)decl);
        } else if (xDecl instanceof ClassDecl) {
            SootField it;
            Collection collection2;
            SootClass t = ((ClassDecl)decl).getTarget();
            List list = t.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            int n = ((Collection)list).size();
            Chain chain = t.getFields();
            Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getFields(...)");
            ArrayList mutableSet = new ArrayList(n + ((Collection)chain).size() + 1);
            ((Collection)mutableSet).add(decl);
            List list2 = t.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getMethods(...)");
            Iterable $this$mapTo$iv = list2;
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                SootMethod sootMethod = (SootMethod)item$iv;
                collection2 = mutableSet;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                collection2.add(this.toDecl((Object)it));
            }
            Chain chain2 = t.getFields();
            Intrinsics.checkNotNullExpressionValue((Object)chain2, (String)"getFields(...)");
            $this$mapTo$iv = (Iterable)chain2;
            $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                it = (SootField)item$iv;
                collection2 = mutableSet;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                collection2.add(this.toDecl((Object)it));
            }
            collection = mutableSet;
        } else if (xDecl instanceof MethodDecl) {
            collection = CollectionsKt.listOf((Object)decl);
        } else if (xDecl instanceof FieldDecl) {
            collection = CollectionsKt.listOf((Object)decl);
        } else {
            throw new IllegalStateException(("invalid type of " + decl).toString());
        }
        return collection;
    }

    @NotNull
    public IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph createInterProceduralAnalysisDependsGraph() {
        DependsGraph d = new DependsGraph((ModifyInfoFactory)this);
        return (IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public ProcessRule.ScanAction getScanAction(@NotNull XDecl target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        if (target instanceof MethodDecl && OthersKt.isDummy((SootMethod)((MethodDecl)target).getTarget())) {
            return ProcessRule.ScanAction.Skip;
        }
        return ProcessRule.ScanAction.Keep;
    }

    @NotNull
    public IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph createSimpleDeclAnalysisDependsGraph() {
        DependsGraph d = new DependsGraph((ModifyInfoFactory)this);
        return (IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph)new /* Unavailable Anonymous Inner Class!! */;
    }
}

