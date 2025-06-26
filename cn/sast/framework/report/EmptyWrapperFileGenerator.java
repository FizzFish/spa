/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.EmptyWrapperFileGenerator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.IWrapperFileGenerator$DefaultImpls
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IWrapperFileGenerator;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/report/EmptyWrapperFileGenerator;", "Lcn/sast/framework/report/IWrapperFileGenerator;", "<init>", "()V", "logger", "Lmu/KLogger;", "name", "", "getName", "()Ljava/lang/String;", "makeWrapperFileContent", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "makeWrapperFile", "Lcn/sast/common/IResFile;", "fileWrapperOutPutDir", "Lcn/sast/common/IResDirectory;", "corax-framework"})
public final class EmptyWrapperFileGenerator
implements IWrapperFileGenerator {
    @NotNull
    public static final EmptyWrapperFileGenerator INSTANCE = new EmptyWrapperFileGenerator();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(EmptyWrapperFileGenerator::logger$lambda$0);

    private EmptyWrapperFileGenerator() {
    }

    @NotNull
    public String getName() {
        return "empty";
    }

    private final String makeWrapperFileContent(IBugResInfo resInfo) {
        String string;
        if (resInfo instanceof ClassResInfo) {
            int maxLine = ((ClassResInfo)resInfo).getMaxLine();
            if (maxLine > 8000) {
                maxLine = 8000;
            }
            string = StringsKt.repeat((CharSequence)"\n", (int)maxLine);
        } else {
            string = "\n";
        }
        String text2 = string;
        return text2;
    }

    @Nullable
    public IResFile makeWrapperFile(@NotNull IResDirectory fileWrapperOutPutDir, @NotNull IBugResInfo resInfo) {
        Intrinsics.checkNotNullParameter((Object)fileWrapperOutPutDir, (String)"fileWrapperOutPutDir");
        Intrinsics.checkNotNullParameter((Object)resInfo, (String)"resInfo");
        String fileName = this.getInternalFileName(resInfo);
        IResFile missingSourceFile = fileWrapperOutPutDir.resolve(this.getName()).resolve(fileName).toFile();
        if (missingSourceFile.getExists()) {
            if (missingSourceFile.isFile()) {
                return missingSourceFile;
            }
            logger.error(() -> EmptyWrapperFileGenerator.makeWrapperFile$lambda$1(missingSourceFile));
            return null;
        }
        String text2 = this.makeWrapperFileContent(resInfo);
        try {
            IResource iResource = missingSourceFile.getParent();
            if (iResource != null) {
                iResource.mkdirs();
            }
            ResourceKt.writeText$default((IResFile)missingSourceFile, (String)text2, null, (int)2, null);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return missingSourceFile.toFile();
    }

    @NotNull
    public String getInternalFileName(@NotNull IBugResInfo resInfo) {
        return IWrapperFileGenerator.DefaultImpls.getInternalFileName((IWrapperFileGenerator)this, (IBugResInfo)resInfo);
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Object makeWrapperFile$lambda$1(IResFile $missingSourceFile) {
        return "duplicate folder exists " + $missingSourceFile;
    }
}

