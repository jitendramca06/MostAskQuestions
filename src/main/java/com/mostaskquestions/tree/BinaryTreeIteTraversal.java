package com.mostaskquestions.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class BinaryTreeIteTraversal {
    private static void inorder(TreeNode root) {
        if (root == null)
            return;


        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }

    // An iterative process to print preorder traversal of Binary tree
    private static void iterativePreorder(TreeNode root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            TreeNode mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    // An iterative function to do postorder traversal
    // of a given binary tree
    private static ArrayList<Integer> postOrderIterative(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> S = new Stack<TreeNode>();

        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.data);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.data);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.data);
            }

            prev = current;
        }

        return list;
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
        iterativePreorder(root);

        System.out.println("\nInorder traversal of binary tree is ");
        inorder(root);

        System.out.println("\nPostorder traversal of binary tree is ");
        System.out.println(postOrderIterative(root).toString());
    }
}
