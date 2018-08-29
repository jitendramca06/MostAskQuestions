package com.mostaskquestions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class LevelOrderTraversal {
    /* Compute the "height" of a tree -- the number of
   nodes along the longest path from the root node
   down to the farthest leaf node.*/
    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    /* Print nodes at the given level */
    private static void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    private static void printLevelOrderIte(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.*/
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /* function to print level order traversal of tree*/
    private static void printLevelOrder(TreeNode root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    public static void main(String[] args) {
         /* creating a binary tree and entering
         the nodes */
        TreeNode tree_level = new TreeNode(1);
        tree_level.left = new TreeNode(2);
        tree_level.right = new TreeNode(3);
        tree_level.left.left = new TreeNode(4);
        tree_level.left.right = new TreeNode(5);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(tree_level);
        System.out.println();
        printLevelOrderIte(tree_level);
    }
}
