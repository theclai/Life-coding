package leetcode.contests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestTime_949 {
    static Set<Integer> set;
    public static void main(String[] args) {
        int[] in1=new int[]{1,2,3,4};
        int[] in2=new int[]{5,5,5,5};
        int[] in3=new int[]{0,4,0,0};

        LargestTime_949 lt=new LargestTime_949();
        System.out.println(lt.largestTimeFromDigits(in1));
        System.out.println(lt.largestTimeFromDigits(in2));
        System.out.println(lt.largestTimeFromDigits(in3));

    }
    public String largestTimeFromDigits(int[] A) {
        if(A.length!=4)
            return "";
        if(A[0]>2 && A[1]>3)
            return "";

        set=new HashSet<>();
        Arrays.sort(A);

        StringBuilder sb=new StringBuilder();

        sb= helper(sb,A,set,3);
        if(Integer.parseInt(String.valueOf(sb.toString().charAt(0)))<2)
            sb=helper(sb,A,set,10);
        else
            sb=helper(sb,A,set,4);

        sb.append(":");
        sb=helper(sb,A,set,5);
        sb=helper(sb,A,set,10);
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
