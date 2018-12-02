package leetcode;

import java.util.Arrays;
import java.util.List;

public class MinimumTimDifference_539 {
    public static void main(String[] args) {
        MinimumTimDifference_539 mtd=new MinimumTimDifference_539();
        mtd.findMinDifference(null);
    }
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            minutes[i] = hour * 60 + minute;
        }

        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        min = Math.min(min, minutes[0] + 24 * 60 - minutes[minutes.length - 1]);

        return min;

    }
}
