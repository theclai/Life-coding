package dailycodings;

import java.util.Arrays;

public class NextGreatestNumber {
    public static void main(String[] args) {
        int[] in1 = new int[]{2, 5, 1, 6, 7, 8};
        int[] in2 = new int[]{3, 2, 1};
        int[] in3 = new int[]{5, 3, 4, 9, 7, 6};
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
        if (isSortedAscending(in)) {
            swap(in, in.length - 2, in.length - 1);
            return in;
        }
        if (isSortedDescending(in))
            return new int[0];

        int i = in.length - 1;
        int j = i - 1;
        while (in[j] > in[i]) {
            j--;
        }
        swap(in, i, j);
        Arrays.sort(in, j, in.length);
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
