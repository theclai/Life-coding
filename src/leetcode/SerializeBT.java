package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");

    }

    private String rSerialize(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
        } else {
            s += s.valueOf(root.val) + ",";
            s = rSerialize(root.left, s);
            s = rSerialize(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    private TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }
}
