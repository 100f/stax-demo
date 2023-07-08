package dev.caio.study.stax.schema;

import dev.caio.study.xml.commons.annotations.XMLBlock;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XMLBlock(blockName = "higher", id = "higher_id")
public class Higher extends XMLBlockClass {
}
