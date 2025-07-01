package cn.sast.framework.plugin;

import java.io.Serializable;
import java.util.Comparator;

public abstract class ConfigSerializable implements IConfig, Comparable<ConfigSerializable>, Serializable {
    private static final long serialVersionUID = 1L;

    protected ConfigSerializable() {
    }

    public abstract String getName();

    @Override
    public int compareTo(ConfigSerializable other) {
        if (other == null) {
            throw new NullPointerException("other cannot be null");
        }
        
        int classCompare = this.getClass().getName().compareTo(other.getClass().getName());
        if (classCompare != 0) {
            return classCompare;
        }
        return this.getName().compareTo(other.getName());
    }

    public static final class Companion {
        private Companion() {
        }
    }
}