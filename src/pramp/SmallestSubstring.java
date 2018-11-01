package pramp;

public class SmallestSubstring {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        if (str == null)
            return "";
        if (arr.length == 0)
            return "";
        // your code goes here
        int start = 0;
        int end = 0;
        char c;
        while (start <= end && end < str.length()) {
            int j = 0;
            while (j < arr.length) {
                c = arr[j];
                if (!(str.substring(start, end).contains(String.valueOf(c)))) {
                    end++;
                } else {
                    j++;
                }
            }
            break;
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "xyyzyzyx";
        char[] arr = new char[]{'x', 'y','z'};
        System.out.println("output"+getShortestUniqueSubstring(arr, str));
    }
}
