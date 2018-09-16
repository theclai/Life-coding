package leetcode;

import java.util.*;

public class FruitIntoBasket {
    public static void main(String[] args){
        int[] trees=new int[]{0,1,2,2};
        System.out.println(maxGain(trees,3));
        int targetLen=trees.length;
        int maxGain=0;
        for(int i=0;i<targetLen-maxGain;i++){
            int res= maxGain(trees,i);
            if(res>maxGain){
                maxGain=res;
            }

        }

        System.out.println(maxGain);



    }

    public static int maxGain(int[] tree,int startPosition) {
        HashMap<Integer, Integer> sorted = new HashMap<>(2);
        HashSet list=new HashSet(2);


        for(int i=startPosition;i<tree.length;i++){
            if(list.size()==2){
                if(!list.contains(tree[i])){
                    break;
                }
            }else {
                list.add(tree[i]);
            }
            Integer count= sorted.get(tree[i]);
            if(count==null){
                sorted.put(tree[i],1);
            }else{
                sorted.put(tree[i],count+1);
            }

        }
        int counter=0;
        for(Map.Entry<Integer,Integer> data:sorted.entrySet()){
            counter=counter+data.getValue();
        }

        System.out.println(sorted);
        return counter;
    }
}
