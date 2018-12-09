package dp;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        WildcardPatternMatching wm = new WildcardPatternMatching();
        boolean result = wm.isMatching("baaabab", "ba*a?");
        System.out.println(result);
    }

    public boolean isMatching(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();

        boolean[][] cache = new boolean[m + 1][n + 1];
        cache[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*')
                cache[0][j] = cache[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    cache[i][j] = cache[i - 1][j] || cache[i][j - 1];

                } else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                }
            }
        }

        return cache[m][n];

    }
}
