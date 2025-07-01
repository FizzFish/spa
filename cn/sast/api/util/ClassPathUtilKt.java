package cn.sast.api.util;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.util.SootUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ModuleUtil;
import soot.SootClass;

public final class ClassPathUtilKt {
    @NotNull
    public static Pair<String, String> classSplit(@NotNull ClassResInfo cp) {
        if (cp == null) {
            throw new NullPointerException("cp cannot be null");
        }
        return SootUtilsKt.classSplit(cp.getSc());
    }

    @Nullable
    public static String getSourcePathModule(@NotNull SootClass c) {
        if (c == null) {
            throw new NullPointerException("c cannot be null");
        }
        
        String sourcePath = SootUtilsKt.getSourcePathFromAnnotation(c);
        if (sourcePath == null) {
            return null;
        }
        
        ModuleUtil.ModuleClassNameWrapper wrapper = ModuleUtil.v().makeWrapper(c.getName());
        if (wrapper.getModuleName() != null) {
            sourcePath = wrapper.getModuleName() + "/" + sourcePath;
        }
        return sourcePath;
    }
}