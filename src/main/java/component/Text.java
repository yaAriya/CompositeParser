package component;

public class Text extends Composite {
    TextComponent textComponent;
    Paragraph paragraph;
    String value;

    public Text(){
    }

    public Text(String value){
        this.value = value;
    }

    @Override
    public void buildTextHierarchy(TextComponent textComponent) {
        this.textComponent = textComponent;
        paragraph = new Paragraph();
        paragraph.buildTextHierarchy(textComponent);
        print();
    }

    @Override
    public void print() {
        paragraph = new Paragraph();
        System.out.println("Your text" + "\n" + textComponent.toString());
        System.out.println("Paragraph count: " + children.size());
        paragraph.print();
    }

    @Override
    public String toString() {
       return value;
    }
}
