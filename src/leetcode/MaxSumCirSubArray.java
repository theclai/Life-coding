package leetcode;

/**
 * 1 -2 3 -2 1 -2 3
 */
public class MaxSumCirSubArray {
    public static void main(String[] args) {


    }

    public static int maxSubArraySumCircular(int[] A) {
        int S = 0;
        for (int x : A)
            S += x;

        int ans1 = kadane(A, 0, A.length - 1, 1);
        int ans2 = S + kadane(A, 1, A.length - 1, -1);
        int ans3 = S + kadane(A, 0, A.length - 2, -1);
        return Math.max(ans1,Math.max(ans2,ans3));
    }

    private static int kadane(int[] A, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * A[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
