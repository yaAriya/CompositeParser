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
}
