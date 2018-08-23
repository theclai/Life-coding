package leetcode.binary_tree;

public class BinaryHashTree {
    public class Node {
        int key;
        int val;
        Node left;
        Node right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node root = null;
    public Node set(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
            return root;
        }
        return insert(root, key, val);

    }

    private Node insert(Node root, int key, int val) {
        Node node;
        if (root == null) {
            node = new Node(key, val);
            return node;
        }
        if (key > root.key) {
            root.right = insert(root.right, key, val);
        } else {
            root.left = insert(root.left, key, val);
        }

        return root;
    }

    public int get(int key) {
        System.out.println(root.key);
        if (key == root.key) {
            return root.val;
        }
        return find(root, key);
    }

    private int find(Node root, int key) {
        if (root.key == key)
            return root.val;
        if (key > root.key) {
            return find(root.right, key);
        } else {
            return find(root.left, key);
        }
    }
}
