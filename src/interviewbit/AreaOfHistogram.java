package interviewbit;


import java.util.Stack;

public class AreaOfHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(getMaxRect(heights));
    }

    public static int getMaxRect(int[] height) {
        int max = -1;
        int curMax = 0;
        if (height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < height.length) {
            // stack is empty or
            // current height is greater or equal previous
            // add to stack
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // current hts is smaller than the previous
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;// get the width
                max = Math.max(h * w, max);
            }
        }
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }
}
