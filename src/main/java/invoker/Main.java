package invoker;

import component.Text;
import component.TextComponent;
import reader.ConsoleReader;

public class Main {
    static void main() {
        ConsoleReader reader = new ConsoleReader();
        TextComponent text = new Text();

        //TextComponent textFromConsole = new Text(reader.readObjectFromConsole());
        text.buildTextHierarchy(reader.readObjectFromConsole());


    }
}
