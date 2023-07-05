package dev.caio.study.stax.reader.domain.factories;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.XMLElement;
import dev.caio.study.stax.reader.domain.XMLFieldElement;

public class XMLFieldElementFactory implements XMLElementFactory {
    @Override
    public XMLElement createElement(XMLElement parentElement, ElementPosition position, String tagName) {
        return new XMLFieldElement(parentElement, position, tagName);
    }
}
