/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bean.AopXMLResultBean
 */
package bean;

public class AopXMLResultBean {
    private String aopclass;
    private String aopmethod;
    private String activetype;
    private String exper;
    private int order;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public AopXMLResultBean() {
    }

    public AopXMLResultBean(String aopclass, String aopmethod, String activetype, String exper, int order) {
        this.aopclass = aopclass;
        this.aopmethod = aopmethod;
        this.activetype = activetype;
        this.exper = exper;
        this.order = order;
    }

    public String toString() {
        return "AopXMLResultBean{aopclass='" + this.aopclass + '\'' + ", aopmethod='" + this.aopmethod + '\'' + ", activetype='" + this.activetype + '\'' + ", exper='" + this.exper + '\'' + ", order=" + this.order + '}';
    }

    public String getAopclass() {
        return this.aopclass;
    }

    public void setAopclass(String aopclass) {
        this.aopclass = aopclass;
    }

    public String getAopmethod() {
        return this.aopmethod;
    }

    public void setAopmethod(String aopmethod) {
        this.aopmethod = aopmethod;
    }

    public String getActivetype() {
        return this.activetype;
    }

    public void setActivetype(String activetype) {
        this.activetype = activetype;
    }

    public String getExper() {
        return this.exper;
    }

    public void setExper(String exper) {
        this.exper = exper;
    }
}

