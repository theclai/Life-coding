package pramp;

import java.util.Arrays;
import java.util.HashMap;

public class MergingBags {

    /**
     * Time Complexity: O(N)
     * Space complexity: O(N)
     */
    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        if (arr == null || arr.length == 0)
            return new int[0];
        HashMap<Integer, Integer> tracker = new HashMap<>(arr.length);

        //n
        for (int i = 0; i < arr.length; i++) {
            tracker.put(arr[i], i);
        }
        //n
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int diff = limit - val;
            if (tracker.containsKey(diff)) {
                int j = tracker.get(diff);
                return new int[]{j, i};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
