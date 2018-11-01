package facebook_codelab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinBulbSwitch {
    public static void main(String[] args) {
        Integer[] input=new Integer[]{0,1,0,1};
        System.out.println(bulbs(Arrays.asList(input)));

    }

    public static int bulbs(List<Integer> a) {
        int[] arr=new int[a.size()];
        int j=0;

        for (Integer i:a) {
            arr[j]=i;
            j++;
        }
        int i=0;
        int counter=0;
        while (i<arr.length){
            if(arr[i]!=1){
                changeState( arr,i);
                counter++;
            }
            i++;
        }
        return counter;
    }

    private static void changeState(int[] a,int pos) {
        for(int i=pos;i<a.length;i++){
            a[i]=1-a[i];
        }

    }
}
