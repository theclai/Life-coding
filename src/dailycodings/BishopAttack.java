package dailycodings;

public class BishopAttack {
    /**
     * Chase board in a 2D array
     */
    static char[][] board;
    /**
     * Number of row and col
     */
    static int m = 5;
    /**
     * Position of the bishop
     */
    static int[][] positions;

    public static void main(String[] args) {
        board = new char[][]{
                {'b', '0', '0', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'b', '0', 'b', '0', '0'}
        };
        positions = new int[][]{
                {0, 0},
                {1, 2},
                {2, 2},
                {4, 0}
        };
        System.out.println(findTotalAttack(board, positions, m));
    }

    private static int findTotalAttack(char[][] board, int[][] positions, int m) {
        int total = 0;
        for (int i = 0; i < positions.length; i++) {
            int[] val = positions[i];
            int r = val[0];
            int c = val[1];
            total = total + moveTopLeft(r, c, board) +
                    moveTopRight(r, c, board) +
                    moveDownRight(r, c, board) +
                    moveDownLeft(r, c, board);
        }
        return total;
    }

    private static int moveDownLeft(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';

            r++;
            c--;
        }
        return attack;
    }

    private static int moveDownRight(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';

            r++;
            c++;
        }
        return attack;
    }

    private static int moveTopRight(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';

            r--;
            c++;
        }
        return attack;
    }

    private static int moveTopLeft(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';
            r--;
            c--;
        }
        return attack;
    }
}
