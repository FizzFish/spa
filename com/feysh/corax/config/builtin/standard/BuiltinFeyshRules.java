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

import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.IStandard;
import com.feysh.corax.config.builtin.standard.BuiltinCWERules;
import com.feysh.corax.config.builtin.standard.BuiltinGeneralStandard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/builtin/standard/BuiltinFeyshRules;", "Lcom/feysh/corax/config/api/IRule;", "", "realName", "", "desc", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRealName", "()Ljava/lang/String;", "getDesc", "DeadCode", "DefineUnused", "DeadStore", "standard", "Lcom/feysh/corax/config/api/IStandard;", "getStandard", "()Lcom/feysh/corax/config/api/IStandard;", "corax-config-api"})
public final class BuiltinFeyshRules
extends Enum<BuiltinFeyshRules>
implements IRule {
    @NotNull
    private final String realName;
    @NotNull
    private final String desc;
    @NotNull
    private final IStandard standard;
    public static final /* enum */ BuiltinFeyshRules DeadCode = new BuiltinFeyshRules("feysh.java.dead-code", BuiltinCWERules.CWE561_DeadCode.getDesc());
    public static final /* enum */ BuiltinFeyshRules DefineUnused = new BuiltinFeyshRules("feysh.java.define-unused", BuiltinCWERules.CWE563_UnusedVariable.getDesc());
    public static final /* enum */ BuiltinFeyshRules DeadStore = new BuiltinFeyshRules("feysh.java.dead-store", "cwe-563");
    private static final /* synthetic */ BuiltinFeyshRules[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private BuiltinFeyshRules(String realName, String desc) {
        this.realName = realName;
        this.desc = desc;
        this.standard = BuiltinGeneralStandard.FEYSH;
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

    @Override
    @NotNull
    public IStandard getStandard() {
        return this.standard;
    }

    public static BuiltinFeyshRules[] values() {
        return (BuiltinFeyshRules[])$VALUES.clone();
    }

    public static BuiltinFeyshRules valueOf(String value) {
        return Enum.valueOf(BuiltinFeyshRules.class, value);
    }

    @NotNull
    public static EnumEntries<BuiltinFeyshRules> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = builtinFeyshRulesArray = new BuiltinFeyshRules[]{BuiltinFeyshRules.DeadCode, BuiltinFeyshRules.DefineUnused, BuiltinFeyshRules.DeadStore};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

