package printer;

import component.*;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public void printText(String text) {
        System.out.println("Your text: ");
        System.out.println(text);
    }

    public void printHowMany(List<TextComponent> components) {
        List<TextComponent> paragraphs = new ArrayList<>();
        List<TextComponent> sentences = new ArrayList<>();
        List<TextComponent> whiteSpaces = new ArrayList<>();
        List<TextComponent> words = new ArrayList<>();
        List<TextComponent> letters = new ArrayList<>();
        List<TextComponent> marks = new ArrayList<>();

        for (TextComponent component : components) {
            if (component instanceof Paragraph) {
                paragraphs.add(component);
            } else if (component instanceof Sentence) {
                sentences.add(component);
            } else if (component instanceof WhiteSpace) {
                whiteSpaces.add(component);
            } else if (component instanceof Word) {
                words.add(component);
            } else if (component instanceof Letter) {
                letters.add(component);
            } else if (component instanceof Punctuation) {
                marks.add(component);
            }
        }

        System.out.println("Paragraphs count: " + paragraphs.size());
        System.out.println("Sentences count: " + sentences.size());
        System.out.println("WhiteSpaces count: " + whiteSpaces.size());
        System.out.println("Words count: " + words.size());
        System.out.println("Letters count: " + letters.size());
        System.out.println("Punctuation count: " + marks.size());
    }
}
