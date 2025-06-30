/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.builtin.checkers;

import com.feysh.corax.config.api.AIAnalysisApiKt;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.builtin.standard.BuiltinCWERules;
import com.feysh.corax.config.builtin.standard.BuiltinFeyshRules;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/config/builtin/checkers/DeadStoreChecker;", "Lcom/feysh/corax/config/api/IChecker;", "<init>", "()V", "report", "Lcom/feysh/corax/config/api/IRule;", "getReport", "()Lcom/feysh/corax/config/api/IRule;", "standards", "", "getStandards", "()Ljava/util/Set;", "DeadLocalStore", "corax-config-api"})
public final class DeadStoreChecker
implements IChecker {
    @NotNull
    public static final DeadStoreChecker INSTANCE = new DeadStoreChecker();
    @NotNull
    private static final IRule report = BuiltinFeyshRules.DeadStore;
    @NotNull
    private static final Set<IRule> standards = SetsKt.setOf((Object)BuiltinCWERules.CWE563_UnusedVariable);

    private DeadStoreChecker() {
    }

    @Override
    @NotNull
    public IRule getReport() {
        return report;
    }

    @Override
    @NotNull
    public Set<IRule> getStandards() {
        return standards;
    }

    @Override
    @NotNull
    public String getSimpleName() {
        return IChecker.DefaultImpls.getSimpleName(this);
    }

    @Override
    @NotNull
    public String getDesc() {
        return IChecker.DefaultImpls.getDesc(this);
    }

    @Override
    public void validate() {
        IChecker.DefaultImpls.validate(this);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/builtin/checkers/DeadStoreChecker$DeadLocalStore;", "Lcom/feysh/corax/config/api/CheckType;", "<init>", "()V", "checker", "Lcom/feysh/corax/config/api/IChecker;", "getChecker", "()Lcom/feysh/corax/config/api/IChecker;", "bugMessage", "", "Lcom/feysh/corax/config/api/Language;", "Lcom/feysh/corax/config/api/BugMessage;", "getBugMessage", "()Ljava/util/Map;", "corax-config-api"})
    public static final class DeadLocalStore
    extends CheckType {
        @NotNull
        public static final DeadLocalStore INSTANCE = new DeadLocalStore();
        @NotNull
        private static final IChecker checker = INSTANCE;
        @NotNull
        private static final Map<Language, BugMessage> bugMessage;

        private DeadLocalStore() {
        }

        @Override
        @NotNull
        public IChecker getChecker() {
            return checker;
        }

        @Override
        @NotNull
        public Map<Language, BugMessage> getBugMessage() {
            return bugMessage;
        }

        private static final String bugMessage$lambda$0(BugMessage.Env $this$msgGenerator) {
            Intrinsics.checkNotNullParameter((Object)$this$msgGenerator, (String)"$this$msgGenerator");
            return "\u8d4b\u503c\u7ed9\u53d8\u91cf\uff0c\u4f46\u540e\u7eed\u5e76\u672a\u4f7f\u7528\u8be5\u503c";
        }

        private static final String bugMessage$lambda$1(BugMessage.Env $this$msgGenerator) {
            Intrinsics.checkNotNullParameter((Object)$this$msgGenerator, (String)"$this$msgGenerator");
            return "Assign a value to a variable, but the value is not used subsequently";
        }

        static {
            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)((Object)Language.ZH), (Object)AIAnalysisApiKt.msgGenerator((Function1<? super BugMessage.Env, String>)((Function1)DeadLocalStore::bugMessage$lambda$0))), TuplesKt.to((Object)((Object)Language.EN), (Object)AIAnalysisApiKt.msgGenerator((Function1<? super BugMessage.Env, String>)((Function1)DeadLocalStore::bugMessage$lambda$1)))};
            bugMessage = MapsKt.mapOf((Pair[])pairArray);
        }
    }
}

