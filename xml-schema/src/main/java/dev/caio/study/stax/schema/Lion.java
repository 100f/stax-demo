package dev.caio.study.stax.schema;

import dev.caio.study.xml.commons.schema.annotations.XMLBlock;
import dev.caio.study.xml.commons.schema.definitions.XMLBlockClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XMLBlock(blockName = "name")
public class Lion extends XMLBlockClass {
}
