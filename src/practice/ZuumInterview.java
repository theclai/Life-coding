package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZuumInterview {
// Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

// 1   2   4
//  \ /   / \
//   3   5   8
//    \ / \   \
//     6   7   10

// Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

// Sample output (pseudodata):
// [
//   [1, 2, 4],   // Individuals with zero parents
//   [5, 7, 8, 10] // Individuals with exactly one parent
// ]


    /***
     3> 1+1
     6>1+1

     O(N)

     O(N)


     */
    /**
     * Map to hold number of parents and number of childs
     */
    static HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();

    //counter for counting the number of parents
    static HashMap<Integer, Integer> counter = new HashMap<>();


    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };

        List<List<Integer>> output = solve(parentChildPairs);

        System.out.println(output.size());

        for (int i = 0; i < output.size(); i++) {
            List list = output.get(i);

            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + "->");
            }

            System.out.println("");
        }

        // run 2


        int[][] parentChildPairs2 = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}
        };

        List<List<Integer>> output2 = solve(parentChildPairs2);


        for (int i = 0; i < output2.size(); i++) {
            List list = output2.get(i);

            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + "->");
            }

            System.out.println("");
        }

    }

    public static List<List<Integer>> solve(int[][] pairs) {
        updateCounter(pairs);

        System.out.println(counter.size());

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            System.out.println("Key: " + key);
            int val = entry.getValue();
            System.out.println("Value: " + val);


            if (val == 0) {
                if (result.containsKey(val)) {
                    result.get(val).add(key);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(key);
                    result.put(0, list);
                }
            }

            if (val == 1) {
                if (result.containsKey(val)) {
                    result.get(val).add(key);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(key);
                    result.put(1, list);
                }
            }
        }

        System.out.println("Result: " + result.size());
        List<List<Integer>> output = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> e : result.entrySet()) {
            ArrayList<Integer> val = e.getValue();
            output.add(val);
        }

        result.clear();
        counter.clear();
        return output;

    }

    public static void updateCounter(int[][] input) {
        if (input.length == 0)
            return;

        for (int i = 0; i < input.length; i++) {
            int[] arr = input[i];

            if (counter.containsKey(arr[1])) {
                counter.put(arr[1], counter.get(arr[1]) + 1);
            } else {
                counter.put(arr[1], 1);
            }
        }


        for (int i = 0; i < input.length; i++) {
            int[] arr = input[i];

            if (!counter.containsKey(arr[0])) {
                counter.put(arr[0], 0);
            } else {
                //counter.put(arr[0],counter.get(a0);
            }
        }


        System.out.println(counter);
    }
}



