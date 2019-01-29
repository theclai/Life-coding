package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DailyCoding_86 {
    DailyCoding_86 dc;

    @BeforeEach
    public void init() {
        dc = new DailyCoding_86();
    }

    @Test
    public void testFirst() {
        Assertions.assertEquals(1, dc.find("())"));
    }

    @Test
    public void testSecond() {
        Assertions.assertEquals(3, dc.find("((("));
    }

    @Test
    public void testThird() {
        Assertions.assertEquals(0, dc.find("((()))"));
    }

    @Test
    public void testFourth() {
        Assertions.assertEquals(1, dc.find("()())()"));
    }

    @Test
    public void testFifth() {
        Assertions.assertEquals(2, dc.find(")("));
    }


    public int find(String in) {
        int total = 1;
        int tailIndex = 0;
        char[] input = in.toCharArray();
        for (int i = 1; i < in.length(); i++) {
            if (input[i] == ')' && tailIndex >= 0 && input[tailIndex] == '(') {
                tailIndex--;
                total--;
            } else if (input[i] == '(') {
                total++;
                tailIndex = i;
            } else if (input[i] == ')' && tailIndex >= 0 && input[tailIndex] != '(') {
                total++;
                tailIndex = i;
            } else
                total++;
        }
        return total;
    }
}
