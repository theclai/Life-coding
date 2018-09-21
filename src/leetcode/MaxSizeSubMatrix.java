package leetcode;

public class MaxSizeSubMatrix {
    public static void main(String[] args) {
        int M[][] = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int result = findMaxSizeSubmatrix(M);
        System.out.println(result);
    }

    private static int findMaxSizeSubmatrix(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        if (row == 0)
            return 0;
        if (col == 0)
            return 0;
        int[][] copy = new int[row][col];

        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (m[i][j] == 1) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = m[i][j];
                    }
                } else if (m[i][j] == 1) {
                    copy[i][j] = Math.min(Math.min(m[i - 1][j], m[i][j - 1]),
                            m[i - 1][j - 1]) + 1;
                    if (max < copy[i][j])
                        max = copy[i][j];
                }

            }
        }
        return max;
    }
}
