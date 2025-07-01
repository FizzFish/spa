package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.ILocalVarMatch;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Local;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.JimpleBody;
import soot.util.Chain;

public final class LocalVarNameMatch implements ILocalVarMatch {
    @NotNull
    private final SootMethod sm;
    @NotNull
    private final String name;

    public LocalVarNameMatch(@NotNull SootMethod sm, @NotNull String name) {
        if (sm == null) throw new IllegalArgumentException("sm cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.sm = sm;
        this.name = name;
    }

    @NotNull
    public SootMethod getSm() {
        return sm;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Override
    @NotNull
    public List<Local> matched(@NotNull Scene scene) {
        if (scene == null) throw new IllegalArgumentException("scene cannot be null");
        if (!sm.hasActiveBody()) {
            return List.of();
        }

        Body body = sm.getActiveBody();
        if (!(body instanceof JimpleBody)) {
            return List.of();
        }

        JimpleBody jimpleBody = (JimpleBody) body;
        Chain<Local> chain = jimpleBody.getLocals();
        List<Local> result = new ArrayList<>();

        for (Local local : chain) {
            if (match(local)) {
                result.add(local);
            }
        }

        return result;
    }

    public boolean match(@NotNull Local local) {
        if (local == null) throw new IllegalArgumentException("local cannot be null");
        return name.equals(local.getName());
    }
}
