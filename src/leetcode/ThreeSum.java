package leetcode;

import java.util.*;

public class ThreeSum {
    public static final int TARGET = 0;

    public static void main(String[] args) {
        //int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        int[] input = new int[]{0, 0, 0};
        List<List<Integer>> threeSum = findThreeSum(input);
        System.out.println(threeSum.size());
    }

    private static List<List<Integer>> findThreeSum(int[] input) {
        Set<List<Integer>> op = new HashSet<>();
        if (input.length == 3) {
            int tSum = input[0] + input[1] + input[2];
            if (tSum == 0) {
                List<Integer> l = new ArrayList<>();
                l.add(input[0]);
                l.add(input[1]);
                l.add(input[2]);
                Collections.sort(l);
                op.add(l);
            }
            List<List<Integer>> res = new ArrayList<>();
            res.addAll(op);
            return res;
        }

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
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(op);
        return res;
    }


    public static List<List<Integer>> findThreeSumBetter(int[] num) {
        Arrays.sort(num);
        LinkedList<List<Integer>> ret = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;

            while (start < end) {
                if (num[i] + num[start] + num[end] == 0) {
                    LinkedList<Integer> oneResult = new LinkedList<>();
                    oneResult.add(num[i]);
                    oneResult.add(num[start]);
                    oneResult.add(num[end]);
                    set.add(oneResult);
                    start++;
                    end--;
                } else {
                    if (num[i] + num[start] + num[end] < 0)
                        start++;
                    else
                        end--;
                }
            }
        }
        ret.addAll(set);
        return ret;

    }
}
