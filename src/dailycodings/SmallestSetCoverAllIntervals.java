package dailycodings;

public class SmallestSetCoverAllIntervals {
    public static void main(String[] args) {
        int[][] in = new int[][]{{0, 3}, {2, 6}, {3, 4}, {6, 9}};
        findMin(in);
    }

    private static void findMin(int[][] in) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < in.length; i++) {
            int[] arr = in[i];
            min = Math.min(min, arr[1]);
            max = Math.max(max, arr[0]);
        }
        System.out.println(min);
        System.out.println(max);
    }
}
