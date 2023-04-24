package org.codewars.Kingdom.ep2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TheCurseSimple {

    public static String translate(String speech, String[] vocabulary) {
        if (speech.isEmpty()) return speech;

        List<String> words = Arrays.stream(speech.split(" ")).toList();
        List<String> vocabularyList = Arrays.stream(vocabulary).toList();

        List<String> decodedWords = words.stream().map(word -> {
            boolean wordContainsSymbol = word.contains(",") || word.contains(".") || word.contains("?") || word.contains("!");
            String encodedWord = wordContainsSymbol ? word.substring(0, word.length() - 1) : word;

            String decodedWord = null;
            for (String vocabularyWord : vocabularyList) {
                if (encodedWord.length() == vocabularyWord.length()) {
                    int astericsCount = 0;
                    int matches = 0;
                    for (int i = 0; i < encodedWord.length(); i++) {
                        char currLetter = encodedWord.charAt(i);
                        if (currLetter == vocabularyWord.charAt(i)) {
                            matches++;
                        }
                        else if(currLetter == '*') {
                            astericsCount++;
                        }
                    }

                    if( astericsCount+matches == encodedWord.length()) {
                        decodedWord = wordContainsSymbol ? vocabularyWord + word.charAt(word.length() - 1) : vocabularyWord;
                    }
                }
            }
            return decodedWord;
        }).toList();

     return decodedWords.stream().map(word -> word.concat(" ")).map(Objects::toString).collect(Collectors.joining()).strip();
    }
}
