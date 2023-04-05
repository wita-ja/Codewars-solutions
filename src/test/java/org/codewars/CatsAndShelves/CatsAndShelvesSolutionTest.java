package org.codewars.CatsAndShelves;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatsAndShelvesSolutionTest {

    @Test
    public void solution() {
            assertEquals(2, CatsAndShelvesSolution.solution(1, 5));
        assertEquals(1, CatsAndShelvesSolution.solution(1, 4));
        assertEquals(3, CatsAndShelvesSolution.solution(1, 6));
        assertEquals(2, CatsAndShelvesSolution.solution(2, 4));
        assertEquals(1, CatsAndShelvesSolution.solution(3, 4));
        assertEquals(4, CatsAndShelvesSolution.solution(3, 11));
    }


}