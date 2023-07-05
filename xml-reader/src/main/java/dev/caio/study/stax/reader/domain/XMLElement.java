package dev.caio.study.stax.reader.domain;

public abstract class XMLElement {
    private XMLElement parentElement;
    private ElementPosition position;
    private String tagName;
    public abstract XMLElement createChildElement(String tagName, ElementPosition position);

    public XMLElement(XMLElement parentElement, ElementPosition position, String tagName) {
        this.parentElement = parentElement;
        this.position = position;
        this.tagName = tagName;
    }

    public ElementPosition getPosition() { return position; }

    public XMLElement getParentElement() { return parentElement; }

    public String getTagName() { return tagName; }

}
