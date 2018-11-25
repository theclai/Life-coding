package coderbyte;

import java.util.Arrays;

public class DuplicatesInArray {
    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 1, 3, 6, 6};
        findDuplicates(in);
    }

    private static void findDuplicates(int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[Math.abs(in[i])] >= 0) {
                in[Math.abs(in[i])] = -1 * in[Math.abs(in[i])];
            } else {
                System.out.println(Math.abs(in[i]));
            }
        }
        Arrays.stream(in).forEach(i -> System.out.println(i));
    }
}
