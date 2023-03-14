package dev.caio.study.stax.demo.domain.validation;

import jakarta.xml.bind.annotation.XmlAccessorType;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class XMLValidator extends AbstractValidator {
    public XMLValidator(ValidatorErrorListener errorListener) {
        super.errorListener = errorListener;
    }


    @Override
    public boolean validate(File file) {
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
