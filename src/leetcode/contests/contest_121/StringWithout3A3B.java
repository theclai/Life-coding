package leetcode.contests.contest_121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringWithout3A3B {
    StringWithout3A3B sw;

    @BeforeEach
    public void init() {
        sw = new StringWithout3A3B();

    }

    @Test
    public void testFirst() {
        String str = sw.strWithout3a3b(4, 1);
        Assertions.assertEquals("aabaa", str);
    }

    @Test
    public void testSecond() {
        String str = sw.strWithout3a3b(1, 2);
        System.out.println("second: "+str);
    }

    @Test
    public void testThird() {
        String str = sw.strWithout3a3b(1, 3);
        Assertions.assertEquals("bbab", str);
        System.out.println("third: "+str);
    }

    @Test
    public void testFourth() {
        String str = sw.strWithout3a3b(2, 5);
        Assertions.assertEquals("bbabbab", str);
        System.out.println("fourth: "+str);
    }

    @Test
    public void testFifth() {
        String str = sw.strWithout3a3b(4, 7);
        System.out.println(str);
        Assertions.assertEquals("bbabbababab", str);
        System.out.println("fifth: "+str);
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        helper(sb,A,B);
        return sb.toString();

    }

    public void helper(StringBuilder sb, int x, int y) {
        int i = 0, j = 0;
        while (x - i != y - j) {
            if (x > y) {
                int count = 0;
                while (i < x && count < 2) {
                    sb.append("a");
                    i++;
                    count++;
                }
                count = 0;
                while (j < y && count < 1) {
                    sb.append("b");
                    j++;
                    count++;
                }

            } else {
                int count = 0;
                while (j < y && count < 2) {
                    sb.append("b");
                    j++;
                    count++;
                }
                 count = 0;
                while (i < x && count < 1) {
                    sb.append("a");
                    i++;
                    count++;
                }
            }
        }
        if(sb.toString().endsWith("a")){
            while (i<x ||j<y){
                sb.append("b");
                sb.append("a");
                i++;
                j++;

            }
        }else{
            while (i<x ||j<y){
                sb.append("a");
                sb.append("b");
                i++;
                j++;

            }
        }

    }

}
