/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.rewrite.LibraryClassPatcher
 *  cn.sast.framework.rewrite.LibraryClassPatcher$IMessageObtainCodeInjector
 *  soot.Body
 *  soot.IntType
 *  soot.Local
 *  soot.LocalGenerator
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootFieldRef
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.IntConstant
 *  soot.jimple.InvokeStmt
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.NullConstant
 *  soot.jimple.ReturnStmt
 *  soot.jimple.ReturnVoidStmt
 *  soot.jimple.infoflow.cfg.FlowDroidEssentialMethodTag
 *  soot.jimple.infoflow.util.SystemClassHandler
 *  soot.tagkit.Tag
 */
package cn.sast.framework.rewrite;

import cn.sast.framework.rewrite.LibraryClassPatcher;
import java.util.Collections;
import soot.Body;
import soot.IntType;
import soot.Local;
import soot.LocalGenerator;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.IntConstant;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NullConstant;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.infoflow.cfg.FlowDroidEssentialMethodTag;
import soot.jimple.infoflow.util.SystemClassHandler;
import soot.tagkit.Tag;

/*
 * Exception performing whole class analysis ignored.
 */
public class LibraryClassPatcher {
    public void patchLibraries() {
        this.patchHandlerImplementation();
        this.patchThreadImplementation();
        this.patchActivityImplementation();
        this.patchTimerImplementation();
        this.patchActivityGetFragmentManager();
        this.patchMessageObtainImplementation();
    }

    private void patchMessageObtainImplementation() {
        SootMethod smObtain4;
        SootMethod smObtain3;
        SootMethod smObtain2;
        SootClass sc = Scene.v().getSootClassUnsafe("android.os.Message");
        if (sc == null || sc.resolvingLevel() < 2) {
            return;
        }
        sc.setLibraryClass();
        SootMethod smMessageConstructor = Scene.v().grabMethod("<android.os.Message: void <init>()>");
        if (smMessageConstructor == null) {
            return;
        }
        SootField tmp = sc.getFieldUnsafe("int what");
        if (tmp == null) {
            tmp = Scene.v().makeSootField("what", (Type)IntType.v());
            sc.addField(tmp);
        }
        SootField fldWhat = tmp;
        tmp = sc.getFieldUnsafe("int arg1");
        if (tmp == null) {
            tmp = Scene.v().makeSootField("arg1", (Type)IntType.v());
            sc.addField(tmp);
        }
        SootField fldArg1 = tmp;
        tmp = sc.getFieldUnsafe("int arg2");
        if (tmp == null) {
            tmp = Scene.v().makeSootField("arg2", (Type)IntType.v());
            sc.addField(tmp);
        }
        SootField fldArg2 = tmp;
        tmp = sc.getFieldUnsafe("java.lang.Object obj");
        if (tmp == null) {
            tmp = Scene.v().makeSootField("obj", (Type)Scene.v().getObjectType());
            sc.addField(tmp);
        }
        SootField fldObj = tmp;
        SystemClassHandler systemClassHandler = SystemClassHandler.v();
        SootMethod smObtain1 = sc.getMethodUnsafe("android.os.Message obtain(android.os.Handler,int)");
        if (smObtain1 != null && (!smObtain1.hasActiveBody() || systemClassHandler.isStubImplementation(smObtain1.getActiveBody()))) {
            this.generateMessageObtainMethod(smObtain1, (IMessageObtainCodeInjector)new /* Unavailable Anonymous Inner Class!! */);
        }
        if ((smObtain2 = sc.getMethodUnsafe("android.os.Message obtain(android.os.Handler,int,int,int,java.lang.Object)")) != null && (!smObtain2.hasActiveBody() || systemClassHandler.isStubImplementation(smObtain2.getActiveBody()))) {
            this.generateMessageObtainMethod(smObtain2, (IMessageObtainCodeInjector)new /* Unavailable Anonymous Inner Class!! */);
        }
        if ((smObtain3 = sc.getMethodUnsafe("android.os.Message obtain(android.os.Handler,int,int,int)")) != null && (!smObtain3.hasActiveBody() || systemClassHandler.isStubImplementation(smObtain3.getActiveBody()))) {
            this.generateMessageObtainMethod(smObtain3, (IMessageObtainCodeInjector)new /* Unavailable Anonymous Inner Class!! */);
        }
        if ((smObtain4 = sc.getMethodUnsafe("android.os.Message obtain(android.os.Handler,int,java.lang.Object)")) != null && (!smObtain4.hasActiveBody() || systemClassHandler.isStubImplementation(smObtain4.getActiveBody()))) {
            this.generateMessageObtainMethod(smObtain4, (IMessageObtainCodeInjector)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private void generateMessageObtainMethod(SootMethod sm, IMessageObtainCodeInjector injector) {
        RefType tpMessage = RefType.v((String)"android.os.Message");
        sm.getDeclaringClass().setLibraryClass();
        sm.setPhantom(false);
        sm.addTag((Tag)new FlowDroidEssentialMethodTag());
        JimpleBody body = Jimple.v().newBody(sm);
        sm.setActiveBody((Body)body);
        body.insertIdentityStmts();
        SootMethod smMessageConstructor = Scene.v().grabMethod("<android.os.Message: void <init>()>");
        LocalGenerator lg = Scene.v().createLocalGenerator((Body)body);
        Local messageLocal = lg.generateLocal((Type)tpMessage);
        body.getUnits().add((Unit)Jimple.v().newAssignStmt((Value)messageLocal, (Value)Jimple.v().newNewExpr(tpMessage)));
        body.getUnits().add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newSpecialInvokeExpr(messageLocal, smMessageConstructor.makeRef())));
        if (injector != null) {
            injector.injectCode((Body)body, messageLocal);
        }
        body.getUnits().add((Unit)Jimple.v().newReturnStmt((Value)messageLocal));
    }

    private void patchActivityImplementation() {
        SootClass scApplicationHolder = LibraryClassPatcher.createOrGetApplicationHolder();
        SootClass sc = Scene.v().getSootClassUnsafe("android.app.Activity");
        if (sc == null || sc.resolvingLevel() < 2 || scApplicationHolder == null) {
            return;
        }
        sc.setLibraryClass();
        SootMethod smRun = sc.getMethodUnsafe("android.app.Application getApplication()");
        if (smRun == null || smRun.hasActiveBody() && !SystemClassHandler.v().isStubImplementation(smRun.getActiveBody())) {
            return;
        }
        smRun.setPhantom(false);
        smRun.addTag((Tag)new FlowDroidEssentialMethodTag());
        JimpleBody b = Jimple.v().newBody(smRun);
        smRun.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        SootFieldRef appStaticFieldRef = scApplicationHolder.getFieldByName("application").makeRef();
        Local targetLocal = Jimple.v().newLocal("retApplication", appStaticFieldRef.type());
        b.getLocals().add((Object)targetLocal);
        b.getUnits().add((Unit)Jimple.v().newAssignStmt((Value)targetLocal, (Value)Jimple.v().newStaticFieldRef(appStaticFieldRef)));
        ReturnStmt retStmt = Jimple.v().newReturnStmt((Value)targetLocal);
        b.getUnits().add((Unit)retStmt);
    }

    public static SootClass createOrGetApplicationHolder() {
        SootClass scApplicationHolder;
        SootClass scApplication = Scene.v().getSootClassUnsafe("android.app.Application");
        if (scApplication == null || scApplication.resolvingLevel() < 2) {
            return null;
        }
        String applicationHolderClassName = "il.ac.tau.MyApplicationHolder";
        if (!Scene.v().containsClass(applicationHolderClassName)) {
            scApplicationHolder = Scene.v().makeSootClass(applicationHolderClassName, 1);
            scApplicationHolder.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
            Scene.v().addClass(scApplicationHolder);
            scApplicationHolder.addField(Scene.v().makeSootField("application", (Type)scApplication.getType(), 9));
            scApplicationHolder.validate();
        } else {
            scApplicationHolder = Scene.v().getSootClassUnsafe(applicationHolderClassName);
        }
        return scApplicationHolder;
    }

    private void patchThreadImplementation() {
        SootClass sc = Scene.v().getSootClassUnsafe("java.lang.Thread");
        if (sc == null || sc.resolvingLevel() < 2) {
            return;
        }
        sc.setLibraryClass();
        SystemClassHandler systemClassHandler = SystemClassHandler.v();
        SootMethod smRun = sc.getMethodUnsafe("void run()");
        if (smRun == null || smRun.hasActiveBody() && !systemClassHandler.isStubImplementation(smRun.getActiveBody())) {
            return;
        }
        smRun.addTag((Tag)new FlowDroidEssentialMethodTag());
        SootMethod smStart = sc.getMethodUnsafe("void start()");
        if (smStart == null || smStart.hasActiveBody() && !systemClassHandler.isStubImplementation(smStart.getActiveBody())) {
            return;
        }
        smStart.addTag((Tag)new FlowDroidEssentialMethodTag());
        SootMethod smCons = sc.getMethodUnsafe("void <init>(java.lang.Runnable)");
        if (smCons == null || smCons.hasActiveBody() && !systemClassHandler.isStubImplementation(smCons.getActiveBody())) {
            return;
        }
        smCons.addTag((Tag)new FlowDroidEssentialMethodTag());
        SootClass runnable = Scene.v().getSootClassUnsafe("java.lang.Runnable");
        if (runnable == null || runnable.resolvingLevel() < 2) {
            return;
        }
        int fieldIdx = 0;
        SootField fldTarget = null;
        while ((fldTarget = sc.getFieldByNameUnsafe("target" + fieldIdx)) != null) {
            ++fieldIdx;
        }
        fldTarget = Scene.v().makeSootField("target" + fieldIdx, (Type)runnable.getType());
        sc.addField(fldTarget);
        this.patchThreadConstructor(smCons, runnable, fldTarget);
        this.patchThreadRunMethod(smRun, runnable, fldTarget);
        this.patchThreadRunMethod(smStart, runnable, fldTarget);
    }

    private void patchThreadRunMethod(SootMethod smRun, SootClass runnable, SootField fldTarget) {
        SootClass sc = smRun.getDeclaringClass();
        sc.setLibraryClass();
        smRun.setPhantom(false);
        JimpleBody b = Jimple.v().newBody(smRun);
        smRun.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        Local targetLocal = Jimple.v().newLocal("target", (Type)runnable.getType());
        b.getLocals().add((Object)targetLocal);
        b.getUnits().add((Unit)Jimple.v().newAssignStmt((Value)targetLocal, (Value)Jimple.v().newInstanceFieldRef((Value)thisLocal, fldTarget.makeRef())));
        ReturnVoidStmt retStmt = Jimple.v().newReturnVoidStmt();
        b.getUnits().add((Unit)Jimple.v().newIfStmt((Value)Jimple.v().newEqExpr((Value)targetLocal, (Value)NullConstant.v()), (Unit)retStmt));
        b.getUnits().add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newInterfaceInvokeExpr(targetLocal, runnable.getMethod("void run()").makeRef())));
        b.getUnits().add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newInterfaceInvokeExpr(thisLocal, runnable.getMethod("void run()").makeRef())));
        b.getUnits().add((Unit)retStmt);
    }

    private void patchThreadConstructor(SootMethod smCons, SootClass runnable, SootField fldTarget) {
        SootClass sc = smCons.getDeclaringClass();
        sc.setLibraryClass();
        smCons.setPhantom(false);
        JimpleBody b = Jimple.v().newBody(smCons);
        smCons.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        Local param0Local = Jimple.v().newLocal("p0", (Type)runnable.getType());
        b.getLocals().add((Object)param0Local);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)param0Local, (Value)Jimple.v().newParameterRef((Type)runnable.getType(), 0)));
        b.getUnits().add((Unit)Jimple.v().newAssignStmt((Value)Jimple.v().newInstanceFieldRef((Value)thisLocal, fldTarget.makeRef()), (Value)param0Local));
        b.getUnits().add((Unit)Jimple.v().newReturnVoidStmt());
    }

    private void patchHandlerImplementation() {
        SootClass sc = Scene.v().getSootClassUnsafe("android.os.Handler");
        if (sc == null || sc.resolvingLevel() < 2) {
            return;
        }
        sc.setLibraryClass();
        SootClass runnable = Scene.v().getSootClassUnsafe("java.lang.Runnable");
        if (runnable == null || runnable.resolvingLevel() < 2) {
            return;
        }
        SootMethod smPost = sc.getMethodUnsafe("boolean post(java.lang.Runnable)");
        SootMethod smPostAtFrontOfQueue = sc.getMethodUnsafe("boolean postAtFrontOfQueue(java.lang.Runnable)");
        SootMethod smPostAtTimeWithToken = sc.getMethodUnsafe("boolean postAtTime(java.lang.Runnable,java.lang.Object,long)");
        SootMethod smPostAtTime = sc.getMethodUnsafe("boolean postAtTime(java.lang.Runnable,long)");
        SootMethod smPostDelayed = sc.getMethodUnsafe("boolean postDelayed(java.lang.Runnable,long)");
        SootMethod smDispatchMessage = sc.getMethodUnsafe("void dispatchMessage(android.os.Message)");
        SystemClassHandler systemClassHandler = SystemClassHandler.v();
        if (smPost != null && (!smPost.hasActiveBody() || systemClassHandler.isStubImplementation(smPost.getActiveBody()))) {
            this.patchHandlerPostBody(smPost, runnable);
            smPost.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if (smPostAtFrontOfQueue != null && (!smPostAtFrontOfQueue.hasActiveBody() || systemClassHandler.isStubImplementation(smPostAtFrontOfQueue.getActiveBody()))) {
            this.patchHandlerPostBody(smPostAtFrontOfQueue, runnable);
            smPostAtFrontOfQueue.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if (smPostAtTime != null && (!smPostAtTime.hasActiveBody() || systemClassHandler.isStubImplementation(smPostAtTime.getActiveBody()))) {
            this.patchHandlerPostBody(smPostAtTime, runnable);
            smPostAtTime.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if (smPostAtTimeWithToken != null && (!smPostAtTimeWithToken.hasActiveBody() || systemClassHandler.isStubImplementation(smPostAtTimeWithToken.getActiveBody()))) {
            this.patchHandlerPostBody(smPostAtTimeWithToken, runnable);
            smPostAtTimeWithToken.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if (smPostDelayed != null && (!smPostDelayed.hasActiveBody() || systemClassHandler.isStubImplementation(smPostDelayed.getActiveBody()))) {
            this.patchHandlerPostBody(smPostDelayed, runnable);
            smPostDelayed.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if (smDispatchMessage != null && (!smDispatchMessage.hasActiveBody() || systemClassHandler.isStubImplementation(smDispatchMessage.getActiveBody()))) {
            this.patchHandlerDispatchBody(smDispatchMessage);
            smDispatchMessage.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
    }

    private Body patchHandlerDispatchBody(SootMethod method) {
        SootClass sc = method.getDeclaringClass();
        sc.setLibraryClass();
        method.setPhantom(false);
        JimpleBody b = Jimple.v().newBody(method);
        method.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        Local firstParam = null;
        for (int i = 0; i < method.getParameterCount(); ++i) {
            Local paramLocal = Jimple.v().newLocal("param" + i, method.getParameterType(i));
            b.getLocals().add((Object)paramLocal);
            b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)paramLocal, (Value)Jimple.v().newParameterRef(method.getParameterType(i), i)));
            if (i != 0) continue;
            firstParam = paramLocal;
        }
        b.getUnits().add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newVirtualInvokeExpr(thisLocal, Scene.v().makeMethodRef(sc, "handleMessage", Collections.singletonList(method.getParameterType(0)), (Type)VoidType.v(), false), firstParam)));
        ReturnVoidStmt retStmt = Jimple.v().newReturnVoidStmt();
        b.getUnits().add((Unit)retStmt);
        return b;
    }

    private Body patchHandlerPostBody(SootMethod method, SootClass runnable) {
        SootClass sc = method.getDeclaringClass();
        sc.setLibraryClass();
        method.setPhantom(false);
        JimpleBody b = Jimple.v().newBody(method);
        method.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        Local firstParam = null;
        for (int i = 0; i < method.getParameterCount(); ++i) {
            Local paramLocal = Jimple.v().newLocal("param" + i, method.getParameterType(i));
            b.getLocals().add((Object)paramLocal);
            b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)paramLocal, (Value)Jimple.v().newParameterRef(method.getParameterType(i), i)));
            if (i != 0) continue;
            firstParam = paramLocal;
        }
        b.getUnits().add((Unit)Jimple.v().newInvokeStmt((Value)Jimple.v().newInterfaceInvokeExpr(firstParam, Scene.v().makeMethodRef(runnable, "run", Collections.emptyList(), (Type)VoidType.v(), false))));
        ReturnStmt retStmt = Jimple.v().newReturnStmt((Value)IntConstant.v((int)1));
        b.getUnits().add((Unit)retStmt);
        return b;
    }

    private void patchTimerImplementation() {
        SootMethod smSchedule6;
        SootMethod smSchedule5;
        SootMethod smSchedule4;
        SootMethod smSchedule3;
        SootMethod smSchedule2;
        SootClass sc = Scene.v().getSootClassUnsafe("java.util.Timer");
        if (sc == null || sc.resolvingLevel() < 2) {
            return;
        }
        sc.setLibraryClass();
        SootMethod smSchedule1 = sc.getMethodUnsafe("void schedule(java.util.TimerTask,long)");
        if (smSchedule1 != null && !smSchedule1.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule1);
            smSchedule1.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if ((smSchedule2 = sc.getMethodUnsafe("void schedule(java.util.TimerTask,java.util.Date)")) != null && !smSchedule2.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule2);
            smSchedule2.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if ((smSchedule3 = sc.getMethodUnsafe("void schedule(java.util.TimerTask,java.util.Date,long)")) != null && !smSchedule3.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule3);
            smSchedule3.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if ((smSchedule4 = sc.getMethodUnsafe("void schedule(java.util.TimerTask,long,long)")) != null && !smSchedule4.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule4);
            smSchedule4.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if ((smSchedule5 = sc.getMethodUnsafe("void scheduleAtFixedRate(java.util.TimerTask,java.util.Date,long)")) != null && !smSchedule5.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule5);
            smSchedule5.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
        if ((smSchedule6 = sc.getMethodUnsafe("void scheduleAtFixedRate(java.util.TimerTask,long,long)")) != null && !smSchedule6.hasActiveBody()) {
            this.patchTimerScheduleMethod(smSchedule6);
            smSchedule6.addTag((Tag)new FlowDroidEssentialMethodTag());
        }
    }

    private void patchTimerScheduleMethod(SootMethod method) {
        SootClass sc = method.getDeclaringClass();
        sc.setLibraryClass();
        method.setPhantom(false);
        JimpleBody b = Jimple.v().newBody(method);
        method.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        Local firstParam = null;
        for (int i = 0; i < method.getParameterCount(); ++i) {
            Local paramLocal = Jimple.v().newLocal("param" + i, method.getParameterType(i));
            b.getLocals().add((Object)paramLocal);
            b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)paramLocal, (Value)Jimple.v().newParameterRef(method.getParameterType(i), i)));
            if (i != 0) continue;
            firstParam = paramLocal;
        }
        SootMethod runMethod = Scene.v().grabMethod("<java.util.TimerTask: void run()>");
        if (runMethod != null) {
            InvokeStmt invokeStmt = Jimple.v().newInvokeStmt((Value)Jimple.v().newVirtualInvokeExpr(firstParam, runMethod.makeRef()));
            b.getUnits().add((Unit)invokeStmt);
        }
        b.getUnits().add((Unit)Jimple.v().newReturnVoidStmt());
    }

    private void patchActivityGetFragmentManager() {
        SootClass sc = Scene.v().getSootClassUnsafe("android.app.Activity");
        if (sc == null || sc.resolvingLevel() < 2) {
            return;
        }
        sc.setLibraryClass();
        SootMethod smGetFM = sc.getMethodUnsafe("android.app.FragmentManager getFragmentManager()");
        if (smGetFM == null || smGetFM.hasActiveBody()) {
            return;
        }
        JimpleBody b = Jimple.v().newBody(smGetFM);
        smGetFM.setActiveBody((Body)b);
        Local thisLocal = Jimple.v().newLocal("this", (Type)sc.getType());
        b.getLocals().add((Object)thisLocal);
        b.getUnits().add((Unit)Jimple.v().newIdentityStmt((Value)thisLocal, (Value)Jimple.v().newThisRef(sc.getType())));
        SootClass scFragmentTransaction = Scene.v().forceResolve("android.app.FragmentManager", 2);
        Local retLocal = Jimple.v().newLocal("retFragMan", (Type)Scene.v().getSootClassUnsafe("android.app.FragmentManager").getType());
        b.getLocals().add((Object)retLocal);
        b.getUnits().add((Unit)Jimple.v().newAssignStmt((Value)retLocal, (Value)Jimple.v().newNewExpr(scFragmentTransaction.getType())));
        b.getUnits().add((Unit)Jimple.v().newReturnStmt((Value)retLocal));
    }
}

