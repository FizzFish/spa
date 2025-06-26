/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  utils.Ref
 */
package utils;

public class Ref<T> {
    private T value;

    public Ref(T value) {
        this.value = value;
    }

    public T get() {
        return (T)this.value;
    }

    public void set(T anotherValue) {
        this.value = anotherValue;
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object obj) {
        return this.value.equals(obj);
    }

    public int hashCode() {
        return this.value.hashCode();
    }
}

