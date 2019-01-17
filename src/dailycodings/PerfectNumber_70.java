package dailycodings;

public class PerfectNumber_70 {
    public static void main(String[] args) {
        int n=2;
        System.out.println(findPerfectNum(n));
    }

    private static int findPerfectNum(int n) {
        int target=10-n;
        return 10*n+target;
    }

}
