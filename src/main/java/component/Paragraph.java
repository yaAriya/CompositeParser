package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Paragraph extends Composite{
    Text text;
    String value;

    public Paragraph() {
    }

    public Paragraph(String value) {
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) {
        Parser parser = new ParserImpl();
        text = new Text();
        Sentence sentence = new Sentence();

        String stringText = textComponent.toString();
        List<String> stringParagraphs = parser.parseText(stringText);
        for (String textParagraph : stringParagraphs) {
            Paragraph paragraph = new Paragraph(textParagraph);
            text.add(paragraph);

            sentence.buildTextHierarchy(paragraph);
        }
    }

    @Override
    public void print() {
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        System.out.println("Sentences count: " + paragraph.children.size());
        sentence.print();
    }

    @Override
    public String toString() {
        return value;
    }
}

