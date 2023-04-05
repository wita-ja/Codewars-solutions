package org.codewars.SimpleFun.DecryptNumber;

import java.math.BigDecimal;

public class DecryptNumberSolution {

    public static String decrypt(String encryptedNum) {
        String result = null;

        for (int i = 1; i < 10; i++) {
            BigDecimal temp = new BigDecimal(String.format("%s%s", i, encryptedNum));
            if(temp.remainder(BigDecimal.valueOf(11)).intValue() == 0) {
                result = temp.divide(BigDecimal.valueOf(11)).toString();
                break;
            }
        }

        if (result == null) {
            result = "impossible";
        }
        return result;
    }
}
