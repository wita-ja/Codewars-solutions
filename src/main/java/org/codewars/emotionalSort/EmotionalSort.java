package org.codewars.emotionalSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EmotionalSort {

    private static final Map<String, Integer> EMOTIONS_MAP = new HashMap<>() {
        {
            put("T_T", 1);
            put(":(", 2);
            put(":|", 3);
            put(":)", 4);
            put(":D", 5);
        }
    };

    public static String[] sortEmotions(boolean order, String[] emotions) {
        // (ง •̀_•́)ง
        if (emotions.length == 0) {
            return emotions;
        }
        else {
            Comparator<Integer> comparingOrder = order ? Comparator.reverseOrder() : Comparator.naturalOrder();

            return Arrays.stream(emotions)
                    .map(EMOTIONS_MAP::get)
                    .sorted(comparingOrder)
                    .map(emotionWeight -> EMOTIONS_MAP.entrySet().stream().filter(e -> e.getValue().equals(emotionWeight))
                            .findFirst().get().getKey())
                    .toList()
                    .toArray(new String[0]);
        }
    }
}
