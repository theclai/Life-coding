package practice;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{5, 2, 6, 7, 1, 9};

    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
