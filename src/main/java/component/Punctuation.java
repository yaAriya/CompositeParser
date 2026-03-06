package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Punctuation extends Leaf {
    Character value;

    public Punctuation() {
    }

    public Punctuation(Character value) {
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Parser parser = new ParserImpl();

        List<Character> punctuations = parser.parseWhiteSpaceIntoPunctuations(textToParse);

        for (Character mark : punctuations) {
            Punctuation punctuation = new Punctuation(mark);
            textComponent.add(punctuation);
        }
    }

    @Override
    public int calculateLettersCount() {
        return 0;
    }

    @Override
    public int calculatePunctuationsCount() {
        return 1;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
