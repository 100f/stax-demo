package dev.caio.study.stax.validator.core.validation;

import dev.caio.study.stax.reader.domain.ElementPosition;

public abstract class ValidatorError {
    private String message;
    private ElementPosition position;
    private ValidatorErrorType type;
}
