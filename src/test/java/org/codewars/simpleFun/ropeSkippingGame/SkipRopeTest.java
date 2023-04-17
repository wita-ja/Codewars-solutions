package org.codewars.simpleFun.ropeSkippingGame;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SkipRopeTest {
    @Test
    public void testBasic() {
        assertEquals(60, SkipRope.tiaosheng(new int[] {}));
        assertEquals(51, SkipRope.tiaosheng(new int[] { 12, 23, 45 }));
        assertEquals(57, SkipRope.tiaosheng(new int[] { 17 }));
        assertEquals(48, SkipRope.tiaosheng(new int[] { 10, 20, 30, 40 }));
        assertEquals(48, SkipRope.tiaosheng(new int[] { 10, 20, 30, 40, 58 }));
        assertEquals(47, SkipRope.tiaosheng(new int[] { 10, 20, 30, 40, 47, 60 }));
        assertEquals(30, SkipRope.tiaosheng(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
        assertEquals(58, SkipRope.tiaosheng(new int[] { 58 }));
    }

    @Test
    public void testRandom() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int nrFails = rand.nextInt(10) + 1;
            int[] fails = new int[nrFails];
            for (int n = 0; n < nrFails; n++) {
                int nxtR = rand.nextInt(60 - (nrFails - n) - (n == 0 ? 0 : fails[n - 1])) + 1;
                fails[n] = nxtR + (n == 0 ? 0 : fails[n - 1]);
            }
            assertEquals(String.format("Testing for [%s]", Arrays.stream(fails).mapToObj(Integer::toString).collect(Collectors.joining(","))), sol(fails), SkipRope.tiaosheng(fails));
        }
    }

    private int sol(int[] failedCount) {
        int count = 0;
        List<Integer> failed = Arrays.stream(failedCount).boxed().toList();
        int time = 0;
        while (time < 60) {
            count++;
            if (failed.contains(count)) {
                time += 3;
            }
            time++;
        }

        return count;
    }
}