package strings;

/**
 * abcb
 * ddcb
 * <p>
 * *    a   b   c   b
 * -------------------
 * d   |0   0   0   0
 * d   |0   0   0   0
 * c   |0   0   1   0
 * b   |0   1   0   2
 **/


public class LongestSubstringOfTwoString {
    public static void main(String[] args) {
        String input1 = "abcb";
        String input2 = "ddcb";
        int longest = findLongestSusbstring(input1, input2);
        System.out.println(longest);
    }

    private static int findLongestSusbstring(String input1, String input2) {
        char[] cols = input1.toCharArray();
        char[] rows = input2.toCharArray();
        int row = rows.length;
        int col = cols.length;
        int max = 0;
        if (row == 0 || col == 0)
            return 0;
        int[][] cache = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cols[j] == rows[i]) {
                    if (i > 0 && j > 0) {
                        cache[i][j] = cache[i - 1][j - 1] + 1;
                    } else {
                        cache[i][j] = 1;

                    }
                    if (cache[i][j] > max)
                        max = cache[i][j];
                }
            }
        }
        return max;
    }
}
