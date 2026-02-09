package component;

import exceptions.ComponentException;

public interface TextComponent {
    void add(TextComponent textComponent) throws ComponentException;

    void remove(TextComponent textComponent) throws ComponentException;

    TextComponent getChild(int i) throws ComponentException;

    void print(TextComponent textComponent);

    String toString(TextComponent textComponent);
}
