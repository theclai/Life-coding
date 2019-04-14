package dailycodings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PartitionIntoThree_143 {
    PartitionIntoThree_143 partitionIntoThree;

    @BeforeEach
    public void init() {
        partitionIntoThree = new PartitionIntoThree_143();
    }

    @Test
    public void testWhenArrayIsSmall() {
        partitionIntoThree.sort(new int[]{9, 12, 3, 5, 14, 10, 10}, 0, 6);
    }

    private void sort(int[] ints, int low, int high) {
        if (low < high) {
            int pivot = partition(ints, low, high);
            sort(ints, low, pivot - 1);
            sort(ints, pivot + 1, high);
        }
        Arrays.stream(ints).forEach(value -> System.out.println(value));
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);// index of the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= arr[high]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;
        return i + 1;
    }
}
