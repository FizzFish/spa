package cn.sast.dataflow.interprocedural.check.printer;

import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import soot.Type;

public final class EventPrinterKt {
    @NotNull
    public static String getPname(@NotNull Type type) {
        if (type == null) {
            throw new NullPointerException("<this>");
        }
        
        String typename = UtilsKt.getTypename(type);
        if (typename == null) {
            return type.toString();
        }
        
        if (typename.startsWith("java.lang.")) {
            return typename.substring("java.lang.".length());
        }
        return typename;
    }
}