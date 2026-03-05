package invoker;

import component.Text;
import exceptions.ComponentException;
import printer.Printer;
import reader.ConsoleReader;

public class Main {
    static void main() throws ComponentException {
        ConsoleReader reader = new ConsoleReader();
        Printer printer = new Printer();
        Text text = new Text();

        text.buildTextHierarchy(text, reader.readObjectFromConsole());
        text.printHowMany();
        printer.printText(text.toString());
    }
}
