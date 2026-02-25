package component;

import exceptions.ComponentException;

public abstract class Leaf implements TextComponent {

    @Override
    public abstract void buildTextHierarchy(TextComponent textComponent) throws ComponentException;

    @Override
    public void add(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public void remove(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public abstract String toString();
}
