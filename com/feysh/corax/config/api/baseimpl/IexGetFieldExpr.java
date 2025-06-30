/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexGetField;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IexGetFieldExpr;", "Lcom/feysh/corax/config/api/IIexGetField;", "base", "Lcom/feysh/corax/config/api/IExpr;", "accessPath", "Lkotlinx/collections/immutable/PersistentList;", "Lcom/feysh/corax/config/api/IClassField;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;Lkotlinx/collections/immutable/PersistentList;)V", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "getAccessPath", "()Lkotlinx/collections/immutable/PersistentList;", "toString", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "Companion", "corax-config-api"})
public final class IexGetFieldExpr
implements IIexGetField {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final IExpr base;
    @NotNull
    private final PersistentList<IClassField> accessPath;

    public IexGetFieldExpr(@NotNull IExpr base, @NotNull PersistentList<? extends IClassField> accessPath) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter(accessPath, (String)"accessPath");
        this.base = base;
        this.accessPath = accessPath;
    }

    @Override
    @NotNull
    public IExpr getBase() {
        return this.base;
    }

    @NotNull
    public PersistentList<IClassField> getAccessPath() {
        return this.accessPath;
    }

    @NotNull
    public String toString() {
        return "IexGetField( " + this.getBase() + "." + CollectionsKt.joinToString$default((Iterable)((Iterable)this.getAccessPath()), (CharSequence)".", null, null, (int)0, null, null, (int)62, null) + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IexGetFieldExpr$Companion;", "", "<init>", "()V", "invoke", "Lcom/feysh/corax/config/api/baseimpl/IexGetFieldExpr;", "base", "Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IClassField;", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nAIAnalysisBaseImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/IexGetFieldExpr$Companion\n+ 2 extensions.kt\nkotlinx/collections/immutable/ExtensionsKt\n*L\n1#1,1477:1\n138#2:1478\n*S KotlinDebug\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/IexGetFieldExpr$Companion\n*L\n561#1:1478\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final IexGetFieldExpr invoke(@NotNull IExpr base, @NotNull IClassField field) {
            IexGetFieldExpr iexGetFieldExpr;
            Intrinsics.checkNotNullParameter((Object)base, (String)"base");
            Intrinsics.checkNotNullParameter((Object)field, (String)"field");
            if (base instanceof IexGetFieldExpr) {
                PersistentList<IClassField> $this$plus$iv = ((IexGetFieldExpr)base).getAccessPath();
                boolean $i$f$plus = false;
                IexGetFieldExpr iexGetFieldExpr2 = new IexGetFieldExpr(((IexGetFieldExpr)base).getBase(), (PersistentList<? extends IClassField>)$this$plus$iv.add((Object)field));
                iexGetFieldExpr = iexGetFieldExpr2;
            } else {
                Object[] objectArray = new IClassField[]{field};
                IexGetFieldExpr iexGetFieldExpr3 = new IexGetFieldExpr(base, (PersistentList<? extends IClassField>)ExtensionsKt.persistentListOf((Object[])objectArray));
                iexGetFieldExpr = iexGetFieldExpr3;
            }
            return iexGetFieldExpr;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

