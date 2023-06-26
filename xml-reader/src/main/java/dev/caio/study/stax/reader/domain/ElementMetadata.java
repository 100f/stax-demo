package dev.caio.study.stax.reader.domain;

public interface ElementMetadata {
    LineColumn getPosition();
    Object getValue();
}
