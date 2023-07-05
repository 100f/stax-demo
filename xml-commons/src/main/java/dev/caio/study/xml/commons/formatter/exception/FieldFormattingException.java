package dev.caio.study.xml.commons.formatter.exception;

public class FieldFormattingException extends Exception {
    public FieldFormattingException() {
        super();
    }

    public FieldFormattingException(String message) {
        super(message);
    }

    public FieldFormattingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldFormattingException(Throwable cause) {
        super(cause);
    }

    protected FieldFormattingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
