package org.codewars.BuildTower;

import java.util.ArrayList;
import java.util.List;

public class TowerBuildingKata {

    public String[] towerBuilder(int floors) {
        List<String> pyramidFloors = new ArrayList<>();

        for (int i = floors; i > 0 ; i--) {
            int currFloorSize = calculateFloorBlocksNumber(i);
            String currentFloorBlocks = "*".repeat(currFloorSize);

            if (i == floors) {
                pyramidFloors.add(currentFloorBlocks);
            }
            else {
                int lastFloorSize = calculateFloorBlocksNumber(floors);
                int floorsSizeDelta = (lastFloorSize-currFloorSize)/2;
                String spacing = " ".repeat(floorsSizeDelta);
                pyramidFloors.add(String.format("%s%s%s", spacing, currentFloorBlocks, spacing));
            }

        }
        return pyramidFloors.stream().sorted().toArray(String[]::new);
    }

    private int calculateFloorBlocksNumber(int reqMember) {
       return 1 + (reqMember -1) * 2;
    }

    public static String[] paintPyramid(int floors) {
        TowerBuildingKata pyramidPainter = new TowerBuildingKata();
        return pyramidPainter.towerBuilder(floors);
    }
}
