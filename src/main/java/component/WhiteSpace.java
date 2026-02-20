package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class WhiteSpace extends Composite {
    Sentence sentence;
    String value;

    public WhiteSpace() {
    }

    public WhiteSpace(String value) {
        super();
        this.value = value;
    }

    public void buildTextHierarchy(TextComponent textComponent) {
        sentence = new Sentence();
        Parser parser = new ParserImpl();
        Word word = new Word();
        Punctuation punctuation = new Punctuation();

        String stringSentence = textComponent.toString();
        List<String> stringWhiteSpaces = parser.parseSentence(stringSentence);

        for (String textWhiteSpace : stringWhiteSpaces) {
            WhiteSpace whiteSpace = new WhiteSpace(textWhiteSpace);
            sentence.add(whiteSpace);

            word.buildTextHierarchy(whiteSpace);
            punctuation.buildTextHierarchy(whiteSpace);
        }
    }

    @Override
    public void print() {
        List<Punctuation> marks = new ArrayList<>();
        List<Word> words = new ArrayList<>();
        Word word = new Word();

        for (TextComponent component : children) {
            if (component instanceof Word) {
                words.add((Word) component);
            } else if (component instanceof Punctuation) {
                marks.add((Punctuation) component);
            }
        }

        System.out.println("Words count: " + words.size());
        System.out.println("Marks count: " + marks.size());

         word.print();
    }

    @Override
    public String toString() {
        return value;
    }
}
