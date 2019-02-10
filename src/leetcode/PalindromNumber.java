package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromNumber {
    PalindromNumber palindromNumber;

    @BeforeEach
    public void init() {
        palindromNumber = new PalindromNumber();
    }

    @Test
    public void test_first() {
        Assertions.assertEquals(true,palindromNumber.isPalindrome(121));
    }
    @Test
    public void test_second() {
        Assertions.assertEquals(false,palindromNumber.isPalindrome(-121));
    }
    @Test
    public void test_third() {
        Assertions.assertEquals(true,palindromNumber.isPalindrome(1001));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = 0;
        int rem = x;
        while (rem / 10 != 0) {
            int t = rem % 10;
            rem = rem / 10;
            temp = temp * 10 + t;
        }
        temp = temp * 10 + rem;
        if (x != temp)
            return false;
        return true;
    }
}
