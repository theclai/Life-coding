package leetcode;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String in) {
        if (in == null || in.length() == 0)
            return "";
        int left = 0;
        int right = in.length() - 1;
        char[] ops = new char[in.length()];
        while (left <= right) {
            if (left == right)
                ops[left] = ops[right];
            if (!Character.isLetter(in.charAt(left))) {
                ops[left] = in.charAt(left);
                left++;
            } else if (!Character.isLetter(in.charAt(right))) {
                ops[right] = in.charAt(right);
                right--;
            } else {
                ops[left] = in.charAt(right);
                ops[right] = in.charAt(left);
                left++;
                right--;
            }
        }
        return new String(ops);
    }
}
