/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResFile
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IProjectFileLocator$DefaultImpls
 *  cn.sast.framework.report.coverage.JacocoSourceLocator
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  org.apache.commons.io.FilenameUtils
 *  org.jacoco.report.InputStreamSourceFileLocator
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 */
package cn.sast.framework.report.coverage;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.IProjectFileLocator;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.jacoco.report.InputStreamSourceFileLocator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lcn/sast/framework/report/coverage/JacocoSourceLocator;", "Lorg/jacoco/report/InputStreamSourceFileLocator;", "sourceLocator", "Lcn/sast/framework/report/IProjectFileLocator;", "encoding", "", "tabWidth", "", "<init>", "(Lcn/sast/framework/report/IProjectFileLocator;Ljava/lang/String;I)V", "getSourceStream", "Ljava/io/InputStream;", "path", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nJacocoSourceLoator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JacocoSourceLoator.kt\ncn/sast/framework/report/coverage/JacocoSourceLocator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
public final class JacocoSourceLocator
extends InputStreamSourceFileLocator {
    @NotNull
    private final IProjectFileLocator sourceLocator;

    public JacocoSourceLocator(@NotNull IProjectFileLocator sourceLocator, @NotNull String encoding, int tabWidth) {
        Intrinsics.checkNotNullParameter((Object)sourceLocator, (String)"sourceLocator");
        Intrinsics.checkNotNullParameter((Object)encoding, (String)"encoding");
        super(encoding, tabWidth);
        this.sourceLocator = sourceLocator;
    }

    public /* synthetic */ JacocoSourceLocator(IProjectFileLocator iProjectFileLocator, String string, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            string = "utf-8";
        }
        if ((n2 & 4) != 0) {
            n = 4;
        }
        this(iProjectFileLocator, string, n);
    }

    @Nullable
    protected InputStream getSourceStream(@NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        char[] cArray = new char[]{'/', '\\'};
        IResFile iResFile = (IResFile)SequencesKt.firstOrNull((Sequence)this.sourceLocator.findFromFileIndexMap(StringsKt.split$default((CharSequence)path, (char[])cArray, (boolean)false, (int)0, (int)6, null), AbstractFileIndexer.Companion.getDefaultClassCompareMode()));
        if (iResFile != null) {
            IResFile it = iResFile;
            boolean bl = false;
            OpenOption[] openOptionArray = new OpenOption[]{};
            InputStream inputStream = Files.newInputStream(it.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
            return inputStream;
        }
        String ext = FilenameUtils.getExtension((String)path);
        if (ResourceKt.getJavaExtensions().contains(ext)) {
            IResFile src;
            Intrinsics.checkNotNull((Object)ext);
            String mayClassName = StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.removeSuffix((String)StringsKt.removeSuffix((String)path, (CharSequence)ext), (CharSequence)"."), (String)"/", (String)".", (boolean)false, (int)4, null), (String)"\\", (String)".", (boolean)false, (int)4, null);
            SootClass sc = Scene.v().getSootClassUnsafe(mayClassName, false);
            if (sc != null && (src = IProjectFileLocator.DefaultImpls.get$default((IProjectFileLocator)this.sourceLocator, (IBugResInfo)((IBugResInfo)ClassResInfo.Companion.of(sc)), null, (int)2, null)) != null) {
                OpenOption[] openOptionArray = new OpenOption[]{};
                InputStream inputStream = Files.newInputStream(src.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
                return inputStream;
            }
        }
        return null;
    }
}

