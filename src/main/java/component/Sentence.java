package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Sentence extends Composite {
    List<TextComponent> children;
    String value;

    public Sentence(){}

    public Sentence(String value){
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        Parser parser = new ParserImpl();
        Paragraph paragraph = new Paragraph();
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
        return "";
    }

}
