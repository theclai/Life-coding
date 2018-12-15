package leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthNArray {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }

    private int helper(Node root, int n) {
        int curMax=n;
        if(root!=null){
            Iterator<Node> it=root.children.iterator();
            while (it.hasNext()){
                Node node=it.next();
                helper(node,n+1);
            }
            curMax=Math.max(curMax,n);
        }
        return curMax;
    }
}
