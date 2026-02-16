package reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readObjectFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text for start working. When you finish the text write \"END\"");

            StringBuilder fullText = new StringBuilder();

            while (scanner.hasNext()) {
                String word = scanner.next();
                fullText.append(word);
                fullText.append(" ");
                if (word.equals("END")) {
                    scanner.close();
                    break;
                }
            }
            return fullText.toString();
        }
    }
}
