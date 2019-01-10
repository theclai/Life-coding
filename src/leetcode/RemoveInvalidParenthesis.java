package leetcode;

import java.util.*;

/**
 * We are required to return the minimum number of invalid parentheses to remove, that is,
 * the shortest distance from s to a valid string. Shortest-path problem is natural to BFS :
 * <p>
 * node: all possible string by removing parenthesis
 * start node: s
 * end state: reach the level which contains a valid string
 * We establish set visited to avoid duplicate calculations.
 * For example, (() count as 2 candidates () and (( with set visited,
 * but one more candidate () without set visited.
 */
public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        RemoveInvalidParenthesis rip=new RemoveInvalidParenthesis();
        ArrayList<String> res;
        res = (ArrayList<String>) rip.removeInvalidParentheses("()())()");
        res.forEach(System.out::println);
    }
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet<>();
        List<String> result=new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //result = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    result.add(cur);
                    continue;
                }
                queue.addAll(getAdj(cur, visited));
            }
            if (result.isEmpty())
                return new ArrayList<>();
        }
        return result;
    }

    private List<String> getAdj(String cur, Set<String> visited) {
        List<String> adj = new ArrayList<>();
        String candidate;
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);
            if (ch == '(' || ch == ')') {
                candidate = cur.substring(0, i) + cur.substring(i + 1);
                if (!visited.contains(candidate)) {
                    visited.add(candidate);
                    adj.add(candidate);
                }
            }
        }
        return adj;
    }

    private boolean isValid(String s) {
        int score = 0; // Indicates whether left parenthesis and right parenthesis are balanced.

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                score++;
            else if (ch == ')')
                score--;
            if (score < 0)
                return false;
        }
        return score == 0;
    }
}
