package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.ProgramRepresentation;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public abstract class InterProceduralAnalysis<M, N, A> {
    private final boolean reverse;

    public InterProceduralAnalysis(boolean reverse) {
        this.reverse = reverse;
        Context.reset();
    }

    protected final boolean getReverse() {
        return reverse;
    }

    public abstract A boundaryValue(M entryPoint);

    public abstract A copy(A src);

    public abstract void doAnalysis(@NotNull Collection<? extends M> entries);

    public abstract A meet(A op1, A op2);

    public abstract A shallowMeet(A op1, A op2);

    public abstract A merge(A local, A ret);

    @NotNull
    public abstract ProgramRepresentation<M, N> programRepresentation();

    public abstract A bottomValue();
}