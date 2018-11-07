package pramp;

public class PositionAndValueInArray {
    static int indexEqualsValueSearch(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        // your code goes here

        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == mid) {
                if (mid > 0 && arr[mid - 1] == mid - 1) {
                    return mid - 1;
                } else {
                    return mid;
                }
            }
            if (arr[mid] > mid)
                end = mid - 1;
            else
                start = mid + 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] input=new int[]{-8,0,2,5};
        int[] input = new int[]{0, 3};


        int result = indexEqualsValueSearch(input);
        System.out.println(result);

    }
}
