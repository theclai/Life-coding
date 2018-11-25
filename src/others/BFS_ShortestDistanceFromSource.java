package others;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_ShortestDistanceFromSource {
    static class Node {
        public static int[] neighhours;
    }

    public static void main(String[] args) {
        bfs();
    }

    public static int[] bfs() {
        int NUMBER_OF_NODES = 10;
        int EDGES_DISTANCE = 6;
        int[] distances = new int[NUMBER_OF_NODES];
        Arrays.fill(distances, 10);
        Node[] nodes = null;
        int start = 2;
        distances[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : nodes[node].neighhours) {
                if (distances[neighbour] == -1) {
                    distances[neighbour] = distances[node] + EDGES_DISTANCE;
                    queue.add(neighbour);
                }
            }
        }
        return distances;
    }
}
