package org.codewars.CatsAndShelves;

public class CatsAndShelvesSolution {

    public static int solution(int start, int finish)
    {
        int counter = 0;
        boolean diffIsLess3 = finish - start < 3;
        int currPosition = start;
        while (!diffIsLess3) {
            currPosition = currPosition + 3;
            diffIsLess3 = finish - currPosition < 3;
            counter++;
        }
        return counter + (finish-currPosition);
    }

    public static int mostEfficientUsersSolution(int start, int finish) {
        int diff = (finish - start);
        return diff/3 + diff % 3;
    }
}
