package com.mostaskquestions.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class BinarySearchTree {
    private static TreeNode searchRec(TreeNode root, int key) {
            if (root == null || root.data == key) {
                return root;
            }

            if (root.data > key) {
                return searchRec(root.left, key);
            }
            return searchRec(root.right, key);
    }

    private static TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (root.data > key) {
            root.left = insertRec(root.left, key);
        } else if (root.data < key) {
            root.right = insertRec(root.right, key);
        }
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
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TreeNode root = insertRec(null, 50);
        root = insertRec(root, 30);
        root = insertRec(root, 20);
        root = insertRec(root, 40);
        root = insertRec(root, 70);
        root = insertRec(root, 60);
        root = insertRec(root, 80);
        inorder(root);
        System.out.println();
        TreeNode found = searchRec(root, 700);
        if (found == null) System.out.println("Not found");
        else System.out.println(found.data + " is found");
    }
}
