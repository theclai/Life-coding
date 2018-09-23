package graph;

import java.util.*;

public class bfs {
    private class Node {
        List<Node> next;
    }

    public static List<Node> breadthFastSearch(Node start, Node dest) {
        if (start == null || dest == null) return null;
        Queue<Node> toVisit = new LinkedList<>();// These are the nodes to visit in future
        HashMap<Node, Node> parents = new HashMap<>();// They track the parents to trace the shortest path

        // Starting nodes parent is to be null
        parents.put(start, null);
        // Add the starting node to "toVisit" list
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            Node cur = toVisit.remove();
            if (cur == dest) break;
            if (parents.containsKey(cur)) {
                for (Node node : cur.next) {
                    parents.put(node, cur);
                    toVisit.add(node);
                }
            }
        }
        // start tracing..
        // There will be not parents if and only if we did not find the dest node
        if (parents.get(dest) == null) return null;

        //
        List<Node> list = new ArrayList<>();
        Node cur = dest;
        while (cur != null) {
            list.add(0, cur);
            cur = parents.get(cur);// Tracing back
        }

        return list;

    }


}

