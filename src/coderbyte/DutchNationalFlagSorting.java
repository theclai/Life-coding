package coderbyte;
/**
 * For this problem, your goal is to sort an array of 0, 1 and 2's
 * but you must do this in place, in linear time and without any extra
 * space (such as creating an extra array). This is called the Dutch
 * national flag sorting problem. For example, if the input array is
 * [2,0,0,1,2,1] then your program should output [0,0,1,1,2,2] and the
 * algorithm should run in O(n) time.
 */

import java.util.Arrays;

/**
 * (1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
 * (2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
 * (3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
 * (4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
 * (5) If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.
 * */
public class DutchNationalFlagSorting {
    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 0, 1, 2, 1};
        int[] result=sort(input);
        Arrays.stream(result).forEach(out->System.out.println(out));
    }

    private static int[] sort(int[] arr) {
        int low=0;
        int mid = 0;
        int high = arr.length - 1;

        // one pass through the array swapping
        // the necessary elements in place
        while (mid <= high) {
            if      (arr[mid] == 0) { swap(arr, low++, mid++); }
            else if (arr[mid] == 2) { swap(arr, mid, high--); }
            else if (arr[mid] == 1) { mid++; }
        }
        return arr;
    }

    private static void swap(int[] input, int start, int end) {
        int data=input[end];
        input[end]=input[start];
        input[start]=data;
    }
}
