package leetcode.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerFulIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> op= (ArrayList<Integer>) powerfulIntegers(2,3,10);
        op.forEach(val-> System.out.println(val));
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound==0) return null;
        int xLimit=0;
        while(Math.pow(x,xLimit)<=bound-1){
            xLimit++;
        }

        System.out.println(xLimit);

        int yLimit=0;
        while(Math.pow(y,yLimit)<=bound-1){
            yLimit++;
        }


        System.out.println(yLimit);

        Set list=new HashSet();
        for(int i=0;i<xLimit;i++){
            for (int j = 0; j < yLimit; j++) {
                double temp=Math.pow(x,i)+Math.pow(y,j);
                if(temp<=10){
                    list.add((int) temp);
                }
            }
        }

        return new ArrayList<>(list);

    }
}
