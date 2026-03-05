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
    public abstract List<TextComponent> countHowMany();

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
