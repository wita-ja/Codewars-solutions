package org.codewars.PlayingWithDigits;

import static org.junit.Assert.*;
import org.junit.Test;

public class DigPowTest {
    @Test
    public void Test1() {
        assertEquals(1, DigPow.digPow(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }
    @Test
    public void Test4() {
        assertEquals(9, DigPow.digPow(114, 3));
    }
    @Test
    public void Test5() {
        assertEquals(-1, DigPow.digPow(46288, 5));
    }
    @Test
    public void Test6() {
        assertEquals(1, DigPow.digPow(135, 1));
    }
    @Test
    public void Test7() {
        assertEquals(1, DigPow.digPow(175, 1));
    }
    @Test
    public void Test8() {
        assertEquals(1, DigPow.digPow(518, 1));
    }
    @Test
    public void Test9() {
        assertEquals(1, DigPow.digPow(63761, 3));
    }
    @Test
    public void Test10() {
        assertEquals(1, DigPow.digPow(598, 1));
    }
    @Test
    public void Test11() {
        assertEquals(1, DigPow.digPow(1306, 1));
    }
    @Test
    public void Test12() {
        assertEquals(1, DigPow.digPow(2427, 1));
    }
    @Test
    public void Test13() {
        assertEquals(1, DigPow.digPow(2646798, 1));
    }
    @Test
    public void Test14() {
        assertEquals(-1, DigPow.digPow(3456789, 1));
    }
    @Test
    public void Test15() {
        assertEquals(-1, DigPow.digPow(3456789, 5));
    }
    @Test
    public void Test16() {
        assertEquals(3, DigPow.digPow(198, 1));
    }
    @Test
    public void Test17() {
        assertEquals(3, DigPow.digPow(249, 1));
    }
    @Test
    public void Test18() {
        assertEquals(2, DigPow.digPow(1377, 1));
    }
    @Test
    public void Test19() {
        assertEquals(1, DigPow.digPow(1676, 1));
    }
    @Test
    public void Test20() {
        assertEquals(2, DigPow.digPow(695, 2));
    }
    @Test
    public void Test21() {
        assertEquals(19, DigPow.digPow(1878, 2));
    }
    @Test
    public void Test22() {
        assertEquals(5, DigPow.digPow(7388, 2));
    }
    @Test
    public void Test23() {
        assertEquals(1, DigPow.digPow(47016, 2));
    }
    @Test
    public void Test24() {
        assertEquals(1, DigPow.digPow(542186, 2));
    }
    @Test
    public void Test25() {
        assertEquals(5, DigPow.digPow(261, 3));
    }
    @Test
    public void Test26() {
        assertEquals(35, DigPow.digPow(1385, 3));
    }
    @Test
    public void Test27() {
        assertEquals(66, DigPow.digPow(2697, 3));
    }
    @Test
    public void Test28() {
        assertEquals(10, DigPow.digPow(6376, 3));
    }
    @Test
    public void Test29() {
        assertEquals(1, DigPow.digPow(6714, 3));
    }
    @Test
    public void Test30() {
        assertEquals(1, DigPow.digPow(63760, 3));
    }
    @Test
    public void Test31() {
        assertEquals(4, DigPow.digPow(132921, 3));
    }
    @Test
    public void Test32() {
        assertEquals(12933, DigPow.digPow(10383, 6));
    }
}