package dailycodings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindingElementInRotatedAndSortedArray {
    FindingElementInRotatedAndSortedArray findingElementInRotatedAndSortedArray;

    @BeforeEach
    public void init() {
        findingElementInRotatedAndSortedArray = new FindingElementInRotatedAndSortedArray();
    }

    @Test
    public void test() {
        int[] in = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int m = findingElementInRotatedAndSortedArray.binarySearch(in, 2);
        System.out.println(m);
    }

    private int binarySearch(int[] arr, int key) {
        int pivot = findPivot(arr, 0, arr.length);
        if (pivot == -1)
            return search(arr, 0, arr.length, key);

        // If we found a pivot, then first compare with pivot
        // and then search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;

        if (arr[0] <= key)
            return search(arr, 0, pivot - 1, key);
        return search(arr, pivot + 1, arr.length, key);
    }

    private int search(int[] in, int start, int end, int target) {
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (in[mid] == target) return mid;
            if (in[mid] > target)
                end = mid;
            if (in[mid] < target)
                start = mid;
        }
        return -1;
    }

    public int findPivot(int[] in, int start, int end) {
        if (end < start) return -1;
        if (start == end) return start;
        int mid = start + (end - start) / 2;
        if (in[mid] > in[mid + 1] || in[mid] < in[mid - 1])
            return mid;
        if (in[start] >= in[mid])
            return findPivot(in, start, mid - 1);
        return findPivot(in, mid + 1, end);
    }
}
