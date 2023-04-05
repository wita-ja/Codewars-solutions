package org.codewars.SimpleFun.DecryptNumber;

import org.junit.Assert;
import org.junit.Test;

public class DecryptNumberSolutionTest {

    @Test
    public void decrypt() {
        Assert.assertEquals("123", DecryptNumberSolution.decrypt("353"));

         Assert.assertEquals("404",DecryptNumberSolution.decrypt("444"));

         Assert.assertEquals("738496",DecryptNumberSolution.decrypt("123456"));

         Assert.assertEquals("377",DecryptNumberSolution.decrypt("147"));

         Assert.assertEquals("impossible",DecryptNumberSolution.decrypt("4334"));
    }
}