package dp;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] w = new int[]{5, 4, 6, 3};
        int[] v = new int[]{10, 40, 30, 50};
        int W = 10;
        int maxGain = knapsack(w, v, W);
        System.out.println(maxGain);
    }

    private static int knapsack(int[] w, int[] v, int W) {
        int[][] matrix = new int[w.length + 1][W + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < W; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 1; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {
                int weight = w[i - 1];
                if(weight<=j){
                    matrix[i][j] = Math.max(
                            v[i - 1] + matrix[i - 1][j - weight],
                            matrix[i - 1][j]
                    );
                }else{
                    matrix[i][j]=matrix[i-1][j];
                }

            }
        }
        return matrix[w.length][W];
    }
}
