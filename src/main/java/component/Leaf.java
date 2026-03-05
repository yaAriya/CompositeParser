package component;

import exceptions.ComponentException;

import java.util.List;

public abstract class Leaf implements TextComponent {

    @Override
    public abstract void buildTextHierarchy(TextComponent textComponent, String textToParse) throws ComponentException;

    @Override
    public void add(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public void remove(TextComponent textComponent) throws ComponentException {
        throw new ComponentException("Leaf cannot have child");
    }

    @Override
    public abstract List<TextComponent> countHowMany();

    @Override
    public TextComponent getChild(int i) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public List<TextComponent> getChildren() throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public abstract String toString();
}
