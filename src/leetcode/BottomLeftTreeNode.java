package leetcode;

public class BottomLeftTreeNode {
    class Node {
        int data;
        Node left, right;

        // Constructor
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class Level {
        int maxVal;
    }

    void deepestLeftLeaf(Node node) {
        Level level = new Level();
        deepestLeftLeafUtil(node, 0, level, false);
    }

    Node result;

    private void deepestLeftLeafUtil(Node node,
                                     int lvl,
                                     Level level,
                                     boolean ifLeft) {
        if(node==null)
            return;
        if (node.left == null & node.right == null && ifLeft) {
            if(level.maxVal<lvl){
                level.maxVal=lvl;
                result=node;
            }

        }
        deepestLeftLeafUtil(node.left, lvl + 1, level, true);

        deepestLeftLeafUtil(node.right, lvl + 1, level, false);
    }

}
