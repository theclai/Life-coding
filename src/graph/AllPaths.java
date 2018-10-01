package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    static boolean[] visited;
    static List<List<Integer>> result;
    static List<Integer> localList;

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        visited = new boolean[4];
        result = new ArrayList<>();
        localList = new ArrayList<>();
        findAllPathsFromSourceTarget(g, 2, 3);
    }

    private static List<List<Integer>> findAllPathsFromSourceTarget(Graph graph,
                                                                    int source,
                                                                    int target) {
        if (source == target) {
            result.add(localList);
        }
        visited[source] = true;

        List<Integer> nodes = graph.adj[source];

        for (Integer data : nodes) {
            if (!visited[data]) {
                localList.add(data);
                findAllPathsFromSourceTarget(graph, data, target);
                localList.remove(data);// Backtracking is happening
            }
        }
        visited[source] = false;
        return result;
    }
}
