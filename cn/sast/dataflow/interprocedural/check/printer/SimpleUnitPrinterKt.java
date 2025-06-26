/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinterKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootMethodInterface
 */
package cn.sast.dataflow.interprocedural.check.printer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethodInterface;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u00a8\u0006\u0007"}, d2={"getPrettyMethodName", "", "declaringClass", "Lsoot/SootClass;", "name", "m", "Lsoot/SootMethodInterface;", "corax-data-flow"})
public final class SimpleUnitPrinterKt {
    @NotNull
    public static final String getPrettyMethodName(@NotNull SootClass declaringClass, @NotNull String name) {
        String string;
        Intrinsics.checkNotNullParameter((Object)declaringClass, (String)"declaringClass");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        String string2 = name;
        if (Intrinsics.areEqual((Object)string2, (Object)"<init>")) {
            String string3 = declaringClass.getShortName();
            string = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getShortName(...)");
        } else if (Intrinsics.areEqual((Object)string2, (Object)"<clinit>")) {
            String string4 = declaringClass.getShortName();
            string = string4;
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getShortName(...)");
        } else {
            string = name;
        }
        return string;
    }

    @NotNull
    public static final String getPrettyMethodName(@NotNull SootMethodInterface m) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        boolean $i$f$getPrettyMethodName = false;
        SootClass sootClass = m.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        String string = m.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return SimpleUnitPrinterKt.getPrettyMethodName((SootClass)sootClass, (String)string);
    }
}

