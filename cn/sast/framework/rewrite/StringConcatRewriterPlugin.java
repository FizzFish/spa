/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.rewrite.StringConcatRewriter
 *  cn.sast.framework.rewrite.StringConcatRewriterPlugin
 *  soot.Body
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.DynamicInvokeExpr
 *  soot.tagkit.LineNumberTag
 *  soot.tagkit.Tag
 */
package cn.sast.framework.rewrite;

import cn.sast.framework.rewrite.StringConcatRewriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import soot.Body;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.DynamicInvokeExpr;
import soot.tagkit.LineNumberTag;
import soot.tagkit.Tag;

/*
 * Exception performing whole class analysis ignored.
 */
public class StringConcatRewriterPlugin {
    private final StringConcatRewriter rewriter = new StringConcatRewriter();
    private static final String ARG_KEY_ENABLE_PLUGIN = "enableJava9StringConcat";
    private Boolean enabled;

    private static boolean isMakeConcatBootstrapMethod(SootMethodRef methodRef) {
        return methodRef.getDeclaringClass().getName().equals("java.lang.invoke.StringConcatFactory") && methodRef.getName().equals("makeConcat");
    }

    private static boolean isMakeConcatWithConstantsBootstrapMethod(SootMethodRef methodRef) {
        return methodRef.getDeclaringClass().getName().equals("java.lang.invoke.StringConcatFactory") && methodRef.getName().equals("makeConcatWithConstants");
    }

    public void transform(SootClass sootClass) throws IOException {
        for (SootMethod method : sootClass.getMethods()) {
            this.transformStringConcats(method);
        }
    }

    public void transformStringConcats(SootMethod method) {
        if (!method.isConcrete()) {
            return;
        }
        Body body = method.retrieveActiveBody();
        if (body == null) {
            return;
        }
        this.transformStringConcats(body);
    }

    public void transformStringConcats(Body body) {
        UnitPatchingChain units = body.getUnits();
        if (units.isEmpty()) {
            return;
        }
        Unit unit = units.getFirst();
        while (unit != null) {
            if (unit instanceof DefinitionStmt && ((DefinitionStmt)unit).getRightOp() instanceof DynamicInvokeExpr) {
                DynamicInvokeExpr expr = (DynamicInvokeExpr)((DefinitionStmt)unit).getRightOp();
                Value outValue = ((DefinitionStmt)unit).getLeftOp();
                SootMethodRef bootstrapMethodRef = expr.getBootstrapMethodRef();
                List args = expr.getArgs();
                List bootstrapArgs = expr.getBootstrapArgs();
                LinkedList newUnits = null;
                if (StringConcatRewriterPlugin.isMakeConcatBootstrapMethod((SootMethodRef)bootstrapMethodRef)) {
                    newUnits = this.rewriter.rewriteMakeConcat(body, outValue, args);
                } else if (StringConcatRewriterPlugin.isMakeConcatWithConstantsBootstrapMethod((SootMethodRef)bootstrapMethodRef)) {
                    newUnits = this.rewriter.rewriteMakeConcatWithConstants(body, outValue, args, bootstrapArgs);
                }
                if (newUnits != null) {
                    int ln = unit.getJavaSourceStartLineNumber();
                    if (ln != -1) {
                        for (Unit u : newUnits) {
                            u.addTag((Tag)new LineNumberTag(ln));
                        }
                    }
                    units.insertAfter((List)newUnits, unit);
                    units.remove((Object)unit);
                    unit = (Unit)newUnits.getLast();
                }
            }
            unit = body.getUnits().getSuccOf(unit);
        }
    }
}

