/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.SafeDomParserFactory
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lcn/sast/common/SafeDomParserFactory;", "", "<init>", "()V", "createDocumentBuilder", "Ljavax/xml/parsers/DocumentBuilder;", "namespaceAware", "", "corax-api"})
public final class SafeDomParserFactory {
    @NotNull
    public static final SafeDomParserFactory INSTANCE = new SafeDomParserFactory();

    private SafeDomParserFactory() {
    }

    @NotNull
    public final DocumentBuilder createDocumentBuilder(boolean namespaceAware) {
        try {
            DocumentBuilderFactory documentBuilderFactory = (DocumentBuilderFactory)new DocumentBuilderFactoryImpl();
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
            Intrinsics.checkNotNull((Object)documentBuilder);
            return documentBuilder;
        }
        catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }
}

