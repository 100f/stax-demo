package dev.caio.study.xml.commons.schema.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
public @interface XMLBlock {
    public String blockName();
}
