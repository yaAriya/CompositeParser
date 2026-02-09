package parser;

import component.Leaf;
import component.TextComponent;

import java.util.List;

public class PunctuationParser extends Leaf implements Parser {
    @Override
    public List<TextComponent> parseObject(TextComponent component) {
        return List.of();
    }

    @Override
    public void print(TextComponent textComponent) {
    }

    @Override
    public String toString(TextComponent textComponent) {
        return "";
    }
}
