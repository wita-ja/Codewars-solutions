package org.codewars.Kingdom.ep2;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheCurseNormal {


    public static String translateNormal(String speech, String[] vocabulary) {
        if (speech.isEmpty()) return speech;

        List<String> encodedWords = new ArrayList<>(Arrays.stream(speech.split(" ")).toList());
        Map<Integer, String> encodedWordsMap = IntStream.range(0, encodedWords.size())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, encodedWords.get(i)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        Map<Integer, String> decodedWords = new LinkedHashMap<>();
        List<String> vocabularyList = new ArrayList<>(Arrays.stream(vocabulary).toList());


        while (!(decodedWords.size() == encodedWordsMap.size())) {
            for (int i = 0; i < encodedWordsMap.size(); i++) {
                List<String> tempPossibleWordsList = new ArrayList<>();
                String currEncodedWord = stripWordSymbol(encodedWordsMap.get(i));
                for (String currVocabularyWord : vocabularyList) {
                    if (currEncodedWord.length() == currVocabularyWord.length()) {
                        int matches = 0;

                        for (int k = 0; k < currEncodedWord.length(); k++) {
                            char currLetter = currEncodedWord.charAt(k);
                            if (currLetter == currVocabularyWord.charAt(k) || currLetter == '*') {
                                matches++;
                            }
                        }

                        if (matches == currEncodedWord.length()) {
                            tempPossibleWordsList.add(currVocabularyWord);
                        }
                    }
                }

                if (tempPossibleWordsList.size() == 1) {
                    String decodedWord = tempPossibleWordsList.get(0);
                    decodedWords.put(i, addWordSymbol(encodedWordsMap.get(i), decodedWord));
                    vocabularyList.remove(decodedWord);
                }
            }
        }

        return decodedWords.keySet().stream().sorted().map(key -> decodedWords.get(key).concat(" ")).map(Objects::toString).collect(Collectors.joining()).strip();
    }


    public static String stripWordSymbol(String word) {
        return doesWordContainLeadingSymbol(word) ? word.substring(0, word.length() - 1) : word;
    }

    public static String addWordSymbol(String encodedWord, String decodedWord) {
        return doesWordContainLeadingSymbol(encodedWord) ? decodedWord + encodedWord.charAt(encodedWord.length() - 1) : decodedWord;
    }

    public static boolean doesWordContainLeadingSymbol(String word) {
        return word.contains(",") || word.contains(".") || word.contains("?") || word.contains("!");
    }
}

