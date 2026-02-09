package component;


import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements TextComponent{
    List<TextComponent> children = new ArrayList<>();
    @Override
    public void add(TextComponent component) {
        children.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        children.remove(component);
    }

    @Override
    public TextComponent getChild(int i) {
        return children.get(i);
    }

    @Override
    public abstract void print(TextComponent component);

    @Override
    public abstract String toString(TextComponent component);
}
