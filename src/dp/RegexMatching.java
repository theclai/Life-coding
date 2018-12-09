package dp;

public class RegexMatching {
    public static void main(String[] args) {
        RegexMatching rm = new RegexMatching();
        boolean isMatch = rm.isMatch();
        System.out.println(isMatch);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] map = new boolean[s.length() + 1][p.length() + 1];
        map[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                map[0][i] = map[0][i - 2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    map[i][j] = map[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    map[i][j] = map[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        map[i][j] = map[i - 1][j] || map[i][j];
                    }
                } else {
                    map[i][j] = false;
                }
            }
        }
        return map[s.length()][p.length()];
    }

}
