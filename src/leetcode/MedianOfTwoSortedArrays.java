package leetcode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3};
        int[] c;
        c = merge(a, b);
        int len = c.length;
        int rem = len % 2;
        int qu = len / 2;
        if (rem == 0) {
            double output = (double) (c[qu - 1] + c[qu]) / 2;
            System.out.print(output);
        } else {

            System.out.print((double)c[qu]);
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int aLength = a.length;
        int bLength = b.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aLength && j < bLength) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else if (a[i] > b[j]) {
                res[k] = b[j];
                k++;
                j++;
            } else {
                res[k] = a[i];
                k++;
                i++;
                res[k] = b[j];
                k++;
                j++;
            }
        }
        while (j < bLength) {
            res[k] = b[j];
            j++;
            k++;
        }

        while (i < aLength) {
            res[k] = a[i];
            i++;
            k++;
        }
        return res;
    }

    private static void printArray(int[] res, String after_partial_merger) {
        System.out.println(after_partial_merger);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
