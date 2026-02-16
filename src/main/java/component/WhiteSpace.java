package component;

import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class WhiteSpace extends Composite {
    List<TextComponent> children;
    List<TextComponent> words;
    List<TextComponent> marks;
    String value;

    public WhiteSpace(){
    }

    public WhiteSpace(String value){
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        Parser parser = new ParserImpl();
        Sentence sentence = new Sentence();
        Word word = new Word();
        Punctuation punctuation = new Punctuation();

        String stringSentence = textComponent.toString();
        List<String> stringWhiteSpaces = parser.parseSentence(stringSentence);

        for(String textWhiteSpace: stringWhiteSpaces) {
            WhiteSpace whiteSpace = new WhiteSpace(textWhiteSpace);
            sentence.add(whiteSpace);

            word.buildTextHierarchy(whiteSpace);
            punctuation.buildTextHierarchy(whiteSpace);
        }
    }

    @Override
    public void print() {
        Word word = new Word();

        for (TextComponent component: children){
            if(component instanceof Word){
                words.add(component);
            } else if(component instanceof Punctuation){
                marks.add(component);
            }
        }

        System.out.println("Words count: " + children.size());
        System.out.println("Marks count: " + children.size());

        word.print();
    }

    @Override
    public String toString() {
        return "";
    }
}
