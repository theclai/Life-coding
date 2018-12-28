package practice.elements_of_pro_interview_book;

public class EntryEqualIndex {
    public static void main(String[] args) {
        int[] in = new int[]{-2, 0, 2, 3, 6, 7, 9};
        find(in);
    }

    private static int find(int[] in) {
        int l = 0;
        int r = in.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int diff = in[mid] - mid;
            if (diff == 0) {
                System.out.println(in[mid]);
                return mid;
            }
            else if (diff > 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
