package parser;

import component.TextComponent;
import component.Composite;

import java.util.List;

public class ParagraphParser extends Composite implements Parser{
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
