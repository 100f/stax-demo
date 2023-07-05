package dev.caio.study.stax.reader.domain.factories;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.XMLElement;

public interface XMLElementFactory {
    public XMLElement createElement(XMLElement parentElement, ElementPosition position, String tagName);
}
