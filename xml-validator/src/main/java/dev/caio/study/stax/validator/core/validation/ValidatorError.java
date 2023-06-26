package dev.caio.study.stax.validator.core.validation;

import dev.caio.study.stax.reader.domain.LineColumn;

public abstract class ValidatorError {
    private String message;
    private LineColumn position;
    private ValidatorErrorType type;
}
