package cracking_coding_int.chapter_one;

public class StringCompression {
    public static void main(String[] args) {
        String in = "aabcccccaaa";
        System.out.println(compressString(in));

        System.out.println(compressLeetCode(new char[]{'a','a','b','b','c','c','c'}));
    }

    private static String compressString(String in) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < in.length(); i++) {
            counter++;
            if (i + 1 >= in.length() || in.charAt(i) != in.charAt(i + 1)) {
                sb.append(in.charAt(i));
                sb.append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }

    private static int compressLeetCode(char[] in) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < in.length; i++) {
            counter++;
            if (i + 1 >= in.length || in[i] != in[i + 1]) {
                sb.append(in[i]);
                sb.append(counter);
                counter = 0;
            }
        }
        return sb.toString().length();
    }
}
