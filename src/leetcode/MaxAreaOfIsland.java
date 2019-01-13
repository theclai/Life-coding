package leetcode;

public class MaxAreaOfIsland {
    int r;
    int c;
    int[][] mGrid;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.mGrid = grid;
        boolean[][] seen;
        int max = 0;
        r = grid.length;
        c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                seen = new boolean[grid.length][grid[0].length];
                max = Math.max(max, helper(i, j, seen));
            }
        }
        return max;

    }

    private int helper(int row, int col, boolean[][] seen) {
        if (row < 0 || row >= r || col < 0 || col >= c || seen[row][col] || mGrid[row][col] == 0) return 0;
        seen[row][col] = true;
        return (1 + helper(row + 1, col, seen) +
                helper(row, col + 1, seen) +
                helper(row - 1, col, seen) +
                helper(row, col - 1, seen));
    }
}
