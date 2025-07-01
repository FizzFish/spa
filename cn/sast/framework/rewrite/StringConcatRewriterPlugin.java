/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 */
package cn.sast.framework.rewrite;

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

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StringConcatRewriterPlugin {
    private final StringConcatRewriter rewriter = new StringConcatRewriter();
    private static final String ARG_KEY_ENABLE_PLUGIN = "enableJava9StringConcat";
    private Boolean enabled;

    private static boolean isMakeConcatBootstrapMethod(SootMethodRef methodRef) {
        return "java.lang.invoke.StringConcatFactory".equals(methodRef.getDeclaringClass().getName()) 
                && "makeConcat".equals(methodRef.getName());
    }

    private static boolean isMakeConcatWithConstantsBootstrapMethod(SootMethodRef methodRef) {
        return "java.lang.invoke.StringConcatFactory".equals(methodRef.getDeclaringClass().getName()) 
                && "makeConcatWithConstants".equals(methodRef.getName());
    }

    public void transform(SootClass sootClass) throws IOException {
        for (SootMethod method : sootClass.getMethods()) {
            transformStringConcats(method);
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
        transformStringConcats(body);
    }

    public void transformStringConcats(Body body) {
        UnitPatchingChain units = body.getUnits();
        if (units.isEmpty()) {
            return;
        }

        Unit unit = units.getFirst();
        while (unit != null) {
            if (unit instanceof DefinitionStmt defStmt && defStmt.getRightOp() instanceof DynamicInvokeExpr expr) {
                Value outValue = defStmt.getLeftOp();
                SootMethodRef bootstrapMethodRef = expr.getBootstrapMethodRef();
                List<Value> args = expr.getArgs();
                List<Value> bootstrapArgs = expr.getBootstrapArgs();

                LinkedList<Unit> newUnits = null;
                if (isMakeConcatBootstrapMethod(bootstrapMethodRef)) {
                    newUnits = rewriter.rewriteMakeConcat(body, outValue, args);
                } else if (isMakeConcatWithConstantsBootstrapMethod(bootstrapMethodRef)) {
                    newUnits = rewriter.rewriteMakeConcatWithConstants(body, outValue, args, bootstrapArgs);
                }

                if (newUnits != null) {
                    int lineNumber = unit.getJavaSourceStartLineNumber();
                    if (lineNumber != -1) {
                        newUnits.forEach(u -> u.addTag(new LineNumberTag(lineNumber)));
                    }
                    units.insertAfter(newUnits, unit);
                    units.remove(unit);
                    unit = newUnits.getLast();
                }
            }
            unit = body.getUnits().getSuccOf(unit);
        }
    }
}