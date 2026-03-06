package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Letter extends Leaf {
    Character value;

    public Letter() {
    }

    public Letter(Character value) {
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Parser parser = new ParserImpl();

        List<Character> letters = parser.parseWord(textToParse);

        for (Character textLetter : letters) {
            Letter letter = new Letter(textLetter);
            textComponent.add(letter);
        }
    }

    @Override
    public int calculatePunctuationsCount() {
        return 0;
    }

    @Override
    public int calculateLettersCount() {
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
