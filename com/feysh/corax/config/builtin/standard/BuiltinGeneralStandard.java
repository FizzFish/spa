/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.builtin.standard;

import com.feysh.corax.config.api.IStandard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/builtin/standard/BuiltinGeneralStandard;", "Lcom/feysh/corax/config/api/IStandard;", "", "realName", "", "desc", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRealName", "()Ljava/lang/String;", "getDesc", "FEYSH", "CWE", "CERT", "corax-config-api"})
public final class BuiltinGeneralStandard
extends Enum<BuiltinGeneralStandard>
implements IStandard {
    @NotNull
    private final String realName;
    @NotNull
    private final String desc;
    public static final /* enum */ BuiltinGeneralStandard FEYSH = new BuiltinGeneralStandard("feysh", "feysh standard");
    public static final /* enum */ BuiltinGeneralStandard CWE = new BuiltinGeneralStandard("cwe", "Common Weakness Enumeration. https://cwe.mitre.org/index.html");
    public static final /* enum */ BuiltinGeneralStandard CERT = new BuiltinGeneralStandard("cert", "SEI CERT Oracle Coding Standard for Java. https://wiki.sei.cmu.edu/confluence/display/java");
    private static final /* synthetic */ BuiltinGeneralStandard[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private BuiltinGeneralStandard(String realName, String desc) {
        this.realName = realName;
        this.desc = desc;
    }

    @Override
    @NotNull
    public String getRealName() {
        return this.realName;
    }

    @Override
    @NotNull
    public String getDesc() {
        return this.desc;
    }

    public static BuiltinGeneralStandard[] values() {
        return (BuiltinGeneralStandard[])$VALUES.clone();
    }

    public static BuiltinGeneralStandard valueOf(String value) {
        return Enum.valueOf(BuiltinGeneralStandard.class, value);
    }

    @NotNull
    public static EnumEntries<BuiltinGeneralStandard> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = builtinGeneralStandardArray = new BuiltinGeneralStandard[]{BuiltinGeneralStandard.FEYSH, BuiltinGeneralStandard.CWE, BuiltinGeneralStandard.CERT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

