/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.validator.PrecisionMeasurementKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.validator;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0007"}, d2={"ExpectBugType", "Lcn/sast/api/report/ExpectBugAnnotationData;", "", "fm", "", "getFm", "(F)Ljava/lang/String;", "corax-framework"})
public final class PrecisionMeasurementKt {
    @NotNull
    public static final String getFm(float $this$fm) {
        String string = "%.2f";
        Object[] objectArray = new Object[]{Float.valueOf($this$fm)};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }
}

