/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.baseimpl.MatchUtilsKt;
import com.feysh.corax.config.api.baseimpl.PackageDeclare;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lcom/feysh/corax/config/api/baseimpl/ClassDecl;", "", "package", "Lcom/feysh/corax/config/api/baseimpl/PackageDeclare;", "className", "", "<init>", "(Lcom/feysh/corax/config/api/baseimpl/PackageDeclare;Ljava/lang/String;)V", "getPackage", "()Lcom/feysh/corax/config/api/baseimpl/PackageDeclare;", "getClassName", "()Ljava/lang/String;", "clazz", "getClazz", "matchSimpleSubSig", "Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "subSignature", "matchSubSig", "Lcom/feysh/corax/config/api/baseimpl/SootSignatureMatch;", "matchName", "name", "toString", "corax-config-api"})
public class ClassDecl {
    @NotNull
    private final PackageDeclare package;
    @NotNull
    private final String className;
    @NotNull
    private final String clazz;

    public ClassDecl(@NotNull PackageDeclare packageDeclare, @NotNull String className) {
        Intrinsics.checkNotNullParameter((Object)packageDeclare, (String)"package");
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        this.package = packageDeclare;
        this.className = className;
        this.clazz = this.package.getPackage() + "." + this.className;
    }

    @NotNull
    public final PackageDeclare getPackage() {
        return this.package;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getClazz() {
        return this.clazz;
    }

    @NotNull
    public final RawSignatureMatch matchSimpleSubSig(@NotNull String subSignature) {
        Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
        return MatchUtilsKt.matchSimpleSig(this.clazz + ": " + subSignature);
    }

    @NotNull
    public final SootSignatureMatch matchSubSig(@NotNull String subSignature) {
        Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
        String sootSig = "<" + this.clazz + ": " + subSignature + ">";
        return SootSignatureMatch.Companion.invoke(sootSig);
    }

    @NotNull
    public final RawSignatureMatch matchName(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return RawSignatureMatch.Companion.invoke$default(RawSignatureMatch.Companion, this.clazz, name, null, null, null, 16, null);
    }

    @NotNull
    public String toString() {
        return "class match: " + this.className;
    }
}

