package com.feysh.corax.config.builtin.standard;

import com.feysh.corax.config.api.IStandard;
import org.jetbrains.annotations.NotNull;

public enum BuiltinGeneralStandard implements IStandard {
    FEYSH("feysh", "feysh standard"),
    CWE("cwe", "Common Weakness Enumeration. https://cwe.mitre.org/index.html"),
    CERT("cert", "SEI CERT Oracle Coding Standard for Java. https://wiki.sei.cmu.edu/confluence/display/java");

    @NotNull
    private final String realName;
    @NotNull
    private final String desc;

    BuiltinGeneralStandard(@NotNull String realName, @NotNull String desc) {
        this.realName = realName;
        this.desc = desc;
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
}