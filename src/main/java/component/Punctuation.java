package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Punctuation extends Leaf {
    Character value;

    public Punctuation() {
    }

    public Punctuation(Character value) {
        this.value = value;
    }


    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        Parser parser = new ParserImpl();
        WhiteSpace whiteSpace = new WhiteSpace();

        String stringWhiteSpace = textComponent.toString();
        List<Character> punctuations = parser.parseWhiteSpaceIntoPunctuations(stringWhiteSpace);

        for (Character mark : punctuations) {
            Punctuation punctuation = new Punctuation(mark);
            whiteSpace.add(punctuation);
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
