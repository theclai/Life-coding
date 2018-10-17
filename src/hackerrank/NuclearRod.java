package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NuclearRod {


    public static void main(String[] args) {
        List<String> pairs=new ArrayList<>();
        pairs.add("1 2");
        pairs.add("1 4");
        int n=4; //how long to go
        System.out.println(minimalCost(n,pairs));

    }

    private static int minimalCost(int n, List<String> pairs) {
        LinkedList<Integer>[] data=new LinkedList[n+1];
        for(int i=0;i<n+1;i++){
            data[i]=new LinkedList<>();
        }
        for (String pair:pairs) {
            String[] p=pair.split("\\s+");
            System.out.println(p[0]);
            System.out.println(p[1]);
            int location = Integer.parseInt(p[0]);
            data[location].add(Integer.parseInt(p[1]));
        }
        System.out.println(data);
        // Find connected component

        boolean[] taken=new boolean[n+1];

        int cost=0;
        for(int j=1;j<n+1;j++){
            int result= runUtil(data,j,taken,new HashSet<>());
            cost+=Math.ceil(Math.sqrt(result));
        }

        return cost;
    }

    private static int runUtil(LinkedList<Integer>[] data,
                                int j,
                                boolean[] taken,

                               HashSet<Integer> counter) {
        if(!taken[j])
            counter.add(j);
        taken[j]=true;

        LinkedList list=data[j];
        for(int i=0;i<list.size();i++){
            if(!taken[(int) list.get(i)]){
                runUtil(data, (Integer) list.get(i),taken,counter);
            }
        }
        return counter.size();
    }
}
