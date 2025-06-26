/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.config.PreAnalysisCoroutineScopeKt
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.PreAnalysisCoroutineScope;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"processAIAnalysisUnits", "", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "preAnalysisScope", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "(Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;Lcn/sast/api/config/PreAnalysisCoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nPreAnalysisCoroutineScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisCoroutineScope.kt\ncn/sast/api/config/PreAnalysisCoroutineScopeKt\n+ 2 Timer.kt\ncn/sast/api/util/TimerKt\n*L\n1#1,99:1\n16#2,2:100\n16#2,8:102\n19#2,3:110\n16#2,8:113\n23#2:121\n*S KotlinDebug\n*F\n+ 1 PreAnalysisCoroutineScope.kt\ncn/sast/api/config/PreAnalysisCoroutineScopeKt\n*L\n63#1:100,2\n89#1:102,8\n63#1:110,3\n89#1:113,8\n63#1:121\n*E\n"})
public final class PreAnalysisCoroutineScopeKt {
    /*
     * Exception decompiling
     */
    @Nullable
    public static final Object processAIAnalysisUnits(@NotNull AIAnalysisBaseImpl var0, @NotNull PreAnalysisCoroutineScope var1_1, @NotNull Continuation<? super Unit> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[SWITCH], 20[CASE]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

