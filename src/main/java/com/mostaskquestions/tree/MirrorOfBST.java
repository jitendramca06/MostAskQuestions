package com.mostaskquestions.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class MirrorOfBST {
    private static TreeNode findMirror(TreeNode root) {
        if (root == null) return root;
        TreeNode left = findMirror(root.left);
        TreeNode right = findMirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data != root2.data) return false;
        boolean leftT = isMirror(root1.left, root2.right);
        boolean rightT = isMirror(root1.right, root2.left);
        if (leftT && rightT) return true;
        else return false;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current  = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
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
        inorder(root);
        System.out.println();
        //System.out.println(isMirror(root, root));
        TreeNode root1 = findMirror(root);
        inorder(root1);
        System.out.println();
        System.out.println(isMirror(root, root1));
    }
}
