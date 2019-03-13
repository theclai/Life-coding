package dailycodings;

public class SquareRoot_129 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(findsqrt(n));
    }

    private static double findsqrt(int n) {
        double left=0;
        double right=n;
        double temp=n/2;
        double diff=1;
        while (diff>.1){
            System.out.println(temp*temp);
            right=temp;
            left=left+(right-left)/2;
            System.out.println(temp);
            temp=(left+right)/2;
            diff=(temp*temp)-n;
        }
        return temp;
    }
}
