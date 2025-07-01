package cn.sast.dataflow.interprocedural.analysis;

public abstract class ReferenceContext {
    private ReferenceContext() {
    }

    public static final class ArrayElement extends ReferenceContext {
    }

    public static final class ArraySize extends ReferenceContext {
    }

    public static final class ArrayInitialized extends ReferenceContext {
    }

    public static final class KVPosition extends ReferenceContext {
    }

    public static final class KVUnreferenced extends ReferenceContext {
    }

    public static final class ObjectValues extends ReferenceContext {
    }

    public static final class PTG extends ReferenceContext {
    }

    public static final class Slot extends ReferenceContext {
    }
}