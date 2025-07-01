package cn.sast.api.config;

import org.jetbrains.annotations.NotNull;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SrcPrecedence {
    prec_class(1),
    prec_only_class(2),
    prec_jimple(3),
    prec_java(6),
    prec_java_soot(4),
    prec_apk(5),
    prec_apk_class_jimple(6),
    prec_dotnet(7);

    private final int sootFlag;
    private static final Map<String, SrcPrecedence> entries = 
        Stream.of(values()).collect(Collectors.toMap(Enum::name, e -> e));

    SrcPrecedence(int sootFlag) {
        this.sootFlag = sootFlag;
    }

    public int getSootFlag() {
        return sootFlag;
    }

    public boolean isSootJavaSourcePrec() {
        return this == prec_java_soot;
    }

    @NotNull
    public static Map<String, SrcPrecedence> getEntries() {
        return entries;
    }
}