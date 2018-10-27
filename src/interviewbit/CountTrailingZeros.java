package interviewbit;

public class CountTrailingZeros {
    public static void main(String[] args) {
        int A = 100;
        System.out.println(trailingZeroes(A));
    }

    public static int trailingZeroes(int A) {
        int count = 0;
        int start = 0;
        int end = 5;

        while (end <= A && A >= start) {
            count = count + 1;
            start = end;
            end = end + 5;
        }
        return count;
    }
}
