package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.ICheckPoint;
import com.feysh.corax.config.api.IClassCheckPoint;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.IInvokeCheckPoint;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.INodeWithRange;
import com.feysh.corax.config.api.IPreAnalysisClassConfig;
import com.feysh.corax.config.api.IPreAnalysisFieldConfig;
import com.feysh.corax.config.api.IPreAnalysisFileConfig;
import com.feysh.corax.config.api.IPreAnalysisInvokeConfig;
import com.feysh.corax.config.api.IPreAnalysisMethodConfig;
import com.feysh.corax.config.api.ISourceFileCheckPoint;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.Position;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import de.fraunhofer.aisec.cpg.sarif.Region;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.tagkit.Host;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public interface PreAnalysisApi extends AnalysisApi, IAnalysisDepends {

    @NotNull
    CallGraph getCg();

    @NotNull
    Path getOutputPath();

    @NotNull
    <T> Result<T> nonNull(@NotNull Result<T> result);

    @NotNull
    <T> Deferred<T> runInSceneAsync(@NotNull CheckerUnit checkerUnit, @NotNull Function<Continuation<? super T>, ?> block);

    @NotNull
    <T> Job runInScene(@NotNull CheckerUnit checkerUnit, @NotNull Function<Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atClass(@NotNull CheckerUnit checkerUnit, @NotNull IClassMatch clazz, 
                         @NotNull Consumer<IPreAnalysisClassConfig> config, 
                         @NotNull BiFunction<IClassCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atAnyClass(@NotNull CheckerUnit checkerUnit, 
                            @NotNull Consumer<IPreAnalysisClassConfig> config, 
                            @NotNull BiFunction<IClassCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atMethod(@NotNull CheckerUnit checkerUnit, @NotNull IMethodMatch method, 
                          @NotNull Consumer<IPreAnalysisMethodConfig> config, 
                          @NotNull BiFunction<IMethodCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atAnyMethod(@NotNull CheckerUnit checkerUnit, 
                             @NotNull Consumer<IPreAnalysisMethodConfig> config, 
                             @NotNull BiFunction<IMethodCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atField(@NotNull CheckerUnit checkerUnit, @NotNull IFieldMatch field, 
                         @NotNull Consumer<IPreAnalysisFieldConfig> config, 
                         @NotNull BiFunction<IFieldCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atAnyField(@NotNull CheckerUnit checkerUnit, 
                            @NotNull Consumer<IPreAnalysisFieldConfig> config, 
                            @NotNull Function<IFieldCheckPoint, T> block);

    @NotNull
    <T> Result<T> atInvoke(@NotNull CheckerUnit checkerUnit, @NotNull IMethodMatch callee, 
                          @NotNull Consumer<IPreAnalysisInvokeConfig> config, 
                          @NotNull BiFunction<IInvokeCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atAnyInvoke(@NotNull CheckerUnit checkerUnit, 
                             @NotNull Consumer<IPreAnalysisInvokeConfig> config, 
                             @NotNull BiFunction<IInvokeCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atAnySourceFile(@NotNull CheckerUnit checkerUnit, 
                                 @Nullable String extension, @Nullable String filename, 
                                 @NotNull Consumer<IPreAnalysisFileConfig> config, 
                                 @NotNull BiFunction<ISourceFileCheckPoint, Continuation<? super T>, ?> block);

    @NotNull
    <T> Result<T> atSourceFile(@NotNull CheckerUnit checkerUnit, @NotNull Path path, 
                              @NotNull Consumer<IPreAnalysisFileConfig> config, 
                              @NotNull BiFunction<ISourceFileCheckPoint, Continuation<? super T>, ?> block);

    <P extends ICheckPoint & INodeWithRange> void report(@NotNull P checkPoint, @NotNull CheckType checkType, 
                                                        @NotNull Consumer<BugMessage.Env> env);

    <P extends ICheckPoint & INodeWithRange> void report(@NotNull P checkPoint, @NotNull CheckType checkType, 
                                                        @NotNull Region region, @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull ISourceFileCheckPoint checkPoint, @NotNull CheckType checkType, 
                @NotNull Region region, @NotNull Consumer<BugMessage.Env> env);

    @Nullable
    Void report(@NotNull ISourceFileCheckPoint checkPoint, @NotNull CheckType checkType, 
                @NotNull de.fraunhofer.aisec.cpg.sarif.Region cpgRegion, @NotNull Consumer<BugMessage.Env> env);

    @Nullable
    Void report(@NotNull ISourceFileCheckPoint checkPoint, @NotNull CheckType checkType, 
               @NotNull Position jpsStart, @Nullable Position jpsEnd, @NotNull Consumer<BugMessage.Env> env);

    @Nullable
    Void report(@NotNull ISourceFileCheckPoint checkPoint, @NotNull CheckType checkType, 
               @NotNull NodeWithRange<?> regionNode, @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType checkType, @NotNull Host sootHost, @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType checkType, @NotNull Host sootHost, @Nullable Region region, 
                @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType checkType, @NotNull Path path, @NotNull Region region, 
                @NotNull Consumer<BugMessage.Env> env);

    @NotNull
    Path archivePath(@NotNull Path path, @NotNull String entry);

    @Nullable
    Pair<Path, String> getZipEntry(@NotNull Path path);

    @NotNull
    File getShadowFile(@NotNull Path path, @Nullable Path copyDest);

    @Nullable
    List<Path> globPath(@NotNull String glob);

    @NotNull
    String getFullCanonicalPathString(@NotNull Path path);

    interface Result<T> {
        CompletableFuture<List<T>> await();
        Deferred<List<T>> getAsyncResult();
    }

    @FunctionalInterface
    interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }
}
