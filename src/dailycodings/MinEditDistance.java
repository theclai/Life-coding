package dailycodings;

public class MinEditDistance {
    public static void main(String[] args) {
        MinEditDistance med = new MinEditDistance();
        System.out.println(med.minDistance("god","dog"));
        System.out.println(med.minDistance("kitten","sitting"));
    }

    public int minDistance(String a, String b) {
        int r = a.length();
        int c = b.length();
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i==0)
                    dp[i][j]=j+1;
                else if(j==0)
                    dp[i][j]=dp[i-1][j]+1;
                else if(a.charAt(i)==b.charAt(j))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1],  // Insert
                            dp[i-1][j]),  // Remove
                            dp[i-1][j-1]);

            }
        }
        return dp[r - 1][c - 1];

    }
}
