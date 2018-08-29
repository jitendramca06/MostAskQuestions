package com.mostaskquestions.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class TreeInVerticalOrder {
    private static void printInVerticalOrder(TreeNode root) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        printInVerticalOrderRec(treeMap, root, 0);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }
    }

    private static void printInVerticalOrderRec(TreeMap<Integer, String> treeMap, TreeNode root, int level) {
        if (root == null) return;
        if (treeMap.containsKey(level)) {
            treeMap.put(level, treeMap.get(level) + ", " + root.data);
        } else {
            treeMap.put(level, root.data + "");
        }
        printInVerticalOrderRec(treeMap, root.left, level - 1);
        printInVerticalOrderRec(treeMap, root.right, level + 1);
     }

    private static void printInVerticalOrderIte(TreeMap<Integer, String> treeMap, VOrderNode root) {
        if (root == null) return;
        Queue<VOrderNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            VOrderNode node = queue.poll();
            if (treeMap.containsKey(node.level)) {
                treeMap.put(node.level, treeMap.get(node.level) + ", " + node.data);
            } else {
                treeMap.put(node.level, node.data + "");
            }

            if (node.left != null) {
                node.left.level = node.level - 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                queue.add(node.right);
            }
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
        printInVerticalOrder(root);

        /**
         * Iteration
         */
        VOrderNode head = new VOrderNode(50);
        head.left = new VOrderNode(30);
        head.right = new VOrderNode(70);
        head.left.left = new VOrderNode(20);
        head.left.right = new VOrderNode(40);
        head.right.left = new VOrderNode(60);
        head.right.right = new VOrderNode(80);
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        printInVerticalOrderIte(treeMap, head);
        System.out.println();
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }
    }
}

class VOrderNode{
    int data;
    VOrderNode left;
    VOrderNode right;
    int level;

    VOrderNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.level = 0;
    }
}
