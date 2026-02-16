package component;

import java.util.List;

public class Text extends Composite {
    TextComponent textComponent;
    List<TextComponent> children;


    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        Paragraph paragraph = new Paragraph();
        paragraph.buildTextHierarchy(textComponent);
        print();
    }

    @Override
    public void print() {
        Paragraph paragraph = new Paragraph();
        System.out.println("Your text" + textComponent);
        System.out.println("Paragraph count: " + children.size());
        paragraph.print();
    }

    @Override
    public String toString() {
        return "";
    }
}
