package org.codewars.PlayingWithDigits;

import java.util.stream.IntStream;

public class DigPow {
    public static long digPow(int n, int p) {
        char[] digits = String.valueOf(n).toCharArray();
        double sum = IntStream.range(0, digits.length).mapToDouble(i -> Math.pow(Character.getNumericValue(digits[i]), p + i)).sum();
        int k = (int) (sum/n);
        return (sum == (k * n)) ? k : -1;
    }
}
