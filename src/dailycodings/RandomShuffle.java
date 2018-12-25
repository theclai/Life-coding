package dailycodings;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomShuffle {
    public static void main(String[] args) {
        int[] in=new int[]{1,2,3,4,5,6};
        shuffle(in);
    }

    private static void shuffle(int[] in) {
        ThreadLocalRandom random= ThreadLocalRandom.current();
        //System.out.println(random.nextInt(0,2));

        for(int i=0;i<in.length;i++){
            int r=random.nextInt(0,i+1);
            int temp=in[i];
            in[i]=in[r];
            in[r]=temp;
        }
        Arrays.stream(in).forEach(d-> System.out.println(d));
    }
}
