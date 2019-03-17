package leetcode.contests.contest_128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplementBase {
    ComplementBase cb;

    @BeforeEach
    public void init() {
        cb = new ComplementBase();
    }

    @Test
    public void first_complementbase() {
        int res = cb.bitwiseComplement(5);
        Assertions.assertEquals(2, res);
    }

    @Test
    public void second_complementbase() {
        int res = cb.bitwiseComplement(5);
        Assertions.assertEquals(2, res);
    }

    @Test
    public void third_complementbase() {
        int res = cb.bitwiseComplement(10);
        Assertions.assertEquals(5, res);
    }

    public int bitwiseComplement(int N) {
        if(N<0)return 0;
        String str = Integer.toBinaryString(N);
       // System.out.println("Input in Binary: " + str);
        StringBuilder sb = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }

        String comStr = sb.toString();
        //System.out.println(comStr);

        int i = Integer.parseInt(comStr, 2);
        //System.out.println("Output: " + i);
        return i;
    }
}
