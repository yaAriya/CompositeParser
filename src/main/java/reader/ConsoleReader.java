package reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readObjectFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text for start working. When you finish the text write \"END\"");

            StringBuilder fullText = new StringBuilder();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int endIndex = line.indexOf("END");

                if (endIndex != -1) {
                    fullText.append(line, 0, endIndex);
                    fullText.append("\n");
                    break;
                } else {
                    fullText.append(line);
                    fullText.append("\n");
                }
            }
            return fullText.toString();
        }
    }
}
