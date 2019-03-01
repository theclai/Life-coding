package hackerrank;

import java.text.DecimalFormat;

public class PlusMinus {
    public static void main(String[] args) {

        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }

    static void plusMinus(int[] arr) {
        int pos = 0;
        int neg = 0;
        int zeros = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                pos++;
            } else if (arr[i] == 0) {
                zeros++;
            } else {
                neg++;
            }
        }
        double posResult = (double) pos / len;
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(posResult));
        double negResult = (double) neg / len;
        System.out.println(df.format(negResult));
        double zeroResult = (double) zeros / len;
        System.out.println(df.format(zeroResult));
    }
}
