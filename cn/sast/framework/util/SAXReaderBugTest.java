/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.util.SAXReaderBugTest
 *  kotlin.Metadata
 *  kotlin.text.StringsKt
 *  org.dom4j.Document
 *  org.dom4j.io.SAXReader
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.util;

import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lcn/sast/framework/util/SAXReaderBugTest;", "", "<init>", "()V", "test", "", "corax-framework"})
public final class SAXReaderBugTest {
    @NotNull
    public static final SAXReaderBugTest INSTANCE = new SAXReaderBugTest();

    private SAXReaderBugTest() {
    }

    public final void test() {
        SAXReader reader = new SAXReader();
        Document doc = reader.read((Reader)new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<MessageCollection xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n  xsi:noNamespaceSchemaLocation=\"messagecollection.xsd\">\n  <Plugin>\n  <![CDATA[\n" + StringsKt.repeat((CharSequence)"1", (int)1124) + "\n]]>\n  </Plugin>\n</MessageCollection>"));
    }
}

