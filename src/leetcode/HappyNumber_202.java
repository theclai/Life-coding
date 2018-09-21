package leetcode;

public class HappyNumber_202 {
    public boolean findHappy(int n){
        System.out.println(n);
        if(n==1)
            return true;
        int sum=0;
        while(n/10!=0){
            int r =n%10;
            n=n/10;
            if(n==1)
                sum=sum+r*r+1;
            sum=sum+r*r;
        }
        if(sum==1)
            return true;
        findHappy(n);
     return false;
    }
}
