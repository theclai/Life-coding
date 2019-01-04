package geeksforgeeks.interview_questions.strings;
public class PermutationOfStrings {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str);
    }

    private static void permutation(String in) {
        helper(in, 0, in.length()-1);
    }

    public static void helper(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                helper(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
