package cn.sast.common;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.jetbrains.annotations.NotNull;

public final class SafeDomParserFactory {
    public static final SafeDomParserFactory INSTANCE = new SafeDomParserFactory();

    private SafeDomParserFactory() {
    }

    @NotNull
    public DocumentBuilder createDocumentBuilder(boolean namespaceAware) {
        try {
            DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactoryImpl();
            documentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            documentBuilderFactory.setFeature("http://apache.org/xml/features/dom/create-entity-ref-nodes", false);
            documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setExpandEntityReferences(false);
            documentBuilderFactory.setNamespaceAware(namespaceAware);
            documentBuilderFactory.setXIncludeAware(false);
            
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setErrorHandler(null);
            return documentBuilder;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }
}