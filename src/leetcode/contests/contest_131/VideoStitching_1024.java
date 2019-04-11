package leetcode.contests.contest_131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching_1024 {
    static class VideoTime {
        int start;
        int end;

        public VideoTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
       /* int[][] clips = new int[][]{{0,2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int T=10;*/

     /* int[][] clips = new int[][]{{0,1}, {1, 2}};
        int T=5;*/
/*

        int[][] clips = new int[][]{{0,4}, {2, 8}};
        int T=5;
*/

        int[][] clips = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        int T = 9;
        System.out.println(videoStitching(clips, T));
    }

    public static int videoStitching(int[][] clips, int T) {
        if (T == 0) return 0;
        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        if (clips[0][0] != 0) return -1;
        int res = 0, max = 0;
        for (int i = 0; i < clips.length; i++) {
            // current start is bigger than last end, it will break
            if (clips[i][0] > max) return -1;

            int temp = max;

            // iterate all the elements whose starting point is small or equal to last max
            // keep update max
            for (; i < clips.length && clips[i][0] <= temp; i++) {
                max = Math.max(clips[i][1], max);
            }
            // increment
            res++;
            // come back one step
            i--;
            if (max >= T) return res;
        }
        return -1;
    }
}
