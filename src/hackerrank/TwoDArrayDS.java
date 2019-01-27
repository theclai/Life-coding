package hackerrank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoDArrayDS {
    TwoDArrayDS twoDArrayDS;
    int[][] input;

    @BeforeEach
    public void inti() {
        input = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
    }

    @Test
    public void test() {
        int out=hourglassSum(input);

    }

    public int hourglassSum(int[][] input) {
        int[][] out = new int[input.length - 2][input[0].length-2];
        int max=-10000000;
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                max=Math.max(max,(input[i][j] + input[i][j + 1] + input[i][j + 2] +
                        input[i + 1][j + 1] +
                        input[i + 2][j] + input[i + 2][j + 1] + input[i + 2][j + 2]));
            }
        }



        return max;

    }
}
