package component;

import exceptions.ComponentException;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements TextComponent {
    protected List<TextComponent> children = new ArrayList<>();

    @Override
    public abstract void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException;

    @Override
    public void add(TextComponent component) {
        children.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        children.remove(component);
    }

    @Override
    public int calculateParagraphsCount() {
        int paragraphsCount = 0;

        for (TextComponent child : getChildren()) {
            paragraphsCount = paragraphsCount + child.calculateParagraphsCount();
        }
        return paragraphsCount;
    }

    @Override
    public int calculateSentencesCount() {
        int sentencesCount = 0;

        for (TextComponent child : getChildren()) {
            sentencesCount = sentencesCount + child.calculateSentencesCount();
        }
        return sentencesCount;
    }

    @Override
    public int calculateWhiteSpacesCount() {
        int whiteSpacesCount = 0;

        for (TextComponent child : getChildren()) {
            whiteSpacesCount = whiteSpacesCount + child.calculateWhiteSpacesCount();
        }
        return whiteSpacesCount;
    }

    @Override
    public int calculateWordsCount() {
        int wordsCount = 0;

        for (TextComponent child : getChildren()) {
            wordsCount = wordsCount + child.calculateWordsCount();
        }
        return wordsCount;
    }

    @Override
    public int calculateLettersCount() {
        int lettersCount = 0;

        for (TextComponent child : getChildren()) {
            lettersCount = lettersCount + child.calculateLettersCount();
        }
        return lettersCount;
    }

    @Override
    public int calculatePunctuationsCount() {
        int punctuationsCount = 0;

        for (TextComponent child : getChildren()) {
            punctuationsCount = punctuationsCount + child.calculatePunctuationsCount();
        }
        return punctuationsCount;
    }

    @Override
    public TextComponent getChild(int i) {
        return children.get(i);
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public abstract String toString();
}
