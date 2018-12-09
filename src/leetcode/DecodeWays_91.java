package leetcode;

public class DecodeWays_91 {
    public static void main(String[] args) {
        DecodeWays_91 dw = new DecodeWays_91();
        System.out.println(dw.numDecodings("12345"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(1) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));

            if (first >= 0 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];

    }


}
