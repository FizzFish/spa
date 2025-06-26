/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject
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
 *  soot.RefType
 *  soot.Scene
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
import soot.RefType;
import soot.Scene;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R&\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/GlobalStaticObject;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "<init>", "()V", "fieldObjects", "", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/PhantomField;", "getPhantomFieldMap", "toString", "", "equals", "", "other", "", "hashCode", "", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "typeIsConcrete", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "corax-data-flow"})
public class GlobalStaticObject
implements IValue,
IFieldManager<GlobalStaticObject> {
    @NotNull
    private final Map<PersistentList<JFieldType>, PhantomField<GlobalStaticObject>> fieldObjects = new LinkedHashMap();
    @NotNull
    private final Type type;

    public GlobalStaticObject() {
        RefType refType = Scene.v().getObjectType();
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"getObjectType(...)");
        this.type = (Type)refType;
    }

    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<GlobalStaticObject>> getPhantomFieldMap() {
        return this.fieldObjects;
    }

    @NotNull
    public String toString() {
        return "GlobalStaticObject";
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return other instanceof GlobalStaticObject;
    }

    public int hashCode() {
        return 30864;
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    public boolean typeIsConcrete() {
        return true;
    }

    public boolean isNullConstant() {
        return false;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Entry;
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
    public IValue copy(@NotNull Type type) {
        return IValue.DefaultImpls.copy((IValue)this, (Type)type);
    }

    @NotNull
    public PhantomField<GlobalStaticObject> getPhantomField(@NotNull JFieldType field) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, (JFieldType)field);
    }

    @NotNull
    public PhantomField<GlobalStaticObject> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, ap);
    }
}

