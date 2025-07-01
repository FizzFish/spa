package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Serializable
@SerialName("QualifiedRefType")
public class QualifiedRefType implements IClassMatch {
    @NotNull
    private final List<String> packageNames;
    @NotNull
    private final List<String> simpleNames;
    private final List<String> typeCache;

    public QualifiedRefType(@NotNull List<String> packageNames, @NotNull List<String> simpleNames) {
        Objects.requireNonNull(packageNames, "packageNames");
        Objects.requireNonNull(simpleNames, "simpleNames");
        this.packageNames = Collections.unmodifiableList(new ArrayList<>(packageNames));
        this.simpleNames = Collections.unmodifiableList(new ArrayList<>(simpleNames));
        this.typeCache = buildTypeCache();

        validateTypes();
    }

    public QualifiedRefType(@NotNull String packageName, @NotNull String simpleName) {
        this(List.of(packageName), List.of(simpleName));
    }

    public QualifiedRefType(@NotNull List<String> packageNames, @NotNull String simpleName) {
        this(packageNames, List.of(simpleName));
    }

    public QualifiedRefType(@NotNull String packageName, @NotNull List<String> simpleNames) {
        this(List.of(packageName), simpleNames);
    }

    public QualifiedRefType(@NotNull String typeName) {
        this(List.of(QualifiedRefTypeKt.splitPackage(typeName).getFirst()), 
             List.of(QualifiedRefTypeKt.splitPackage(typeName).getSecond()));
    }

    @NotNull
    public List<String> getPackageNames() {
        return packageNames;
    }

    @Override
    @NotNull
    public List<String> getSimpleNames() {
        return simpleNames;
    }

    @NotNull
    public List<String> getTypes() {
        return typeCache;
    }

    @NotNull
    public List<RefType> getSootTypes() {
        return getTypes().stream()
                .map(Scene.v()::getRefTypeUnsafe)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    @NotNull
    public List<SootClass> matched(@NotNull Scene scene) {
        Objects.requireNonNull(scene, "scene");
        return getSootTypes().stream()
                .filter(RefType::hasSootClass)
                .map(RefType::getSootClass)
                .collect(Collectors.toList());
    }

    @Override
    @NotNull
    public String toString() {
        if (getTypes().size() == 1) {
            return getTypes().get(0);
        }
        return "[" + String.join(", ", getTypes()) + "]";
    }

    private List<String> buildTypeCache() {
        List<String> types = new ArrayList<>();
        for (String pkg : packageNames) {
            for (String name : simpleNames) {
                types.add(pkg + "." + name);
            }
        }
        return Collections.unmodifiableList(types);
    }

    private void validateTypes() {
        for (String type : getTypes()) {
            if (type.contains("/") || type.contains("\\")) {
                throw new IllegalArgumentException("Invalid type signature: " + type);
            }
        }

        if (getTypes().isEmpty()) {
            throw new IllegalStateException("Empty type specification: " + this);
        }

        if (getTypes().stream().anyMatch(String::isEmpty)) {
            throw new IllegalStateException("Empty type component in: " + this);
        }
    }

    @JvmStatic
    public static void write$Self(QualifiedRefType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<?>[] childSerializers = new KSerializer[]{
                new ArrayListSerializer(StringSerializer.INSTANCE),
                new ArrayListSerializer(StringSerializer.INSTANCE)
        };
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) childSerializers[0], self.packageNames);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) childSerializers[1], self.getSimpleNames());
    }

    public static final class Companion {
        public static final Companion INSTANCE = new Companion();

        private Companion() {}

        @NotNull
        public KSerializer<QualifiedRefType> serializer() {
            return QualifiedRefType$.INSTANCE;
        }
    }
}
