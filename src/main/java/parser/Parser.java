package parser;

import component.TextComponent;

import java.util.List;

public interface Parser {
    List<TextComponent> parseObject(TextComponent component);
}
