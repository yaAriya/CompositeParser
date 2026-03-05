package component;

import exceptions.ComponentException;

import java.util.ArrayList;
import java.util.List;

public class Text extends Composite {

    @Override
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Paragraph paragraph = new Paragraph();
        Text text = new Text();

        paragraph.buildTextHierarchy(text, textToParse);
        textComponent.add(text);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (TextComponent paragraph : getChildren()) {
            stringBuilder.append(paragraph.toString());
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public List<TextComponent> countHowMany() {
        List<TextComponent> result = new ArrayList<>();

        for (TextComponent child : getChildren()) {
            result.addAll(child.countHowMany());
        }

        return result;
    }

    public void printHowMany() {
        List<TextComponent> components = countHowMany();

        List<TextComponent> paragraphs = new ArrayList<>();
        List<TextComponent> sentences = new ArrayList<>();
        List<TextComponent> whiteSpaces = new ArrayList<>();
        List<TextComponent> words = new ArrayList<>();
        List<TextComponent> letters = new ArrayList<>();
        List<TextComponent> marks = new ArrayList<>();

        for (TextComponent component : components) {
            if (component instanceof Paragraph) {
                paragraphs.add(component);
            } else if (component instanceof Sentence) {
                sentences.add(component);
            } else if (component instanceof WhiteSpace) {
                whiteSpaces.add(component);
            } else if (component instanceof Word) {
                words.add(component);
            } else if (component instanceof Letter) {
                letters.add(component);
            } else if (component instanceof Punctuation) {
                marks.add(component);
            }

        }

        System.out.println("Paragraphs count: " + paragraphs.size());
        System.out.println("Sentences count: " + sentences.size());
        System.out.println("WhiteSpaces count: " + whiteSpaces.size());
        System.out.println("Words count: " + words.size());
        System.out.println("Letters count: " + letters.size());
        System.out.println("Punctuation count: " + marks.size());
    }
}
