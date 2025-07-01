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
    
    private final SootMethod StringBuilder_init;
    private final SootMethod StringBuilder_toString;
    private final SootMethod defaultStringBuilder_append;
    private final Map<Type, SootMethod> StringBuilder_append;

    public StringConcatRewriter() {
        SootClass javaLangStringBuilder = SootResolver.v().resolveClass(JAVA_STRINGBUILDER, 2);
        this.StringBuilder_init = javaLangStringBuilder.getMethod(JAVA_STRINGBUILDER_INIT);
        this.StringBuilder_toString = javaLangStringBuilder.getMethod(JAVA_STRINGBUILDER_TOSTRING);
        
        this.StringBuilder_append = new HashMap<>();
        this.defaultStringBuilder_append = javaLangStringBuilder.getMethod(
            APPEND, 
            Collections.singletonList(RefType.v(JAVA_OBJECT)), 
            RefType.v(JAVA_STRINGBUILDER)
        );
        
        initAppendMethods(javaLangStringBuilder);
    }

    private void initAppendMethods(SootClass stringBuilderClass) {
        StringBuilder_append.put(BooleanType.v(), getAppendMethod(stringBuilderClass, BooleanType.v()));
        StringBuilder_append.put(CharType.v(), getAppendMethod(stringBuilderClass, CharType.v()));
        StringBuilder_append.put(ByteType.v(), getAppendIntMethod(stringBuilderClass));
        StringBuilder_append.put(ShortType.v(), getAppendIntMethod(stringBuilderClass));
        StringBuilder_append.put(IntType.v(), getAppendMethod(stringBuilderClass, IntType.v()));
        StringBuilder_append.put(LongType.v(), getAppendLongMethod(stringBuilderClass));
        StringBuilder_append.put(FloatType.v(), getAppendMethod(stringBuilderClass, FloatType.v()));
        StringBuilder_append.put(DoubleType.v(), getAppendMethod(stringBuilderClass, DoubleType.v()));
        StringBuilder_append.put(RefType.v(JAVA_STRING), getAppendMethod(stringBuilderClass, RefType.v(JAVA_STRING)));
    }

    private SootMethod getAppendMethod(SootClass stringBuilderClass, Type paramType) {
        return stringBuilderClass.getMethod(
            APPEND,
            Collections.singletonList(paramType),
            RefType.v(JAVA_STRINGBUILDER)
        );
    }

    private SootMethod getAppendIntMethod(SootClass stringBuilderClass) {
        return getAppendMethod(stringBuilderClass, IntType.v());
    }

    private SootMethod getAppendLongMethod(SootClass stringBuilderClass) {
        return getAppendMethod(stringBuilderClass, LongType.v());
    }

    public LinkedList<Unit> rewriteMakeConcat(Body body, Value outValue, List<Value> concatArgs) {
        return rewrite(body, outValue, concatArgs);
    }

    public LinkedList<Unit> rewriteMakeConcatWithConstants(Body body, Value outValue, 
            List<Value> concatArgs, List<Value> bootstrapArgs) {
        Value recipeValue = bootstrapArgs.get(0);
        if (!(recipeValue instanceof StringConstant)) {
            throw new IllegalArgumentException("makeConcatWithConstants argument 'recipe' must be a String!");
        }
        
        String recipe = ((StringConstant)recipeValue).value;
        LinkedList<Value> args = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int argIndex = 0;
        int constIndex = 1;
        
        for (int i = 0; i < recipe.length(); i++) {
            char c = recipe.charAt(i);
            if (c == '\u0001') {
                addStringIfNeeded(args, sb);
                args.add(concatArgs.get(argIndex++));
            } else if (c == '\u0002') {
                StringConstant constant = (StringConstant)bootstrapArgs.get(constIndex++);
                sb.append(constant.value);
            } else {
                sb.append(c);
            }
        }
        addStringIfNeeded(args, sb);
        
        return rewrite(body, outValue, args);
    }

    private void addStringIfNeeded(List<Value> args, StringBuilder sb) {
        if (sb.length() > 0) {
            args.add(StringConstant.v(sb.toString()));
            sb.setLength(0);
        }
    }

    private LinkedList<Unit> rewrite(Body body, Value outValue, List<Value> args) {
        LinkedList<Unit> newUnits = new LinkedList<>();
        Local stringBuilderLocal = createNewLocal(body, RefType.v(JAVA_STRINGBUILDER));
        
        newUnits.add(Jimple.v().newAssignStmt(stringBuilderLocal, 
            Jimple.v().newNewExpr(RefType.v(JAVA_STRINGBUILDER))));
        newUnits.add(Jimple.v().newInvokeStmt(
            Jimple.v().newSpecialInvokeExpr(stringBuilderLocal, StringBuilder_init.makeRef())));
        
        for (Value value : args) {
            Value appendValue = value;
            if (value instanceof StringConstant) {
                Local constString = createNewLocal(body, RefType.v(JAVA_STRING));
                newUnits.add(Jimple.v().newAssignStmt(constString, value));
                appendValue = constString;
            }
            
            SootMethod appendMethod = StringBuilder_append.getOrDefault(
                appendValue.getType(), defaultStringBuilder_append);
            newUnits.add(Jimple.v().newInvokeStmt(
                Jimple.v().newVirtualInvokeExpr(stringBuilderLocal, appendMethod.makeRef(), appendValue)));
        }
        
        newUnits.add(Jimple.v().newAssignStmt(outValue, 
            Jimple.v().newVirtualInvokeExpr(stringBuilderLocal, StringBuilder_toString.makeRef())));
        return newUnits;
    }

    private Local createNewLocal(Body body, Type type) {
        Local local = Jimple.v().newLocal("$v" + body.getLocals().size(), type);
        body.getLocals().add(local);
        return local;
    }
}
