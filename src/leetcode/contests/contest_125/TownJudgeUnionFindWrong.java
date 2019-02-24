package leetcode.contests.contest_125;

import java.util.*;

public class TownJudgeUnionFindWrong {
    int[] parents;

    public TownJudgeUnionFindWrong(int N) {

        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
    }

    public static void main(String[] args) {
        TownJudgeUnionFindWrong townJudgeUnionFindWrong = new TownJudgeUnionFindWrong(4);
        townJudgeUnionFindWrong.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}});
    }


    public int root(int i) {
        while (i != parents[i]) i = parents[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        parents[i] = j;

    }

    public int findJudge(int N, int[][] trust) {
        for (int[] data : trust) {
            if (!connected(data[0], data[1])) {
                union(data[0], data[1]);
            }
        }
        Arrays.stream(parents).forEach(d -> System.out.println(d));
        return 0;
    }
}
