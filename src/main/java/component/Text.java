package component;

import exceptions.ComponentException;

import java.util.ArrayList;
import java.util.List;

public class Text extends Composite {
    static List<List<TextComponent>> paragraphs = new ArrayList<>();
    TextComponent textComponent;
    Paragraph paragraph;
    String value;

    public Text() {
    }

    public Text(String value) {
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) throws ComponentException {
        this.textComponent = textComponent;
        paragraph = new Paragraph();

        String stringText = textComponent.toString();
        Text text = new Text(stringText);
        paragraph.buildTextHierarchy(text);
        paragraphs.add(text.children);
        printCount();
    }

    @Override
    public void printCount() {
        System.out.println("Your text" + "\n" + textComponent.toString());
        List<TextComponent> allParagraphs = paragraphs.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("Paragraph count: " + allParagraphs.size());
        paragraph.printCount();
    }

    @Override
    public String toString() {
        return value;
    }
}
