package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Composite {
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Parser parser = new ParserImpl();
        WhiteSpace whiteSpace = new WhiteSpace();

        List<String> stringSentences = parser.parseParagraph(textToParse);
        for (String textSentence : stringSentences) {
            Sentence sentence = new Sentence();

            whiteSpace.buildTextHierarchy(sentence, textSentence);
            textComponent.add(sentence);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (TextComponent whiteSpaces : getChildren()) {
            stringBuilder.append(whiteSpaces.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public List<TextComponent> countHowMany() {
        List<TextComponent> result = new ArrayList<>();

        result.add(this);
        for (TextComponent whiteSpace : getChildren()) {
            result.addAll(whiteSpace.countHowMany());
        }

        return result;
    }
}
