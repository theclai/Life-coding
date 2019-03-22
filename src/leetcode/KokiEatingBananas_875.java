package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KokiEatingBananas_875 {
    KokiEatingBananas_875 kokiEatingBananas_875;

    @BeforeEach
    public void init() {
        kokiEatingBananas_875 = new KokiEatingBananas_875();
    }

    @Test
    public void first_minEatingSpeed_positive() {
        int res = kokiEatingBananas_875.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        Assertions.assertEquals(4, res);
    }

    @Test
    public void second_minEatingSpeed_positive() {
        int res = kokiEatingBananas_875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        Assertions.assertEquals(30, res);
    }

    @Test
    public void third_minEatingSpeed_positive() {
        int res = kokiEatingBananas_875.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
        Assertions.assertEquals(23, res);
    }

    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }
}
