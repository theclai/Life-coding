package leetcode.contests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestTime_949 {
    static Set<Integer> set;
    public static void main(String[] args) {
        int[] in1=new int[]{1,2,3,4};
        int[] in2=new int[]{5,5,5,5};

        LargestTime_949 lt=new LargestTime_949();
        System.out.println(lt.largestTimeFromDigits(in1));
        System.out.println(lt.largestTimeFromDigits(in2));

    }
    public String largestTimeFromDigits(int[] A) {
        if(A.length!=4)
            return "";
        if(A[0]>2 && A[1]>3)
            return "";

        set=new HashSet<>();
        Arrays.sort(A);
        return getMaxHour(A);

    }

    private String getMaxHour(int[] input) {
        StringBuilder sb=new StringBuilder();

        sb= helper(sb,input,set,3);
        sb=helper(sb,input,set,4);
        sb.append(":");
        sb=helper(sb,input,set,5);
        sb=helper(sb,input,set,10);
        if(sb.length()==5)
            return sb.toString();
        else return "";

    }

    private StringBuilder helper(StringBuilder sb, int[] input, Set<Integer> set, int target) {
        int m=Integer.MIN_VALUE;
        int maxPosition=0;
        int i=0;
        while (i<4 && input[i]<target){
            if(input[i]>m && !set.contains(i)){
                m=input[i];
                maxPosition=i;
            }
            i++;
        }
        sb.append(m);
        set.add(maxPosition);
        return sb;
    }
}
