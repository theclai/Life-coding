package cracking_coding_int.chaper_four;

import graph.Graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
    static Graph g;

    public static void main(String[] args) {
        int V = 6;
        g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(g, V);
    }

    private static void topologicalSort(Graph g, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;
        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");

    }

    private static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> it = g.adj[v].iterator();
        Integer i;
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(new Integer(v));
    }
}
