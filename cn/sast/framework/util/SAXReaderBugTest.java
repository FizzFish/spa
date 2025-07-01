package cn.sast.framework.util;

import java.io.Reader;
import java.io.StringReader;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.jetbrains.annotations.NotNull;

public final class SAXReaderBugTest {
    @NotNull
    public static final SAXReaderBugTest INSTANCE = new SAXReaderBugTest();

    private SAXReaderBugTest() {
    }

    public void test() {
        SAXReader reader = new SAXReader();
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<MessageCollection xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "  xsi:noNamespaceSchemaLocation=\"messagecollection.xsd\">\n" +
            "  <Plugin>\n" +
            "  <![CDATA[\n" +
            "1".repeat(1124) + "\n]]>\n" +
            "  </Plugin>\n" +
            "</MessageCollection>";
        Document doc = reader.read(new StringReader(xmlContent));
    }
}