package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<String> parseText(String text) {
        String[] paragraphs = text.split("\\n\\n");
        return Arrays.asList(paragraphs);
    }

    @Override
    public List<String> parseParagraph(String paragraph) {
        String[] sentences = paragraph.split("(?<=[.!?])\\s+");
        return Arrays.asList(sentences);
    }

    @Override
    public List<String> parseSentence(String sentence) {
        return Arrays.stream(sentence.trim().split("\\s+"))
                .toList();
    }

    @Override
    public List<String> parseWhiteSpaceIntoWords(String whiteSpace) {
        List<String> words = new ArrayList<>();
        String[] notFilteredWords = whiteSpace.split("[^a-zA-Z]+");

        for (String word : notFilteredWords) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        return words;
    }

    @Override
    public List<Character> parseWhiteSpaceIntoPunctuations(String whiteSpace) {
        List<Character> punctuation = new ArrayList<>();
        String[] notFilteredPunctuation = whiteSpace.split("\\P{Punct}");

        for (String string : notFilteredPunctuation) {
            if (!string.isEmpty()) {
                char[] marks = string.toCharArray();
                for (char mark : marks) {
                    punctuation.add(mark);
                }
            }
        }
        return punctuation;
    }

    @Override
    public List<Character> parseWord(String word) {
        List<Character> letters = new ArrayList<>();

        for (char letter : word.toCharArray()) {
            letters.add(letter);
        }
        return letters;
    }
}
