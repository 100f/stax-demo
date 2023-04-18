package dev.caio.study.stax.demo.core.validation;

import java.io.Closeable;
import java.io.File;

public interface Validator extends Closeable {
    boolean validate(File file);
}
