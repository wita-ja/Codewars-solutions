package org.codewars.BetweenExtremes;

import java.util.stream.IntStream;

public class BetweenExtremes {
    public static int betweenExtremes(int[] numbers) {
       return IntStream.of(numbers).max().getAsInt() - IntStream.of(numbers).min().getAsInt();
    }
}
