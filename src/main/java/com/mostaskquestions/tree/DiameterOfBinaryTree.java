package com.mostaskquestions.tree;

/**
 * @author Jitendra Kumar : 29/8/18
 */
public class DiameterOfBinaryTree {
    private static int d;
    private static int height(TreeNode root) {
        if (root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return (Math.max(leftH, rightH) +1);
    }

    private static int findDiameter(TreeNode root) {
        if (root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        int diameter = leftH + rightH + 1;
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int findDiameter1(TreeNode root) {
        if (root == null) return 0;
        int leftDiameter = findDiameter1(root.left);
        int rightDiameter = findDiameter1(root.right);
        if (leftDiameter + rightDiameter + 1 > d) {
            d = leftDiameter + rightDiameter + 1;
        }

        if (leftDiameter > rightDiameter) return (leftDiameter + 1);
        else return (rightDiameter + 1);
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
        System.out.println(findDiameter(root));
        findDiameter1(root);
        System.out.println(d);
    }
}
