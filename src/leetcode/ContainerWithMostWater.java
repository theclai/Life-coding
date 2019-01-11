package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ContainerWithMostWater {
    ContainerWithMostWater c;

    @BeforeEach
    public void init() {
        c = new ContainerWithMostWater();
    }

    @Test
    public void testFirst() {
        c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
