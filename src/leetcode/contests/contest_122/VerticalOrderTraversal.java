package leetcode.contests.contest_122;

import leetcode.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
   static Map<Integer, List<Integer>> map;

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        List<List<Integer>> result=verticalTraversal(root);
        System.out.println(result);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        helper(map, root, 0);
        List<List<Integer>> result=new ArrayList<>();
        int index=0;
        Iterator<Map.Entry<Integer, List<Integer>>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,List<Integer>> data= it.next();
            result.add(index,data.getValue());
            index++;
        }
        return result;
    }

    public static void helper(Map<Integer, List<Integer>> map, TreeNode root, int level) {

        map.computeIfAbsent(level,val->new ArrayList<>()).add(root.val);
        if (root.left != null){
            helper(map, root.left, level - 1);
        }
        if (root.right != null){
            helper(map, root.right, level + 1);
        }
    }
}
