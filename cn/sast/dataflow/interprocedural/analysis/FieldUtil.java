/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.JFieldNameType
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  com.feysh.corax.config.api.ClassField
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootField
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.JFieldNameType;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import com.feysh.corax.config.api.ClassField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootField;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\bJ\u0013\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\tH\u0086\bJ\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0086\bJ\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\fH\u0086\b\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/FieldUtil;", "", "<init>", "()V", "of", "Lcn/sast/dataflow/interprocedural/analysis/JSootFieldType;", "field", "Lsoot/SootField;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldNameType;", "Lcom/feysh/corax/config/api/ClassField;", "typeOf", "Lsoot/Type;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "nameOf", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nIFact.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,507:1\n1#2:508\n*E\n"})
public final class FieldUtil {
    @NotNull
    public static final FieldUtil INSTANCE = new FieldUtil();

    private FieldUtil() {
    }

    @NotNull
    public final JSootFieldType of(@NotNull SootField field) {
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        boolean $i$f$of = false;
        return new JSootFieldType(field);
    }

    @Nullable
    public final JFieldNameType of(@NotNull ClassField field) {
        Type type;
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        boolean $i$f$of = false;
        String string = field.getFieldType();
        if (string != null) {
            String it = string;
            boolean bl = false;
            type = Scene.v().getTypeUnsafe(it, true);
        } else {
            type = null;
        }
        Type ty = type;
        String string2 = field.getFieldName();
        Type type2 = ty;
        if (type2 == null) {
            type2 = (Type)Scene.v().getObjectType();
        }
        Type type3 = type2;
        Intrinsics.checkNotNull((Object)type3);
        return new JFieldNameType(string2, type3);
    }

    @NotNull
    public final Type typeOf(@NotNull JFieldType field) {
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        boolean $i$f$typeOf = false;
        return field.getType();
    }

    @NotNull
    public final String nameOf(@NotNull JFieldType field) {
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        boolean $i$f$nameOf = false;
        return field.getName();
    }
}

