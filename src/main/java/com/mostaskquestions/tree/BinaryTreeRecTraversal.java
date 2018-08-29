package com.mostaskquestions.tree;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class BinaryTreeRecTraversal {
    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        /**
         * Depth First Traversal
         *              1
         *
         *           2      3
         *
         *     4        5
         *
         */
        System.out.println("Preorder traversal of binary tree is ");
        preOrder(root);

        System.out.println("\nInorder traversal of binary tree is ");
        inOrder(root);

        System.out.println("\nPostorder traversal of binary tree is ");
        postOrder(root);
    }
}
