/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.framework.SourceLocatorPlusKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 */
package cn.sast.framework;

import cn.sast.common.IResource;
import cn.sast.common.Resource;
import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import soot.Scene;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0004"}, d2={"sootClassPathsCvt", "", "Lcn/sast/common/IResource;", "sourceDir", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSourceLocatorPlus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceLocatorPlus.kt\ncn/sast/framework/SourceLocatorPlusKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1628#2,3:117\n1797#2,3:120\n*S KotlinDebug\n*F\n+ 1 SourceLocatorPlus.kt\ncn/sast/framework/SourceLocatorPlusKt\n*L\n23#1:117,3\n27#1:120,3\n*E\n"})
public final class SourceLocatorPlusKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Set<IResource> sootClassPathsCvt(@NotNull Set<? extends IResource> sourceDir) {
        void $this$fold$iv;
        void initial$iv;
        List $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(sourceDir, (String)"sourceDir");
        Iterable iterable = sourceDir;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            IResource iResource = (IResource)item$iv;
            Collection collection = destination$iv;
            boolean bl = false;
            collection.add(it.getAbsolutePath());
        }
        Iterable $this$sootClassPathsCvt_u24lambda_u241 = $this$mapTo$iv = CollectionsKt.toMutableList((Collection)destination$iv);
        boolean $i$a$-apply-SourceLocatorPlusKt$sootClassPathsCvt$sourcePath$32 = false;
        String string = Scene.v().getSootClassPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSootClassPath(...)");
        String[] stringArray = new String[]{File.pathSeparator};
        $this$sootClassPathsCvt_u24lambda_u241.addAll(StringsKt.split$default((CharSequence)string, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
        List sourcePath = $this$mapTo$iv;
        $this$sootClassPathsCvt_u24lambda_u241 = sourcePath;
        Set $i$a$-apply-SourceLocatorPlusKt$sootClassPathsCvt$sourcePath$32 = new LinkedHashSet();
        boolean $i$f$fold = false;
        void accumulator$iv = initial$iv;
        for (Object element$iv : $this$fold$iv) {
            void aPath;
            String string2 = (String)element$iv;
            void r = accumulator$iv;
            boolean bl = false;
            if (Intrinsics.areEqual((Object)"VIRTUAL_FS_FOR_JDK", (Object)aPath)) {
                String string3 = System.getProperty("java.home");
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getProperty(...)");
                v2 = r.add(Resource.INSTANCE.of(string3));
            } else {
                v2 = r.add(Resource.INSTANCE.of((String)aPath));
            }
            accumulator$iv = r;
        }
        void srcTranslate = accumulator$iv;
        return srcTranslate;
    }
}

