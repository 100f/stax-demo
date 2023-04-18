package dev.caio.study.stax.demo.core.validation;

import java.io.File;
import java.io.IOException;

public class XmlValidator extends AbstractValidator {
    public XmlValidator(ValidatorErrorListener errorListener) {
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
