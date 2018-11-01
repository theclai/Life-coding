package facebook_codelab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArrays {
    public static void main(String[] args) {
        Integer[] a=new Integer[]{1,2,3,4};
        Integer[] b=new Integer[]{5,6,7,8};
        Integer[] c=new Integer[]{9,10,11,12};


        List<List<Integer>> input=new ArrayList<>();
        Arrays.asList(a);
        input.add(Arrays.asList(a));
        input.add(Arrays.asList(b));
        input.add(Arrays.asList(c));

        ArrayList<ArrayList<Integer>> B = performOps(input);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }


    static ArrayList<ArrayList<Integer>> performOps(List<List<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}
