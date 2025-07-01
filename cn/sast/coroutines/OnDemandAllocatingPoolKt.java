package cn.sast.coroutines;

@FunctionalInterface
public interface Runnable {
    void run();
}

public final class OnDemandAllocatingPoolKt {
    private static final int IS_CLOSED_MASK = Integer.MIN_VALUE;

    private static Void loop(Runnable block) {
        while (true) {
            block.run();
        }
    }
}