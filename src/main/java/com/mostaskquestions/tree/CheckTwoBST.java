package com.mostaskquestions.tree;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class CheckTwoBST {
    private static boolean isSameBST(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data != root2.data) return false;
        boolean leftTree = isSameBST(root1.left, root2.left);
        boolean rightTree = isSameBST(root1.right, root2.right);
        if (leftTree && rightTree) return true;
        else return false;
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        System.out.println(isSameBST(root, root));

        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(30);
        root1.right = new TreeNode(70);
        root1.left.left = new TreeNode(20);
        root1.left.right = new TreeNode(40);
        root1.right.left = new TreeNode(60);
        System.out.println(isSameBST(root, root1));
    }
}
