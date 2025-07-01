import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.ISootMethodDecl;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import com.feysh.corax.config.api.baseimpl.BaseFieldDecl;
import com.feysh.corax.config.api.baseimpl.BaseSootFieldDecl;
import com.feysh.corax.config.api.baseimpl.BaseSootMethodDecl;
import com.feysh.corax.config.api.baseimpl.MethodDeclBase;
import com.feysh.corax.config.api.baseimpl.SootFieldSignatureMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;

import java.util.List;
import java.util.function.Function;

public final class BaseSootClassDecl implements ISootClassDecl, IClassDecl {
    @NotNull
    private final IClassDecl delegate;
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final SootClass sootClass;

    public BaseSootClassDecl(@NotNull IClassDecl delegate, @NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull SootClass sootClass) {
        if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
        if (analyzeConfig == null) throw new IllegalArgumentException("analyzeConfig cannot be null");
        if (sootClass == null) throw new IllegalArgumentException("sootClass cannot be null");
        
        this.delegate = delegate;
        this.analyzeConfig = analyzeConfig;
        this.sootClass = sootClass;
    }

    @NotNull
    public IClassDecl getDelegate() {
        return delegate;
    }

    @Override
    @NotNull
    public SootClass getSootClass() {
        return sootClass;
    }

    @Override
    public void eachDeclaringMethod(@NotNull Function<? super ISootMethodDecl<Object>, Void> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        if (getSootClass().resolvingLevel() < 2) return;
        
        for (SootMethod sm : getSootClass().getMethods()) {
            if (sm == null) continue;
            ISootMethodDecl<Object> smd = sootDeclaringMethod(sm);
            block.apply(smd);
        }
    }

    @Override
    @NotNull
    public <R> ISootMethodDecl<R> sootDeclaringMethod(@NotNull SootMethod method) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        MethodDeclBase md = new MethodDeclBase(analyzeConfig, SootSignatureMatch.create(method), null, 4, null);
        return new BaseSootMethodDecl<>(md, this, method);
    }

    @Override
    public void eachDeclaringField(@NotNull Function<? super ISootFieldDecl<Object, Object>, Void> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        
        for (SootField sf : getSootClass().getFields()) {
            if (sf == null) continue;
            BaseFieldDecl sootFd = new BaseFieldDecl(analyzeConfig, new SootFieldSignatureMatch(sf));
            BaseSootFieldDecl sootMd = new BaseSootFieldDecl<>(sootFd, this, sf);
            block.apply(sootMd);
        }
    }

    @Override
    public boolean anySuperClass(@NotNull Function<? super SootClass, Boolean> predicate) {
        if (predicate == null) throw new IllegalArgumentException("predicate cannot be null");
        
        SootClass clazz = getSootClass();
        while (clazz.hasSuperclass()) {
            clazz = clazz.getSuperclass();
            if (predicate.apply(clazz)) {
                return true;
            }
        }
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return "soot class decl: " + getSootClass();
    }

    @Override
    @NotNull
    public String getClazzName() {
        return getSootClass().getName();
    }

    @Override
    @NotNull
    public List<Tag> getClassTags() {
        return getSootClass().getTags();
    }

    @Override
    @NotNull
    public List<AnnotationTag> getClassAnnotationTags() {
        return getSootClass().getTags().stream()
                .filter(tag -> tag instanceof AnnotationTag)
                .map(tag -> (AnnotationTag) tag)
                .toList();
    }

    @Override
    @NotNull
    public List<SootMethod> getDeclaringSootMethods() {
        return List.copyOf(getSootClass().getMethods());
    }

    @Override
    @NotNull
    public IClassMatch getMatch() {
        return delegate.getMatch();
    }
}