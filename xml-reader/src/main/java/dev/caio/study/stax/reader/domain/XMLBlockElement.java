package dev.caio.study.stax.reader.domain;

public class XMLBlockElement extends XMLElement {
    @Override
    public boolean isField() {
        return false;
    }

    @Override
    public boolean isBlock() {
        return true;
    }
}
