package hackerrank;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FormingMagicSquare {
    public static void main(String[] args) {
        int[][] in = new int[][]{
                {5, 4, 3},
                {1, 5, 8},
                {6, 4, 2}
        };

        //System.out.println(formingMagicSquare(in));
        System.out.println(ThreadLocalRandom.current().nextInt(0,10));

    }

    static int formingMagicSquare(int[][] s) {
        // find all unique number
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                uniqueNumbers.add(s[i][j]);
            }
        }
        ThreadLocalRandom.current().nextInt(0,10);

        return 0;
    }


    public static boolean isComplete(int[][] s) {
        int magicNumber = 15;
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                magicNumber -= s[i][j];
            }
        }
        if (magicNumber != 0)
            return false;

        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                //if (rcSum(i, j) != 15 || rcSum(j, i) != 15)
                  //  return false;
            }
        }
        return true;

    }


}
