/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.JavaSourceLocatorKt
 *  cn.sast.framework.report.ListSuffixRelation
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import cn.sast.framework.report.ListSuffixRelation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a8\u0006\u0006"}, d2={"listEndsWith", "Lcn/sast/framework/report/ListSuffixRelation;", "array1", "", "", "array2", "corax-framework"})
public final class JavaSourceLocatorKt {
    @NotNull
    public static final ListSuffixRelation listEndsWith(@NotNull List<String> array1, @NotNull List<String> array2) {
        Intrinsics.checkNotNullParameter(array1, (String)"array1");
        Intrinsics.checkNotNullParameter(array2, (String)"array2");
        int minSize = Math.min(array1.size(), array2.size());
        if (minSize == 0) {
            return ListSuffixRelation.NeitherSuffix;
        }
        for (int i = 0; i < minSize; ++i) {
            if (Intrinsics.areEqual((Object)array1.get(array1.size() - minSize + i), (Object)array2.get(array2.size() - minSize + i))) continue;
            return ListSuffixRelation.NeitherSuffix;
        }
        return array1.size() < array2.size() ? ListSuffixRelation.AIsSuffixOfB : (array1.size() > array2.size() ? ListSuffixRelation.BIsSuffixOfA : ListSuffixRelation.Equals);
    }
}

