/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter$Companion
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinterKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.AbstractUnitPrinter
 *  soot.SootClass
 *  soot.SootFieldRef
 *  soot.SootMethodInterface
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.CaughtExceptionRef
 *  soot.jimple.Constant
 *  soot.jimple.IdentityRef
 *  soot.jimple.ParameterRef
 *  soot.jimple.StringConstant
 *  soot.jimple.ThisRef
 */
package cn.sast.dataflow.interprocedural.check.printer;

import cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt;
import cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter;
import cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.AbstractUnitPrinter;
import soot.SootClass;
import soot.SootFieldRef;
import soot.SootMethodInterface;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.Constant;
import soot.jimple.IdentityRef;
import soot.jimple.ParameterRef;
import soot.jimple.StringConstant;
import soot.jimple.ThisRef;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\bH\u0014\u00a8\u0006!"}, d2={"Lcn/sast/dataflow/interprocedural/check/printer/SimpleUnitPrinter;", "Lsoot/AbstractUnitPrinter;", "<init>", "()V", "getQuotedStringOf", "", "fromString", "literal", "", "s", "type", "t", "Lsoot/Type;", "constant", "c", "Lsoot/jimple/Constant;", "methodRef", "m", "Lsoot/SootMethodRef;", "fieldRef", "f", "Lsoot/SootFieldRef;", "unitRef", "u", "Lsoot/Unit;", "branchTarget", "", "identityRef", "r", "Lsoot/jimple/IdentityRef;", "toString", "handleIndent", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSimpleUnitPrinter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleUnitPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/SimpleUnitPrinter\n+ 2 SimpleUnitPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/SimpleUnitPrinterKt\n*L\n1#1,144:1\n17#2:145\n*S KotlinDebug\n*F\n+ 1 SimpleUnitPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/SimpleUnitPrinter\n*L\n57#1:145\n*E\n"})
public final class SimpleUnitPrinter
extends AbstractUnitPrinter {
    @NotNull
    public static final Companion Companion = new Companion(null);

    private final String getQuotedStringOf(String fromString) {
        int fromStringLen = fromString.length();
        StringBuilder toStringBuffer = new StringBuilder(fromStringLen + 20);
        toStringBuffer.append("\"");
        block7: for (int i = 0; i < fromStringLen; ++i) {
            char ch = fromString.charAt(i);
            switch (ch) {
                case '\\': {
                    StringBuilder stringBuilder = toStringBuffer.append("\\\\");
                    continue block7;
                }
                case '\"': {
                    StringBuilder stringBuilder = toStringBuffer.append("\\\"");
                    continue block7;
                }
                case '\n': {
                    StringBuilder stringBuilder = toStringBuffer.append("\\n");
                    continue block7;
                }
                case '\t': {
                    StringBuilder stringBuilder = toStringBuffer.append("\\t");
                    continue block7;
                }
                case '\r': {
                    StringBuilder stringBuilder = toStringBuffer.append("\\r");
                    continue block7;
                }
                default: {
                    StringBuilder stringBuilder = toStringBuffer.append(ch);
                }
            }
        }
        toStringBuffer.append("\"");
        String string = toStringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    public void literal(@NotNull String s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        this.output.append(s);
    }

    public void type(@NotNull Type t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        this.output.append(EventPrinterKt.getPname((Type)t));
    }

    public void constant(@Nullable Constant c) {
        if (c instanceof StringConstant) {
            this.handleIndent();
            String string = ((StringConstant)c).value;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"value");
            this.output.append(this.getQuotedStringOf(string));
        } else {
            super.constant(c);
        }
    }

    public void methodRef(@NotNull SootMethodRef m) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        boolean $i$f$getPrettyMethodName = false;
        SootClass sootClass = ((SootMethodInterface)m).getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        String string = ((SootMethodInterface)m).getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        this.output.append(SimpleUnitPrinterKt.getPrettyMethodName((SootClass)sootClass, (String)string));
    }

    public void fieldRef(@NotNull SootFieldRef f) {
        Intrinsics.checkNotNullParameter((Object)f, (String)"f");
        this.output.append(f.name());
    }

    public void unitRef(@Nullable Unit u, boolean branchTarget) {
    }

    public void identityRef(@NotNull IdentityRef r) {
        Intrinsics.checkNotNullParameter((Object)r, (String)"r");
        if (r instanceof ThisRef) {
            this.literal("@this: ");
            Type type = ((ThisRef)r).getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            this.type(type);
        } else if (r instanceof ParameterRef) {
            this.literal("@parameter" + ((ParameterRef)r).getIndex() + ": ");
            Type type = ((ParameterRef)r).getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            this.type(type);
        } else if (r instanceof CaughtExceptionRef) {
            this.literal("@caughtexception");
        } else {
            throw new RuntimeException();
        }
    }

    @NotNull
    public String toString() {
        String string = this.output.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    protected void handleIndent() {
        this.startOfLine = false;
    }
}

