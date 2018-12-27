package coderbyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LookAndSay {
    LookAndSay ls;

    @BeforeEach
    public void init() {
        ls = new LookAndSay();
    }

    @Test
    public void test() {
        int n = 5;
        String result = ls.lookAndSay(n);
        Assertions.assertEquals("111221", result);
    }

    private String lookAndSay(int n) {

        if (n == 1) return "1";
        if (n == 2) return "11";
        int count = 1;
        String str = "11";


        for (int i = 3; i <= n; i++) {
            str += '$';
            char[] input = str.toCharArray();
            String temp="";

            for (int j = 1; j < str.length(); j++) {
                if (input[j] != input[j-1]) {
                    temp = temp + String.valueOf(count+0);
                    temp = temp + str.charAt(j - 1);
                    count=1;
                } else {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }
}
