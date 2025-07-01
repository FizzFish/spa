package cn.sast.dataflow.infoflow.provider;

import com.feysh.corax.config.api.AttributeName;
import com.feysh.corax.config.api.BuiltInField;
import com.feysh.corax.config.api.ClassField;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.SubFields;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class FieldFinder {
    private static final Logger logger = LoggerFactory.getLogger(FieldFinder.class);

    @Nullable
    private final Set<String> baseTypes;
    @NotNull
    private final List<IClassField> acc;

    public FieldFinder(@Nullable Set<String> baseTypes, @NotNull List<? extends IClassField> acc) {
        if (acc == null) throw new IllegalArgumentException("acc must not be null");
        this.baseTypes = baseTypes;
        this.acc = new ArrayList<>(acc);
    }

    public FieldFinder(@Nullable String baseTypes, @NotNull List<? extends IClassField> acc) {
        this(baseTypes != null ? Set.of(baseTypes) : null, acc);
    }

    @NotNull
    public List<AccessPath> sootFields() {
        return find();
    }

    @NotNull
    public List<AccessPath> find() {
        if (acc.isEmpty()) {
            return List.of(new AccessPath(Collections.emptyList(), false));
        }

        List<AccessPath> res = new ArrayList<>();
        Queue<Task> workList = new LinkedList<>();
        workList.add(new Task(Collections.emptyList(), acc));

        while (!workList.isEmpty()) {
            Task cur = workList.poll();
            IClassField field = cur.getRight().get(0);

            if (field instanceof ClassField) {
                SootField sf = FieldFinderKt.getSootField((ClassField) field);
                if (sf == null) continue;

                List<IClassField> newRight = cur.getRight().subList(1, cur.getRight().size());
                if (newRight.isEmpty()) {
                    res.add(new AccessPath(append(cur.getLeft(), sf), false));
                } else {
                    workList.add(new Task(append(cur.getLeft(), sf), newRight));
                }
            } else if (field instanceof SubFields) {
                if (cur.getRight().size() != 1) {
                    throw new IllegalArgumentException("oops: " + cur);
                }
                res.add(new AccessPath(cur.getLeft(), true));
            } else if (field instanceof BuiltInField || field instanceof AttributeName) {
                res.add(new AccessPath(cur.getLeft(), false));
            }
        }
        return res;
    }

    private static <T> List<T> append(List<T> list, T element) {
        List<T> newList = new ArrayList<>(list);
        newList.add(element);
        return newList;
    }

    public static final class AccessPath {
        private final List<SootField> fields;
        private final boolean isSubFields;

        public AccessPath(List<SootField> fields, boolean isSubFields) {
            this.fields = fields;
            this.isSubFields = isSubFields;
        }

        public List<SootField> getFields() {
            return fields;
        }

        public boolean isSubFields() {
            return isSubFields;
        }
    }

    public static final class Task {
        private final List<SootField> left;
        private final List<IClassField> right;

        public Task(List<SootField> left, List<IClassField> right) {
            this.left = left;
            this.right = right;
        }

        public List<SootField> getLeft() {
            return left;
        }

        public List<IClassField> getRight() {
            return right;
        }
    }

    public static final class Companion {
        private Companion() {}
    }
}