package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n){
        System.out.println(n);
        if(set.contains(n))
            return false;
        set.add(n);
        if(n==1)
            return true;
        int sum=0;
        if(n<10){
            isHappy(n*n);
        }
        while(n/10!=0){
            int r =n%10;
            n=n/10;
            if(n<10)
                sum=sum+r*r+n*n;
            else
                sum=sum+r*r;
        }
        if(sum==1)
            return true;
        return isHappy(sum);

    }
}
