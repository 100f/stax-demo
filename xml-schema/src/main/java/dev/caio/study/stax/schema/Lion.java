package dev.caio.study.stax.schema;

import dev.caio.study.xml.commons.annotations.XMLBlock;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XMLBlock(blockName = "name", id = "lion_id")
public class Lion extends XMLBlockClass {
}
