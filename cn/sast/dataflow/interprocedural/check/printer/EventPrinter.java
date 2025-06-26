/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.analysis.EntryParam
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  cn.sast.dataflow.interprocedural.check.AssignLocalPath
 *  cn.sast.dataflow.interprocedural.check.ExitInvoke
 *  cn.sast.dataflow.interprocedural.check.GetEdgePath
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath
 *  cn.sast.dataflow.interprocedural.check.LiteralPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.ModelBind
 *  cn.sast.dataflow.interprocedural.check.PrevCallStmtInfo
 *  cn.sast.dataflow.interprocedural.check.SetEdgePath
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinter
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinter$WhenMappings
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter$Companion
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.TaintProperty
 *  com.feysh.corax.config.api.baseimpl.IexConst
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Local
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.Constant
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.IdentityStmt
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 *  soot.tagkit.ParamNamesTag
 */
package cn.sast.dataflow.interprocedural.check.printer;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.EntryParam;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import cn.sast.dataflow.interprocedural.check.AssignLocalPath;
import cn.sast.dataflow.interprocedural.check.ExitInvoke;
import cn.sast.dataflow.interprocedural.check.GetEdgePath;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import cn.sast.dataflow.interprocedural.check.LiteralPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.ModelBind;
import cn.sast.dataflow.interprocedural.check.PrevCallStmtInfo;
import cn.sast.dataflow.interprocedural.check.SetEdgePath;
import cn.sast.dataflow.interprocedural.check.printer.EventPrinter;
import cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt;
import cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.baseimpl.IexConst;
import com.feysh.corax.config.api.report.Region;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.DefinitionStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.tagkit.ParamNamesTag;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0003J\b\u0010#\u001a\u00020\u0010H\u0002J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J$\u0010\u001e\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140(2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010)\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0003\u0018\u00010*8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2={"Lcn/sast/dataflow/interprocedural/check/printer/EventPrinter;", "", "prefix", "", "<init>", "(Ljava/lang/String;)V", "outputEn", "Ljava/lang/StringBuffer;", "outputZh", "region", "Lcom/feysh/corax/config/api/report/Region;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "setRegion", "(Lcom/feysh/corax/config/api/report/Region;)V", "plusAssign", "", "string", "default", "pathNode", "Lcn/sast/dataflow/interprocedural/check/IPath;", "unit", "Lsoot/Unit;", "printModelingBinding", "v", "Lcn/sast/dataflow/interprocedural/check/ModelBind;", "sootMethod", "Lsoot/SootMethod;", "printModeling", "pathEvent", "normalPrint", "node", "Lcn/sast/dataflow/interprocedural/check/ExitInvoke;", "write", "s", "clean", "calleeBeginPrint", "invoke", "Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;", "nodeI", "Lkotlin/collections/IndexedValue;", "message", "", "Lcom/feysh/corax/config/api/Language;", "getMessage", "()Ljava/util/Map;", "printParameterNameByIndex", "", "index", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nEventPrinter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/EventPrinter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,245:1\n1#2:246\n1#2:249\n1#2:251\n1#2:253\n310#3:247\n303#3:248\n303#3:250\n303#3:252\n808#4,11:254\n*S KotlinDebug\n*F\n+ 1 EventPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/EventPrinter\n*L\n101#1:249\n129#1:251\n156#1:253\n100#1:247\n101#1:248\n129#1:250\n156#1:252\n225#1:254,11\n*E\n"})
public final class EventPrinter {
    @NotNull
    private final String prefix;
    @NotNull
    private StringBuffer outputEn;
    @NotNull
    private StringBuffer outputZh;
    @Nullable
    private Region region;

    public EventPrinter(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        this.prefix = prefix;
        this.outputEn = new StringBuffer();
        this.outputZh = new StringBuffer();
    }

    @Nullable
    public final Region getRegion() {
        return this.region;
    }

    public final void setRegion(@Nullable Region region) {
        this.region = region;
    }

    public final void plusAssign(@NotNull StringBuffer $this$plusAssign, @NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)$this$plusAssign, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        $this$plusAssign.append(string);
    }

    public final void default(@NotNull IPath pathNode, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)pathNode, (String)"pathNode");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        String keyPath = SimpleUnitPrinter.Companion.getStringOf(unit);
        this.plusAssign(this.outputEn, "key path: " + keyPath);
        this.plusAssign(this.outputZh, "\u5173\u952e\u8def\u5f84: " + keyPath);
    }

    /*
     * WARNING - void declaration
     */
    private final void printModelingBinding(ModelBind v, Unit unit, SootMethod sootMethod) {
        if (v.getMt() instanceof TaintProperty) {
            List params;
            IValue iValue = v.getObj();
            if (iValue instanceof EntryParam || iValue instanceof PhantomField) {
                this.plusAssign(this.outputZh, "\u6c61\u70b9\u6e90 Source \u70b9: ");
                this.plusAssign(this.outputEn, "Taint source: ");
                IValue iValue2 = v.getObj();
                if (iValue2 instanceof EntryParam && this.printParameterNameByIndex(((EntryParam)iValue2).getMethod(), ((EntryParam)iValue2).getParamIndex())) {
                    return;
                }
            } else {
                this.plusAssign(this.outputZh, "\u6c61\u70b9\u4f20\u9012");
                this.plusAssign(this.outputEn, "Taint propagate");
            }
            String call = SimpleUnitPrinter.Companion.getStringOf(unit);
            boolean msg = false;
            if (!(unit instanceof IdentityStmt)) {
                this.write(": " + call);
                msg = true;
            }
            if (v.getInfo() != null && !((Collection)(params = v.getInfo().getParameterNamesInUnitDefUse(unit))).isEmpty()) {
                String paramsStr = CollectionsKt.joinToString$default((Iterable)params, (CharSequence)", ", null, null, (int)0, null, null, (int)62, null);
                this.plusAssign(this.outputZh, ", \u5173\u952e\u4f4d\u7f6e: `" + paramsStr + "`");
                this.plusAssign(this.outputEn, ", key scope: `" + paramsStr + "`");
                if (v.getInfo() instanceof PrevCallStmtInfo) {
                    Region region;
                    EventPrinter eventPrinter = this;
                    Integer n = ((PrevCallStmtInfo)v.getInfo()).getFirstParamIndex();
                    if (n != null) {
                        void it;
                        int n2 = ((Number)n).intValue();
                        EventPrinter eventPrinter2 = eventPrinter;
                        boolean bl = false;
                        region = Region.Companion.getParamRegion(sootMethod, (int)it);
                        eventPrinter = eventPrinter2;
                    } else {
                        region = null;
                    }
                    eventPrinter.region = region;
                }
                msg = true;
            }
            if (msg) {
                return;
            }
            this.clean();
        }
        this.default((IPath)v, unit);
    }

    @NotNull
    public final EventPrinter printModeling(@NotNull ModelBind pathEvent, @NotNull Unit unit, @NotNull SootMethod sootMethod) {
        Intrinsics.checkNotNullParameter((Object)pathEvent, (String)"pathEvent");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        this.printModelingBinding(pathEvent, unit, sootMethod);
        return this;
    }

    @NotNull
    public final EventPrinter normalPrint(@NotNull ExitInvoke node) {
        InvokeExpr invokeExpr;
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        SootMethod sootMethod = node.getInvoke().getCallee();
        Unit $this$leftOp$iv = node.getInvoke().getNode();
        boolean $i$f$getLeftOp = false;
        DefinitionStmt definitionStmt = $this$leftOp$iv instanceof DefinitionStmt ? (DefinitionStmt)$this$leftOp$iv : null;
        Object object = definitionStmt != null ? definitionStmt.getLeftOp() : null;
        Unit $this$invokeExprOrNull$iv = node.getInvoke().getNode();
        boolean $i$f$getInvokeExprOrNull = false;
        Stmt stmt = $this$invokeExprOrNull$iv instanceof Stmt ? (Stmt)$this$invokeExprOrNull$iv : null;
        if (stmt != null) {
            Stmt it$iv = stmt;
            boolean bl = false;
            invokeExpr = ((Stmt)$this$invokeExprOrNull$iv).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull$iv).getInvokeExpr() : null;
        } else {
            invokeExpr = null;
        }
        String call = SimpleUnitPrinter.Companion.getStringOf$default((SimpleUnitPrinter.Companion)SimpleUnitPrinter.Companion, (SootMethod)sootMethod, (Value)object, invokeExpr, (boolean)false, (int)8, null);
        this.plusAssign(this.outputZh, "\u79bb\u5f00\u88ab\u8c03\u7528\u65b9\u6cd5: `" + call + "`");
        this.plusAssign(this.outputEn, "return from calling: `" + call + "`");
        return this;
    }

    public final void write(@NotNull String s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        this.plusAssign(this.outputZh, s);
        this.plusAssign(this.outputEn, s);
    }

    private final void clean() {
        this.outputZh = new StringBuffer();
        this.outputEn = new StringBuffer();
    }

    @NotNull
    public final EventPrinter calleeBeginPrint(@NotNull InvokeEdgePath invoke) {
        Intrinsics.checkNotNullParameter((Object)invoke, (String)"invoke");
        SootMethod container = invoke.getContainer();
        String call = container.getDeclaringClass().getName() + "#" + container.getName();
        this.plusAssign(this.outputZh, "\u4ece `" + call + "` \u8fdb\u5165\u8c03\u7528");
        this.plusAssign(this.outputEn, "calling from: `" + call + "`");
        return this;
    }

    @NotNull
    public final EventPrinter normalPrint(@NotNull IndexedValue<? extends IPath> nodeI, @NotNull Unit unit, @NotNull SootMethod sootMethod) {
        Intrinsics.checkNotNullParameter(nodeI, (String)"nodeI");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        IPath node = (IPath)nodeI.getValue();
        if (node instanceof InvokeEdgePath) {
            InvokeExpr invokeExpr;
            SootMethod sootMethod2 = ((InvokeEdgePath)node).getCallee();
            Unit $this$invokeExprOrNull$iv = unit;
            boolean $i$f$getInvokeExprOrNull = false;
            Stmt stmt = $this$invokeExprOrNull$iv instanceof Stmt ? (Stmt)$this$invokeExprOrNull$iv : null;
            if (stmt != null) {
                Stmt it$iv = stmt;
                boolean bl = false;
                invokeExpr = ((Stmt)$this$invokeExprOrNull$iv).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull$iv).getInvokeExpr() : null;
            } else {
                invokeExpr = null;
            }
            String call = SimpleUnitPrinter.Companion.getStringOf$default((SimpleUnitPrinter.Companion)SimpleUnitPrinter.Companion, (SootMethod)sootMethod2, null, invokeExpr, (boolean)false, (int)8, null);
            this.plusAssign(this.outputZh, "\u8fdb\u5165\u88ab\u8c03\u7528\u65b9\u6cd5: `" + call + "`");
            this.plusAssign(this.outputEn, "calling: `" + call + "`");
        } else if (!(node instanceof MergePath)) {
            if (node instanceof AssignLocalPath) {
                this.default(node, unit);
            } else if (node instanceof ModelBind) {
                this.printModelingBinding((ModelBind)node, unit, sootMethod);
            } else if (node instanceof LiteralPath) {
                Object object = ((LiteralPath)node).getConst();
                if (object instanceof IexConst) {
                    switch (WhenMappings.$EnumSwitchMapping$0[((IexConst)object).getType().ordinal()]) {
                        case 1: {
                            InvokeExpr invokeExpr;
                            Unit $this$invokeExprOrNull$iv = unit;
                            boolean $i$f$getInvokeExprOrNull = false;
                            Stmt stmt = $this$invokeExprOrNull$iv instanceof Stmt ? (Stmt)$this$invokeExprOrNull$iv : null;
                            if (stmt != null) {
                                Stmt it$iv = stmt;
                                boolean bl = false;
                                v4 = ((Stmt)$this$invokeExprOrNull$iv).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull$iv).getInvokeExpr() : null;
                            } else {
                                v4 = invokeExpr = null;
                            }
                            if (invokeExpr != null && nodeI.getIndex() == 0) {
                                this.plusAssign(this.outputZh, "\u6c61\u70b9\u6e90 Source \u70b9: ");
                                this.plusAssign(this.outputEn, "Taint source: ");
                                String call = SimpleUnitPrinter.Companion.getStringOf$default((SimpleUnitPrinter.Companion)SimpleUnitPrinter.Companion, null, null, (InvokeExpr)invokeExpr, (boolean)false, (int)8, null);
                                this.write(call);
                                break;
                            }
                            this.clean();
                            return this;
                        }
                        case 2: {
                            this.clean();
                            return this;
                        }
                        default: {
                            this.plusAssign(this.outputZh, ((IexConst)object).getType() + " \u7c7b\u578b\u7684\u5e38\u91cf: ");
                            this.plusAssign(this.outputEn, ((IexConst)object).getType() + " type constant: ");
                            this.write("`" + ((IexConst)object).getConst() + "`");
                            break;
                        }
                    }
                } else if (object instanceof Constant) {
                    Type type = ((Constant)object).getType();
                    Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
                    String ty = EventPrinterKt.getPname((Type)type);
                    this.plusAssign(this.outputZh, ty + " \u7c7b\u578b\u7684\u5e38\u91cf: ");
                    this.plusAssign(this.outputEn, ty + " type constant: ");
                    this.write(String.valueOf(object));
                }
            } else if (node instanceof GetEdgePath) {
                this.default(node, unit);
            } else if (node instanceof SetEdgePath) {
                this.default(node, unit);
            } else {
                this.default(node, unit);
            }
        }
        return this;
    }

    @Nullable
    public final Map<Language, String> getMessage() {
        if (((CharSequence)this.outputEn).length() == 0) {
            return null;
        }
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Language.EN, (Object)(this.prefix + " " + this.outputEn)), TuplesKt.to((Object)Language.ZH, (Object)(this.prefix + " " + this.outputZh))};
        return MapsKt.mapOf((Pair[])pairArray);
    }

    /*
     * WARNING - void declaration
     */
    private final boolean printParameterNameByIndex(SootMethod sootMethod, int index) {
        boolean bl;
        if (index == -1) {
            String ty = sootMethod.getDeclaringClass().getName();
            this.plusAssign(this.outputZh, ty + "\u7c7b\u578b\u7684\u53c2\u6570: this");
            this.plusAssign(this.outputEn, ty + " type parameter: this");
            this.region = Region.Companion.getParamRegion(sootMethod, index);
            bl = true;
        } else if (index >= 0 && index < sootMethod.getParameterCount()) {
            void $this$filterIsInstanceTo$iv$iv;
            List list = sootMethod.getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            Iterable $this$filterIsInstance$iv = list;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof ParamNamesTag)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Object object = (ParamNamesTag)CollectionsKt.firstOrNull((List)((List)destination$iv$iv));
            if (object == null || (object = object.getNames()) == null) {
                object = CollectionsKt.emptyList();
            }
            Object names = object;
            Type ty = sootMethod.getParameterType(index);
            String string = (String)CollectionsKt.getOrNull((List)names, (int)index);
            if (string == null) {
                Object object2;
                String string2;
                try {
                    String string3;
                    Body body = SootUtilsKt.getActiveBodyOrNull((SootMethod)sootMethod);
                    if (body != null && (body = body.getParameterLocal(index)) != null) {
                        Body it = body;
                        boolean bl2 = false;
                        string3 = "local var " + (Local)it;
                    } else {
                        string3 = null;
                    }
                    string2 = string3;
                }
                catch (RuntimeException ignore) {
                    string2 = null;
                }
                String string4 = string2;
                if (string4 != null) {
                    String it = string4;
                    boolean bl3 = false;
                    object2 = ": `" + it + "`";
                } else {
                    object2 = string = null;
                }
                if (object2 == null) {
                    string = "";
                }
            }
            String name = string;
            this.plusAssign(this.outputZh, ty + "\u7c7b\u578b\u7684\u7b2c" + (index + 1) + "\u4e2a\u53c2\u6570" + name + "`");
            this.plusAssign(this.outputEn, ty + " type parameter" + (index + 1) + name + "}");
            this.region = Region.Companion.getParamRegion(sootMethod, index);
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }
}

