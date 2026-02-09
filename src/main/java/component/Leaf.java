package component;

import exceptions.ComponentException;

public abstract class Leaf implements TextComponent {
    @Override
    public TextComponent getChild(int i) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public void remove(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public void add(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public abstract void print(TextComponent textComponent);

    @Override
    public abstract String toString(TextComponent textComponent);
}
