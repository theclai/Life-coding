package leetcode.contests.contest_123;

import java.util.*;

public class SatisfibalityOfEqualityEquations {
    public static void main(String[] args) {
        boolean result = equationsPossible(new String[]{"a==b", "b!=a"});
        System.out.println(result);

        boolean result1 = equationsPossible(new String[]{"b==a", "a==b"});
        System.out.println(result1);

        boolean result2 = equationsPossible(new String[]{"a==b", "b==c", "a==c"});
        System.out.println(result2);

        boolean result3 = equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
        System.out.println(result3);

        boolean result4 = equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
        System.out.println(result4);
    }

    public static boolean equationsPossible(String[] equations) {
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            graph[i] = new ArrayList();

        for (String eqn : equations) {
            if (eqn.charAt(1) == '=') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }

        int[] color = new int[26];
        int t = 0;
        for (int start = 0; start < 26; ++start) {
            if (color[start] == 0) {
                t++;
                Stack<Integer> stack = new Stack();
                stack.push(start);
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == 0) {
                            color[nei] = t;
                            stack.push(nei);
                        }
                    }
                }
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (x == y || color[x] != 0 && color[x] == color[y])
                    return false;
            }
        }
        return true;
    }
}
