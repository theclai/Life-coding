package leetcode.contests.contest_125;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TownJudge {
    TownJudge townJudge;

    @BeforeEach
    public void init() {
        townJudge = new TownJudge();
    }

    @Test
    public void townJudgeFirstPositive() {
        int res = townJudge.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}});
        Assertions.assertEquals(3, res);
    }

    @Test
    public void townJudgeSecondPositive() {
        int res = townJudge.findJudge(2, new int[][]{{1, 2}, {2, 3}});
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void townJudgeThirdPositive() {
        int res = townJudge.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}});
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void townJudgeFourthPositive() {
        int res = townJudge.findJudge(3, new int[][]{{1, 3}, {2, 3}});
        Assertions.assertEquals(3, res);
    }

    @Test
    public void townJudgeFifthPositive() {
        int res = townJudge.findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}});
        Assertions.assertEquals(3, res);
    }

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) return 1;
        /**
         * Simple parents tracker
         * */
        int[] parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        /**
         * Extracting the possible town judge
         * */
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] data : trust) {
            int a = data[0];
            int b = data[1];
            parents[a] = b;
            map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            ArrayList<Integer> members = (ArrayList<Integer>) e.getValue();
            if (members.size() == N - 1) { //all the citizen except the judge
                int key = (int) e.getKey();
                if (parents[key] != key) return -1;// if judge trust someone else
                return (int) e.getKey();
            }
        }
        return -1;
    }
}

