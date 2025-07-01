package com.feysh.corax.config.builtin.standard;

import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.IStandard;
import org.jetbrains.annotations.NotNull;

public enum BuiltinCWERules implements IRule {
    CWE561_DeadCode("cwe-561", "Contains dead code, which can never be executed"),
    CWE563_UnusedVariable("cwe-563", "Assignment to Variable without Use");

    @NotNull
    private final String realName;
    @NotNull
    private final String desc;
    @NotNull
    private final IStandard standard;

    BuiltinCWERules(@NotNull String realName, @NotNull String desc) {
        this.realName = realName;
        this.desc = desc;
        this.standard = BuiltinGeneralStandard.CWE;
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