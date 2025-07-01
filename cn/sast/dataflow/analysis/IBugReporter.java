package cn.sast.dataflow.analysis;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;

public interface IBugReporter {
    void report(@NotNull CheckType checkType, @NotNull SootClass atClass, @NotNull Region region, 
                @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType checkType, @NotNull Path file, @NotNull Region region, 
                @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType ct, @NotNull SootField field, 
                @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType ct, @NotNull SootMethod method, 
                @NotNull Consumer<BugMessage.Env> env);

    void report(@NotNull CheckType ct, @NotNull SootClass clazz, @NotNull Unit unit, 
                @NotNull Consumer<BugMessage.Env> env);
}