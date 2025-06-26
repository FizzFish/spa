/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mock.MockObject
 *  soot.Local
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.jimple.JimpleBody
 *  utils.BaseBodyGenerator
 */
package mock;

import soot.Local;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.JimpleBody;
import utils.BaseBodyGenerator;

public interface MockObject {
    public void mockJoinPoint(JimpleBody var1, BaseBodyGenerator var2);

    public Local mockBean(JimpleBody var1, BaseBodyGenerator var2, SootClass var3, SootMethod var4);

    public Local mockHttpServlet(JimpleBody var1, BaseBodyGenerator var2, SootClass var3, SootMethod var4);
}

