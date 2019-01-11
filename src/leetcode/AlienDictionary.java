package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary {
    class Graph {
        private final LinkedList<Integer>[] adjacencyList;

        Graph(int nVertices) {
            adjacencyList = new LinkedList[nVertices];
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                adjacencyList[vertexIndex] = new LinkedList<>();
            }
        }

        // function to add an edge to graph
        void addEdge(int startVertex, int endVertex) {
            adjacencyList[startVertex].add(endVertex);
        }

        private int getNoOfVertices() {
            return adjacencyList.length;
        }

        private void topologicalSortUtil(int currentVertex, boolean[] visited,
                                         Stack<Integer> stack) {
            visited[currentVertex] = true;
            for (int adjacentVertex : adjacencyList[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    topologicalSortUtil(adjacentVertex, visited, stack);
                }
            }
            stack.push(currentVertex);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();

            // Mark all the vertices as not visited
            boolean[] visited = new boolean[getNoOfVertices()];
            for (int i = 0; i < getNoOfVertices(); i++) {
                visited[i] = false;
            }

            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < getNoOfVertices(); i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // Print contents of stack
            while (!stack.isEmpty()) {
                System.out.print((char) ('a' + stack.pop()) + " ");
            }
        }
    }
}
