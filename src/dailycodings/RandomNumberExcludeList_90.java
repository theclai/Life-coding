package dailycodings;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberExcludeList_90 {
    static Set<Integer> set;
    public static void main(String[] args) {
        set=new HashSet<>();
        set.add(3);
        set.add(4);
        set.add(9);
        int count=0;
        while (count<10) {
            System.out.println(betterApproach(0, 10));
            count++;
        }
    }

    private static int generate(int min, int max) {
        int rand=ThreadLocalRandom.current().nextInt(min,max);
        while (set.contains(rand)){
            System.out.println("collision happened: "+rand);
            rand=ThreadLocalRandom.current().nextInt(min,max);
        }
        return rand;
    }

    private static int betterApproach(int min, int max) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <max ; i++) {
            if(!set.contains(i))
                list.add(i);
        }

        int pos=ThreadLocalRandom.current().nextInt(min,list.size());

        return list.get(pos);
    }
}
