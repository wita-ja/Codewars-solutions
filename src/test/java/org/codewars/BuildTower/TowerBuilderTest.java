package org.codewars.BuildTower;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TowerBuilderTest {
        @Test
        public void basicTests() {
            assertEquals(String.join(",", "*"), String.join(",", TowerBuildingKata.paintPyramid(1)));
            assertEquals(String.join(",", " * ", "***"), String.join(",", TowerBuildingKata.paintPyramid(2)));
            assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", TowerBuildingKata.paintPyramid(3)));
        }
}