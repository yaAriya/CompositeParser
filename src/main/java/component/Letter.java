package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
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
    public List<TextComponent> countHowMany() {
        List<TextComponent> letters = new ArrayList<>();

        letters.add(this);
        return letters;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
