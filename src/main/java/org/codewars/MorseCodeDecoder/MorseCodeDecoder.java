package org.codewars.MorseCodeDecoder;

import java.util.Arrays;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code) available on CodeWars
        return Arrays.stream(morseCode.trim().split("   "))
                .map(morseWord -> Arrays.stream(morseWord.split(" ")).reduce("", (temp, current) ->temp +MorseCode.get(current)))
                .reduce("", (temp, current) -> temp +String.format(" %s", current)).trim();
    }
}
