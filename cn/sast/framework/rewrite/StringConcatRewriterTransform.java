/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 */
package cn.sast.framework.rewrite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Body;
import soot.BodyTransformer;
import soot.options.Options;

import java.util.Map;

public class StringConcatRewriterTransform extends BodyTransformer {
    public static final String PHASE = "jb.rewriter";
    private static final Logger logger = LoggerFactory.getLogger(StringConcatRewriterTransform.class);

    @Override
    protected void internalTransform(Body body, String phaseName, Map<String, String> options) {
        if (Options.v().verbose()) {
            logger.debug("[{}] Rewrite string concat...", body.getMethod().getName());
        }
        new StringConcatRewriterPlugin().transformStringConcats(body);
    }
}