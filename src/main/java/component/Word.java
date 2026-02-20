package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class Word extends Composite {
    WhiteSpace whiteSpace;
    String value;

    public Word(){}

    public Word(String value){
        super();
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        whiteSpace = new WhiteSpace();
        Parser parser = new ParserImpl();
        Letter letter = new Letter();

        String stringWhiteSpace = textComponent.toString();
        List<String> words = parser.parseWhiteSpaceIntoWords(stringWhiteSpace);

        for (String textWord : words) {
            Word word = new Word(textWord);
            whiteSpace.add(word);

            letter.buildTextHierarchy(word);
        }
    }

    @Override
    public void print() {
        System.out.println("Letters count: " + children.size());
    }

    @Override
    public String toString() {
        return value;
    }
}
