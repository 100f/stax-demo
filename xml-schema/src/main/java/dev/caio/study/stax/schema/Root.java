package dev.caio.study.stax.schema;

import dev.caio.study.xml.commons.schema.annotations.XMLBlock;
import dev.caio.study.xml.commons.schema.annotations.XMLField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@XMLBlock(blockName = "root")
public class Root {
    @XMLField(name = "frozen")
    private Optional<String> frozen;
    @XMLField(name = "city")
    private Optional<String> city;
    @XMLField(name = "let")
    private Optional<String> let;
    @XMLField(name = "window")
    private Optional<String> window;
    @XMLField(name = "path")
    private Optional<Long> path;
}
