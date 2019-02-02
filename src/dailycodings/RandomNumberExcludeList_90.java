package dailycodings;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
            System.out.println(generate(0, 10));
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
}
