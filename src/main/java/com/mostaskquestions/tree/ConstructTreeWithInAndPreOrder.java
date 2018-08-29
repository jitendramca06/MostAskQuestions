package com.mostaskquestions.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class ConstructTreeWithInAndPreOrder {
    private static int preOrderStart = 0;
    private static TreeNode construct(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        /**
         * O(n^2)
         */
        if (inStart > inEnd) return null;
         TreeNode node = new TreeNode(preOrder[preOrderStart++]);
         if (inStart == inEnd) return node;
         int index = 0;
         for (int i = 0 ; i < inOrder.length ; i++) {
             if (node.data == inOrder[i]) {
                 index = i;
                 break;
             }
         }
         node.left = construct(preOrder, inOrder, inStart, index - 1);
         node.right = construct(preOrder, inOrder, index + 1, inEnd);
         return node;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int inorder[] =  {20, 30, 35, 40, 45, 50, 55, 60, 70};
        int preorder[] = {50, 40, 30, 20, 35, 45, 60, 55, 70};
        TreeNode root = construct(preorder, inorder, 0 , inorder.length - 1);
        inorder(root);
    }
}
