package parser;

import java.util.List;

public interface Parser {
    List<String> parseText(String text);

    List<String> parseParagraph(String paragraph);

    List<String> parseSentence(String sentence);

    List<String> parseWhiteSpaceIntoWords(String whiteSpace);

    List<Character> parseWhiteSpaceIntoPunctuations(String whiteSpace);

    List<Character> parseWord(String word);
}
