package dailycodings;

public class DailyCodings85 {
    public static void main(String[] args) {
        int x = 34;
        int y = 67;
        int b = 0;

        System.out.println(test(x, y, 0));
    }

    public static int test(int x, int y, int b) {
        return x * b | y * (1 - b);
    }
}
