/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.report.ExpectBugAnnotationData
 *  cn.sast.api.report.ExpectBugAnnotationData$Kind
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.result.ResultCollector
 *  cn.sast.framework.validator.AccuracyValidator
 *  cn.sast.framework.validator.AccuracyValidator$Result
 *  com.feysh.corax.config.api.rules.ProcessRule
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch
 *  com.feysh.corax.config.api.rules.ProcessRule$InlineRuleStringSerialize
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.serialization.SerializersKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.validator;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.ExpectBugAnnotationData;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.ResultCollector;
import cn.sast.framework.validator.AccuracyValidator;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.SerializersKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ \u0010\u001e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000fj\u0002`\u00100\u001f2\u0006\u0010 \u001a\u00020!H\u0002J*\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020$H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\r\u001a\u00020\f*\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000fj\u0002`\u00100\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Lcn/sast/framework/validator/AccuracyValidator;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "logger", "Lmu/KLogger;", "extensions", "", "", "str", "", "Lcn/sast/api/report/ExpectBugAnnotationData;", "Lcn/sast/framework/validator/ExpectBugType;", "getStr", "(Ljava/util/Set;)Ljava/lang/String;", "rules", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch;", "makeScore", "Lcn/sast/framework/validator/AccuracyValidator$Result;", "result", "Lcn/sast/framework/result/ResultCollector;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Lcn/sast/framework/result/ResultCollector;Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pattern", "Ljava/util/regex/Pattern;", "parseFile", "", "file", "Lcn/sast/common/IResFile;", "getLineAndColumn", "Lkotlin/Triple;", "", "text", "index", "Result", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPrecisionMeasurement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrecisionMeasurement.kt\ncn/sast/framework/validator/AccuracyValidator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,423:1\n1557#2:424\n1628#2,3:425\n1053#2:429\n24#3:428\n1#4:430\n*S KotlinDebug\n*F\n+ 1 PrecisionMeasurement.kt\ncn/sast/framework/validator/AccuracyValidator\n*L\n86#1:424\n86#1:425,3\n81#1:429\n86#1:428\n*E\n"})
public final class AccuracyValidator {
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final KLogger logger;
    @NotNull
    private final List<String> extensions;
    @NotNull
    private final List<ProcessRule.FileMatch> rules;
    @NotNull
    private final Pattern pattern;

    /*
     * WARNING - void declaration
     */
    public AccuracyValidator(@NotNull MainConfig mainConfig) {
        void $this$mapTo$iv$iv$iv;
        void ruleItems$iv;
        void $this$mapTo$iv$iv;
        List $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.mainConfig = mainConfig;
        this.logger = KotlinLogging.INSTANCE.logger(AccuracyValidator::logger$lambda$0);
        String[] stringArray = new String[]{"yml", "txt", "gradle", "kts", "cnf", "conf", "config", "xml", "properties"};
        this.extensions = CollectionsKt.plus((Collection)ResourceKt.getJavaExtensions(), (Iterable)CollectionsKt.listOf((Object[])stringArray));
        stringArray = ProcessRule.INSTANCE;
        Object object = new String[]{"build", "out", "target", ".idea", ".git"};
        object = CollectionsKt.listOf((Object[])object);
        AccuracyValidator accuracyValidator = this;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo22 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add("(-)path=/" + (String)it + "/");
        }
        $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$cvt = false;
        Iterable $this$map$iv$iv = (Iterable)ruleItems$iv;
        boolean $i$f$map2 = false;
        Iterable $i$f$mapTo22 = $this$map$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
            void it$iv;
            String string = (String)item$iv$iv$iv;
            Collection collection = destination$iv$iv$iv;
            boolean bl = false;
            collection.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.FileMatch.class)), (String)it$iv));
        }
        accuracyValidator.rules = (List)destination$iv$iv$iv;
        Pattern pattern = Pattern.compile("(?<escape>(!?))\\$ *(?<name>((`([^(`\\r\\n)])+`)|([a-zA-Z$_]+[a-zA-Z0-9$_.-]*)))", 8);
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
        this.pattern = pattern;
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final String getStr(@NotNull Set<ExpectBugAnnotationData<String>> $this$str) {
        Intrinsics.checkNotNullParameter($this$str, (String)"<this>");
        Iterable $this$sortedBy$iv = $this$str;
        boolean $i$f$sortedBy = false;
        return "\"" + CollectionsKt.joinToString$default((Iterable)CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */)), (CharSequence)"\n", null, null, (int)0, null, arg_0 -> AccuracyValidator._get_str_$lambda$3(this, arg_0), (int)30, null) + "\"";
    }

    @Nullable
    public final Object makeScore(@NotNull ResultCollector result, @NotNull IProjectFileLocator locator2, @NotNull Continuation<? super Result> $completion) {
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
    }

    private final Set<ExpectBugAnnotationData<String>> parseFile(IResFile file) {
        String string;
        try {
            string = new String(ResourceKt.readAllBytes((IResFile)file), Charsets.UTF_8);
        }
        catch (IOException e) {
            this.logger.error("read config file " + file + " failed");
            string = null;
        }
        String string2 = string;
        if (string2 == null) {
            return SetsKt.emptySet();
        }
        String text2 = string2;
        Matcher matcher = this.pattern.matcher(text2);
        Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"matcher(...)");
        Matcher matcher2 = matcher;
        Set res = new LinkedHashSet();
        while (matcher2.find()) {
            String it;
            String string3 = matcher2.group("escape");
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"group(...)");
            boolean escape = ((CharSequence)string3).length() > 0;
            String string4 = matcher2.group("name");
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"group(...)");
            String name = StringsKt.removeSuffix((String)StringsKt.removeSurrounding((String)string4, (CharSequence)"`"), (CharSequence)"--");
            int startIndex = matcher2.start();
            Triple triple = this.getLineAndColumn(text2, startIndex);
            int start2 = ((Number)triple.component1()).intValue();
            int line = ((Number)triple.component2()).intValue();
            int col = ((Number)triple.component3()).intValue();
            String string5 = text2.substring(start2);
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"substring(...)");
            String lineText = StringsKt.substringBefore$default((String)string5, (String)"\n", null, (int)2, null);
            Intrinsics.checkNotNullExpressionValue((Object)lineText.substring(0, startIndex - start2), (String)"substring(...)");
            boolean bl = false;
            boolean bl2 = StringsKt.contains$default((CharSequence)it, (CharSequence)"//", (boolean)false, (int)2, null) || StringsKt.contains$default((CharSequence)it, (CharSequence)"<!--", (boolean)false, (int)2, null);
            if (!bl2 && !Intrinsics.areEqual((Object)file.getExtension(), (Object)"properties")) continue;
            IResFile iResFile = file.getAbsolute();
            String string6 = name;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
            String string7 = string6.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"toLowerCase(...)");
            it = string6 = new ExpectBugAnnotationData(iResFile, line, col, (Object)string7, escape ? ExpectBugAnnotationData.Kind.Escape : ExpectBugAnnotationData.Kind.Expect);
            Set set = res;
            boolean bl3 = false;
            this.logger.trace(() -> AccuracyValidator.parseFile$lambda$7$lambda$6((ExpectBugAnnotationData)it));
            set.add(string6);
        }
        return res;
    }

    private final Triple<Integer, Integer, Integer> getLineAndColumn(String text2, int index) {
        int line = 1;
        int col = 0;
        int start2 = 0;
        for (int i = 0; i < index; ++i) {
            if (text2.charAt(i) == '\n') {
                ++line;
                start2 = i + 1;
                col = 0;
                continue;
            }
            ++col;
        }
        return new Triple((Object)start2, (Object)line, (Object)col);
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final CharSequence _get_str_$lambda$3(AccuracyValidator this$0, ExpectBugAnnotationData bugAnnotationData) {
        Intrinsics.checkNotNullParameter((Object)bugAnnotationData, (String)"bugAnnotationData");
        ExpectBugAnnotationData $this$_get_str__u24lambda_u243_u24lambda_u242 = bugAnnotationData;
        boolean bl = false;
        return "file: " + this$0.mainConfig.tryGetRelativePath((IResource)$this$_get_str__u24lambda_u243_u24lambda_u242.getFile()).getRelativePath() + ":" + $this$_get_str__u24lambda_u243_u24lambda_u242.getLine() + ":" + $this$_get_str__u24lambda_u243_u24lambda_u242.getColumn() + " kind: " + $this$_get_str__u24lambda_u243_u24lambda_u242.getKind() + " a bug: " + $this$_get_str__u24lambda_u243_u24lambda_u242.getBug();
    }

    private static final Object parseFile$lambda$7$lambda$6(ExpectBugAnnotationData $it) {
        return $it;
    }

    public static final /* synthetic */ List access$getExtensions$p(AccuracyValidator $this) {
        return $this.extensions;
    }

    public static final /* synthetic */ KLogger access$getLogger$p(AccuracyValidator $this) {
        return $this.logger;
    }

    public static final /* synthetic */ Set access$parseFile(AccuracyValidator $this, IResFile file) {
        return $this.parseFile(file);
    }

    public static final /* synthetic */ List access$getRules$p(AccuracyValidator $this) {
        return $this.rules;
    }
}

