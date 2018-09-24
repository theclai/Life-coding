package dp;

public class TargetSum {
    public static void main(String[] args) {
        int[] in = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSum(in, in.length, target);
    }

    private static void findTargetSum(int[] in, int length, int target) {
        int naiveOutput = naiveImplementation(in, 0, 0, target);
        System.out.println("Result of the naive implementation: " + naiveOutput);
    }

    private static int naiveImplementation(int[] in, int currentPosition, int sum, int target) {
        // When we’ve gone through every item, see
        // if we’ve reached our target sum
        if (currentPosition == in.length) {
            return sum == target ? 1 : 0;
        }
        if (currentPosition < in.length) {
            return naiveImplementation(in, (currentPosition + 1), (sum + in[currentPosition]), target) +
                    naiveImplementation(in, (currentPosition + 1), (sum - in[currentPosition]), target);
        }
        return sum;
    }
}
