package leetcode.contests.contest_122;

import java.util.*;

public class EvenSum {
    static int[] A;
    static int[][] queries;

    public static void main(String[] args) {
        A = new int[]{5,4,0,2};
        queries = new int[][]{
                {1,1}, {3, 1}, {3,3},{5,1}
        };
        int[] res=sumEvenAfterQueries(A,queries);
        Arrays.stream(res).forEach(i-> System.out.println(i));
    }


    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if(A==null || A.length==0)return new int[]{};
        if(queries==null || queries.length==0)return A;
        HashMap<Integer,Integer> evens=new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) % 2 == 0) {
                evens.put(i, A[i]);
                sum += A[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int val = q[0];
            int pos = q[1];
            int temp=A[pos]+val;
            if (temp % 2 == 0) {
                if (evens.containsKey(pos)) {
                    sum = sum - evens.get(pos);
                    evens.put(pos, A[pos] + val);
                    sum = sum + A[pos] + val;
                    result.add(sum);
                    A[pos] = A[pos] + val;
                } else {
                    A[pos] += val;
                    evens.put(pos,A[pos]);
                    sum+=A[pos];
                    result.add(sum);
                }
            }else{
                if(evens.containsKey(pos)){
                    sum-=evens.get(pos);
                }
                result.add(sum);
                A[pos]+=val;
                evens.remove(pos);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }
}
