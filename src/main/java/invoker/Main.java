package invoker;

import component.Text;
import exceptions.ComponentException;
import reader.ConsoleReader;

public class Main {
    static Text textFromConsole;
    static ConsoleReader reader = new ConsoleReader();
    static Text text = new Text();

    static void main() throws ComponentException {

        textFromConsole = new Text(reader.readObjectFromConsole());
        text.buildTextHierarchy(textFromConsole);
    }
}
