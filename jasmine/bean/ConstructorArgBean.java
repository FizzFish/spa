/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bean.ConstructorArgBean
 */
package bean;

public class ConstructorArgBean {
    private String xml;
    private String argName;
    private Integer argIndex;
    private String argType;
    private String refType;
    private String argValue;
    private String clazzName;

    public String toString() {
        return "ConstructorArgBean{argName='" + this.argName + '\'' + ", argIndex=" + this.argIndex + ", argType='" + this.argType + '\'' + ", refType='" + this.refType + '\'' + ", argValue='" + this.argValue + '\'' + ", clazzName='" + this.clazzName + '\'' + '}';
    }

    public String getArgName() {
        return this.argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public Integer getArgIndex() {
        return this.argIndex;
    }

    public void setArgIndex(Integer argIndex) {
        this.argIndex = argIndex;
    }

    public String getArgType() {
        return this.argType;
    }

    public void setArgType(String argType) {
        this.argType = argType;
    }

    public String getRefType() {
        return this.refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getArgValue() {
        return this.argValue;
    }

    public void setArgValue(String argValue) {
        this.argValue = argValue;
    }

    public String getClazzName() {
        return this.clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getXml() {
        return this.xml;
    }
}

