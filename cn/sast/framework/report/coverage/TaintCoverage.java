/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.coverage.Coverage
 *  cn.sast.framework.report.coverage.TaintCoverage
 *  cn.sast.framework.report.coverage.TaintCoverage$flushCoverage$1
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.coverage;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.coverage.Coverage;
import cn.sast.framework.report.coverage.TaintCoverage;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lcn/sast/framework/report/coverage/TaintCoverage;", "Lcn/sast/framework/report/coverage/Coverage;", "<init>", "()V", "copyResource", "", "name", "", "to", "Lcn/sast/common/IResFile;", "changeColor", "reportOutputRoot", "Lcn/sast/common/IResDirectory;", "flushCoverage", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "outputDir", "encoding", "Ljava/nio/charset/Charset;", "(Lcn/sast/framework/report/IProjectFileLocator;Lcn/sast/common/IResDirectory;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nCoverageCompnment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoverageCompnment.kt\ncn/sast/framework/report/coverage/TaintCoverage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class TaintCoverage
extends Coverage {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void copyResource(String name, IResFile to) {
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream(to.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        Closeable closeable = outputStream;
        Throwable throwable = null;
        try {
            OutputStream it = (OutputStream)closeable;
            boolean bl = false;
            InputStream inputStream = TaintCoverage.class.getResourceAsStream(name);
            Intrinsics.checkNotNull((Object)inputStream);
            long l = ByteStreamsKt.copyTo$default((InputStream)inputStream, (OutputStream)it, (int)0, (int)2, null);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    public final void changeColor(@NotNull IResDirectory reportOutputRoot) {
        Intrinsics.checkNotNullParameter((Object)reportOutputRoot, (String)"reportOutputRoot");
        this.copyResource("/jacoco/taint-report.css", reportOutputRoot.resolve("jacoco-resources").resolve("report.css").toFile());
        this.copyResource("/jacoco/greenbar.gif", reportOutputRoot.resolve("jacoco-resources").resolve("redbar.gif").toFile());
        this.copyResource("/jacoco/redbar.gif", reportOutputRoot.resolve("jacoco-resources").resolve("greenbar.gif").toFile());
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object flushCoverage(@NotNull IProjectFileLocator var1_1, @NotNull IResDirectory var2_2, @NotNull Charset var3_3, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof flushCoverage.1)) ** GOTO lbl-1000
        var8_5 = $completion;
        if ((var8_5.label & -2147483648) != 0) {
            var8_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = outputDir;
                $continuation.label = 1;
                v0 = super.flushCoverage((IProjectFileLocator)locator, outputDir, (Charset)encoding, (Continuation)$continuation);
                if (v0 == var9_7) {
                    return var9_7;
                }
                ** GOTO lbl24
            }
            case 1: {
                outputDir = (IResDirectory)$continuation.L$1;
                this = (TaintCoverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                var5_8 = Unit.INSTANCE;
                $i$a$-also-TaintCoverage$flushCoverage$2 = false;
                this.changeColor(outputDir);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

