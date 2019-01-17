package dailycodings;

import java.util.Arrays;

public class TripleProduct_628 {
    public static void main(String[] args) {
        int[] in = new int[]{-10, -10, 5, 2};
        Arrays.sort(in);
        System.out.println(product(in));
    }

    private static int product(int[] in) {
        //-10,-10,2,5
        int len = in.length - 1;
        int first = Math.max((in[len] * in[len - 1] * in[len - 2]),
                (in[0] * in[1] * in[2])
        );
        int second = Math.max(
                (in[0] * in[1] * in[len]),
                (in[0] * in[len - 1] * in[len])
        );
        return Math.max(first, second);
    }
}
