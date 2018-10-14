package practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[]  args){
        int[] in = {-1, 0, 1, 2, -1, -4};
        findThreeSum(in);

    }
    private static List<List<Integer>> findThreeSum(int[] in) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.parallelSort(in);

        for(int i=0;i<in.length-2;i++){
            int j=i+1;
            int k = in.length-1;
            int target = 0;
            while(j<k){
                int sum = in[i]+in[j]+in[k];
                if(sum==target){
                    System.out.println(in[i]+", "+in[j]+", "+in[k]);
                    List<Integer> op = new ArrayList<>(3);
                    op.add(in[i]);
                    op.add(in[j]);
                    op.add(in[k]);
                    result.add(op);
                   // j++;
                    //k--;
                    break;
                }else if(sum<target){
                    j++;

                }else{
                    k--;
                }
            }
        }
        return result;

    }
}
