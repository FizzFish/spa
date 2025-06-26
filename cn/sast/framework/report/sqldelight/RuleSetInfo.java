/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.RuleSetInfo
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003Jf\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006)"}, d2={"Lcn/sast/framework/report/sqldelight/RuleSetInfo;", "", "name", "", "language", "description", "prefix", "id_pattern", "section_level", "", "version", "revision", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLanguage", "getDescription", "getPrefix", "getId_pattern", "getSection_level", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVersion", "getRevision", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcn/sast/framework/report/sqldelight/RuleSetInfo;", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class RuleSetInfo {
    @NotNull
    private final String name;
    @NotNull
    private final String language;
    @Nullable
    private final String description;
    @Nullable
    private final String prefix;
    @Nullable
    private final String id_pattern;
    @Nullable
    private final Long section_level;
    @NotNull
    private final String version;
    @NotNull
    private final String revision;

    public RuleSetInfo(@NotNull String name, @NotNull String language, @Nullable String description, @Nullable String prefix, @Nullable String id_pattern, @Nullable Long section_level, @NotNull String version, @NotNull String revision) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)revision, (String)"revision");
        this.name = name;
        this.language = language;
        this.description = description;
        this.prefix = prefix;
        this.id_pattern = id_pattern;
        this.section_level = section_level;
        this.version = version;
        this.revision = revision;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getPrefix() {
        return this.prefix;
    }

    @Nullable
    public final String getId_pattern() {
        return this.id_pattern;
    }

    @Nullable
    public final Long getSection_level() {
        return this.section_level;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final String getRevision() {
        return this.revision;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.language;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.prefix;
    }

    @Nullable
    public final String component5() {
        return this.id_pattern;
    }

    @Nullable
    public final Long component6() {
        return this.section_level;
    }

    @NotNull
    public final String component7() {
        return this.version;
    }

    @NotNull
    public final String component8() {
        return this.revision;
    }

    @NotNull
    public final RuleSetInfo copy(@NotNull String name, @NotNull String language, @Nullable String description, @Nullable String prefix, @Nullable String id_pattern, @Nullable Long section_level, @NotNull String version, @NotNull String revision) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)revision, (String)"revision");
        return new RuleSetInfo(name, language, description, prefix, id_pattern, section_level, version, revision);
    }

    public static /* synthetic */ RuleSetInfo copy$default(RuleSetInfo ruleSetInfo, String string, String string2, String string3, String string4, String string5, Long l, String string6, String string7, int n, Object object) {
        if ((n & 1) != 0) {
            string = ruleSetInfo.name;
        }
        if ((n & 2) != 0) {
            string2 = ruleSetInfo.language;
        }
        if ((n & 4) != 0) {
            string3 = ruleSetInfo.description;
        }
        if ((n & 8) != 0) {
            string4 = ruleSetInfo.prefix;
        }
        if ((n & 0x10) != 0) {
            string5 = ruleSetInfo.id_pattern;
        }
        if ((n & 0x20) != 0) {
            l = ruleSetInfo.section_level;
        }
        if ((n & 0x40) != 0) {
            string6 = ruleSetInfo.version;
        }
        if ((n & 0x80) != 0) {
            string7 = ruleSetInfo.revision;
        }
        return ruleSetInfo.copy(string, string2, string3, string4, string5, l, string6, string7);
    }

    @NotNull
    public String toString() {
        return "RuleSetInfo(name=" + this.name + ", language=" + this.language + ", description=" + this.description + ", prefix=" + this.prefix + ", id_pattern=" + this.id_pattern + ", section_level=" + this.section_level + ", version=" + this.version + ", revision=" + this.revision + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.language.hashCode();
        result = result * 31 + (this.description == null ? 0 : this.description.hashCode());
        result = result * 31 + (this.prefix == null ? 0 : this.prefix.hashCode());
        result = result * 31 + (this.id_pattern == null ? 0 : this.id_pattern.hashCode());
        result = result * 31 + (this.section_level == null ? 0 : ((Object)this.section_level).hashCode());
        result = result * 31 + this.version.hashCode();
        result = result * 31 + this.revision.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleSetInfo)) {
            return false;
        }
        RuleSetInfo ruleSetInfo = (RuleSetInfo)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)ruleSetInfo.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.language, (Object)ruleSetInfo.language)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)ruleSetInfo.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.prefix, (Object)ruleSetInfo.prefix)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.id_pattern, (Object)ruleSetInfo.id_pattern)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.section_level, (Object)ruleSetInfo.section_level)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.version, (Object)ruleSetInfo.version)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.revision, (Object)ruleSetInfo.revision);
    }
}

