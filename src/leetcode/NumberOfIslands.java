package leetcode;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(input);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int num = 0;
        int row = grid.length;
        if(row==0) return 0;
        int col = grid[0].length;
        if(col==0) return 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j);
                    num = num + 1;
                }

            }
        }
        return num;
    }

    private static void visit(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            visit(grid, i + 1, j);
            visit(grid, i - 1, j);
            visit(grid, i, j + 1);
            visit(grid, i, j - 1);
        }
    }
}
