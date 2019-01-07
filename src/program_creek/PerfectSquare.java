package program_creek;

import java.util.Arrays;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(perfSquare(12));

    }
    public static int perfSquare(int n){
        int[] cache=new int[n+1];
        Arrays.fill(cache,Integer.MAX_VALUE);
        int max=(int)Math.sqrt(n);
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j < max; j++) {
                if(i==j*j)
                    cache[i]=1;
                else if(i>j*j){
                    cache[i]=Math.min(cache[i],cache[i-j*j]+1);
                }
            }
        }
        return cache[n];
    }
}
