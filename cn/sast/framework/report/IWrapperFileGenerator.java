/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2={"Lcn/sast/framework/report/IWrapperFileGenerator;", "", "name", "", "getName", "()Ljava/lang/String;", "makeWrapperFile", "Lcn/sast/common/IResFile;", "fileWrapperOutPutDir", "Lcn/sast/common/IResDirectory;", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "getInternalFileName", "corax-framework"})
public interface IWrapperFileGenerator {
    @NotNull
    public String getName();

    @Nullable
    public IResFile makeWrapperFile(@NotNull IResDirectory var1, @NotNull IBugResInfo var2);

    @NotNull
    public String getInternalFileName(@NotNull IBugResInfo var1);
}

