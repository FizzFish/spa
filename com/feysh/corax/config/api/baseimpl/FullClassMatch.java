import com.feysh.corax.config.api.IClassMatch;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import java.util.Collections;
import java.util.List;

@Serializable
@SerialName("FullClassMatch")
public final class FullClassMatch implements IClassMatch {
    @NotNull
    private final String className;
    @NotNull
    private final List<String> simpleName;
    
    private static final KSerializer<Object>[] $childSerializers = new KSerializer[]{
        null, 
        new ArrayListSerializer<>(StringSerializer.INSTANCE)
    };

    public FullClassMatch(@NotNull String className) {
        if (className == null) {
            throw new IllegalArgumentException("className cannot be null");
        }
        this.className = className;
        this.simpleName = List.of(className.substring(className.lastIndexOf('.') + 1));
    }

    public FullClassMatch(@NotNull SootClass sc) {
        if (sc == null) {
            throw new IllegalArgumentException("sc cannot be null");
        }
        this(sc.getName());
    }

    @NotNull
    public String getClassName() {
        return className;
    }

    @Override
    @NotNull
    public List<SootClass> matched(@NotNull Scene scene) {
        if (scene == null) {
            throw new IllegalArgumentException("scene cannot be null");
        }
        SootClass sootClass = Scene.v().getSootClassUnsafe(className, false);
        return sootClass == null ? Collections.emptyList() : List.of(sootClass);
    }

    @Override
    @NotNull
    public List<String> getSimpleName() {
        return simpleName;
    }

    @Override
    @NotNull
    public String toString() {
        return className;
    }

    public static void write$Self$corax_config_api(FullClassMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.className);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || 
            !self.getSimpleName().equals(List.of(self.className.substring(self.className.lastIndexOf('.') + 1)))) {
            output.encodeSerializableElement(serialDesc, 1, $childSerializers[1], self.getSimpleName());
        }
    }

    public FullClassMatch(int seen0, String className, List<String> simpleName, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            throw PluginExceptionsKt.throwMissingFieldException(seen0, 1, $serializer.INSTANCE.getDescriptor());
        }
        this.className = className;
        this.simpleName = (seen0 & 2) == 0 
            ? List.of(className.substring(className.lastIndexOf('.') + 1)) 
            : simpleName;
    }

    public static final class Companion {
        @NotNull
        public KSerializer<FullClassMatch> serializer() {
            return $serializer.INSTANCE;
        }
    }
}