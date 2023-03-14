package dev.caio.study.stax.demo.domain.validation;

import java.io.Closeable;
import java.io.File;

public interface Validator extends Closeable {
    boolean validate(File file);
}
