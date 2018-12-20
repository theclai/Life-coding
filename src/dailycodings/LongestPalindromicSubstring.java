package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    LongestPalindromicSubstring lps;

    public String find(String in) {
        char[] chars = in.toCharArray();
        int len = chars.length;
        if(len==0)
            return "";
        int maxLength = 0;
        int maxPosition = 0;
        int[][] cache = new int[chars.length][chars.length];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (chars[i] == chars[len - j - 1]) {
                    if (i > 0 && j > 0)
                        cache[i][j] = cache[i - 1][j - 1] + 1;
                    else
                        cache[i][j] = 1;

                    if (cache[i][j] > maxLength) {
                        maxLength = cache[i][j];
                        maxPosition=i;
                    }
                } else {
                    if (j==0)
                        cache[i][j] = cache[i - 1][j];
                    else if(i==0)
                        cache[i][j] = cache[i][j-1];
                    else
                        cache[i][j] = 0;
                }
            }

        }
        System.out.println(maxLength);
        System.out.println(maxPosition);
        return in.substring(maxPosition+1-maxLength,maxPosition+1);

    }

    @BeforeEach
    public void init() {
        lps = new LongestPalindromicSubstring();
    }
    @Test
    public void firstTest() {
        Assertions.assertEquals("anana", lps.find("bananas"));
    }
    @Test
    public void secondTest() {
        Assertions.assertEquals("", lps.find(""));
    }

    @Test
    public void thirdTest() {
        Assertions.assertEquals("a", lps.find("abcda"));
    }
}
