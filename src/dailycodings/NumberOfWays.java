package dailycodings;

public class NumberOfWays {
    public static void main(String[] args) {
        int N=4;
        System.out.println(numberOfWays(N));
    }

    private static int numberOfWays(int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;

        else{
            return numberOfWays(n-1)+numberOfWays(n-2);
        }
    }
}

