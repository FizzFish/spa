/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldNameType
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt
 *  cn.sast.dataflow.interprocedural.check.checker.FactModeling
 *  cn.sast.dataflow.interprocedural.check.checker.FactModeling$getVisitor$stmtVisitor$1
 *  cn.sast.dataflow.interprocedural.check.checker.FactModeling$setConstValue$baseExpr$1
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValuesBuilder
 *  cn.sast.idfa.check.ICallCB
 *  com.feysh.corax.config.api.AttributeName
 *  com.feysh.corax.config.api.BuiltInField
 *  com.feysh.corax.config.api.ClassField
 *  com.feysh.corax.config.api.Elements
 *  com.feysh.corax.config.api.IClassField
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.IIexGetField
 *  com.feysh.corax.config.api.IIexLoad
 *  com.feysh.corax.config.api.IModelStmtVisitor
 *  com.feysh.corax.config.api.MGlobal
 *  com.feysh.corax.config.api.MLocal
 *  com.feysh.corax.config.api.MParameter
 *  com.feysh.corax.config.api.MReturn
 *  com.feysh.corax.config.api.MapKeys
 *  com.feysh.corax.config.api.MapValues
 *  com.feysh.corax.config.api.SubFields
 *  com.feysh.corax.config.api.TaintProperty
 *  com.feysh.corax.config.api.ViaProperty
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.NotImplementedError
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.Scene
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldNameType;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt;
import cn.sast.dataflow.interprocedural.check.checker.FactModeling;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValuesBuilder;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.AttributeName;
import com.feysh.corax.config.api.BuiltInField;
import com.feysh.corax.config.api.ClassField;
import com.feysh.corax.config.api.Elements;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexGetField;
import com.feysh.corax.config.api.IIexLoad;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import com.feysh.corax.config.api.MapKeys;
import com.feysh.corax.config.api.MapValues;
import com.feysh.corax.config.api.SubFields;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Scene;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BS\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\"\u0010\b\u001a\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\n*\b\u0012\u0004\u0012\u00020\u00010\u0018J&\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u001aJ<\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u001aJ \u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020$2\u0010\u0010*\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050+J<\u0010,\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u001aJ\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010.R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\b\u001a\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006/"}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/FactModeling;", "", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "summaryCtxCalleeSite", "Lcn/sast/idfa/check/ICallCB;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "builder", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lcn/sast/idfa/check/ICallCB;Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;)V", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "getSummaryCtxCalleeSite", "()Lcn/sast/idfa/check/ICallCB;", "getBuilder", "()Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "toHV", "", "isArray", "", "(Ljava/lang/Object;)Z", "store", "", "values", "dest", "Lcom/feysh/corax/config/api/MLocal;", "append", "setField", "baseExpr", "Lcom/feysh/corax/config/api/IExpr;", "bases", "field", "Lcom/feysh/corax/config/api/IClassField;", "setConstValue", "rvalue", "newBase", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "propertyPropagate", "getVisitor", "Lcom/feysh/corax/config/api/IModelStmtVisitor;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nCheckerModeling.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerModeling.kt\ncn/sast/dataflow/interprocedural/check/checker/FactModeling\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n774#2:566\n865#2,2:567\n774#2:569\n865#2,2:570\n46#3:572\n47#3:574\n1#4:573\n*S KotlinDebug\n*F\n+ 1 CheckerModeling.kt\ncn/sast/dataflow/interprocedural/check/checker/FactModeling\n*L\n197#1:566\n197#1:567,2\n200#1:569\n200#1:570,2\n242#1:572\n242#1:574\n242#1:573\n*E\n"})
public final class FactModeling {
    @NotNull
    private final AbstractHeapFactory<IValue> hf;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite;
    @NotNull
    private final IFact.Builder<IValue> builder;

    public FactModeling(@NotNull AbstractHeapFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite, @NotNull IFact.Builder<IValue> builder2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(summaryCtxCalleeSite, (String)"summaryCtxCalleeSite");
        Intrinsics.checkNotNullParameter(builder2, (String)"builder");
        this.hf = hf;
        this.env = env;
        this.summaryCtxCalleeSite = summaryCtxCalleeSite;
        this.builder = builder2;
    }

    @NotNull
    public final AbstractHeapFactory<IValue> getHf() {
        return this.hf;
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return this.env;
    }

    @NotNull
    public final ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> getSummaryCtxCalleeSite() {
        return this.summaryCtxCalleeSite;
    }

    @NotNull
    public final IFact.Builder<IValue> getBuilder() {
        return this.builder;
    }

    @NotNull
    public final IHeapValues<IValue> toHV(@NotNull List<? extends Object> $this$toHV) {
        Intrinsics.checkNotNullParameter($this$toHV, (String)"<this>");
        IHeapValues.Builder b = this.hf.emptyBuilder();
        for (Object object : $this$toHV) {
            if (!(object instanceof CompanionV)) continue;
            if (!(((CompanionV)object).getValue() instanceof IValue)) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
            b.add((CompanionV)object);
        }
        return b.build();
    }

    public final boolean isArray(@NotNull Object $this$isArray) {
        Intrinsics.checkNotNullParameter((Object)$this$isArray, (String)"<this>");
        return $this$isArray instanceof CompanionV && ((CompanionV)$this$isArray).getValue() instanceof IValue && ((IValue)((CompanionV)$this$isArray).getValue()).getType() instanceof ArrayType;
    }

    public final void store(@NotNull List<? extends Object> values, @NotNull MLocal dest, boolean append) {
        Intrinsics.checkNotNullParameter(values, (String)"values");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        IFact.Builder builder2 = this.builder;
        Intrinsics.checkNotNull((Object)builder2, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract<cn.sast.dataflow.interprocedural.analysis.IValue>");
        PointsToGraphBuilderAbstract out = (PointsToGraphBuilderAbstract)builder2;
        IHeapValues value = this.toHV(values);
        MLocal mLocal = dest;
        if (Intrinsics.areEqual((Object)mLocal, (Object)MReturn.INSTANCE)) {
            if (append) {
                ICallCB iCallCB = this.summaryCtxCalleeSite;
                iCallCB.setReturn((Object)((IHeapValues)iCallCB.getReturn()).plus(value));
            } else {
                this.summaryCtxCalleeSite.setReturn((Object)value);
            }
        } else if (mLocal instanceof MParameter) {
            Object destValue = this.summaryCtxCalleeSite.argToValue(((MParameter)dest).getIndex());
            out.assignNewExpr(this.env, destValue, value, append);
        } else if (!Intrinsics.areEqual((Object)mLocal, (Object)MGlobal.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ void store$default(FactModeling factModeling, List list, MLocal mLocal, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        factModeling.store(list, mLocal, bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void setField(@Nullable IExpr baseExpr2, @NotNull List<? extends Object> bases, @NotNull List<? extends Object> values, @NotNull IClassField field, boolean append) {
        Intrinsics.checkNotNullParameter((Object)bases, (String)"bases");
        Intrinsics.checkNotNullParameter(values, (String)"values");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        IClassField iClassField = field;
        if (iClassField instanceof BuiltInField) {
            BuiltInField builtInField = (BuiltInField)field;
            if (Intrinsics.areEqual((Object)builtInField, (Object)TaintProperty.INSTANCE) || Intrinsics.areEqual((Object)builtInField, (Object)ViaProperty.INSTANCE)) {
                this.propertyPropagate(baseExpr2, bases, values, field, append);
                return;
            } else {
                BuiltInModelT builtInModelT;
                Object $this$filter$iv;
                if (!Intrinsics.areEqual((Object)builtInField, (Object)MapKeys.INSTANCE) && !Intrinsics.areEqual((Object)builtInField, (Object)MapValues.INSTANCE) && !Intrinsics.areEqual((Object)builtInField, (Object)Elements.INSTANCE)) throw new NoWhenBranchMatchedException();
                List baseValues = bases;
                BuiltInField builtInField2 = (BuiltInField)field;
                if (builtInField2 instanceof Elements) {
                    Object baseValue;
                    Object element$iv$iv;
                    Object $this$filterTo$iv$iv;
                    $this$filter$iv = (IHeapValues[])baseValues;
                    boolean $i$f$filter = false;
                    IHeapValues[] iHeapValuesArray = $this$filter$iv;
                    Collection destination$iv$iv = new ArrayList();
                    boolean $i$f$filterTo = false;
                    Iterator iterator2 = $this$filterTo$iv$iv.iterator();
                    while (iterator2.hasNext()) {
                        baseValue = element$iv$iv = iterator2.next();
                        boolean bl = false;
                        if (!this.isArray(baseValue)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    List arrayObjects = (List)destination$iv$iv;
                    $this$filter$iv = baseValues;
                    $i$f$filter = false;
                    $this$filterTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList();
                    $i$f$filterTo = false;
                    iterator2 = $this$filterTo$iv$iv.iterator();
                    while (iterator2.hasNext()) {
                        baseValue = element$iv$iv = iterator2.next();
                        boolean bl = false;
                        if (!(!this.isArray(baseValue))) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    baseValues = (List)destination$iv$iv;
                    if (!((Collection)arrayObjects).isEmpty()) {
                        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)this.builder, (HeapValuesEnv)this.env, (Object)"@arr", (IHeapValues)this.toHV(arrayObjects), (boolean)false, (int)8, null);
                        this.builder.setArrayValueNew(this.env, (Object)"@arr", null, this.toHV(values));
                        this.builder.kill((Object)"@arr");
                    }
                    builtInModelT = BuiltInModelT.Element;
                } else if (builtInField2 instanceof MapKeys) {
                    builtInModelT = BuiltInModelT.MapKeys;
                } else if (builtInField2 instanceof MapValues) {
                    builtInModelT = BuiltInModelT.MapValues;
                } else {
                    String arrayObjects = "unreachable";
                    throw new NotImplementedError("An operation is not implemented: " + arrayObjects);
                }
                BuiltInModelT mt = builtInModelT;
                IHeapValues base = this.toHV(baseValues);
                $this$filter$iv = new IHeapValues[]{base};
                IOpCalculator op = this.hf.resolveOp(this.env, (IHeapValues[])$this$filter$iv);
                boolean append2 = !base.isSingle();
                op.resolve((arg_0, arg_1, arg_2) -> FactModeling.setField$lambda$2(append2, this, mt, values, arg_0, arg_1, arg_2));
            }
            return;
        } else if (iClassField instanceof ClassField) {
            Type type;
            IHeapValues base = this.toHV(bases);
            IHeapValues value = this.toHV(values);
            FieldUtil op = FieldUtil.INSTANCE;
            ClassField field$iv = (ClassField)field;
            boolean $i$f$of = false;
            String string = field$iv.getFieldType();
            if (string != null) {
                String it$iv = string;
                boolean bl = false;
                type = Scene.v().getTypeUnsafe(it$iv, true);
            } else {
                type = null;
            }
            Type ty$iv = type;
            String string2 = field$iv.getFieldName();
            Type type2 = ty$iv;
            if (type2 == null) {
                type2 = (Type)Scene.v().getObjectType();
            }
            Type type3 = type2;
            Intrinsics.checkNotNull((Object)type3);
            JFieldNameType sootField = new JFieldNameType(string2, type3);
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)this.builder, (HeapValuesEnv)this.env, (Object)"@base", (IHeapValues)base, (boolean)false, (int)8, null);
            this.builder.setFieldNew(this.env, (Object)"@base", (JFieldType)sootField, value);
            this.builder.kill((Object)"@base");
            return;
        } else if (iClassField instanceof AttributeName) {
            Object mt = CheckerModelingKt.getKeyAttribute();
            IHeapValues value = this.toHV(values);
            IHeapValues baseHeapValues = this.toHV(bases);
            boolean append3 = !baseHeapValues.isSingle();
            for (CompanionV base : this.toHV(bases)) {
                ImmutableElementHashMap attributeMap;
                IData it$iv = this.builder.getValueData(base.getValue(), mt);
                ImmutableElementHashMap immutableElementHashMap = attributeMap = it$iv instanceof ImmutableElementHashMap ? (ImmutableElementHashMap)it$iv : null;
                if (attributeMap == null) {
                    attributeMap = new ImmutableElementHashMap(null, null, 3, null);
                }
                ImmutableElementHashMapBuilder b = attributeMap.builder();
                b.set((IHeapValuesFactory)this.hf, this.env, (Object)((AttributeName)field).getName(), value, append3);
                ImmutableElementHashMap immutableElementHashMap2 = b.build();
                if ((IValue)base.getValue() instanceof ConstVal) {
                    return;
                }
                this.builder.setValueData(this.env, base.getValue(), mt, (IData)immutableElementHashMap2);
            }
            return;
        } else if (!Intrinsics.areEqual((Object)iClassField, (Object)SubFields.INSTANCE)) return;
    }

    public final void setConstValue(@NotNull IExpr rvalue, @NotNull CompanionV<IValue> newBase) {
        Intrinsics.checkNotNullParameter((Object)rvalue, (String)"rvalue");
        Intrinsics.checkNotNullParameter(newBase, (String)"newBase");
        IExpr iExpr = rvalue;
        if (iExpr instanceof IIexGetField) {
            if (((IIexGetField)rvalue).getAccessPath().isEmpty()) {
                return;
            }
            List acp = CollectionsKt.dropLast((List)((IIexGetField)rvalue).getAccessPath(), (int)1);
            setConstValue.baseExpr.1 baseExpr2 = new /* Unavailable Anonymous Inner Class!! */;
            List bases = SequencesKt.toList((Sequence)this.hf.resolve(this.env, this.summaryCtxCalleeSite, (IExpr)baseExpr2));
            this.setField(null, bases, CollectionsKt.listOf(newBase), (IClassField)CollectionsKt.last((List)((IIexGetField)rvalue).getAccessPath()), true);
        } else if (iExpr instanceof IIexLoad) {
            this.store(CollectionsKt.listOf(newBase), ((IIexLoad)rvalue).getOp(), true);
        }
    }

    public final void propertyPropagate(@Nullable IExpr baseExpr2, @NotNull List<? extends Object> bases, @NotNull List<? extends Object> values, @NotNull IClassField field, boolean append) {
        Intrinsics.checkNotNullParameter(bases, (String)"bases");
        Intrinsics.checkNotNullParameter(values, (String)"values");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        IHeapValues base = this.toHV(bases);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{base};
        IOpCalculator op = this.hf.resolveOp(this.env, iHeapValuesArray);
        boolean append1 = !base.isSingle() || append;
        op.resolve((arg_0, arg_1, arg_2) -> FactModeling.propertyPropagate$lambda$4(append1, this, field, values, arg_0, arg_1, arg_2));
    }

    @NotNull
    public final IModelStmtVisitor<Object> getVisitor() {
        getVisitor.stmtVisitor.1 stmtVisitor2 = new /* Unavailable Anonymous Inner Class!! */;
        return (IModelStmtVisitor)stmtVisitor2;
    }

    private static final boolean setField$lambda$2(boolean $append, FactModeling this$0, Object $mt, List $values, IOpCalculator $this$solve, IHeapValues.Builder ret, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$solve, (String)"$this$solve");
        Intrinsics.checkNotNullParameter((Object)ret, (String)"ret");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV base = companionVArray[0];
        if ($append) {
            ObjectValues collection;
            IData iData = this$0.builder.getValueData(base.getValue(), $mt);
            ObjectValues objectValues = collection = iData instanceof ObjectValues ? (ObjectValues)iData : null;
            if (collection == null) {
                collection = new ObjectValues(this$0.hf.empty());
            }
            ObjectValuesBuilder b = collection.builder();
            b.addAll(this$0.toHV($values));
            this$0.builder.setValueData(this$0.env, base.getValue(), $mt, (IData)b.build());
        } else {
            ObjectValues collection = new ObjectValues(this$0.toHV($values));
            this$0.builder.setValueData(this$0.env, base.getValue(), $mt, (IData)collection);
        }
        return true;
    }

    private static final boolean propertyPropagate$lambda$4(boolean $append1, FactModeling this$0, IClassField $field, List $values, IOpCalculator $this$solve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        ImmutableElementSet immutableElementSet;
        ImmutableElementSet immutableElementSet2;
        IData iData;
        Intrinsics.checkNotNullParameter((Object)$this$solve, (String)"$this$solve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV base = companionVArray[0];
        ImmutableElementSet setDate = $append1 ? ((iData = this$0.builder.getValueData(base.getValue(), (Object)$field)) instanceof ImmutableElementSet ? (ImmutableElementSet)iData : null) : null;
        if (setDate == null || setDate.isEmpty()) {
            if ($values.size() == 1) {
                Object object = CollectionsKt.first((List)$values);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet<kotlin.Any>");
                immutableElementSet2 = (ImmutableElementSet)object;
            } else {
                immutableElementSet2 = null;
            }
        } else {
            immutableElementSet2 = immutableElementSet = null;
        }
        if (immutableElementSet2 == null) {
            boolean bl = false;
            ImmutableElementSetBuilder setBuilder = new ImmutableElementSet(null, null, 3, null).builder();
            for (Object typeValues : $values) {
                ImmutableElementSet set;
                if ((typeValues instanceof ImmutableElementSet ? (ImmutableElementSet)typeValues : null) == null) continue;
                set = set;
                for (Object e : set.getElement()) {
                    IHeapValues v = set.get((IHeapValuesFactory)this$0.hf, e);
                    setBuilder.set((IHeapValuesFactory)this$0.hf, this$0.env, e, v, $append1);
                }
            }
            immutableElementSet = setBuilder.build();
        }
        ImmutableElementSet immutableElementSet3 = immutableElementSet;
        if ((IValue)base.getValue() instanceof ConstVal) {
            return false;
        }
        this$0.builder.setValueData(this$0.env, base.getValue(), CheckerModelingKt.getKeyTaintProperty(), (IData)immutableElementSet3);
        return true;
    }
}

