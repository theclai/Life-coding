package com.practice;

public class MaxProductInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,  2,  3},
                { 4,  5, 6},
                { 7,  8,  9}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println(maxProduct(matrix, row - 1, col - 1));
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
