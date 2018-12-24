package dailycodings;

import leetcode.TreeNode;

public class ExpressionTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('*');
        root.left = new TreeNode('+');
        root.right = new TreeNode('+');
        root.left.left = new TreeNode('3');
        root.left.right = new TreeNode('2');

        root.right.left = new TreeNode('4');
        root.right.right = new TreeNode('5');

        int result = compute(root);
        System.out.println(result);
    }

    private static int compute(TreeNode root) {
        System.out.println("Root: "+ root.c);
        if(root==null)
            return 0;
        if(Character.isDigit(root.left.c) && Character.isDigit(root.right.c))
            return execute(Integer.parseInt(String.valueOf(root.left.c)),
                    Integer.parseInt(String.valueOf(root.right.c)),
                    root.c);
        return execute(compute(root.left),compute(root.right),root.c);
    }

    public static int execute(int a, int b, char sign){
        System.out.println("a: "+a+"b: "+b+"sign: "+sign);
        if(sign=='+')
            return a+b;
        if(sign=='*')
            return a*b;
        if(sign=='-')
            return a-b;
        if(sign=='/')
            return a/b;

        return 0;
    }
}
