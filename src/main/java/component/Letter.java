package component;

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
    public void buildTextHierarchy(TextComponent textComponent) {
        Parser parser = new ParserImpl();
        Word word = new Word();

        String stringWord = textComponent.toString();
        List<Character> letters = parser.parseWord(stringWord);

        for (Character textLetter : letters) {
            Letter letter = new Letter(textLetter);
            word.add((letter));
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
