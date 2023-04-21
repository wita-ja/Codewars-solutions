package org.codewars.Kingdom.ep1;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class JoustingTest {
    @Test
    public void sampleJousting() {
        assertArrayEquals(new String[]{
                " $->   ",
                "   <-P "
        }, Jousting.joust(new String[]{
                "$->    ",
                "    <-P"
        }, 1, 1));
        assertArrayEquals(new String[]{
                "  $->   ",
                "   <-P  "
        }, Jousting.joust(new String[]{
                "$->     ",
                "     <-P"
        }, 1, 1));
        assertArrayEquals(new String[]{
                "      $->        ",
                "        <-P      "
        }, Jousting.joust(new String[]{
                "$->              ",
                "              <-P"
        }, 1, 1));
    }

    @Test
    public void differentVelocity() {
        assertArrayEquals(new String[]{
                "   $-> ",
                " <-P   "
        }, Jousting.joust(new String[]{
                "$->    ",
                "    <-P"
        }, 3, 3));
        assertArrayEquals(new String[]{
                "$->     ",
                " <-P    "
        }, Jousting.joust(new String[]{
                "$->     ",
                "     <-P"
        }, 0, 2));
        assertArrayEquals(new String[]{
                "      $->        ",
                "     <-P         "
        }, Jousting.joust(new String[]{
                "$->              ",
                "              <-P"
        }, 2, 3));
    }

    @Test
    public void immediateBattle() {
        assertArrayEquals(new String[]{
                "$->  ",
                "  <-P"
        }, Jousting.joust(new String[]{
                "$->  ",
                "  <-P"
        }, 3, 3));
        assertArrayEquals(new String[]{
                "$->",
                "<-P"
        }, Jousting.joust(new String[]{
                "$->",
                "<-P"
        }, 3, 3));
        assertArrayEquals(new String[]{
                "$-> ",
                " <-P"
        }, Jousting.joust(new String[]{
                "$-> ",
                " <-P"
        }, 0, 0));
    }

    @Test
    public void knightsRefusedToFight() {
        assertArrayEquals(new String[]{
                "$->    ",
                "    <-P"
        }, Jousting.joust(new String[]{
                "$->    ",
                "    <-P"
        }, 0, 0));
    }

    private static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min); //The maximum is exclusive and the minimum is inclusive
    }

    private static Object[] createTest(int i) {
        String[] listField = new String[]{"$->" + " ".repeat(i), " ".repeat(i) + "<-P"};
        int vKnightLeft = getRandomInt(0, 4);
        int vKnightRight = getRandomInt(0, 4);
        return new Object[]{listField, vKnightLeft, vKnightRight};
    }

    private static String[] mySolution(String[] listField, int vKnightLeft, int vKnightRight) {
        int leftPoint = 2;
        int rightPoint = listField[0].length() - 3;

        while (leftPoint < rightPoint && (vKnightLeft > 0 || vKnightRight > 0)) {
            leftPoint += vKnightLeft;
            rightPoint -= vKnightRight;
        }

        String line1 = " ".repeat(leftPoint - 2) + "$->" + " ".repeat(listField[0].length() - leftPoint - 1);
        String line2 = " ".repeat(rightPoint) + "<-P" + " ".repeat(listField[1].length() - rightPoint - 3);

        return new String[]{line1, line2};
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 100; i++) {
            Object[] createdTest = createTest(i);
            String[] listField = (String[]) createdTest[0];
            int vKnightLeft = (int) createdTest[1];
            int vKnightRight = (int) createdTest[2];
            String[] solution = mySolution(Arrays.copyOf(listField, listField.length), vKnightLeft, vKnightRight);
            assertArrayEquals(solution, Jousting.joust(Arrays.copyOf(listField, listField.length), vKnightLeft, vKnightRight));
        }
    }
}