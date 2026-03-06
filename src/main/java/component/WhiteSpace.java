package component;

import exceptions.ComponentException;
import parser.Parser;
import parser.ParserImpl;

import java.util.List;

public class WhiteSpace extends Composite {
    public void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException {
        Word word = new Word();
        Punctuation punctuation = new Punctuation();
        Parser parser = new ParserImpl();

        List<String> stringWhiteSpaces = parser.parseSentence(textToParse);
        for (String textWhiteSpace : stringWhiteSpaces) {
            WhiteSpace whiteSpace = new WhiteSpace();

            word.buildTextHierarchy(whiteSpace, textWhiteSpace);
            punctuation.buildTextHierarchy(whiteSpace, textWhiteSpace);

            textComponent.add(whiteSpace);
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
    public int calculateWhiteSpacesCount() {
        return 1;
    }
}
