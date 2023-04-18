package org.codewars.theObservedPin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObservedPin {

    public static HashMap<String, List<String>> adjacentKeys = new HashMap<>() {
        {
            put("1", List.of("1", "2", "4"));
            put("2", List.of("1", "2", "3", "5"));
            put("3", List.of("2", "3", "6"));
            put("4", List.of("1", "4", "5", "7"));
            put("5", List.of("2", "4", "5", "6", "8"));
            put("6", List.of("3", "5", "6", "9"));
            put("7", List.of("4", "7", "8"));
            put("8", List.of("5", "7", "8", "9", "0"));
            put("9", List.of("6", "8", "9"));
            put("0", List.of("8", "0"));
        }
    };

    public static List<List<String>> getPossibleKeysLists(String observed) {
        return IntStream.range(0, observed.length())
                .map(observed::charAt)
                .mapToObj(Character::toString)
                .map(numKey -> adjacentKeys.get(numKey))
                .collect(Collectors.toList());
    }

    public static List<String> generateCombinationsFromTwoArrays(List<String> upperList, List<String> lowerList) {
        List<String> combinations = new ArrayList<>();

        upperList.forEach(upperArrayDigit -> {
            for (String lowerArrayDigit : lowerList) {
                combinations.add(upperArrayDigit + lowerArrayDigit);
            }
        });
        return combinations;
    }

    //TODO Check if possible to reimplement while and iterators
    public static List<String> getPINs(String observed) {
        Iterator<List<String>> possibleKeysLists = getPossibleKeysLists(observed).stream().iterator();
        if (observed.length() == 1) {
            return new ArrayList<>(possibleKeysLists.next());
        } else {
            List<String> result = new ArrayList<>();

            boolean firstIteration = true;
            while (possibleKeysLists.hasNext()) {
                if (firstIteration) {
                    result = generateCombinationsFromTwoArrays(possibleKeysLists.next(), possibleKeysLists.next());
                    firstIteration = false;
                } else {
                    result = generateCombinationsFromTwoArrays(result, possibleKeysLists.next());
                }
            }
            return result;
        }
    }
}
