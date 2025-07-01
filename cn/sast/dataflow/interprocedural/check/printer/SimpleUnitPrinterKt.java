package cn.sast.dataflow.interprocedural.check.printer;

import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethodInterface;

public final class SimpleUnitPrinterKt {
    @NotNull
    public static String getPrettyMethodName(@NotNull SootClass declaringClass, @NotNull String name) {
        if (name.equals("<init>") || name.equals("<clinit>")) {
            return declaringClass.getShortName();
        }
        return name;
    }

    @NotNull
    public static String getPrettyMethodName(@NotNull SootMethodInterface m) {
        return getPrettyMethodName(m.getDeclaringClass(), m.getName());
    }
}