package hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JumpingOnTheCloudRevisited {
    JumpingOnTheCloudRevisited jumpingOnTheCloudRevisited;

    @BeforeEach
    public void init() {
        jumpingOnTheCloudRevisited = new JumpingOnTheCloudRevisited();
    }

    @Test
    public void first_test_positive() {
        int[] input = new int[]{0, 0, 1, 0};
        int k = 2;
        int energy = jumpingOnTheCloudRevisited.jumpingOnClouds(input, k);
        Assertions.assertEquals(96, energy);
    }

    @Test
    public void second_test_positive() {
        int[] input = new int[]{0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        int energy = jumpingOnTheCloudRevisited.jumpingOnClouds(input, k);
        Assertions.assertEquals(92, energy);
    }

    public int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        if (c == null || c.length == 0) return energy;
        int start = 0;
        int end = -1;
        while (start != end) {
            start += k;
            if (start >= c.length)
                start -= start;
            if (c[start] == 1)
                energy -= 3;
            else
                energy -= 1;
            end = 0;
        }
        return energy;
    }
}
