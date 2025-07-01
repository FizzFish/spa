package cn.sast.dataflow.interprocedural.check.checker;

import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import org.jetbrains.annotations.NotNull;

public final class CheckerModelingKt {
    @NotNull
    private static final Object KeyTaintProperty = TaintProperty.INSTANCE;
    @NotNull
    private static final Object KeyViaProperty = ViaProperty.INSTANCE;
    @NotNull
    private static final Object KeyAttribute = new Object();

    @NotNull
    public static Object getKeyTaintProperty() {
        return KeyTaintProperty;
    }

    @NotNull
    public static Object getKeyViaProperty() {
        return KeyViaProperty;
    }

    @NotNull
    public static Object getKeyAttribute() {
        return KeyAttribute;
    }
}