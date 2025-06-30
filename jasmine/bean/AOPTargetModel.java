/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bean.AOPTargetModel
 *  bean.AspectModel
 *  soot.SootClass
 *  soot.SootMethod
 */
package bean;

import bean.AspectModel;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import soot.SootClass;
import soot.SootMethod;

public class AOPTargetModel {
    private String className;
    private String methodName;
    private String proxyClassName;
    private String proxyMethodName;
    private SootClass sootClass;
    private SootMethod sootMethod;
    private SootClass proxyClass;
    private SootMethod proxyMethod;
    private List<AspectModel> advices = new ArrayList();
    private Set<SootMethod> pointcuts = new LinkedHashSet();

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public SootClass getSootClass() {
        return this.sootClass;
    }

    public void setSootClass(SootClass sootClass) {
        this.sootClass = sootClass;
    }

    public SootMethod getSootMethod() {
        return this.sootMethod;
    }

    public void setSootMethod(SootMethod sootMethod) {
        this.sootMethod = sootMethod;
    }

    public List<AspectModel> getAdvices() {
        return this.advices;
    }

    public void setAdvices(List<AspectModel> advices) {
        this.advices = advices;
    }

    public void addAdvice(AspectModel method) {
        this.advices.add(method);
    }

    public Set<SootMethod> getPointcuts() {
        return this.pointcuts;
    }

    public void setPointcuts(Set<SootMethod> pointcuts) {
        this.pointcuts = pointcuts;
    }

    public void addPoint(SootMethod method) {
        this.pointcuts.add(method);
    }

    public SootClass getProxyClass() {
        return this.proxyClass;
    }

    public void setProxyClass(SootClass proxyClass) {
        this.proxyClass = proxyClass;
    }

    public SootMethod getProxyMethod() {
        return this.proxyMethod;
    }

    public void setProxyMethod(SootMethod proxyMethod) {
        this.proxyMethod = proxyMethod;
    }

    public String getProxyClassName() {
        return this.proxyClassName;
    }

    public void setProxyClassName(String proxyClassName) {
        this.proxyClassName = proxyClassName;
    }

    public String getProxyMethodName() {
        return this.proxyMethodName;
    }

    public void setProxyMethodName(String proxyMethodName) {
        this.proxyMethodName = proxyMethodName;
    }

    public String toString() {
        return "AOPTargetModel{className='" + this.className + '\'' + ", methodName='" + this.methodName + '\'' + ", proxyClassName='" + this.proxyClassName + '\'' + ", proxyMethodName='" + this.proxyMethodName + '\'' + ", sootClass=" + this.sootClass + ", sootMethod=" + this.sootMethod + ", proxyClass=" + this.proxyClass + ", proxyMethod=" + this.proxyMethod + ", advices=" + this.advices + ", pointcuts=" + this.pointcuts + '}';
    }
}

