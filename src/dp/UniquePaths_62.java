package dp;

public class UniquePaths_62 {


    public static void main(String[] args) {
        UniquePaths_62 up = new UniquePaths_62();
        System.out.println(up.uniquePaths(3,2));
    }

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==1 && j==1)
                    cache[i][j]=1;
                else
                    cache[i][j]=cache[i-1][j]+cache[i][j-1];
            }
        }
        return cache[m][n];

    }
}
