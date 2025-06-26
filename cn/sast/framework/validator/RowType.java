/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.validator.RowType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.validator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2={"Lcn/sast/framework/validator/RowType;", "", "<init>", "()V", "type", "getType", "()Ljava/lang/Object;", "Lcn/sast/framework/validator/RowCheckType;", "Lcn/sast/framework/validator/RowUnknownType;", "corax-framework"})
public abstract class RowType {
    private RowType() {
    }

    @NotNull
    public abstract Object getType();

    public /* synthetic */ RowType(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

