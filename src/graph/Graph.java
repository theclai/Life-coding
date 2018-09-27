package graph;

import java.util.LinkedList;

public class Graph {
    /**
     * Vertices
     */
    public int V;
    /**
     * Edges for a particular vertices
     */
    public LinkedList<Integer> adj[];

    /**
     * @param v Number of Vertices
     */
    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int start,
                        int end) {
        adj[start].add(end);
    }

}
