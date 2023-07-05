package dev.caio.study.stax.reader.domain;

import dev.caio.study.stax.reader.domain.factories.XMLBlockElementFactory;

public class XMLBlockElement extends XMLElement {
    private XMLBlockElementFactory elementFactory;
    public XMLBlockElement(XMLElement parentElement, ElementPosition position, String tagName) {
        super(parentElement, position, tagName);
        this.elementFactory = new XMLBlockElementFactory();
    }

    @Override
    public XMLElement createChildElement(String tagName, ElementPosition position) {
        return elementFactory.createElement(this, position, tagName);
    }
}
