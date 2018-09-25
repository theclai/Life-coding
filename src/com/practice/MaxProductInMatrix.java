package com.practice;

public class MaxProductInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-1, 2, 3},
                {4, 5, -6},
                {7, 8, 9}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println(maxProduct(matrix, row - 1, col - 1));
        System.out.println(maxProductAdvance(matrix));
    }

    private static int maxProductAdvance(int[][] matrix) {
        // We need two caches to process negative number.
        int[][] minCache = new int[matrix.length][matrix[0].length];
        int[][] maxCache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    minCache[i][j] = matrix[i][j];
                    maxCache[i][j] = matrix[i][j];
                }
            }
        }
        return maxCache[matrix.length][matrix[0].length];
    }

    private static int maxProduct(int[][] matrix, int row, int col) {
        if (row == 0 && col == 0) {
            return matrix[row][col];
        }
        //Basically we need to move left and up;
        if (row >= 0 && col >= 0) {
            return Math.max(matrix[row][col] * maxProduct(matrix, row - 1, col),
                    matrix[row][col] * maxProduct(matrix, row, col - 1));
        }
        return 0;
    }
}
