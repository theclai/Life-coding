package interviewbit;
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] input=new int[]{101, 103, 106, 109,
                158, 164, 182, 187, 202, 205, 2,
                3, 32, 57, 69, 74, 81, 99, 100};

        System.out.println(search(input,202));
    }
    public static int search( int[] a, int b) {
        if (a.length == 0 || a == null) return -1;
        return searchTargetHelper(a, 0, a.length-1, b);
    }

    public static int searchTargetHelper(int[] in, int low, int up, int target) {
        int mid = (low + up) / 2;
        if (in[mid] == target)
            return mid;
        if (target > in[low] && target < in[mid]) {
            return searchTargetHelper(in, low, mid - 1, target);
        } else {
            return searchTargetHelper(in, mid + 1, up, target);
        }
    }
}
