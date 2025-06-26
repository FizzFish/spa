/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.rewrite.StringConcatRewriter
 *  soot.Body
 *  soot.BooleanType
 *  soot.ByteType
 *  soot.CharType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.IntType
 *  soot.Local
 *  soot.LongType
 *  soot.RefType
 *  soot.ShortType
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootResolver
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.Jimple
 *  soot.jimple.StringConstant
 */
package cn.sast.framework.rewrite;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import soot.Body;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.Local;
import soot.LongType;
import soot.RefType;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.SootResolver;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.Jimple;
import soot.jimple.StringConstant;

public class StringConcatRewriter {
    private static final String JAVA_OBJECT = "java.lang.Object";
    private static final String JAVA_STRING = "java.lang.String";
    private static final String JAVA_STRINGBUILDER = "java.lang.StringBuilder";
    private static final String JAVA_STRINGBUILDER_INIT = "void <init>()";
    private static final String JAVA_STRINGBUILDER_TOSTRING = "java.lang.String toString()";
    private static final String APPEND = "append";
    private SootMethod StringBuilder_init;
    private SootMethod StringBuilder_toString;
    private SootMethod defaultStringBuilder_append;
    private Map<Type, SootMethod> StringBuilder_append;

    public StringConcatRewriter() {
        this.init();
    }

    private void init() {
        SootClass java_lang_StringBuilder = SootResolver.v().resolveClass(JAVA_STRINGBUILDER, 2);
        this.StringBuilder_init = java_lang_StringBuilder.getMethod(JAVA_STRINGBUILDER_INIT);
        this.StringBuilder_toString = java_lang_StringBuilder.getMethod(JAVA_STRINGBUILDER_TOSTRING);
        this.StringBuilder_append = new HashMap();
        this.defaultStringBuilder_append = java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(RefType.v((String)JAVA_OBJECT)), (Type)RefType.v((String)JAVA_STRINGBUILDER));
        this.StringBuilder_append.put(BooleanType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(BooleanType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(CharType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(CharType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(ByteType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(IntType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(ShortType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(IntType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(IntType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(IntType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(LongType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(LongType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(FloatType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(FloatType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(DoubleType.v(), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(DoubleType.v()), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
        this.StringBuilder_append.put(RefType.v((String)JAVA_STRING), java_lang_StringBuilder.getMethod(APPEND, Collections.singletonList(RefType.v((String)JAVA_STRING)), (Type)RefType.v((String)JAVA_STRINGBUILDER)));
    }

    public LinkedList<Unit> rewriteMakeConcat(Body body, Value outValue, List<Value> concatArgs) {
        return this.rewrite(body, outValue, concatArgs);
    }

    public LinkedList<Unit> rewriteMakeConcatWithConstants(Body body, Value outValue, List<Value> concatArgs, List<Value> bootstrapArgs) {
        Value recipeValue = bootstrapArgs.get(0);
        if (!(recipeValue instanceof StringConstant)) {
            throw new IllegalArgumentException("makeConcatWithConstants argument 'recipe' must be a String!");
        }
        String recipe = ((StringConstant)recipeValue).value;
        LinkedList<Object> args = new LinkedList<Object>();
        StringBuilder sb = new StringBuilder();
        int argIndex = 0;
        int constIndex = 1;
        int length = recipe.length();
        for (int i = 0; i < length; ++i) {
            char c = recipe.charAt(i);
            if (c == '\u0001') {
                if (sb.length() > 0) {
                    args.add(StringConstant.v((String)sb.toString()));
                    sb.setLength(0);
                }
                args.add(concatArgs.get(argIndex++));
                continue;
            }
            if (c == '\u0002') {
                StringConstant constant = (StringConstant)bootstrapArgs.get(constIndex++);
                sb.append(constant.value);
                continue;
            }
            sb.append(c);
        }
        if (sb.length() > 0) {
            args.add(StringConstant.v((String)sb.toString()));
        }
        return this.rewrite(body, outValue, args);
    }

    private LinkedList<Unit> rewrite(Body body, Value outValue, List<Value> args) {
        LinkedList<Unit> newUnits = new LinkedList<Unit>();
        Local stringBuilderLocal = this.createNewLocal(body, (Type)RefType.v((String)JAVA_STRINGBUILDER));
        newUnits.add((Unit)Jimple.v().newAssignStmt((Value)stringBuilderLocal, (Value)Jimple.v().newNewExpr(RefType.v((String)JAVA_STRINGBUILDER))));
        newUnits.add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newSpecialInvokeExpr(stringBuilderLocal, this.StringBuilder_init.makeRef())));
        for (Value value : args) {
            if (value instanceof StringConstant) {
                Local constString = this.createNewLocal(body, (Type)RefType.v((String)JAVA_STRING));
                newUnits.add((Unit)Jimple.v().newAssignStmt((Value)constString, value));
                value = constString;
            }
            newUnits.add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newVirtualInvokeExpr(stringBuilderLocal, this.StringBuilder_append.getOrDefault(value.getType(), this.defaultStringBuilder_append).makeRef(), value)));
        }
        newUnits.add((Unit)Jimple.v().newAssignStmt(outValue, (Value)Jimple.v().newVirtualInvokeExpr(stringBuilderLocal, this.StringBuilder_toString.makeRef())));
        return newUnits;
    }

    private Local createNewLocal(Body body, Type t) {
        Local local = Jimple.v().newLocal("$v" + body.getLocals().size(), t);
        body.getLocals().add((Object)local);
        return local;
    }
}

