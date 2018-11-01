package cracking_coding_int.chaper_four;

import graph.Graph;

public class TopologicalSort {
    public static void main(String[] args) {
        int V=6;
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(g,V);
    }

    private static void topologicalSort(Graph g, int v) {

    }
}
