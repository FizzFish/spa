/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bB%\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\tJ\u0013\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\""}, d2={"Lcn/sast/dataflow/interprocedural/analysis/PhantomField;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "type", "Lsoot/Type;", "base", "Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "accessPath", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "<init>", "(Lsoot/Type;Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;Lkotlinx/collections/immutable/PersistentList;)V", "(Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;Lkotlinx/collections/immutable/PersistentList;)V", "getType", "()Lsoot/Type;", "getBase", "()Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "getAccessPath", "()Lkotlinx/collections/immutable/PersistentList;", "toString", "", "typeIsConcrete", "", "copy", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "getPhantomField", "field", "equals", "other", "", "hashCode", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nFactValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactValues.kt\ncn/sast/dataflow/interprocedural/analysis/PhantomField\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,589:1\n49#2:590\n50#2:591\n*S KotlinDebug\n*F\n+ 1 FactValues.kt\ncn/sast/dataflow/interprocedural/analysis/PhantomField\n*L\n295#1:590\n298#1:591\n*E\n"})
public class PhantomField<V extends IValue>
implements IValue {
    @NotNull
    private final Type type;
    @NotNull
    private final IFieldManager<V> base;
    @NotNull
    private final PersistentList<JFieldType> accessPath;

    public PhantomField(@NotNull Type type, @NotNull IFieldManager<V> base, @NotNull PersistentList<? extends JFieldType> accessPath) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(base, (String)"base");
        Intrinsics.checkNotNullParameter(accessPath, (String)"accessPath");
        this.type = type;
        this.base = base;
        this.accessPath = accessPath;
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    @NotNull
    public final IFieldManager<V> getBase() {
        return this.base;
    }

    @NotNull
    public final PersistentList<JFieldType> getAccessPath() {
        return this.accessPath;
    }

    public PhantomField(@NotNull IFieldManager<V> base, @NotNull PersistentList<? extends JFieldType> accessPath) {
        Intrinsics.checkNotNullParameter(base, (String)"base");
        Intrinsics.checkNotNullParameter(accessPath, (String)"accessPath");
        FieldUtil fieldUtil = FieldUtil.INSTANCE;
        JFieldType field$iv = (JFieldType)CollectionsKt.last((List)((List)accessPath));
        boolean $i$f$typeOf = false;
        this(field$iv.getType(), base, accessPath);
    }

    @NotNull
    public String toString() {
        return "PhantomObject_" + this.getType() + "_" + this.base + "." + CollectionsKt.joinToString$default((Iterable)((Iterable)this.accessPath), null, null, null, (int)0, null, PhantomField::toString$lambda$0, (int)31, null);
    }

    public boolean typeIsConcrete() {
        return false;
    }

    @NotNull
    public IValue copy(@NotNull Type type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return (IValue)new PhantomField(type, this.base, this.accessPath);
    }

    public boolean isNullConstant() {
        return false;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Summary;
    }

    @NotNull
    public final PhantomField<V> getPhantomField(@NotNull JFieldType field) {
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        return this.base.getPhantomField(this.accessPath.add((Object)field));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof PhantomField)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.base, (Object)((PhantomField)other).base)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.accessPath, (Object)((PhantomField)other).accessPath)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getType(), (Object)((PhantomField)other).getType());
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + this.base.hashCode();
        result = 31 * result + this.accessPath.hashCode();
        result = 31 * result + this.getType().hashCode();
        return result;
    }

    public boolean isNormal() {
        return IValue.DefaultImpls.isNormal((IValue)this);
    }

    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return IValue.DefaultImpls.objectEqual((IValue)this, (IValue)b);
    }

    @NotNull
    public IValue clone() {
        return IValue.DefaultImpls.clone((IValue)this);
    }

    private static final CharSequence toString$lambda$0(JFieldType it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$nameOf = false;
        return it.getName();
    }
}

