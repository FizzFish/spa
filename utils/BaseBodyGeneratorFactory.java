/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  soot.Body
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 */
package utils;

import soot.Body;
import utils.BaseBodyGenerator;

public abstract class BaseBodyGeneratorFactory {
    public static BaseBodyGeneratorFactory instance = new /* Unavailable Anonymous Inner Class!! */;

    public abstract BaseBodyGenerator create(Body var1);

    public static BaseBodyGenerator get(Body body) {
        return instance.create(body);
    }
}

