/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.util.ClassPathUtilKt
 *  cn.sast.api.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ModuleUtil
 *  soot.ModuleUtil$ModuleClassNameWrapper
 *  soot.SootClass
 */
package cn.sast.api.util;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.util.SootUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ModuleUtil;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"classSplit", "Lkotlin/Pair;", "", "cp", "Lcn/sast/api/report/ClassResInfo;", "getSourcePathModule", "c", "Lsoot/SootClass;", "corax-api"})
public final class ClassPathUtilKt {
    @NotNull
    public static final Pair<String, String> classSplit(@NotNull ClassResInfo cp) {
        Intrinsics.checkNotNullParameter((Object)cp, (String)"cp");
        return SootUtilsKt.classSplit((SootClass)cp.getSc());
    }

    @Nullable
    public static final String getSourcePathModule(@NotNull SootClass c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        String string = SootUtilsKt.getSourcePathFromAnnotation((SootClass)c);
        if (string == null) {
            return null;
        }
        Object sourcePath = string;
        ModuleUtil.ModuleClassNameWrapper wrapper = ModuleUtil.v().makeWrapper(c.getName());
        if (wrapper.getModuleName() != null) {
            sourcePath = wrapper.getModuleName() + "/" + (String)sourcePath;
        }
        return sourcePath;
    }
}

