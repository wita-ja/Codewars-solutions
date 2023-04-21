package org.codewars.Kingdom.ep1;

public class Jousting {
    public static String[] joust(String[] listField, int vKnightLeft, int vKnightRight) {
        String knightLeft = listField[0];
        String knightRight = listField[1];

        if (areKnightsRefusedToJoust(vKnightLeft, vKnightRight)) {
            return listField;
        } else {
            while (!areKnightsCollided(knightLeft, knightRight)) {
                knightLeft = " ".repeat(vKnightLeft).concat(knightLeft.substring(0, knightLeft.length() - vKnightLeft));
                knightRight = knightRight.substring(vKnightRight).concat(" ".repeat(vKnightRight));
            }

            return new String[]{knightLeft, knightRight};
        }


    }

    public static boolean areKnightsCollided(String knightLeft, String knightRight) {
        return knightLeft.indexOf(">") >= knightRight.indexOf("<");
    }

    public static boolean areKnightsRefusedToJoust(int vKnightLeft, int vKnightRight) {
        return vKnightLeft == vKnightRight && vKnightLeft == 0;
    }
}
