/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.baseimpl.ClassDecl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/baseimpl/PackageDeclare;", "", "package", "", "<init>", "(Ljava/lang/String;)V", "getPackage", "()Ljava/lang/String;", "class", "", "className", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/baseimpl/ClassDecl;", "Lkotlin/ExtensionFunctionType;", "toString", "corax-config-api"})
public class PackageDeclare {
    @NotNull
    private final String package;

    public PackageDeclare(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"package");
        this.package = string;
    }

    @NotNull
    public final String getPackage() {
        return this.package;
    }

    public final void class(@NotNull String className, @NotNull Function1<? super ClassDecl, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        block.invoke((Object)new ClassDecl(this, className));
    }

    @NotNull
    public String toString() {
        return "package match: " + this.package;
    }
}

