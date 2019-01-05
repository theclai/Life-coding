package leetcode;

public class Wildcardmatching_44 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*"));
    }

    private static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        ;

        // it's whole string matching, so when p[j] == '*', when previous is true, then the dp[0][j] is true
        for (int j = 0; j < n; j++)
            if (p.charAt(j) == '*' && dp[0][j])
                dp[0][j + 1] = true;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*')
                    // check previous	   set * as null 	    set * equal to previous sequence
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
            }
        return dp[m][n];

    }
}
