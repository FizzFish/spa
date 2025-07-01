package com.feysh.corax.config.builtin.standard;

import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.IStandard;
import org.jetbrains.annotations.NotNull;

public enum BuiltinFeyshRules implements IRule {
    DeadCode("feysh.java.dead-code", BuiltinCWERules.CWE561_DeadCode.getDesc()),
    DefineUnused("feysh.java.define-unused", BuiltinCWERules.CWE563_UnusedVariable.getDesc()),
    DeadStore("feysh.java.dead-store", "cwe-563");

    @NotNull
    private final String realName;
    @NotNull
    private final String desc;
    @NotNull
    private final IStandard standard;

    BuiltinFeyshRules(@NotNull String realName, @NotNull String desc) {
        this.realName = realName;
        this.desc = desc;
        this.standard = BuiltinGeneralStandard.FEYSH;
    }

    @Override
    @NotNull
    public String getRealName() {
        return realName;
    }

    @Override
    @NotNull
    public String getDesc() {
        return desc;
    }

    @Override
    @NotNull
    public IStandard getStandard() {
        return standard;
    }
}