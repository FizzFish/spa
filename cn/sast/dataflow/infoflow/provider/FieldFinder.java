/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.FieldFinder
 *  cn.sast.dataflow.infoflow.provider.FieldFinder$AccessPath
 *  cn.sast.dataflow.infoflow.provider.FieldFinder$Companion
 *  cn.sast.dataflow.infoflow.provider.FieldFinder$Task
 *  cn.sast.dataflow.infoflow.provider.FieldFinderKt
 *  com.feysh.corax.config.api.AttributeName
 *  com.feysh.corax.config.api.BuiltInField
 *  com.feysh.corax.config.api.ClassField
 *  com.feysh.corax.config.api.IClassField
 *  com.feysh.corax.config.api.SubFields
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 */
package cn.sast.dataflow.infoflow.provider;

import cn.sast.dataflow.infoflow.provider.FieldFinder;
import cn.sast.dataflow.infoflow.provider.FieldFinderKt;
import com.feysh.corax.config.api.AttributeName;
import com.feysh.corax.config.api.BuiltInField;
import com.feysh.corax.config.api.ClassField;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.SubFields;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0003\u000e\u000f\u0010B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/infoflow/provider/FieldFinder;", "", "baseTypes", "", "", "acc", "", "Lcom/feysh/corax/config/api/IClassField;", "<init>", "(Ljava/util/Set;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/util/List;)V", "sootFields", "Lcn/sast/dataflow/infoflow/provider/FieldFinder$AccessPath;", "find", "Companion", "AccessPath", "Task", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nFieldFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FieldFinder.kt\ncn/sast/dataflow/infoflow/provider/FieldFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n1#2:83\n*E\n"})
public final class FieldFinder {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Set<String> baseTypes;
    @NotNull
    private final List<IClassField> acc;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(FieldFinder::logger$lambda$2);

    public FieldFinder(@Nullable Set<String> baseTypes, @NotNull List<? extends IClassField> acc) {
        Intrinsics.checkNotNullParameter(acc, (String)"acc");
        this.baseTypes = baseTypes;
        this.acc = acc;
    }

    /*
     * WARNING - void declaration
     */
    public FieldFinder(@Nullable String baseTypes, @NotNull List<? extends IClassField> acc) {
        Set set;
        Intrinsics.checkNotNullParameter(acc, (String)"acc");
        FieldFinder fieldFinder = this;
        String string = baseTypes;
        if (string != null) {
            void it;
            String string2 = string;
            FieldFinder fieldFinder2 = fieldFinder;
            boolean bl = false;
            set = SetsKt.setOf((Object)it);
            fieldFinder = fieldFinder2;
        } else {
            set = null;
        }
        fieldFinder(set, acc);
    }

    @NotNull
    public final List<AccessPath> sootFields() {
        return this.find();
    }

    @NotNull
    public final List<AccessPath> find() {
        if (this.acc.isEmpty()) {
            return CollectionsKt.listOf((Object)new AccessPath(CollectionsKt.emptyList(), false));
        }
        List res = new ArrayList();
        Queue workList = new LinkedList();
        workList.add(new Task(CollectionsKt.emptyList(), this.acc));
        while (!workList.isEmpty()) {
            Task cur = (Task)workList.poll();
            IClassField field = (IClassField)CollectionsKt.first((List)cur.getRight());
            if (field instanceof ClassField) {
                SootField sf;
                if (FieldFinderKt.getSootField((ClassField)((ClassField)field)) == null) continue;
                List newRight = CollectionsKt.drop((Iterable)cur.getRight(), (int)1);
                boolean bl = newRight.isEmpty() ? res.add(new AccessPath(CollectionsKt.plus((Collection)cur.getLeft(), (Object)sf), false)) : workList.add(new Task(CollectionsKt.plus((Collection)cur.getLeft(), (Object)sf), newRight));
                continue;
            }
            if (field instanceof SubFields) {
                if (!(cur.getRight().size() == 1)) {
                    boolean bl = false;
                    String string = "oops: " + cur;
                    throw new IllegalArgumentException(string.toString());
                }
                res.add(new AccessPath(cur.getLeft(), true));
                continue;
            }
            if (field instanceof BuiltInField) {
                res.add(new AccessPath(cur.getLeft(), false));
                continue;
            }
            if (!(field instanceof AttributeName)) continue;
            res.add(new AccessPath(cur.getLeft(), false));
        }
        return res;
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }
}

