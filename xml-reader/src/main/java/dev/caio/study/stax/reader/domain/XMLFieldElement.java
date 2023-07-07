package dev.caio.study.stax.reader.domain;

import dev.caio.study.stax.reader.domain.factories.XMLFieldElementFactory;
import dev.caio.study.stax.reader.domain.metadata.XMLFieldMetadata;
import dev.caio.study.xml.commons.formatter.exception.FieldFormattingException;
import lombok.Getter;

@Getter
public class XMLFieldElement extends XMLElement {
    private XMLFieldElementFactory elementFactory;
    private XMLFieldMetadata fieldMetadata;
    private Object parsedValue;

    public XMLFieldElement(XMLElement parentElement, ElementPosition position, String tagName) {
        super(parentElement, position, tagName);
        this.elementFactory = new XMLFieldElementFactory();
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
            //DEFINIR MELHOR O QUE FAZER
            return content;
        }
    }

    private void setParsedValueUsingParentBlockSetter() {
        try {
            if (parsedValue != null) {
                fieldMetadata.setter().invoke(getParentElement(), parsedValue);
            }
        }
        catch (ReflectiveOperationException e) {
            //DEFINIR MELHOR O QUE FAZER, COSTUMA-SE INTERROMPER A LEITURA.
            e.printStackTrace();
        }
    }

    @Override
    public XMLElement createChildElement(String tagName, ElementPosition position) {
        throw new IllegalStateException("O campo " + tagName + " não deveria possuir filhos.");
    }
}
