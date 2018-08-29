package com.mostaskquestions.tree;

/**
 * @author Jitendra Kumar : 29/8/18
 */
public class KThSmallestLargest {
    private static int count;
    private static TreeNode getKthSmallest(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode node = getKthSmallest(root.left, k);
        //If counter is not equal to K, then only increment the counter.
        //Once counter is equal to K, it means we have found the desired smallest element and no need to increment further,
        //Take the back up of the current node as it might be the Kth smallest element we are looking for. 
        if (count != k) {
            count++;
            node = root;
        }
        //This is the place where actual check is going to happen between counter and K,
        //If counter matched K, it means we found the node and no need to find further so simply return the found node.
        if (count == k) {
            return node;
        } else return getKthSmallest(root.right, k);
    }

    private static TreeNode getKthHighest(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode node = getKthHighest(root.right, k);
        if (count != k) {
            count++;
            node = root;
        }
        if (count == k) return node;
        else return getKthHighest(root.left, k);
    }

    private static int getKthHighest1(TreeNode root, int k) {
        if (root == null) return -1;
        int rightCount = getCount(root.right);
        if (rightCount +1 == k) return root.data;
        else if (rightCount +1 >= k) return getKthHighest1(root.right, k);
        else return getKthHighest1(root.left, k - (rightCount + 1));
    }

    private static int getKthSmallest1(TreeNode root, int k) {
        if (root == null) return -1;
        int countLeft = getCount(root.left);
        if (countLeft +1 == k) return root.data;
        else if (countLeft + 1 >= k) return getKthSmallest1(root.left, k);
        else return getKthSmallest1(root.right , k - (countLeft + 1));
    }

    private static int getCount(TreeNode node) {
        if (node == null) return 0;
        int leftCount = getCount(node.left);
        int rightCount = getCount(node.right);
        return (1 + leftCount + rightCount);
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
        TreeNode kThS = getKthSmallest(root, 3);
        if (kThS != null)
            System.out.println(kThS.data);
        System.out.println(getKthSmallest1(root, 3));
        count = 0;
        kThS = getKthHighest(root, 3);
        if (kThS != null)
            System.out.println(kThS.data);
        System.out.println(getKthHighest1(root, 3));
    }
}
