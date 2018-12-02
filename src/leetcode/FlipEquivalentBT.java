package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipEquivalentBT {
    public static void main(String[] args) {
        FlipEquivalentBT fbt = new FlipEquivalentBT();
        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(12);
        fbt.flipEquiv(r1, r2);

    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    private void dfs(TreeNode root, List<Integer> vals) {
        if (root != null) {
            vals.add(root.val);
            int L = root.left != null ? root.left.val : -1;
            int R = root.right != null ? root.right.val : -1;
            if(L<R){
                dfs(root.left,vals);
                dfs(root.right,vals);
            }else{
                dfs(root.right,vals);
                dfs(root.left,vals);
            }
        }

    }
}
