package org.codewars.WhoLikesIt;

import java.util.Arrays;

public class WhoLikesIt {

    public static String whoLikesIt(String... names) {
        return switch (Math.min(names.length, 4)) {
            case 0 -> "no one likes this";
            case 1 -> String.format("%s likes this", names[0]);
            case 2 -> String.format("%s and %s like this", names[0], names[1]);
            case 3 -> String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            case 4 -> String.format("%s, %s and %s others like this", names[0], names[1], Arrays.stream(names).count() - 2);
            default -> throw new UnsupportedOperationException(String.format("%s - length", names.length));
        };

    }
}
