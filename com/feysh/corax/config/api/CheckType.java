package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.ObjectSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Serializable
public abstract class CheckType {
    public static final Companion Companion = new Companion();
    private static final KSerializer<Object>[] CHILD_SERIALIZERS = new KSerializer[]{new LinkedHashSetSerializer(StringSerializer.INSTANCE)};
    
    @NotNull
    private final Set<String> aliasNames;

    public CheckType() {
        this.aliasNames = Collections.emptySet();
    }

    public CheckType(int seen0, Set<String> aliasNames, Object serializationConstructorMarker) {
        this.aliasNames = (seen0 & 1) == 0 ? Collections.emptySet() : aliasNames;
    }

    @NotNull
    public abstract IChecker getChecker();

    @NotNull
    public Set<String> getAliasNames() {
        return aliasNames;
    }

    @NotNull
    public abstract Map<Language, BugMessage> getBugMessage();

    @NotNull
    public IRule getReport() {
        return getChecker().getReport();
    }

    @NotNull
    public Set<IRule> getStandards() {
        Set<IRule> standards = new LinkedHashSet<>(getChecker().getStandards());
        standards.add(getReport());
        return standards;
    }

    @NotNull
    public final Set<IRule> getRulesByName(@NotNull String standardName) {
        return getStandards().stream()
                .filter(rule -> rule.getStandard().getRealName().equals(standardName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public String getSerializerName() {
        return getClass().getCanonicalName();
    }

    @NotNull
    public String getSimpleName() {
        return getClass().getSimpleName();
    }

    @NotNull
    public final KSerializer<CheckType> serializer() {
        return new ObjectSerializer<>(getSerializerName(), this);
    }

    @NotNull
    public String toString() {
        return getChecker().getSimpleName() + "." + getSimpleName();
    }

    public static final void write$Self(CheckType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !self.getAliasNames().isEmpty()) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) CHILD_SERIALIZERS[0], self.getAliasNames());
        }
    }

    public static final class Companion {
        private Companion() {}

        @NotNull
        public KSerializer<CheckType> serializer() {
            return new PolymorphicSerializer<>(CheckType.class, new Annotation[0]);
        }
    }
}