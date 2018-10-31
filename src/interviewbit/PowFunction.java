package interviewbit;

public class PowFunction {
    public int power(int x, int n, int d) {
        int pow = 1;
        // do till n is not zero
        while (n > 0) {
            // if n is odd, multiply result by x
            if ((n & 1) == 1) {
                pow *= x;
            }
            // divide n by 2
            n = n >> 1;
            // multiply x by itself
            x = x * x;
        }
        // return result
        return pow;
    }

    public static void main(String[] args) {
        PowFunction pf = new PowFunction();
        System.out.println(pf.power(2, 5, 20));
    }
}
