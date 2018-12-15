package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInEachRow {
    int level = 0;

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        else {
            largestLevel(0, root, list);
            return list;
        }
    }

    public void largestLevel(int level, TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (level >= list.size()) list.add(root.val);
        list.set(level, Math.max(list.get(level), root.val));
        largestLevel(level + 1, root.left, list);
        largestLevel(level + 1, root.right, list);
    }
}
