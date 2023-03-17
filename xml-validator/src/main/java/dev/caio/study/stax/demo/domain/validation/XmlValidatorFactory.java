package dev.caio.study.stax.demo.domain.validation;

public class XmlValidatorFactory implements ValidatorFactory {
    @Override
    public AbstractValidator build() {
        return new XmlValidator(null);
    }
}
