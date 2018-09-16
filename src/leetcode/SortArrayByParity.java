package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
    public static void main(String[] args){
        int[] input=new int[]{3,1,2,4};
        int[] output= sortArrayByParity(input);
        System.out.println(output.length);

    }
    public static int[] sortArrayByParity(int[] A) {
        List lOdd=new ArrayList();
        List lEven=new ArrayList();
        if(A.length<=1){
            return A;
        }

        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                lEven.add(A[i]);
            }else{
                lOdd.add(A[i]);
            }
        }

        lEven.addAll(lOdd);

        int[] output=new int[lEven.size()];
        for(int i=0;i<lEven.size();i++){
            output[i]= (int) lEven.get(i);
        }
        return output;

    }
}
