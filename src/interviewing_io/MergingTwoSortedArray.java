package interviewing_io;

public class MergingTwoSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8, 10};
        int[] merged = merge(a, b);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            }else if (a[i] > b[j]) {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        System.out.println("I: " + i + " J: " + j);
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while(j<b.length){
            result[k]=b[j];
            j++;
            k++;
        }
        return result;
    }
}
