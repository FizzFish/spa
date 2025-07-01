package cn.sast.dataflow.analysis.constant;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public class CPValue {
    private int value;
    
    @NotNull
    private static final CPValue nac = new CPValue() {
        @Override
        public String toString() {
            return "NAC";
        }
    };
    
    @NotNull
    private static final CPValue undef = new CPValue() {
        @Override
        public String toString() {
            return "UNDEF";
        }
    };

    private CPValue() {
    }

    private CPValue(int val) {
        this.value = val;
    }

    public final int value() {
        return this.value;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (this == undef && other == nac) {
            return false;
        }
        if (this == nac && other == undef) {
            return false;
        }
        CPValue cpValue = (CPValue) other;
        return this.value == cpValue.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    @NotNull
    public String toString() {
        if (this == nac) {
            return "NAC";
        }
        return this == undef ? "UNDEF" : String.valueOf(this.value);
    }

    @NotNull
    public static CPValue makeConstant(int value) {
        return new CPValue(value);
    }

    @NotNull
    public static CPValue getNac() {
        return nac;
    }

    @NotNull
    public static CPValue getUndef() {
        return undef;
    }
}
