package dailycodings;

import java.util.Arrays;

public class NextGreatestNumber {
    public static void main(String[] args) {
        int[] in1 = new int[]{1, 2, 3};
        int[] in2 = new int[]{3, 2, 1};
        int[] in3 = new int[]{4, 1, 5, 4};
        int[] res1 = compute(in1);
        Arrays.stream(res1).forEach(i -> System.out.print(i + "->"));
        System.out.println("");
        int[] res2 = compute(in2);
        Arrays.stream(res2).forEach(i -> System.out.print(i + "->"));
        System.out.println("");
        int[] res3 = compute(in3);
        Arrays.stream(res3).forEach(i -> System.out.print(i + "->"));

    }

    public static int[] compute(int[] in) {
        boolean isAscending = isSortedAscending(in);
        if (isAscending) {
            int temp = in[in.length - 1];
            in[in.length - 1] = in[in.length - 2];
            in[in.length - 2] = temp;
            return in;
        }

        if (isSortedDescending(in))
            return new int[0];


        int i = in.length - 1;


        while (in[i-1]>in[i]) {
            swap(in,i-1,i);
            i--;
        }

        swap(in,i,i-1);

        return in;
    }

    public static void swap(int[] in, int start, int end) {
        int temp = in[end];
        in[end] = in[start];
        in[start] = temp;

    }

    private static boolean isSortedAscending(int[] in) {
        for (int i = 1; i < in.length; i++) {
            if (in[i] < in[i - 1])
                return false;
        }
        return true;
    }

    private static boolean isSortedDescending(int[] in) {
        for (int i = 1; i < in.length; i++) {
            if (in[i] > in[i - 1])
                return false;
        }
        return true;
    }
}
