/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import soot.Type;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\f\r\u00a8\u0006\u000e"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "", "<init>", "()V", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "name", "", "getName", "()Ljava/lang/String;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldNameType;", "Lcn/sast/dataflow/interprocedural/analysis/JSootFieldType;", "corax-data-flow"})
public abstract class JFieldType {
    private JFieldType() {
    }

    @NotNull
    public abstract Type getType();

    @NotNull
    public abstract String getName();

    public /* synthetic */ JFieldType(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

