package leetcode;

public class CountingNumberOfSetBits {
    public static void main(String[] args){
        count(8);
    }

    private static void count(int n) {
        int count=0;
        while(n!=0){
            n &=n-1;
            count++;
        }
        System.out.println(count);
    }
}
