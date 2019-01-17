package dailycodings;

public class WordFindOrNotInMatrix {
    public static void main(String[] args) {
        char[][] in = new char[][]{
                {'a', 'x', 'm', 'y'},
                {'b', 'g', 'd', 'f'},
                {'x', 'e', 'e', 't'},
                {'r', 'a', 'k', 's'}
        };
        System.out.println(wordfind(in, "geekt"));
    }

    private static boolean wordfind(char[][] in, String geek) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                if (geek.charAt(0) == in[i][j]) {
                    boolean res = helper(i, j, in, geek, 0);
                    if (res)
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(int r, int c, char[][] in, String geek, int pos) {
        if (r < 0 || c < 0 || r >= in.length || c >= in[0].length)
            return false;

        if (pos == geek.length() - 1 && in[r][c] == geek.charAt(pos))
            return true;
        if (pos < geek.length() && in[r][c] == geek.charAt(pos))
            return (helper(r + 1, c, in, geek, pos + 1) ||
                    helper(r, c + 1, in, geek, pos + 1) ||
                    helper(r - 1, c, in, geek, pos + 1) ||
                    helper(r, c - 1, in, geek, pos + 1));

        return false;
    }
}
