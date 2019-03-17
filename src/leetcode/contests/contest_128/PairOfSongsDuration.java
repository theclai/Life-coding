package leetcode.contests.contest_128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PairOfSongsDuration {
    PairOfSongsDuration pairOfSongsDuration;

    @BeforeEach
    public void init() {
        pairOfSongsDuration = new PairOfSongsDuration();
    }

    @Test
    public void remainder() {
        Assertions.assertEquals(2, pairOfSongsDuration.rem(12, 5));
    }

    @Test
    public void first_pairsongs() {
        Assertions.assertEquals(3,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));

    }

    @Test
    public void second_pairsongs() {
        Assertions.assertEquals(3,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{60,60,60}));

    }

    @Test
    public void third_pairsongs() {
        Assertions.assertEquals(0,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{439,407,197,191,291,486,30,307,11}));

    }

    @Test
    public void fourth_pairsongs() {
        Assertions.assertEquals(1,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{418,204,77,278,239,457,284,263,372,279,476,416,360,18}));

    }
    public int numPairsDivisibleBy60(int[] time) {
        HashSet<Integer> set=new HashSet<>();

        for (int i = 0; i <time.length ; i++) {
            set.add(60-rem(time[i],60));
        }
        int total = 0;
        for(int i=0;i<time.length;i++){
            if(set.contains(rem(time[i],60)))
                total++;
        }
        return total;
    }


    public int rem(int N, int d) {
        return N % d;
    }
}
