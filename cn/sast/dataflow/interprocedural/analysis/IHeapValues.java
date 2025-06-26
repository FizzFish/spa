/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlinx.collections.immutable.ImmutableSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.collections.immutable.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001-J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u00a6\u0002J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u00a6\u0002J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&J6\u0010\u0019\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u001e\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u001cH&J<\u0010\u001d\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182$\u0010\u001b\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u001e0\u001cH&J\b\u0010\u001f\u001a\u00020\u0015H&J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0015H&J\u0017\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\u0015H\u0016\u00a2\u0006\u0002\u0010'J\u0015\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0)H\u00a6\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,H&R\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006."}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "reference", "", "res", "", "plus", "rhs", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "size", "", "getSize", "()I", "values", "Lkotlinx/collections/immutable/ImmutableSet;", "getValues", "()Lkotlinx/collections/immutable/ImmutableSet;", "valuesCompanion", "getValuesCompanion", "isNotEmpty", "", "isEmpty", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "map", "c", "transform", "Lkotlin/Function1;", "flatMap", "", "isSingle", "single", "getSingle", "()Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "getAllIntValue", "", "must", "getMaxInt", "(Z)Ljava/lang/Integer;", "iterator", "", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "Builder", "corax-data-flow"})
public interface IHeapValues<V>
extends IDiffAble<V> {
    public void reference(@NotNull Collection<V> var1);

    @NotNull
    public IHeapValues<V> plus(@NotNull IHeapValues<V> var1);

    @NotNull
    public IHeapValues<V> plus(@NotNull CompanionV<V> var1);

    public int getSize();

    @NotNull
    public ImmutableSet<V> getValues();

    @NotNull
    public ImmutableSet<CompanionV<V>> getValuesCompanion();

    public boolean isNotEmpty();

    public boolean isEmpty();

    @NotNull
    public Builder<V> builder();

    public void map(@NotNull Builder<V> var1, @NotNull Function1<? super CompanionV<V>, ? extends CompanionV<V>> var2);

    public void flatMap(@NotNull Builder<V> var1, @NotNull Function1<? super CompanionV<V>, ? extends Collection<? extends CompanionV<V>>> var2);

    public boolean isSingle();

    @NotNull
    public CompanionV<V> getSingle();

    @Nullable
    public Set<Integer> getAllIntValue(boolean var1);

    @Nullable
    public Integer getMaxInt(boolean var1);

    @NotNull
    public Iterator<CompanionV<V>> iterator();

    @NotNull
    public IHeapValues<V> cloneAndReNewObjects(@NotNull IReNew<V> var1);
}

