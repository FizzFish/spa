/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.RuleMapping
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2={"Lcn/sast/framework/report/sqldelight/RuleMapping;", "", "rule_name", "", "standard_name", "standard_rule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRule_name", "()Ljava/lang/String;", "getStandard_name", "getStandard_rule", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class RuleMapping {
    @NotNull
    private final String rule_name;
    @Nullable
    private final String standard_name;
    @Nullable
    private final String standard_rule;

    public RuleMapping(@NotNull String rule_name, @Nullable String standard_name, @Nullable String standard_rule) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        this.rule_name = rule_name;
        this.standard_name = standard_name;
        this.standard_rule = standard_rule;
    }

    @NotNull
    public final String getRule_name() {
        return this.rule_name;
    }

    @Nullable
    public final String getStandard_name() {
        return this.standard_name;
    }

    @Nullable
    public final String getStandard_rule() {
        return this.standard_rule;
    }

    @NotNull
    public final String component1() {
        return this.rule_name;
    }

    @Nullable
    public final String component2() {
        return this.standard_name;
    }

    @Nullable
    public final String component3() {
        return this.standard_rule;
    }

    @NotNull
    public final RuleMapping copy(@NotNull String rule_name, @Nullable String standard_name, @Nullable String standard_rule) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        return new RuleMapping(rule_name, standard_name, standard_rule);
    }

    public static /* synthetic */ RuleMapping copy$default(RuleMapping ruleMapping, String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string = ruleMapping.rule_name;
        }
        if ((n & 2) != 0) {
            string2 = ruleMapping.standard_name;
        }
        if ((n & 4) != 0) {
            string3 = ruleMapping.standard_rule;
        }
        return ruleMapping.copy(string, string2, string3);
    }

    @NotNull
    public String toString() {
        return "RuleMapping(rule_name=" + this.rule_name + ", standard_name=" + this.standard_name + ", standard_rule=" + this.standard_rule + ")";
    }

    public int hashCode() {
        int result = this.rule_name.hashCode();
        result = result * 31 + (this.standard_name == null ? 0 : this.standard_name.hashCode());
        result = result * 31 + (this.standard_rule == null ? 0 : this.standard_rule.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleMapping)) {
            return false;
        }
        RuleMapping ruleMapping = (RuleMapping)other;
        if (!Intrinsics.areEqual((Object)this.rule_name, (Object)ruleMapping.rule_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.standard_name, (Object)ruleMapping.standard_name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.standard_rule, (Object)ruleMapping.standard_rule);
    }
}

