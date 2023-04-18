package dev.caio.study.stax.demo.core.validation;

import dev.caio.study.stax.demo.core.LineColumn;

public abstract class ValidatorError {
    private String message;
    private LineColumn position;
    private ValidatorErrorType type;
}
