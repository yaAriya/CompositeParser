package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Composite {
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Parser parser = new ParserImpl();
        Sentence sentence = new Sentence();

        List<String> stringParagraphs = parser.parseText(textToParse);
        for (String textParagraph : stringParagraphs) {
            Paragraph paragraph = new Paragraph();

            sentence.buildTextHierarchy(paragraph, textParagraph);
            textComponent.add(paragraph);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (TextComponent sentence : getChildren()) {
            stringBuilder.append(sentence.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public List<TextComponent> countHowMany() {
        List<TextComponent> result = new ArrayList<>();

        result.add(this);
        for (TextComponent sentence : getChildren()) {
            result.addAll(sentence.countHowMany());
        }
        return result;
    }
}
