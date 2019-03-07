package practice;

public class PalindromicString {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(count(input));
    }

    private static int count(String input) {
        int count = 0;
        if (input == null || input.length() == 0) return count;
        int len = input.length();
        boolean[][] cache = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            cache[i][i] = true;
            count++;
        }

        for (int i = 1; i < len; i++) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                cache[i - 1][i] = true;
                count++;
            }
        }

        for (int i = 2; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (cache[j + 1][i - 1] && input.charAt(j) == input.charAt(i)) {
                    cache[j][i] = true;
                    count++;
                }

            }
        }
        return count;
    }
}
