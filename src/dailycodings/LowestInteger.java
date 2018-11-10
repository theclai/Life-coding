package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LowestInteger {
    static int[] in;

    public static void main(String[] args) {
        in=new int[]{1,2,0};
        LowestInteger li=new LowestInteger();
        System.out.println(li.firstMissingPositive(in));

        int[] in1=new int[]{3,4,-1,1};

        System.out.println(li.firstMissingPositive(in1));
        int[] in2=new int[]{7,8,9,11,12};
        System.out.println(li.firstMissingPositive(in2));

        int[] in3=new int[]{2,1};
        System.out.println(li.firstMissingPositive(in3));

    }

    public int firstMissingPositive(int[] nums) {
        int low=1;
        int start=0;
        while(start<nums.length){
            if(low==nums[start])
                low++;
            start++;
        }

        int l=1;
        int s=nums.length-1;
        while(s>=0){
            if(l==nums[s])
                l++;
            if(low==nums[s])
                low=l;
            s--;
        }
        return low;
    }

}
