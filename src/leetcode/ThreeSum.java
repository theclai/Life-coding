package leetcode;

import dp.LIS;

import java.util.*;

public class ThreeSum {
    public static final int TARGET = 0;

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = findThreeSum(input);
        System.out.println(threeSum.size());
    }

    private static List<List<Integer>> findThreeSum(int[] input) {
        Set<List<Integer>> op = new HashSet<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length - 2; j++) {
                int twoSum = input[i] + input[j];
                int k = j + 1;
                while (k < input.length) {
                    if (twoSum + input[k] == TARGET) {
                        List<Integer> l = new ArrayList<>();
                        l.add(input[i]);
                        l.add(input[j]);
                        l.add(input[k]);
                        Collections.sort(l);
                        op.add(l);
                    }
                    k++;
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        res.addAll(op);
        return res ;
    }
}
