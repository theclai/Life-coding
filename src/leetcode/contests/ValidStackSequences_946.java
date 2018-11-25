package leetcode.contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidStackSequences_946 {
    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};

        //int[] push = new int[]{1, 2, 3, 4, 5};
        //int[] pop = new int[]{4, 3, 5, 1, 2};

        //int[] push = new int[]{1, 0};
        //int[] pop = new int[]{1, 0};
        System.out.println(validateStackSequences(push, pop));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0 || popped.length==0)
            return true;
        int j = 0;
        int i = 0;

        List<Integer> push = new ArrayList<>();
        Arrays.stream(pushed).forEach(data -> push.add(data));

        List<Integer> pop = new ArrayList<>();
        Arrays.stream(popped).forEach(d -> pop.add(d));

        while (j < pop.size() && i < push.size()) {
            if (push.get(i) == pop.get(j)) {
                push.remove(i);
                j++;
                if (i > 0)
                    i--;
            } else {
                i++;
            }
            if (j == pop.size() && i <= 0) {
                return true;
            }

        }
        return false;

    }
}
