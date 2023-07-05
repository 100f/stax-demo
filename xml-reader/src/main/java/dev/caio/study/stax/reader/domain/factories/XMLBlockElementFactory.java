package dev.caio.study.stax.reader.domain.factories;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.XMLBlockElement;
import dev.caio.study.stax.reader.domain.XMLElement;

public class XMLBlockElementFactory implements XMLElementFactory {
    @Override
    public XMLElement createElement(XMLElement parentElement, ElementPosition position, String tagName) {
        return new XMLBlockElement(parentElement, position, tagName);
    }
}
