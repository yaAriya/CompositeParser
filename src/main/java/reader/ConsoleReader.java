package reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readObjectFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            int emptyLineCount = 0;
            boolean isEnd = false;
            StringBuilder fullText = new StringBuilder();

            while (scanner.hasNext() && !isEnd) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    emptyLineCount++;
                    if (emptyLineCount == 2) {
                        isEnd = true;
                    }
                } else {
                    fullText.append(line);
                    fullText.append("\n");
                }
            }
            return fullText.toString();
        }
    }
}
