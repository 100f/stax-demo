package dev.caio.study.stax.demo.domain.validation;

public class XMLValidatorFactory implements ValidatorFactory {
    @Override
    public AbstractValidator build() {
        return new XMLValidator(null);
    }
}
