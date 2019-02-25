package leetcode.contests.contest_125;

public class AvailableCapturesRook {
    static char[][] board;

    public static void main(String[] args) {
        board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        int[] rook = findRook(board);
        System.out.println("Row: " + rook[0] + "Col: " + rook[1]);
        int res = killPown(rook[0], rook[1]);
        System.out.println(res);
    }

    public static int killPown(int r, int c) {
        int n = moveNorth(r, c);
        System.out.println(n);
        int s = moveSouth(r, c);
        System.out.println(s);
        int e = moveEast(r, c);
        System.out.println(e);
        int w = moveWest(r, c);
        System.out.println(w);
        return (n + s + e + w);
    }

    private static int moveWest(int r, int c) {
        if (!inRange(r, c)) return 0;
        if (board[r][c] == 'p') return 1;
        return moveWest(r, c + 1);
    }

    private static int moveEast(int r, int c) {
        if (!inRange(r, c)) return 0;
        if (board[r][c] == 'p') return 1;
        return moveEast(r, c - 1);
    }

    private static int moveSouth(int r, int c) {
        if (!inRange(r, c)) return 0;
        if (board[r][c] == 'p') return 1;
        return moveSouth(r + 1, c);
    }

    private static int moveNorth(int r, int c) {
        if (!inRange(r, c)) return 0;
        if (board[r][c] == 'p') return 1;
        return moveNorth(r - 1, c);
    }


    private static boolean inRange(int r, int c) {
        if (r < 0 || c < 0 || r > 7 || c > 7) return false;
        if (board[r][c] == 'B') return false;
        return true;
    }

    public static int[] findRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') return new int[]{i, j};
            }
        }
        return null;
    }
}
