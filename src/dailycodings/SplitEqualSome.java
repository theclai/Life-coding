package dailycodings;

import java.util.Arrays;

public class SplitEqualSome {
    static int[] in;
    public static void main(String[] args) {
        in=new int[]{15, 5, 20, 10, 35, 15, 10,5,5};
        System.out.println(split(in));
    }

    private static boolean split(int[] in) {
        int sum= Arrays.stream(in).sum();
        System.out.println(sum);
        if(sum%2!=0)return false;
        return helper(sum/2,0,in.length,0);
    }

    private static boolean helper(int target, int start, int length,int sum) {
        if(sum==target)
            return true;
        if(start+1<length)
            return helper(target,start+1,length,sum+in[start])||helper(target,start+1,length,sum);
        return false;
    }
}
