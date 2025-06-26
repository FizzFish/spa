/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.ReportConverterKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package cn.sast.framework.report;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u00a2\u0006\u0002\u0010\u0007*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u00a8\u0006\b"}, d2={"JavaDecompileUnit", "", "getField", "T", "", "name", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "corax-framework"})
public final class ReportConverterKt {
    public static final /* synthetic */ <T> T getField(Object $this$getField, String name) {
        Intrinsics.checkNotNullParameter((Object)$this$getField, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        boolean $i$f$getField = false;
        Field it = $this$getField.getClass().getDeclaredField(name);
        boolean bl = false;
        it.setAccessible(true);
        Object object = it.get($this$getField);
        Intrinsics.reifiedOperationMarker((int)2, (String)"T");
        return (T)object;
    }
}

