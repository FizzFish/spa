/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bean.ConstructorArgBean
 *  mock.GenerateSyntheticClass
 *  soot.SootClass
 */
package mock;

import bean.ConstructorArgBean;
import java.util.List;
import java.util.Map;
import java.util.Set;
import soot.SootClass;

public interface GenerateSyntheticClass {
    public SootClass generateJoinPointImpl(SootClass var1);

    public SootClass generateMapperImpl(SootClass var1);

    public SootClass generateProxy(SootClass var1);

    public void generateSingletonBeanFactory(Set<SootClass> var1, Map<String, List<ConstructorArgBean>> var2);

    public SootClass generateHttpServlet(SootClass var1);
}

