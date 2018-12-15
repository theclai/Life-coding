package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NArrayPostOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        return dfs(root,new ArrayDeque<Node>(),new ArrayList<Integer>());

    }

    private List<Integer> dfs(Node root, ArrayDeque<Node> nodes, ArrayList<Integer> integers) {
        if(root!=null){
            nodes.add(root);
            while (!nodes.isEmpty()){
                Iterator<Node> it=nodes.poll().children.iterator();
                while (it.hasNext()){
                    Node n=it.next();
                    dfs(n,nodes,integers);

                }
                integers.add(root.val);
            }
        }

        return integers;
    }
}
