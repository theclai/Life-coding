package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AliceBob {
    public static void main(String[] args) {
        int[] a = {35, 17, 4, 24, 10};
        int[] b = {63, 21};


        int[] op = findResult(a, b);
        System.out.println(op[0] + "," + op[1]);
    }

    private static int[] findResult(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int sA = IntStream.of(a).sum();
        int sB = IntStream.of(b).sum();
        int sum = IntStream.of(a).sum() + IntStream.of(b).sum();
        System.out.println("Sum: " + sum);
        int target = sum / 2;

        System.out.println("Target: " + target);

        int[] res = new int[2];
        for(int i=0;i<a.length;i++){
            int aSum = sA-a[i];
            for(int j=0;j<b.length;j++){
                if(aSum+b[j]==target){

                    res[0] = a[i];
                    res[1] = b[j];
                }
            }
        }



        return res;
    }

}
