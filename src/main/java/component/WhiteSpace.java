package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class WhiteSpace extends Composite {
    static List<List<TextComponent>> wordsAndMarks = new ArrayList<>();
    Sentence sentence;
    WhiteSpace whiteSpace;
    Word word;
    Punctuation punctuation;
    Parser parser;
    String value;

    public WhiteSpace() {
    }

    public WhiteSpace(String value) {
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        sentence = new Sentence();
        whiteSpace = new WhiteSpace();
        word = new Word();
        punctuation = new Punctuation();
        parser = new ParserImpl();

        String stringSentence = textComponent.toString();
        List<String> stringWhiteSpaces = parser.parseSentence(stringSentence);

        for (String textWhiteSpace : stringWhiteSpaces) {
            WhiteSpace whiteSpace = new WhiteSpace(textWhiteSpace);

            word.buildTextHierarchy(whiteSpace);
            punctuation.buildTextHierarchy(whiteSpace);

            wordsAndMarks.add(whiteSpace.children);
            textComponent.add(whiteSpace);
        }
    }

    @Override
    public void printCount() {
        List<TextComponent> marks = wordsAndMarks.stream()
                .flatMap(list -> list.stream())
                .filter(element -> element instanceof Punctuation)
                .toList();

        List<TextComponent> words = wordsAndMarks.stream()
                .flatMap(list -> list.stream())
                .filter(element -> element instanceof Word)
                .toList();

        System.out.println("Words count: " + words.size());
        System.out.println("Marks count: " + marks.size());

        word.printCount();
    }

    @Override
    public String toString() {
        return value;
    }
}
