package stackoverflow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class PreAndInOrderToLevelOrderTraversal {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    static int[] pre;
    static int[] in;
    static ConcurrentHashMap<Integer, Integer> map;
    static Node treeRoot;
    static int preIndex = 0;

    public static void main(String[] args) {
        map = new ConcurrentHashMap<>();
        pre = new int[]{1, 2, 4, 5, 3};
        in = new int[]{4, 2, 5, 1, 3};

        treeRoot = buildTreeFromPreorderAndInOrder(pre, in, map);
        System.out.println(treeRoot.val);
        printLevelOrder();
    }

    public static void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(treeRoot);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }

    private static Node buildTreeFromPreorderAndInOrder(int[] pre, int[] in, ConcurrentHashMap<Integer, Integer> map) {
        // location of the item in the inorder traversal to find it quick in O(1)
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(in, pre, 0, pre.length - 1, map);
    }

    private static Node helper(int[] in, int[] pre, int inStart, int inEnd, ConcurrentHashMap<Integer, Integer> map) {
        if (inStart > inEnd) return null;
        int curr = pre[preIndex++];
        Node tNode = new Node(curr);
        if (inStart == inEnd) return tNode;
        int inIndex = map.get(curr);
        tNode.left = helper(in, pre, inStart, inIndex - 1, map);
        tNode.right = helper(in, pre, inIndex + 1, inEnd, map);
        return tNode;
    }
}
