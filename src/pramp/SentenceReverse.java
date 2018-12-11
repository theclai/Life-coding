package pramp;

public class SentenceReverse {
    static char[] reverseWords(char[] arr) {
        reverse(arr, 0, arr.length - 1);
        int i = 0;
        int j = 0;
        System.out.println(String.valueOf(arr));
        while (j <= arr.length) {
            if (j == arr.length || arr[j] == '.') {
                reverse(arr, i, j - 1);
                System.out.println("i: " + i + " j: " + j + " output: " + String.valueOf(arr));
                i = j + 1;
            }
            j++;
        }
        return arr;
    }

    public static void reverse(char[] in, int start, int end) {
        while (start < end) {
            char c = in[end];
            in[end] = in[start];
            in[start] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'c', 'a', 't', '.', 'd', 'o', 'g'};
        char[] result = reverseWords(arr);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
