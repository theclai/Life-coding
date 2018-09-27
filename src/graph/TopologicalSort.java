package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(g);
    }

    private static void topologicalSort(Graph g) {
        /**
         * We have to use DFS but we can not mark permanently a vertices visited or done
         * processing until or unless all of its adjacent is also visited.
         * So we need a temporary stack
         * */
        Stack<Integer> tempStack = new Stack<>();
        /**
         * visiting node tracker
         * */
        boolean visited[] = new boolean[g.V];
        for (int i = 0; i < g.V; i++)
            visited[i] = false;

        for (int i = 0; i < g.V; i++) {
            if (!visited[i])
                helper(g, tempStack, visited, i);
        }
        while (!tempStack.empty())
            System.out.print(tempStack.pop() + " ");

    }

    private static void helper(Graph graph,
                               Stack<Integer> tempStack,
                               boolean[] visited,
                               int curr) {
        visited[curr] = true;
        Iterator<Integer> iterator = graph.adj[curr].iterator();
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            if (!visited[data])
                helper(graph, tempStack, visited, data);
        }
        tempStack.push(curr);
    }
}
