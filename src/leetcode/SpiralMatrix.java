package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int m = matrix.length;
        int n = matrix[0].length;
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                //System.out.print(matrix[k][i] + " ");
                list.add(matrix[k][i]);
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                //System.out.print(matrix[i][n - 1] + " ");
                list.add(matrix[i][n - 1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    //System.out.print(matrix[m - 1][i] + " ");
                    list.add(matrix[m - 1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    //System.out.print(matrix[i][l] + " ");
                    list.add(matrix[i][l]);
                }
                l++;
            }
        }
        return list;
    }
}
