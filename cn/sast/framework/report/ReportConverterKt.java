package cn.sast.framework.report;

import java.lang.reflect.Field;

public final class ReportConverterKt {
    @SuppressWarnings("unchecked")
    public static <T> T getField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException {
        if (obj == null) {
            throw new NullPointerException("<this>");
        }
        if (name == null) {
            throw new NullPointerException("name");
        }

        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return (T) field.get(obj);
    }
}