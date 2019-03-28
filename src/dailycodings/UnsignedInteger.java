package dailycodings;

public class UnsignedInteger {
    public static void main(String[] args) {

        int even = 0b10101010;
        int odd = 0b01010101;

        int x=226;
        System.out.println((x&even)>>1 | (x & odd));
    }
}
