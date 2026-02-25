package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Composite {
    static List<List<TextComponent>> sentences = new ArrayList<>();
    Paragraph paragraph;
    Sentence sentence;
    Parser parser;
    String value;

    public Paragraph() {
    }

    public Paragraph(String value) {
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        paragraph = new Paragraph();
        parser = new ParserImpl();
        sentence = new Sentence();

        String stringText = textComponent.toString();
        List<String> stringParagraphs = parser.parseText(stringText);
        for (String textParagraph : stringParagraphs) {
            Paragraph paragraph = new Paragraph(textParagraph);

            sentence.buildTextHierarchy(paragraph);
            sentences.add(paragraph.children);
            textComponent.add(paragraph);
        }
    }

    @Override
    public void printCount() {
        List<TextComponent> allSentences = sentences.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("Sentences count: " + allSentences.size());
        sentence.printCount();
    }

    @Override
    public String toString() {
        return value;
    }
}

