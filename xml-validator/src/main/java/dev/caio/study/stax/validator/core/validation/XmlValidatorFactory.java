package dev.caio.study.stax.validator.core.validation;

public class XmlValidatorFactory implements ValidatorFactory {
    @Override
    public AbstractValidator build() {
        return new XmlValidator(null);
    }
}
