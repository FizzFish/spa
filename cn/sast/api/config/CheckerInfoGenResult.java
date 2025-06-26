/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ChapterFlat
 *  cn.sast.api.config.CheckerInfo
 *  cn.sast.api.config.CheckerInfoGenResult
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import com.feysh.corax.config.api.CheckType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005H\u00c6\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005H\u00c6\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005H\u00c6\u0003Jq\u0010\u001b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\tH\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2={"Lcn/sast/api/config/CheckerInfoGenResult;", "", "checkerInfoList", "Ljava/util/LinkedHashSet;", "Lcn/sast/api/config/CheckerInfo;", "Lkotlin/collections/LinkedHashSet;", "existsCheckTypes", "Lcom/feysh/corax/config/api/CheckType;", "existsCheckerIds", "", "checkerIdInCsv", "<init>", "(Ljava/util/LinkedHashSet;Ljava/util/LinkedHashSet;Ljava/util/LinkedHashSet;Ljava/util/LinkedHashSet;)V", "getCheckerInfoList", "()Ljava/util/LinkedHashSet;", "getExistsCheckTypes", "getExistsCheckerIds", "getCheckerIdInCsv", "chapters", "", "Lcn/sast/api/config/ChapterFlat;", "getChapters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-api"})
@SourceDebugExtension(value={"SMAP\nCheckerInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerInfo.kt\ncn/sast/api/config/CheckerInfoGenResult\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1611#2,9:50\n1863#2:59\n1864#2:61\n1620#2:62\n1#3:60\n*S KotlinDebug\n*F\n+ 1 CheckerInfo.kt\ncn/sast/api/config/CheckerInfoGenResult\n*L\n48#1:50,9\n48#1:59\n48#1:61\n48#1:62\n48#1:60\n*E\n"})
public final class CheckerInfoGenResult {
    @NotNull
    private final LinkedHashSet<CheckerInfo> checkerInfoList;
    @NotNull
    private final LinkedHashSet<CheckType> existsCheckTypes;
    @NotNull
    private final LinkedHashSet<String> existsCheckerIds;
    @NotNull
    private final LinkedHashSet<String> checkerIdInCsv;

    public CheckerInfoGenResult(@NotNull LinkedHashSet<CheckerInfo> checkerInfoList, @NotNull LinkedHashSet<CheckType> existsCheckTypes, @NotNull LinkedHashSet<String> existsCheckerIds, @NotNull LinkedHashSet<String> checkerIdInCsv) {
        Intrinsics.checkNotNullParameter(checkerInfoList, (String)"checkerInfoList");
        Intrinsics.checkNotNullParameter(existsCheckTypes, (String)"existsCheckTypes");
        Intrinsics.checkNotNullParameter(existsCheckerIds, (String)"existsCheckerIds");
        Intrinsics.checkNotNullParameter(checkerIdInCsv, (String)"checkerIdInCsv");
        this.checkerInfoList = checkerInfoList;
        this.existsCheckTypes = existsCheckTypes;
        this.existsCheckerIds = existsCheckerIds;
        this.checkerIdInCsv = checkerIdInCsv;
    }

    @NotNull
    public final LinkedHashSet<CheckerInfo> getCheckerInfoList() {
        return this.checkerInfoList;
    }

    @NotNull
    public final LinkedHashSet<CheckType> getExistsCheckTypes() {
        return this.existsCheckTypes;
    }

    @NotNull
    public final LinkedHashSet<String> getExistsCheckerIds() {
        return this.existsCheckerIds;
    }

    @NotNull
    public final LinkedHashSet<String> getCheckerIdInCsv() {
        return this.checkerIdInCsv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<ChapterFlat> getChapters() {
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = this.checkerInfoList;
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            ChapterFlat it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl = false;
            CheckerInfo it = (CheckerInfo)element$iv$iv;
            boolean bl2 = false;
            if (it.getChapterFlat() == null) continue;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public final LinkedHashSet<CheckerInfo> component1() {
        return this.checkerInfoList;
    }

    @NotNull
    public final LinkedHashSet<CheckType> component2() {
        return this.existsCheckTypes;
    }

    @NotNull
    public final LinkedHashSet<String> component3() {
        return this.existsCheckerIds;
    }

    @NotNull
    public final LinkedHashSet<String> component4() {
        return this.checkerIdInCsv;
    }

    @NotNull
    public final CheckerInfoGenResult copy(@NotNull LinkedHashSet<CheckerInfo> checkerInfoList, @NotNull LinkedHashSet<CheckType> existsCheckTypes, @NotNull LinkedHashSet<String> existsCheckerIds, @NotNull LinkedHashSet<String> checkerIdInCsv) {
        Intrinsics.checkNotNullParameter(checkerInfoList, (String)"checkerInfoList");
        Intrinsics.checkNotNullParameter(existsCheckTypes, (String)"existsCheckTypes");
        Intrinsics.checkNotNullParameter(existsCheckerIds, (String)"existsCheckerIds");
        Intrinsics.checkNotNullParameter(checkerIdInCsv, (String)"checkerIdInCsv");
        return new CheckerInfoGenResult(checkerInfoList, existsCheckTypes, existsCheckerIds, checkerIdInCsv);
    }

    public static /* synthetic */ CheckerInfoGenResult copy$default(CheckerInfoGenResult checkerInfoGenResult, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, LinkedHashSet linkedHashSet3, LinkedHashSet linkedHashSet4, int n, Object object) {
        if ((n & 1) != 0) {
            linkedHashSet = checkerInfoGenResult.checkerInfoList;
        }
        if ((n & 2) != 0) {
            linkedHashSet2 = checkerInfoGenResult.existsCheckTypes;
        }
        if ((n & 4) != 0) {
            linkedHashSet3 = checkerInfoGenResult.existsCheckerIds;
        }
        if ((n & 8) != 0) {
            linkedHashSet4 = checkerInfoGenResult.checkerIdInCsv;
        }
        return checkerInfoGenResult.copy(linkedHashSet, linkedHashSet2, linkedHashSet3, linkedHashSet4);
    }

    @NotNull
    public String toString() {
        return "CheckerInfoGenResult(checkerInfoList=" + this.checkerInfoList + ", existsCheckTypes=" + this.existsCheckTypes + ", existsCheckerIds=" + this.existsCheckerIds + ", checkerIdInCsv=" + this.checkerIdInCsv + ")";
    }

    public int hashCode() {
        int result = this.checkerInfoList.hashCode();
        result = result * 31 + this.existsCheckTypes.hashCode();
        result = result * 31 + this.existsCheckerIds.hashCode();
        result = result * 31 + this.checkerIdInCsv.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckerInfoGenResult)) {
            return false;
        }
        CheckerInfoGenResult checkerInfoGenResult = (CheckerInfoGenResult)other;
        if (!Intrinsics.areEqual((Object)this.checkerInfoList, (Object)checkerInfoGenResult.checkerInfoList)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.existsCheckTypes, (Object)checkerInfoGenResult.existsCheckTypes)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.existsCheckerIds, (Object)checkerInfoGenResult.existsCheckerIds)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.checkerIdInCsv, (Object)checkerInfoGenResult.checkerIdInCsv);
    }
}

