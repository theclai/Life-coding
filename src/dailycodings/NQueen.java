package dailycodings;

public class NQueen {
    static int N=8;
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        NQueen nq = new NQueen();
        nq.solve(board);

        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]+" ");

            }
            System.out.println();
        }

    }

    public void solve(int[][] board) {
        queenHelper(board, 0, 0);

    }

    private boolean queenHelper(int[][] board, int r, int col) {
        if (col >= N)
            return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < N; i++)
        {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isCollisionFree(board, i, col))
            {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (queenHelper(board, 0,col + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
    }

    public boolean isCollisionFree(int[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<8; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}
