package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Word extends Composite {
    static List<List<TextComponent>> letters = new ArrayList<>();
    WhiteSpace whiteSpace;
    Letter letter;
    Parser parser;
    String value;

    public Word() {
    }

    public Word(String value) {
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        whiteSpace = new WhiteSpace();
        parser = new ParserImpl();
        letter = new Letter();

        String stringWhiteSpace = textComponent.toString();
        List<String> stringWords = parser.parseWhiteSpaceIntoWords(stringWhiteSpace);

        for (String textWord : stringWords) {
            Word word = new Word(textWord);

            letter.buildTextHierarchy(word);
            letters.add(word.children);
            textComponent.add(word);
        }
    }

    @Override
    public void printCount() {
        List<TextComponent> allLetters = letters.stream()
                .flatMap(list -> list.stream())
                .toList();

        System.out.println("Letters count: " + allLetters.size());
    }

    @Override
    public String toString() {
        return value;
    }
}
