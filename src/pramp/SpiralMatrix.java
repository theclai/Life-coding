package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    static int[] spiralCopy(int[][] in) {
        // your code goes here
        int topRow = 0;
        int bottomRow = 3;

        int leftCol = 0;
        int rightCol = 4;


        List<Integer> list = new ArrayList<Integer>();
        while (topRow <= bottomRow && leftCol <= rightCol) {

            moveRight(in, topRow, leftCol, rightCol, list);
            topRow++;

            moveDown(in, rightCol, topRow, bottomRow, list);
            rightCol--;

            if (topRow <= bottomRow)
                moveLeft(in, bottomRow, rightCol, leftCol, list);
            bottomRow--;

            if (leftCol <= rightCol)
                moveUp(in, leftCol, bottomRow, topRow, list);
            leftCol++;

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void moveRight(int[][] in, int topRow, int leftCol, int rightCol, List<Integer> op) {
        for (int i = leftCol; i <= rightCol; i++) {
            op.add(in[topRow][i]);
        }
    }

    public static void moveDown(int[][] in, int rightCol, int topRow, int bottomRow, List<Integer> op) {
        for (int i = topRow; i <= bottomRow; i++) {
            op.add(in[i][rightCol]);
        }
    }

    public static void moveLeft(int[][] in, int bottomRow, int rightCol, int leftCol, List<Integer> op) {
        for (int i = rightCol; i >= leftCol; i--) {
            op.add(in[bottomRow][i]);
        }
    }

    public static void moveUp(int[][] in, int leftCol, int bottomRow, int topRow, List<Integer> op) {
        for (int i = bottomRow; i >= topRow; i--) {
            op.add(in[i][leftCol]);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[] result = spiralCopy(input);
        Arrays.stream(result).forEach(i -> System.out.println(i));

    }
}
