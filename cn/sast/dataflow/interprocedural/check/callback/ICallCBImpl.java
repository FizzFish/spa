/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 */
package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.idfa.check.ICallCB;
import org.jetbrains.annotations.NotNull;

public interface ICallCBImpl<V, R> extends ICallCB<V, R> {
    @NotNull
    HookEnv getEnv();

    @NotNull
    AnyNewExprEnv getNewEnv();

    @NotNull
    AbstractHeapFactory<IValue> getHf();
}