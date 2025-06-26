/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.graph.GraphPlotKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.util.dot.DotGraph
 */
package cn.sast.graph;

import cn.sast.common.IResFile;
import java.io.Closeable;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.util.dot.DotGraph;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"dump", "", "Lsoot/util/dot/DotGraph;", "output", "Lcn/sast/common/IResFile;", "corax-api"})
public final class GraphPlotKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void dump(@NotNull DotGraph $this$dump, @NotNull IResFile output) {
        Intrinsics.checkNotNullParameter((Object)$this$dump, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream(output.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        Closeable closeable = outputStream;
        Throwable throwable = null;
        try {
            OutputStream out = (OutputStream)closeable;
            boolean bl = false;
            $this$dump.render(out, 0);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }
}

