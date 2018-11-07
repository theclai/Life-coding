package dailycodings;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeSerializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('1');
        root.left = new TreeNode('2');
        root.left.left = new TreeNode('3');
        root.left.right = new TreeNode('4');
        root.right = new TreeNode('5');
        List<Character> sNode = searialize(root, new ArrayList<>());
        sNode.stream().forEach(tn -> System.out.println(tn));

        TreeNode r = deserialize(sNode);
        System.out.println(r.c);
    }

    private static TreeNode deserialize(List<Character> sNode) {
        if (sNode.get(0) == 'N') {
            sNode.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(sNode.get(0));
        sNode.remove(0);
        root.left = deserialize(sNode);
        root.right = deserialize(sNode);
        return root;
    }

    private static List<Character> searialize(TreeNode root,
                                              ArrayList<Character> treeNodes) {
        if (root == null)
            treeNodes.add('N');
        else {
            treeNodes.add(Character.valueOf(root.c));
            searialize(root.left, treeNodes);
            searialize(root.right, treeNodes);
        }
        return treeNodes;
    }
}
