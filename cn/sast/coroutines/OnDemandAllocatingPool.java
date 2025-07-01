import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.Function;

public final class OnDemandAllocatingPool<T> {
    private static final int CLOSED_FLAG = Integer.MIN_VALUE;
    
    private final int maxCapacity;
    private final Function<Integer, T> create;
    private final AtomicInteger controlState;
    private final AtomicReferenceArray<T> elements;

    public OnDemandAllocatingPool(int maxCapacity, Function<Integer, T> create) {
        if (create == null) {
            throw new NullPointerException("create");
        }
        this.maxCapacity = maxCapacity;
        this.create = create;
        this.controlState = new AtomicInteger(0);
        this.elements = new AtomicReferenceArray<>(maxCapacity);
    }

    private int tryForbidNewElements() {
        int current;
        do {
            current = controlState.get();
            if (isClosed(current)) {
                return 0;
            }
        } while (!controlState.compareAndSet(current, current | CLOSED_FLAG));
        return current;
    }

    private boolean isClosed(int state) {
        return (state & CLOSED_FLAG) != 0;
    }

    public boolean allocate() {
        int current;
        do {
            current = controlState.get();
            if (isClosed(current)) {
                return false;
            }
            if (current >= maxCapacity) {
                return true;
            }
        } while (!controlState.compareAndSet(current, current + 1));
        
        elements.set(current, create.apply(current));
        return true;
    }

    public List<T> close() {
        int elementsExisting = tryForbidNewElements();
        List<T> result = new ArrayList<>(elementsExisting);
        
        for (int i = 0; i < elementsExisting; i++) {
            T element;
            do {
                element = elements.getAndSet(i, null);
            } while (element == null);
            result.add(element);
        }
        
        return result;
    }

    public String stateRepresentation() {
        int ctl = controlState.get();
        List<T> activeElements = new ArrayList<>(ctl & Integer.MAX_VALUE);
        
        for (int i = 0; i < (ctl & Integer.MAX_VALUE); i++) {
            activeElements.add(elements.get(i));
        }
        
        String closedStr = isClosed(ctl) ? "[closed]" : "";
        return activeElements.toString() + closedStr;
    }

    @Override
    public String toString() {
        return "OnDemandAllocatingPool(" + stateRepresentation() + ")";
    }
}