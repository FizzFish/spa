import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.MethodConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public final class BaseSootFieldDecl<This, T> implements ISootFieldDecl<This, T>, IFieldDecl<This, T> {
    @NotNull
    private final IFieldDecl<This, T> delegate;
    @NotNull
    private final ISootClassDecl clazz;
    @NotNull
    private final SootField sootField;

    public BaseSootFieldDecl(@NotNull IFieldDecl<This, T> delegate, @NotNull ISootClassDecl clazz, @NotNull SootField sootField) {
        if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
        if (clazz == null) throw new IllegalArgumentException("clazz cannot be null");
        if (sootField == null) throw new IllegalArgumentException("sootField cannot be null");
        this.delegate = delegate;
        this.clazz = clazz;
        this.sootField = sootField;
    }

    @NotNull
    public IFieldDecl<This, T> getDelegate() {
        return delegate;
    }

    @Override
    @NotNull
    public ISootClassDecl getClazz() {
        return clazz;
    }

    @Override
    @NotNull
    public SootField getSootField() {
        return sootField;
    }

    @Override
    @NotNull
    public String toString() {
        return "soot decl: " + getSootField();
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return ISootFieldDecl.super.getVisibilityAnnotationTag();
    }

    @Override
    @NotNull
    public List<Tag> getTags() {
        return ISootFieldDecl.super.getTags();
    }

    @Override
    @Nullable
    public AnnotationTag getAnnotations() {
        return ISootFieldDecl.super.getAnnotations();
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atGet(@NotNull Consumer<? super MethodConfig> config, @NotNull Consumer<? super IFieldDecl.IGet<This, T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        return delegate.atGet(config, block);
    }

    @Override
    @NotNull
    public IFieldDecl<This, T> atSet(@NotNull Consumer<? super MethodConfig> config, @NotNull BiConsumer<? super IFieldDecl.ISet<This, T>, ? super IParameterT<T>> block) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        return delegate.atSet(config, block);
    }
}