package component;

import exceptions.ComponentException;

import java.util.List;

public interface TextComponent {
    void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException;

    void add(TextComponent textComponent) throws ComponentException;

    void remove(TextComponent textComponent) throws ComponentException;

    int calculateParagraphsCount();

    int calculateSentencesCount();

    int calculateWhiteSpacesCount();

    int calculateWordsCount();

    int calculateLettersCount();

    int calculatePunctuationsCount();

    TextComponent getChild(int i) throws ComponentException;

    List<TextComponent> getChildren() throws ComponentException;

    String toString();
}
