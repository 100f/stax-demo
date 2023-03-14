package dev.caio.study.stax.demo.domain.exception;

public class UnmarshallingException extends RuntimeException {
    public UnmarshallingException(String message) {
        super(message);
    }

    public UnmarshallingException(Throwable cause) {
        super(cause);
    }

    public UnmarshallingException(String message, Throwable cause) {
        super(message, cause);
    }

}
