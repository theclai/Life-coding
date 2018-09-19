package geeksforgeeks;

public class ChainedMatrixMultiplication {
    static String dump = "";
    static String beg = "";

    public static void main(String[] args) {
        String in = "abcd";
        compute(in, 0);
    }

    private static void compute(String in, int pos) {
        if (pos <= in.length() - 1) {
            if (beg.length() == 0) {
                dump = "(" + in + ")";
                System.out.println(dump);
            } else {
                dump = "(" + beg + ")" + in;
                System.out.println(dump);
            }
            beg = beg + in.substring(0, pos + 1);
            compute(in.substring(pos + 1, in.length()), pos);
        }
    }
}
