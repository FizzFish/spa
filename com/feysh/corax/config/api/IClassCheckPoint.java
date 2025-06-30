/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.sequences.Sequence
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMemberCheckPoint;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u0015H&J!\u0010\u0016\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0002\b\u0015H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/config/api/IClassCheckPoint;", "Lcom/feysh/corax/config/api/IClassMemberCheckPoint;", "sootClass", "Lsoot/SootClass;", "getSootClass", "()Lsoot/SootClass;", "className", "", "getClassName", "()Ljava/lang/String;", "superClasses", "Lkotlin/sequences/Sequence;", "getSuperClasses", "()Lkotlin/sequences/Sequence;", "superInterfaces", "getSuperInterfaces", "eachMethod", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/IMethodCheckPoint;", "Lkotlin/ExtensionFunctionType;", "eachField", "Lcom/feysh/corax/config/api/IFieldCheckPoint;", "corax-config-api"})
public interface IClassCheckPoint
extends IClassMemberCheckPoint {
    @NotNull
    public SootClass getSootClass();

    @NotNull
    public String getClassName();

    @NotNull
    public Sequence<SootClass> getSuperClasses();

    @NotNull
    public Sequence<SootClass> getSuperInterfaces();

    public void eachMethod(@NotNull Function1<? super IMethodCheckPoint, Unit> var1);

    public void eachField(@NotNull Function1<? super IFieldCheckPoint, Unit> var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static Sequence<SootClass> getSuperClasses(@NotNull IClassCheckPoint $this) {
            return UtilsKt.getSuperClasses($this.getSootClass());
        }

        @NotNull
        public static Sequence<SootClass> getSuperInterfaces(@NotNull IClassCheckPoint $this) {
            return UtilsKt.getSuperInterfaces($this.getSootClass());
        }
    }
}

