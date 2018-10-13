package practice;

import java.util.Hashtable;

public class Staircase {
    static Hashtable<Integer,Integer> table=new Hashtable<>();
    public static void main(String[] args){
        int n=2;
        int res=climbStairs(5);
        System.out.println(res);
    }

    public static int climbStairs(int n){
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        if(table.contains(n))
            return table.get(n);
        int result= climbStairs(n-1)+climbStairs(n-2);
        table.put(n,result);
        return table.get(n);
    }

    public static int climbStoresAdvance(int n){
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
