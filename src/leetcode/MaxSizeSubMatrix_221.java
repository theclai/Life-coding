package leetcode;

public class MaxSizeSubMatrix_221 {
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

        char[][] chars = new char[][]{{'1'}};
        int res= findMaxSizeSubmatrixLeetcode(chars);
        System.out.println(res);


    }

    private static int findMaxSizeSubmatrix(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] copy = new int[row][col];
        if (row == 0)
            return 0;
        if (col == 0)
            return 0;

        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (m[i][j] == 1) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                } else if (m[i][j] == 1) {
                    copy[i][j] = Math.min(Math.min(copy[i - 1][j], copy[i][j - 1]),
                            copy[i - 1][j - 1]) + 1;

                }
                if (max < copy[i][j])
                    max = copy[i][j];

            }
        }
        return max;
    }

    private static int findMaxSizeSubmatrixLeetcode(char[][] m) {
        if (m == null)
            return 0;
        int row = m.length;
        int col = 0;
        if (row != 0) {
            col = m[0].length;
        }

        int[][] copy = new int[row][col];
        if (row == 0)
            return 0;
        if (col == 0)
            return 0;

        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (m[i][j] == '1') {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                } else if (m[i][j] == '1') {
                    copy[i][j] = Math.min(Math.min(copy[i - 1][j], copy[i][j - 1]),
                            copy[i - 1][j - 1]) + 1;

                }
                if (max < copy[i][j])
                    max = copy[i][j];

            }
        }
        return max * max;
    }


}
