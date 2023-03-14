package dev.caio.study.stax.demo.domain.validation;

public abstract class ValidatorError {
    private String message;
    private LineColumn position;
    private ValidatorErrorType type;
}
