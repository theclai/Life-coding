package practice;

public class ReverseString {
    public static void main(String[] args) {
        String input="Bangla";
        System.out.println(reverString(input));
    }

    private static String reverString(String input) {
        // String build is immutable and faster
        StringBuilder builder=new StringBuilder();
        for (int i = input.length()-1; i >=0 ; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString();
    }
}
