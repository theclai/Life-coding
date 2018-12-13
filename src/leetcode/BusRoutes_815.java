package leetcode;

import java.util.*;

public class BusRoutes_815 {
    public static void main(String[] args) {
        int[][] in = new int[][]{
                {1, 2, 7},
                {3, 6, 7}
        };
        int S = 1;
        int T = 6;
        BusRoutes_815 br = new BusRoutes_815();
        System.out.println(br.numBusesToDestination(in, S, T));
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(routes == null || routes.length == 0 || routes[0].length == 0) return -1;
        if(S == T) return 0;

        // Stop and buses relation
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], v -> new ArrayList<>()).add(i);
            }
        }

        //System.out.println(map);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        queue.offer(S);
        visitedStops.add(S);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == T) return count; // found the destination

                List<Integer> buses = map.get(cur);
                if (buses == null) continue;
                for (int bus : buses) {
                    if (visitedBuses.contains(bus)) continue;
                    for (int stop : routes[bus]) {
                        if (visitedStops.add(stop)) {
                            queue.offer(stop);
                        }
                    }
                }
            }
            count++;
        }
        return -1;

    }
}
