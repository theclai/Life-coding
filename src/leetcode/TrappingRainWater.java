package leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int totalAmount = 0;
        if (height == null || height.length == 0) return totalAmount;

        int[] leftHighest = new int[height.length + 1];
        leftHighest[0] = 0;

        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            leftHighest[i + 1] = Math.max(leftHighest[i], h);
        }

        int rightHighest = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int h = height[i];
            rightHighest = Math.max(rightHighest, h);
            totalAmount += Math.min(rightHighest, leftHighest[i]) > h ?
                    Math.min(rightHighest, leftHighest[i]) - h : 0;
        }
        return totalAmount;
    }
}
