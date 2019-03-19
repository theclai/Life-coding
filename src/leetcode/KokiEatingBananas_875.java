package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

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
        int sum = Arrays.stream(piles).sum();
        int res = sum / H;
        int rem = sum % H;
        int speed = 0;
        if (rem >= 0)
            speed = res + 1;
        else
            speed = res;
        int hour = Integer.MAX_VALUE;
        while (hour != H) {
            hour = Math.min(hour, computeSpeed(piles, speed));
            System.out.println("Speed: " + speed);
            speed++;
        }
        return speed - 1;

    }

    private int computeSpeed(int[] piles, int speed) {
        int[] pile = Arrays.copyOf(piles, piles.length);
        int i = 0;
        int hour = 0;
        while (i < pile.length) {
            int item = pile[i];
            if (item <= speed) {
                i++;
            } else {
                pile[i] = item - speed;
            }
            hour++;
        }
        return hour;
    }
}
