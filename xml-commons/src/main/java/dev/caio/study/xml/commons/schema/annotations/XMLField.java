package dev.caio.study.xml.commons.schema.annotations;

import dev.caio.study.xml.commons.schema.enums.FieldFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface XMLField {
    /**
     * Atributo obrigatório que define o nome exato do campo dentro do arquivo XML que o atributo representará.
     * @return {@link String} nome do campo XML correspondente.
     */
    public String name();

    /**
     * Formato que o campo possui no XML, para formatações durante a leitura.
     * @return {@link FieldFormat} enumerável do formato que o campo deverá possuir.
     */
    public FieldFormat format() default FieldFormat.UNDEFINED;
}
