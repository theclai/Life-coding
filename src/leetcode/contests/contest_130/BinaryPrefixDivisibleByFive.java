package leetcode.contests.contest_130;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryPrefixDivisibleByFive {
    BinaryPrefixDivisibleByFive binaryPrefixDivisibleByFive;

    @BeforeEach
    public void init() {
        binaryPrefixDivisibleByFive = new BinaryPrefixDivisibleByFive();
    }

    @Test
    public void fistBinaryPrefixDivisibleByFive() {
        List<Boolean> result = binaryPrefixDivisibleByFive.prefixesDivBy5(new int[]{0, 1, 1});
        Assertions.assertEquals(Arrays.asList(true, false, false), result);
    }

    @Test
    public void secondBinaryPrefixDivisibleByFive() {
        List<Boolean> result = binaryPrefixDivisibleByFive.prefixesDivBy5(new int[]{1, 1, 1});
        Assertions.assertEquals(Arrays.asList(false, false, false), result);
    }

    @Test
    public void thirdBinaryPrefixDivisibleByFive() {
        List<Boolean> result = binaryPrefixDivisibleByFive.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1});
        Assertions.assertEquals(Arrays.asList(true, false, false, false, true, false), result);
    }

    @Test
    public void fourthBinaryPrefixDivisibleByFive() {
        List<Boolean> result = binaryPrefixDivisibleByFive.prefixesDivBy5(new int[]{1, 1, 1, 0, 1});
        Assertions.assertEquals(Arrays.asList(false, false, false, false, false), result);
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        int remainder = 0;
        for (int a : A) {
            remainder = ((remainder << 1) + a) % 5; //new number=oldNumer*2+d;
            result.add(remainder == 0);
        }
        return result;
    }
}
