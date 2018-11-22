package pramp;


class KMessedArraySort {

    static int[] sortKMessedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return arr;
        // your code goes here

        for (int i = 0; i < arr.length; i++) {
            int shift = 1;
            while (shift <= k) {
                if (i + shift < arr.length) {
                    if (arr[i] > arr[i + shift])
                        swap(arr, i, i + shift);
                }
                shift++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int begin, int end) {
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int[] result = sortKMessedArray(input, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
