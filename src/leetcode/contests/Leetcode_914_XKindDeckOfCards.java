package leetcode.contests;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Leetcode_914_XKindDeckOfCards {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,2,2,2,2};
        boolean result = isPossibleXKindDeckCard(input);
        System.out.println(result);
    }

    private static boolean isPossibleXKindDeckCard(int[] input) {
        if(input.length<=1)
            return false;
        HashMap<Integer,Integer> table=new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            if(table.containsKey(input[i])){
                int count=table.get(input[i]);
                table.put(input[i],count+1);
            }else{
                table.put(input[i],1);
            }
        }

        Set<Integer> keys=table.keySet();
        int targetCount=table.get(input[0]);
        boolean result=true;

        for(Integer key:keys){
            int val=table.get(key);
            int rem=val%2;
            int res=val/2;

           if(res<1 || rem!=0){
                result= false;
            }else {
                result=true;
            }

        }

        return result;

    }
}
