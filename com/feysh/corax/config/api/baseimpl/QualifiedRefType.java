/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.baseimpl.QualifiedRefType$;
import com.feysh.corax.config.api.baseimpl.QualifiedRefTypeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootClass;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Serializable
@SerialName(value="QualifiedRefType")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 )2\u00020\u0001:\u0002()B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\bB\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\fB;\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0006\u0010\u0011J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006*\u0080\u00e5\b\u0002\u0080\u00e5\b\u0005"}, d2={"Lcom/feysh/corax/config/api/baseimpl/QualifiedRefType;", "Lcom/feysh/corax/config/api/IClassMatch;", "package", "", "", "simpleName", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/util/List;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/util/List;)V", "typeName", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPackage", "()Ljava/util/List;", "getSimpleName", "type", "getType", "type$delegate", "Lkotlin/Lazy;", "sooType", "Lsoot/RefType;", "getSooType", "matched", "Lsoot/SootClass;", "scene", "Lsoot/Scene;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nQualifiedRefType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualifiedRefType.kt\ncom/feysh/corax/config/api/baseimpl/QualifiedRefType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1863#2:46\n1864#2:48\n1734#2,3:49\n1611#2,9:52\n1863#2:61\n1864#2:63\n1620#2:64\n774#2:65\n865#2,2:66\n1557#2:68\n1628#2,3:69\n1864#2:72\n1734#2,3:73\n1368#2:76\n1454#2,2:77\n1557#2:79\n1628#2,3:80\n1456#2,3:83\n1368#2:86\n1454#2,2:87\n1557#2:89\n1628#2,3:90\n1456#2,3:93\n1#3:47\n1#3:62\n*S KotlinDebug\n*F\n+ 1 QualifiedRefType.kt\ncom/feysh/corax/config/api/baseimpl/QualifiedRefType\n*L\n29#1:46\n29#1:48\n34#1:49,3\n26#1:52,9\n26#1:61\n26#1:63\n26#1:64\n38#1:65\n38#1:66,2\n38#1:68\n38#1:69,3\n29#1:72\n34#1:73,3\n25#1:76\n25#1:77,2\n25#1:79\n25#1:80,3\n25#1:83,3\n25#1:86\n25#1:87,2\n25#1:89\n25#1:90,3\n25#1:93,3\n26#1:62\n*E\n"})
public class QualifiedRefType
implements IClassMatch {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> package;
    @NotNull
    private final List<String> simpleName;
    @NotNull
    private final Lazy type$delegate;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public QualifiedRefType(@NotNull List<String> list, @NotNull List<String> simpleName) {
        boolean bl;
        block7: {
            Intrinsics.checkNotNullParameter(list, (String)"package");
            Intrinsics.checkNotNullParameter(simpleName, (String)"simpleName");
            this.package = list;
            this.simpleName = simpleName;
            this.type$delegate = LazyKt.lazy(() -> QualifiedRefType.type_delegate$lambda$2(this));
            Iterable $this$forEach$iv = this.getType();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String clazz = (String)element$iv;
                boolean bl2 = false;
                if (!(!StringsKt.contains$default((CharSequence)clazz, (char)'/', (boolean)false, (int)2, null))) {
                    boolean $i$a$-require-QualifiedRefType$6$32 = false;
                    String $i$a$-require-QualifiedRefType$6$32 = "error sig: " + clazz;
                    throw new IllegalArgumentException($i$a$-require-QualifiedRefType$6$32.toString());
                }
                if (!StringsKt.contains$default((CharSequence)clazz, (char)'\\', (boolean)false, (int)2, null)) continue;
                boolean bl3 = false;
                String string = "error sig: " + clazz;
                throw new IllegalArgumentException(string.toString());
            }
            if (!(!((Collection)this.getType()).isEmpty())) {
                boolean $i$a$-check-QualifiedRefType$82 = false;
                String $i$a$-check-QualifiedRefType$82 = "error syntax: " + this;
                throw new IllegalStateException($i$a$-check-QualifiedRefType$82.toString());
            }
            Iterable $this$all$iv = this.getType();
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    String it = (String)element$iv;
                    boolean bl4 = false;
                    if (((CharSequence)it).length() > 0) continue;
                    bl = false;
                    break block7;
                }
                bl = true;
            }
        }
        if (!bl) {
            boolean bl5 = false;
            String string = "error syntax: " + this;
            throw new IllegalStateException(string.toString());
        }
    }

    @NotNull
    public final List<String> getPackage() {
        return this.package;
    }

    @Override
    @NotNull
    public List<String> getSimpleName() {
        return this.simpleName;
    }

    public QualifiedRefType(@NotNull String string, @NotNull String simpleName) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"package");
        Intrinsics.checkNotNullParameter((Object)simpleName, (String)"simpleName");
        this((List<String>)CollectionsKt.listOf((Object)string), (List<String>)CollectionsKt.listOf((Object)simpleName));
    }

    public QualifiedRefType(@NotNull List<String> list, @NotNull String simpleName) {
        Intrinsics.checkNotNullParameter(list, (String)"package");
        Intrinsics.checkNotNullParameter((Object)simpleName, (String)"simpleName");
        this(list, (List<String>)CollectionsKt.listOf((Object)simpleName));
    }

    public QualifiedRefType(@NotNull String string, @NotNull List<String> simpleName) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"package");
        Intrinsics.checkNotNullParameter(simpleName, (String)"simpleName");
        this((List<String>)CollectionsKt.listOf((Object)string), simpleName);
    }

    public QualifiedRefType(@NotNull String typeName) {
        Intrinsics.checkNotNullParameter((Object)typeName, (String)"typeName");
        this((List<String>)CollectionsKt.listOf((Object)QualifiedRefTypeKt.splitPackage(typeName).getFirst()), (List<String>)CollectionsKt.listOf((Object)QualifiedRefTypeKt.splitPackage(typeName).getSecond()));
    }

    @NotNull
    public final List<String> getType() {
        Lazy lazy = this.type$delegate;
        return (List)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<RefType> getSooType() {
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = this.getType();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv$iv$iv.iterator();
        while (iterator.hasNext()) {
            RefType it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator.next();
            boolean bl = false;
            String it = (String)element$iv$iv;
            boolean bl2 = false;
            if (Scene.v().getRefTypeUnsafe(it) == null) continue;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<SootClass> matched(@NotNull Scene scene) {
        void $this$mapTo$iv$iv;
        RefType it;
        Iterable $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Iterable $this$filter$iv = this.getSooType();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (RefType)element$iv$iv;
            boolean bl = false;
            if (!it.hasSootClass()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (RefType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getSootClass());
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public String toString() {
        if (this.getType().size() == 1) {
            return (String)CollectionsKt.first(this.getType());
        }
        return CollectionsKt.joinToString$default((Iterable)this.getType(), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", (int)0, null, null, (int)56, null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(QualifiedRefType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], self.package);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], self.getSimpleName());
    }

    public /* synthetic */ QualifiedRefType(int seen0, List list, List simpleName, SerializationConstructorMarker serializationConstructorMarker) {
        boolean bl;
        block8: {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
            }
            this.package = list;
            this.simpleName = simpleName;
            this.type$delegate = LazyKt.lazy(() -> QualifiedRefType._init_$lambda$14(this));
            Iterable $this$forEach$iv = this.getType();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String clazz = (String)element$iv;
                boolean bl2 = false;
                if (!(!StringsKt.contains$default((CharSequence)clazz, (char)'/', (boolean)false, (int)2, null))) {
                    boolean $i$a$-require-QualifiedRefType$6$32 = false;
                    String $i$a$-require-QualifiedRefType$6$32 = "error sig: " + clazz;
                    throw new IllegalArgumentException($i$a$-require-QualifiedRefType$6$32.toString());
                }
                if (!StringsKt.contains$default((CharSequence)clazz, (char)'\\', (boolean)false, (int)2, null)) continue;
                boolean bl3 = false;
                String string = "error sig: " + clazz;
                throw new IllegalArgumentException(string.toString());
            }
            if (!(!((Collection)this.getType()).isEmpty())) {
                boolean $i$a$-check-QualifiedRefType$82 = false;
                String $i$a$-check-QualifiedRefType$82 = "error syntax: " + this;
                throw new IllegalStateException($i$a$-check-QualifiedRefType$82.toString());
            }
            Iterable $this$all$iv = this.getType();
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    String it = (String)element$iv;
                    boolean bl4 = false;
                    if (((CharSequence)it).length() > 0) continue;
                    bl = false;
                    break block8;
                }
                bl = true;
            }
        }
        if (!bl) {
            boolean bl5 = false;
            String string = "error syntax: " + this;
            throw new IllegalStateException(string.toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final List type_delegate$lambda$2(QualifiedRefType this$0) {
        void $this$flatMapTo$iv$iv;
        Iterable $this$flatMap$iv = this$0.package;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$mapTo$iv$iv;
            String p = (String)element$iv$iv;
            boolean bl = false;
            Iterable $this$map$iv = this$0.getSimpleName();
            boolean $i$f$map = false;
            Iterable iterable2 = $this$map$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void n;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv2;
                boolean bl2 = false;
                collection.add(p + "." + (String)n);
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$14(QualifiedRefType this$0) {
        void $this$flatMapTo$iv$iv;
        Iterable $this$flatMap$iv = this$0.package;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$mapTo$iv$iv;
            String p = (String)element$iv$iv;
            boolean bl = false;
            Iterable $this$map$iv = this$0.getSimpleName();
            boolean $i$f$map = false;
            Iterable iterable2 = $this$map$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void n;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv2;
                boolean bl2 = false;
                collection.add(p + "." + (String)n);
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/baseimpl/QualifiedRefType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/baseimpl/QualifiedRefType;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<QualifiedRefType> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

