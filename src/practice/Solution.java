package practice;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        String[] input  = { "10", "1","0"};
        int maxOnes  = 1;
        int maxZeros = 1;
        int max=0;

        //ArrayList<String> includes = new ArrayList<String>();
        int includes=0;

        int remZeros= maxZeros;
        int remOnes = maxOnes;
        int iter = 0;

        ArrayList<Integer>  op = new ArrayList<Integer>();
        while(iter<input.length){
            for(int i=0;i<input.length;i++){
                String data  =input[i];
                int[] c = count(data);
                int zeros = c[0];
                int ones = c[1];

                if(zeros<=remZeros && ones<=remOnes){
                    includes++;
                    remZeros = remZeros-zeros;
                    remOnes = remOnes-ones;
                }
            }
            op.add(iter,includes);
            iter++;

        }

        System.out.println(findMax(op));
    }


    private static int findMax(ArrayList<Integer> data){
        int max= 0;
        for(int i=0;i<data.size();i++){
            Integer in = data.get(i);
            if(in>max){
                max = in;
            }
        }
        return max;
    }

    private static int[] count(String data){
        int zero=0;
        int one = 0;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
        }

        int[] res = {zero,one};
        return res;
    }
}
