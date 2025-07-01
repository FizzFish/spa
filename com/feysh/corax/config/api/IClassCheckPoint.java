package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMemberCheckPoint;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import java.util.stream.Stream;

public interface IClassCheckPoint extends IClassMemberCheckPoint {
    @NotNull
    SootClass getSootClass();

    @NotNull
    String getClassName();

    @NotNull
    default Stream<SootClass> getSuperClasses() {
        return UtilsKt.getSuperClasses(getSootClass());
    }

    @NotNull
    default Stream<SootClass> getSuperInterfaces() {
        return UtilsKt.getSuperInterfaces(getSootClass());
    }

    void eachMethod(@NotNull java.util.function.Consumer<? super IMethodCheckPoint> block);

    void eachField(@NotNull java.util.function.Consumer<? super IFieldCheckPoint> block);
}