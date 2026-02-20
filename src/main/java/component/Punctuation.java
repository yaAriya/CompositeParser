package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Punctuation extends Leaf {
    WhiteSpace whiteSpace;
    Character value;

    public Punctuation() {
    }

    public Punctuation(Character value) {
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        whiteSpace = new WhiteSpace();
        Parser parser = new ParserImpl();

        String stringWhiteSpace = textComponent.toString();
        List<Character> punctuations = parser.parseWhiteSpaceIntoPunctuations(stringWhiteSpace);

        for (Character mark : punctuations) {
            Punctuation punctuation = new Punctuation(mark);
            whiteSpace.add(punctuation);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
