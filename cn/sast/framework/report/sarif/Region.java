/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Region
 *  cn.sast.framework.report.sarif.Region$$serializer
 *  cn.sast.framework.report.sarif.Region$Companion
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Region;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u0007\u0010\u000bB;\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0007\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001\u00a2\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006*"}, d2={"Lcn/sast/framework/report/sarif/Region;", "", "startLine", "", "startColumn", "endLine", "endColumn", "<init>", "(IIII)V", "region", "Lcom/feysh/corax/config/api/report/Region;", "(Lcom/feysh/corax/config/api/report/Region;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartLine", "()I", "getStartColumn", "getEndLine", "getEndColumn", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Region {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int startLine;
    private final int startColumn;
    private final int endLine;
    private final int endColumn;

    public Region(int startLine, int startColumn, int endLine, int endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public /* synthetic */ Region(int n, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 2) != 0) {
            n2 = 0;
        }
        if ((n5 & 4) != 0) {
            n3 = 0;
        }
        if ((n5 & 8) != 0) {
            n4 = 0;
        }
        this(n, n2, n3, n4);
    }

    public final int getStartLine() {
        return this.startLine;
    }

    public final int getStartColumn() {
        return this.startColumn;
    }

    public final int getEndLine() {
        return this.endLine;
    }

    public final int getEndColumn() {
        return this.endColumn;
    }

    public Region(@NotNull com.feysh.corax.config.api.report.Region region) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        this(Math.max(region.startLine, 0), Math.max(region.startColumn, 0), Math.max(region.getEndLine(), 0), Math.max(region.getEndColumn() + 1, 0));
    }

    public final int component1() {
        return this.startLine;
    }

    public final int component2() {
        return this.startColumn;
    }

    public final int component3() {
        return this.endLine;
    }

    public final int component4() {
        return this.endColumn;
    }

    @NotNull
    public final Region copy(int startLine, int startColumn, int endLine, int endColumn) {
        return new Region(startLine, startColumn, endLine, endColumn);
    }

    public static /* synthetic */ Region copy$default(Region region, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = region.startLine;
        }
        if ((n5 & 2) != 0) {
            n2 = region.startColumn;
        }
        if ((n5 & 4) != 0) {
            n3 = region.endLine;
        }
        if ((n5 & 8) != 0) {
            n4 = region.endColumn;
        }
        return region.copy(n, n2, n3, n4);
    }

    @NotNull
    public String toString() {
        return "Region(startLine=" + this.startLine + ", startColumn=" + this.startColumn + ", endLine=" + this.endLine + ", endColumn=" + this.endColumn + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.startLine);
        result = result * 31 + Integer.hashCode(this.startColumn);
        result = result * 31 + Integer.hashCode(this.endLine);
        result = result * 31 + Integer.hashCode(this.endColumn);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Region)) {
            return false;
        }
        Region region = (Region)other;
        if (this.startLine != region.startLine) {
            return false;
        }
        if (this.startColumn != region.startColumn) {
            return false;
        }
        if (this.endLine != region.endLine) {
            return false;
        }
        return this.endColumn == region.endColumn;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Region self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.startLine);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.startColumn != 0) {
            output.encodeIntElement(serialDesc, 1, self.startColumn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.endLine != 0) {
            output.encodeIntElement(serialDesc, 2, self.endLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.endColumn != 0) {
            output.encodeIntElement(serialDesc, 3, self.endColumn);
        }
    }

    public /* synthetic */ Region(int seen0, int startLine, int startColumn, int endLine, int endColumn, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.startLine = startLine;
        this.startColumn = (seen0 & 2) == 0 ? 0 : startColumn;
        this.endLine = (seen0 & 4) == 0 ? 0 : endLine;
        this.endColumn = (seen0 & 8) == 0 ? 0 : endColumn;
    }
}

