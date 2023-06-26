package dev.caio.study.xml.commons.schema.enums;

import dev.caio.study.xml.commons.schema.formatter.FieldFormatter;
import dev.caio.study.xml.commons.schema.formatter.NumericFieldFormatter;
import dev.caio.study.xml.commons.schema.formatter.TextFieldFormatter;

public enum FieldFormat {
    AN(TextFieldFormatter.class),
    ANS(TextFieldFormatter.class),
    NUMBER(NumericFieldFormatter.class),
    FLOATING_POINT(NumericFieldFormatter.class),
    UNDEFINED(TextFieldFormatter.class); //Valor indefinido, utilizado por hora apenas para servir como valor padrão

    private final Class<? extends FieldFormatter<?>> fieldFormatterClass;
    FieldFormat(final Class<? extends FieldFormatter<?>> fieldFormatterClass) {
        this.fieldFormatterClass = fieldFormatterClass;
    }

    public FieldFormatter<?> getFormatter() {
        try {
            return this.fieldFormatterClass.getDeclaredConstructor().newInstance();
        }
        catch (InstantiationException ie) {
            throw new RuntimeException("O formatador de campo " + this.fieldFormatterClass.getName() + " deve ser concreto.");
        }
        catch (Exception e) {
            throw new RuntimeException("Um erro foi identificado ao tentar instanciar o formatador " + this.fieldFormatterClass.getName() + ".", e);
        }
    }

}
