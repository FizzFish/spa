/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  enums.AdviceEnum
 *  utils.EnumUtils
 */
package utils;

import enums.AdviceEnum;

public class EnumUtils {
    public static AdviceEnum getEnumObject(Object value) {
        for (AdviceEnum adviceEnum : AdviceEnum.values()) {
            if (!adviceEnum.getAnnotationClassName().equals(value)) continue;
            return adviceEnum;
        }
        return null;
    }
}

