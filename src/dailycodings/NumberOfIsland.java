package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOfIsland {
    NumberOfIsland island;
    static int[][] in;
    static int[][] path;

    @BeforeEach
    public void init() {
        in = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        path = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        island = new NumberOfIsland();
    }

    @Test
    public void countIslandTesst() {
        Assertions.assertEquals(4, island.numberOfIsland(in));
    }

    private int numberOfIsland(int[][] in) {
        int total = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                if (in[i][j] == 1) {
                    helper(in, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    private void helper(int[][] in, int r, int c) {
        if (r < 0 || r >= 6 || c < 0 || c >= 5 || in[r][c] == 0 || in[r][c] == 2)
            return;
        in[r][c] = 2;
        for (int i = 0; i < path.length; i++) {
            int[] p = path[i];
            helper(in, r + p[0], c + p[1]);
        }
    }
}
