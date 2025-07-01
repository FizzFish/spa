package cn.sast.dataflow.interprocedural.analysis;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class ACheckCallAnalysisKt {
    private static final Set<String> excludeSubSignature = Set.of(
        "java.lang.String toString()",
        "boolean equals(java.lang.Object)",
        "int hashCode()",
        "java.lang.Object clone()"
    );

    @NotNull
    public static Set<String> getExcludeSubSignature() {
        return excludeSubSignature;
    }

    public static void AnalysisInSummary$annotations() {
    }
}