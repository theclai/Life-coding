package pramp;

import java.util.Arrays;

public class ArrayQuadruplet {
    /**
     * unsorted array
     * random quadruplet
     * <p>
     * 0 1 2 3  4 5 7 9
     * <p>
     * i=0;
     * j=7
     * <p>
     * s = 20 .. s=11 j--  j=6 counter = 1
     * s = 20 .. s=4 j--  j=5 counter = 2
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * while(i<j){
     * <p>
     * }
     */

    static int[] findArrayQuadruplet(int[] arr, int s) {
        if (arr.length < 4)
            return new int[0];

        int[] result = new int[4];
        // your code goes here
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                for (int k = j + 1; k < arr.length - 1; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        int tempSum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (tempSum == s)
                            result = new int[]{arr[i], arr[j], arr[k], arr[l]};
                    }

                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 4, 0, 9, 5, 1, 3};
        Arrays.sort(input);
        int[] res = findArrayQuadruplet(input, 20);
        Arrays.sort(res);

        int[] ad= findQuad(input, 20);
        Arrays.stream(ad).forEach(i->System.out.print(i+"->"));
    }

    private static int[] findQuad(int[] in, int s) {
        int len = in.length;
        if (len < 4)
            return new int[0];
        for (int i = 0; i < len - 4; i++) {
            for (int j = 0; j < len - 3; j++) {
                int r = s - (in[i] + in[j]);
                int low = j + 1;
                int high = len - 1;

                while (low < high) {
                    if(in[low]+in[high]<r)
                        low++;
                    else if(in[low]+in[high]<r)
                        high--;
                    else
                        return new int[]{in[i],in[j],in[low],in[high]};
                }

            }
        }
        return new int[0];
    }
}
