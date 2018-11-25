package leetcode;

import java.util.*;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    // use hashmap-> key is the node, value all the neighbours
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        // key is original node，value is copied node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        // each node in queue is already copied itself
        // but neighbors are not copied yet
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode un : cur.neighbors) {
                if (visited.containsKey(un)) {
                    visited.get(cur).neighbors.add(visited.get(un));
                } else {
                    UndirectedGraphNode new_node = new UndirectedGraphNode(un.label);
                    visited.put(un, new_node);
                    visited.get(cur).neighbors.add(new_node);
                    queue.offer(un);
                }
            }
        }
        return visited.get(node);
    }
}
