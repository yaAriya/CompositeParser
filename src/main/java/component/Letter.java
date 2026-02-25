package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Letter extends Leaf {
    Word word;
    Parser parser;
    Character value;

    public Letter() {
    }

    public Letter(Character value) {
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        word = new Word();
        parser = new ParserImpl();

        String stringWord = textComponent.toString();
        List<Character> letters = parser.parseWord(stringWord);

        for (Character textLetter : letters) {
            Letter letter = new Letter(textLetter);
            textComponent.add(letter);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
