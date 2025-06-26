/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.ClassResInfo$Companion
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.api.util.SootUtilsKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SourceLocator
 */
package cn.sast.api.report;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.util.SootUtilsKt;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SourceLocator;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0001H\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\rH\u00d6\u0001J\t\u0010'\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000bR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b\u00a8\u0006)"}, d2={"Lcn/sast/api/report/ClassResInfo;", "Lcn/sast/api/report/IBugResInfo;", "sc", "Lsoot/SootClass;", "<init>", "(Lsoot/SootClass;)V", "getSc", "()Lsoot/SootClass;", "path", "", "getPath", "()Ljava/lang/String;", "maxLine", "", "getMaxLine", "()I", "maxLine$delegate", "Lkotlin/Lazy;", "sourcePath", "getSourcePath", "sourcePath$delegate", "sourceFile", "Ljava/util/LinkedHashSet;", "getSourceFile", "()Ljava/util/LinkedHashSet;", "sourceFile$delegate", "reportFileName", "getReportFileName", "compareTo", "other", "reportHash", "c", "Lcn/sast/api/report/IReportHashCalculator;", "component1", "copy", "equals", "", "", "hashCode", "toString", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/ClassResInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class ClassResInfo
extends IBugResInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootClass sc;
    @NotNull
    private final Lazy maxLine$delegate;
    @NotNull
    private final Lazy sourcePath$delegate;
    @NotNull
    private final Lazy sourceFile$delegate;

    public ClassResInfo(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        super(null);
        this.sc = sc;
        this.maxLine$delegate = LazyKt.lazy(() -> ClassResInfo.maxLine_delegate$lambda$0(this));
        this.sourcePath$delegate = LazyKt.lazy(() -> ClassResInfo.sourcePath_delegate$lambda$1(this));
        this.sourceFile$delegate = LazyKt.lazy(() -> ClassResInfo.sourceFile_delegate$lambda$2(this));
    }

    @NotNull
    public final SootClass getSc() {
        return this.sc;
    }

    @NotNull
    public String getPath() {
        return ((String)CollectionsKt.first((Iterable)this.getSourceFile())).toString();
    }

    public final int getMaxLine() {
        Lazy lazy = this.maxLine$delegate;
        return ((Number)lazy.getValue()).intValue();
    }

    @Nullable
    public final String getSourcePath() {
        Lazy lazy = this.sourcePath$delegate;
        return (String)lazy.getValue();
    }

    @NotNull
    public final LinkedHashSet<String> getSourceFile() {
        Lazy lazy = this.sourceFile$delegate;
        return (LinkedHashSet)lazy.getValue();
    }

    @NotNull
    public String getReportFileName() {
        String[] stringArray;
        Object object = this.getSourcePath();
        if (object == null || (object = StringsKt.split$default((CharSequence)((CharSequence)object), (String[])(stringArray = new String[]{"/"}), (boolean)false, (int)0, (int)6, null)) == null || (object = (String)CollectionsKt.lastOrNull((List)object)) == null) {
            object = SourceLocator.v().getSourceForClass(this.sc.getShortJavaStyleName()) + ".java";
        }
        return object;
    }

    public int compareTo(@NotNull IBugResInfo other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        if (!(other instanceof ClassResInfo)) {
            String string = this.getClass().getSimpleName();
            String string2 = other.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getSimpleName(...)");
            return string.compareTo(string2);
        }
        String string = this.sc.getName();
        String string3 = ((ClassResInfo)other).sc.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getName(...)");
        Integer n2 = string.compareTo(string3);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return c.from(this.sc);
    }

    @NotNull
    public final SootClass component1() {
        return this.sc;
    }

    @NotNull
    public final ClassResInfo copy(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        return new ClassResInfo(sc);
    }

    public static /* synthetic */ ClassResInfo copy$default(ClassResInfo classResInfo, SootClass sootClass, int n, Object object) {
        if ((n & 1) != 0) {
            sootClass = classResInfo.sc;
        }
        return classResInfo.copy(sootClass);
    }

    @NotNull
    public String toString() {
        return "ClassResInfo(sc=" + this.sc + ")";
    }

    public int hashCode() {
        return this.sc.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassResInfo)) {
            return false;
        }
        ClassResInfo classResInfo = (ClassResInfo)other;
        return Intrinsics.areEqual((Object)this.sc, (Object)classResInfo.sc);
    }

    private static final int maxLine_delegate$lambda$0(ClassResInfo this$0) {
        return SootUtilsKt.getNumCode((SootClass)this$0.sc);
    }

    private static final String sourcePath_delegate$lambda$1(ClassResInfo this$0) {
        return SootUtilsKt.getSourcePath((SootClass)this$0.sc);
    }

    private static final LinkedHashSet sourceFile_delegate$lambda$2(ClassResInfo this$0) {
        return SootUtilsKt.getPossibleSourceFiles((SootClass)this$0.sc);
    }
}

