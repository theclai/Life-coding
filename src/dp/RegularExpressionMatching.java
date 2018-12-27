package dp;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pChar=='*'){
                    if (sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        //   - a b *
                        // - t f f f
                        // a f t f t // b != a and b != '.' thus treat b* as 0 match
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        //   - a b *
                        // - t f f f
                        // a f t f t
                        // b f f t t // dp[i][j - 2] 0 match or dp[i][j - 1] 1 math or dp[i - 1][j] 2+ match (not sure why)
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
