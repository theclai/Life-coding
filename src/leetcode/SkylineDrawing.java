package leetcode;

import java.util.*;

public class SkylineDrawing {
    private static class BuildingPoint
            implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x)
                return this.x - o.x;
            else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }

    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }

        Arrays.sort(buildingPoints);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();

        for (BuildingPoint buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height,
                        (key, val) -> {
                            if (val != null)
                                return val + 1;
                            return 1;
                        });
            } else {
                queue.compute(buildingPoint.height,
                        (key, val) -> {
                            if (val == 1)
                                return null;
                            return val - 1;

                        });
            }
            int currentMaxHeight = queue.lastKey();
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }
}
