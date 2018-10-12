package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPaths_1 {
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

    private static void findAllPathsFromSourceTarget(Graph g, int source, int target) {
        // Iterate over each node and their child
        // whenever found the target, noted the path
        // backtrack when you found the node and try different path in adjacency list

        /**
         * Check it is the target or not, if target print the localpath
         * */
        if(source==target){
            printPath(localList,target);
        }

        // Update the visited list
        visited[source]=true;
        // add to localpath
        localList.add(source);

        // iterate and recursively run on adjacency list of the source

        for (int node:g.adj[source]) {
            if(!visited[node]){
                findAllPathsFromSourceTarget(g,node,target);// You are visiting all the adjancey child
                // remove it from the visited list
                localList.remove(node);
            }
        }
        visited[source]=false;
    }

    private static void printPath(List<Integer> localList,int target) {
        for (int val:localList) {
            System.out.print(val+"->");
        }
        System.out.print(target);
        System.out.println("");
    }
}
