package practice;

import java.util.Arrays;

public class TrappingWater {
    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2};
        int[] input1=new int[]{3, 0, 0, 2, 0, 4};
        TrappingWater tw = new TrappingWater();
        System.out.println(tw.total(input));
        System.out.println(tw.total(input1));

    }

    public int total(int[] in) {
        int[] helper = new int[in.length];
        helper[0] = in[0];
        // move from left to right
        int curMaxLeft = in[0];
        for (int i = 0; i < in.length-1; i++) {
            if (in[i + 1] > curMaxLeft) {
                helper[i + 1] = in[i + 1];
                curMaxLeft = in[i + 1];

            } else {
                helper[i + 1] = curMaxLeft;
            }
        }
        //Arrays.stream(helper).forEach(d -> System.out.println(d));

        // move from right to left
        int curMaxRight = in[in.length - 1];
        helper[in.length - 1] = Math.max(in[in.length-1], helper[in.length - 1]);

        for (int i = in.length - 1; i > 0; i--) {
            if (in[i] > curMaxRight) {
                helper[i - 1] = Math.min(curMaxRight, helper[i - 1]);
                curMaxRight = in[i - 1];

            } else {
                helper[i - 1] = Math.min(curMaxRight, helper[i - 1]);
            }
        }

        int total = 0;
        for (int i = 0; i < helper.length; i++)
            total += helper[i] - in[i];
        return total;
    }
}
