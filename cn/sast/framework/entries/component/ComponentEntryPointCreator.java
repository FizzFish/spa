package cn.sast.framework.entries.component;

import cn.sast.framework.entries.utils.PhantomValueForType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.LocalGenerator;
import soot.SootClass;
import soot.Type;
import soot.Value;
import soot.jimple.infoflow.entryPointCreators.SequentialEntryPointCreator;

public final class ComponentEntryPointCreator extends SequentialEntryPointCreator {
    @NotNull
    private final PhantomValueForType p;

    public ComponentEntryPointCreator(@NotNull Collection<String> entry) {
        super(entry);
        if (entry == null) {
            throw new IllegalArgumentException("entry must not be null");
        }
        this.p = new PhantomValueForType(null, 1, null);
    }

    @Nullable
    protected Value getValueForType(
            @NotNull Type tp,
            @Nullable Set<SootClass> constructionStack,
            @Nullable Set<? extends SootClass> parentClasses,
            @Nullable Set<Local> generatedLocals,
            boolean ignoreExcludes) {
        if (tp == null) {
            throw new IllegalArgumentException("tp must not be null");
        }
        
        Body body = this.body;
        LocalGenerator localGenerator = this.generator;
        if (body == null || localGenerator == null) {
            throw new IllegalStateException("Body or LocalGenerator is null");
        }
        
        return p.getValueForType(body, localGenerator, tp);
    }
}