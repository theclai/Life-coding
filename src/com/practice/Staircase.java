package com.practice;

public class Staircase {
    public static void main(String[] args){
        int n=2;
        int res=climbStairs(2);
        System.out.println(res);
    }

    public static int climbStairs(int n){
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        return climbStairs(n-1)+climbStairs(n-2);
    }
}
