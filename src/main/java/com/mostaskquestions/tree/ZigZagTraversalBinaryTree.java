package com.mostaskquestions.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class ZigZagTraversalBinaryTree {
    private static void printSpiralIte(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node  = stack1.pop();
                System.out.print(node.data + " ");
                if (node.right != null) stack2.push(node.right);
                if (node.left != null) stack2.push(node.left);
            }

            while (!stack2.isEmpty()) {
                TreeNode node  = stack2.pop();
                System.out.print(node.data + " ");
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }
    }

    private static void printSpiralRec(TreeNode root) {
        if (root == null) return;
        int h = height(root);
        boolean flag = true;

        for (int i = 1 ; i <= h ; i++) {
            printLevel(root, i, flag);
            flag = !flag;
        }
    }

    private static void printLevel(TreeNode root, int level, boolean flag) {
        if (root == null) return;
        if (level == 1) System.out.print(root.data + " ");
        if (level > 1) {
            if (flag) {
                printLevel(root.right, level - 1, flag);
                printLevel(root.left, level - 1, flag);
            } else {
                printLevel(root.left, level - 1, flag);
                printLevel(root.right, level - 1, flag);
            }
        }
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);
            if (lHeight > rHeight) return (lHeight + 1);
            else return (rHeight + 1);
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
        printSpiralRec(root);
        System.out.println();
        printSpiralIte(root);
    }
}
