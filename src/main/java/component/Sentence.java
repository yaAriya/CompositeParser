package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Composite {
    List<List<TextComponent>> whiteSpaces = new ArrayList<>();
    Paragraph paragraph;
    Sentence sentence;
    WhiteSpace whiteSpace;
    Parser parser;
    String value;

    public Sentence() {
    }

    public Sentence(String value) {
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        paragraph = new Paragraph();
        sentence = new Sentence();
        parser = new ParserImpl();
        whiteSpace = new WhiteSpace();

        String stringParagraph = textComponent.toString();
        List<String> stringSentences = parser.parseParagraph(stringParagraph);
        for (String textSentence : stringSentences) {
            Sentence sentence = new Sentence(textSentence);

            whiteSpace.buildTextHierarchy(sentence);
            whiteSpaces.add(sentence.children);
            textComponent.add(sentence);
        }
    }

    @Override
    public void printCount() {
        List<TextComponent> allWhiteSpaces = whiteSpaces.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("WhiteSpace count: " + allWhiteSpaces.size());
        whiteSpace.printCount();
    }

    @Override
    public String toString() {
        return value;
    }
}
