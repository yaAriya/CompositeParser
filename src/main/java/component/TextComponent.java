package component;

import exceptions.ComponentException;

public interface TextComponent {
    void buildTextHierarchy(TextComponent textComponent);

    void add(TextComponent textComponent) throws ComponentException;

    void remove(TextComponent textComponent) throws ComponentException;

    TextComponent getChild(int i) throws ComponentException;

    String toString();
}
