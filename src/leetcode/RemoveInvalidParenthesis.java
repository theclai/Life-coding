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
        RemoveInvalidParenthesis rip = new RemoveInvalidParenthesis();
        ArrayList<String> res;
        res = (ArrayList<String>) rip.removeInvalidParentheses("()())()");
        res.forEach(System.out::println);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
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
