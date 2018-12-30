package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    LongestConsecutiveSequence mLongestConsecutiveSequence;

    @BeforeEach
    public void init() {
        mLongestConsecutiveSequence = new LongestConsecutiveSequence();
    }

    @Test
    public void test() {
        Assertions.assertEquals(4,mLongestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2}));

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        Arrays.stream(nums).forEach(val -> s.add(val));
        int len = 0;
        while (!s.isEmpty()) {
            int data = s.iterator().next();
            s.remove(data);
            //lower bound
            int lowerBound = data - 1;
            while (s.contains(lowerBound)) {
                s.remove(lowerBound);
                lowerBound = lowerBound - 1;
            }

            int upperBound = data + 1;
            while (s.contains(upperBound)) {
                s.remove(upperBound);
                upperBound = upperBound + 1;
            }

            len = Math.max(upperBound - lowerBound - 1, len);
        }
        return len;
    }
}
