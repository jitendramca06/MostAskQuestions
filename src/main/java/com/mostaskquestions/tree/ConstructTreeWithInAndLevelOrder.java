package com.mostaskquestions.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class ConstructTreeWithInAndLevelOrder {
    private static TreeNode construct(TreeNode root, int[] levelOrder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        if (inEnd == inStart) return new TreeNode(inorder[inStart]);

        int index = 0;
        boolean found = false;

        for (int i = 0; i < levelOrder.length; i++) {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) {
                if (data == inorder[j]) {
                    index = j;
                    found = true;
                    root = new TreeNode(data);
                    break;
                }
            }
            if (found) break;
        }

        root.left = construct(root, levelOrder, inorder, inStart, index - 1);
        root.right = construct(root, levelOrder, inorder, index + 1, inEnd);
        return root;
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
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        TreeNode root = null;
        root = construct(root, level, in, 0, in.length - 1);
        inorder(root);
    }
}
