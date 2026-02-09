package parser;

import component.TextComponent;
import component.Leaf;

import java.util.List;

public class LetterParser extends Leaf implements Parser{
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
