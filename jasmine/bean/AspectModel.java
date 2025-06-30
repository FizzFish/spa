/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bean.AspectModel
 *  enums.AdviceEnum
 *  soot.SootClass
 *  soot.SootMethod
 */
package bean;

import enums.AdviceEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import soot.SootClass;
import soot.SootMethod;

public class AspectModel
implements Comparable<AspectModel> {
    private SootClass sootClass;
    private int order;
    private List<String> pointcutExpressions = new ArrayList();
    private SootMethod sootMethod;
    private AdviceEnum annotation;

    public AspectModel(SootClass sootClass, int order) {
        this.sootClass = sootClass;
        this.order = order;
    }

    public AspectModel(SootClass sootClass, int order, SootMethod sootMethod) {
        this.sootClass = sootClass;
        this.order = order;
        this.sootMethod = sootMethod;
    }

    public AspectModel() {
    }

    public SootClass getSootClass() {
        return this.sootClass;
    }

    public void setSootClass(SootClass sootClass) {
        this.sootClass = sootClass;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setPointcutExpressions(List<String> pointcutExpressions) {
        this.pointcutExpressions = pointcutExpressions;
    }

    public void addPointcutExpressions(String pointcutExpression) {
        this.pointcutExpressions.add(pointcutExpression);
    }

    public List<String> getPointcutExpressions() {
        return this.pointcutExpressions;
    }

    public SootMethod getSootMethod() {
        return this.sootMethod;
    }

    public void setSootMethod(SootMethod sootMethod) {
        this.sootMethod = sootMethod;
    }

    public AdviceEnum getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(AdviceEnum annotation) {
        this.annotation = annotation;
    }

    @Override
    public int compareTo(AspectModel o) {
        if (o.order - this.order > 0) {
            return -1;
        }
        if (o.order - this.order < 0) {
            return 1;
        }
        if (this.getSootClass().getName().compareTo(o.getSootClass().getName()) > 0) {
            return 1;
        }
        if (this.getSootClass().getName().compareTo(o.getSootClass().getName()) < 0) {
            return -1;
        }
        return this.getAnnotation().ordinal() - o.getAnnotation().ordinal();
    }

    public String toString() {
        return "AspectModel{sootClass=" + this.sootClass + ", order=" + this.order + ", pointcutExpression='" + this.pointcutExpressions + '\'' + ", sootMethod=" + this.sootMethod + ", annotation='" + this.annotation + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        AspectModel that = (AspectModel)o;
        return this.order == that.order && Objects.equals(this.sootClass, that.sootClass) && Objects.equals(this.pointcutExpressions, that.pointcutExpressions) && Objects.equals(this.sootMethod, that.sootMethod) && this.annotation == that.annotation;
    }

    public int hashCode() {
        return Objects.hash(this.sootClass, this.order, this.pointcutExpressions, this.sootMethod, this.annotation);
    }
}

