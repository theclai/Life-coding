package pramp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindDuplicates {
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        int i = 0;
        int j = 0;

        Set<Integer> set = new HashSet<Integer>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                set.add(arr1[i]);
                j++;
                i++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] op = new int[set.size()];
        int k = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            op[k] = (int) it.next();
            k++;
        }
        return op;
    }


    static int[] findDuplicatesAdvace(int[] a, int[] b) {
        int[] result = new int[10];
        for (int i = 0; i < a.length; i++) {
            int target = a[i];
            int[] op = findDuplicatesHelper(a, b, 0, b.length - 1, target);
            result[0] = op[0];
        }
        return result;
    }


    static int[] findDuplicatesHelper(int[] a, int[] b, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (b[mid] == target) {
            return new int[]{mid, b[mid]};
        }
        if (target < b[mid]) {
            return findDuplicatesHelper(a, b, start, mid - 1, target);
        } else {
            return findDuplicatesHelper(a, b, mid + 1, end, target);
        }

    }

    public static void main(String[] args) {
    }
}
