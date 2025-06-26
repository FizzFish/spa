/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.framework.result.IUTBotResultCollector
 *  kotlin.Metadata
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import kotlin.Metadata;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2={"Lcn/sast/framework/result/IUTBotResultCollector;", "Lcn/sast/api/report/IResultCollector;", "addUtState", "", "corax-framework"})
public interface IUTBotResultCollector
extends IResultCollector {
    public void addUtState();
}

