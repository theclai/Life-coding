package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulations {
    static long arrayManipulation(int n, int[][] queries) {
        long max = Integer.MIN_VALUE;
        long[] D = new long[n + 1];
        long[] A = new long[n];
        D[0] = A[0];
        D[n] = 0L;
        for (int i = 1; i < n; i++)
            D[i] = A[i] - A[i - 1];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int a = q[0];
            int b = q[1];
            int k = q[2];
            update(D, a - 1, b - 1, k);
        }

        for (int i = 0; i < A.length; i++) {

            if (i == 0)
                A[i] = D[i];
            else {
                A[i] = D[i] + A[i - 1];
                if (A[i] > max)
                    max = A[i];
            }
        }
        return max;
    }

    static void update(long D[], int l, int r, int x) {
        D[l] += x;
        D[r + 1] -= x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}


