package leetcode.contests.contest_122;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EvenSum {
    int[] A;
    int[][] queries;
    EvenSum evenSum;

    @BeforeEach
    public void init() {
        evenSum = new EvenSum();
        A = new int[]{5, 4, 0, 2};
        queries = new int[][]{
                {1, 1}, {3, 1}, {3, 3}, {5, 1}
        };
    }

    @Test
    public void test() {
        Assertions.assertEquals(0, evenSum.sumEvenAfterQueries(A, queries)[3]);
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (A == null || A.length == 0) return new int[]{};
        if (queries == null || queries.length == 0) return A;
        int[] res = new int[queries.length];
        Set<Integer> evens = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evens.add(i);
                sum += A[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int val = q[0];
            int pos = q[1];
            int temp = A[pos] + val;
            if (temp % 2 == 0) {
                if (evens.contains(pos)) {
                    sum = sum - A[pos];
                    A[pos] = A[pos] + val;
                    sum += A[pos];
                    res[i] = sum;

                } else {
                    A[pos] += val;
                    evens.add(pos);
                    sum += A[pos];
                    res[i] = sum;
                }
            } else {
                if (evens.contains(pos)) {
                    sum -= A[pos];
                }
                res[i] = sum;
                A[pos] += val;
                evens.remove(pos);
            }
        }
        return res;
    }
}
