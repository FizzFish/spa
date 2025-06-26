/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.IWrapperFileGenerator$DefaultImpls
 *  cn.sast.framework.report.NullWrapperFileGenerator
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IWrapperFileGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lcn/sast/framework/report/NullWrapperFileGenerator;", "Lcn/sast/framework/report/IWrapperFileGenerator;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "makeWrapperFile", "Lcn/sast/common/IResFile;", "fileWrapperOutPutDir", "Lcn/sast/common/IResDirectory;", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "corax-framework"})
public final class NullWrapperFileGenerator
implements IWrapperFileGenerator {
    @NotNull
    public static final NullWrapperFileGenerator INSTANCE = new NullWrapperFileGenerator();

    private NullWrapperFileGenerator() {
    }

    @NotNull
    public String getName() {
        return "null";
    }

    @Nullable
    public IResFile makeWrapperFile(@NotNull IResDirectory fileWrapperOutPutDir, @NotNull IBugResInfo resInfo) {
        Intrinsics.checkNotNullParameter((Object)fileWrapperOutPutDir, (String)"fileWrapperOutPutDir");
        Intrinsics.checkNotNullParameter((Object)resInfo, (String)"resInfo");
        return null;
    }

    @NotNull
    public String getInternalFileName(@NotNull IBugResInfo resInfo) {
        return IWrapperFileGenerator.DefaultImpls.getInternalFileName((IWrapperFileGenerator)this, (IBugResInfo)resInfo);
    }
}

