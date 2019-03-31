package leetcode.contests.contest_129;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertToBaseTwo_1017 {
    ConvertToBaseTwo_1017 convertToBaseTwo;

    @BeforeEach
    public void init() {
        convertToBaseTwo = new ConvertToBaseTwo_1017();
    }

    @Test
    public void testForTwo() {
        int N=2;
        String result = baseNeg2(N);
        Assertions.assertEquals("110",result);
    }

    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int a = N;
        while (a != 0) {
            int result = a / (-2);
            int remainder = a % (-2);

            if (remainder < 0) {
                remainder = 2 + remainder;
                result++;
            }
            sb.append(remainder);
            a = result;
        }
        return sb.reverse().toString();
    }
}
