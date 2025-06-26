/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.PathFactory
 *  cn.sast.dataflow.interprocedural.check.PathFactoryImpl
 *  cn.sast.dataflow.interprocedural.check.PathFactoryImpl$setModelData$pathReNew$1
 *  cn.sast.dataflow.interprocedural.check.PathFactoryImpl$updatePath$pathReNew$1
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.PathFactory;
import cn.sast.dataflow.interprocedural.check.PathFactoryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005JD\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007H\u0016Jh\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00102\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00102:\u0010\u0011\u001a6\u0012\u0017\u0012\u00150\u0002j\u0002`\u0003\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00160\u0012H\u0016\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/interprocedural/check/PathFactoryImpl;", "Lcn/sast/dataflow/interprocedural/check/PathFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "setModelData", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "obj", "mt", "", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "data", "updatePath", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "newPath", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "v", "Lcn/sast/dataflow/interprocedural/check/IPath;", "old", "corax-data-flow"})
public final class PathFactoryImpl
extends PathFactory<IValue> {
    @NotNull
    public IData<IValue> setModelData(@NotNull HeapValuesEnv env, @NotNull IValue obj, @NotNull Object mt, @NotNull IData<IValue> data) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)obj, (String)"obj");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        Intrinsics.checkNotNullParameter(data, (String)"data");
        setModelData.pathReNew.1 pathReNew2 = new /* Unavailable Anonymous Inner Class!! */;
        return data.cloneAndReNewObjects((IReNew)pathReNew2);
    }

    @NotNull
    public IHeapValues<IValue> updatePath(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> data, @NotNull Function2<? super IValue, ? super IPath, ? extends IPath> newPath) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter(newPath, (String)"newPath");
        updatePath.pathReNew.1 pathReNew2 = new /* Unavailable Anonymous Inner Class!! */;
        return data.cloneAndReNewObjects((IReNew)pathReNew2);
    }
}

