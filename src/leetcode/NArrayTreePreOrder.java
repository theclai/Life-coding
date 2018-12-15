package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NArrayTreePreOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        return helper(root,new ArrayList<>());
    }

    private List<Integer> helper(Node root, List<Integer> nodes) {
        if(root!=null){
            nodes.add(root.val);
            Iterator<Node> it= root.children.iterator();
            while (it.hasNext()) {
                Node n = it.next();
                helper(n, nodes);

            }
        }

        return nodes;
    }
}
