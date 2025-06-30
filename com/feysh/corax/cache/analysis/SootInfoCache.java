/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.ast.Node$TreeTraversal
 *  com.github.javaparser.ast.NodeList
 *  com.github.javaparser.ast.body.BodyDeclaration
 *  com.github.javaparser.ast.body.TypeDeclaration
 *  com.github.javaparser.ast.expr.ObjectCreationExpr
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.Host
 *  soot.tagkit.SourceLnPosTag
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootClassExtend;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.feysh.corax.config.api.report.RegionKt;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\b*\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u001d\u001a\u00020\u0014*\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u0014*\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u0018\u0010#\u001a\u00020\u0014*\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010 R\u0018\u0010%\u001a\u00020\u0014*\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010 \u00a8\u0006'"}, d2={"Lcom/feysh/corax/cache/analysis/SootInfoCache;", "", "cache", "Lcom/feysh/corax/cache/AnalysisCache;", "getCache", "()Lcom/feysh/corax/cache/AnalysisCache;", "hostKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoFKey;", "getHostKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "ext", "Lsoot/tagkit/Host;", "getExt", "(Lsoot/tagkit/Host;)Lcom/feysh/corax/cache/analysis/SootHostExtend;", "getMemberAtLine", "Lcom/github/javaparser/ast/body/BodyDeclaration;", "Lsoot/SootClass;", "ln", "", "getMember", "members", "", "getNormalMembers", "decl", "Lcom/github/javaparser/ast/body/TypeDeclaration;", "getMembersOfAnonymousClass", "Lcom/github/javaparser/ast/expr/ObjectCreationExpr;", "javaNameSourceStartLineNumber", "Lsoot/tagkit/AbstractHost;", "getJavaNameSourceStartLineNumber", "(Lsoot/tagkit/AbstractHost;)I", "javaNameSourceStartColumnNumber", "getJavaNameSourceStartColumnNumber", "javaNameSourceEndLineNumber", "getJavaNameSourceEndLineNumber", "javaNameSourceEndColumnNumber", "getJavaNameSourceEndColumnNumber", "corax-config-api"})
public interface SootInfoCache {
    @NotNull
    public AnalysisCache getCache();

    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getHostKey();

    @Nullable
    public SootHostExtend getExt(@NotNull Host var1);

    @Nullable
    public BodyDeclaration<?> getMemberAtLine(@NotNull SootClass var1, int var2);

    public int getJavaNameSourceStartLineNumber(@NotNull AbstractHost var1);

    public int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost var1);

    public int getJavaNameSourceEndLineNumber(@NotNull AbstractHost var1);

    public int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootInfoCache$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,391:1\n774#2:392\n865#2,2:393\n*S KotlinDebug\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootInfoCache$DefaultImpls\n*L\n256#1:392\n256#1:393,2\n*E\n"})
    public static final class DefaultImpls {
        @Nullable
        public static SootHostExtend getExt(@NotNull SootInfoCache $this, @NotNull Host $receiver) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            return SootHostExtendKt.ext($receiver, $this.getCache(), $this.getHostKey());
        }

        @Nullable
        public static BodyDeclaration<?> getMemberAtLine(@NotNull SootInfoCache $this, @NotNull SootClass $receiver, int ln) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            SootHostExtend sootHostExtend = $this.getExt((Host)$receiver);
            SootClassExtend sootClassExtend = sootHostExtend instanceof SootClassExtend ? (SootClassExtend)sootHostExtend : null;
            if (sootClassExtend == null || (sootClassExtend = sootClassExtend.getDecl()) == null) {
                return null;
            }
            SootClassExtend decl = sootClassExtend;
            SootClassExtend sootClassExtend2 = decl;
            return sootClassExtend2 instanceof TypeDeclaration ? DefaultImpls.getNormalMembers($this, (TypeDeclaration)decl, ln) : (sootClassExtend2 instanceof ObjectCreationExpr ? DefaultImpls.getMembersOfAnonymousClass($this, (ObjectCreationExpr)decl, ln) : null);
        }

        /*
         * WARNING - void declaration
         */
        private static BodyDeclaration<?> getMember(SootInfoCache $this, List<? extends BodyDeclaration<?>> members, int ln) {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = members;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                boolean bl;
                BodyDeclaration it = (BodyDeclaration)element$iv$iv;
                boolean bl2 = false;
                Optional optional = it.getBegin();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getBegin(...)");
                Integer n = SootHostExtendKt.getLine(optional);
                if (n == null) {
                    bl = false;
                } else {
                    Integer n2 = (int)n;
                    Optional optional2 = it.getEnd();
                    Intrinsics.checkNotNullExpressionValue((Object)optional2, (String)"getEnd(...)");
                    Integer n3 = SootHostExtendKt.getLine(optional2);
                    if (n3 == null) {
                        boolean bl3;
                        bl = bl3 = false;
                    } else {
                        Pair declRange = TuplesKt.to((Object)n2, (Object)n3);
                        bl = ((Number)declRange.getFirst()).intValue() > ((Number)declRange.getSecond()).intValue() ? false : ((Number)declRange.getFirst()).intValue() <= ln && ln <= ((Number)declRange.getSecond()).intValue();
                    }
                }
                if (!bl) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            return (BodyDeclaration)CollectionsKt.firstOrNull((List)((List)destination$iv$iv));
        }

        private static BodyDeclaration<?> getNormalMembers(SootInfoCache $this, TypeDeclaration<?> decl, int ln) {
            NodeList nodeList = decl.getMembers();
            Intrinsics.checkNotNullExpressionValue((Object)nodeList, (String)"getMembers(...)");
            return DefaultImpls.getMember($this, (List)nodeList, ln);
        }

        private static BodyDeclaration<?> getMembersOfAnonymousClass(SootInfoCache $this, ObjectCreationExpr decl, int ln) {
            List list = decl.findAll(BodyDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"findAll(...)");
            return DefaultImpls.getMember($this, CollectionsKt.filterNotNull((Iterable)list), ln);
        }

        public static int getJavaNameSourceStartLineNumber(@NotNull SootInfoCache $this, @NotNull AbstractHost $receiver) {
            int n;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Object object = $this.getExt((Host)$receiver);
            if (object != null && (object = ((SootHostExtend)object).getJavaNameSourceStartLineNumber()) != null) {
                n = (Integer)object;
            } else {
                SootHostExtend sootHostExtend = $this.getExt((Host)$receiver);
                n = sootHostExtend != null ? sootHostExtend.getJavaSourceStartLineNumber() : $receiver.getJavaSourceStartLineNumber();
            }
            return n;
        }

        public static int getJavaNameSourceStartColumnNumber(@NotNull SootInfoCache $this, @NotNull AbstractHost $receiver) {
            int n;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Object object = $this.getExt((Host)$receiver);
            if (object != null && (object = ((SootHostExtend)object).getJavaNameSourceStartColumnNumber()) != null) {
                n = (Integer)object;
            } else {
                SootHostExtend sootHostExtend = $this.getExt((Host)$receiver);
                n = sootHostExtend != null ? sootHostExtend.getJavaSourceStartColumnNumber() : $receiver.getJavaSourceStartColumnNumber();
            }
            return n;
        }

        public static int getJavaNameSourceEndLineNumber(@NotNull SootInfoCache $this, @NotNull AbstractHost $receiver) {
            int n;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Object object = $this.getExt((Host)$receiver);
            if (object != null && (object = ((SootHostExtend)object).getJavaNameSourceEndLineNumber()) != null) {
                n = (Integer)object;
            } else {
                SourceLnPosTag sourceLnPosTag = RegionKt.getPos((Host)$receiver);
                n = sourceLnPosTag != null ? sourceLnPosTag.endLn() : -1;
            }
            return n;
        }

        public static int getJavaNameSourceEndColumnNumber(@NotNull SootInfoCache $this, @NotNull AbstractHost $receiver) {
            int n;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Object object = $this.getExt((Host)$receiver);
            if (object != null && (object = ((SootHostExtend)object).getJavaNameSourceEndColumnNumber()) != null) {
                n = (Integer)object;
            } else {
                SourceLnPosTag sourceLnPosTag = RegionKt.getPos((Host)$receiver);
                n = sourceLnPosTag != null ? sourceLnPosTag.endPos() : -1;
            }
            return n;
        }
    }
}

