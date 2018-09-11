package leetcode;

public class ValidPermutationOfDISequence {
    public static void main(String[] args){
        numPermsDISequence("DID");

    }
    public static int numPermsDISequence(String S) {
        int n = S.length(), mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1], dp2 = new int[n];
        for (int j = 0; j <= n; j++) dp[j] = 1;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp2[j] = cur = (cur + dp[j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp2[j] = cur = (cur + dp[j + 1]) % mod;
            dp = dp2;
        }
        return dp[0];
    }
}
