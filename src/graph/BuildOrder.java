package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a list of packages that need to be built and the dependencies for each package, determine a valid order in which to build the packages.
 * <p>
 * eg.
 * <p>
 * 0:
 * 1: 0
 * 2: 0
 * 3: 1, 2
 * 4: 3
 * <p>
 * output: 0, 1, 2, 3, 4
 * <p>
 * Once you think that you’ve solved the problem, click below to see the solution.
 */

public class BuildOrder {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(4, 3);
        g.addEdge(0, 0);
        g.addEdge(1, 0);
        g.addEdge(2, 0);
        g.addEdge(3, 2);
        g.addEdge(3, 1);
        buildOrder(g);
    }

    private static void buildOrder(Graph g) {
        boolean[] visited = new boolean[g.V];
        Queue<Integer> stack = new LinkedList<>();

        for (int i = 0; i < g.V; i++) {
            if (!visited[i])
                helper(i, g, visited, stack);
        }
        stack.forEach(System.out::println);
    }

    private static void helper(int cur,
                               Graph g,
                               boolean[] visited,
                               Queue<Integer> stack) {
        visited[cur] = true;
        Iterator<Integer> iterator = g.adj[cur].iterator();
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            if(!visited[data])
                helper(data,g,visited,stack);
        }
        stack.add(cur);
    }
}
