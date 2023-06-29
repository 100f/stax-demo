package dev.caio.study.stax.reader.domain;

import dev.caio.study.xml.commons.schema.formatter.exception.FieldFormattingException;
import lombok.Getter;

@Getter
public class XMLFieldElement extends XMLElement {
    /**
     * Bloco XML lido pelo ouvite ao qual este campo pertence.
     */
    private final XMLBlockElement parentBlock;

    private XMLFieldMetadata fieldMetadata;

    private Object parsedValue;

    public XMLFieldElement(XMLBlockElement parentBlock) {
        this.parentBlock = parentBlock;
    }

    public void setFieldContent(String content) {
        //VALIDAR CAMPO DE ACORDO COM O FIELDFORMATTER, TEREI QUE TRAZER O FORMATADOR PARA DENTRO DESSA CLASSE, OBSERVANDO A ANOTAÇÃO @XMLFIELD
        this.parsedValue = tryParseValue(content);
        setParsedValueUsingParentBlockSetter();
    }

    private Object tryParseValue(String content) {
        try {
            return fieldMetadata.parseContent(content);
        } catch (FieldFormattingException e) {
            //DEFINIR MELHOR O QUE FAZER, PODE-SE
            return content;
        }
    }

    private void setParsedValueUsingParentBlockSetter() {
        try {
            if (parsedValue != null) {
                fieldMetadata.setter().invoke(parentBlock, parsedValue);
            }
        }
        catch (ReflectiveOperationException e) {
            //DEFINIR MELHOR O QUE FAZER, COSTUMA-SE INTERROMPER A LEITURA.
            e.printStackTrace();
        }
    }

    @Override
    public boolean isField() {
        return true;
    }

    @Override
    public boolean isBlock() {
        return false;
    }
}
