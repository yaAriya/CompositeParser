package component;

import parser.Parser;
import parser.ParserImpl;

import java.awt.*;
import java.util.List;

public class Sentence extends Composite{
    Paragraph paragraph;
    String value;

    public Sentence(){}

    public Sentence(String value){
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) {
        paragraph = new Paragraph();
        Parser parser = new ParserImpl();
         WhiteSpace whiteSpace = new WhiteSpace();

        String stringParagraph = textComponent.toString();
        List<String> stringSentences = parser.parseParagraph(stringParagraph);
        for (String textSentence: stringSentences){
            Sentence sentence = new Sentence(textSentence);
            paragraph.add(sentence);

            whiteSpace.buildTextHierarchy(sentence);
        }
    }

    @Override
    public void print() {
        WhiteSpace whiteSpace = new WhiteSpace();
        System.out.println("WhiteSpace count: " + children.size());
        whiteSpace.print();
    }

    @Override
    public String toString() {
        return value;
    }
}
