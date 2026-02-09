package invoker;

import parser.ParagraphParser;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text for start working");

        StringBuilder fullText = new StringBuilder();

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            fullText.append(line);
            if(line.equals("END")){
                scanner.close();
            }
        }

        ParagraphParser paragraphParser = new ParagraphParser();
        //paragraphParser.parseObject(fullText);

    }
}
