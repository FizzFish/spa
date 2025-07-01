package com.feysh.corax.config.api.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.*;
import kotlinx.serialization.descriptors.*;
import kotlinx.serialization.encoding.*;
import kotlinx.serialization.json.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProcessRule {
    public static final ProcessRule INSTANCE = new ProcessRule();

    private ProcessRule() {
    }

    public final <T extends IMatchItem> List<T> cvt(List<String> ruleItems) {
        List<T> result = new ArrayList<>();
        for (String item : ruleItems) {
            result.add(InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(
                SerializersKt.serializer(IMatchItem.class), item));
        }
        return result;
    }

    public final <T extends IMatchItem> List<T> cvt(String... ruleItems) {
        List<T> result = new ArrayList<>();
        for (String item : ruleItems) {
            result.add(InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(
                SerializersKt.serializer(IMatchItem.class), item));
        }
        return result;
    }

    @Nullable
    public final String isValidOf(@NotNull ProcRegexBase regexBase, @NotNull Type type) {
        if (regexBase instanceof ProcRegex) {
            String regex = ((ProcRegex)regexBase).getRegexExpr();
            if (type.isFile() && regex.contains("\\")) {
                return "Matching regex for file cannot contains \\ char";
            }
            if (type.isClassMember() && (regex.contains("\\") || regex.contains("/"))) {
                return "Matching regex for class cannot contains \\ char";
            }
        }
        return null;
    }

    private Boolean matcher(ProcRegexBase regexBase, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return regexBase.matches(str);
    }

    @NotNull
    public final <T extends IMatchTarget> Pair<IMatchItem, ScanAction> matches(
            @NotNull List<? extends IMatchItem> matchItems, @NotNull T content) {
        if (matchItems.isEmpty()) {
            return new Pair<>(null, ScanAction.Keep);
        }

        IMatchItem matchedItem = null;
        ListIterator<? extends IMatchItem> iterator = matchItems.listIterator(matchItems.size());
        while (iterator.hasPrevious()) {
            IMatchItem item = iterator.previous();
            if (item.matches(content)) {
                matchedItem = item;
                break;
            }
        }

        OP op = matchedItem != null ? matchedItem.getOp() : null;
        ScanAction action;
        if (op == null) {
            action = ScanAction.Keep;
        } else {
            switch (op) {
                case Add:
                    action = ScanAction.Process;
                    break;
                case Sub:
                    action = ScanAction.Skip;
                    break;
                default:
                    action = ScanAction.Keep;
            }
        }
        return new Pair<>(matchedItem, action);
    }

    public static final class ClassMemberMatch implements IMatchItem, ErrorCommit {
        public static final Companion Companion = new Companion();
        
        @NotNull
        private final OP op;
        @Nullable
        private final ProcRegexBase classNameMatch;
        @Nullable
        private final ProcRegexBase classSrcMatch;
        @Nullable
        private final ProcRegexBase methodSignatureMatch;
        @Nullable
        private final ProcRegexBase methodNameMatch;
        @Nullable
        private final ProcRegexBase fieldSignatureMatch;
        @Nullable
        private final ProcRegexBase fieldNameMatch;

        public ClassMemberMatch(@NotNull OP op, @Nullable ProcRegexBase classNameMatch, 
                @Nullable ProcRegexBase classSrcMatch, @Nullable ProcRegexBase methodSignatureMatch,
                @Nullable ProcRegexBase methodNameMatch, @Nullable ProcRegexBase fieldSignatureMatch,
                @Nullable ProcRegexBase fieldNameMatch) {
            this.op = op;
            this.classNameMatch = classNameMatch;
            this.classSrcMatch = classSrcMatch;
            this.methodSignatureMatch = methodSignatureMatch;
            this.methodNameMatch = methodNameMatch;
            this.fieldSignatureMatch = fieldSignatureMatch;
            this.fieldNameMatch = fieldNameMatch;
        }

        @Override
        public @NotNull OP getOp() {
            return op;
        }

        // ... other getters and methods

        public static final class Companion {
            private Companion() {}
            
            @NotNull
            public KSerializer<ClassMemberMatch> serializer() {
                return ClassMemberMatch$$serializer.INSTANCE;
            }
        }
    }

    // ... other nested classes (ClassPathMatch, FileMatch, etc.)
    public static final class ClassPathMatch implements IMatchItem, ErrorCommit {

        @NotNull
        private final OP op;

        @NotNull
        private final ProcRegexBase path;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("com.feysh.corax.config.api.rules.ProcessRule.OP", OP.values()), null};

        @SerialName("path")
        @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
        public static /* synthetic */ void getPath$annotations() {
        }

        @NotNull
        public final OP component1() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase component2() {
            return this.path;
        }

        @NotNull
        public final ClassPathMatch copy(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(path, "path");
            return new ClassPathMatch(op, path);
        }

        public static /* synthetic */ ClassPathMatch copy$default(ClassPathMatch classPathMatch, OP op, ProcRegexBase procRegexBase, int i, Object obj) {
            if ((i & 1) != 0) {
                op = classPathMatch.op;
            }
            if ((i & 2) != 0) {
                procRegexBase = classPathMatch.path;
            }
            return classPathMatch.copy(op, procRegexBase);
        }

        public int hashCode() {
            int result = this.op.hashCode();
            return (result * 31) + this.path.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassPathMatch)) {
                return false;
            }
            ClassPathMatch classPathMatch = (ClassPathMatch) other;
            return this.op == classPathMatch.op && Intrinsics.areEqual(this.path, classPathMatch.path);
        }

        /* compiled from: ProcessRule.kt */
        @Metadata(mv = {2, PointsToGraphKt.pathStrictMod, PointsToGraphKt.pathStrictMod}, k = PseudoTopologicalOrderer.REVERSE, xi = 48, d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\b\u0086\u0003\u0018��2\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch;", "corax-config-api"})
        /* loaded from: ProcessRule$ClassPathMatch$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            @NotNull
            public final KSerializer<ClassPathMatch> serializer() {
                return ProcessRule$ClassPathMatch$$serializer.INSTANCE;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(ClassPathMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.getOp());
            output.encodeSerializableElement(serialDesc, 1, ProcRegexBaseSerializer.INSTANCE, self.path);
        }

        public /* synthetic */ ClassPathMatch(int seen0, OP op, ProcRegexBase path, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 3, ProcessRule$ClassPathMatch$$serializer.INSTANCE.getDescriptor());
            }
            this.op = op;
            this.path = path;
        }

        public ClassPathMatch(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(path, "path");
            this.op = op;
            this.path = path;
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchItem
        @NotNull
        public OP getOp() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase getPath() {
            return this.path;
        }

        /* compiled from: ProcessRule.kt */
        @Metadata(mv = {2, PointsToGraphKt.pathStrictMod, PointsToGraphKt.pathStrictMod}, k = PseudoTopologicalOrderer.REVERSE, xi = 48, d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\b\u0086\b\u0018��2\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020��2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "type", "getType", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "corax-config-api"})
        /* loaded from: ProcessRule$ClassPathMatch$MatchTarget.class */
        public static final class MatchTarget implements IMatchTarget {

            @Nullable
            private final String path;

            @Nullable
            public final String component1() {
                return this.path;
            }

            @NotNull
            public final MatchTarget copy(@Nullable String path) {
                return new MatchTarget(path);
            }

            public static /* synthetic */ MatchTarget copy$default(MatchTarget matchTarget, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = matchTarget.path;
                }
                return matchTarget.copy(str);
            }

            public int hashCode() {
                if (this.path == null) {
                    return 0;
                }
                return this.path.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MatchTarget) && Intrinsics.areEqual(this.path, ((MatchTarget) other).path);
            }

            public MatchTarget(@Nullable String path) {
                this.path = path;
            }

            @Nullable
            public final String getPath() {
                return this.path;
            }

            @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchTarget
            @NotNull
            public String getType() {
                return "classpath";
            }

            @NotNull
            public String toString() {
                List it = new ArrayList();
                if (this.path != null) {
                    it.add("path=" + this.path);
                }
                return CollectionsKt.joinToString$default(it, ", ", getType() + ": { ", " }", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            }
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchItem
        public boolean matches(@NotNull IMatchTarget matchContent) {
            Intrinsics.checkNotNullParameter(matchContent, "matchContent");
            if (!(matchContent instanceof MatchTarget)) {
                return false;
            }
            boolean anyMatch = false;
            Boolean boolMatcher = ProcessRule.INSTANCE.matcher(this.path, ((MatchTarget) matchContent).getPath());
            if (boolMatcher != null) {
                boolean it = boolMatcher.booleanValue();
                if (!it) {
                    return false;
                }
                anyMatch = true;
            }
            return anyMatch;
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.ErrorCommit
        @Nullable
        public String getError() {
            String it = ProcessRule.INSTANCE.isValidOf(this.path, Type.File);
            if (it != null) {
                return it;
            }
            return null;
        }

        @NotNull
        public String toString() {
            List it = new ArrayList();
            it.add("path=" + this.path);
            return CollectionsKt.joinToString$default(it, ", ", "(" + getOp().getPretty() + ")", "", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        }
    }

    //... other nested classes (FileMatch, etc.)
    public static final class FileMatch implements IMatchItem, ErrorCommit {

        @NotNull
        private final OP op;

        @NotNull
        private final ProcRegexBase path;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("com.feysh.corax.config.api.rules.ProcessRule.OP", OP.values()), null};

        @SerialName("path")
        @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
        public static /* synthetic */ void getPath$annotations() {
        }

        @NotNull
        public final OP component1() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase component2() {
            return this.path;
        }

        @NotNull
        public final FileMatch copy(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(path, "path");
            return new FileMatch(op, path);
        }

        public static /* synthetic */ FileMatch copy$default(FileMatch fileMatch, OP op, ProcRegexBase procRegexBase, int i, Object obj) {
            if ((i & 1) != 0) {
                op = fileMatch.op;
            }
            if ((i & 2) != 0) {
                procRegexBase = fileMatch.path;
            }
            return fileMatch.copy(op, procRegexBase);
        }

        public int hashCode() {
            int result = this.op.hashCode();
            return (result * 31) + this.path.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileMatch)) {
                return false;
            }
            FileMatch fileMatch = (FileMatch) other;
            return this.op == fileMatch.op && Intrinsics.areEqual(this.path, fileMatch.path);
        }

        /* compiled from: ProcessRule.kt */
        @Metadata(mv = {2, PointsToGraphKt.pathStrictMod, PointsToGraphKt.pathStrictMod}, k = PseudoTopologicalOrderer.REVERSE, xi = 48, d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\b\u0086\u0003\u0018��2\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch;", "corax-config-api"})
        /* loaded from: ProcessRule$FileMatch$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            @NotNull
            public final KSerializer<FileMatch> serializer() {
                return ProcessRule$FileMatch$$serializer.INSTANCE;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(FileMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.getOp());
            output.encodeSerializableElement(serialDesc, 1, ProcRegexBaseSerializer.INSTANCE, self.path);
        }

        public /* synthetic */ FileMatch(int seen0, OP op, ProcRegexBase path, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 3, ProcessRule$FileMatch$$serializer.INSTANCE.getDescriptor());
            }
            this.op = op;
            this.path = path;
        }

        public FileMatch(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(path, "path");
            this.op = op;
            this.path = path;
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchItem
        @NotNull
        public OP getOp() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase getPath() {
            return this.path;
        }

        /* compiled from: ProcessRule.kt */
        @Metadata(mv = {2, PointsToGraphKt.pathStrictMod, PointsToGraphKt.pathStrictMod}, k = PseudoTopologicalOrderer.REVERSE, xi = 48, d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\b\u0086\b\u0018��2\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020��2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "type", "getType", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "corax-config-api"})
        /* loaded from: ProcessRule$FileMatch$MatchTarget.class */
        public static final class MatchTarget implements IMatchTarget {

            @Nullable
            private final String path;

            @Nullable
            public final String component1() {
                return this.path;
            }

            @NotNull
            public final MatchTarget copy(@Nullable String path) {
                return new MatchTarget(path);
            }

            public static /* synthetic */ MatchTarget copy$default(MatchTarget matchTarget, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = matchTarget.path;
                }
                return matchTarget.copy(str);
            }

            public int hashCode() {
                if (this.path == null) {
                    return 0;
                }
                return this.path.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MatchTarget) && Intrinsics.areEqual(this.path, ((MatchTarget) other).path);
            }

            public MatchTarget(@Nullable String path) {
                this.path = path;
            }

            @Nullable
            public final String getPath() {
                return this.path;
            }

            @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchTarget
            @NotNull
            public String getType() {
                return "file";
            }

            @NotNull
            public String toString() {
                List it = new ArrayList();
                if (this.path != null) {
                    it.add("path=" + this.path);
                }
                return CollectionsKt.joinToString$default(it, ", ", getType() + ": { ", " }", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            }
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.IMatchItem
        public boolean matches(@NotNull IMatchTarget matchContent) {
            Intrinsics.checkNotNullParameter(matchContent, "matchContent");
            if (!(matchContent instanceof MatchTarget)) {
                return false;
            }
            boolean anyMatch = false;
            Boolean boolMatcher = ProcessRule.INSTANCE.matcher(this.path, ((MatchTarget) matchContent).getPath());
            if (boolMatcher != null) {
                boolean it = boolMatcher.booleanValue();
                if (!it) {
                    return false;
                }
                anyMatch = true;
            }
            return anyMatch;
        }

        @Override // com.feysh.corax.config.api.rules.ProcessRule.ErrorCommit
        @Nullable
        public String getError() {
            String it = ProcessRule.INSTANCE.isValidOf(this.path, Type.File);
            if (it != null) {
                return it;
            }
            return null;
        }

        @NotNull
        public String toString() {
            List it = new ArrayList();
            it.add("path=" + this.path);
            return CollectionsKt.joinToString$default(it, ", ", "(" + getOp().getPretty() + ")", "", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final <T extends IMatchTarget> Pair<IMatchItem, ScanAction> matches(@NotNull List<? extends IMatchItem> list, @NotNull T t) throws NoWhenBranchMatchedException {
        Object obj;
        ScanAction scanAction;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(t, "content");
        if (list.isEmpty()) {
            return TuplesKt.to((Object) null, ScanAction.Keep);
        }
        ListIterator iterator$iv = list.listIterator(list.size());
        while (true) {
            if (iterator$iv.hasPrevious()) {
                Object element$iv = iterator$iv.previous();
                IMatchItem it = (IMatchItem) element$iv;
                if (it.matches(t)) {
                    obj = element$iv;
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IMatchItem ruleItem = (IMatchItem) obj;
        OP op = ruleItem != null ? ruleItem.getOp() : null;
        switch (op == null ? -1 : WhenMappings.$EnumSwitchMapping$0[op.ordinal()]) {
            case -1:
                scanAction = ScanAction.Keep;
                break;
            case PointsToGraphKt.pathStrictMod /* 0 */:
            default:
                throw new NoWhenBranchMatchedException();
            case PseudoTopologicalOrderer.REVERSE /* 1 */:
                scanAction = ScanAction.Process;
                break;
            case 2:
                scanAction = ScanAction.Skip;
                break;
        }
        return TuplesKt.to(ruleItem, scanAction);
    }

    public enum OP {
        Add("+"), Sub("-");

        private final String pretty;

        OP(String pretty) {
            this.pretty = pretty;
        }

        public String getPretty() {
            return pretty;
        }
    }

    public enum ScanAction {
        Process, Skip, Keep
    }

    public enum Type {
        File(true, false),
        Class(false, true),
        Method(false, true),
        Field(false, true);

        private final boolean isFile;
        private final boolean isClassMember;

        Type(boolean isFile, boolean isClassMember) {
            this.isFile = isFile;
            this.isClassMember = isClassMember;
        }

        public boolean isFile() {
            return isFile;
        }

        public boolean isClassMember() {
            return isClassMember;
        }
    }

    public interface IMatchItem {
        @NotNull OP getOp();
        boolean matches(@NotNull IMatchTarget matchContent);
    }

    public interface IMatchTarget {
        @NotNull String getType();
    }

    public interface ErrorCommit {
        @Nullable String getError();
    }

    public static final class InlineRuleStringSerialize {
        public static final InlineRuleStringSerialize INSTANCE = new InlineRuleStringSerialize();
        
        private final Json jsonFormat = JsonKt.Json(builder -> {
            builder.setUseArrayPolymorphism(true);
            builder.setPrettyPrint(true);
            return Unit.INSTANCE;
        });

        @NotNull
        public <R extends IMatchItem> R deserializeMatchFromLineString(
                @NotNull KSerializer<R> serializer, @NotNull String objectKeyValues) {
            // ... implementation
        }

        @NotNull
        public <T> Map<String, String> lineString2map(
                @NotNull KSerializer<T> serializer, @NotNull String fieldInline) {
            // ... implementation
        }
    }

    public static abstract class ProcRegexBase {
        public static final Companion Companion = new Companion();
        
        @NotNull
        public abstract String serializerToString();
        public abstract boolean matches(@NotNull String identifier);
        
        @Override
        public String toString() {
            return serializerToString();
        }

        public static final class Companion {
            private Companion() {}
            
            @NotNull
            public ProcRegexBase parse(@NotNull String str, @Nullable String origin) {
                // ... implementation
            }
            
            @NotNull
            public KSerializer<ProcRegexBase> serializer() {
                return ProcRegexBaseSerializer.INSTANCE;
            }
        }
    }

    private static final class ProcRegex extends ProcRegexBase {
        private final String regexExpr;
        private final Lazy<Regex> regex;

        public ProcRegex(@NotNull String regexExpr) {
            this.regexExpr = regexExpr;
            this.regex = LazyKt.lazy(() -> new Regex(regexExpr));
        }

        @Override
        public @NotNull String serializerToString() {
            return regexExpr;
        }

        @Override
        public boolean matches(@NotNull String identifier) {
            return regex.getValue().containsMatchIn(identifier);
        }
    }

    public static final class ProcRegexBaseSerializer implements KSerializer<ProcRegexBase> {
        public static final ProcRegexBaseSerializer INSTANCE = new ProcRegexBaseSerializer();
        
        private final SerialDescriptor descriptor = 
            SerialDescriptorsKt.PrimitiveSerialDescriptor("proc-regex", PrimitiveKind.STRING.INSTANCE);

        @Override
        public @NotNull SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override
        public void serialize(@NotNull Encoder encoder, @NotNull ProcRegexBase value) {
            encoder.encodeString(value.serializerToString());
        }

        @Override
        public @NotNull ProcRegexBase deserialize(@NotNull Decoder decoder) {
            return ProcRegexBase.Companion.parse(decoder.decodeString(), null);
        }
    }
}
