package component;

import exceptions.ComponentException;

public interface TextComponent {
    void buildTextHierarchy(TextComponent textComponent) throws ComponentException;

    void add(TextComponent textComponent) throws ComponentException;

    void remove(TextComponent textComponent) throws ComponentException;

    String toString();
}
