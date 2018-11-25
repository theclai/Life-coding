package coderbyte;

public class MaxSquare {
    public static void main(String[] args) {
        int[][] in = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(findMaxSquare(in));
    }

    private static int findMaxSquare(int[][] in) {
        int max = 0;
        for (int i = 1; i < in.length; i++) {
            for (int j = 1; j < in[0].length; j++) {
                if (in[i][j] == 1) {
                    int curMax = Math.min(in[i - 1][j - 1], Math.min(in[i - 1][j], in[i][j - 1])) + 1;
                    in[i][j] = curMax;
                    if (curMax > max)
                        max = curMax;
                }
            }
        }
        return max * max;
    }
}
