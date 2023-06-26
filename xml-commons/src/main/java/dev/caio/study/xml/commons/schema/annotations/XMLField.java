package dev.caio.study.xml.commons.schema.annotations;

import dev.caio.study.xml.commons.schema.enums.FieldFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface XMLField {
    public String name();
    public FieldFormat fieldFormat() default FieldFormat.UNDEFINED;
}
