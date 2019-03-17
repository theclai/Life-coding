package leetcode.contests.contest_128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{60, 60, 60}));

    }

    @Test
    public void third_pairsongs() {
        Assertions.assertEquals(0,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{439, 407, 197, 191, 291, 486, 30, 307, 11}));

    }

    @Test
    public void fourth_pairsongs() {
        Assertions.assertEquals(1,
                pairOfSongsDuration.numPairsDivisibleBy60(new int[]{418, 204, 77, 278, 239, 457, 284, 263, 372, 279, 476, 416, 360, 18}));

    }

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        if (time.length < 2) return 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int val = rem(time[i], 60);
            if (m.containsKey(60 - val))
                count += m.get(60 - val);
            if (!m.containsKey(val))
                m.put(val, 1);
            else
                m.put(val, m.get(val) + 1);
        }
        if (m.containsKey(0)) {
            int val = m.get(0);
            return count + (val - 1) * val / 2;
        }
        return count;
    }


    public int rem(int N, int d) {
        return N % d;
    }
}
