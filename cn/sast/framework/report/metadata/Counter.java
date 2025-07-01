package cn.sast.framework.report.metadata;

import kotlinx.serialization.Serializable;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class Counter {
    private int missed;
    private int covered;

    public Counter(int missed, int covered) {
        this.missed = missed;
        this.covered = covered;
    }

    public int getMissed() {
        return missed;
    }

    public void setMissed(int missed) {
        this.missed = missed;
    }

    @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
    public static void getMissed$annotations() {
    }

    public int getCovered() {
        return covered;
    }

    public void setCovered(int covered) {
        this.covered = covered;
    }

    @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
    public static void getCovered$annotations() {
    }

    public int component1() {
        return missed;
    }

    public int component2() {
        return covered;
    }

    @NotNull
    public Counter copy(int missed, int covered) {
        return new Counter(missed, covered);
    }

    @Override
    public @NotNull String toString() {
        return "Counter(missed=" + missed + ", covered=" + covered + ")";
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(missed);
        result = result * 31 + Integer.hashCode(covered);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Counter)) return false;
        Counter counter = (Counter) other;
        return missed == counter.missed && covered == counter.covered;
    }

    public static void write$Self$corax_framework(Counter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.missed);
        output.encodeIntElement(serialDesc, 1, self.covered);
    }
}