package cn.sast.dataflow.interprocedural.check.printer;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimpleUnitPrinter extends AbstractUnitPrinter {

    private String getQuotedStringOf(String fromString) {
        int fromStringLen = fromString.length();
        StringBuilder toStringBuffer = new StringBuilder(fromStringLen + 20);
        toStringBuffer.append("\"");
        
        for (int i = 0; i < fromStringLen; ++i) {
            char ch = fromString.charAt(i);
            switch (ch) {
                case '\\' -> toStringBuffer.append("\\\\");
                case '\"' -> toStringBuffer.append("\\\"");
                case '\n' -> toStringBuffer.append("\\n");
                case '\t' -> toStringBuffer.append("\\t");
                case '\r' -> toStringBuffer.append("\\r");
                default -> toStringBuffer.append(ch);
            }
        }
        toStringBuffer.append("\"");
        return toStringBuffer.toString();
    }

    public void literal(@NotNull String s) {
        output.append(s);
    }

    public void type(@NotNull Type t) {
        output.append(EventPrinterKt.getPname(t));
    }

    public void constant(@Nullable Constant c) {
        if (c instanceof StringConstant) {
            handleIndent();
            output.append(getQuotedStringOf(((StringConstant)c).value));
        } else {
            super.constant(c);
        }
    }

    public void methodRef(@NotNull SootMethodRef m) {
        SootClass sootClass = m.getDeclaringClass();
        output.append(SimpleUnitPrinterKt.getPrettyMethodName(sootClass, m.getName()));
    }

    public void fieldRef(@NotNull SootFieldRef f) {
        output.append(f.name());
    }

    public void unitRef(@Nullable Unit u, boolean branchTarget) {
        // Intentionally empty
    }

    public void identityRef(@NotNull IdentityRef r) {
        if (r instanceof ThisRef) {
            literal("@this: ");
            type(((ThisRef)r).getType());
        } else if (r instanceof ParameterRef) {
            literal("@parameter" + ((ParameterRef)r).getIndex() + ": ");
            type(((ParameterRef)r).getType());
        } else if (r instanceof CaughtExceptionRef) {
            literal("@caughtexception");
        } else {
            throw new RuntimeException();
        }
    }

    @NotNull
    public String toString() {
        return output.toString();
    }

    protected void handleIndent() {
        startOfLine = false;
    }
}