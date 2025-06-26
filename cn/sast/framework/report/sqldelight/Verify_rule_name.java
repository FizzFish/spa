/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Verify_rule_name
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqldelight;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lcn/sast/framework/report/sqldelight/Verify_rule_name;", "", "id", "", "rule_name", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getRule_name", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class Verify_rule_name {
    private final long id;
    @NotNull
    private final String rule_name;

    public Verify_rule_name(long id, @NotNull String rule_name) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        this.id = id;
        this.rule_name = rule_name;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getRule_name() {
        return this.rule_name;
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.rule_name;
    }

    @NotNull
    public final Verify_rule_name copy(long id, @NotNull String rule_name) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        return new Verify_rule_name(id, rule_name);
    }

    public static /* synthetic */ Verify_rule_name copy$default(Verify_rule_name verify_rule_name, long l, String string, int n, Object object) {
        if ((n & 1) != 0) {
            l = verify_rule_name.id;
        }
        if ((n & 2) != 0) {
            string = verify_rule_name.rule_name;
        }
        return verify_rule_name.copy(l, string);
    }

    @NotNull
    public String toString() {
        return "Verify_rule_name(id=" + this.id + ", rule_name=" + this.rule_name + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + this.rule_name.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Verify_rule_name)) {
            return false;
        }
        Verify_rule_name verify_rule_name = (Verify_rule_name)other;
        if (this.id != verify_rule_name.id) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rule_name, (Object)verify_rule_name.rule_name);
    }
}

