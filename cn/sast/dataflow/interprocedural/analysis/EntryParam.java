/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.EntryParam
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\u000bJ \u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00160\u0013H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00160\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/EntryParam;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "type", "Lsoot/Type;", "method", "Lsoot/SootMethod;", "paramIndex", "", "<init>", "(Lsoot/Type;Lsoot/SootMethod;I)V", "(Lsoot/SootMethod;I)V", "getType", "()Lsoot/Type;", "getMethod", "()Lsoot/SootMethod;", "getParamIndex", "()I", "fieldObjects", "", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/PhantomField;", "getPhantomFieldMap", "equals", "", "other", "", "hashCode", "typeIsConcrete", "copy", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "toString", "", "corax-data-flow"})
public class EntryParam
implements IValue,
IFieldManager<EntryParam> {
    @NotNull
    private final Type type;
    @NotNull
    private final SootMethod method;
    private final int paramIndex;
    @NotNull
    private final Map<PersistentList<JFieldType>, PhantomField<EntryParam>> fieldObjects;

    public EntryParam(@NotNull Type type, @NotNull SootMethod method, int paramIndex) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        this.type = type;
        this.method = method;
        this.paramIndex = paramIndex;
        this.fieldObjects = new LinkedHashMap();
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    public final int getParamIndex() {
        return this.paramIndex;
    }

    public EntryParam(@NotNull SootMethod method, int paramIndex) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Type type = paramIndex != -1 ? method.getParameterType(paramIndex) : (Type)method.getDeclaringClass().getType();
        Intrinsics.checkNotNull((Object)type);
        this(type, method, paramIndex);
    }

    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<EntryParam>> getPhantomFieldMap() {
        return this.fieldObjects;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof EntryParam)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.method, (Object)((EntryParam)other).method)) {
            return false;
        }
        if (this.paramIndex != ((EntryParam)other).paramIndex) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getType(), (Object)((EntryParam)other).getType());
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + this.method.hashCode();
        result = 31 * result + Integer.hashCode(this.paramIndex);
        result = 31 * result + this.getType().hashCode();
        return result;
    }

    public boolean typeIsConcrete() {
        return false;
    }

    @NotNull
    public IValue copy(@NotNull Type type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return (IValue)new EntryParam(type, this.method, this.paramIndex);
    }

    public boolean isNullConstant() {
        return false;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Entry;
    }

    @NotNull
    public String toString() {
        return "param<" + this.paramIndex + ">_" + this.getType();
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

    @NotNull
    public PhantomField<EntryParam> getPhantomField(@NotNull JFieldType field) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, (JFieldType)field);
    }

    @NotNull
    public PhantomField<EntryParam> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, ap);
    }
}

