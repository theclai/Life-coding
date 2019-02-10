package leetcode.contests.contest_123;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenCalculator {
    BrokenCalculator bc;
    @BeforeEach
    public void init() {
        bc = new BrokenCalculator();
    }

    @Test
    public void test_first() {
        Assertions.assertEquals(2, bc.brokenCalc(2, 3));

    }

    @Test
    public void test_second() {
        Assertions.assertEquals(2, bc.brokenCalc(5, 8));
    }


    @Test
    public void test_third() {
        Assertions.assertEquals(1023, bc.brokenCalc(1024, 1));
    }

    @Test
    public void test_fifth() {
        System.out.println(bc.brokenCalc(1,
                1000000000));

    }

    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }
        return ans + X - Y;
    }
}
