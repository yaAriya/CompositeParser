package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Punctuation extends Leaf {
    WhiteSpace whiteSpace;
    Parser parser;
    Character value;

    public Punctuation() {
    }

    public Punctuation(Character value) {
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        whiteSpace = new WhiteSpace();
        parser = new ParserImpl();

        String stringWhiteSpace = textComponent.toString();
        List<Character> punctuations = parser.parseWhiteSpaceIntoPunctuations(stringWhiteSpace);

        for (Character mark : punctuations) {
            Punctuation punctuation = new Punctuation(mark);
            textComponent.add(punctuation);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
