package leetcode;

import java.util.*;

public class AllNodeDistanceK_863 {
    Map<TreeNode, TreeNode> parent;


    public AllNodeDistanceK_863() {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // track parent node
        Map<TreeNode, TreeNode> prevMap = new HashMap<>();
        buildPrevNodes(root, prevMap, null);

        // bfs
        Queue<TreeNode> queue = new LinkedList<>();
        if (target != null)
            queue.add(target);
        int curK = 0;

        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            // if the counter distance satisfy, you found the answer
            if (curK == K) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode n : queue)
                    res.add(n.val);

                return res;
            }
            int size = queue.size();
            // for all the elemets in the queue in a certain level(counter)
            // add all of their next layer child and increase the counter.
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                visited.add(poll);
                if (poll.left != null && !visited.contains(poll.left))
                    queue.offer(poll.left);

                if (poll.right != null && !visited.contains(poll.right))
                    queue.offer(poll.right);

                if (prevMap.get(poll) != null && !visited.contains(prevMap.get(poll)))
                    queue.offer(prevMap.get(poll));
            }
            curK++;
        }

        return new ArrayList<>();
    }

    public void buildPrevNodes(TreeNode root, Map<TreeNode, TreeNode> prevMap, TreeNode prev) {
        if (root == null)
            return;

        buildPrevNodes(root.left, prevMap, root);
        prevMap.put(root, prev);
        buildPrevNodes(root.right, prevMap, root);
    }


    public static void main(String[] args) {

    }
}
