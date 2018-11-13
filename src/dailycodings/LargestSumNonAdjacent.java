package dailycodings;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * <p>
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10,
 * since we pick 5 and 5.
 * <p>
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class LargestSumNonAdjacent {
    public static void main(String[] args) {
        //int[] input = new int[]{5, 1, 1, 5};
        int[] input = new int[]{ 2, 4, 6, 2, 5};

        System.out.println(findLargest(input));
    }

    private static int findLargest(int[] input) {
        int maxInclude = input[0];
        int maxExclude = 0;
        for (int i = 1; i < input.length; i++) {
            int newExclude = Math.max(maxExclude, maxInclude);
            maxInclude = maxExclude + input[i];
            maxExclude = newExclude;
        }
        return Math.max(maxExclude, maxInclude);
    }
}
