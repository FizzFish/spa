/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.SpringAnnotationTag
 */
package analysis;

public class SpringAnnotationTag {
    public static final int BEAN = 1;
    public static final int PROTOTYPE = 2;
    public static final int MAPPER = 4;

    public static boolean isBean(int m) {
        return (m & 1) != 0;
    }

    public static boolean isPrototype(int m) {
        return (m & 2) != 0;
    }

    public static boolean isMapper(int m) {
        return (m & 4) != 0;
    }
}

