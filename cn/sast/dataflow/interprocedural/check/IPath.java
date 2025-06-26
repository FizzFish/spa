/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.interner.InternerEquiv
 *  cn.sast.common.interner.WeakInternerX
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.IPath$Companion
 *  com.github.benmanes.caffeine.cache.Interner
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.common.interner.InternerEquiv;
import cn.sast.common.interner.WeakInternerX;
import cn.sast.dataflow.interprocedural.check.IPath;
import com.github.benmanes.caffeine.cache.Interner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Unit;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\t\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lcn/sast/dataflow/interprocedural/check/IPath;", "Lcn/sast/common/interner/InternerEquiv;", "<init>", "()V", "node", "Lsoot/Unit;", "getNode", "()Lsoot/Unit;", "Companion", "Lcn/sast/dataflow/interprocedural/check/AssignLocalPath;", "Lcn/sast/dataflow/interprocedural/check/EntryPath;", "Lcn/sast/dataflow/interprocedural/check/GetEdgePath;", "Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;", "Lcn/sast/dataflow/interprocedural/check/LiteralPath;", "Lcn/sast/dataflow/interprocedural/check/MergePath;", "Lcn/sast/dataflow/interprocedural/check/ModelBind;", "Lcn/sast/dataflow/interprocedural/check/SetEdgePath;", "Lcn/sast/dataflow/interprocedural/check/UnknownPath;", "corax-data-flow"})
public abstract class IPath
implements InternerEquiv {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Interner<Object> specialWeakInterner;
    @NotNull
    private static final WeakInternerX weakInterner;

    private IPath() {
    }

    @NotNull
    public abstract Unit getNode();

    public /* synthetic */ IPath(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final /* synthetic */ Interner access$getSpecialWeakInterner$cp() {
        return specialWeakInterner;
    }

    public static final /* synthetic */ WeakInternerX access$getWeakInterner$cp() {
        return weakInterner;
    }

    static {
        Interner interner = Interner.newWeakInterner();
        Intrinsics.checkNotNullExpressionValue((Object)interner, (String)"newWeakInterner(...)");
        specialWeakInterner = interner;
        weakInterner = new WeakInternerX();
    }
}

