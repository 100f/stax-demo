package dev.caio.study.stax.reader.domain.listeners.impl;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.XMLElement;
import dev.caio.study.stax.reader.domain.XMLFieldElement;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class XMLUnmarshallingReaderListener implements XMLReaderListener {
    private final Deque<XMLElement> readElementsStack;
    private final XMLMetadataProvider xmlMetadataProvider;

    /**
     * Ouvinte de leitura que deve gerar instâncias de classes que representam nós XML. Para tal, utiliza um provedor de metadados dedicado como dependência.
     * @param xmlMetadataProvider {@link XMLMetadataProvider} Provedor de metadados das classes destino que representam nós XML.
     */
    public XMLUnmarshallingReaderListener(final XMLMetadataProvider xmlMetadataProvider) {
        this.xmlMetadataProvider = xmlMetadataProvider;
        this.readElementsStack = new LinkedBlockingDeque<>();
    }

    @Override
    public void onReadStart() {
    }

    @Override
    public void onReadFinish() {
        readElementsStack.clear();
    }

    @Override
    public void onXmlElementReadStart(String startTagName, ElementPosition position) {
        XMLElement newCurrentReadElement = createChildElementFromLatestReadElement(startTagName, position);
        this.readElementsStack.add(newCurrentReadElement);
    }

    private XMLElement createChildElementFromLatestReadElement(String tagName, ElementPosition position) {
        XMLElement latestReadElement = retrieveLatestReadElement();
        return latestReadElement.createChildElement(tagName, position);
    }

    @Override
    public void onXmlElementReadFinish(String endTagName, ElementPosition position) {
        final XMLElement latest = retrieveLatestReadElement();
        //O handler deverá estar aqui.
    }

    @Override
    public void characters(String content, ElementPosition position) {
        //TODO: na teoria, se válido, sempre o último elemento da pilha para esse evento tem de ser do tipo campo, por isso o cast.
        // Verificar possibilidade de lançar algum erro específico, caso não seja.
        XMLFieldElement latestFieldRead = (XMLFieldElement) retrieveLatestReadElement();
        latestFieldRead.setFieldContent(content);
    }

    private XMLElement retrieveLatestReadElement() {
        return readElementsStack.peekFirst();
    }
}
