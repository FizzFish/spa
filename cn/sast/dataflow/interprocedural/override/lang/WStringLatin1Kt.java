package cn.sast.dataflow.interprocedural.override.lang;

public final class WStringLatin1Kt {
    public static boolean canEncode(int cp) {
        return cp >>> 8 == 0;
    }
}