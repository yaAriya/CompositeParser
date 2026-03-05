package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Word extends Composite {
    @Override
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Parser parser = new ParserImpl();
        Letter letter = new Letter();

        List<String> stringWords = parser.parseWhiteSpaceIntoWords(textToParse);

        for (String textWord : stringWords) {
            Word word = new Word();

            letter.buildTextHierarchy(word, textWord);
            textComponent.add(word);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent child : getChildren()) {
            stringBuilder.append(child.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public List<TextComponent> countHowMany() {
        List<TextComponent> result = new ArrayList<>();

        result.add(this);
        for (TextComponent letter : getChildren()) {
            if (letter instanceof Letter) {
                result.addAll(letter.countHowMany());
            }
        }
        return result;
    }
}
