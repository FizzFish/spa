/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.IBugReporter
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.dataflow.analysis;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\b\rH&J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\b\rH&J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\b\rH&J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\b\rH&J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\b\rH&\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/analysis/IBugReporter;", "", "report", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "atClass", "Lsoot/SootClass;", "region", "Lcom/feysh/corax/config/api/report/Region;", "env", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "Lkotlin/ExtensionFunctionType;", "file", "Ljava/nio/file/Path;", "ct", "field", "Lsoot/SootField;", "method", "Lsoot/SootMethod;", "clazz", "unit", "Lsoot/Unit;", "corax-data-flow"})
public interface IBugReporter {
    public void report(@NotNull CheckType var1, @NotNull SootClass var2, @NotNull Region var3, @NotNull Function1<? super BugMessage.Env, kotlin.Unit> var4);

    public void report(@NotNull CheckType var1, @NotNull Path var2, @NotNull Region var3, @NotNull Function1<? super BugMessage.Env, kotlin.Unit> var4);

    public void report(@NotNull CheckType var1, @NotNull SootField var2, @NotNull Function1<? super BugMessage.Env, kotlin.Unit> var3);

    public void report(@NotNull CheckType var1, @NotNull SootMethod var2, @NotNull Function1<? super BugMessage.Env, kotlin.Unit> var3);

    public void report(@NotNull CheckType var1, @NotNull SootClass var2, @NotNull Unit var3, @NotNull Function1<? super BugMessage.Env, kotlin.Unit> var4);
}

