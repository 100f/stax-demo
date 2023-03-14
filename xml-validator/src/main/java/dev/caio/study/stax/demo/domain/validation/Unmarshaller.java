package dev.caio.study.stax.demo.domain.validation;

import dev.caio.study.stax.demo.domain.exception.UnmarshallingException;

import java.io.File;

public interface Unmarshaller {
    <T> T unmarshal(String content, Class<T> clazz) throws UnmarshallingException;

    <T> T unmarshal(File file, Class<T> clazz) throws UnmarshallingException;

}
