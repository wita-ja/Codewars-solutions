package org.codewars.simpleFun.ropeSkippingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SkipRope {

    public static int tiaosheng(int[] failedCount) {
        List<Integer> failures = new ArrayList<>(IntStream.of(failedCount).boxed().toList().stream().sorted().toList());
        int sumOfJumps= 0;
        if (failures.size() == 0) {
           return 60;
       } else {
            boolean isCooldownActive = false;
            int cooldownCounter = 0;

            for (int i = 0; i < 60; i++) {
                System.out.println("seconds: " + i + " jumps: " + sumOfJumps);

                if ( isCooldownActive && cooldownCounter == 0) {
                    isCooldownActive = false;
                } else if (isCooldownActive) {
                    cooldownCounter--;
                } else {
                    sumOfJumps++;
                }

                for (Integer jumpOnWhichFailed : failures) {
                    if (sumOfJumps == jumpOnWhichFailed) {
                        isCooldownActive = true;
                        cooldownCounter = 2;
                        failures.remove(jumpOnWhichFailed);
                        break;
                    }
                }
            }
        }
        return sumOfJumps;
    }
}
