package leetcode.contests.contest_128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CapacityToShipPackage {
    CapacityToShipPackage capacityToShipPackage;

    @BeforeEach
    public void init() {
        capacityToShipPackage = new CapacityToShipPackage();
    }

    @Test
    public void first_mincapacity_ship_positive() {
        int res = capacityToShipPackage.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        Assertions.assertEquals(15, res);
    }

    @Test
    public void second_mincapacity_ship_positive() {
        int res = capacityToShipPackage.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        Assertions.assertEquals(6, res);
    }

    @Test
    public void third_mincapacity_ship_positive() {
        int res = capacityToShipPackage.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
        Assertions.assertEquals(3, res);
    }

    @Test
    public void fourth_mincapacity_ship_positive() {
        int res = capacityToShipPackage.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        Assertions.assertEquals(55, res);
    }

    public int shipWithinDays(int[] weights, int D) {
        int sum = Arrays.stream(weights).sum();
        System.out.println(sum);
        int min = sum / D;
        //System.out.println(min);
        int res = -1;
        while (res == -1) {
            res = helper(min, weights, D);
            System.out.println(res);
            if (res >= 0) return min;
            else
                min += 1;
        }
        return min;
    }

    private int helper(int min, int[] weights, int D) {
        int d = 0;
        int i = 0;
        int temp = 0;
        while (i < weights.length) {
            int item = weights[i];
            if (item > min) {
                d++;
                weights[i] -= min;
            } else {
                temp += item;
                if (temp > min) {
                    d++;
                    temp = 0;
                } else {
                    i++;
                }
            }

        }
        if (d + 1 <= D) return min;
        return -1;
    }
}
