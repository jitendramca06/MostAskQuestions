package com.mostaskquestions.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class BinaryTreeSearchInsertion {
    private static void insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(key);
                } else {
                    node.right = new TreeNode(key);
                }
                break;
            }
        }
    }

    private static void search(TreeNode root, int key) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || st.size() > 0) {
            while (current != null) {
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            if (current.data  == key) {
                System.out.println("Given value is found");
                return;
            }
            current = current.right;
        }
        System.out.println("Given value is not found");
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inorder(root);
        System.out.println();
        insert(root, 10);
        inorder(root);
        System.out.println();
        search(root, 3);
    }
}
